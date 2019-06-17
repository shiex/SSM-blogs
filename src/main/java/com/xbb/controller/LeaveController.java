package com.xbb.controller;

import com.xbb.pojo.Leave;
import com.xbb.pojo.User;
import com.xbb.service.LeaveService;
import com.xbb.service.UserService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Administrator
 * @title: AxLeaveController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\30 003019:44
 */
@Controller
@RequestMapping("/ax")
public class LeaveController {

    @Autowired private LeaveService leaveService;
    @Autowired private UserService userService;

    @ModelAttribute("ctxPath")
    public String getCtxPath()
    {
        return StatusCode.CONTEXT_PATH;
    }

    @RequestMapping("/leave.html")
    public String axLeave(){
        return "ax_leave";
    }

    @RequestMapping("/leave.load")
    @ResponseBody
    public Map queryLeaveList(@RequestBody String id){
        Map<String , Object> map = RestMap.getRestMap();
        Map<String , Object> data = new HashMap<>();
        List<Leave> leaves = leaveService.queryLeaveList(Integer.valueOf(id));
        data.put("leaves",leaves);
        if(leaves.size() >= 30){
            Leave leave = leaves.get(leaves.size() - 1);
            data.put("endId", leave.getId());
        }
        map.put("data", data);
        return map;
    }

    @RequestMapping("/leave.add")
    @ResponseBody
    public Map add(@RequestBody Leave leave, HttpSession session){
        Map<String , Object> map = RestMap.getRestMap();
        leave.setLeave_time(new Date());
        leave.setUser_id(1);
        // 若是用户留言则另做处理
        User user = (User) session.getAttribute("SESSION_USER");
        if(user != null){
            leave.setUser_id(user.getId());
        }
        leaveService.add(leave);

        leave = leaveService.getLeaveById(leave.getId());
        List<Leave> leaves = new ArrayList<>();
        leaves.add(leave);
        map.put("data", leaves);
        return map;
    }
}
