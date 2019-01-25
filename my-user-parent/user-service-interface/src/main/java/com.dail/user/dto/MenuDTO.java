package com.dail.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {

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

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 图标
     */
    private String icon;

    /**
     * 子菜单
     */
    private List<MenuDTO> children;
}
