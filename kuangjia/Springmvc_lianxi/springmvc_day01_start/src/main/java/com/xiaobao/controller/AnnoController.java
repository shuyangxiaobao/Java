package com.xiaobao.controller;

//import com.sun.deploy.net.HttpResponse;
import com.xiaobao.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping(value = "/anno")
@SessionAttributes(value={"msg","name"})   // 把msg=美美存入到session域对中

public class AnnoController {


    @RequestMapping(value = "/demo1")
    public String demo1(@RequestParam(name = "name", required = true) String name,
                        @RequestParam(name = "age", required = false) String age) {
        System.out.println ("name:"+name);
        System.out.println ("age:"+age);
        return "success";
    }


    /**
     * 获取请求体内容(只能是post请求)
     * @return
     */
    @RequestMapping(value = "/demo2")
    public String dmeo2(@RequestBody String body){
        try {
            body = java.net.URLDecoder.decode(body,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        }
        System.out.println (body);
        return "success";
    }



    @RequestMapping(value = "/demo3/{sid}/{sid2}")
    public String demo3(@PathVariable(name = "sid") String sid, @PathVariable(name = "sid2") String sid2){
        System.out.println (sid);
        System.out.println (sid2);
        return "success";
    }


    /**
     * 获取请求头的值
     * @param header
     * @param language
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/demo4")
    public String demo4(@RequestHeader(value = "Accept") String header,
                        @RequestHeader(value = "Accept-Language") String language,
                        @RequestHeader(value = "Cookie") String cookie,
                        HttpServletRequest request,
                        HttpServletResponse response){
        System.out.println (header);
        System.out.println (language);
        System.out.println (cookie);
        System.out.println (request);
        System.out.println (response);
        return "success";
    }


    @RequestMapping(value = "/demo5")
    public String demo4(@CookieValue(value = "JSESSIONID") String cookie,
                        HttpServletRequest request,
                        HttpServletResponse response){

        System.out.println (cookie);
        System.out.println (request);
        System.out.println (response);
        return "success";
}



//@RequestMapping(value = "/demo6")
//    public String demo6(User user){
//        System.out.println (user);
//        return "success";
//    }

//    @ModelAttribute
//    public User initUser(){
//        User user = new User ();
//        user.setDate ( new Date (  ) );
//        return user;
//    }


    @RequestMapping(value = "/demo6")
    public String demo7(@ModelAttribute(value = "value") User user){
        System.out.println (user);
        return "success";
    }

    @ModelAttribute
    public void initUser(Map<String,User> map){
        User user = new User ();
        user.setDate ( new Date (  ) );
        map.put ( "value",user );
    }



    /**
     * SessionAttributes的注解
     * @return
     */
//    1. 作用:用于多次执行控制器方法间的参数共享    //用于数据共享
//    2. 属性
//          1. value:指定存入属性的名称
    @RequestMapping(value="/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中
        model.addAttribute("msg","我是message");
        model.addAttribute("name","我是name");

        return "success";
    }



    /**
     * 从session域获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }


    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value="/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("getSessionAttributes...");
        status.setComplete();
        return "success";
    }








}
