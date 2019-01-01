package com.dail.user.service.impl;

import com.dail.constant.CookieConstant;
import com.dail.constant.PrefixConstant;
import com.dail.constant.RedisConstant;
import com.dail.dto.BaseResult;
import com.dail.user.dto.LoginDTO;
import com.dail.user.dto.UserDTO;
import com.dail.user.model.User;
import com.dail.user.service.LoginService;
import com.dail.user.service.UserService;
import com.dail.util.RedisClient;
import com.dail.utils.BeanUtil;
import com.dail.utils.CookieUtils;
import com.dail.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Auther: dailiang
 * @Date: 2018/12/25 17:06
 * @Description:
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisClient redisClient;

    @Override
    @Transactional
    public BaseResult login(HttpServletResponse response, LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if (StringUtil.isBlankOrEmpty(username) || StringUtil.isBlankOrEmpty(password)) {
            return BaseResult.error("用户名或密码不能为空！");
        }
        User user = userService.findByName(username);
        if (user == null) {
            log.error("LoginService.login ---- 用户名不存在！");
            return BaseResult.error("用户名或密码错误！");
        }
        if (!user.getPassword().equals(password)) {
            log.error("LoginService.login ---- 密码不正确！");
            return BaseResult.error("用户名或密码错误！");
        }
        // 生成token
        String token = UUID.randomUUID().toString();
        addCookie(response, token, BeanUtil.copyProperties(user, UserDTO.class));
        return BaseResult.success();
    }

    /**
     * 增加cookie信息，并把token保存到redis
     * @param response
     * @param token
     * @param userDTO
     */
    private void addCookie(HttpServletResponse response, String token, UserDTO userDTO) {
        // 保存token到redis缓存中
        redisClient.set(PrefixConstant.TOKEN_KEY + token, userDTO, RedisConstant.tokenToExpireDefault);
        // 缓存用户id和token的关系，用以确认同一用户同时只能有一个人可以登录
        redisClient.set(PrefixConstant.USERID_KEY + userDTO.getId(), token);
        CookieUtils.setCookie(response, CookieConstant.COOKI_NAME_TOKEN, token, RedisConstant.tokenToExpireDefault);
    }

}
