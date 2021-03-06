package day1.demo04.Calendar;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

/*
    Calendar类的常用成员方法:
        public int get(int field)：返回给定日历字段的值。
        public void set(int field, int value)：将给定的日历字段设置为给定值。
        public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
    成员方法的参数:
        int field:日历类的字段,可以使用Calendar类的静态成员变量获取
            public static final int YEAR = 1;	年
            public static final int MONTH = 2;	月
            public static final int DATE = 5;	月中的某一天
            public static final int DAY_OF_MONTH = 5;月中的某一天
            public static final DAY_OF_WEEK;周中的某一天
            public static final int HOUR = 10; 		时
            public static final int MINUTE = 12; 	分
            public static final int SECOND = 13;	秒
 */
public class Demo02Calendar {
    public static void main(String[] args) {
//        demo03();
        fun1();
    }

    /*
        public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
        把日历对象,转换为日期对象
     */
    private static void demo04() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();
//获取Date对象
        Date date = c.getTime();
        System.out.println(date);
    }

    /*
        public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        把指定的字段增加/减少指定的值
        参数:
            int field:传递指定的日历字段(YEAR,MONTH...)
            int amount:增加/减少指定的值
                正数:增加
                负数:减少
     */
    private static void demo03() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();

        //把年增加2年
        c.add(Calendar.YEAR,2);
        //把月份减少3个月
        c.add(Calendar.MONTH,-3);


        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//西方的月份0-11 东方:1-12

        //int date = c.get(Calendar.DAY_OF_MONTH);
        int date = c.get(Calendar.DATE);
        System.out.println(date);
    }

    /*
        public void set(int field, int value)：将给定的日历字段设置为给定值。
        参数:
            int field:传递指定的日历字段(YEAR,MONTH...)
            int value:给指定字段设置的值
     */
    private static void demo02() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();
        
        c.set(Calendar.YEAR, 1992);

        //设置年为9999
//        c.set(Calendar.YEAR,9999);
        //设置月为9月
        c.set(Calendar.MONTH,9);
        //设置日9日
        c.set(Calendar.DATE,9);

        //同时设置年月日,可以使用set的重载方法
//        c.set(8888,8,8);

        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);//西方的月份0-11 东方:1-12

        int date = c.get(Calendar.DATE);
        System.out.println(date);
    }

    /*
        public int get(int field)：返回给定日历字段的值。
        参数:传递指定的日历字段(YEAR,MONTH...)
        返回值:日历字段代表的具体的值
     */
    private static void demo01() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);//获取年
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month+1);//西方的月份0-11 东方:1-12

        int date = c.get(Calendar.DAY_OF_MONTH);
//        int date = c.get(Calendar.DATE);
        System.out.println(date);
        
      //星期中的第几天，相当于星期几。 1是星期日，7是星期六。
        int week = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(week);
        
        System.out.println("AM_PM:  "+c.get(Calendar.AM_PM));   
    }
    
    private static void fun1() {
    	Calendar ca = Calendar.getInstance();
    	System.out.println("DATE:"+ca.get(Calendar.DATE));
    	
    	ca.set(Calendar.YEAR, 1992);
    	System.out.println("YEAR:"+ca.get(Calendar.YEAR));
    	
    	ca.add(Calendar.YEAR, -9);
    	System.out.println("YEAR:"+ca.get(Calendar.YEAR));
    	
    	System.out.println(ca.getTimeInMillis());//获取毫秒值


	}
}
