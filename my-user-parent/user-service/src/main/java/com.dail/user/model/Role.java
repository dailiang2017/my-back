package com.dail.user.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_role
 * @author 
 */
@Data
public class Role implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色名称
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

    public void preInsert(String username) {
        Date now = new Date();
        this.setCreator(username);
        this.setModifier(username);
        this.setCreateTime(now);
        this.setModifyTime(now);
    }

    public void preUpdate(String username) {
        Date now = new Date();
        this.setModifier(username);
        this.setModifyTime(now);
    }
}