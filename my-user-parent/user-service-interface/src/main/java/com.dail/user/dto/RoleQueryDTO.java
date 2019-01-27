package com.dail.user.dto;

import com.dail.page.Pagination;
import lombok.Data;

@Data
public class RoleQueryDTO extends Pagination {

    /**
     * 角色名
     */
    private String role;
}
