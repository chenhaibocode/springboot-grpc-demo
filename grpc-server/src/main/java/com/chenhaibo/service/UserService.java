package com.chenhaibo.service;

import com.chenhaibo.model.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhaibo
 * @since 2018-11-27
 */
public interface UserService extends IService<User> {

    User findByUserName(String name);
}
