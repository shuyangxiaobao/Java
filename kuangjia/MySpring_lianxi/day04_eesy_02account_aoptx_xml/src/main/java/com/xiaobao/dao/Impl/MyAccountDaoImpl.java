package com.xiaobao.dao.Impl;

import com.xiaobao.dao.IMyAccountDao;
import com.xiaobao.domain.MyAccount;
import com.xiaobao.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

public class MyAccountDaoImpl implements IMyAccountDao {
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<MyAccount> findAllAccount() {
        return null;
    }

    public MyAccount findAccountById(Integer accountId) {
        try {
            return (MyAccount) runner.query ( connectionUtils.getThreadConnection (), "select * from account",
                    new BeanListHandler<MyAccount> ( MyAccount.class ) );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return null;
    }

    public void saveAccount(MyAccount account) {
        try {
            runner.update (connectionUtils.getThreadConnection (), "insert into myAccount(myname,mymoney) values (?," +
                            "?)", account.getMyname (),
                    account.getMymoney ());
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void updateAccount(MyAccount account) {
        try {
            runner.update ( connectionUtils.getThreadConnection (), "update myAccount set myname = ? , mymoney = ? where id = ?", account.getMyname (),
                    account.getMymoney (), account.getId () );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void deleteAccount(Integer acccountId) {
        try {
            runner.update (connectionUtils.getThreadConnection (),"delete from myAccount where id = ?",acccountId );
        } catch (SQLException e) {
            throw  new RuntimeException ( e );
        }

    }

    public MyAccount findAccountByName(String accountName) {
        try {
            return runner.query(connectionUtils.getThreadConnection (),"select * from myaccount where myname = ?",
                    new BeanHandler<MyAccount> ( MyAccount.class ),
                    accountName);
        } catch (SQLException e) {
            throw  new RuntimeException ( e );
        }    }

    public MyAccount findAccountByID(String s) {
        try{
            return runner.query ( connectionUtils.getThreadConnection (),"select * from myAccount where id = ?",
                    new BeanHandler<MyAccount>(MyAccount.class),s);
        }catch (Exception e){
            throw new RuntimeException ( e );
        }
    }

}
