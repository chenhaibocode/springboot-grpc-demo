package com.chenhaibo.service;

import com.chenhaibo.dao.UserRepositoty;
import com.chenhaibo.exception.MyException;
import com.chenhaibo.exception.MyExceptionEnums;
import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.model.User;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: com.com.chenhaibo
 * @Description:
 * @Date: Created in 15:49 2018/7/26
 */
@Service
public class UserServiceImpl extends UserFacadeGrpc.UserFacadeImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepositoty userRepositoty;

    @Override
    public void getUser(UserParam request, StreamObserver<UserResult> responseObserver) {
        if(null == request) {
            new MyException(MyExceptionEnums.REQUEST_EMPTY);
        }
        LOGGER.info("server getUser request {}", request);

        User user = userRepositoty.findByUserName(request.getName());
        if (null == user) {
            LOGGER.error("user is null. request {}", request);
            return;
        }
        UserResult userResult =
                UserResult.newBuilder()
                        .setId(String.valueOf(user.getId()))
                        .setName(user.getName()).build();
        LOGGER.info("server getUser responded {}", userResult);

        responseObserver.onNext(userResult);
        responseObserver.onCompleted();
    }
}
