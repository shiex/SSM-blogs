package com.xbb.crud;

import com.xbb.crud.CRUDMapper;

import java.util.List;

/**
 * @author Administrator
 * @title: CRUDService
 * @projectName books-shop
 * @description: TODO
 * @date 2019\6\21 002120:05
 *
 * service须继承此类
 */
public interface CRUDService<T> {

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

    CRUDMapper getMapper();

}
