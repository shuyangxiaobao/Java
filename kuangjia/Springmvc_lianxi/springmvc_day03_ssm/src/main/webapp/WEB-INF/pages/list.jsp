<%--
  Created by IntelliJ IDEA.
  User: xiaobao
  Date: 2020-08-12
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>查询所有的账户</h3>

<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>

</body>
</html>
