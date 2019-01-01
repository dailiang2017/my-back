package com.dail.utils;

/**
 * @Auther: dailiang
 * @Date: 2018/12/25 17:54
 * @Description: string类型工具类
 */
public class StringUtil {

    /**
     * 判断string类型非空
     * @param str
     * @return
     */
    public static boolean isBlankOrEmpty(String str) {
        return (str == null || str.isEmpty()) ? true : false;
    }
}
