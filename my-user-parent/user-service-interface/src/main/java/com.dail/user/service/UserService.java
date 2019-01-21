package com.dail.user.service;

import com.dail.user.dto.UserDTO;
import com.dail.user.dto.UserQueryDTO;
import com.github.pagehelper.PageInfo;

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
    UserDTO findByUserId(Long userId);

    /**
     * 查找所有用户
     * @return
     */
    List<UserDTO> findAll();

    UserDTO findByName(String username);

    PageInfo<List<UserDTO>> queryUserPage(UserQueryDTO queryDTO);

    Integer update(UserDTO userDTO);

    Integer insert(UserDTO userDTO);
}
