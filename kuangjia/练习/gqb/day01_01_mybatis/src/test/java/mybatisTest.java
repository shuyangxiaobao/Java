import com.xiaobao.dao.IUserDao;
import com.xiaobao.dao.IUserDao2;
import com.xiaobao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class mybatisTest {


    /**
     * 入门案例
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream ( "SqlMapConfig.xml" );
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory factory = builder.build ( in );
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession ();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper ( IUserDao.class );
        //5.使用代理对象执行方法
        List<User> users = userDao.finall ();
        for (User user : users) {
            System.out.println ( user );
        }
        //6.释放资源
        session.close ();
        in.close ();
    }


    @Test
    public void demo1() throws IOException {
        InputStream stream = Resources.getResourceAsStream ( "SqlMapConfig.xml" );
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory factory = builder.build ( stream );
        SqlSession session = factory.openSession ();
        IUserDao userDao = session.getMapper ( IUserDao.class );
        List<User> users = userDao.finallAnnotation ();
        for (User user : users) {
            System.out.println ( user );
        }
    }

    @Test
    public void demo2() throws IOException {
        InputStream stream = Resources.getResourceAsStream ( "SqlMapConfig.xml" );
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory factory = builder.build ( stream );
        SqlSession session = factory.openSession ();
        IUserDao2 userDao = session.getMapper ( IUserDao2.class );
        List<User> users = userDao.finallAnnotation ();
        for (User user : users) {
            System.out.println ( user );
        }
    }

    @Test
    public void demo3() throws IOException {
        User user = new User();
        user.setUsername ("8888888");
        user.setAddress ("北京市顺义区");
        user.setSex ("男");
        user.setBirthday (new Date ());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法

        InputStream stream = Resources.getResourceAsStream ( "SqlMapConfig.xml" );
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory factory = builder.build ( stream );
        SqlSession session = factory.openSession ();
        IUserDao userDao = session.getMapper ( IUserDao.class );
        userDao.saveUser(user);

        System.out.println("保存操作之后："+user);
        session.commit(); // 需要事务提交，不然保存不了
        session.close ();
        stream.close ();

    }

    @Test
    public void demo4() throws IOException {
        User user = new User();
        user.setUsername ("8888888");
        user.setAddress ("北京市顺义区");
        user.setSex ("男");
        user.setBirthday (new Date ());
        user.setId ( 41 );
        System.out.println("保存操作之前："+user);

        //5.执行保存方法

        InputStream stream = Resources.getResourceAsStream ( "SqlMapConfig.xml" );
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory factory = builder.build ( stream );
        SqlSession session = factory.openSession ();
        IUserDao userDao = session.getMapper ( IUserDao.class );
        userDao.updateUser (user);

        System.out.println("保存操作之后："+user);
        session.commit(); // 需要事务提交，不然保存不了
        session.close ();
        stream.close ();

    }


}
