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

    /**
     * @description: 添加留言
     * @param leave
     * @return: void
     */
    @Override
    public void add(Leave leave) {
        leaveMapper.add(leave);
    }

    /**
     * @description: 查询留言列表
     * @param id
     * @return: java.util.List<com.xbb.pojo.Leave>
     */
    @Override
    public List<Leave> queryLeaveList(Integer id) {
        return leaveMapper.queryLeaveList(id);
    }

    /**
     * @description: 根据留言ID查询留言
     * @param id
     * @return: com.xbb.pojo.Leave
     */
    @Override
    public Leave getLeaveById(Integer id) {
        return leaveMapper.getLeaveById(id);
    }
}
