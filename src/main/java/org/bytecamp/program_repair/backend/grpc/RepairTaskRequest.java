// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.bytecamp.program_repair.backend.grpc;

/**
 * Protobuf type {@code RepairTaskRequest}
 */
public final class RepairTaskRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:RepairTaskRequest)
    RepairTaskRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RepairTaskRequest.newBuilder() to construct.
  private RepairTaskRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RepairTaskRequest() {
    locationType_ = 0;
    location_ = "";
    project_ = "";
    algorithm_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RepairTaskRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RepairTaskRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            locationType_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            location_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            project_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            algorithm_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.bytecamp.program_repair.backend.grpc.RepairServerProto.internal_static_RepairTaskRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.bytecamp.program_repair.backend.grpc.RepairServerProto.internal_static_RepairTaskRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.class, org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.Builder.class);
  }

  /**
   * Protobuf enum {@code RepairTaskRequest.LocationType}
   */
  public enum LocationType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>PATH = 0;</code>
     */
    PATH(0),
    /**
     * <code>GIT = 1;</code>
     */
    GIT(1),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>PATH = 0;</code>
     */
    public static final int PATH_VALUE = 0;
    /**
     * <code>GIT = 1;</code>
     */
    public static final int GIT_VALUE = 1;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static LocationType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static LocationType forNumber(int value) {
      switch (value) {
        case 0: return PATH;
        case 1: return GIT;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<LocationType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        LocationType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<LocationType>() {
            public LocationType findValueByNumber(int number) {
              return LocationType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.getDescriptor().getEnumTypes().get(0);
    }

    private static final LocationType[] VALUES = values();

    public static LocationType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private LocationType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:RepairTaskRequest.LocationType)
  }

  public static final int LOCATION_TYPE_FIELD_NUMBER = 1;
  private int locationType_;
  /**
   * <code>.RepairTaskRequest.LocationType location_type = 1;</code>
   * @return The enum numeric value on the wire for locationType.
   */
  @java.lang.Override public int getLocationTypeValue() {
    return locationType_;
  }
  /**
   * <code>.RepairTaskRequest.LocationType location_type = 1;</code>
   * @return The locationType.
   */
  @java.lang.Override public org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType getLocationType() {
    @SuppressWarnings("deprecation")
    org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType result = org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType.valueOf(locationType_);
    return result == null ? org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType.UNRECOGNIZED : result;
  }

  public static final int LOCATION_FIELD_NUMBER = 2;
  private volatile java.lang.Object location_;
  /**
   * <code>string location = 2;</code>
   * @return The location.
   */
  @java.lang.Override
  public java.lang.String getLocation() {
    java.lang.Object ref = location_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      location_ = s;
      return s;
    }
  }
  /**
   * <code>string location = 2;</code>
   * @return The bytes for location.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getLocationBytes() {
    java.lang.Object ref = location_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      location_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PROJECT_FIELD_NUMBER = 3;
  private volatile java.lang.Object project_;
  /**
   * <code>string project = 3;</code>
   * @return The project.
   */
  @java.lang.Override
  public java.lang.String getProject() {
    java.lang.Object ref = project_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      project_ = s;
      return s;
    }
  }
  /**
   * <code>string project = 3;</code>
   * @return The bytes for project.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getProjectBytes() {
    java.lang.Object ref = project_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      project_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ALGORITHM_FIELD_NUMBER = 4;
  private volatile java.lang.Object algorithm_;
  /**
   * <code>string algorithm = 4;</code>
   * @return The algorithm.
   */
  @java.lang.Override
  public java.lang.String getAlgorithm() {
    java.lang.Object ref = algorithm_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      algorithm_ = s;
      return s;
    }
  }
  /**
   * <code>string algorithm = 4;</code>
   * @return The bytes for algorithm.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAlgorithmBytes() {
    java.lang.Object ref = algorithm_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      algorithm_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (locationType_ != org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType.PATH.getNumber()) {
      output.writeEnum(1, locationType_);
    }
    if (!getLocationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, location_);
    }
    if (!getProjectBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, project_);
    }
    if (!getAlgorithmBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, algorithm_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (locationType_ != org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType.PATH.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, locationType_);
    }
    if (!getLocationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, location_);
    }
    if (!getProjectBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, project_);
    }
    if (!getAlgorithmBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, algorithm_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.bytecamp.program_repair.backend.grpc.RepairTaskRequest)) {
      return super.equals(obj);
    }
    org.bytecamp.program_repair.backend.grpc.RepairTaskRequest other = (org.bytecamp.program_repair.backend.grpc.RepairTaskRequest) obj;

    if (locationType_ != other.locationType_) return false;
    if (!getLocation()
        .equals(other.getLocation())) return false;
    if (!getProject()
        .equals(other.getProject())) return false;
    if (!getAlgorithm()
        .equals(other.getAlgorithm())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LOCATION_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + locationType_;
    hash = (37 * hash) + LOCATION_FIELD_NUMBER;
    hash = (53 * hash) + getLocation().hashCode();
    hash = (37 * hash) + PROJECT_FIELD_NUMBER;
    hash = (53 * hash) + getProject().hashCode();
    hash = (37 * hash) + ALGORITHM_FIELD_NUMBER;
    hash = (53 * hash) + getAlgorithm().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.bytecamp.program_repair.backend.grpc.RepairTaskRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code RepairTaskRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:RepairTaskRequest)
      org.bytecamp.program_repair.backend.grpc.RepairTaskRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.bytecamp.program_repair.backend.grpc.RepairServerProto.internal_static_RepairTaskRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.bytecamp.program_repair.backend.grpc.RepairServerProto.internal_static_RepairTaskRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.class, org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.Builder.class);
    }

    // Construct using org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      locationType_ = 0;

      location_ = "";

      project_ = "";

      algorithm_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.bytecamp.program_repair.backend.grpc.RepairServerProto.internal_static_RepairTaskRequest_descriptor;
    }

    @java.lang.Override
    public org.bytecamp.program_repair.backend.grpc.RepairTaskRequest getDefaultInstanceForType() {
      return org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.bytecamp.program_repair.backend.grpc.RepairTaskRequest build() {
      org.bytecamp.program_repair.backend.grpc.RepairTaskRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.bytecamp.program_repair.backend.grpc.RepairTaskRequest buildPartial() {
      org.bytecamp.program_repair.backend.grpc.RepairTaskRequest result = new org.bytecamp.program_repair.backend.grpc.RepairTaskRequest(this);
      result.locationType_ = locationType_;
      result.location_ = location_;
      result.project_ = project_;
      result.algorithm_ = algorithm_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.bytecamp.program_repair.backend.grpc.RepairTaskRequest) {
        return mergeFrom((org.bytecamp.program_repair.backend.grpc.RepairTaskRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.bytecamp.program_repair.backend.grpc.RepairTaskRequest other) {
      if (other == org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.getDefaultInstance()) return this;
      if (other.locationType_ != 0) {
        setLocationTypeValue(other.getLocationTypeValue());
      }
      if (!other.getLocation().isEmpty()) {
        location_ = other.location_;
        onChanged();
      }
      if (!other.getProject().isEmpty()) {
        project_ = other.project_;
        onChanged();
      }
      if (!other.getAlgorithm().isEmpty()) {
        algorithm_ = other.algorithm_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.bytecamp.program_repair.backend.grpc.RepairTaskRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.bytecamp.program_repair.backend.grpc.RepairTaskRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int locationType_ = 0;
    /**
     * <code>.RepairTaskRequest.LocationType location_type = 1;</code>
     * @return The enum numeric value on the wire for locationType.
     */
    @java.lang.Override public int getLocationTypeValue() {
      return locationType_;
    }
    /**
     * <code>.RepairTaskRequest.LocationType location_type = 1;</code>
     * @param value The enum numeric value on the wire for locationType to set.
     * @return This builder for chaining.
     */
    public Builder setLocationTypeValue(int value) {
      
      locationType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.RepairTaskRequest.LocationType location_type = 1;</code>
     * @return The locationType.
     */
    @java.lang.Override
    public org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType getLocationType() {
      @SuppressWarnings("deprecation")
      org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType result = org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType.valueOf(locationType_);
      return result == null ? org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType.UNRECOGNIZED : result;
    }
    /**
     * <code>.RepairTaskRequest.LocationType location_type = 1;</code>
     * @param value The locationType to set.
     * @return This builder for chaining.
     */
    public Builder setLocationType(org.bytecamp.program_repair.backend.grpc.RepairTaskRequest.LocationType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      locationType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.RepairTaskRequest.LocationType location_type = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearLocationType() {
      
      locationType_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object location_ = "";
    /**
     * <code>string location = 2;</code>
     * @return The location.
     */
    public java.lang.String getLocation() {
      java.lang.Object ref = location_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        location_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string location = 2;</code>
     * @return The bytes for location.
     */
    public com.google.protobuf.ByteString
        getLocationBytes() {
      java.lang.Object ref = location_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        location_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string location = 2;</code>
     * @param value The location to set.
     * @return This builder for chaining.
     */
    public Builder setLocation(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      location_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string location = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLocation() {
      
      location_ = getDefaultInstance().getLocation();
      onChanged();
      return this;
    }
    /**
     * <code>string location = 2;</code>
     * @param value The bytes for location to set.
     * @return This builder for chaining.
     */
    public Builder setLocationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      location_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object project_ = "";
    /**
     * <code>string project = 3;</code>
     * @return The project.
     */
    public java.lang.String getProject() {
      java.lang.Object ref = project_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        project_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string project = 3;</code>
     * @return The bytes for project.
     */
    public com.google.protobuf.ByteString
        getProjectBytes() {
      java.lang.Object ref = project_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        project_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string project = 3;</code>
     * @param value The project to set.
     * @return This builder for chaining.
     */
    public Builder setProject(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      project_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string project = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearProject() {
      
      project_ = getDefaultInstance().getProject();
      onChanged();
      return this;
    }
    /**
     * <code>string project = 3;</code>
     * @param value The bytes for project to set.
     * @return This builder for chaining.
     */
    public Builder setProjectBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      project_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object algorithm_ = "";
    /**
     * <code>string algorithm = 4;</code>
     * @return The algorithm.
     */
    public java.lang.String getAlgorithm() {
      java.lang.Object ref = algorithm_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        algorithm_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string algorithm = 4;</code>
     * @return The bytes for algorithm.
     */
    public com.google.protobuf.ByteString
        getAlgorithmBytes() {
      java.lang.Object ref = algorithm_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        algorithm_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string algorithm = 4;</code>
     * @param value The algorithm to set.
     * @return This builder for chaining.
     */
    public Builder setAlgorithm(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      algorithm_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string algorithm = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearAlgorithm() {
      
      algorithm_ = getDefaultInstance().getAlgorithm();
      onChanged();
      return this;
    }
    /**
     * <code>string algorithm = 4;</code>
     * @param value The bytes for algorithm to set.
     * @return This builder for chaining.
     */
    public Builder setAlgorithmBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      algorithm_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:RepairTaskRequest)
  }

  // @@protoc_insertion_point(class_scope:RepairTaskRequest)
  private static final org.bytecamp.program_repair.backend.grpc.RepairTaskRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.bytecamp.program_repair.backend.grpc.RepairTaskRequest();
  }

  public static org.bytecamp.program_repair.backend.grpc.RepairTaskRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RepairTaskRequest>
      PARSER = new com.google.protobuf.AbstractParser<RepairTaskRequest>() {
    @java.lang.Override
    public RepairTaskRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RepairTaskRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RepairTaskRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RepairTaskRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.bytecamp.program_repair.backend.grpc.RepairTaskRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

