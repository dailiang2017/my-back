package com.dail.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RoleODTO {

    private String role;

    private String description;

    private String username;

    private Date createTime;
}
