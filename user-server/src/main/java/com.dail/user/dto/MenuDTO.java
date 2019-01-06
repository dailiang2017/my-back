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
     * 资源类型 1-menu 2-button
     */
    private Byte resourcetype;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 子菜单
     */
    private List<MenuDTO> children;
}
