package cn.itcast.jdbctemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update account set balance = 5888 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
        
        fun1();
    }
    
    private static void fun1() {
    	// TODO Auto-generated method stub
    	JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    	String sqlString = "update account set balance = 9999 where name = ?";
    	int count = template.update(sqlString,"王五");
    	System.out.println(count+"KKKKKKKK");
    }
}
