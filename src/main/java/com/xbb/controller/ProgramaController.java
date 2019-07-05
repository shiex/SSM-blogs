package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.Programa;
import com.xbb.service.ArticleService;
import com.xbb.service.ProgramaService;
import com.xbb.utils.BlogsUtlis;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        List <Programa> programaList = programaService.queryAll(); // 博客分类列表
        Programa programa = programaList.get(0);
        int id = programa.getId();
        List <Article> articleList = articleService.queryAll();   // 首页博客列表
        List <Article> articleReferral = BlogsUtlis.extractHot(articleList, 15); // 首页推荐博客
        BlogsUtlis.setDate(articleList); // 计算出距离发布博客到目前的时差

        model.addAttribute("programaList",programaList);
        model.addAttribute("articleList",articleList);
        model.addAttribute("articleReferral",articleReferral);
        model.addAttribute("title", "首页");
        return "programa";
    }

    /**
     * @description: 根据分类ID加载对应页面
     * @param id
     * @param model
     * @return: java.lang.String
     */
    @RequestMapping("/p/{id}.html")
    public String queryArticles(@PathVariable("id")int id, Model model)
    {
        List <Programa> programaList = programaService.queryArticles(id);    // 博客分类列表
        int index = 0;
        for(Programa programa : programaList){
            if(programa.getId() == id){
                model.addAttribute("title", programa.getName());
                break;
            }
            index += 1;
        }

        List <Article> articleList = programaList.get(index).getArticleList();   // 分类博客列表
        List <Article> articleReferral = BlogsUtlis.extractHot(articleList, 10); // 分类推荐列表
        BlogsUtlis.setDate(articleList); // 计算发布博客时差

        model.addAttribute("programaList",programaList);
        model.addAttribute("articleList", articleList);
        model.addAttribute("articleReferral",articleReferral);
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
        List <Programa> programaList = programaService.queryAll();
        Map<String , Object> restMap = RestMap.getRestMap();
        restMap.put("data", programaList);
        return restMap;
    }
}
