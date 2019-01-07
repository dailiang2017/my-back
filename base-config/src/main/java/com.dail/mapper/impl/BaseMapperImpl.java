package com.dail.mapper.impl;

import com.dail.mapper.BaseMapper;

import java.util.List;
import java.util.logging.Logger;

/**
 * todo 待实现
 * @param <T>
 */
public class BaseMapperImpl<T> implements BaseMapper<T> {

    private Logger logger = Logger.getLogger("BaseMapperImpl");

    private Class<T> tClass;

    protected BaseMapperImpl() {

    }

    @Override
    public int insert(T t) {
        return 0;
    }

    @Override
    public int insertSelective(T t) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return 0;
    }

    @Override
    public T selectByPrimaryKey(long id) {
        return null;
    }

    @Override
    public List<T> selectList(T t) {
        return null;
    }

    @Override
    public long getCount(T t) {
        return 0;
    }
}
