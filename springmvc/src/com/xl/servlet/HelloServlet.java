package com.xl.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("我就是构造器方法(●'◡'●)");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("此时此刻我被初始化了(●ˇ∀ˇ●)");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 专门用来处理请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello被访问了，我是service方法O(∩_∩)O");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }

    }

    /**
     *
     */
    public void doGet() {
        System.out.println("get请求");
    }

    public void doPost() {
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("此时我被销毁了/(ㄒoㄒ)/~~");
    }
}
