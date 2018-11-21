package com.chenhaibo.client;

import com.chenhaibo.grpc.jobfacade.JobFacadeGrpc;
import com.chenhaibo.grpc.jobfacade.JobParam;
import com.chenhaibo.grpc.jobfacade.JobResult;
import com.chenhaibo.model.Job;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/19 16:44
 * @Description:
 */
@Component
public class JobClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JobClient.class);

    private JobFacadeGrpc.JobFacadeBlockingStub jobFacadeBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 9898).usePlaintext().build();

        jobFacadeBlockingStub =
                JobFacadeGrpc.newBlockingStub(managedChannel);
    }

    /**
     * @param id
     * @return
     */
    public Job getJobById(Long id) {
        JobParam jobParam = JobParam.newBuilder().setId(String.valueOf(id)).build();
        LOGGER.info("client sending {}", jobParam);

        JobResult jobResult =
                jobFacadeBlockingStub.getJobById(jobParam);
        LOGGER.info("client received {}", jobResult);

        if (null == jobResult) {
            return null;
        }

        Job job = new Job();
        job.setId(Long.parseLong(jobResult.getId()));
        job.setJobCode(jobResult.getJobCode());
        return job;
    }
}
