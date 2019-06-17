package com.xbb.mapper;

import com.xbb.pojo.Leave;

import java.util.List;

/**
 * @author Administrator
 * @title: LeaveMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\30 003019:53
 */
public interface LeaveMapper {
    /*
        添加留言
     */
    void add(Leave leave);

    /*
        查询留言列表
     */
    List<Leave> queryLeaveList(Integer id);

    /*
        根据留言ID查询留言
     */
    Leave getLeaveById(Integer id);

}
