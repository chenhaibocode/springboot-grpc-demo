package com.chenhaibo.client;

import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.model.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/19 16:44
 * @Description:
 */
@Slf4j
@Component
public class UserClient {

    private UserFacadeGrpc.UserFacadeBlockingStub userFacadeBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("0.0.0.0", 9898).usePlaintext().build();

        userFacadeBlockingStub =
                UserFacadeGrpc.newBlockingStub(managedChannel);
    }

    /**
     *
     * @param name
     * @return
     */
    public User getUser(String name) {
        UserParam userParam = UserParam.newBuilder().setName(name).build();
        log.info("client sending {}", userParam);

        UserResult userResult =
                userFacadeBlockingStub.getUser(userParam);
        log.info("client received {}", userResult);

        if (null == userResult) {
            return null;
        }

        User user = new User();
        user.setId(Long.parseLong(userResult.getId()));
        user.setName(userResult.getName());
        return user;
    }
}
