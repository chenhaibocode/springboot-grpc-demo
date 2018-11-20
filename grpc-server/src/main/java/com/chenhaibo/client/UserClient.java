package com.chenhaibo.client;

import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.model.User;
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
public class UserClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserClient.class);

    private UserFacadeGrpc.UserFacadeBlockingStub userFacadeBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 9898).usePlaintext().build();

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
        LOGGER.info("client sending {}", userParam);

        UserResult userResult =
                userFacadeBlockingStub.getUser(userParam);
        LOGGER.info("client received {}", userResult);

        if (null == userResult) {
            return null;
        }

        User user = new User();
        user.setId(Long.parseLong(userResult.getId()));
        user.setName(userResult.getName());
        return user;
    }
}
