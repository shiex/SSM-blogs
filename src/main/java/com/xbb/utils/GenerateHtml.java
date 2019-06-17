package com.xbb.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;

/**
 * @author Administrator
 * @title: GenerateHtml
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\10 001016:39
 */
public class GenerateHtml {

    public static GenerateHtml i = new GenerateHtml();  // 全局实例

    protected Configuration frmkConfig;
    protected File appDir;

    public synchronized void init(File appDir)
    {
        if(this.appDir != null) return;  //只加载一次
        this.appDir = appDir;
        try{
            frmkConfig = new Configuration(Configuration.VERSION_2_3_28);
            frmkConfig.setDirectoryForTemplateLoading(appDir); // 设置模板根目录
            frmkConfig.setDefaultEncoding("UTF-8");
            frmkConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            frmkConfig.setLogTemplateExceptions(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
        template：模板文件路径
        model：数据源
        htmlPath：页面存储位置
     */
    public String GenHtml(String template, Object model, String htmlPath)throws Exception
    {
        if(appDir == null) throw new Exception("init()初始化启动失败!");

        File htmlFile = new File(appDir, htmlPath);
        FileOutputStream fileOut = new FileOutputStream(htmlFile);
        OutputStreamWriter out = new OutputStreamWriter(fileOut, "UTF-8");
       try{
           Template tp = frmkConfig.getTemplate(template);
           if(tp == null) throw new Exception("404：模板路径不存在!");
           tp.process(model, out);

       }finally {
           // 确保文件句柄被关闭
           try{ out.close(); }catch (Exception e){ }
       }
       return null;
    }

}
