package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAllAccount();

}
