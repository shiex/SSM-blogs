package com.xbb.controller;

import com.xbb.service.ArticleService;
import com.xbb.service.ProgramaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author shiex-薛
 * @title: ProgramaControllerTest
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\6\30 003012:36
 */
@RunWith(value = SpringJUnit4ClassRunner.class)//固定写法
@ContextConfiguration(locations  = "classpath:spring/applicationContext.xml") //告诉junit spring的配置文件
public class ProgramaControllerTest {

    static Logger log = LoggerFactory.getLogger(ProgramaControllerTest.class);

    @Resource private ProgramaService programaService;
    @Resource private ArticleService articleService;

    @Test
    public void queryProgramaList() {

    }


}