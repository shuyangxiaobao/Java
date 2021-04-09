package com.xiaobao.test;

import com.xiaobao.dao.IgqbAccountDao;
import com.xiaobao.domain.GqbAccount;
import com.xiaobao.service.IGqbAccountService;
import com.xiaobao.service.Impl.GqbAccountServiceImpl;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


//使用 xml 配置使用这两行
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:bean.xml")



//使用注解配置使用这两行
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)

public class GqbAccountTest {
    @Autowired
    private IGqbAccountService service;


    @Test
    public void demo4(){
        //1.获取容易
        ApplicationContext ac = new AnnotationConfigApplicationContext ( SpringConfiguration.class);
        //2.获取queryRunner对象
        QueryRunner runner = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        System.out.println(runner == runner1);
    }


    @Test
    public void demo2(){
        System.out.println ("----------demo2-----------");
        System.out.println (service);
        List<GqbAccount> allAccount = service.findAllAccount ();
        for (GqbAccount account:allAccount
        ) {
            System.out.println (account);
        }
    }

    @Test
    public void demo3(){
        //1.获取容易
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IGqbAccountService as = ac.getBean("accountService2",IGqbAccountService.class);
        //3.执行方法
        System.out.println (as);

        List<GqbAccount> accounts = as.findAllAccount();
        for(GqbAccount account : accounts){
            System.out.println(account);
        }
    }





    @Test
    public void demo1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IGqbAccountService service  = (IGqbAccountService)ac.getBean("gqbAccountService");
        List<GqbAccount> allAccount = service.findAllAccount ();
        for (GqbAccount account:allAccount
        ) {
            System.out.println (account);
        }
    }


}
