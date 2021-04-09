package com.xiaobao.service.Impl;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import com.xiaobao.service.IMyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("myAccountService")
public class MyAccountServiceImpl implements IMyAccountService {
    @Resource(name = "accountDao")
    private IMyAccountDao accountDao;

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
