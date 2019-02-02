package com.dail.user.mapper;

import com.dail.user.model.Role;
import com.dail.user.model.RoleExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RoleDAO继承基类
 */
@Repository
public interface RoleDAO extends MyBatisBaseDao<Role, Long, RoleExample> {

    int insertList(List<Role> list);

    int updateList(List<Role> list);

    int deleteList(List<Role> list);

    int deleteAll();

}