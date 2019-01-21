package com.dail.user.controller;

import com.dail.dto.TokenInfo;
import com.dail.user.dto.UserDTO;
import com.dail.user.dto.UserQueryDTO;
import com.dail.user.service.UserService;
import com.dail.utils.UserUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: dailiang
 * @Date: 2018/12/18 11:06
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/findByUserId")
    public UserDTO findByUserId(@RequestParam Long userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping(value="/findAll")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping("/queryUserPage")
    public PageInfo<List<UserDTO>> queryUserPage(@RequestBody UserQueryDTO queryDTO) {
        return userService.queryUserPage(queryDTO);
    }

    @PostMapping("/update")
    public Integer update(@RequestBody UserDTO userDTO) {
        TokenInfo tokenInfo = UserUtil.getUserInfo();
        userDTO.preUpdate(tokenInfo.getId());
        return userService.update(userDTO);
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody UserDTO userDTO) {
        TokenInfo tokenInfo = UserUtil.getUserInfo();
        userDTO.preInsert(tokenInfo.getId());
        return userService.insert(userDTO);
    }

    /**
     * 逻辑删除
     * @return
     */
    @GetMapping("/delete/{id}")
    public Integer delete(@PathVariable("id") Long id) {
        UserDTO userDTO = new UserDTO();
        TokenInfo tokenInfo = UserUtil.getUserInfo();
        userDTO.preDelete(tokenInfo.getId(), id);
        return userService.update(userDTO);
    }
}
