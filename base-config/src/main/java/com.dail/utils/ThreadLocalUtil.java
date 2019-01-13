package com.dail.utils;

import com.dail.dto.TokenInfo;

/**
 * @Auther: dailiang
 * @Date: 2019/1/7 16:26
 * @Description:
 */
public class ThreadLocalUtil {

    private static ThreadLocal<TokenInfo> tokenInfo = new ThreadLocal<>();

    public static TokenInfo getTokenInfo() {
        return tokenInfo.get();
    }

    public static void setTokenInfo(TokenInfo userDTO) {
        tokenInfo.set(userDTO);
    }
}
