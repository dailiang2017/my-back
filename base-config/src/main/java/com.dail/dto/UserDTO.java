package com.dail.dto;

import lombok.Data;

/**
 * @Auther: dailiang
 * @Date: 2019/1/7 16:28
 * @Description:
 */
@Data
public class UserDTO {

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;
}
