package com.xiaobao.service.Impl;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import com.xiaobao.service.IMyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class MyAccountServiceImpl implements IMyAccountService {
    @Autowired
    private IMyAccountDao accountDao;
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println ("transfer");
        MyAccount sourceAccount = accountDao.findAccountByName ( sourceName );
        MyAccount targetAccount = accountDao.findAccountByName ( targetName );
        sourceAccount.setMymoney ( sourceAccount.getMymoney ()  - money );
        targetAccount.setMymoney ( targetAccount.getMymoney () + money );
        accountDao.updateAccount ( sourceAccount );
//        int i = 1/0;
        accountDao.updateAccount ( targetAccount );
    }
}
