package com.sheffield.common.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractDao extends SqlSessionDaoSupport {

    protected static final String COUNT = "count";
    protected static final String SELECT_ONE = "selectOne";
    protected static final String INSERT = "insert";
    protected static final String INSERT_LIST = "insertList";
    protected static final String UPDATE = "update";
    protected static final String UPDATE_BY_ENTITY = "updateByEntity";
    protected static final String DELETE = "delete";
    protected static final String SELECT_LIST = "selectList";


    private static String getStatement(Class<?> clazz, String methodName) {
        return clazz.getName() + "." + methodName;
    }

    public Integer count(Object parameter) {

        return getSqlSession().selectOne(getStatement(parameter.getClass(), COUNT), parameter);
    }

    public Integer count(Class<?> statementClazz, String methodName, Object parameter) {

        return getSqlSession().selectOne(getStatement(statementClazz, methodName), parameter);
    }

    public <T> T selectOne(Object parameter) {

        return getSqlSession().selectOne(getStatement(parameter.getClass(), SELECT_ONE), parameter);
    }

    public <T> T selectOne(Class<?> statementClazz, String methodName, Object parameter) {

        return getSqlSession().selectOne(getStatement(statementClazz, methodName), parameter);
    }

    public <T> T selectOne(Class<?> statementClazz, String methodName) {

        return getSqlSession().selectOne(getStatement(statementClazz, methodName));
    }

    public <T> T selectById(Class<?> statementClazz, Object parameter) {

        return getSqlSession().selectOne(getStatement(statementClazz, "selectById"), parameter);
    }

    public int insert(Object parameter) {

        return getSqlSession().insert(getStatement(parameter.getClass(), INSERT), parameter);
    }

    public int insert(List<?> list) {

        return getSqlSession().insert(getStatement(list.get(0).getClass(), INSERT_LIST), list);
    }

    public int update(Object parameter) {

        return getSqlSession().update(getStatement(parameter.getClass(), UPDATE), parameter);
    }

    public int update(Class<?> statementClazz, String methodName) {

        return getSqlSession().update(getStatement(statementClazz, methodName));
    }

    public int update(Class<?> statementClazz, String methodName, Object parameter) {

        return getSqlSession().update(getStatement(statementClazz, methodName), parameter);
    }

    public int update(Object setParameter, Object whereParameter) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("s", setParameter);
        parameter.put("w", whereParameter);
        return getSqlSession().update(getStatement(setParameter.getClass(), UPDATE_BY_ENTITY), parameter);
    }

    public int delete(Object parameter) {

        return getSqlSession().delete(getStatement(parameter.getClass(), DELETE), parameter);
    }

    public int delete(Class<?> statementClazz, String methodName, Object parameter) {

        return getSqlSession().delete(getStatement(statementClazz, methodName), parameter);
    }

    public int deleteById(Class<?> statementClazz, Object parameter) {

        return getSqlSession().delete(getStatement(statementClazz, "deleteById"), parameter);
    }


    public <E> List<E> selectList(Object parameter) {

        return getSqlSession().selectList(getStatement(parameter.getClass(), SELECT_LIST), parameter);
    }

    public <E> List<E> selectList(Object parameter, String orderBy) {

        PageHelper.orderBy(orderBy);
        return selectList(parameter);
    }

    public <E> List<E> selectList(Class<?> statementClazz, String methodName) {

        return getSqlSession().selectList(getStatement(statementClazz, methodName));
    }

    public <E> List<E> selectList(Class<?> statementClazz, String methodName, Object parameter) {

        return getSqlSession().selectList(getStatement(statementClazz, methodName), parameter);
    }

    public <E> List<E> selectList(Class<?> statementClazz, String methodName, Object parameter, String orderBy) {

        PageHelper.orderBy(orderBy);
        return selectList(statementClazz, methodName, parameter);
    }


    public <E> List<E> selectPageList(Class<?> statementClazz, String methodName, Object parameter,
                                      int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, false);

        return selectList(statementClazz, methodName, parameter);
    }


    public <E> List<E> selectPageList(Object parameter, int pageNum, int pageSize, String orderBy) {
        PageHelper.startPage(pageNum, pageSize, false);
        PageHelper.orderBy(orderBy);

        return selectList(parameter);
    }

    public <E> List<E> selectPageList(Class<?> statementClazz, String methodName, Object parameter,
                                      int pageNum, int pageSize, String orderBy) {
        PageHelper.startPage(pageNum, pageSize, false);
        PageHelper.orderBy(orderBy);

        return selectList(statementClazz, methodName, parameter);
    }

    public <T> PageInfo<T> selectPageListAndCount(Class<?> statementClazz, String methodName, Object parameter,
                                                  int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<T> list = selectList(statementClazz, methodName, parameter);
        return new PageInfo<>(list);
    }

    public <T> PageInfo<T> selectPageListAndCount(Class<?> statementClazz, String methodName, Object parameter,
                                                  int pageNum, int pageSize, String orderBy) {

        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy(orderBy);
        List<T> list = selectList(statementClazz, methodName, parameter);
        return new PageInfo<>(list);
    }

}
