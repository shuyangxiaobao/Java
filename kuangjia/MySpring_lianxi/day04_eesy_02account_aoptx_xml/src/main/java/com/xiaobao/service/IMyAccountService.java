package com.xiaobao.service;

import com.xiaobao.domain.MyAccount;

import java.util.List;

public interface IMyAccountService {
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
     * 转账
     * @param sourceName        转出账户名称
     * @param targetName        转入账户名称
     * @param money             转账金额
     */
    void transfer(String sourceName,String targetName,Float money);

    //void test();//它只是连接点，但不是切入点，因为没有被增强
}
