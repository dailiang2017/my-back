package com.dail.user.controller;

import com.dail.user.dto.LoginDTO;
import com.dail.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
    public String login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        return loginService.login(response, loginDTO);
    }

    @PostMapping("/loginOut")
    public String loginOut(HttpServletResponse response) {
        return loginService.loginOut(response);
    }
}
