package com.xbb.service;

import com.xbb.pojo.Leave;

import java.util.List;

/**
 * @author Administrator
 * @title: LeaveService
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\30 003019:53
 */
public interface LeaveService {

    void add(Leave leave);

    List<Leave> queryLeaveList(Integer id);

    Leave getLeaveById(Integer id);

}
