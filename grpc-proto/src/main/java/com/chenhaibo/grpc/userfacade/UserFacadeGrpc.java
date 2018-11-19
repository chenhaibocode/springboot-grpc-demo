package com.chenhaibo.grpc.userfacade;

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
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: UserFacade.proto")
public final class UserFacadeGrpc {

  private UserFacadeGrpc() {}

  public static final String SERVICE_NAME = "com.chenhaibo.grpc.userfacade.UserFacade";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.chenhaibo.grpc.userfacade.UserParam,
      com.chenhaibo.grpc.userfacade.UserResult> METHOD_GET_USER = getGetUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.chenhaibo.grpc.userfacade.UserParam,
      com.chenhaibo.grpc.userfacade.UserResult> getGetUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.chenhaibo.grpc.userfacade.UserParam,
      com.chenhaibo.grpc.userfacade.UserResult> getGetUserMethod() {
    return getGetUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.chenhaibo.grpc.userfacade.UserParam,
      com.chenhaibo.grpc.userfacade.UserResult> getGetUserMethodHelper() {
    io.grpc.MethodDescriptor<com.chenhaibo.grpc.userfacade.UserParam, com.chenhaibo.grpc.userfacade.UserResult> getGetUserMethod;
    if ((getGetUserMethod = UserFacadeGrpc.getGetUserMethod) == null) {
      synchronized (UserFacadeGrpc.class) {
        if ((getGetUserMethod = UserFacadeGrpc.getGetUserMethod) == null) {
          UserFacadeGrpc.getGetUserMethod = getGetUserMethod = 
              io.grpc.MethodDescriptor.<com.chenhaibo.grpc.userfacade.UserParam, com.chenhaibo.grpc.userfacade.UserResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.chenhaibo.grpc.userfacade.UserFacade", "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chenhaibo.grpc.userfacade.UserParam.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chenhaibo.grpc.userfacade.UserResult.getDefaultInstance()))
                  .setSchemaDescriptor(new UserFacadeMethodDescriptorSupplier("getUser"))
                  .build();
          }
        }
     }
     return getGetUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserFacadeStub newStub(io.grpc.Channel channel) {
    return new UserFacadeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserFacadeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserFacadeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserFacadeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserFacadeFutureStub(channel);
  }

  /**
   */
  public static abstract class UserFacadeImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUser(com.chenhaibo.grpc.userfacade.UserParam request,
        io.grpc.stub.StreamObserver<com.chenhaibo.grpc.userfacade.UserResult> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.chenhaibo.grpc.userfacade.UserParam,
                com.chenhaibo.grpc.userfacade.UserResult>(
                  this, METHODID_GET_USER)))
          .build();
    }
  }

  /**
   */
  public static final class UserFacadeStub extends io.grpc.stub.AbstractStub<UserFacadeStub> {
    private UserFacadeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFacadeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFacadeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFacadeStub(channel, callOptions);
    }

    /**
     */
    public void getUser(com.chenhaibo.grpc.userfacade.UserParam request,
        io.grpc.stub.StreamObserver<com.chenhaibo.grpc.userfacade.UserResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserFacadeBlockingStub extends io.grpc.stub.AbstractStub<UserFacadeBlockingStub> {
    private UserFacadeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFacadeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFacadeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFacadeBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chenhaibo.grpc.userfacade.UserResult getUser(com.chenhaibo.grpc.userfacade.UserParam request) {
      return blockingUnaryCall(
          getChannel(), getGetUserMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserFacadeFutureStub extends io.grpc.stub.AbstractStub<UserFacadeFutureStub> {
    private UserFacadeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFacadeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFacadeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFacadeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chenhaibo.grpc.userfacade.UserResult> getUser(
        com.chenhaibo.grpc.userfacade.UserParam request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserFacadeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserFacadeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser((com.chenhaibo.grpc.userfacade.UserParam) request,
              (io.grpc.stub.StreamObserver<com.chenhaibo.grpc.userfacade.UserResult>) responseObserver);
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

  private static abstract class UserFacadeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserFacadeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chenhaibo.grpc.userfacade.UserFacadeOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserFacade");
    }
  }

  private static final class UserFacadeFileDescriptorSupplier
      extends UserFacadeBaseDescriptorSupplier {
    UserFacadeFileDescriptorSupplier() {}
  }

  private static final class UserFacadeMethodDescriptorSupplier
      extends UserFacadeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserFacadeMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserFacadeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserFacadeFileDescriptorSupplier())
              .addMethod(getGetUserMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
