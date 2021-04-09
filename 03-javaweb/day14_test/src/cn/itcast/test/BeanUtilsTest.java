package cn.itcast.test;

import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
public class BeanUtilsTest {


    public static void main(String[] args) {
        User user = new User();
        try {
            BeanUtils.setProperty(user,"gender","male2");
            System.out.println(user);
            String gender = BeanUtils.getProperty(user, "gender");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test(){

        User user = new User();
        try {
            BeanUtils.setProperty(user,"hehe","male");
            System.out.println(user);

            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


}
