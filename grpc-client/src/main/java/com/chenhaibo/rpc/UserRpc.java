package com.chenhaibo.rpc;

import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.vo.UserVO;
import com.ke.springboot.grpc.discovery.ServiceDiscovery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: com.com.chenhaibo
 * @Date: 2018/11/18 15:15
 * @Description:
 */
@Slf4j
@Service
public class UserRpc {

    @Autowired
    private ServiceDiscovery serviceDiscovery;

    public UserVO findUserByName(String name) {

        UserFacadeGrpc.UserFacadeBlockingStub userFacadeBlockingStub =
                UserFacadeGrpc.newBlockingStub(serviceDiscovery.getManagedChannel());

        UserParam userParam = UserParam.newBuilder().setName(name).build();
        UserResult userResult =
                userFacadeBlockingStub.getUser(userParam);
        if (null == userResult) {
            log.error("userResult is null.");
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(userResult.getId());
        userVO.setName(userResult.getName());
        return userVO;
    }
}
