package cn.itcast.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Druid演示
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties pro = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //5.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        
//        fun1();
        
    }

    @Test
    public void fun1() throws Exception {
    	// TODO Auto-generated method stub
//    	Properties properties = new Properties();
//    	InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
//    	properties.load(is);
//    	DataSource ds = DruidDataSourceFactory.createDataSource(properties);
//    	Connection conn = ds.getConnection();
//    	System.out.println(conn);

    	Properties properties = new Properties ();
    	InputStream inputStream  = DruidDemo.class.getClassLoader ().getResourceAsStream ( "druid.properties" );
    	properties.load(inputStream);
        System.out.println (properties);

        DataSource ds = DruidDataSourceFactory.createDataSource ( properties );
        Connection connection = ds.getConnection ();
        String sql = "select * from account where id > ?";
        PreparedStatement pre = connection.prepareStatement ( sql );
        pre.setInt ( 1,10 );
        ResultSet resultSet = pre.executeQuery();
        while (resultSet.next ()){
          int id = resultSet.getInt ( 1 );
          String name = resultSet.getString ( "name" );
          int balance = resultSet.getInt ( "balance");
            System.out.println (id+"__"+name+"__"+balance);
        }

	}
}
