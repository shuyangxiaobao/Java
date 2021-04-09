package com.xiaobao.utils;

import org.aspectj.lang.ProceedingJoinPoint;

import java.sql.SQLException;

//
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
         try {
             connectionUtils.getThreadConnection ().setAutoCommit ( false );
         } catch (SQLException e) {
             throw new RuntimeException ( e );
         }
     }

    /**
     * 提交事务
     */
    public  void commit(){
         try {
             connectionUtils.getThreadConnection ().commit ();
         } catch (SQLException e) {
             throw new RuntimeException ( e );
         }
     }

    /**
     * 回滚事务
     */
    public void rollback(){
         try {
             connectionUtils.getThreadConnection ().rollback ();
         } catch (SQLException e) {
             throw new RuntimeException ( e );
         }
     }

    /**
     * 释放连接
     */
    public void release(){
        try {
            connectionUtils.getThreadConnection ().close ();
            connectionUtils.removeConnection ();
        } catch (SQLException e) {
            throw new RuntimeException ( e );
        }
    }

    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtValue = pjp.proceed(args);
            //4.提交事务
            this.commit();

            //返回结果
            return  rtValue;

        }catch (Throwable e){
            //5.回滚事务
            this.rollback();
            System.out.println ("回滚了😄😄😄😄😄😄😄😄");
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            this.release();
            System.out.println ("finally😄😄😄😄😄😄😄😄");

        }
    }

}
