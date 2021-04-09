package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountDao {


    public Account findByID(Integer uid);


    public List<Account> findAllAccount ();
}
