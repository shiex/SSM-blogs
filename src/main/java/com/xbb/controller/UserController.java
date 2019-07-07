package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.User;
import com.xbb.service.ArticleService;
import com.xbb.service.UserService;
import com.xbb.utils.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: UserController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\13 001319:29
 */

@Controller
public class UserController {

    @Autowired private UserService userService;
    @Autowired private ArticleService articleService;

    /**
     * @description: 用户登录
     * @param u
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public Map login(@RequestBody User u, HttpSession session){
        Map<String , Object> restMap = RestMap.getRestMap();
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(u.getUsername(),u.getPassword());
            token.setRememberMe(true);
            try{
                //执行登陆
                currentUser.login(token);
            }catch (UnknownAccountException e){
                RestMap.setRestMap(restMap, e.getMessage());
            }catch (AuthenticationException e){
                session.removeAttribute(StatusCode.SESSION_USER);
                RestMap.setRestMap(restMap, "密码错误!");
            }
        }
        return restMap;
    }

    /**
     * @description: 用户注册
     * @param user
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/register.do")
    @ResponseBody
    public Map<String, Object> verify(@RequestBody User user)
    {
        Map<String, Object> restMap = RestMap.getRestMap();
        User u = userService.query(0, user.getUsername());
        if(u != null)
        {
            RestMap.setRestMap(restMap, "用户已存在!");
            return restMap;
        }

        user.setRegisterTime(new Date());
        user.setPassword(BlogsUtlis.pswdMD5(user)); // 密码进行MD5盐值加密
        userService.add(user);

        // 生成用户图片存储目录
        String date = AxDateUtils.format(AxDateUtils.SDF_Y2);
        StringBuilder sbr = new StringBuilder(StatusCode.IMGS_ROOT)
                .append(date).append("/").append(user.getId());
        String imgsRoot =  sbr.toString();
        userService.updateImgFileRoot(user.getId(),imgsRoot);
        File appDir = new File(StatusCode.WEB_FILE_ROOT,imgsRoot);
        appDir.mkdirs();

        return restMap;
    }

    /**
     * @description: 返回包含当前用户数据的js文件
     * @param session
     * @param resp
     * @return: void
     */
    @RequestMapping(value = "user.jsx", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
    public void JsxUser(HttpSession session, HttpServletResponse resp) throws IOException
    {
        JSONObject data = null;
        try{
            User user = (User) session.getAttribute(StatusCode.SESSION_USER);
            data = new JSONObject(user);
            data.remove("password");
        }catch (Exception e){
        }
        String strResp = AxWebUtils.JsxData(data,"user",null);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");
        resp.getWriter().write(strResp);
    }

    /**
     * @description: 获取用户信息以及所发布的所有博客
     * @param userId
     * @param model
     * @return: java.lang.String
     */
    @RequestMapping("/u/index/{userId}.html")
    public String personal(@PathVariable("userId") int userId, Model model)
    {
        User user = userService.queryUserArticles(userId);
        BlogsUtlis.setDate(user.getArticleList());
        model.addAttribute("ctxPath", StatusCode.CONTEXT_PATH);
        model.addAttribute("user", user);
        return "uIndex";
    }

    /**
     * @description: 用户管理博客界面初始化加载博客
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("u/article.all")
    @ResponseBody
    public Map articleInit(HttpSession session){
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        Map<String , Object> restMap = RestMap.getRestMap();
        List<Article> articleList = articleService.queryAllUserIssue(user.getId());
        restMap.put("data", articleList);
        return restMap;
    }

    /**
     * @description: 用户编辑资料
     * @param user
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/u/update.do")
    @ResponseBody
    public Map update(@RequestBody User user, HttpSession session){
        User u = (User) session.getAttribute(StatusCode.SESSION_USER);
        String imgUrl = u.getHeadPhoto();
        if(!imgUrl.equals("static/img/ph.png")){
            if(!user.getHeadPhoto().equals(imgUrl)){
                File imgFile = new File(StatusCode.WEB_FILE_ROOT,imgUrl);
                imgFile.delete();
            }
        }
        userService.update(user);
        BlogsUtlis.setSessionUser(user, session); // 更新会话中的user状态
        Map<String , Object> restMap = RestMap.getRestMap();
        restMap.put("data", user);
        return restMap;
    }

    /**
     * @description: 用户取消编辑资料
     * @param imgUrl
     * @return: java.util.Map
     */
    @RequestMapping("/u/update.call")
    @ResponseBody
    public Map updataCall(@RequestBody String imgUrl){
        Map<String , Object> restMap = RestMap.getRestMap();
        // 删除已上传未提交图片
        imgUrl = imgUrl.substring(1, imgUrl.length() - 1);
        if(!imgUrl.equals("static/img/ph.png")){
            File imgFile = new File(StatusCode.WEB_FILE_ROOT, imgUrl);
            imgFile.delete();
        }
        return restMap;
    }

    /**
     * @description: 退出登录
     * @param session
     * @return: java.util.Map
     */
    /*@RequestMapping("/login.out")
    @ResponseBody
    public Map loginOut(HttpSession session){
        Map<String , Object> restMap = RestMap.getRestMap();
        session.removeAttribute(StatusCode.SESSION_USER);
        return restMap;
    }*/

}
