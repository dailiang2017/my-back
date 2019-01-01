package com.dail.gate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: dailiang
 * @Date: 2018/12/28 15:48
 * @Description:
 */
@Component
public class IgnoreUrlService {

    @Value("${zuul.prefix}")
    private String prefiUrl;
    @Value("${gate.ignore.authUrl}")
    private String authUrl;

    /**
     * 登录校验可以忽略的url
     * @param requestUri
     * @return
     */
    public boolean loginCheckUrl(String requestUri) {
        return checkUrl(authUrl, requestUri);
    }

    /**
     * 判断url组中是否存在访问的uri
     * @param url
     * @param requestUri
     * @return
     */
    private boolean checkUrl(String url, String requestUri) {
        String[] strs = url.split(",");
        if (Arrays.asList(strs).contains(requestUri.substring(prefiUrl.length()))) {
            return true;
        }
        return false;
    }
}
