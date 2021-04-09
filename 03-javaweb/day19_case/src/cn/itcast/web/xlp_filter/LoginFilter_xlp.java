package cn.itcast.web.xlp_filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter_xlp implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI ();
        if (uri.contains ( "/login.jsp" ) ||
                uri.contains ( "/loginServlet" ) ||
                uri.contains ( "/checkCodeServlet" ) ||
                uri.contains ( "/css/" ) ||
                uri.contains ( "/fonts/" ) ||
                uri.contains ( "/js/" )) {
            chain.doFilter ( req, resp );
        } else {
            Object user = request.getSession ().getAttribute ( "user" );
            if (user == null){
               request.setAttribute ( "login_msg" ,"尚未登录--34567");
               request.getRequestDispatcher ( "/login.jsp" ).forward ( req,resp );
            } else {
//               已经登录
                chain.doFilter ( req, resp );
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
