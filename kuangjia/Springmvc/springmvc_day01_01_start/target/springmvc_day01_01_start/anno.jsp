<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--常用的注解--%>

    <a href="anno/testRequestParam?name=小明">testRequestParam</a>

    <br>
<h2>testRequestBody</h2>
    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />



    </form>

    <a href="anno/testPathVariable/10">testPathVariable</a>

    <br>

    <div>hiddentHttpMethodFilter 过滤器</div>
    <!-- 更新 -->
    <form action="anno/hiddentHttpMethodFilter" method="post">
        用户名称：<input type="text" name="username"><br/>
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="更新">
    </form>


    <a href="anno/testRequestHeader">RequestHeader</a>

    <br>

    <a href="anno/testCookieValue">CookieValue</a>

    <br>

    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <br>


    <a href="anno/testSessionAttributes">testSessionAttributes</a>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>


</body>
</html>
