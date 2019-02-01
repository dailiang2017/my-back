package com.dail.user.mapper;

import com.dail.user.model.RolePermission;
import com.dail.user.model.RolePermissionExample;
import org.springframework.stereotype.Repository;

/**
 * RolePermissionDAO继承基类
 */
@Repository
public interface RolePermissionDAO extends MyBatisBaseDao<RolePermission, Long, RolePermissionExample> {
}