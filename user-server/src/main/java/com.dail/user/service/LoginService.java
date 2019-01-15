package com.dail.user.service;

import com.dail.user.dto.LoginDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: dailiang
 * @Date: 2018/12/25 14:30
 * @Description:
 */
public interface LoginService {

    public String login(HttpServletResponse response, LoginDTO loginDTO);

    public String loginOut(HttpServletResponse response);
}
