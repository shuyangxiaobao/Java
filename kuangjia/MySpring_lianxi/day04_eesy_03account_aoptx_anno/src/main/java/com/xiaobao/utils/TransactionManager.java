package com.xiaobao.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;

//
@Component("txmanager")
@Aspect
public class TransactionManager {
    @Resource(name = "connectionUtils")
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.xiaobao.service.Impl.*.*(..))")
    private void pt1(){}

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

    @Around("pt1()")

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
