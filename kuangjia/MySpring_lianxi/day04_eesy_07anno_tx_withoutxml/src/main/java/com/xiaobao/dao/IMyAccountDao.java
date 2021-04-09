package com.xiaobao.dao;

import com.xiaobao.domain.MyAccount;

import java.util.List;

public interface IMyAccountDao {


    /**
     * 查询一个
     * @return
     */
    MyAccount findAccountById(Integer accountId);


    /**
     * 更新
     * @param account
     */
    void updateAccount(MyAccount account);


    /**
     * 根据名称查询账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，如果没有结果就返回null
     *          如果结果集超过一个就抛异常
     */
    MyAccount findAccountByName(String accountName);

}
