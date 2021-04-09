<%--
  Created by IntelliJ IDEA.
  User: xiaobao
  Date: 2020-08-04
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>springmvc 文件上传</h3>

<form action="user/fileupload2" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"/><br>

    <input type="submit" value="提交"/><br>

</form>


<h3>springmvc 跨服务器文件上传</h3>

<form action="user/fileupload3" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload"/><br>

    <input type="submit" value="提交"/><br>

</form>


<a href="user/test">test</a>



</body>
</html>
