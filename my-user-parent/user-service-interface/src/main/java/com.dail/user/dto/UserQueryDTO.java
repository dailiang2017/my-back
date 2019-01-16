package com.dail.user.dto;

import com.dail.page.Pagination;
import lombok.Data;

@Data
public class UserQueryDTO extends Pagination {

    /**
     * 用户名
     */
    private String username;
}
