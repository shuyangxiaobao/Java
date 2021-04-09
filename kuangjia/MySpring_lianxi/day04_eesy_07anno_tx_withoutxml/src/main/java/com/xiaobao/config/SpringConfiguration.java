package com.xiaobao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@ComponentScan("com.xiaobao")
@Import ( {JdbcConfig.class,TransactionConfig.class} )
@PropertySource ( "jdbcConfig.properties" )
@EnableTransactionManagement
public class SpringConfiguration {


}
