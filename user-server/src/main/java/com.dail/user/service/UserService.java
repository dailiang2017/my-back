package com.dail.user.service;

import com.dail.user.model.User;

import java.util.List;

/**
 * @Auther: dailiang
 * @Date: 2018/12/18 11:02
 * @Description:
 */
public interface UserService {

    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    User findByUserId(Long userId);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();

    User findByName(String username);
}
