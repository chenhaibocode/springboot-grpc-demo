package com.chenhaibo.service.impl;

import com.chenhaibo.model.User;
import com.chenhaibo.dao.UserMapper;
import com.chenhaibo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhaibo
 * @since 2018-11-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String name) {
        return userMapper.findByUserName(name);
    }

}
