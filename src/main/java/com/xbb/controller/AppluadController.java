package com.xbb.controller;

import com.xbb.pojo.Appluad;
import com.xbb.pojo.User;
import com.xbb.service.AppluadService;
import com.xbb.service.CommentService;
import com.xbb.utils.RestMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Administrator
 * @title: AppluadController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\7 000715:42
 */
@RestController
public class AppluadController {

    @Autowired
    private AppluadService appluadService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("appluad.add")
    public Map add(@RequestBody Appluad appluad, HttpSession session){
        User user = (User) session.getAttribute("SESSION_USER");
        // 判断是否存在点赞行为，存在则修改
        Appluad isAppluad = appluadService.queryIsAppluad(appluad.getComment_id(), user.getId());
        if(isAppluad == null){
            appluad.setUser_id(user.getId());
            appluad.setStatus(true);
            appluadService.add(appluad);
            commentService.appluadCountPlus(appluad.getComment_id());
        }else{
            appluadService.upAppluadStatus(isAppluad.getComment_id(), user.getId(), !isAppluad.getStatus());
            // 为1则递增，反之递减（评论对应的点赞数）
            if(isAppluad.getStatus()){
                commentService.appluadCountMinus(isAppluad.getComment_id());
            }
            else {
                commentService.appluadCountPlus(isAppluad.getComment_id());
            }
        }

        Map<String , Object> map = RestMap.getRestMap();
        return map;
    }

    /*@RequestMapping("appluad.all")
    public Map findList(@RequestBody String articleId,HttpSession session) {
        Map<String , Object> map = RestMap.getRestMap();
        Integer article_id = Integer.valueOf(articleId);
        List<Integer> appluadCounts = appluadService.findAppluadCount(article_id);
        map.put("data", appluadCounts);
        return map;
    }

    @RequestMapping(value = "appluad.jsx", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
    public void JsxUser(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        HttpSession session = req.getSession();
        Object data = null;
        try{
            User user = (User) session.getAttribute("SESSION_USER");
            Integer article_id = Integer.valueOf(req.getParameter("id"));
            System.out.println(article_id);
            List<Appluad> list_appluad = appluadService.findUserAppluad(user.getId(), article_id);
            data = new JSONArray(list_appluad);
        }catch (Exception e){
        }

        String strResp = AxWebUtils.JsxData(data,"userAppluad",null);
        System.out.println(strResp);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");
        Writer out = resp.getWriter();
        out.write(strResp);
    }*/
}
