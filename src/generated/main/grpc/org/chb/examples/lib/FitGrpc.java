package org.chb.examples.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: fit.proto")
public final class FitGrpc {

  private FitGrpc() {}

  public static final String SERVICE_NAME = "Fit";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.chb.examples.lib.RequestFit,
      org.chb.examples.lib.ResponseFit> getStreamingFitAndSimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingFitAndSim",
      requestType = org.chb.examples.lib.RequestFit.class,
      responseType = org.chb.examples.lib.ResponseFit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.chb.examples.lib.RequestFit,
      org.chb.examples.lib.ResponseFit> getStreamingFitAndSimMethod() {
    io.grpc.MethodDescriptor<org.chb.examples.lib.RequestFit, org.chb.examples.lib.ResponseFit> getStreamingFitAndSimMethod;
    if ((getStreamingFitAndSimMethod = FitGrpc.getStreamingFitAndSimMethod) == null) {
      synchronized (FitGrpc.class) {
        if ((getStreamingFitAndSimMethod = FitGrpc.getStreamingFitAndSimMethod) == null) {
          FitGrpc.getStreamingFitAndSimMethod = getStreamingFitAndSimMethod =
              io.grpc.MethodDescriptor.<org.chb.examples.lib.RequestFit, org.chb.examples.lib.ResponseFit>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingFitAndSim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.RequestFit.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.ResponseFit.getDefaultInstance()))
              .setSchemaDescriptor(new FitMethodDescriptorSupplier("StreamingFitAndSim"))
              .build();
        }
      }
    }
    return getStreamingFitAndSimMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FitStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FitStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FitStub>() {
        @java.lang.Override
        public FitStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FitStub(channel, callOptions);
        }
      };
    return FitStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FitBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FitBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FitBlockingStub>() {
        @java.lang.Override
        public FitBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FitBlockingStub(channel, callOptions);
        }
      };
    return FitBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FitFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FitFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FitFutureStub>() {
        @java.lang.Override
        public FitFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FitFutureStub(channel, callOptions);
        }
      };
    return FitFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FitImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.chb.examples.lib.RequestFit> streamingFitAndSim(
        io.grpc.stub.StreamObserver<org.chb.examples.lib.ResponseFit> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamingFitAndSimMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamingFitAndSimMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                org.chb.examples.lib.RequestFit,
                org.chb.examples.lib.ResponseFit>(
                  this, METHODID_STREAMING_FIT_AND_SIM)))
          .build();
    }
  }

  /**
   */
  public static final class FitStub extends io.grpc.stub.AbstractAsyncStub<FitStub> {
    private FitStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FitStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FitStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.chb.examples.lib.RequestFit> streamingFitAndSim(
        io.grpc.stub.StreamObserver<org.chb.examples.lib.ResponseFit> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingFitAndSimMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FitBlockingStub extends io.grpc.stub.AbstractBlockingStub<FitBlockingStub> {
    private FitBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FitBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FitBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class FitFutureStub extends io.grpc.stub.AbstractFutureStub<FitFutureStub> {
    private FitFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FitFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FitFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAMING_FIT_AND_SIM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FitImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FitImplBase serviceImpl, int methodId) {
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
        case METHODID_STREAMING_FIT_AND_SIM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingFitAndSim(
              (io.grpc.stub.StreamObserver<org.chb.examples.lib.ResponseFit>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FitBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FitBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.chb.examples.lib.FitProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Fit");
    }
  }

  private static final class FitFileDescriptorSupplier
      extends FitBaseDescriptorSupplier {
    FitFileDescriptorSupplier() {}
  }

  private static final class FitMethodDescriptorSupplier
      extends FitBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FitMethodDescriptorSupplier(String methodName) {
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
      synchronized (FitGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FitFileDescriptorSupplier())
              .addMethod(getStreamingFitAndSimMethod())
              .build();
        }
      }
    }
    return result;
  }
}
