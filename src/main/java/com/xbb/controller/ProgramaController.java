package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.Programa;
import com.xbb.service.ArticleService;
import com.xbb.service.ProgramaService;
import com.xbb.utils.ArticleUtlis;
import com.xbb.utils.AxDateUtils;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @title: 加载首页信息
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000920:04
 */
@Controller
public class ProgramaController {

    @Autowired private ProgramaService programaService;
    @Autowired private ArticleService articleService;

    @ModelAttribute("ctxPath")
    public String getCtxPath()
    {
        return StatusCode.CONTEXT_PATH;
    }

    /**
     * @description: 首页
     * @param model
     * @return: java.lang.String
     */
    @RequestMapping("/index.html")
    public String queryProgramaList(Model model)
    {
        List <Programa> list_programa = programaService.queryProgramaList();
        Programa programa = list_programa.get(0);
        int id = programa.getId();
        List <Article> list_article = articleService.queryArticleList(id);  // 首页博客
        List <Article> articles = articleService.queryArticleReferral(id);  // 今日推荐

        ArticleUtlis.setTitle(articles);  // 今日推荐标题字数不得超过22

        // 计算出距离发布到现在的时间
        long end = new Date().getTime();
        for(Article article : list_article){
            String timeLog = AxDateUtils.timeInterval(article.getIssue_time().getTime(), end);
            article.setPastTime(timeLog);
        }

        model.addAttribute("list_programa",list_programa);
        model.addAttribute("list_article",list_article);
        model.addAttribute("articles",articles);
        model.addAttribute("title", programa.getName());

        return "programa";
    }

    /**
     * @description: 发布博客时加载栏目下拉列表select
     * @param
     * @return: java.util.Map
     */
    @RequestMapping("/load")
    @ResponseBody
    public Map load(){
        Map<String , Object> map = RestMap.getRestMap();
        List <Programa> list_programa = programaService.queryProgramaList();
        map.put("data", list_programa);
        return map;
    }
}
