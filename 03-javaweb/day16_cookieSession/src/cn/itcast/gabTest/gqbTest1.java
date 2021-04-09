package cn.itcast.gabTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gqbTest1")
public class gqbTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie ( "xlp", "huxu1" );
        cookie.setMaxAge ( 0 );
        response.addCookie (cookie);

        Cookie cookie2 = new Cookie ( "JSESSIONID", "huxue2" );
        cookie2.setMaxAge (0);
        response.addCookie (cookie2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
