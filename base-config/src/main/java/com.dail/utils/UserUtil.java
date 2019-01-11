package com.dail.utils;

import com.dail.constant.CookieConstant;
import com.dail.dto.UserDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: dailiang
 * @Date: 2019/1/8 10:13
 * @Description:
 */
public class UserUtil {

    /**
     * 获得用户信息
     * @return
     */
    public static UserDTO getUserInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userinfo = request.getHeader(CookieConstant.USER_INFO_KEY);
        UserDTO userDTO = StringUtil.stringToBean(userinfo, UserDTO.class);
        return userDTO;
    }
}
