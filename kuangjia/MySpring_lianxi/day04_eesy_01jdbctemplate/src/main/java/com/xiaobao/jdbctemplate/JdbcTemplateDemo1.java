package com.xiaobao.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource ();
        dataSource.setDriverClassName ( "com.mysql.cj.jdbc.Driver" );
        dataSource.setUrl ( "jdbc:mysql://localhost:3306/spring_test" );
        dataSource.setUsername ( "root" );
        dataSource.setPassword ( "123456abc" );
        JdbcTemplate template = new JdbcTemplate ( dataSource );
        template.execute ( "insert into myAccount(myname,mymoney) values ('ccc',999)" );
    }
}
