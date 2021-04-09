package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService完成查询
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter ( "name" );
        String sex = request.getParameter ( "sex" );
        String age = request.getParameter ( "age" );
        String address = request.getParameter ( "address" );
        String qq = request.getParameter ( "qq" );
        String email = request.getParameter ( "email" );

        User user = new User ();
        user.setName ( name );
        user.setGender ( sex );
        user.setAge ( Integer.parseInt ( age ) );
        user.setAddress ( address );
        user.setQq ( qq );
        user.setEmail ( email );

        UserService service = new UserServiceImpl ();
        service.add ( user );
        System.out.println (user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
