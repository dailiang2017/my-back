package com.dail.user.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_permission
 * @author 
 */
@Data
public class Permission implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型 1-菜单 2-按钮
     */
    private Byte resourceType;

    /**
     * url
     */
    private String url;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 等级 1-一级 2-二级 3-三级
     */
    private Byte level;

    /**
     * 图标
     */
    private String icon;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改人
     */
    private String modifier;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

    /**
     * N正常,Y删除
     */
    private String isDeleted;

    private static final long serialVersionUID = 1L;

    public void preInsert(String username, Integer sortNum) {
        Date now = new Date();
        this.creator = username;
        this.modifier = username;
        this.createTime = now;
        this.modifyTime = now;
        this.sortNum = sortNum;
    }
}