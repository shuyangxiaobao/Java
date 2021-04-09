package cn.itcast.web.servlet;

import cn.itcast.service.Impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl ();
        String json = provinceService.findAllJson ();
        System.out.println (json);
        response.setContentType ( "application/json;charset=utf-8" );
        response.getWriter().write ( json );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
