package com.xiaobao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class JdbcConfig {


    @Value ( "${jdbc.driver}" )
    private String driver;

    @Value ( "${jdbc.url}" )
    private String url;

    @Value ( "${jdbc.username}" )
    private String username;


    @Value ( "${jdbc.password}" )
    private String password;


    @Bean(name = "jdbctemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }



//    DataSource 是接口  DriverManagerDataSource是实现类

    @Bean(name = "datasource")
    public DataSource createDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource ();
        dataSource.setDriverClassName ( driver );
        dataSource.setUrl ( url );
        dataSource.setUsername ( username );
        dataSource.setPassword ( password );
        return dataSource;
    }
}
