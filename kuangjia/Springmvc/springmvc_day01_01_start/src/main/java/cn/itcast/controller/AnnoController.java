package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */

//---------3---------------
@Controller
@RequestMapping(value = "/anno")
@SessionAttributes(value={"msg","name"})   // 把msg=美美存入到session域对中


public class AnnoController {

//    RequestParam注解
//1. 作用:把请求中的指定名称的参数传递给控制器中的形参赋值 2. 属性
//1. value:请求参数中的名称
//2. required:请求参数中是否必须提供此参数，默认值是true，必须提供
    @RequestMapping("/testRequestParam")
    public String testRequestParam(
            @RequestParam(name="name",required = true) String myname ,
            @RequestParam(name= "age",required = false) String xlpage
    )
    {
        try {
            myname = java.net.URLDecoder.decode(myname,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        }
        System.out.println("执行了111...");
        System.out.println(myname);
        System.out.println(xlpage);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @return
     */

//    2. RequestBody注解
// 1. 作用:用于获取请求体的内容(注意:get方法不可以)
// 2. 属性
//   required:是否必须有请求体，默认值是true
    @RequestMapping( path = "/testRequestBody",produces="text/html;charset=UTF-8")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了222...");
        System.out.println ("body:"+body);
        try {
            //   URLDecode解码问题
            String mytext2 = java.net.URLDecoder.decode(body,"utf-8");
            System.out.println(mytext2);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        }
        return "success";
    }

    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping(value="/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }


    /**
     * HiddentHttpMethodFilter过滤器
     * @return
     */
    @RequestMapping(value="/hiddentHttpMethodFilter",method = {RequestMethod.POST,RequestMethod.PUT})
    public void hiddentHttpMethodFilter(String username){
        System.out.println("hiddentHttpMethodFilter...");
        System.out.println (username);
//        return "success";
    }






    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping(value="/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept") String header, HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("执行了testRequestHeader...");
        System.out.println(header);
        System.out.println(request);
        System.out.println(response);

        // return "success";
        // response.sendRedirect(request.getContextPath()+"/anno/testCookieValue");
        return "redirect:/param.jsp";
    }


    /**
     * 获取Cookie的值
     * @return
     */
    @RequestMapping(value="/testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String cookieValue){
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */

//    1. 作用
//         1. 出现在方法上:表示当前方法会在控制器方法执行前线执行。
//         2. 出现在参数上:获取指定的数据给参数赋值。
//    2. 应用场景
//         1. 当提交表单数据不是完整的实体数据时，保证没有提交的字段使用数据库原来的数据。
    @RequestMapping(value="/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
//        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }

    /**
     * 该方法会先执行

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
     */

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














