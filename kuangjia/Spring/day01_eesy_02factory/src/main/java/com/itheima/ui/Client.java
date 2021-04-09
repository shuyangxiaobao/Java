package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl ();
        for(int i=0;i<5;i++) {
//            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            IAccountService as = (IAccountService) BeanFactory.getBean2("accountService");

            System.out.println(as);
            as.saveAccount();
        }

    }
}

//accountService=com.itheima.service.impl.AccountServiceImpl
//        accountDao=com.itheima.dao.impl.AccountDaoImpl
