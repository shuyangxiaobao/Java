package com.xiaobao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public class TransactionConfig {


    @Bean(name = "transactionmanager")
    public DataSourceTransactionManager cetateManager(DataSource dataSource){
        return new DataSourceTransactionManager ( dataSource );
    }
}
