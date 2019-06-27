package com.xbb.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: CRUDServiceImpl
 * @projectName books-shop
 * @description: TODO
 * @date 2019\6\21 002120:04
 *
 * ServiceImpl须继承此类
 */
@Service("crudService")
public abstract class CRUDServiceImpl<T> implements CRUDService<T> {

    private Logger logger = LoggerFactory.getLogger(CRUDServiceImpl.class);

    protected CRUDMapper crudMapper;

    /**
     * @description: 子类须重写此方法返回对应mapper
     */
    @Override
    public abstract CRUDMapper getMapper();

    /**
     * @description: 加载对应mapper
     * @param
     * @return: void
     */
    private synchronized void initCrudMapper(){
        try{
            if(crudMapper == null){
                crudMapper = getMapper();
                logger.debug("当前执行mapper --- [" + crudMapper.toString() +"]");
            }
        }catch (Exception e){
            logger.warn(e.getMessage());
        }finally {
            if(crudMapper == null){
                crudMapper = getMapper();
            }
        }
    }

    /**
     * @description: 添加
     * @param bean
     * @return: void
     */
    @Override
    public void add(T bean) {
        initCrudMapper();
        crudMapper.add(bean);
    }

    /**
     * @description: 根据ID删除
     * @param id
     * @return: void
     */
    @Override
    public void remove(Integer id) {
        initCrudMapper();
        crudMapper.remove(id);
    }

    /**
     * @description: 根据文本删除
     * @param text
     * @return: void
     */
    @Override
    public void remove(String text) {
        initCrudMapper();
        crudMapper.remove(text);
    }

    /**
     * @description: 修改Bean
     * @param bean
     * @return: void
     */
    @Override
    public void update(T bean) {
        initCrudMapper();
        crudMapper.update(bean);
    }

    /**
     * @description: 修改文本字段
     * @param text
     * @return: void
     */
    @Override
    public void updateText(String text) {
        initCrudMapper();
        crudMapper.updateText(text);
    }

    /**
     * @description: 根据ID查询是否存在此列
     * @param id
     * @return: int 【0：不存在，1：存在】
     */
    @Override
    public int queryIsExist(Integer id) {
        initCrudMapper();
        return crudMapper.queryIsExist(id);
    }

    /**
     * @description: 根据文本查询是否存在此列
     * @param text
     * @return: int【0：不存在，1：存在】
     */
    @Override
    public int queryIsExist(String text) {
        initCrudMapper();
        return crudMapper.queryIsExist(text);
    }

    /**
     * @description: 根据文本查询Bean
     * @param text
     * @return: T
     */
    @Override
    public T qeury(String text) {
        initCrudMapper();
        return (T) crudMapper.qeury(text);
    }

    /**
     * @description: 根本ID查询Bean
     * @param id
     * @return: T
     */
    @Override
    public T query(Integer id) {
        initCrudMapper();
        return (T) crudMapper.query(id);
    }

    /**
     * @description: 查询List<Bean>
     * @param
     * @return: java.util.List<T>
     */
    @Override
    public List<T> queryAll() {
        initCrudMapper();
        return crudMapper.queryAll();
    }

    /**
     * @description: 根据ID查询List<Bean>
     * @param id
     * @return: java.util.List<T>
     */
    @Override
    public List<T> queryAll(Integer id) {
        initCrudMapper();
        return crudMapper.queryAll(id);
    }

    /**
     * @description: 根据文本查询List<Bean>
     * @param text
     * @return: java.util.List<T>
     */
    @Override
    public List<T> queryAll(String text) {
        initCrudMapper();
        return crudMapper.queryAll(text);
    }

    /**
     * @description: 根据ID指定值递增
     * @param id
     * @return: void
     */
    @Override
    public void countAdd(Integer id) {
        initCrudMapper();
        crudMapper.countAdd(id);
    }

    /**
     * @description: 根据ID指定值递减
     * @param id
     * @return: void
     */
    @Override
    public void conutSubtract(Integer id) {
        initCrudMapper();
        crudMapper.conutSubtract(id);
    }

}
