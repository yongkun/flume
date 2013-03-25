/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.flume.handlers.hdfs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.Compressor;
import org.apache.hadoop.io.compress.GzipCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudera.flume.conf.Context;
import com.cloudera.flume.conf.FlumeConfiguration;
import com.cloudera.flume.conf.FlumeSpecException;
import com.cloudera.flume.conf.SinkFactory.SinkBuilder;
import com.cloudera.flume.core.Event;
import com.cloudera.flume.core.EventSink;
import com.cloudera.flume.handlers.text.FormatFactory;
import com.cloudera.flume.handlers.text.output.OutputFormat;
import com.cloudera.flume.reporter.ReportEvent;
import com.google.common.base.Preconditions;

/**
 * This creates a raw hadoop dfs file that outputs data formatted by the
 * provided OutputFormat. It is assumed that the output is a file of some sort.
 */
public class CustomDfsSink extends EventSink.Base {
  static final Logger LOG = LoggerFactory.getLogger(CustomDfsSink.class);

  private static final String A_OUTPUTFORMAT = "recordformat";

  boolean compressOutput;
  OutputFormat format;
  OutputStream writer;
  AtomicLong count = new AtomicLong();
  String path;
  Path dstPath;
  FileStatus fStats;
  long bytesWritten = 0;
  //long hdfsFileSize = 0;
  private boolean appendEnabled = FlumeConfiguration.get().getDfsAppendEnabled();

  public CustomDfsSink(String path, OutputFormat format) {
    Preconditions.checkArgument(path != null);
    Preconditions.checkArgument(format != null);
    this.path = path;
    this.format = format;
    this.writer = null;
  }

  @Override
  public void append(Event e) throws IOException, InterruptedException {
    if (writer == null) {
    	LOG.info("HDFS file has been closed. Reopen it.");
    	open();
      //throw new IOException("Append failed, did you open the writer?");
    }

    format.format(writer, e);
    count.getAndIncrement();
    //TODO: should consider dump format (raw, json ...)
    this.bytesWritten += e.getBody().length;
    super.append(e);
  }

  @Override
  public void close() throws IOException {
	  if ( writer != null ) {
	    LOG.info("Closing HDFS file: " + dstPath);
	    writer.flush();
	    LOG.info("done writing raw file to hdfs");
	    writer.close();
	    writer = null;
	  }
    //this.hdfsFileSize = fStats.getLen();
  }
  
  /**
   * Hadoop Compression Codecs that use Native libs require
   * an instance of a Configuration Object. They require this
   * due to some check against knowing weather or not the native libs 
   * have been loaded. GzipCodec, LzoCodec, LzopCodec are all codecs that
   * require Native libs. GZipCodec has a slight exception that if native libs
   * are not accessible it will use Pure Java. This results in no errors just
   * notices. BZip2Codec is an example codec that doesn't use native libs.
   */
  @Override
  public void open() throws IOException {
    FlumeConfiguration conf = FlumeConfiguration.get();
    FileSystem hdfs;

    // use v0.9.1 compression settings
    if (conf.getCollectorDfsCompressGzipStatus()) {
      LOG.warn("Config property "
          + FlumeConfiguration.COLLECTOR_DFS_COMPRESS_GZIP
          + " is deprecated, please use "
          + FlumeConfiguration.COLLECTOR_DFS_COMPRESS_CODEC
          + " set to GzipCodec instead");
      CompressionCodec gzipC = new GzipCodec();
      
      //See Below for comments on this
      if(gzipC instanceof Configurable){
        ((Configurable)gzipC).setConf(conf);
      }
      Compressor gzCmp = gzipC.createCompressor();
      dstPath = new Path(path + gzipC.getDefaultExtension());
      hdfs = dstPath.getFileSystem(conf);
      
      writer = getHDFSWriter(hdfs, dstPath);
  		 	  
      writer = gzipC.createOutputStream(writer, gzCmp);
      LOG.info("Opening HDFS gzip compressed file: " + dstPath.toString());
      return;
    }

    String codecName = conf.getCollectorDfsCompressCodec();
    List<Class<? extends CompressionCodec>> codecs = CompressionCodecFactory
        .getCodecClasses(FlumeConfiguration.get());
    //Wish we could base this on DefaultCodec but appears not all codec's extend DefaultCodec(Lzo)
    CompressionCodec codec = null;
    ArrayList<String> codecStrs = new ArrayList<String>();
    codecStrs.add("None");
    for (Class<? extends CompressionCodec> cls : codecs) {
      codecStrs.add(cls.getSimpleName());

      if (cls.getSimpleName().equals(codecName)) {
        try {
          codec = cls.newInstance();
        } catch (InstantiationException e) {
          LOG.error("Unable to instantiate " + codec + " class");
        } catch (IllegalAccessException e) {
          LOG.error("Unable to access " + codec + " class");
        }
      }
    }

    if (codec == null) {
      if (!codecName.equals("None")) {
        LOG.warn("Unsupported compression codec " + codecName
            + ".  Please choose from: " + codecStrs);
      }
      dstPath = new Path(path);
      hdfs = dstPath.getFileSystem(conf);
      
      writer = getHDFSWriter(hdfs, dstPath);
  		   
      LOG.info("Opening HDFS file: " + dstPath.toString());
      return;
    }
    //Must check instanceof codec as BZip2Codec doesn't inherit Configurable
    if(codec instanceof Configurable){
      //Must set the configuration for Configurable objects that may or do use native libs
      ((Configurable)codec).setConf(conf);
    }
    //debug
    //codec = new GzipCodec();
    
    Compressor cmp = codec.createCompressor();
    dstPath = new Path(path + codec.getDefaultExtension());
    hdfs = dstPath.getFileSystem(conf);
    
    writer = getHDFSWriter(hdfs, dstPath);
		  
    try {
      writer = codec.createOutputStream(writer, cmp);
    } catch (NullPointerException npe) {
      // tries to find "native" version of codec, if that fails, then tries to
      // find java version. If there is no java version, the createOutputStream
      // exits via NPE. We capture this and convert it into a IOE with a more
      // useful error message.
      LOG.error("Unable to load compression codec " + codec);
      throw new IOException("Unable to load compression codec " + codec);
    }
    LOG.info("Opening " + codec + " compressed HDFS file: "
        + dstPath.toString());
  }
  
