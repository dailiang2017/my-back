package com.dail.utils;

import com.dail.constant.CookieConstant;
import com.dail.dto.TokenInfo;
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
    public static TokenInfo getUserInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TokenInfo tokenInfo = StringUtil.stringToBean(request.getHeader(CookieConstant.USER_INFO_KEY), TokenInfo.class);
        tokenInfo.setToken(request.getHeader(CookieConstant.COOKIE_NAME_TOKEN));
        return tokenInfo;
    }
}
