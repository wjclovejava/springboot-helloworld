package com.wjclovejava.springsecurity.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wjc
 * @Description:  拦截器
 * @Date: created in 2019/1/21 14:56
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     * 方法调用之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        Long start=System.currentTimeMillis();
        request.setAttribute("startTime", start);
        return true;
    }

    /**
     * 方法调用之后 (抛出异常则不调用)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long start =(Long)request.getAttribute("startTime");
        System.out.println("TimeInterceptor 耗时:" +(System.currentTimeMillis()-start));
    }

    /**
     * 方法调用之后(不管是否抛出异常)
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        Long start =(Long)request.getAttribute("startTime");
        System.out.println("TimeInterceptor 耗时:" +(System.currentTimeMillis()-start));
        System.out.println("ex:"+ex);
    }
}
