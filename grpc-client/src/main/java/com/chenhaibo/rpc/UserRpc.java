package com.chenhaibo.rpc;

import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.vo.UserVO;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Auther: com.com.chenhaibo
 * @Date: 2018/11/18 15:15
 * @Description:
 */
@Service
public class UserRpc {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserRpc.class);

    @GrpcClient("grpc-server-user")
    private Channel serverChannel;

    public UserVO findUserByName(String name) {

        UserFacadeGrpc.UserFacadeBlockingStub userFacadeBlockingStub = UserFacadeGrpc.newBlockingStub(serverChannel);

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
