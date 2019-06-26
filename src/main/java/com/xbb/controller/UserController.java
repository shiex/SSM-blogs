package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.Notice;
import com.xbb.pojo.User;
import com.xbb.service.ArticleService;
import com.xbb.service.NoticeService;
import com.xbb.service.UserService;
import com.xbb.utils.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private RedisTemplate redisTemplate;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @ModelAttribute("ctxPath")
    public String getCtxPath()
    {
        return StatusCode.CONTEXT_PATH;
    }

    /**
     * @description: 用户登录
     * @param u
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/login/verify")
    @ResponseBody
    public Map login(@RequestBody User u, HttpSession session){
        Map<String , Object> map = RestMap.getRestMap();
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            //把用户名和密码封装为UsernamepasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(u.getUsername(),u.getPassword());
            //remember me
            token.setRememberMe(true);
            try{
                //执行登陆
                currentUser.login(token);
            }catch (AuthenticationException ae){
                session.setAttribute("SESSION_USER", null);
                map.put("error", StatusCode.FAILER);
                map.put("reason", "密码错误！");
            }
        }
        return map;
    }

    /**
     * @description: 注册用户
     * @param u
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/register/verify")
    @ResponseBody
    public Map<String, Object> verify(@RequestBody User u)
    {
        Map<String, Object> map = RestMap.getRestMap();
        System.out.println("/register/verify");
        User user = userService.findByUsername(u.getUsername());
        if(user != null)
        {
            map.put("error", StatusCode.FAILER);
            map.put("reason", "该用户已存在!");
            return map;
        }

        // 密码进行MD5盐值加密
        Object usernameSalt = ByteSource.Util.bytes(u.getUsername());
        Object result = new SimpleHash("MD5", u.getPassword(), usernameSalt, 1024);

        user = new User();
        user.setRegister_time(new Date());
        user.setUsername(u.getUsername());
        user.setPassword(result.toString());
        user.setPas(u.getPassword());
        userService.insertUser(user);

        // 生成用户图片存储目录
        String date = sdf.format(new Date());
        String imgsFileUrl = StatusCode.USER_IMGS_ROOT + date + "/" + user.getId();
        userService.upImgsFileUrl(user.getId(),imgsFileUrl);
        File appDir = new File(StatusCode.WEB_FILE_ROOT + imgsFileUrl);
        appDir.mkdirs();

        return map;
    }

    /**
     * @description: 退出登录
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("login.out")
    @ResponseBody
    public Map loginOut(HttpSession session){
        Map<String , Object> map = RestMap.getRestMap();
        session.removeAttribute("SESSION_USER");
        return map;
    }

    /**
     * @description: 返回JS文件，包含当前用户信息
     * @param req
     * @param resp
     * @return: void
     */
    @RequestMapping(value = "user.jsx", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
    public void JsxUser(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        HttpSession session = req.getSession();

        JSONObject data = null;
        try{
            User user = (User) session.getAttribute("SESSION_USER");
            user = userService.queryById(user.getId());
            data = new JSONObject(user);
            data.remove("password");
            data.remove("pas");
        }catch (Exception e){
        }

        String strResp = AxWebUtils.JsxData(data,"user",null);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");
        Writer out = resp.getWriter();
        out.write(strResp);
    }

    /**
     * @description: 获取用户信息以及所发布的所有博客
     * @param userId
     * @param model
     * @return: java.lang.String
     */
    @RequestMapping("/userPage/{userId}.html")
    public String personal(@PathVariable("userId") int userId, Model model)
    {
        User user = userService.queryById(userId);
        model.addAttribute("user", user);
        model.addAttribute("notices", null);    //默认为null
        model.addAttribute("articles", null);
        List<Article> articles = articleService.queryUserArticles(userId); // 查询用户发布的博客列表
        List<Notice> notices = noticeService.queryNotices(userId); // 查询用户发布的公告列表
        for(Notice notice : notices){
            if(notice.getTitle().length() > 8){
                notice.setTitle(notice.getTitle().substring(0, 8) + "...");
            }else {
                notice.setTitle(notice.getTitle() + "...");
            }
        }
        if(articles.size() > 0){
            // 计算出距离发布到现在的时间
            long end = new Date().getTime();
            for(Article article : articles){
                String timeLog = AxDateUtils.timeInterval(article.getIssue_time().getTime(), end);
                article.setPastTime(timeLog);
            }
            model.addAttribute("articles", articles);
        }
        if(notices.size() > 0){
            model.addAttribute("notices", notices);
        }
        return "user_homepage";
    }

    // 跳转到个人页面
    @RequestMapping("/user/index")
    public String userIndex(){
        return "user_index";
    }

    /**
     * @description: 修改个人资料
     * @param user
     * @return: java.util.Map
     */
    @RequestMapping("/user/updata")
    @ResponseBody
    public Map upData(@RequestBody User user){
        Map<String , Object> map = RestMap.getRestMap();
        String imgUrl = userService.queryIsHeadPortrait(user.getId());
        if(!imgUrl.equals("static/img/ph.png")){
            if(!user.getHead_portrait().equals(imgUrl)){
                File imgFile = new File(StatusCode.WEB_FILE_ROOT + imgUrl);
                imgFile.delete();
            }
        }
        userService.updateUserData(user);
        map.put("data", user);
        return map;
    }

    /**
     * @description: 取消修改资料
     * @param imgUrl
     * @return: java.util.Map
     */
    @RequestMapping("/updata.call")
    @ResponseBody
    public Map updataCall(@RequestBody String imgUrl){
        Map<String , Object> map = RestMap.getRestMap();
        // 删除已上传未提交的图片
        imgUrl = imgUrl.substring(1, imgUrl.length() - 1);
        if(imgUrl.startsWith("static") && !imgUrl.equals("static/img/ph.png")){
            File imgFile = new File(StatusCode.WEB_FILE_ROOT + imgUrl);
            imgFile.delete();
        }
        return map;
    }

    /**
     * @description: 用户上传照片，包含头像，主页图，资料图
     * @param multipartFile
     * @param status 图片类型状态码
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping(value = "/user/uploadPhoto/{status}",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map uploadPhoto(@RequestParam("file") MultipartFile multipartFile,
                           @PathVariable("status") int status, HttpSession session){
        Map<String , Object> map = RestMap.getRestMap();
        if(multipartFile != null)
        {
            String realName = multipartFile.getOriginalFilename(); // 原始文件名
            String suffix = AxFileUploadUtils.fileSuffix(realName); // 文件名后缀
            String tmpFileName = AxFileUploadUtils.createTmpFileName(suffix); // 生成保证不重复的临时文件名
            // 判断文件是否为图片类型格式
            if(!StatusCode.IMG_TYPE.contains(suffix)){
                map.put("error", StatusCode.FAILER);
                map.put("reason", "上传失败：请上传格式为[" + StatusCode.IMG_TYPE + "]的图片");
                return map;
            }
            if(multipartFile.getSize() > 20 * 1024 * 1024){
                map.put("error", StatusCode.FAILER);
                map.put("reason","上传失败：图片大小不得超过20MB");
                return map;
            }

            User user = (User) session.getAttribute("SESSION_USER");
            String imgsFileUrl = userService.findByIdImgsFile(user.getId()); // 图片存储父目录路径
            File imgsFileRoot = new File(StatusCode.WEB_FILE_ROOT + imgsFileUrl); // 图片存储父目录
            // 当图片数量大于1700时则新建文件夹
            File[] imgFiles = imgsFileRoot.listFiles();
            if(imgFiles.length > 1700){
                String date = sdf.format(new Date());
                imgsFileUrl = StatusCode.USER_IMGS_ROOT + date + "/" + user.getId();
                userService.upImgsFileUrl(user.getId(),imgsFileUrl);
                imgsFileRoot = new File(StatusCode.WEB_FILE_ROOT + imgsFileUrl);
                imgsFileRoot.mkdirs();
            }
            String imgUrl = imgsFileUrl + "/" + tmpFileName;
            // status状态:0:头像图，1:主页图，2:资料图
            File file = null;
            if(status == 1){
                String themePhoto = userService.queryIsThemePhoto(user.getId());
                if(themePhoto != null){
                    file = new File(StatusCode.WEB_FILE_ROOT + themePhoto);
                    file.delete();
                }
                userService.upImgPhoto(user.getId(), null, imgUrl, null);
            }
            if(status == 2){
                String dataPhoto = userService.queryIsDataPhoto(user.getId());
                if(dataPhoto != null){
                    file = new File(StatusCode.WEB_FILE_ROOT + dataPhoto);
                    file.delete();
                }
                userService.upImgPhoto(user.getId(), null, null, imgUrl);
            }

            Map<String , Object> data = new HashMap<>();
            data.put("imgUrl", imgUrl);
            data.put("status", status);
            map.put("data", data);
            try{
                File tmpFile = new File(imgsFileRoot, tmpFileName);
                multipartFile.transferTo(tmpFile);
            }catch (Exception e){}
        }else {
            map.put("error", StatusCode.FAILER);
            map.put("reason","请选择需要上传的图片!");
        }
        return map;
    }

}
