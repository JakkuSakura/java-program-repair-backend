// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.bytecamp.program_repair.backend.grpc;

public final class RepairServerProto {
  private RepairServerProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RepairTaskRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RepairTaskRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RepairTaskResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RepairTaskResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RepairTaskResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RepairTaskResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RepairTaskResult_Patch_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RepairTaskResult_Patch_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rservice.proto\"\244\001\n\021RepairTaskRequest\0226\n" +
      "\rlocation_type\030\001 \001(\0162\037.RepairTaskRequest" +
      ".LocationType\022\020\n\010location\030\002 \001(\t\022\017\n\007proje" +
      "ct\030\003 \001(\t\022\021\n\talgorithm\030\004 \001(\t\"!\n\014LocationT" +
      "ype\022\010\n\004PATH\020\000\022\007\n\003GIT\020\001\"\240\001\n\022RepairTaskRes" +
      "ponse\0221\n\nframe_type\030\001 \001(\0162\035.RepairTaskRe" +
      "sponse.FrameType\022\017\n\007message\030\002 \001(\t\022!\n\006res" +
      "ult\030\003 \003(\0132\021.RepairTaskResult\"#\n\tFrameTyp" +
      "e\022\n\n\006STDOUT\020\000\022\n\n\006RESULT\020\001\"{\n\020RepairTaskR" +
      "esult\022\017\n\007success\030\001 \001(\010\022&\n\005patch\030\003 \003(\0132\027." +
      "RepairTaskResult.Patch\032.\n\005Patch\022\020\n\010modif" +
      "ied\030\002 \001(\t\022\023\n\013source_path\030\003 \001(\t2I\n\014Repair" +
      "Server\0229\n\nSubmitTask\022\022.RepairTaskRequest" +
      "\032\023.RepairTaskResponse\"\0000\001B?\n(org.bytecam" +
      "p.program_repair.backend.grpcB\021RepairSer" +
      "verProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_RepairTaskRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RepairTaskRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RepairTaskRequest_descriptor,
        new java.lang.String[] { "LocationType", "Location", "Project", "Algorithm", });
    internal_static_RepairTaskResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_RepairTaskResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RepairTaskResponse_descriptor,
        new java.lang.String[] { "FrameType", "Message", "Result", });
    internal_static_RepairTaskResult_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_RepairTaskResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RepairTaskResult_descriptor,
        new java.lang.String[] { "Success", "Patch", });
    internal_static_RepairTaskResult_Patch_descriptor =
      internal_static_RepairTaskResult_descriptor.getNestedTypes().get(0);
    internal_static_RepairTaskResult_Patch_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RepairTaskResult_Patch_descriptor,
        new java.lang.String[] { "Modified", "SourcePath", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
