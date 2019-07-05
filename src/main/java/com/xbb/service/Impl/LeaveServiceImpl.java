package com.xbb.service.Impl;

import com.xbb.mapper.LeaveMapper;
import com.xbb.pojo.Leave;
import com.xbb.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: LeaveServiceImpl
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\30 003019:54
 */
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public void add(Leave leave) {
        leaveMapper.add(leave);
    }

    @Override
    public List<Leave> queryLeaveAll(int leaveId) {
        return leaveMapper.queryLeaveAll(leaveId);
    }
}
