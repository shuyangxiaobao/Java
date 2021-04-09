package com.itheima.service.Impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("accountService1")
@Scope("prototype")
public class AccountServiceImpl implements AccountService {

        @Autowired


//    @Autowired
//    @Qualifier("accountDao1")

//    @Resource(name = "accountDao1")
    private IAccountDao accountDao1 = null;

    public void saveAccountXlp() {
        accountDao1.saveAccountXlp ();
    }
}