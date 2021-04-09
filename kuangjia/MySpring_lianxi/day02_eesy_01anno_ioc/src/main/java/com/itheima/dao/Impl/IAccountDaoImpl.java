package com.itheima.dao.Impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class IAccountDaoImpl implements IAccountDao {
    public void saveAccountXlp() {
        System.out.println ("保存了账户11111111111");
    }
}
