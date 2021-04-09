package com.xiaobao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping("/demo1")
    public String demo1(){
        System.out.println ("demo1.......");
        return "success";
    }

    @RequestMapping(value = {"/demo2"},params = {"age"},headers = {"Accept"},method = {RequestMethod.GET,RequestMethod.POST})
    public String demo2(){
        System.out.println ("demo2.....");
        return "success";
    }





}




















































