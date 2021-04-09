package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1........");

//       重定向
        //1：方式1
      /**  System.out.println ("111111"+request.getContextPath ());
        response.setStatus ( 302 );//1。设置状态码为302
        response.setHeader ( "location",request.getContextPath ()+"/responseDemo2" ); //2.设置响应头location
        request.setAttribute ( "msg","response" );
       **/

//        方式2
//        response.sendRedirect ( request.getContextPath ()+"/responseDemo2" );
//        request.setAttribute ( "msg","response" );

        String userAgent = request.getHeader("user-agent");
        if (userAgent.contains ( "iPhone" )){
            response.sendRedirect ( "http://www.baidu.com" );
        } else {
            response.sendRedirect ( "http://www.taobao.com" );
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
