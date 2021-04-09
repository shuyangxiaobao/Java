package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法

        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance ( req.getClass ().getClassLoader (), req.getClass ().getInterfaces (), new InvocationHandler () {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName ().equals ( "getParameter" )) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke ( req, args );
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains ( str )) {
                                value = value.replaceAll ( str, "***" );
                            }
                        }
                    }

                    return value;
                } else if (method.getName ().equals ( "getParameterMap" )) {
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke ( req, args );
                    System.out.println ( map.keySet () );
                    Set<String> keySet = map.keySet ();
                    Map<String, String[]> map1 = new HashMap<> (  );

                    for (String key : keySet) {
                        String value = map.get ( key )[0];
                        for (String word : list) {
                            if (value.contains ( word )) {
                                System.out.println ("old:"+value);
                                value =  value.replaceAll ( word, "++" );
                                System.out.println ("new:"+value);

                            }
                        }
                        System.out.println ( key + "🍺🍺🍺🍺🍺🍺" + value );
                        map1.put ( key, new String[]{value} );

                    }

                    if (map1 != null && map1.keySet () != null && map1.keySet ().size () > 0) {
                        for (String key : map1.keySet ()) {
//                            System.out.println ( key + ":" + map1.get ( key )[0] );
                        }
                    }
//                    System.out.println (map);
//                    System.out.println (map2);

                    return map1;
                }


                //判断方法名是否是 getParameterMap

                //判断方法名是否是 getParameterValue

                return method.invoke ( req, args );
            }
        } );

        //2.放行
        chain.doFilter ( proxy_req, resp );
    }

    private List<String> list = new ArrayList<String> ();//敏感词汇集合

    public void init(FilterConfig config) throws ServletException {

        try {
            //1.获取文件真实路径
            ServletContext servletContext = config.getServletContext ();
            String realPath = servletContext.getRealPath ( "/WEB-INF/classes/敏感词汇.txt" );
            //2.读取文件
            BufferedReader br = new BufferedReader ( new FileReader ( realPath ) );
            //3.将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine ()) != null) {
                list.add ( line );
            }

            br.close ();

            System.out.println ( list );

        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    public void destroy() {
    }

}
