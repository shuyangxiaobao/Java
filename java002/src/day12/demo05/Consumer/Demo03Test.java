package day12.demo05.Consumer;

import java.util.function.Consumer;
//import sun.awt.IconInfo;

/*
    练习:
        字符串数组当中存有多条信息，请按照格式“姓名：XX。性别：XX。”的格式将信息打印出来。
        要求将打印姓名的动作作为第一个Consumer接口的Lambda实例，
        将打印性别的动作作为第二个Consumer接口的Lambda实例，
        将两个Consumer接口按照顺序“拼接”到一起。
 */
public class Demo03Test {

	public static void main(String[] args) {
		String[] array = {"小强,12","小雪,13","小宝,14"};
		printInfo((String s)->{
			System.out.print("name:"+s.split(",")[0]);
		}, (String s)->{
			System.out.println(" age:"+s.split(",")[1]);
		}, array);
	}
	private static void printInfo(Consumer<String> one, Consumer<String> two,String[] array) {
		for (String info : array) {
			one.andThen(two).accept(info);
		}
	}
	

}


      
