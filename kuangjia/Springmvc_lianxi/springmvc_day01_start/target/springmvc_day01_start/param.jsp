<%--
  Created by IntelliJ IDEA.
  User: xiaobao
  Date: 2020-07-29
  Time: 06:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/param/param1?account=xiaoming&password=123456">param1</a>
<br>

<h2 style="color:#ff0000;font-size: 18px">把数据封装Account类中</h2>

<form action="/param/param2" method="post">
   姓名： <input type="text" name="username"/><br>
    密码：<input type="text" name="password"/><br>
    金额：<input type="text" name="money"/><br>

    用户姓名<input type="text" name="list[0].uname"><br>
    用户年龄<input type="text" name="list[0].age"><br>
    用户年龄<input type="text" name="list[0].date"><br>

    map用户姓名<input type="text" name="map['key'].uname"><br>
    map用户年龄<input type="text" name="map['key'].age"><br>


    <input type="submit" value="提交"/>
</form>


<a href="/param/parm3">servlet原生api</a>


</body>
</html>
