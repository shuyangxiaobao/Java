package com.xiaobao.dao;

import com.xiaobao.domain.MyAccount;

import java.util.List;

public interface IMyAccountDao {

    /**
     * 查询所有
     * @return
     */
    List<MyAccount> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    MyAccount findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(MyAccount account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(MyAccount account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，如果没有结果就返回null
     *          如果结果集超过一个就抛异常
     */
    MyAccount findAccountByName(String accountName);

    MyAccount findAccountByID(String s);
}
