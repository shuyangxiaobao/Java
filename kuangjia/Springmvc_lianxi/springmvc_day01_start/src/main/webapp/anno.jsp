<%--
  Created by IntelliJ IDEA.
  User: xiaobao
  Date: 2020-08-01
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>anno</title>
</head>
<body>

<a href="/anno/demo1?name=小明">demo1</a>

<br>

<form method="post" action="/anno/demo2">
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交"/><br>
</form>


<a href="/anno/demo3/xiaoming/19">demo3</a>

<a href="/anno/demo4">demo4</a>
<a href="/anno/demo5">demo5</a>


<form method="post" action="/anno/demo6">
    姓名:<input type="text" name="uname"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交"/><br>
</form>

<a href="anno/testSessionAttributes">testSessionAttributes</a>
<a href="anno/getSessionAttributes">getSessionAttributes</a>
<a href="anno/delSessionAttributes">delSessionAttributes</a>

</body>
</html>
