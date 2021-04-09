package cn.itcast.web.download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8"); //有欠缺
                response.setContentType ( "text/html;charset=utf-8" ); //这句最稳
//        以上两句效果相同，都能保证客户端中文正确显示

        request.setCharacterEncoding ( "utf-8" ); //保证服务端中文正确显示
        String name = request.getParameter ( "name" );
        String age = request.getParameter ( "age" );
        PrintWriter out = response.getWriter ();
        out.println ( "name=" + name + "age = " + age );
        System.out.println ( "name:" + name );
        System.out.println ( "age:" + age );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
