package com.chenhaibo.rpc;

import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.vo.UserVO;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: com.com.chenhaibo
 * @Date: 2018/11/18 15:15
 * @Description:
 */
@Component
public class UserRpc {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserRpc.class);

    private UserFacadeGrpc.UserFacadeBlockingStub userFacadeBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("0.0.0.0", 9090).usePlaintext().build();

        userFacadeBlockingStub =
                UserFacadeGrpc.newBlockingStub(managedChannel);
    }

    public UserVO findUserByName(String name) {

        UserParam userParam = UserParam.newBuilder().setName(name).build();
        LOGGER.info("client sending {}", userParam);

        UserResult userResult =
                userFacadeBlockingStub.getUser(userParam);
        LOGGER.info("client received {}", userResult);

        if (null == userResult) {
            LOGGER.error("userResult is null.");
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(userResult.getId());
        userVO.setName(userResult.getName());
        return userVO;
    }
}
