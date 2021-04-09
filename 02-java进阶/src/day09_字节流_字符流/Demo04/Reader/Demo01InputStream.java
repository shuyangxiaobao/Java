package day09_字节流_字符流.Demo04.Reader;

import java.io.FileInputStream;
import java.io.IOException;

/*
    使用字节流读取中文文件
   一个字母一个字节
    1个中文
        GBK:占用两个字节
        UTF-8:占用3个字节

 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
//      demo ();
        xlp2 ();
    }


    public static void demo() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/xiaobao/Desktop/test/e.txt");
        int len = 0;
        while((len = fis.read())!=-1){
            System.out.println((char)len);
        }
        fis.close();
    }


    public static void xlp() throws IOException {
        FileInputStream stream = new FileInputStream ( "/Users/xiaobao/Desktop/test/e.txt" );
        int len = 0;
        while ((len = stream.read ()) != -1){
            System.out.println ((char)len);
        }
    }

    public static void xlp2() throws IOException {
        FileInputStream stream = new FileInputStream ( "/Users/xiaobao/Desktop/test/f.txt" );

        int len = 0;
        byte[] bytes = new byte[12];
        while ((len = stream.read (bytes)) != -1){
            String s = new String ( bytes, 0, len );
            System.out.println (s);
            System.out.println ("----");
        }
    }





}




