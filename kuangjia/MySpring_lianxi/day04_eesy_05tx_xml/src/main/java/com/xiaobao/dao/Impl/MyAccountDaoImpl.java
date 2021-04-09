package com.xiaobao.dao.Impl;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import java.sql.SQLException;
import java.util.List;

public class MyAccountDaoImpl extends JdbcDaoSupport implements IMyAccountDao {


    public MyAccount findAccountById(Integer accountId) {
        List<MyAccount> accounts = super.getJdbcTemplate ().query ( "select * from myAccount where id = ?",
                new BeanPropertyRowMapper<MyAccount> ( MyAccount.class ),accountId );
        if (accounts.isEmpty ()){
            return  null;
        } else {
            return  accounts.get ( 0 );
        }
    }

    public void updateAccount(MyAccount account) {
        super.getJdbcTemplate ().update ( "update myAccount set myname = ? , mymoney = ? where id = ?",
                account.getMyname (),account.getMymoney (),account.getId () );

    }

    public MyAccount findAccountByName(String accountName) {
        List<MyAccount> accounts = super.getJdbcTemplate ().query ( "select * from myAccount where myName = ?",
                new BeanPropertyRowMapper<MyAccount> ( MyAccount.class ),accountName );
        if (accounts.isEmpty ()){
            return  null;
        } else if (accounts.size () > 1){
            throw  new RuntimeException ( "结果不唯一" );
        } else{
            return accounts.get ( 0 );
        }
    }
}
