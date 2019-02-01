package com.dail.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RoleODTO {

    /**
     * 角色
     */
    private String role;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;
}
