package com.dail.utils;

import com.dail.dto.UserDTO;

/**
 * @Auther: dailiang
 * @Date: 2019/1/7 16:26
 * @Description:
 */
public class ThreadLocalUtil {

    private static ThreadLocal<UserDTO> tokenInfo = new ThreadLocal<>();

    public static UserDTO getTokenInfo() {
        return tokenInfo.get();
    }

    public static void setTokenInfo(UserDTO userDTO) {
        tokenInfo.set(userDTO);
    }
}
