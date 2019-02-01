package com.dail.user.mapper;

import com.dail.user.model.UserRole;
import com.dail.user.model.UserRoleExample;
import org.springframework.stereotype.Repository;

/**
 * UserRoleDAO继承基类
 */
@Repository
public interface UserRoleDAO extends MyBatisBaseDao<UserRole, Long, UserRoleExample> {
}