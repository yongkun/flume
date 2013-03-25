/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.cloudera.flume.handlers.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum Priority implements org.apache.thrift.TEnum {
  FATAL(0),
  ERROR(1),
  WARN(2),
  INFO(3),
  DEBUG(4),
  TRACE(5);

  private final int value;

  private Priority(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Priority findByValue(int value) { 
    switch (value) {
      case 0:
        return FATAL;
      case 1:
        return ERROR;
      case 2:
        return WARN;
      case 3:
        return INFO;
      case 4:
        return DEBUG;
      case 5:
        return TRACE;
      default:
        return null;
    }
  }
}
