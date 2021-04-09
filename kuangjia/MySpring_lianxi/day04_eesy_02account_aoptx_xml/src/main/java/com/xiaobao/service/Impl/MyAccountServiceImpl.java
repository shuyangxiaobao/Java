package com.xiaobao.service.Impl;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import com.xiaobao.service.IMyAccountService;

import java.util.List;

public class MyAccountServiceImpl implements IMyAccountService {
    private IMyAccountDao accountDao;

    public void setAccountDao(IMyAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<MyAccount> findAllAccount() {
        return accountDao.findAllAccount ();
    }

    public MyAccount findAccountById(Integer accountId) {
        return accountDao.findAccountById ( accountId );
    }

    public void saveAccount(MyAccount account) {
        accountDao.saveAccount ( account );
    }

    public void updateAccount(MyAccount account) {
        accountDao.updateAccount ( account );
    }

    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount ( acccountId );

    }

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
