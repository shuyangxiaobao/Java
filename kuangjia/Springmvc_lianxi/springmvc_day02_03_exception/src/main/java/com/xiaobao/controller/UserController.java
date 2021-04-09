package com.xiaobao.controller;


import com.xiaobao.exception.SysExcption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception {
        try {
            int i = 1/0;

        }catch (Exception e){
            System.out.println (e);
            throw new SysExcption ( "23423" );
        }

        return "success";

    }
}
