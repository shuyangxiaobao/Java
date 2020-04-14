<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>


    <%
        //在域中存储数据
        session.setAttribute("name","李四");

        request.setAttribute("name","张三");
        session.setAttribute("age","23");

        request.setAttribute("str","");

        request.setAttribute ( "xlp","huxu" );



    %>

<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.haha}

${name}
${sessionScope.name}

<h3 style="color: #ff0000; font-size: 49px">${requestScope.xlp}</h3>




</body>
</html>
