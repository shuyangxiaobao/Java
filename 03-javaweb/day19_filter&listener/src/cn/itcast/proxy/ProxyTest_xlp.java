package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest_xlp {
    public static void main(String[] args) {

        Lenovo lenovo = new Lenovo ();
        SaleComputer proxyLenovo = (SaleComputer) Proxy.newProxyInstance (
                lenovo.getClass ().getClassLoader (),
                lenovo.getClass ().getInterfaces (),
                new InvocationHandler () {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        String name = method.getName ();
                        if (name.equals ( "sale" )) {
                            double money = (double) args[0];
                            String result = (String) method.invoke ( lenovo, money * 0.8 );
                            return result + "鼠标";
                        } else {
                            method.invoke ( lenovo, args );
                        }
                        return null;
                    }
                } );

        String sale = proxyLenovo.sale ( 3456 );
        System.out.println ( "sale=" + sale );
        System.out.println ( "-----------------------" );
        proxyLenovo.show ();


    }
}
