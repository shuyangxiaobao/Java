package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//---------1---------------
// 控制器类
@Controller
@RequestMapping(path="/user")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
//    path 和 value 一样 不写也可以
//    @RequestMapping(value="/hello")
    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }




    /**
     * RequestMapping注解
     * @return
     */
//    method = {RequestMethod.GET } 请求方式
//    headers = {"Accept"} 请求头
//    path  value  请求路径 两个一样
//    params 请求参数
//          params = {"username")
//          params = {"username=heihei"}
    @RequestMapping(value="/testRequestMapping",params = {"username=heihei"},headers = {"Accept"},method =
            {RequestMethod.GET,RequestMethod.POST})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }

}
