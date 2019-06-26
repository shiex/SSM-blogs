package com.xbb.shiroRealm;

import com.xbb.pojo.User;
import com.xbb.utils.StatusCode;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.json.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @title: ShiroAjaxFilter
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\22 002218:48
 */
public class ShiroAjaxFilter extends AdviceFilter {

    /**
     * @description: ajax请求访问认证未通过时的处理
     * @param request
     * @param response
     * @return: boolean
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        User user = (User) req.getSession().getAttribute(StatusCode.SESSION_USER);
        if (user == null && !req.getRequestURI().contains("/login.html")) {
            String requestedWith = req.getHeader("X-Requested-With");
            if (requestedWith != null && StringUtils.equals(requestedWith, "XMLHttpRequest")) {
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("application/json");
                JSONObject json = new JSONObject();
                json.put("error", 403);
                json.put("reason","无权访问");
                resp.getWriter().write(json.toString(2));
                return false;
            } else {//不是ajax进行重定向处理
                resp.sendRedirect(StatusCode.CONTEXT_PATH + "login.html");
                return false;
            }
        }
        return true;
    }

}
