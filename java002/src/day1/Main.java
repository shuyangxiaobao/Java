package day1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


// java进阶 第一天
public class Main {

	private static void fun1() {
		//		打印一个对象时
		//直接打印对象的名字,其实就是调用对象的toString  p=p.toString();
		Person p1 = new Person("xiaoming",28);
		Person p2 = new Person("xiaoming",28);

		System.out.println(p1.equals(p2));
		System.out.println(p1);	

		/*  Objects类的equals方法:对两个对象进行比较,防止空指针异常
        public static boolean equals(Object a, Object b) {
            return (a == b) || (a != null && a.equals(b));
        }*/
		boolean b = Objects.deepEquals(p1, p2);
		System.out.println("b=" + b);
	}

	public static void func2() {
		long a = System.currentTimeMillis();
		System.out.println(a);
		// TODO Auto-generated method stub
	}


	//日期 Date SimpleDateFormat
	private static void fun3() throws ParseException {
		Date date = new Date();
		System.out.println(date);//Fri Jan 10 22:02:08 CST 2020
		System.out.println(date.toLocaleString()); //2020年1月10日 下午10:02:08

		long time = date.getTime();
		System.out.println("🍺"+time);

		System.out.println(date.getDay()); // 获取天
		System.out.println(date.getYear()); //获取年份
		System.out.println(date.getMonth()+1); //获取当前月份
		System.out.println(date.getHours()); //获取当前几点
		System.out.println(date.getMinutes()); //获取当前几分		
		//		  y   年
		//        M   月
		//        d   日
		//        H   时
		//        m   分
		//        s   秒
		//1.创建SimpleDateFormat对象,构造方法中传递指定的模式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		//        //2.调用SimpleDateFormat对象中的方法format,按照构造方法中指定的模式,把Date日期格式化为符合模式的字符串(文本)
		String str = sdf.format(date);
		System.out.println(str); // 2020年01月10日 22:58:28		

		Date date1 = sdf.parse("2021年01月10日 22:58:28");  //把符合构造方法中模式的字符串,解析为Date日期
		System.out.println(date1);  //Sun Jan 10 22:58:28 CST 2021
	}

	//	  日历 Calendar
	private static void fun4() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.YEAR)); //获取年  2020
		System.out.println(calendar.get(Calendar.MONTH)+1); //获取月 //西方的月份0-11 东方:1-12
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //获取日   11
		System.out.println(calendar.get(Calendar.DATE)); //获取日   11
	}

	//	System方法  currentTimeMillis  arraycopy
	private static void fun5() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			//			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("程序耗时:"+(end-start)+"ms");

		int[] src = {1,2,3,4,5};
		int[] dest = {6,7,8,9,10};
		System.out.println("复制前:"+Arrays.toString(dest));

		//	    参数:
		//            src - 源数组。
		//            srcPos - 源数组中的起始位置(起始索引)。
		//            dest - 目标数组。
		//            destPos - 目标数据中的起始位置。
		//            length - 要复制的数组元素的数量。
		System.arraycopy(src, 1, dest, 2, 3);
		System.out.println("复制后:"+Arrays.toString(dest));
	}


	//	StringBuilder
	private static void fun6() {
		/*
	    java.lang.StringBuilder类:字符串缓冲区,可以提高字符串的效率
	    构造方法:
	        StringBuilder() 构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符。
	        StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。
		 */
		StringBuilder bu1 = new StringBuilder();
		System.out.println("bu1:"+bu1);  // bu1:
		StringBuilder bu2 = new StringBuilder("xiaolaopo");  
		System.out.println("bu2:"+bu2);  // bu2:xiaolaopo


		//		append 方法
		StringBuilder bu3 = new StringBuilder();
		//append方法返回的是this,调用方法的对象bu3,this==bu3
		bu3.append("abc");
		bu3.append(1);
		bu3.append(true);
		bu3.append(8.8);
		bu3.append('中');
		System.out.println("bu3:"+bu3);//abc1true8.8中

		/*
        链式编程:方法返回值是一个对象,可以继续调用方法
		 */
		StringBuilder bu4Builder = new StringBuilder();
		bu4Builder.append("abc").append(1).append(true).append(8.8).append('中');
		System.out.println("bu4:"+bu4Builder);

		/*
	    StringBuilder和String可以相互转换:
	        String->StringBuilder:可以使用StringBuilder的构造方法
	            StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。
	        StringBuilder->String:可以使用StringBuilder中的toString方法
	            public String toString()：将当前StringBuilder对象转换为String对象。
		 */

		String str5String = "xiaoniu";
		StringBuilder bu5 = new StringBuilder(str5String);
		bu5.append(" hello");
		str5String = bu5.toString();
		System.out.println("str5String = " + str5String);
	}

	//	装箱 拆箱
	private static void fun7() {
		/*
	    装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
	        构造方法:
	            Integer(int value) 构造一个新分配的 Integer 对象，它表示指定的 int 值。
	            Integer(String s) 构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
	                传递的字符串,必须是基本类型的字符串,否则会抛出异常 "100" 正确  "a" 抛异常
	        静态方法:
	            static Integer valueOf(int i) 返回一个表示指定的 int 值的 Integer 实例。
	            static Integer valueOf(String s) 返回保存指定的 String 的值的 Integer 对象。
	    拆箱:在包装类中取出基本类型的数据(包装类->基本类型的数据)
	        成员方法:
	            int intValue() 以 int 类型返回该 Integer 的值。
		 */
		Integer aInteger = new Integer("12");
		System.out.println(aInteger); // 12

		int b = 100;
		Integer bInteger = Integer.valueOf(b);
		System.out.println(bInteger); // 100


		/*
	    基本类型与字符串类型之间的相互转换
	    基本类型->字符串(String)
	        1.基本类型的值+""  最简单的方法(工作中常用)
	        2.包装类的静态方法toString(参数),不是Object类的toString() 重载
	            static String toString(int i) 返回一个表示指定整数的 String 对象。
	        3.String类的静态方法valueOf(参数)
	            static String valueOf(int i) 返回 int 参数的字符串表示形式。
	    字符串(String)->基本类型
	        使用包装类的静态方法parseXXX("字符串");
	            Integer类: static int parseInt(String s)
	            Double类: static double parseDouble(String s)
		 */
		//基本类型->字符串(String)
		int i1 = 100;
		String s1 = i1+"";
		System.out.println(s1+200);//100200

		String s2 = Integer.toString(100);
		System.out.println(s2+200);//100200

		String s3 = String.valueOf(100);
		System.out.println(s3+200);//100200

		//字符串(String)->基本类型
		int i = Integer.parseInt(s1);
		System.out.println(i-10);

//		int a = Integer.parseInt("a");//NumberFormatException
//		System.out.println(a);
		  
		int a100 = Integer.parseInt("112");
		System.out.println(a100);    // 112

	}

	public static void main(String[] args) throws ParseException {
		fun8();
		//		try {
		//			fun3();
		//		} catch (ParseException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}	
	}
	
	private static void xlp() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date startDate = sdf.parse("2012年09月29日 00:00:00");
		Date enDate = sdf.parse("2020年01月20日 00:00:00");
		long start = startDate.getTime();
		long end = enDate.getTime();
		long result = (end - start)/1000/3600/24;
		System.out.println("相识"+result+"天");//相识2669天
	}


}
