package com.xiaobao.jdbctemplate;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ( "bean.xml" );
        IMyAccountDao accountDao = (IMyAccountDao)context.getBean ( "myAccountDao" );
        MyAccount account = accountDao.findAccountByID ( "1" );
        System.out.println (account);
    }

    @Test
    public void demo1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ( "bean.xml" );
        IMyAccountDao accounDao2 = (IMyAccountDao)context.getBean ( "myAccounDao2" );
        MyAccount account = accounDao2.findAccountByID ( "2" );
        System.out.println (account);

    }

}
