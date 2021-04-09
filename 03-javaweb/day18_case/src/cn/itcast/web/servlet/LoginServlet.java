package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.test ( request,response);
        return;
//        //1.设置编码
//        request.setCharacterEncoding("utf-8");
//
//        //2.获取数据
//        //2.1获取用户填写验证码
//        String verifycode = request.getParameter("verifycode");
//
//        //3.验证码校验
//        HttpSession session = request.getSession();
//        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
//        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
//        if(!checkcode_server.equalsIgnoreCase(verifycode)){
//            //验证码不正确
//            //提示信息
//            request.setAttribute("login_msg","验证码错误！");
//            //跳转登录页面
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//
//            return;
//        }
//
//        Map<String, String[]> map = request.getParameterMap();
//        //4.封装User对象
//        User user = new User();
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//
//        //5.调用Service查询
//        UserService service = new UserServiceImpl();
//        User loginUser = service.login(user);
//        //6.判断是否登录成功
//        if(loginUser != null){
//            //登录成功
//            //将用户存入session
//            session.setAttribute("user",loginUser);
//            //跳转页面
//            response.sendRedirect(request.getContextPath()+"/index.jsp");
//        }else{
//            //登录失败
//            //提示信息
//            request.setAttribute("login_msg","用户名或密码错误！");
//            //跳转登录页面
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//
//        }




    }


    private void test(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding ( "utf-8" );
        String verifycode = request.getParameter ( "verifycode" );
        String checkcode_server = (String)request.getSession ().getAttribute ( "CHECKCODE_SERVER" );
        if (checkcode_server.equalsIgnoreCase ( verifycode )){
            Map<String, String[]> parameterMap = request.getParameterMap ();
            User user = new User ();
            try {
                BeanUtils.populate ( user,parameterMap );
            } catch (IllegalAccessException e) {
                e.printStackTrace ();
            } catch (InvocationTargetException e) {
                e.printStackTrace ();
            }
            UserServiceImpl userServiceImpl = new UserServiceImpl ();
            User login = userServiceImpl.login ( user );
            if (login == null){
                request.setAttribute ( "login_msg","账号或密码错误😄" );
                request.getRequestDispatcher ( "/login.jsp" ).forward ( request,response );
            } else {
                request.setAttribute ( "user",login );
                request.getRequestDispatcher ( "/index.jsp" ).forward ( request,response );
            }
            request.getRequestDispatcher ("/login.jsp").forward ( request,response);

        } else {
            request.setAttribute ( "login_msg","验证码错误😄" );
            request.getRequestDispatcher ("/login.jsp").forward ( request,response);
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
