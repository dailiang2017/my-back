package com.dail.user.dto;

import com.dail.dto.BaseModel;
import lombok.Data;

@Data
public class RoleIDTO extends BaseModel {

    /**
     * 角色名
     */
    private String role;

    /**
     * 描述
     */
    private String description;

    private String username;
}
