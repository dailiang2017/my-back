package com.dail.user.controller;

/**
 * @Auther: dailiang
 * @Date: 2019/1/24 18:55
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Long ii = 1000040170145L;
        int aa = ii.hashCode() % 2;
        System.out.println(ii.hashCode());
        System.out.println(aa);
    }
}
