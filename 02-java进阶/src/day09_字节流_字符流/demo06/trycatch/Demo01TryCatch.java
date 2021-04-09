package day09_字节流_字符流.demo06.trycatch;

import java.io.FileWriter;
import java.io.IOException;

/*
    在jdk1.7之前使用try catch finally 处理流中的异常
    格式:
        try{
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }finally{
            一定会指定的代码
            资源释放
        }
 */
public class Demo01TryCatch {
    public static void main(String[] args) {
        xlp ();
    }


    public static void demo( ) {
        //提高变量fw的作用域,让finally可以使用
        //变量在定义的时候,可以没有值,但是使用的时候必须有值
        //fw = new FileWriter("09_IOAndProperties\\g.txt",true); 执行失败,fw没有值,fw.close会报错
        FileWriter fw = null;
        try{
            //可能会产出异常的代码
            fw = new FileWriter("w:\\09_IOAndProperties\\g.txt",true);
            for (int i = 0; i <10 ; i++) {
                fw.write("HelloWorld"+i+"\r\n");
            }
        }catch(IOException e){
            //异常的处理逻辑
            System.out.println(e);
        }finally {
            //一定会指定的代码
            //创建对象失败了,fw的默认值就是null,null是不能调用方法的,会抛出NullPointerException,需要增加一个判断,不是null在把资源释放
            if(fw!=null){
                try {
                    //fw.close方法声明抛出了IOException异常对象,所以我们就的处理这个异常对象,要么throws,要么try catch
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static void xlp(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter ( "/Users/xiaobao/Desktop/test/f2.txt" );
            for (int i = 0; i < 10; i++) {
                fileWriter.write ( "hello"+i+"\n" );
            }
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            if (fileWriter != null){
                try {
                    fileWriter.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }




    }






}
