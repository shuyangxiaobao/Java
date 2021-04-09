package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {

    public static void main(String[] args) {
        User loginuser = new User();
        loginuser.setUsername("xiaoming");
        loginuser.setPassword("123");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }

@Test
public void testLogin(){
    User loginuser = new User();
    loginuser.setUsername("xiaoming");
    loginuser.setPassword("123");


    UserDao dao = new UserDao();
    User user = dao.login(loginuser);

    System.out.println(user);
    }
}
