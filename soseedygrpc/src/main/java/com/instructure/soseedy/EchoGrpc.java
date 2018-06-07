package com.instructure.soseedy;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: echo.proto")
public final class EchoGrpc {

  private EchoGrpc() {}

  public static final String SERVICE_NAME = "echo.Echo";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> METHOD_GET = getGetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getGetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getGetMethod() {
    return getGetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getGetMethodHelper() {
    io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse> getGetMethod;
    if ((getGetMethod = EchoGrpc.getGetMethod) == null) {
      synchronized (EchoGrpc.class) {
        if ((getGetMethod = EchoGrpc.getGetMethod) == null) {
          EchoGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "echo.Echo", "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EchoMethodDescriptorSupplier("Get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExpandMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> METHOD_EXPAND = getExpandMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getExpandMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getExpandMethod() {
    return getExpandMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getExpandMethodHelper() {
    io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse> getExpandMethod;
    if ((getExpandMethod = EchoGrpc.getExpandMethod) == null) {
      synchronized (EchoGrpc.class) {
        if ((getExpandMethod = EchoGrpc.getExpandMethod) == null) {
          EchoGrpc.getExpandMethod = getExpandMethod = 
              io.grpc.MethodDescriptor.<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "echo.Echo", "Expand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EchoMethodDescriptorSupplier("Expand"))
                  .build();
          }
        }
     }
     return getExpandMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCollectMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> METHOD_COLLECT = getCollectMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getCollectMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getCollectMethod() {
    return getCollectMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getCollectMethodHelper() {
    io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse> getCollectMethod;
    if ((getCollectMethod = EchoGrpc.getCollectMethod) == null) {
      synchronized (EchoGrpc.class) {
        if ((getCollectMethod = EchoGrpc.getCollectMethod) == null) {
          EchoGrpc.getCollectMethod = getCollectMethod = 
              io.grpc.MethodDescriptor.<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "echo.Echo", "Collect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EchoMethodDescriptorSupplier("Collect"))
                  .build();
          }
        }
     }
     return getCollectMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> METHOD_UPDATE = getUpdateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getUpdateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getUpdateMethod() {
    return getUpdateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest,
      com.instructure.soseedy.EchoResponse> getUpdateMethodHelper() {
    io.grpc.MethodDescriptor<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse> getUpdateMethod;
    if ((getUpdateMethod = EchoGrpc.getUpdateMethod) == null) {
      synchronized (EchoGrpc.class) {
        if ((getUpdateMethod = EchoGrpc.getUpdateMethod) == null) {
          EchoGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.instructure.soseedy.EchoRequest, com.instructure.soseedy.EchoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "echo.Echo", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.instructure.soseedy.EchoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EchoMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EchoStub newStub(io.grpc.Channel channel) {
    return new EchoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EchoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EchoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EchoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EchoFutureStub(channel);
  }

  /**
   */
  public static abstract class EchoImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Immediately returns an echo of a request.
     * </pre>
     */
    public void get(com.instructure.soseedy.EchoRequest request,
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Splits a request into words and returns each word in a stream of messages.
     * </pre>
     */
    public void expand(com.instructure.soseedy.EchoRequest request,
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getExpandMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Collects a stream of messages and returns them concatenated when the caller closes.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoRequest> collect(
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCollectMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Streams back messages as they are received in an input stream.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoRequest> update(
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.instructure.soseedy.EchoRequest,
                com.instructure.soseedy.EchoResponse>(
                  this, METHODID_GET)))
          .addMethod(
            getExpandMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.instructure.soseedy.EchoRequest,
                com.instructure.soseedy.EchoResponse>(
                  this, METHODID_EXPAND)))
          .addMethod(
            getCollectMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.instructure.soseedy.EchoRequest,
                com.instructure.soseedy.EchoResponse>(
                  this, METHODID_COLLECT)))
          .addMethod(
            getUpdateMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.instructure.soseedy.EchoRequest,
                com.instructure.soseedy.EchoResponse>(
                  this, METHODID_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class EchoStub extends io.grpc.stub.AbstractStub<EchoStub> {
    private EchoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoStub(channel, callOptions);
    }

    /**
     * <pre>
     * Immediately returns an echo of a request.
     * </pre>
     */
    public void get(com.instructure.soseedy.EchoRequest request,
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Splits a request into words and returns each word in a stream of messages.
     * </pre>
     */
    public void expand(com.instructure.soseedy.EchoRequest request,
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getExpandMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Collects a stream of messages and returns them concatenated when the caller closes.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoRequest> collect(
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCollectMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Streams back messages as they are received in an input stream.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoRequest> update(
        io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUpdateMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class EchoBlockingStub extends io.grpc.stub.AbstractStub<EchoBlockingStub> {
    private EchoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Immediately returns an echo of a request.
     * </pre>
     */
    public com.instructure.soseedy.EchoResponse get(com.instructure.soseedy.EchoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Splits a request into words and returns each word in a stream of messages.
     * </pre>
     */
    public java.util.Iterator<com.instructure.soseedy.EchoResponse> expand(
        com.instructure.soseedy.EchoRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getExpandMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EchoFutureStub extends io.grpc.stub.AbstractStub<EchoFutureStub> {
    private EchoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Immediately returns an echo of a request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.instructure.soseedy.EchoResponse> get(
        com.instructure.soseedy.EchoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_EXPAND = 1;
  private static final int METHODID_COLLECT = 2;
  private static final int METHODID_UPDATE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EchoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EchoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((com.instructure.soseedy.EchoRequest) request,
              (io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse>) responseObserver);
          break;
        case METHODID_EXPAND:
          serviceImpl.expand((com.instructure.soseedy.EchoRequest) request,
              (io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COLLECT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.collect(
              (io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse>) responseObserver);
        case METHODID_UPDATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.update(
              (io.grpc.stub.StreamObserver<com.instructure.soseedy.EchoResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EchoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EchoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.instructure.soseedy.EchoOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Echo");
    }
  }

  private static final class EchoFileDescriptorSupplier
      extends EchoBaseDescriptorSupplier {
    EchoFileDescriptorSupplier() {}
  }

  private static final class EchoMethodDescriptorSupplier
      extends EchoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EchoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EchoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EchoFileDescriptorSupplier())
              .addMethod(getGetMethodHelper())
              .addMethod(getExpandMethodHelper())
              .addMethod(getCollectMethodHelper())
              .addMethod(getUpdateMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
