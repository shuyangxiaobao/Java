package cn.itcast.gabTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTestgqb")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ( "text/html;charset=utf-8" );
        Cookie[] cookies = request.getCookies ();
        Boolean exist = false;
        if (cookies != null && cookies.length > 0){
            for (Cookie c: cookies
                 ) {
                String name = c.getName ();
                if ("lastTime2".equals ( name )){
                    exist = true;
                    String oldvalue = c.getValue ();
                    Date date = new Date ();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss");
                    String format = simpleDateFormat.format ( date );
                    PrintWriter writer = response.getWriter ();
                    System.out.println (oldvalue);
                    System.out.println (format);

                    oldvalue = URLDecoder.decode ( oldvalue,"utf-8" );
                    writer.write ( "<h1>您上次访问时间为"+oldvalue+"</h1>" );
                    format = URLEncoder.encode(format,"utf-8");

                    c.setValue ( format );
                    response.addCookie ( c );
                    break;
                }
            }
        }

        if (exist == false){
            Cookie c = new Cookie ( "lastTime2", "2" );
            Date date = new Date ();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss");
            String format = simpleDateFormat.format ( date );
            PrintWriter writer = response.getWriter ();
            writer.write ( "<h1>首次访问</h1>" );
            format = URLEncoder.encode(format,"utf-8");
            c.setValue ( format );
            response.addCookie(c);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
