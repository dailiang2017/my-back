package com.dail.user.service;

import com.dail.user.dto.LoginDTO;

/**
 * @Auther: dailiang
 * @Date: 2018/12/25 14:30
 * @Description:
 */
public interface LoginService {

    public String login(LoginDTO loginDTO);

    public String loginOut();
}
