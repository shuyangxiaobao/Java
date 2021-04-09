package com.xiaobao.test;

import com.xiaobao.dao.IUserDao;
import com.xiaobao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private IUserDao userDao;
    InputStream stream;
    SqlSession session;

    @Before//用于在测试方法执行之前执行
    public  void init() throws IOException {
        //1.读取配置文件
        stream = Resources.getResourceAsStream ( "SqlMapConfig.xml" );
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory factory = factoryBuilder.build ( stream );
        //3.使用工厂生产SqlSession对象
        session = factory.openSession ();
        //4.使用SqlSession创建Dao接口的代理对象
         userDao = session.getMapper ( IUserDao.class );
    }

    @After//用于在测试方法执行之后执行
    public  void destroy() throws IOException {
//      6.提交事务
        session.commit ();
//       7.释放资源
        session.close ();
        stream.close ();
    }

    /**
     * 查询所有
     * @throws IOException
     */

    @Test
    public void testFindAll() throws IOException {
//        //1.读取配置文件
//        InputStream stream = Resources.getResourceAsStream ( "SqlMapConfig.xml" );
//        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder ();
//        SqlSessionFactory factory = factoryBuilder.build ( stream );
//        //3.使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession ();
//        //4.使用SqlSession创建Dao接口的代理对象
//        IUserDao userDao = session.getMapper ( IUserDao.class );
//        //5.使用代理对象执行方法
        List<User> list = userDao.findAll ();

        System.out.println ("");
        System.out.println ("<<<<<<<<<<<<<<<<<");
        for (User user:list
             ) {
            System.out.println (user);
        }
        System.out.println (">>>>>>>>>>>>>>>>>");
        System.out.println ("");


    }

    /**
     * 保存用户
     */
    @Test
    public void testSaveUser(){
        User user = new User ();
        user.setUsername ( "小老婆2" );
        user.setBirthday ( new Date () );
        user.setSex ( "女" );
        user.setAddress ("上海浦东" );
        userDao.saveuser ( user );
        System.out.println (user);
    }


    /**
     * 更新用户信息
     */
    @Test
    public void testUpdateUser(){
        User user = new User ();
        user.setId ( 63 );
        user.setUsername ( "小63" );
        user.setBirthday ( new Date () );
        user.setSex ( "女" );
        user.setAddress ("上海浦东333333" );
        userDao.updateUser ( user );
        System.out.println (user);
    }

    /**
     * 删除用户信息
     */
    @Test
    public void  testDelete(){
        userDao.deleteUser ( 62 );
    }

    /**
     * 根据id查询用户
     */

    @Test
    public void  testFindByid(){
        User user = userDao.findByid ( 41 );
        System.out.println (user);
    }











}
