package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        as.saveAccount();

        //手动关闭容器
        ac.close();
    }


    @Test
    public void xlp(){
        System.out.println ("🍺🍺🍺🍺🍺🍺🍺");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ( "bean.xml" );
        IAccountService service = (IAccountService)context.getBean ( "accountService1" );
//        IAccountService service2 = (IAccountService)context.getBean ( "accountService2" );
//        IAccountService service3 = (IAccountService)context.getBean ( "accountService3" );

        service.saveAccount ();
//        service2.saveAccount ();
//        service3.saveAccount ();
        context.close ();
    }

}
