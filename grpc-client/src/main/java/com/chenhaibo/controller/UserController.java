package com.chenhaibo.controller;

import com.chenhaibo.rpc.UserRpc;
import com.chenhaibo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 15:51 2018/7/26
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRpc userRpc;

    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "show")
    @ResponseBody
    public String show(@RequestParam(value = "id") Long id) {
        UserVO userVO = userRpc.findUserByName(id);
        if (null != userVO) {
            return userVO.getId() + "";
        }
        return "null";
    }

    @RequestMapping(value = "showHttp")
    @ResponseBody
    public String showHttp(@RequestParam(value = "name") String name) {
        UserVO userVO = userRpc.findUserByNameByHttp(name);
        if (null != userVO) {
            return userVO.getId() + "";
        }
        return "null";
    }
}
