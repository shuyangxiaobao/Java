<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/6
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--  遍历用--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>查询所有的帐户</h3>

    <c:forEach items="${list}" var="account">
        <h1>${account.name}</h1>
    </c:forEach>


</body>
</html>
