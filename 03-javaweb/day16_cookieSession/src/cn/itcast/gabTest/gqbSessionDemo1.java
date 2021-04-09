package cn.itcast.gabTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/gqbSessionDemo1")
public class gqbSessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession ();
        session.setAttribute ( "session1","wokao山东" );
        System.out.println (session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}


//org.apache.catalina.session.StandardSessionFacade@1ee3da87
//org.apache.catalina.session.StandardSessionFacade@1ee3da87