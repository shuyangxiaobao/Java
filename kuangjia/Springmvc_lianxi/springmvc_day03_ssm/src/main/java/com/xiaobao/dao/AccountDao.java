package com.xiaobao.dao;

import com.xiaobao.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {


    /**
     * 查询所有账户
     *
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);
}