  private OutputStream getHDFSWriter(FileSystem hdfs, Path dstPath) throws IOException {
	  OutputStream writer = null;
	  if ( appendEnabled ) {
		  if ( ! hdfs.isFile(dstPath) ) {
		    writer = hdfs.create(dstPath);
		    writer.close();
		  }		  
		  //this.fStats = hdfs.getFileStatus(dstPath);	  
		  //this.hdfsFileSize = fStats.getLen();
		  writer = hdfs.append(dstPath);
	  } else {
		  writer = hdfs.create(dstPath);
	  }
	  return writer;
  }

  public long getBytesWritten() {
    return this.bytesWritten;
  }  

//  public long getHDFSFileLength() {
//	  return this.hdfsFileSize;
//  }
//
//  public long getLatestHDFSFileLength() {
//    if ( this.fStats == null )
//      LOG.warn("== fStats is not initialized.");
//	  return this.fStats == null ? 0 : this.fStats.getLen();
//  }

  public long getEventCount() {
    return this.count.get();
  }

  public static SinkBuilder builder() {
    return new SinkBuilder() {
      @Override
      public EventSink build(Context context, String... args) {
        if (args.length != 2 && args.length != 1) {
          // TODO (jon) make this message easier.
          throw new IllegalArgumentException(
              "usage: customdfs(\"[(hdfs|file|s3n|...)://namenode[:port]]/path\", \"format\")");
        }

        String format = (args.length == 1) ? null : args[1];
        OutputFormat fmt;
        try {
          fmt = FormatFactory.get().getOutputFormat(format);
        } catch (FlumeSpecException e) {
          LOG.error("failed to load format " + format, e);
          throw new IllegalArgumentException("failed to load format " + format);
        }
        return new CustomDfsSink(args[0], fmt);
      }
    };
  }

  @Override
  public String getName() {
    return "CustomDfs";
  }

  @Override
  public ReportEvent getMetrics() {
    ReportEvent rpt = super.getMetrics();
    rpt.setStringMetric(A_OUTPUTFORMAT, format.getBuilder().getName());
    rpt.setLongMetric(ReportEvent.A_COUNT, count.get());
    return rpt;
  }

  @Deprecated
  @Override
  public ReportEvent getReport() {
    ReportEvent rpt = super.getReport();
    rpt.setStringMetric(A_OUTPUTFORMAT, format.getBuilder().getName());
    rpt.setLongMetric(ReportEvent.A_COUNT, count.get());
    return rpt;
  }
}
