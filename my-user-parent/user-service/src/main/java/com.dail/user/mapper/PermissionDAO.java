package com.dail.user.mapper;

import com.dail.user.model.Permission;
import com.dail.user.model.PermissionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PermissionDAO继承基类
 */
@Repository
public interface PermissionDAO extends MyBatisBaseDao<Permission, Long, PermissionExample> {

    List<Permission> queryUserMenu(@Param(value = "userId") Long userId);

    @Select("SELECT MAX(sort_num) FROM t_permission WHERE is_deleted = 'N'")
    Integer selectMaxSortNum();
}