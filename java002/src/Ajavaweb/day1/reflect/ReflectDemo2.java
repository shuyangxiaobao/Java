package Ajavaweb.day1.reflect;

import Ajavaweb.day1.domain.Person;

import java.lang.reflect.Field;

 
public class ReflectDemo2 {

    /**
     Class对象功能：
         * 获取功能：
         1. 获取成员变量们
             * Field[] getFields() //获取所有public修饰的成员变量
             * Field getField(String name)

             * Field[] getDeclaredFields()
             * Field getDeclaredField(String name)
         2. 获取构造方法们
             * Constructor<?>[] getConstructors()
             * Constructor<T> getConstructor(类<?>... parameterTypes)

             * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
             * Constructor<?>[] getDeclaredConstructors()
         3. 获取成员方法们：
             * Method[] getMethods()
             * Method getMethod(String name, 类<?>... parameterTypes)

             * Method[] getDeclaredMethods()
             * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

         4. 获取类名
             * String getName()



     */

    public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
             1. 获取成员变量们
                 * Field[] getFields()
                 * Field getField(String name)

                 * Field[] getDeclaredFields()
                 * Field getDeclaredField(String name)

         */
        //1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("======");

        System.out.println("------------");
        //2.Field getField(String name)
        Field a = personClass.getField("a");
        System.out.println("a="+a);
        //获取成员变量a 的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println("value="+value);
        //设置a的值
        a.set(p,"张三");
        System.out.println("004:😄"+p);

        System.out.println("005:😄===================");

        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("006:😄===================");
        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        d.set(p, "dddddd123");
        Object value2 = d.get(p);
        System.out.println(value2);

    }


}
