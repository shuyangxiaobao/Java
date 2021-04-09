package com.xiaobao.controller;

import com.xiaobao.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/testString")
    public String testString(Model model) {
        User user = new User ( "小明", "1234567", "18" );
        model.addAttribute ( "user", user );
        return "success";
    }

    @RequestMapping(value = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) {
        System.out.println ( "testVoid执行了........." );
//        转发
//        try {
//            request.getRequestDispatcher ( "/WEB-INF/pages/success.jsp" ).forward ( request,response );
//        } catch (ServletException e) {
//            e.printStackTrace ();
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }

//        重定向
//        try {
//            response.sendRedirect ( request.getContextPath () + "/response.jsp" );
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }

        // 设置中文乱码
        response.setCharacterEncoding ( "UTF-8" );
        response.setContentType ( "text/html;charset=utf-8" );

//        直接进行响应
        try {
            response.getWriter ().println ( "你好哈12345678asdfghjkl" );
        } catch (IOException e) {
            e.printStackTrace ();
        }


    }

    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView ();
        User user = new User ( "吊胆", "345678", "90" );
        modelAndView.addObject ( "user", user );
        modelAndView.setViewName ( "success" );
        return modelAndView;
    }


    //    使用关键字 进行转发和重定向
    @RequestMapping(value = "/testForwardOrRedirect")
    public String testForwardOrRedirect() {


//        转发
//        return "forward:/WEB-INF/pages/success.jsp";


//        重定向
        return "redirect:/response.jsp"; // ok
    }


//    @RequestMapping(value = "/testajax")
//    public void testajax(@RequestBody String body) {
//        System.out.println (body);
//
//    }


    @RequestMapping(value = "/testajax")
    public @ResponseBody
    User testajax(@RequestBody User user) {
        System.out.println ( user );
        user.setUsername ( "戈强宝" );
        return user;
    }


}
