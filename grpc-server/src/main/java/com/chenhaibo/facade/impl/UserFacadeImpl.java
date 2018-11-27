package com.chenhaibo.facade.impl;

import com.chenhaibo.exception.MyException;
import com.chenhaibo.exception.MyExceptionEnums;
import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.model.User;
import com.chenhaibo.service.UserService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 15:49 2018/7/26
 */
@Slf4j
@GrpcService
public class UserFacadeImpl extends UserFacadeGrpc.UserFacadeImplBase {

    @Autowired
    private UserService userService;

    @Override
    public void getUser(UserParam request, StreamObserver<UserResult> responseObserver) {
        UserResult userResult;
        if (null == request) {
            new MyException(MyExceptionEnums.REQUEST_EMPTY);
        }

        User user = userService.findByUserName(request.getName());
        if (null == user) {
            log.error("user is null. request {}", request);
            userResult = UserResult.newBuilder()
                            .setId("-1")
                            .setName("用户不存在").build();
        } else {
            userResult = UserResult.newBuilder()
                            .setId(String.valueOf(user.getId()))
                            .setName(user.getName()).build();
        }

        responseObserver.onNext(userResult);
        responseObserver.onCompleted();
    }
}
