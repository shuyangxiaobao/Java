package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan("com.itheima") //配置要扫描的包
@Import({JdbcConfig.class,TransactionConfig.class}) //导入配置
@PropertySource("jdbcConfig.properties") //加载文件
@EnableTransactionManagement   //开启spring对注解事务的支持
public class SpringConfiguration {
}
