package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.Programa;
import com.xbb.service.ArticleService;
import com.xbb.service.ProgramaService;
import com.xbb.utils.ArticleDateUtils;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Random;

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
    @Autowired private RedisTemplate<String, Object> redisTemplate;
    public static Random random = new Random();

    @ModelAttribute("ctxPath")
    public String getCtxPath()
    {
        return StatusCode.CONTEXT_PATH;
    }

    // 首页
    @RequestMapping("/index.html")
    public String queryProgramaList(Model model)
    {
        List <Programa> list_programa = programaService.queryProgramaList();
        Programa programa = list_programa.get(0);
        int id = programa.getId();
        List <Article> list_article = articleService.queryArticleList(id);
        List <Article> articles = articleService.queryArticleReferral(id);    // 今日推荐
        if(articles.size() > 0){
            for(Article article : articles){
                if(article.getTitle().length() > 15){
                    int n = random.nextInt(15) + 7;
                    String title = article.getTitle().substring(0,n);
                    article.setTitle(title);
                }
            }
        }
        ArticleDateUtils.setDayTime(list_article); // 计算出距离发布到现在的时间
        model.addAttribute("list_programa",list_programa);
        model.addAttribute("list_article",list_article);
        model.addAttribute("articles",articles);
        model.addAttribute("title", programa.getName());
        return "programa";
    }

    // 发布博客时加载栏目下拉列表select
    @RequestMapping("/load")
    @ResponseBody
    public Map load(){
        Map<String , Object> map = RestMap.getRestMap();
        List <Programa> list_programa = programaService.queryProgramaList();
        map.put("data", list_programa);
        return map;
    }
}
