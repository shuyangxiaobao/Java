package cn.itcast.web.download;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UploadServlet")
@MultipartConfig(location = "/Users/xiaobao/Desktop/000")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println ("222222222");

        Part part = request.getPart ( "file" );
        part.write ( "shangchuan_tupian.jpg" );
        response.setCharacterEncoding ( "utf-8" );
        PrintWriter writer = response.getWriter ();
        writer.print ( "upload success" );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println ("1111111111111");
        this.doPost ( request, response );
    }


    public UploadServlet() {

    }
}



