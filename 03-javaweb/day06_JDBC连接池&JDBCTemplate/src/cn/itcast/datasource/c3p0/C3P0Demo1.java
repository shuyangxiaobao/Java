package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        System.out.println ( "32456789" );

        //1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource ();
        //2. 获取连接对象
        Connection conn = ds.getConnection ();
        //3. 打印
        System.out.println ( conn );
        conn.close ();
    }

    @Test
    public void fun1() throws SQLException {
        System.out.println ( "34534" );
        DataSource dataSource = new ComboPooledDataSource ();
        Connection connection = dataSource.getConnection ();
        System.out.println ( connection );
    }
}