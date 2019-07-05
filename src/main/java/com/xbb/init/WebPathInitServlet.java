package com.xbb.init;

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
@WebServlet(urlPatterns = "", loadOnStartup = 3) // 随应用启动加载
public class WebPathInitServlet extends HttpServlet {

    /**
     * @description: 初始化加载路径
     * @param config
     * @return: void
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        StatusCode.CONTEXT_PATH = config.getServletContext().getContextPath() + "/"; // contextPath
        StatusCode.WEB_FILE_ROOT = config.getServletContext().getRealPath("/"); // webFileRoot
        GenerateHtml.i.init(new File(StatusCode.WEB_FILE_ROOT)); //  初始化Configuration
    }

}
