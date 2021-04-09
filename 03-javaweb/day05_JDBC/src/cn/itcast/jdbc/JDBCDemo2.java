package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表 添加一条记录 insert 语句
 */
public class JDBCDemo2 {
    public static void main(String[] args) {
        fun1 ();

//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            //1. 注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //2. 定义sql
//            String sql = "insert into account values(null,'王五',3000)";
//            //3.获取Connection对象
//            conn = DriverManager.getConnection ( "jdbc:mysql:///xlpdata", "root", "123456abc" );
//            //4.获取执行sql的对象 Statement
//            stmt = conn.createStatement();
//            //5.执行sql
//            int count = stmt.executeUpdate(sql);//影响的行数
//            //6.处理结果
//            System.out.println(count);
//            if(count > 0){
//                System.out.println("添加成功！");
//            }else{
//                System.out.println("添加失败！");
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            //stmt.close();
//            //7. 释放资源
//            //避免空指针异常
//            if(stmt != null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(conn != null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }



    public static void fun1(){
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
            connection = DriverManager.getConnection ( "jdbc:mysql:///xlpdata","root","123456abc" );
            stmt = connection.createStatement ();
            String sql = "insert into account values(8,'xlp1','16000')";
            int count =  stmt.executeUpdate ( sql );
            System.out.println ("jdbcDemo2结果："+count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            if (connection != null){
                try {
                    connection.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
            if (stmt != null){
                try {
                    stmt.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }

        }

    }

}
