package com.dail.user.controller;

import com.dail.dto.BaseResult;
import com.dail.user.model.User;
import com.dail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Object findByUserId(@RequestParam Long userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping(value="/findAll")
    public BaseResult findAll() {
        return BaseResult.success(userService.findAll());
    }
}
