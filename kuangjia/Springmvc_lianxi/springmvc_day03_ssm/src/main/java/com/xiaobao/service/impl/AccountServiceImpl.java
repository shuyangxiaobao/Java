package com.xiaobao.service.impl;

import com.xiaobao.dao.AccountDao;
import com.xiaobao.domain.Account;
import com.xiaobao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll ();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount (account);

    }
}
