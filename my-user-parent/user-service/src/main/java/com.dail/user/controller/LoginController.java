package com.dail.user.controller;

import com.dail.user.dto.LoginDTO;
import com.dail.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: dailiang
 * @Date: 2018/12/25 13:52
 * @Description:
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    @PostMapping("/loginOut")
    public String loginOut() {
        return loginService.loginOut();
    }
}
