package com.dail.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    private Long id;

    private String createId;

    private Date createTime;

    private String updateId;

    private Date updateTime;

    private String isDeleted;
}
