package org.chb.examples.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: controller.proto")
public final class ControllerGrpc {

  private ControllerGrpc() {}

  public static final String SERVICE_NAME = "Controller";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.chb.examples.lib.RequestController,
      org.chb.examples.lib.ResponseController> getStreamingFitAndControllerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingFitAndController",
      requestType = org.chb.examples.lib.RequestController.class,
      responseType = org.chb.examples.lib.ResponseController.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.chb.examples.lib.RequestController,
      org.chb.examples.lib.ResponseController> getStreamingFitAndControllerMethod() {
    io.grpc.MethodDescriptor<org.chb.examples.lib.RequestController, org.chb.examples.lib.ResponseController> getStreamingFitAndControllerMethod;
    if ((getStreamingFitAndControllerMethod = ControllerGrpc.getStreamingFitAndControllerMethod) == null) {
      synchronized (ControllerGrpc.class) {
        if ((getStreamingFitAndControllerMethod = ControllerGrpc.getStreamingFitAndControllerMethod) == null) {
          ControllerGrpc.getStreamingFitAndControllerMethod = getStreamingFitAndControllerMethod =
              io.grpc.MethodDescriptor.<org.chb.examples.lib.RequestController, org.chb.examples.lib.ResponseController>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingFitAndController"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.RequestController.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.ResponseController.getDefaultInstance()))
              .setSchemaDescriptor(new ControllerMethodDescriptorSupplier("StreamingFitAndController"))
              .build();
        }
      }
    }
    return getStreamingFitAndControllerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getCheckConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckConnection",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getCheckConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getCheckConnectionMethod;
    if ((getCheckConnectionMethod = ControllerGrpc.getCheckConnectionMethod) == null) {
      synchronized (ControllerGrpc.class) {
        if ((getCheckConnectionMethod = ControllerGrpc.getCheckConnectionMethod) == null) {
          ControllerGrpc.getCheckConnectionMethod = getCheckConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ControllerMethodDescriptorSupplier("CheckConnection"))
              .build();
        }
      }
    }
    return getCheckConnectionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControllerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControllerStub>() {
        @java.lang.Override
        public ControllerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControllerStub(channel, callOptions);
        }
      };
    return ControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControllerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControllerBlockingStub>() {
        @java.lang.Override
        public ControllerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControllerBlockingStub(channel, callOptions);
        }
      };
    return ControllerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControllerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControllerFutureStub>() {
        @java.lang.Override
        public ControllerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControllerFutureStub(channel, callOptions);
        }
      };
    return ControllerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.chb.examples.lib.RequestController> streamingFitAndController(
        io.grpc.stub.StreamObserver<org.chb.examples.lib.ResponseController> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamingFitAndControllerMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.Empty> checkConnection(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCheckConnectionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamingFitAndControllerMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                org.chb.examples.lib.RequestController,
                org.chb.examples.lib.ResponseController>(
                  this, METHODID_STREAMING_FIT_AND_CONTROLLER)))
          .addMethod(
            getCheckConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.Empty>(
                  this, METHODID_CHECK_CONNECTION)))
          .build();
    }
  }

  /**
   */
  public static final class ControllerStub extends io.grpc.stub.AbstractAsyncStub<ControllerStub> {
    private ControllerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControllerStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.chb.examples.lib.RequestController> streamingFitAndController(
        io.grpc.stub.StreamObserver<org.chb.examples.lib.ResponseController> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingFitAndControllerMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.Empty> checkConnection(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCheckConnectionMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ControllerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ControllerBlockingStub> {
    private ControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControllerBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ControllerFutureStub extends io.grpc.stub.AbstractFutureStub<ControllerFutureStub> {
    private ControllerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControllerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAMING_FIT_AND_CONTROLLER = 0;
  private static final int METHODID_CHECK_CONNECTION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAMING_FIT_AND_CONTROLLER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingFitAndController(
              (io.grpc.stub.StreamObserver<org.chb.examples.lib.ResponseController>) responseObserver);
        case METHODID_CHECK_CONNECTION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.checkConnection(
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.chb.examples.lib.ControllerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Controller");
    }
  }

  private static final class ControllerFileDescriptorSupplier
      extends ControllerBaseDescriptorSupplier {
    ControllerFileDescriptorSupplier() {}
  }

  private static final class ControllerMethodDescriptorSupplier
      extends ControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControllerFileDescriptorSupplier())
              .addMethod(getStreamingFitAndControllerMethod())
              .addMethod(getCheckConnectionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
