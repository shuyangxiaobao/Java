//package com.itheima.dao.impl;
//
//
////  此类用于抽取dao中的重复代码
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
//public class JdbcDaoSupport {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//
//    public void setDataSource(DataSource dataSource) {
//        if(jdbcTemplate == null){
//            jdbcTemplate = createJdbcTemplate(dataSource);
//        }
//    }
//
//    private JdbcTemplate createJdbcTemplate(DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
//}
