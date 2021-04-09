package com.xiaobao.dao.Impl;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class MyAccountDaoImpl2 extends JdbcDaoSupport implements IMyAccountDao {
    public MyAccount findAccountByID(String accountID) {
        List<MyAccount> list = super.getJdbcTemplate ().query ( "select * from myAccount where id = ?",
                new BeanPropertyRowMapper<MyAccount> ( MyAccount.class ), accountID );
        if (!list.isEmpty ()){
            return list.get ( 0 );
        }
        return null;
    }

    public MyAccount findAccountByName(String name) {
        List<MyAccount> list = super.getJdbcTemplate ().query ( "select *from myAccount where name = ?",
                new BeanPropertyRowMapper<MyAccount> ( MyAccount.class ), name );
        if (list.isEmpty ()){
            return  null;
        }
        if (list.size () > 1){
            throw new RuntimeException ( "ji结果不是唯一的" );
        }
        return  list.get ( 0 );
    }

    public void UpdataAccount(MyAccount account) {
        super.getJdbcTemplate ().update ( "update myAccount set myname = ?,mymoney = ? where id = ?",account.getMyname (),
                account.getMymoney (),account.getId ());
    }
}
