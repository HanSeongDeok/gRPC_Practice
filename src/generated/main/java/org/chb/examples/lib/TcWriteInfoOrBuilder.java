// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fit2.proto

package org.chb.examples.lib;

public interface TcWriteInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:TcWriteInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 address = 1;</code>
   * @return The address.
   */
  int getAddress();

  /**
   * <code>bytes bytes = 2;</code>
   * @return The bytes.
   */
  com.google.protobuf.ByteString getBytes();

  /**
   * <code>string message = 3;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 3;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.WriteAddressAndByte write = 4;</code>
   * @return Whether the write field is set.
   */
  boolean hasWrite();
  /**
   * <code>.WriteAddressAndByte write = 4;</code>
   * @return The write.
   */
  org.chb.examples.lib.WriteAddressAndByte getWrite();
  /**
   * <code>.WriteAddressAndByte write = 4;</code>
   */
  org.chb.examples.lib.WriteAddressAndByteOrBuilder getWriteOrBuilder();
}
