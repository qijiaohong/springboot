package com.example.intercepter;

import com.example.utils.SEQUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadRenameIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Thread.currentThread().setName(SEQUtil.getSEQNum24());
        return super.preHandle(request, response, handler);
    }
}
