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

    /**
     * @description: 添加留言
     * @param leave
     * @return: void
     */
    void add(Leave leave);

    /**
     * @description: 根据留言ID加载后30条留言
     * @param leaveId
     * @return: java.util.List<com.xbb.pojo.Leave>
     */
    List<Leave> queryLeaveAll(int leaveId);
}
