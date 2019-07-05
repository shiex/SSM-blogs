package com.xbb.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shiex-薛
 * @title: MethodsTakeListener
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\6\27 002722:30
 */
public class MethodsTakeListener implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger("methodsTake");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            String className = method.getBeanType().getName();
            String methodName = method.getMethod().getName();
            long startTime = (long) request.getAttribute("startTime");
            Long endTime = System.currentTimeMillis();
            StringBuilder logs = new StringBuilder();
            logs.append(" ").append(className).append("::").append(methodName);
            long time = endTime - startTime;
            logs.append(" 耗时：").append(time).append("(ms)");
            log.debug(logs.toString());
        }

    }
}
