package com.tianma.springboot01_static.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lgc
 * @createDate 2020/4/28 - 17:26
 */
public class LoginHandlerIntercetor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            request.setAttribute("msg","没有权限请先登陆");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        return true;
    }
}
