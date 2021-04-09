package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器快速入门程序
 */
//@WebFilter("/*")//访问所有资源之前，都会执行该过滤器



    @WebFilter("/*")
//    @WebFilter("/user/*")
//    @WebFilter("/index.jsp")
//    @WebFilter("*.jsp")

public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo1被执行了....");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println (request.getRequestURI ()); //  /day19/

        System.out.println (request.getRequestURL ()); //   http://localhost:8080/day19/



        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("filterDemo1回来了...");

    }

    @Override
    public void destroy() {

    }
}
