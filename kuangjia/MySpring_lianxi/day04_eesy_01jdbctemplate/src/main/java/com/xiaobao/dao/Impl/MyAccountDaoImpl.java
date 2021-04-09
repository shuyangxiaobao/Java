package com.xiaobao.dao.Impl;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MyAccountDaoImpl implements IMyAccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MyAccount findAccountByID(String accountID) {
        List<MyAccount> list = jdbcTemplate.query ( "select * from myAccount where id = ?",
                new BeanPropertyRowMapper<MyAccount> ( MyAccount.class ), accountID );
        if (!list.isEmpty ()){
            return list.get ( 0 );
        }
        return null;
    }

    public MyAccount findAccountByName(String name) {
        List<MyAccount> list = jdbcTemplate.query ( "select *from myAccount where name = ?",
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
        jdbcTemplate.update ( "update myAccount set myname = ?,mymoney = ? where id = ?",account.getMyname (),
                account.getMymoney (),account.getId ());
    }
}
