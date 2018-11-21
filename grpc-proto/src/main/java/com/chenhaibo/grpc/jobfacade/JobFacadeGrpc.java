package com.chenhaibo.grpc.jobfacade;

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
    comments = "Source: JobFacade.proto")
public final class JobFacadeGrpc {

  private JobFacadeGrpc() {}

  public static final String SERVICE_NAME = "com.chenhaibo.grpc.jobfacade.JobFacade";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetJobByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.chenhaibo.grpc.jobfacade.JobParam,
      com.chenhaibo.grpc.jobfacade.JobResult> METHOD_GET_JOB_BY_ID = getGetJobByIdMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.chenhaibo.grpc.jobfacade.JobParam,
      com.chenhaibo.grpc.jobfacade.JobResult> getGetJobByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.chenhaibo.grpc.jobfacade.JobParam,
      com.chenhaibo.grpc.jobfacade.JobResult> getGetJobByIdMethod() {
    return getGetJobByIdMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.chenhaibo.grpc.jobfacade.JobParam,
      com.chenhaibo.grpc.jobfacade.JobResult> getGetJobByIdMethodHelper() {
    io.grpc.MethodDescriptor<com.chenhaibo.grpc.jobfacade.JobParam, com.chenhaibo.grpc.jobfacade.JobResult> getGetJobByIdMethod;
    if ((getGetJobByIdMethod = JobFacadeGrpc.getGetJobByIdMethod) == null) {
      synchronized (JobFacadeGrpc.class) {
        if ((getGetJobByIdMethod = JobFacadeGrpc.getGetJobByIdMethod) == null) {
          JobFacadeGrpc.getGetJobByIdMethod = getGetJobByIdMethod = 
              io.grpc.MethodDescriptor.<com.chenhaibo.grpc.jobfacade.JobParam, com.chenhaibo.grpc.jobfacade.JobResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.chenhaibo.grpc.jobfacade.JobFacade", "getJobById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chenhaibo.grpc.jobfacade.JobParam.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.chenhaibo.grpc.jobfacade.JobResult.getDefaultInstance()))
                  .setSchemaDescriptor(new JobFacadeMethodDescriptorSupplier("getJobById"))
                  .build();
          }
        }
     }
     return getGetJobByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JobFacadeStub newStub(io.grpc.Channel channel) {
    return new JobFacadeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobFacadeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new JobFacadeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JobFacadeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new JobFacadeFutureStub(channel);
  }

  /**
   */
  public static abstract class JobFacadeImplBase implements io.grpc.BindableService {

    /**
     */
    public void getJobById(com.chenhaibo.grpc.jobfacade.JobParam request,
        io.grpc.stub.StreamObserver<com.chenhaibo.grpc.jobfacade.JobResult> responseObserver) {
      asyncUnimplementedUnaryCall(getGetJobByIdMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetJobByIdMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.chenhaibo.grpc.jobfacade.JobParam,
                com.chenhaibo.grpc.jobfacade.JobResult>(
                  this, METHODID_GET_JOB_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class JobFacadeStub extends io.grpc.stub.AbstractStub<JobFacadeStub> {
    private JobFacadeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobFacadeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobFacadeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JobFacadeStub(channel, callOptions);
    }

    /**
     */
    public void getJobById(com.chenhaibo.grpc.jobfacade.JobParam request,
        io.grpc.stub.StreamObserver<com.chenhaibo.grpc.jobfacade.JobResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetJobByIdMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class JobFacadeBlockingStub extends io.grpc.stub.AbstractStub<JobFacadeBlockingStub> {
    private JobFacadeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobFacadeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobFacadeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JobFacadeBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.chenhaibo.grpc.jobfacade.JobResult getJobById(com.chenhaibo.grpc.jobfacade.JobParam request) {
      return blockingUnaryCall(
          getChannel(), getGetJobByIdMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class JobFacadeFutureStub extends io.grpc.stub.AbstractStub<JobFacadeFutureStub> {
    private JobFacadeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JobFacadeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobFacadeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JobFacadeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.chenhaibo.grpc.jobfacade.JobResult> getJobById(
        com.chenhaibo.grpc.jobfacade.JobParam request) {
      return futureUnaryCall(
          getChannel().newCall(getGetJobByIdMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_JOB_BY_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JobFacadeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JobFacadeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_JOB_BY_ID:
          serviceImpl.getJobById((com.chenhaibo.grpc.jobfacade.JobParam) request,
              (io.grpc.stub.StreamObserver<com.chenhaibo.grpc.jobfacade.JobResult>) responseObserver);
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

  private static abstract class JobFacadeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JobFacadeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.chenhaibo.grpc.jobfacade.JobFacadeOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JobFacade");
    }
  }

  private static final class JobFacadeFileDescriptorSupplier
      extends JobFacadeBaseDescriptorSupplier {
    JobFacadeFileDescriptorSupplier() {}
  }

  private static final class JobFacadeMethodDescriptorSupplier
      extends JobFacadeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JobFacadeMethodDescriptorSupplier(String methodName) {
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
      synchronized (JobFacadeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JobFacadeFileDescriptorSupplier())
              .addMethod(getGetJobByIdMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
