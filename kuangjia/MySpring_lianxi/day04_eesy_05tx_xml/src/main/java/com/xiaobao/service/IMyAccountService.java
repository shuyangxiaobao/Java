package com.xiaobao.service;

import com.xiaobao.domain.MyAccount;

import java.util.List;

public interface IMyAccountService {
    /**


    /**
     * 转账
     * @param sourceName        转出账户名称
     * @param targetName        转入账户名称
     * @param money             转账金额
     */
    void transfer(String sourceName,String targetName,Float money);

    //void test();//它只是连接点，但不是切入点，因为没有被增强
}
