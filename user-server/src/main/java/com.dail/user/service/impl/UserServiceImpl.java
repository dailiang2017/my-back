package com.dail.user.service.impl;

import com.dail.user.mapper.UserMapper;
import com.dail.user.model.User;
import com.dail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: dailiang
 * @Date: 2018/12/18 11:03
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }
}
