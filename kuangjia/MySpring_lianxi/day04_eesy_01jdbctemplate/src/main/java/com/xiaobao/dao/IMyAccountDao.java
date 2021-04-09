package com.xiaobao.dao;

import com.xiaobao.domain.MyAccount;

public interface IMyAccountDao {

    public MyAccount findAccountByID(String accountID);
    public MyAccount findAccountByName(String name);
    public  void UpdataAccount(MyAccount account);

}
