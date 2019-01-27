package com.dail.user.dto;

import lombok.Data;

@Data
public class MenuIDTO {

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型
     */
    private Integer resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 菜单级别1-2-3
     */
    private Integer level;

    private Long userId;
}
