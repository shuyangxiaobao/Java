package day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main3 {
	public static void main(String[] args) {
		fun9();
	}

	//  list 接口
	private static void fun1() {
		/*
	    java.util.List接口 extends Collection接口
	    List接口的特点:
	        1.有序的集合,存储元素和取出元素的顺序是一致的(存储123 取出123)
	        2.有索引,包含了一些带索引的方法
	        3.允许存储重复的元素

	    List接口中带索引的方法(特有)
	        - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
	        - public E get(int index):返回集合中指定位置的元素。
	        - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
	        - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
	    注意:
	        操作索引的时候,一定要防止索引越界异常
	        IndexOutOfBoundsException:索引越界异常,集合会报
	        ArrayIndexOutOfBoundsException:数组索引越界异常
	        StringIndexOutOfBoundsException:字符串索引越界异常
		 */
		//创建一个List集合对象,多态
		List<String> list = new ArrayList<>();
		//使用add方法往集合中添加元素
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		//打印集合
		System.out.println(list);//[a, b, c, d, a]  不是地址重写了toString

		//public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
		//在c和d之间添加一个itheima
		list.add(3,"itheima");//[a, b, c, itheima, d, a]
		System.out.println(list);

		//public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
		//移除元素
		String removeE = list.remove(2);
		System.out.println("被移除的元素:"+removeE);//被移除的元素:c
		System.out.println(list);//[a, b, itheima, d, a]

		//public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
		//把最后一个a,替换为A
		String setE = list.set(4, "A");
		System.out.println("被替换的元素:"+setE);//被替换的元素:a
		System.out.println(list);//[a, b, itheima, d, A]

		//List集合遍历有3种方式
		//使用普通的for循环
		for(int i=0; i<list.size(); i++){
			//public E get(int index):返回集合中指定位置的元素。
			String s = list.get(i);
			System.out.println(s);
		}
		System.out.println("-----------------");
		//使用迭代器
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
		System.out.println("-----------------");
		//使用增强for
		for (String s : list) {
			System.out.println(s);
		}

		String r = list.get(5);//IndexOutOfBoundsException: Index 5 out-of-bounds for length 5
		System.out.println(r);
	}


	//	LinkedList
	private static void fun2() {
		/*
	    java.util.LinkedList集合 implements List接口
	    LinkedList集合的特点:
	        1.底层是一个链表结构:查询慢,增删快
	        2.里边包含了大量操作首尾元素的方法
	        注意:使用LinkedList集合特有的方法,不能使用多态

	        - public void addFirst(E e):将指定元素插入此列表的开头。
	        - public void addLast(E e):将指定元素添加到此列表的结尾。
	        - public void push(E e):将元素推入此列表所表示的堆栈。

	        - public E getFirst():返回此列表的第一个元素。
	        - public E getLast():返回此列表的最后一个元素。

	        - public E removeFirst():移除并返回此列表的第一个元素。
	        - public E removeLast():移除并返回此列表的最后一个元素。
	        - public E pop():从此列表所表示的堆栈处弹出一个元素。
	        - public boolean isEmpty()：如果列表不包含元素，则返回true。
		 */
		//创建LinkedList集合对象
		LinkedList<String> linked = new LinkedList<>();
		//使用add方法往集合中添加元素
		linked.add("a");
		linked.add("b");
		linked.add("c");
		linked.addLast("end");
		linked.push("push");
		String first =  linked.getFirst();
		System.out.println("first = "+first);
		linked.pop();
		System.out.println(linked);	
	}

	//	Set接口
	private static void fun3() {
		/*
	    java.util.Set接口 extends Collection接口
	    Set接口的特点:
	        1.不允许存储重复的元素
	        2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历
	    java.util.HashSet集合 implements Set接口
	    HashSet特点:
	         1.不允许存储重复的元素
	         2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历
	         3.是一个无序的集合,存储元素和取出元素的顺序有可能不一致
	         4.底层是一个哈希表结构(查询的速度非常的快)
		 */
		//		Set<Integer> set = new HashSet<>();
		HashSet<Integer> set = new HashSet<>();
		//使用add方法往集合中添加元素
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(1);
		//使用迭代器遍历set集合
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()){
			Integer n = it.next();
			System.out.println(n);//1,2,3
		}
		//使用增强for遍历set集合
		System.out.println("-----------------");
		for (Integer i : set) {
			System.out.println(i);
		}
	}

	//	HashSet存储自定义类型元素
	private static void fun4() {
		/*
	    HashSet存储自定义类型元素
	    set集合元素唯一:
	        存储的元素(String,Integer,...Student,Person...),必须重写hashCode方法和equals方法
	    要求:
	        同名同年龄的人,视为同一个人,只能存储一次
		 */
		//创建HashSet集合存储Person
		HashSet<Person> set = new HashSet<>();
		Person p1 = new Person("小美女",18);
		Person p2 = new Person("小美女",18);
		Person p3 = new Person("小美女",19);
		System.out.println(p1.hashCode());//1967205423
		System.out.println(p2.hashCode());//42121758

		System.out.println(p1==p2);//false
		System.out.println(p1.equals(p2));//false
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println(set);
	}


	//	LinkedHashSet
	private static void fun5() {
		/*
	    java.util.LinkedHashSet集合 extends HashSet集合
	    LinkedHashSet集合特点:
	        底层是一个哈希表(数组+链表/红黑树)+链表:多了一条链表(记录元素的存储顺序),保证元素有序
		 */
		HashSet<String> set = new HashSet<>();
		set.add("www");
		set.add("abc");
		set.add("abc");
		set.add("itcast");
		System.out.println(set);//[abc, www, itcast] 无序,不允许重复

		LinkedHashSet<String> linked = new LinkedHashSet<>();
		linked.add("www");
		linked.add("abc");
		linked.add("abc");
		linked.add("itcast");
		System.out.println(linked);//[www, abc, itcast] 有序,不允许重复

	}

	//	哈希值
	private static void fun6() {
		/*
	    哈希值:是一个十进制的整数,由系统随机给出(就是对象的地址值,是一个逻辑地址,是模拟出来得到地址,不是数据实际存储的物理地址)
	    在Object类有一个方法,可以获取对象的哈希值
	    int hashCode() 返回该对象的哈希码值。
	    hashCode方法的源码:
	        public native int hashCode();
	        native:代表该方法调用的是本地操作系统的方法
		 */
		//Person类继承了Object类,所以可以使用Object类的hashCode方法
		Person p1 = new Person();
		int h1 = p1.hashCode();
		System.out.println(h1);//2137589296  | 1

		Person p2 = new Person();
		int h2 = p2.hashCode();
		System.out.println(h2);//249515771   |  1

		/*
            toString方法的源码:
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
		 */
		System.out.println(p1);//com.itheima.demo03.hashCode.Person@75412c2f
		System.out.println(p2);//com.itheima.demo03.hashCode.Person@282ba1e
		System.out.println(p1==p2);//false

		/*
            String类的哈希值
                String类重写Obejct类的hashCode方法
		 */
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1.hashCode());//96354
		System.out.println(s2.hashCode());//96354

		System.out.println("重地".hashCode());//1179395
		System.out.println("通话".hashCode());//1179395
	}

	//	可边参数
	private static void fun7() {
		int result = add(1,2,3,4,5);
		System.out.println(result);
	}
	/*
    可变参数的注意事项
        1.一个方法的参数列表,只能有一个可变参数
        2.如果方法的参数有多个,那么可变参数必须写在参数列表的末尾
	 */
	/*public static void method(int...a,String...b){

}*/

	/*public static void method(String b,double c,int d,int...a){
}*/

	//可变参数的特殊(终极)写法
	public static void method(Object...obj){

	}
	public static int add(int...arr){
		//System.out.println(arr);//[I@2ac1fdc4 底层是一个数组
		//System.out.println(arr.length);//0,1,2,10
		//定义一个初始化的变量,记录累加求和
		int sum = 0;
		//遍历数组,获取数组中的每一个元素
		for (int i : arr) {
			//累加求和
			sum += i;
		}
		//把求和结果返回
		return sum;
	}

	//    Collections
	private static void fun8() {
		/*
	    - java.utils.Collections是集合工具类，用来对集合进行操作。部分方法如下：
	        - public static <T> boolean addAll(Collection<T> c, T... elements):往集合中添加一些元素。
	        - public static void shuffle(List<?> list) 打乱顺序:打乱集合顺序。
	        - public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
	            注意:
         		sort(List<T> list)使用前提
         		被排序的集合里边存储的元素,必须实现Comparable,重写接口中的方法compareTo定义排序的规则
    			Comparable接口的排序规则:
        		自己(this)-参数:升序

       		- public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。
     			Comparator和Comparable的区别
        		Comparable:自己(this)和别人(参数)比较,自己需要实现Comparable接口,重写比较的规则compareTo方法
        		Comparator:相当于找一个第三方的裁判,比较两个
    			Comparator的排序规则:
        		o1-o2:升序

		 */
		ArrayList<String> list = new ArrayList<>();
		//往集合中添加多个元素
		/*list.add("a");
       list.add("b");
       list.add("c");
       list.add("d");
       list.add("e");*/
		Collections.addAll(list,"a","b","c","d","e");

		System.out.println(list);//[a, b, c, d, e]

		//public static void shuffle(List<?> list) 打乱顺序:打乱集合顺序。
		Collections.shuffle(list);
		System.out.println(list);//[b, d, c, a, e], [b, d, c, a, e]

		Collections.sort(list); //排序
		System.out.println("sort排序后:"+list);//


		//       自定义数据类型排序
		ArrayList<Person> list03 = new ArrayList<>();
		list03.add(new Person("张三",18));
		list03.add(new Person("李四",20));
		list03.add(new Person("王五",15));
		System.out.println(list03);//[Person{name='张三', age=18}, Person{name='李四', age=20}, Person{name='王五', age=15}]

		Collections.sort(list03);
		System.out.println(list03);
	}
	private static void fun9() {
		ArrayList<Integer> list01 = new ArrayList<>();
		list01.add(1);
		list01.add(3);
		list01.add(2);
		System.out.println(list01);//[1, 3, 2]
		Collections.sort(list01, new Comparator<Integer>() {
			//重写比较的规则
			@Override
			public int compare(Integer o1, Integer o2) {
				//return o1-o2;//升序
				return o2-o1;//降序
			}
		});
		System.out.println(list01);


		ArrayList<Person> list02 = new ArrayList<>();
		list02.add(new Person("a迪丽热巴",18));
		list02.add(new Person("古力娜扎",20));
		list02.add(new Person("杨幂",17));
		list02.add(new Person("b杨幂",18));
		System.out.println(list02);

		//扩展:了解
		Collections.sort(list02, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int result = o1.getAge() - o2.getAge();
				if (result == 0) {
					result = o1.getName().charAt(0) - o2.getName().charAt(0);
				}
				return result;
			}
		});
		System.out.println(list02);
	}
}
