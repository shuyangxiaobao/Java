<%--
  Created by IntelliJ IDEA.
  User: fqy
  Date: 2018/6/6
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <script>

    function call() {
      alert("1");
      js.callJs();
    }
  </script>

  <body>


  <%
//  Cookie[] cookies = request.getCookies ();
//  if (cookies != null){
//    for (Cookie cookie : cookies){
//      if (cookie.getValue () != null && !"".equals (cookie.getValue ())){
//        response.sendRedirect ( "welcome.jsp" );
//      }
//    }
//  }


  %>

  <%--<form action="MyServlet" method="post">--%>
    <%--name:<input type="text" name="name">--%>
    <%--age:<input type="text" name="age">--%>

    <%--<input type="submit" value="提交">--%>

  <%--</form>--%>

  calljava<input type="button" value="calljava" onclick="call()">

  <a href="http://192.168.0.102:8082/welcome.jsp?start">自定义协议</a>

  </body>
</html>
