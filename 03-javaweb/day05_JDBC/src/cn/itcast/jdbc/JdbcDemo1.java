package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {

        //1. 导入驱动jar包
        //2.注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
        Connection conn = DriverManager.getConnection ( "jdbc:mysql:///xlpdata", "root", "123456abc" );
        //4.定义sql语句
//        String sql = "update account set balance = 2000 where id = 1";
        String sql = "update account set balance = 999";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement ();
        //6.执行sql
        int count = stmt.executeUpdate ( sql );
        //7.处理结果
        System.out.println ( count );
        //8.释放资源
        stmt.close ();
        conn.close ();

//        fun1 ();
    }










    public static void fun1(){
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
            Connection connection = DriverManager.getConnection ( "jdbc:mysql:///xlpdata","root","123456abc" );
            String sql = "update account set balance = 8989 where NAME = 'zhangsan'";
            Statement stmt =  connection.createStatement ();
            int count = stmt.executeUpdate ( sql );
            stmt.close ();
            connection.close ();
            System.out.println ("count:"+count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {

        }


    }



}

