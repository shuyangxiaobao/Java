package day10_缓冲流_转换流_序列化流_Files.demo04.ObjectStream;

import java.io.*;

/*
    java.io.ObjectOutputStream extends OutputStream
    ObjectOutputStream:对象的序列化流
    作用:把对象以流的方式写入到文件中保存

    构造方法:
        ObjectOutputStream(OutputStream out) 创建写入指定 OutputStream 的 ObjectOutputStream。
        参数:
            OutputStream out:字节输出流
    特有的成员方法:
        void writeObject(Object obj) 将指定的对象写入 ObjectOutputStream。

    使用步骤:
        1.创建ObjectOutputStream对象,构造方法中传递字节输出流
        2.使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
        3.释放资源
 */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        xlp ();
    }

    public static void demo( ) throws IOException {
        //1.创建ObjectOutputStream对象,构造方法中传递字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("10_IO\\person.txt"));
        //2.使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
        oos.writeObject(new Person("小美女",18));
        //3.释放资源
        oos.close();
    }

    public static void xlp() throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream ( new FileOutputStream ( "/Users/xiaobao/Desktop" +
                "/test/f.txt" ) );
        outputStream.writeObject(new Person("小美女",18));
        outputStream.flush ();
        outputStream.close ();


        ObjectInputStream inputStream = new ObjectInputStream ( new FileInputStream ( "/Users/xiaobao/Desktop/test/f.txt" ) );
        Object o = inputStream.readObject ();
        System.out.println (o);

    }
}
