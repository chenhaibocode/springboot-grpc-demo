package com.chenhaibo.controller;

import com.chenhaibo.client.UserClient;
import com.chenhaibo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhaibo
 * @since 2018-11-27
 */
@Slf4j
@RestController
@RequestMapping("api/user")
@Api("UserController")
public class UserController {

    @Autowired
    private UserClient userClient;

    @ApiOperation(value = "根据姓名查询人员信息", notes = "根据姓名查询人员信息")
    @ApiImplicitParam(name = "name", value = "姓名", paramType = "path", required = true, dataType = "String")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String name) {
        log.info("开始根据姓名查询人员信息");
        User user = userClient.getUser(name);
        if(null == user) {
            User user1 = new User();
            user1.setId(-1L);
            user1.setName("用户不存在");
            return user1;
        }else {
            return user;
        }
    }
}
