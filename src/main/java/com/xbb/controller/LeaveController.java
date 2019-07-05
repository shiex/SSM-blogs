package com.xbb.controller;

import com.xbb.pojo.Leave;
import com.xbb.pojo.User;
import com.xbb.service.LeaveService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Administrator
 * @title: AxLeaveController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\30 003019:44
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {

    private final static String VISITORS_PHOTO = "/static/img/xxx.jpg"; // 游客固定头像
    private final static String VISITORS_NAME = "一个小小小游客"; // 游客固定名称

    @Autowired private LeaveService leaveService;

    /**
     * @description: 以每次结果集末尾留言ID进行分段查询
     * @param id
     * @return: java.util.Map
     */
    @RequestMapping("/init.do")
    public Map queryLeaveList(@RequestBody int id){
        List<Leave> leaves = leaveService.queryLeaveAll(id);
        Leave leave = leaves.get(leaves.size() - 1);

        Map<String , Object> data = new HashMap<>();
        data.put("leaves",leaves);
        data.put("leaveId", leave.getId());

        Map<String , Object> restMap = RestMap.getRestMap();
        restMap.put("data", data);
        return restMap;
    }

    /**
     * @description: 添加留言
     * @param leave
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/add.do")
    public Map add(@RequestBody Leave leave, HttpSession session){
        // 判断是否登录，null为游客身份
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        if(user == null){
            leave.setUserId(1);
            leave.setUsername(VISITORS_NAME);
            leave.setHeadPhoto(VISITORS_PHOTO);
        }else {
            leave.setUserId(user.getId());
            leave.setUsername(user.getUsername());
            leave.setHeadPhoto(user.getHeadPhoto());
        }
        leave.setLeaveTime(new Date());
        leaveService.add(leave);

        // 前端需要的是一个数组
        Map<String , Object> restMap = RestMap.getRestMap();
        restMap.put("data", leave);
        return restMap;
    }
}
