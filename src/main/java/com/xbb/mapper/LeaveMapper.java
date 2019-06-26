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

    void add(Leave leave);

    List<Leave> queryLeaveList(Integer id);

    Leave getLeaveById(Integer id);

}
