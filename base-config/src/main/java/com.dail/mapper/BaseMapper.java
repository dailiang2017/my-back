package com.dail.mapper;

import java.util.List;

public interface BaseMapper<T> {

    int insert(T t);

    int insertSelective(T t);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    T select(long id);

    List<T> selectList(T t);

    long getTotalCount();

    long getCount(T t);
}
