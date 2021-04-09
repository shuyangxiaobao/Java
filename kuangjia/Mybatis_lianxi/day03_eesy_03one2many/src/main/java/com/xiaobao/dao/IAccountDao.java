package com.xiaobao.dao;

import com.xiaobao.domain.Account;
import com.xiaobao.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    List<AccountUser> findAllUser();

}
