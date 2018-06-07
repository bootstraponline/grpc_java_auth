// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: echo.proto

package com.instructure.soseedy;

/**
 * Protobuf type {@code echo.EchoRequest}
 */
public  final class EchoRequest extends
    com.google.protobuf.GeneratedMessageLite<
        EchoRequest, EchoRequest.Builder> implements
    // @@protoc_insertion_point(message_implements:echo.EchoRequest)
    EchoRequestOrBuilder {
  private EchoRequest() {
    text_ = "";
  }
  public static final int TEXT_FIELD_NUMBER = 1;
  private java.lang.String text_;
  /**
   * <pre>
   * The text of a message to be echoed.
   * </pre>
   *
   * <code>optional string text = 1;</code>
   */
  public java.lang.String getText() {
    return text_;
  }
  /**
   * <pre>
   * The text of a message to be echoed.
   * </pre>
   *
   * <code>optional string text = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTextBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(text_);
  }
  /**
   * <pre>
   * The text of a message to be echoed.
   * </pre>
   *
   * <code>optional string text = 1;</code>
   */
  private void setText(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    text_ = value;
  }
  /**
   * <pre>
   * The text of a message to be echoed.
   * </pre>
   *
   * <code>optional string text = 1;</code>
   */
  private void clearText() {
    
    text_ = getDefaultInstance().getText();
  }
  /**
   * <pre>
   * The text of a message to be echoed.
   * </pre>
   *
   * <code>optional string text = 1;</code>
   */
  private void setTextBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    text_ = value.toStringUtf8();
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!text_.isEmpty()) {
      output.writeString(1, getText());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (!text_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeStringSize(1, getText());
    }
    memoizedSerializedSize = size;
    return size;
  }

  public static com.instructure.soseedy.EchoRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.instructure.soseedy.EchoRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.instructure.soseedy.EchoRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static com.instructure.soseedy.EchoRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static com.instructure.soseedy.EchoRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.instructure.soseedy.EchoRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.instructure.soseedy.EchoRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static com.instructure.soseedy.EchoRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static com.instructure.soseedy.EchoRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static com.instructure.soseedy.EchoRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.instructure.soseedy.EchoRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * Protobuf type {@code echo.EchoRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        com.instructure.soseedy.EchoRequest, Builder> implements
      // @@protoc_insertion_point(builder_implements:echo.EchoRequest)
      com.instructure.soseedy.EchoRequestOrBuilder {
    // Construct using com.instructure.soseedy.EchoRequest.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * The text of a message to be echoed.
     * </pre>
     *
     * <code>optional string text = 1;</code>
     */
    public java.lang.String getText() {
      return instance.getText();
    }
    /**
     * <pre>
     * The text of a message to be echoed.
     * </pre>
     *
     * <code>optional string text = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTextBytes() {
      return instance.getTextBytes();
    }
    /**
     * <pre>
     * The text of a message to be echoed.
     * </pre>
     *
     * <code>optional string text = 1;</code>
     */
    public Builder setText(
        java.lang.String value) {
      copyOnWrite();
      instance.setText(value);
      return this;
    }
    /**
     * <pre>
     * The text of a message to be echoed.
     * </pre>
     *
     * <code>optional string text = 1;</code>
     */
    public Builder clearText() {
      copyOnWrite();
      instance.clearText();
      return this;
    }
    /**
     * <pre>
     * The text of a message to be echoed.
     * </pre>
     *
     * <code>optional string text = 1;</code>
     */
    public Builder setTextBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setTextBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:echo.EchoRequest)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new com.instructure.soseedy.EchoRequest();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        com.instructure.soseedy.EchoRequest other = (com.instructure.soseedy.EchoRequest) arg1;
        text_ = visitor.visitString(!text_.isEmpty(), text_,
            !other.text_.isEmpty(), other.text_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!input.skipField(tag)) {
                  done = true;
                }
                break;
              }
              case 10: {
                String s = input.readStringRequireUtf8();

                text_ = s;
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (com.instructure.soseedy.EchoRequest.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:echo.EchoRequest)
  private static final com.instructure.soseedy.EchoRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new EchoRequest();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static com.instructure.soseedy.EchoRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<EchoRequest> PARSER;

  public static com.google.protobuf.Parser<EchoRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}
