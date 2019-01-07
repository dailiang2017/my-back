package com.dail;

import com.alibaba.fastjson.JSON;
import com.dail.user.model.User;

public class Test {

    public static void main(String[] args) {
        Integer i = 1;
        String str = JSON.toJSONString(i);
        System.out.println(str);

        User user = new User();
        user.setId(1L);
        user.setUsername("username");
        String userStr = JSON.toJSONString(user);
        System.out.println("user：" + userStr);

        User in = JSON.toJavaObject(JSON.parseObject(userStr), User.class);
        System.out.println(in);
    }
}
