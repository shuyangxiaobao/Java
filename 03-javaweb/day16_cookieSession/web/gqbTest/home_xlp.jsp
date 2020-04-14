<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: xiaobao
  Date: 2020-03-23
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        Cookie[] cookies = request.getCookies ();
        Boolean exist = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies
            ) {
                String name = c.getName ();
                if ("lastTime9".equals ( name )) {
                    exist = true;
                    String oldvalue = c.getValue ();
                    Date date = new Date ();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy年MM月dd日 HH:mm:ss" );
                    String format = simpleDateFormat.format ( date );
                    PrintWriter writer = response.getWriter ();
                    System.out.println ( oldvalue );
                    System.out.println ( format );

                    oldvalue = URLDecoder.decode ( oldvalue, "utf-8" );
    %>
    <h1>您上次访问时间为new:<%=oldvalue%>
    </h1>

    <%


                    format = URLEncoder.encode ( format, "utf-8" );

                    c.setValue ( format );
                    response.addCookie ( c );
                    break;
                }
            }
        }

        if (exist == false) {
            Cookie c = new Cookie ( "lastTime9", "2" );
            Date date = new Date ();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy年MM月dd日 HH:mm:ss" );
            String format = simpleDateFormat.format ( date );
            PrintWriter writer = response.getWriter ();
    %>

    <h1>首次访问</h1>
    <%
            format = URLEncoder.encode ( format, "utf-8" );
            c.setValue ( format );
            response.addCookie ( c );

        }

    %>
</head>
<body>

</body>
</html>
