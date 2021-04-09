<%--
  Created by IntelliJ IDEA.
  User: xiaobao
  Date: 2020-06-22
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>上传文件</div>

<form action="UploadServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="submit" value="submit">
</form>


</body>
</html>
