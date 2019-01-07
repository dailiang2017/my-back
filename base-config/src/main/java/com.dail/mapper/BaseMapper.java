package com.dail.mapper;

import java.util.List;

/**
 * todo 待实现
 * @param <T>
 */
public interface BaseMapper<T> {

    int insert(T t);

    int insertSelective(T t);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    T selectByPrimaryKey(long id);

    List<T> selectList(T t);

    long getCount(T t);
}
