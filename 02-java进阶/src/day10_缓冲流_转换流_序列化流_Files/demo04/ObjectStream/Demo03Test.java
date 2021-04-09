package day10_缓冲流_转换流_序列化流_Files.demo04.ObjectStream;

import java.io.*;
import java.util.ArrayList;

/*
    练习：序列化集合
        当我们想在文件中保存多个对象的时候
        可以把多个对象存储到一个集合中
        对集合进序列化和反序列化
    分析:
        1.定义一个存储Person对象的ArrayList集合
        2.往ArrayList集合中存储Person对象
        3.创建一个序列化流ObjectOutputStream对象
        4.使用ObjectOutputStream对象中的方法writeObject,对集合进行序列化
        5.创建一个反序列化ObjectInputStream对象
        6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
        7.把Object类型的集合转换为ArrayList类型
        8.遍历ArrayList集合
        9.释放资源
 */
public class Demo03Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        demo ();
        xlp ();
    }
    public static void demo( ) throws IOException, ClassNotFoundException {
        //1.定义一个存储Person对象的ArrayList集合
        ArrayList<Person> list = new ArrayList<>();
        //2.往ArrayList集合中存储Person对象
        list.add(new Person("张三",18));
        list.add(new Person("李四",19));
        list.add(new Person("王五",20));
        //3.创建一个序列化流ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/xiaobao/Desktop/test/f.txt"));
        //4.使用ObjectOutputStream对象中的方法writeObject,对集合进行序列化
        oos.writeObject(list);
        //5.创建一个反序列化ObjectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/xiaobao/Desktop/test/f.txt"));
        //6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
        Object o = ois.readObject();
        //7.把Object类型的集合转换为ArrayList类型
        ArrayList<Person> list2 = (ArrayList<Person>)o;
        //8.遍历ArrayList集合
        for (Person p : list2) {
            System.out.println(p);
        }
        //9.释放资源
        ois.close();
        oos.close();
    }

    public static void xlp() throws IOException,ClassNotFoundException {
        ArrayList<Person> list = new ArrayList<> ();
        list.add ( new Person ( "zhangsan",18 ) );
        list.add ( new Person ( "lisi",18 ) );
        list.add ( new Person ( "xiaoming",19 ) );

        String path = "/Users/xiaobao/Desktop/test/f.txt";
        ObjectOutputStream outputStream = new ObjectOutputStream ( new FileOutputStream ( path ) );

        outputStream.writeObject ( list );

        ObjectInputStream inputStream = new ObjectInputStream ( new FileInputStream ( path ) );
        Object o = inputStream.readObject ();
        ArrayList<Person> lists =  (ArrayList<Person>) o;
        for (Person p:lists
             ) {
            System.out.println (p);
        }



    }


}
