package com.xbb.servlet;

import com.xbb.utils.GenerateHtml;
import com.xbb.utils.StatusCode;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.File;

/**
 * @author Administrator
 * @title: WebPathInitServlet
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001715:29
 */
@WebServlet(urlPatterns = "", loadOnStartup = 3)
public class WebPathInitServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        StatusCode.CONTEXT_PATH = config.getServletContext().getContextPath() + "/";
        System.out.println("当前服务部署路径为：" + StatusCode.CONTEXT_PATH);

        // WEB-NIF路径
        StatusCode.WEB_FILE_ROOT = config.getServletContext().getRealPath("/");
        System.out.println("当前项目路径为：" + StatusCode.WEB_FILE_ROOT);

        //  初始化Configuration
        File appDir = new File(StatusCode.WEB_FILE_ROOT);
        GenerateHtml.i.init(appDir);
    }

}
