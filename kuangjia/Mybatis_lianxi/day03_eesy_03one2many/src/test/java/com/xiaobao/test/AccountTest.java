package com.xiaobao.test;

import com.xiaobao.dao.IAccountDao;
import com.xiaobao.domain.Account;
import com.xiaobao.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder ().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> list = accountDao.findAll ();
        for (Account u:list
             ) {
            System.out.println ("<<<<<<<<<<<<<<<");
            System.out.println (u);
            System.out.println (u.getUser ());
            System.out.println (">>>>>>>>>>>>>>>");

        }

    }

    @Test
    public void testFindAllUser(){
        List<AccountUser> list = accountDao.findAllUser ();
        for (AccountUser u:list
        ) {
            System.out.println ("<<<<<<<<<<<<<<<");
            System.out.println (u);
            System.out.println (">>>>>>>>>>>>>>>");
        }

    }

}