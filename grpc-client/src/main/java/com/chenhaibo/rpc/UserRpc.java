package com.chenhaibo.rpc;

import com.alibaba.fastjson.JSON;
import com.chenhaibo.grpc.userfacade.UserFacadeGrpc;
import com.chenhaibo.grpc.userfacade.UserParam;
import com.chenhaibo.grpc.userfacade.UserResult;
import com.chenhaibo.util.HttpUtil;
import com.chenhaibo.vo.UserVO;
import com.zk.springboot.grpc.discovery.ServiceDiscovery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chenhaibo
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

    public UserVO findUserByNameByHttp(String name) {
        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        String ret = HttpUtil.sendPostJson("http://10.26.21.6:4140/user/getUser", JSON.toJSONString(param));
        if (ret != null) {
            try {
                return JSON.parseObject(ret, UserVO.class);
            } catch (Exception e) {
                log.error("#UserRpc.findUserByNameByHttp# json结果处理失败，ret:{} ", e);
            }
        }
        return null;
    }
}
