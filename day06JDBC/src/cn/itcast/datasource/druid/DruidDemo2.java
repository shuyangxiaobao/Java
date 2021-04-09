package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {

    public static void main(String[] args) {
        /*
         * 完成添加操作：给account表添加一条记录
         */
    	fun1();
    	
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into account values(null,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,"王五2");
            pstmt.setDouble(2,5000);
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源
            JDBCUtils.close(pstmt,conn);
        }
    }

    
    
    private static void fun1() {
    	Connection conn = null;
    	PreparedStatement prepare = null;
    	try {
			 conn = JDBCUtils.getConnection();
			 String sql = "insert into account values(null,?,?)";
			 prepare = conn.prepareStatement(sql);
			 prepare.setString(1, "戈强宝");
			 prepare.setDouble(2, 30000);
			 int count = prepare.executeUpdate();
			 System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close(prepare, conn);
		}
    	
	}
    
}
