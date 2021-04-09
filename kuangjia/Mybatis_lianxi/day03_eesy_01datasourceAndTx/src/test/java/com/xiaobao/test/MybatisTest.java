package com.xiaobao.test;

import com.xiaobao.dao.IUserDao;
import com.xiaobao.domain.QueryVo;
import com.xiaobao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder ().build(in);
        //3.获取SqlSession对象    //   true:自动提交  false：手动提交
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper( IUserDao.class);
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
        List<User> list = userDao.findAll ();
        for (User user:list
             ) {
            System.out.println (user);
        }
        System.out.println ("1234567890");
    }

    @Test
    public void testFindAll2(){
        User user1 = new User ();
        user1.setUserName ( "%婆%" );
        QueryVo vo = new QueryVo ();
        vo.setUser ( user1 );
        List<User> list = userDao.findUserByVo (vo);
        for (User u:list
        ) {
            System.out.println (u);
        }
        System.out.println ("1234567890");
    }



    @Test
    public void TestfindUserByCondition(){
        User user = new User ();
        user.setUserName ( "老王" );
//        user.setUserSex ( "男" );
        List<User> list = userDao.findUserByCondition ( user );
        for (User u:list
        ) {
            System.out.println (u);
        }
        System.out.println (list.size ());
    }

    @Test
    public void TestfindUserInIds(){
        QueryVo vo = new QueryVo ();
        List<Integer> list =new ArrayList<Integer> (  );
        list.add ( 41 );
        list.add ( 63 );
        list.add ( 64 );
        list.add ( 99 );
        vo.setIds ( list );
        List<User> userInIds = userDao.findUserInIds ( vo );
        for (User u:userInIds
             ) {
            System.out.println (u);
        }

    }
}
