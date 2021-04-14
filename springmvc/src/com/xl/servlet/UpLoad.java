package com.xl.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UpLoad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        System.out.println("文件上传了");

        ServletInputStream inputStream = req.getInputStream();

        byte[] buffer = new byte[1024000];

        int read = inputStream.read(buffer);

       // System.out.println(new String(buffer, 0, read));*/


        //先判断上传的数据是否是多段数据（只有多端的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(req)) {
            //创建FileItenFactory工厂实现类
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //用于解析上传数据的的工具类ServletFileUpload
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解析上传的数据，得到每一个表单项FileItem
            try {
                List<FileItem> list = upload.parseRequest(req);
                //循环判断，每一个表单项是普通类型还是上传的文件


                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //true 普通表单项
                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        //参数UTF-8，解决乱码问题
                        System.out.println("表单项的value属性值：" + fileItem.getString("UTF-8"));
                    } else {
                        //上传的文件
                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());

                        try {
                            fileItem.write(new File("D:\\" + fileItem.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}
