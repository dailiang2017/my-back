package com.dail.user.service;

import com.dail.constant.PrefixConstant;
import com.dail.constant.RedisConstant;
import com.dail.constant.ReturnConstant;
import com.dail.dto.TokenInfo;
import com.dail.user.dto.LoginDTO;
import com.dail.user.dto.UserDTO;
import com.dail.util.RedisClient;
import com.dail.utils.ExceptionUtil;
import com.dail.utils.StringUtil;
import com.dail.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public String login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        ExceptionUtil.isTrue(StringUtil.isBlankOrEmpty(username) || StringUtil.isBlankOrEmpty(password)
                , "用户名或密码不能为空！");
        UserDTO user = userService.findByName(username);
        ExceptionUtil.isTrue(user == null, "用户名或密码错误！");
        ExceptionUtil.isTrue(!user.getPassword().equals(password), "用户名或密码错误！");
        // 生成token
        String token = UUID.randomUUID().toString();
        setToken(token, user);
        return token;
    }

    @Override
    public String loginOut() {
        TokenInfo tokenInfo = UserUtil.getUserInfo();
        // 删除token信息
        redisClient.delete(PrefixConstant.TOKEN_KEY + tokenInfo.getToken());
        redisClient.delete(PrefixConstant.USERID_KEY + tokenInfo.getId());
        return ReturnConstant.OK;
    }

    /**
     * 把token保存到redis
     * @param token
     * @param userDTO
     */
    private void setToken(String token, UserDTO userDTO) {
        // 保存token到redis缓存中
        redisClient.set(PrefixConstant.TOKEN_KEY + token, userDTO, RedisConstant.tokenToExpireDefault);
        // 缓存用户id和token的关系，用以确认同一用户同时只能有一个人可以登录
        redisClient.set(PrefixConstant.USERID_KEY + userDTO.getId(), token);
    }

}
