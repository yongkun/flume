/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.cloudera.flume.handlers.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftFlumeEvent implements org.apache.thrift.TBase<ThriftFlumeEvent, ThriftFlumeEvent._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftFlumeEvent");

  private static final org.apache.thrift.protocol.TField TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamp", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField PRIORITY_FIELD_DESC = new org.apache.thrift.protocol.TField("priority", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField BODY_FIELD_DESC = new org.apache.thrift.protocol.TField("body", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField NANOS_FIELD_DESC = new org.apache.thrift.protocol.TField("nanos", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField FIELDS_FIELD_DESC = new org.apache.thrift.protocol.TField("fields", org.apache.thrift.protocol.TType.MAP, (short)6);
  private static final org.apache.thrift.protocol.TField HOST_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("hostList", org.apache.thrift.protocol.TType.LIST, (short)7);

  public long timestamp; // required
  /**
   * 
   * @see Priority
   */
  public Priority priority; // required
  public ByteBuffer body; // required
  public long nanos; // required
  public String host; // required
  public Map<String,ByteBuffer> fields; // required
  public List<String> hostList; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TIMESTAMP((short)1, "timestamp"),
    /**
     * 
     * @see Priority
     */
    PRIORITY((short)2, "priority"),
    BODY((short)3, "body"),
    NANOS((short)4, "nanos"),
    HOST((short)5, "host"),
    FIELDS((short)6, "fields"),
    HOST_LIST((short)7, "hostList");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TIMESTAMP
          return TIMESTAMP;
        case 2: // PRIORITY
          return PRIORITY;
        case 3: // BODY
          return BODY;
        case 4: // NANOS
          return NANOS;
        case 5: // HOST
          return HOST;
        case 6: // FIELDS
          return FIELDS;
        case 7: // HOST_LIST
          return HOST_LIST;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIMESTAMP_ISSET_ID = 0;
  private static final int __NANOS_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("timestamp", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "Timestamp")));
    tmpMap.put(_Fields.PRIORITY, new org.apache.thrift.meta_data.FieldMetaData("priority", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Priority.class)));
    tmpMap.put(_Fields.BODY, new org.apache.thrift.meta_data.FieldMetaData("body", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.NANOS, new org.apache.thrift.meta_data.FieldMetaData("nanos", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FIELDS, new org.apache.thrift.meta_data.FieldMetaData("fields", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    tmpMap.put(_Fields.HOST_LIST, new org.apache.thrift.meta_data.FieldMetaData("hostList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftFlumeEvent.class, metaDataMap);
  }

  public ThriftFlumeEvent() {
  }

  public ThriftFlumeEvent(
    long timestamp,
    Priority priority,
    ByteBuffer body,
    long nanos,
    String host,
    Map<String,ByteBuffer> fields,
    List<String> hostList)
  {
    this();
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    this.priority = priority;
    this.body = body;
    this.nanos = nanos;
    setNanosIsSet(true);
    this.host = host;
    this.fields = fields;
    this.hostList = hostList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftFlumeEvent(ThriftFlumeEvent other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.timestamp = other.timestamp;
    if (other.isSetPriority()) {
      this.priority = other.priority;
    }
    if (other.isSetBody()) {
      this.body = org.apache.thrift.TBaseHelper.copyBinary(other.body);
;
    }
    this.nanos = other.nanos;
    if (other.isSetHost()) {
      this.host = other.host;
    }
    if (other.isSetFields()) {
      Map<String,ByteBuffer> __this__fields = new HashMap<String,ByteBuffer>();
      for (Map.Entry<String, ByteBuffer> other_element : other.fields.entrySet()) {

        String other_element_key = other_element.getKey();
        ByteBuffer other_element_value = other_element.getValue();

        String __this__fields_copy_key = other_element_key;

        ByteBuffer __this__fields_copy_value = org.apache.thrift.TBaseHelper.copyBinary(other_element_value);
;

        __this__fields.put(__this__fields_copy_key, __this__fields_copy_value);
      }
      this.fields = __this__fields;
    }
    if (other.isSetHostList()) {
      List<String> __this__hostList = new ArrayList<String>();
      for (String other_element : other.hostList) {
        __this__hostList.add(other_element);
      }
      this.hostList = __this__hostList;
    }
  }

  public ThriftFlumeEvent deepCopy() {
    return new ThriftFlumeEvent(this);
  }

  @Override
  public void clear() {
    setTimestampIsSet(false);
    this.timestamp = 0;
    this.priority = null;
    this.body = null;
    setNanosIsSet(false);
    this.nanos = 0;
    this.host = null;
    this.fields = null;
    this.hostList = null;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public ThriftFlumeEvent setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bit_vector.clear(__TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return __isset_bit_vector.get(__TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bit_vector.set(__TIMESTAMP_ISSET_ID, value);
  }

  /**
   * 
   * @see Priority
   */
  public Priority getPriority() {
    return this.priority;
  }

  /**
   * 
   * @see Priority
   */
  public ThriftFlumeEvent setPriority(Priority priority) {
    this.priority = priority;
    return this;
  }

  public void unsetPriority() {
    this.priority = null;
  }

  /** Returns true if field priority is set (has been assigned a value) and false otherwise */
  public boolean isSetPriority() {
    return this.priority != null;
  }

  public void setPriorityIsSet(boolean value) {
    if (!value) {
      this.priority = null;
    }
  }

  public byte[] getBody() {
    setBody(org.apache.thrift.TBaseHelper.rightSize(body));
    return body == null ? null : body.array();
  }

  public ByteBuffer bufferForBody() {
    return body;
  }

  public ThriftFlumeEvent setBody(byte[] body) {
    setBody(body == null ? (ByteBuffer)null : ByteBuffer.wrap(body));
    return this;
  }

  public ThriftFlumeEvent setBody(ByteBuffer body) {
    this.body = body;
    return this;
  }

  public void unsetBody() {
    this.body = null;
  }

  /** Returns true if field body is set (has been assigned a value) and false otherwise */
  public boolean isSetBody() {
    return this.body != null;
  }

  public void setBodyIsSet(boolean value) {
    if (!value) {
      this.body = null;
    }
  }

  public long getNanos() {
    return this.nanos;
  }

  public ThriftFlumeEvent setNanos(long nanos) {
    this.nanos = nanos;
    setNanosIsSet(true);
    return this;
  }

  public void unsetNanos() {
    __isset_bit_vector.clear(__NANOS_ISSET_ID);
  }

  /** Returns true if field nanos is set (has been assigned a value) and false otherwise */
  public boolean isSetNanos() {
    return __isset_bit_vector.get(__NANOS_ISSET_ID);
  }

  public void setNanosIsSet(boolean value) {
    __isset_bit_vector.set(__NANOS_ISSET_ID, value);
  }

  public String getHost() {
    return this.host;
  }

  public ThriftFlumeEvent setHost(String host) {
    this.host = host;
    return this;
  }

  public void unsetHost() {
    this.host = null;
  }

  /** Returns true if field host is set (has been assigned a value) and false otherwise */
  public boolean isSetHost() {
    return this.host != null;
  }

  public void setHostIsSet(boolean value) {
    if (!value) {
      this.host = null;
    }
  }

  public int getFieldsSize() {
    return (this.fields == null) ? 0 : this.fields.size();
  }

  public void putToFields(String key, ByteBuffer val) {
    if (this.fields == null) {
      this.fields = new HashMap<String,ByteBuffer>();
    }
    this.fields.put(key, val);
  }

  public Map<String,ByteBuffer> getFields() {
    return this.fields;
  }

  public ThriftFlumeEvent setFields(Map<String,ByteBuffer> fields) {
    this.fields = fields;
    return this;
  }

  public void unsetFields() {
    this.fields = null;
  }

  /** Returns true if field fields is set (has been assigned a value) and false otherwise */
  public boolean isSetFields() {
    return this.fields != null;
  }

  public void setFieldsIsSet(boolean value) {
    if (!value) {
      this.fields = null;
    }
  }

  public int getHostListSize() {
    return (this.hostList == null) ? 0 : this.hostList.size();
  }

  public java.util.Iterator<String> getHostListIterator() {
    return (this.hostList == null) ? null : this.hostList.iterator();
  }

  public void addToHostList(String elem) {
    if (this.hostList == null) {
      this.hostList = new ArrayList<String>();
    }
    this.hostList.add(elem);
  }

  public List<String> getHostList() {
    return this.hostList;
  }

  public ThriftFlumeEvent setHostList(List<String> hostList) {
    this.hostList = hostList;
    return this;
  }

  public void unsetHostList() {
    this.hostList = null;
  }

  /** Returns true if field hostList is set (has been assigned a value) and false otherwise */
  public boolean isSetHostList() {
    return this.hostList != null;
  }

  public void setHostListIsSet(boolean value) {
    if (!value) {
      this.hostList = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((Long)value);
      }
      break;

    case PRIORITY:
      if (value == null) {
        unsetPriority();
      } else {
        setPriority((Priority)value);
      }
      break;

    case BODY:
      if (value == null) {
        unsetBody();
      } else {
        setBody((ByteBuffer)value);
      }
      break;

    case NANOS:
      if (value == null) {
        unsetNanos();
      } else {
        setNanos((Long)value);
      }
      break;

    case HOST:
      if (value == null) {
        unsetHost();
      } else {
        setHost((String)value);
      }
      break;

    case FIELDS:
      if (value == null) {
        unsetFields();
      } else {
        setFields((Map<String,ByteBuffer>)value);
      }
      break;

    case HOST_LIST:
      if (value == null) {
        unsetHostList();
      } else {
        setHostList((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TIMESTAMP:
      return Long.valueOf(getTimestamp());

    case PRIORITY:
      return getPriority();

    case BODY:
      return getBody();

    case NANOS:
      return Long.valueOf(getNanos());

    case HOST:
      return getHost();

    case FIELDS:
      return getFields();

    case HOST_LIST:
      return getHostList();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TIMESTAMP:
      return isSetTimestamp();
    case PRIORITY:
      return isSetPriority();
    case BODY:
      return isSetBody();
    case NANOS:
      return isSetNanos();
    case HOST:
      return isSetHost();
    case FIELDS:
      return isSetFields();
    case HOST_LIST:
      return isSetHostList();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftFlumeEvent)
      return this.equals((ThriftFlumeEvent)that);
    return false;
  }

  public boolean equals(ThriftFlumeEvent that) {
    if (that == null)
      return false;

    boolean this_present_timestamp = true;
    boolean that_present_timestamp = true;
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_priority = true && this.isSetPriority();
    boolean that_present_priority = true && that.isSetPriority();
    if (this_present_priority || that_present_priority) {
      if (!(this_present_priority && that_present_priority))
        return false;
      if (!this.priority.equals(that.priority))
        return false;
    }

    boolean this_present_body = true && this.isSetBody();
    boolean that_present_body = true && that.isSetBody();
    if (this_present_body || that_present_body) {
      if (!(this_present_body && that_present_body))
        return false;
      if (!this.body.equals(that.body))
        return false;
    }

    boolean this_present_nanos = true;
    boolean that_present_nanos = true;
    if (this_present_nanos || that_present_nanos) {
      if (!(this_present_nanos && that_present_nanos))
        return false;
      if (this.nanos != that.nanos)
        return false;
    }

    boolean this_present_host = true && this.isSetHost();
    boolean that_present_host = true && that.isSetHost();
    if (this_present_host || that_present_host) {
      if (!(this_present_host && that_present_host))
        return false;
      if (!this.host.equals(that.host))
        return false;
    }

    boolean this_present_fields = true && this.isSetFields();
    boolean that_present_fields = true && that.isSetFields();
    if (this_present_fields || that_present_fields) {
      if (!(this_present_fields && that_present_fields))
        return false;
      if (!this.fields.equals(that.fields))
        return false;
    }

    boolean this_present_hostList = true && this.isSetHostList();
    boolean that_present_hostList = true && that.isSetHostList();
    if (this_present_hostList || that_present_hostList) {
      if (!(this_present_hostList && that_present_hostList))
        return false;
      if (!this.hostList.equals(that.hostList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ThriftFlumeEvent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftFlumeEvent typedOther = (ThriftFlumeEvent)other;

    lastComparison = Boolean.valueOf(isSetTimestamp()).compareTo(typedOther.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamp, typedOther.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPriority()).compareTo(typedOther.isSetPriority());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPriority()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.priority, typedOther.priority);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBody()).compareTo(typedOther.isSetBody());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBody()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.body, typedOther.body);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNanos()).compareTo(typedOther.isSetNanos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNanos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nanos, typedOther.nanos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHost()).compareTo(typedOther.isSetHost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, typedOther.host);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFields()).compareTo(typedOther.isSetFields());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFields()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fields, typedOther.fields);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHostList()).compareTo(typedOther.isSetHostList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHostList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hostList, typedOther.hostList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // TIMESTAMP
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.timestamp = iprot.readI64();
            setTimestampIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PRIORITY
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.priority = Priority.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // BODY
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.body = iprot.readBinary();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // NANOS
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.nanos = iprot.readI64();
            setNanosIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // HOST
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.host = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // FIELDS
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
              this.fields = new HashMap<String,ByteBuffer>(2*_map0.size);
              for (int _i1 = 0; _i1 < _map0.size; ++_i1)
              {
                String _key2; // required
                ByteBuffer _val3; // required
                _key2 = iprot.readString();
                _val3 = iprot.readBinary();
                this.fields.put(_key2, _val3);
              }
              iprot.readMapEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // HOST_LIST
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list4 = iprot.readListBegin();
              this.hostList = new ArrayList<String>(_list4.size);
              for (int _i5 = 0; _i5 < _list4.size; ++_i5)
              {
                String _elem6; // required
                _elem6 = iprot.readString();
                this.hostList.add(_elem6);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
    oprot.writeI64(this.timestamp);
    oprot.writeFieldEnd();
    if (this.priority != null) {
      oprot.writeFieldBegin(PRIORITY_FIELD_DESC);
      oprot.writeI32(this.priority.getValue());
      oprot.writeFieldEnd();
    }
    if (this.body != null) {
      oprot.writeFieldBegin(BODY_FIELD_DESC);
      oprot.writeBinary(this.body);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(NANOS_FIELD_DESC);
    oprot.writeI64(this.nanos);
    oprot.writeFieldEnd();
    if (this.host != null) {
      oprot.writeFieldBegin(HOST_FIELD_DESC);
      oprot.writeString(this.host);
      oprot.writeFieldEnd();
    }
    if (this.fields != null) {
      oprot.writeFieldBegin(FIELDS_FIELD_DESC);
      {
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, this.fields.size()));
        for (Map.Entry<String, ByteBuffer> _iter7 : this.fields.entrySet())
        {
          oprot.writeString(_iter7.getKey());
          oprot.writeBinary(_iter7.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.hostList != null) {
      oprot.writeFieldBegin(HOST_LIST_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, this.hostList.size()));
        for (String _iter8 : this.hostList)
        {
          oprot.writeString(_iter8);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftFlumeEvent(");
    boolean first = true;

    sb.append("timestamp:");
    sb.append(this.timestamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("priority:");
    if (this.priority == null) {
      sb.append("null");
    } else {
      sb.append(this.priority);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("body:");
    if (this.body == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.body, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("nanos:");
    sb.append(this.nanos);
    first = false;
    if (!first) sb.append(", ");
    sb.append("host:");
    if (this.host == null) {
      sb.append("null");
    } else {
      sb.append(this.host);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fields:");
    if (this.fields == null) {
      sb.append("null");
    } else {
      sb.append(this.fields);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hostList:");
    if (this.hostList == null) {
      sb.append("null");
    } else {
      sb.append(this.hostList);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

