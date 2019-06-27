package com.xbb.crud;

import java.util.List;

/**
 * @author Administrator
 * @title: CRUDMapper：Mapper增删改查基类
 * @projectName books-shop
 * @description: TODO
 * @date 2019\6\22 002210:10
 *
 * CRUD基类：Mapper须继承此类
 */
public interface CRUDMapper<T> {

    void add(T bean);

    void remove(Integer id);

    void remove(String text);

    void update(T bean);

    void updateText(String text);

    int queryIsExist(Integer id);

    int queryIsExist(String text);

    T qeury(String text);

    T query(Integer id);

    List<T> queryAll();

    List<T> queryAll(Integer id);

    List<T> queryAll(String text);

    void countAdd(Integer id);

    void conutSubtract(Integer id);

}
