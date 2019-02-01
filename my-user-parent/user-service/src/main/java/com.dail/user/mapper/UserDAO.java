package com.dail.user.mapper;

import com.dail.user.model.User;
import com.dail.user.model.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, Long, UserExample> {

    @Select("select * from t_user")
    List<User> selectAll();

    @Select("select * from t_user where username = #{username}")
    User findByName(@Param(value = "username") String username);
}