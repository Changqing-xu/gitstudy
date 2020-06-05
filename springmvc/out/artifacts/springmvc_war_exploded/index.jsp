<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Springmvc</title>
</head>
<body>
<%--multipart/form-data 表示提交的数据以多段（每一个表单项一个数据段）的形式进行拼接，然后以二进制流的形式发送给服务器--%>
<form action="http://localhost:8080/up" method="post" enctype="multipart/form-data">
    用户名: <input type="text" name="username"/> <br>
    头像: <input type="file" name="photo"> <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
