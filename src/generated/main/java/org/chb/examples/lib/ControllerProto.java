// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: controller.proto

package org.chb.examples.lib;

public final class ControllerProto {
  private ControllerProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestController_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RequestController_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResponseController_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseController_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020controller.proto\"1\n\021RequestController\022" +
      "\017\n\007address\030\001 \001(\t\022\013\n\003var\030\002 \001(\003\"%\n\022Respons" +
      "eController\022\017\n\007message\030\001 \001(\t2X\n\nControll" +
      "er\022J\n\031StreamingFitAndController\022\022.Reques" +
      "tController\032\023.ResponseController\"\000(\0010\001B)" +
      "\n\024org.chb.examples.libB\017ControllerProtoP" +
      "\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_RequestController_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RequestController_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RequestController_descriptor,
        new java.lang.String[] { "Address", "Var", });
    internal_static_ResponseController_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ResponseController_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResponseController_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
