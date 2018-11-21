package com.chenhaibo.facade.impl;

import com.chenhaibo.dao.JobMapper;
import com.chenhaibo.exception.MyException;
import com.chenhaibo.exception.MyExceptionEnums;
import com.chenhaibo.grpc.jobfacade.JobFacadeGrpc;
import com.chenhaibo.grpc.jobfacade.JobParam;
import com.chenhaibo.grpc.jobfacade.JobResult;
import com.chenhaibo.model.Job;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: com.com.chenhaibo
 * @Description:
 * @Date: Created in 15:49 2018/7/26
 */
@GrpcService
public class JobFacadeImpl extends JobFacadeGrpc.JobFacadeImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JobFacadeImpl.class);

    @Autowired
    private JobMapper jobDao;

    @Override
    public void getJobById(JobParam request, StreamObserver<JobResult> responseObserver) {
        JobResult jobResult;
        if (null == request) {
            new MyException(MyExceptionEnums.REQUEST_EMPTY);
        }

        Job job = jobDao.getJobById(Long.parseLong(request.getId()));
        if (null == job) {
            LOGGER.error("user is null. request {}", request);
            jobResult = JobResult.newBuilder()
                    .setId("-1")
                    .setJobCode("职务不存在").build();
        } else {
            jobResult = JobResult.newBuilder()
                    .setId(String.valueOf(job.getId()))
                    .setJobCode(job.getJobCode()).build();
        }

        responseObserver.onNext(jobResult);
        responseObserver.onCompleted();
    }
}
