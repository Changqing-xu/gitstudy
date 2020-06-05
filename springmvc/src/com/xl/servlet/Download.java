package com.xl.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:获取要下载的文件名
        String downloadFileName = "2.jpeg";
        //2:读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext context = getServletContext();
        //获取要下载的文件类型
        String mimeType = context.getMimeType("/file/" + downloadFileName);
        System.out.println(mimeType);

        //4:回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //5:还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        /*
         * Content-Disposition :响应头，表示收到的数据怎么处理
         *
         * attachment ：表示附件，表示下载使用
         * filename   ：表示指定下载的文件名
         * */
        resp.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);

        // /斜杠被服务器解析表示地址为http://ip:port/工程名/ 映射 到代码的web目录
        InputStream resourceAsStream = context.getResourceAsStream("/file/" + downloadFileName);
        //获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //3:把下载的文件内容回传给客户端
        //读取输入流中的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);


    }
}
