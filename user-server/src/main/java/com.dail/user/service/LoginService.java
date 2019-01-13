package com.dail.user.service;

import com.dail.dto.BaseResult;
import com.dail.user.dto.LoginDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: dailiang
 * @Date: 2018/12/25 14:30
 * @Description:
 */
public interface LoginService {

    public BaseResult login(HttpServletResponse response, LoginDTO loginDTO);

    public BaseResult loginOut(HttpServletResponse response);
}
