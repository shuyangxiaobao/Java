<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../500.jsp"%>


<html>
<head>
    <title>Title</title>
</head>
<body>


${3 > 4}

\${3 > 4}
<hr>

<h3>算数运算符</h3>
${3 + 4}<br>
${3 / 4}<br>
${3 div 4}<br>
${3 % 4}<br>
${3 mod 4}<br>
<h3>比较运算符</h3>
${3 == 4}<br>

<h3>逻辑运算符</h3>
${3 > 4  && 3 < 4}<br>
${3 > 4  and 3 < 4}<br>


<h4>empty运算符345345345354</h4>
<%

    //    String str = "";
//    request.setAttribute("str",str);
//
//    List list = new ArrayList();
//    request.setAttribute("list",list);

%>
${not empty str}



${not empty list}



${not empty list}



<hr/>


<h1 style="color: red; font-size: 40px">下面是我的个人练习</h1>




</body>
</html>
