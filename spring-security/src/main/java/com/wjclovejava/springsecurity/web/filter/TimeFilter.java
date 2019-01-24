package com.wjclovejava.springsecurity.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: wjc
 * @Description: 过滤器
 * @Date: created in 2019/1/21 14:39
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TimeFilter start");

        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("TimeFilter 耗时:"+(System.currentTimeMillis()-start));
        System.out.println("TimeFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter destroy");
    }
}
