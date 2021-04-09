package com.xiaobao.jdbctemplate;

import com.xiaobao.domain.MyAccount;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ( "bean.xml" );
        JdbcTemplate jdbctemplate = (JdbcTemplate)context.getBean ( "jdbctemplate" );

//        jdbctemplate.execute("insert into (name,money)values('ddd',2222)");

        jdbctemplate.execute("UPDATE myAccount set myname = '新改的',mymoney = 8989 where id = 3)");

//        增加数据
        jdbctemplate.update ( "insert into myAccount (myname,mymoney) values (?,?)","eeee",9999 );

//        更新
        jdbctemplate.update ( "UPDATE myAccount set myname = ?,mymoney = ? where id = ?","xiaoming",10000,1 );
//        删除
        jdbctemplate.update ("delete from myAccount where id > ?",4);

//        查询
        List<MyAccount> list = jdbctemplate.query ( "select * from myAccount where mymoney >= ? ",
                new BeanPropertyRowMapper<MyAccount> ( MyAccount.class ), 1000 );
        for (MyAccount account:list
             ) {
            System.out.println (account);
        }
//        聚合函数
        Long count = jdbctemplate.queryForObject("select count(*) from myaccount where mymoney > ?",Long.class,900);

        System.out.println (count);
    }
}
