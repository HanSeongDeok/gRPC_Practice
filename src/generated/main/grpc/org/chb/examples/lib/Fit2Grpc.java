package org.chb.examples.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.0)",
    comments = "Source: fit2.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Fit2Grpc {

  private Fit2Grpc() {}

  public static final String SERVICE_NAME = "Fit2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.chb.examples.lib.TcIndex,
      org.chb.examples.lib.TcWriteInfo> getWriteMemoryInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteMemoryInfo",
      requestType = org.chb.examples.lib.TcIndex.class,
      responseType = org.chb.examples.lib.TcWriteInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chb.examples.lib.TcIndex,
      org.chb.examples.lib.TcWriteInfo> getWriteMemoryInfoMethod() {
    io.grpc.MethodDescriptor<org.chb.examples.lib.TcIndex, org.chb.examples.lib.TcWriteInfo> getWriteMemoryInfoMethod;
    if ((getWriteMemoryInfoMethod = Fit2Grpc.getWriteMemoryInfoMethod) == null) {
      synchronized (Fit2Grpc.class) {
        if ((getWriteMemoryInfoMethod = Fit2Grpc.getWriteMemoryInfoMethod) == null) {
          Fit2Grpc.getWriteMemoryInfoMethod = getWriteMemoryInfoMethod =
              io.grpc.MethodDescriptor.<org.chb.examples.lib.TcIndex, org.chb.examples.lib.TcWriteInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteMemoryInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.TcIndex.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.TcWriteInfo.getDefaultInstance()))
              .setSchemaDescriptor(new Fit2MethodDescriptorSupplier("WriteMemoryInfo"))
              .build();
        }
      }
    }
    return getWriteMemoryInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.chb.examples.lib.TcWriteInfo,
      org.chb.examples.lib.TcWriteInfo> getWriteMemoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteMemory",
      requestType = org.chb.examples.lib.TcWriteInfo.class,
      responseType = org.chb.examples.lib.TcWriteInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.chb.examples.lib.TcWriteInfo,
      org.chb.examples.lib.TcWriteInfo> getWriteMemoryMethod() {
    io.grpc.MethodDescriptor<org.chb.examples.lib.TcWriteInfo, org.chb.examples.lib.TcWriteInfo> getWriteMemoryMethod;
    if ((getWriteMemoryMethod = Fit2Grpc.getWriteMemoryMethod) == null) {
      synchronized (Fit2Grpc.class) {
        if ((getWriteMemoryMethod = Fit2Grpc.getWriteMemoryMethod) == null) {
          Fit2Grpc.getWriteMemoryMethod = getWriteMemoryMethod =
              io.grpc.MethodDescriptor.<org.chb.examples.lib.TcWriteInfo, org.chb.examples.lib.TcWriteInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteMemory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.TcWriteInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.chb.examples.lib.TcWriteInfo.getDefaultInstance()))
              .setSchemaDescriptor(new Fit2MethodDescriptorSupplier("WriteMemory"))
              .build();
        }
      }
    }
    return getWriteMemoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getCheckConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckConnection",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getCheckConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getCheckConnectionMethod;
    if ((getCheckConnectionMethod = Fit2Grpc.getCheckConnectionMethod) == null) {
      synchronized (Fit2Grpc.class) {
        if ((getCheckConnectionMethod = Fit2Grpc.getCheckConnectionMethod) == null) {
          Fit2Grpc.getCheckConnectionMethod = getCheckConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new Fit2MethodDescriptorSupplier("CheckConnection"))
              .build();
        }
      }
    }
    return getCheckConnectionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Fit2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Fit2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Fit2Stub>() {
        @java.lang.Override
        public Fit2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Fit2Stub(channel, callOptions);
        }
      };
    return Fit2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Fit2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Fit2BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Fit2BlockingStub>() {
        @java.lang.Override
        public Fit2BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Fit2BlockingStub(channel, callOptions);
        }
      };
    return Fit2BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Fit2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Fit2FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Fit2FutureStub>() {
        @java.lang.Override
        public Fit2FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Fit2FutureStub(channel, callOptions);
        }
      };
    return Fit2FutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class Fit2ImplBase implements io.grpc.BindableService {

    /**
     */
    public void writeMemoryInfo(org.chb.examples.lib.TcIndex request,
        io.grpc.stub.StreamObserver<org.chb.examples.lib.TcWriteInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteMemoryInfoMethod(), responseObserver);
    }

    /**
     */
    public void writeMemory(org.chb.examples.lib.TcWriteInfo request,
        io.grpc.stub.StreamObserver<org.chb.examples.lib.TcWriteInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteMemoryMethod(), responseObserver);
    }

    /**
     */
    public void checkConnection(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckConnectionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWriteMemoryInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.chb.examples.lib.TcIndex,
                org.chb.examples.lib.TcWriteInfo>(
                  this, METHODID_WRITE_MEMORY_INFO)))
          .addMethod(
            getWriteMemoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.chb.examples.lib.TcWriteInfo,
                org.chb.examples.lib.TcWriteInfo>(
                  this, METHODID_WRITE_MEMORY)))
          .addMethod(
            getCheckConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.Empty>(
                  this, METHODID_CHECK_CONNECTION)))
          .build();
    }
  }

  /**
   */
  public static final class Fit2Stub extends io.grpc.stub.AbstractAsyncStub<Fit2Stub> {
    private Fit2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Fit2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Fit2Stub(channel, callOptions);
    }

    /**
     */
    public void writeMemoryInfo(org.chb.examples.lib.TcIndex request,
        io.grpc.stub.StreamObserver<org.chb.examples.lib.TcWriteInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteMemoryInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMemory(org.chb.examples.lib.TcWriteInfo request,
        io.grpc.stub.StreamObserver<org.chb.examples.lib.TcWriteInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteMemoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkConnection(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckConnectionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Fit2BlockingStub extends io.grpc.stub.AbstractBlockingStub<Fit2BlockingStub> {
    private Fit2BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Fit2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Fit2BlockingStub(channel, callOptions);
    }

    /**
     */
    public org.chb.examples.lib.TcWriteInfo writeMemoryInfo(org.chb.examples.lib.TcIndex request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteMemoryInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.chb.examples.lib.TcWriteInfo writeMemory(org.chb.examples.lib.TcWriteInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteMemoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty checkConnection(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckConnectionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Fit2FutureStub extends io.grpc.stub.AbstractFutureStub<Fit2FutureStub> {
    private Fit2FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Fit2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Fit2FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chb.examples.lib.TcWriteInfo> writeMemoryInfo(
        org.chb.examples.lib.TcIndex request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteMemoryInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.chb.examples.lib.TcWriteInfo> writeMemory(
        org.chb.examples.lib.TcWriteInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteMemoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> checkConnection(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckConnectionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WRITE_MEMORY_INFO = 0;
  private static final int METHODID_WRITE_MEMORY = 1;
  private static final int METHODID_CHECK_CONNECTION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Fit2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Fit2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WRITE_MEMORY_INFO:
          serviceImpl.writeMemoryInfo((org.chb.examples.lib.TcIndex) request,
              (io.grpc.stub.StreamObserver<org.chb.examples.lib.TcWriteInfo>) responseObserver);
          break;
        case METHODID_WRITE_MEMORY:
          serviceImpl.writeMemory((org.chb.examples.lib.TcWriteInfo) request,
              (io.grpc.stub.StreamObserver<org.chb.examples.lib.TcWriteInfo>) responseObserver);
          break;
        case METHODID_CHECK_CONNECTION:
          serviceImpl.checkConnection((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Fit2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Fit2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.chb.examples.lib.Fit2Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Fit2");
    }
  }

  private static final class Fit2FileDescriptorSupplier
      extends Fit2BaseDescriptorSupplier {
    Fit2FileDescriptorSupplier() {}
  }

  private static final class Fit2MethodDescriptorSupplier
      extends Fit2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Fit2MethodDescriptorSupplier(String methodName) {
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
      synchronized (Fit2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Fit2FileDescriptorSupplier())
              .addMethod(getWriteMemoryInfoMethod())
              .addMethod(getWriteMemoryMethod())
              .addMethod(getCheckConnectionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
