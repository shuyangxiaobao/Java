package com.itheima.dao.Impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class IAccountDaoImpl2 implements IAccountDao {
    public void saveAccountXlp() {
        System.out.println ("保存了账户222222222");
    }
}
