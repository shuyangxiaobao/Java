package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 请求参数绑定
 */

//---------2---------------

@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了111...");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @return
     */
//    get请求不会出现中文问题，post 请求会出现中文乱码问题 需要在web.xml里面配置
    @RequestMapping(path = "/saveAccount",method = {RequestMethod.GET,RequestMethod.POST})
    public String saveAccount(Account account){
        System.out.println("执行了222...");
        System.out.println(account);
        return "success";
    }


    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
//    @RequestMapping("/saveUser")
    @RequestMapping(path = "/saveUser",method = {RequestMethod.GET,RequestMethod.POST})
    public String saveUser(User user){
        System.out.println("执行了333...");
        System.out.println(user);
        return "success";
    }

    /**
     * 原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了444...");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session.toString ());
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }
}
