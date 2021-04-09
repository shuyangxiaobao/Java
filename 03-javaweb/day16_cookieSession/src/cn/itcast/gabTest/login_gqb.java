package cn.itcast.gabTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_gqb")
public class login_gqb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String codeStr = (String) request.getSession ().getAttribute ( "checkCode_session" );
        String username = request.getParameter ( "username" );
        String password = request.getParameter ( "password" );
        String checkCode = request.getParameter ( "checkCode" );
        request.removeAttribute ( "checkCode" );
        if (codeStr.equalsIgnoreCase ( checkCode )){
            if ("zhangsan".equals ( username ) && "123".equals ( password )){
                request.setAttribute ("user",username );
                request.getSession ().setAttribute ( "user",username );
                response.sendRedirect ( request.getContextPath ()+"/success.jsp" );

//                request.getRequestDispatcher ( "success.jsp" ).forward ( request,response );

            } else {
//                账号密码错误
                request.setAttribute ( "login_error","账号密码错误-xlp");
                request.getRequestDispatcher ( "login.jsp" ).forward ( request,response );

            }

        } else {
//验证码不一致
            request.setAttribute ( "cc_error","验证码错误啦——gqb" );
            request.getRequestDispatcher ( "login.jsp" ).forward ( request,response );


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
