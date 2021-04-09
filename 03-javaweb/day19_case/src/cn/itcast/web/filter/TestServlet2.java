package cn.itcast.web.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/testServlet2")
public class TestServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String msg = request.getParameter("msg");
//        System.out.println(name+":"+msg);

        System.out.println ("😄😄😄😄😄😄😄😄😄😄😄");
        Map<String, String[]> parameterMap = request.getParameterMap ();
        String name1 = parameterMap.get ( "name" )[0];
        System.out.println ("name1="+name1);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
