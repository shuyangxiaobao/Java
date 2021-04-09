package com.xiaobao.controller;


import com.xiaobao.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/param")
public class PararmController {
    @RequestMapping(value = "param1")
    public String param1(String account,String password){
        System.out.println ("param1.........");
        System.out.println (account+":"+password);
        return "success";

    }

    @RequestMapping(value = "param2",method = {RequestMethod.GET,RequestMethod.POST})
    public String param2(Account account){
        System.out.println ("param2.........");
        System.out.println (account);
        return "success";
    }

    @RequestMapping(value = "parm3")
    public String param3(HttpServletRequest request, HttpServletResponse response){
        System.out.println ("param3.............");
        System.out.println (request);
        System.out.println (response);
        HttpSession session = request.getSession();





        return "success";
    }



}
