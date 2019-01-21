package com.dail.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    private Long id;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * N正常,Y删除
     */
    private String isDeleted;

    /**
     * 每页条数
     */
    private int limit        = 20;

    /**
     * 起始条数
     */
    private int start        = 0;
    /**
     * 是否需要 分页
     */
    boolean     isNeedPaging = true;
}
