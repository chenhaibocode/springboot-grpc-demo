package com.chenhaibo.rpc;

import com.alibaba.fastjson.JSON;
import com.chenhaibo.util.HttpUtil;
import com.chenhaibo.vo.UserVO;
import com.ke.ehr.discovery.ServiceDiscovery;
import com.ke.ehr.permission.grpc.DataRuleByIdRequest;
import com.ke.ehr.permission.grpc.DataRuleByIdResponse;
import com.ke.ehr.permission.grpc.DataRuleServiceGrpc;
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

    public UserVO findUserByName(Long id) {
        DataRuleServiceGrpc.DataRuleServiceBlockingStub dataRuleServiceBlockingStub =
                DataRuleServiceGrpc.newBlockingStub(serviceDiscovery.getManagedChannel());

        DataRuleByIdRequest request = DataRuleByIdRequest.newBuilder().setId(id).build();
        DataRuleByIdResponse response =
                dataRuleServiceBlockingStub.dataRuleById(request);
        if (null == response) {
            log.error("response is null.");
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(response.getId() + "");
        userVO.setName(response.getUserName());
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
