package day06_线程同步.demo01.getName;
/*
    线程的名称:
        主线程: main
        新线程: Thread-0,Thread-1,Thread-2
 */
public class Demo01GetThreadName {
    public static void main(String[] args) {
    xlp ();
    }

    public static void demo(){
        //创建Thread类的子类对象
        MyThread mt = new MyThread();
        //调用start方法,开启新线程,执行run方法
//        mt.start();    //创建Thread类的子类对象
//        MyThread mt = new MyThread();
//        //调用start方法,开启新线程,执行run方法
////        mt.start();
////
////        new MyThread().start();
////        new MyThread().start();
//
//        //链式编程
//        System.out.println(Thread.currentThread().getName());
//
//        new MyThread().start();
//        new MyThread().start();

        //链式编程
        System.out.println(Thread.currentThread().getName());
    }


    public static void xlp(){
        XLPThread xlpThread = new XLPThread ();
        xlpThread.setName ( "woshi" );
//        xlpThread.start ();
//
//        xlpThread.stop ();
//        xlpThread.start ();

        System.out.println (Thread.currentThread ().getState ());

    }
}


class XLPThread extends Thread{
    @Override
    public void run() {
        super.run ();
        System.out.println (currentThread ().getName ());
    }
}