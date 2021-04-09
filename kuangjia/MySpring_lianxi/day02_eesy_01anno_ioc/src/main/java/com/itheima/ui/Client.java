package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext ( "bean.xml" );
        AccountService service1 = (AccountService)ac.getBean ( "accountService1" );
        service1.saveAccountXlp ();
        System.out.println ("========-------分割线------========");
        IAccountDao dao2 = ac.getBean("accountDao2",IAccountDao.class );
        dao2.saveAccountXlp ();

    }


    @Test
    public void demo1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext ( "bean.xml" );
        AccountService service1 = (AccountService)ac.getBean ( "accountService1" );
        AccountService service2 = (AccountService)ac.getBean ( "accountService1" );
        System.out.println (service1 == service2);


    }


}
