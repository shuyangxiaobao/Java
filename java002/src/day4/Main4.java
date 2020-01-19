package day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.Hashtable;
import java.util.List;
public class Main4 {


	public static void main(String[] args) {
		fun7();

	}

	//	Map<k,v>集合
	private static void fun1() {
		/*
	    java.util.Map<k,v>集合
	    Map集合的特点:
	        1.Map集合是一个双列集合,一个元素包含两个值(一个key,一个value)
	        2.Map集合中的元素,key和value的数据类型可以相同,也可以不同
	        3.Map集合中的元素,key是不允许重复的,value是可以重复的
	        4.Map集合中的元素,key和value是一一对应
	    java.util.HashMap<k,v>集合 implements Map<k,v>接口
	    HashMap集合的特点:
	        1.HashMap集合底层是哈希表:查询的速度特别的快
	            JDK1.8之前:数组+单向链表
	            JDK1.8之后:数组+单向链表|红黑树(链表的长度超过8):提高查询的速度
	        2.hashMap集合是一个无序的集合,存储元素和取出元素的顺序有可能不一致
	   java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>集合
	   LinkedHashMap的特点:
	        1.LinkedHashMap集合底层是哈希表+链表(保证迭代的顺序)
	        2.LinkedHashMap集合是一个有序的集合,存储元素和取出元素的顺序是一致的
		 */

		/*
        public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
            返回值:v
                存储键值对的时候,key不重复,返回值V是null
                存储键值对的时候,key重复,会使用新的value替换map中重复的value,返回被替换的value值
		 */
		Map<String, String> map = new HashMap<String, String>();
		String v1String = map.put("李晨", "范冰冰1");
		System.out.println(v1String); // null
		String v2String = map.put("李晨", "范冰冰2");
		System.out.println(v2String); // 范冰冰1

		System.out.println(map);//{李晨=范冰冰2}

		map.put("冷锋","龙小云");
		System.out.println(map);//{李晨=范冰冰2, 冷锋=龙小云}

		/*
        public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
            返回值:V
                key存在,v返回被删除的值
                key不存在,v返回null
		 */
		String nameString = map.remove("李晨");
		System.out.println(nameString);
		System.out.println(map);

		/*
        public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
            返回值:
                key存在,返回对应的value值
                key不存在,返回null
		 */
		System.out.println(map.get("冷锋"));

		/*
        boolean containsKey(Object key) 判断集合中是否包含指定的键。
        包含返回true,不包含返回false
		 */
		System.out.println(map.containsKey("冷锋"));

	}

	//	使用 keySet 遍历 Map集合
	private static void fun2() {
		/*
	    Map集合的第一种遍历方式:通过键找值的方式
	    Map集合中的方法:
	         Set<K> keySet() 返回此映射中包含的键的 Set 视图。
	    实现步骤:
	        1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一个Set集合中
	        2.遍历set集合,获取Map集合中的每一个key
	        3.通过Map集合中的方法get(key),通过key找到value
		 */
		Map<String,Integer> map = new HashMap<>();
		map.put("赵丽颖",168);
		map.put("杨颖",165);
		map.put("林志玲",178);

		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String keyString = iterator.next();
			Integer valueString = map.get(keyString);
			System.out.println(keyString+":"+valueString);
		}
		System.out.println("=============");
		for(String key:set) {
			Integer valueString = map.get(key);
			System.out.println(key+":"+valueString);
		}

	}


	//	使用 Entry 遍历 Map集合
	private static void fun3() {
		System.out.println(_FUNC_()+":"+_LINE_()+"行");
		/*
	    Map集合遍历的第二种方式:使用Entry对象遍历

	    Map集合中的方法:
	        Set<Map.Entry<K,V>> entrySet() 返回此映射中包含的映射关系的 Set 视图。

	    实现步骤:
	        1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
	        2.遍历Set集合,获取每一个Entry对象
	        3.使用Entry对象中的方法getKey()和getValue()获取键与值
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("赵丽颖",168);
		map.put("杨颖",165);
		map.put("林志玲",178);
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			String keyString = entry.getKey();
			Integer valueString = entry.getValue();
			System.out.println(keyString+":"+valueString);
		}
	}



	//	HashMap存储自定义类型键值
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private static void fun4() {
		/*
	    HashMap存储自定义类型键值
	    Map集合保证key是唯一的:
	        作为key的元素,必须重写hashCode方法和equals方法,以保证key唯一
		 */

		/*
        HashMap存储自定义类型键值
        key:String类型
            String类重写hashCode方法和equals方法,可以保证key唯一
        value:Person类型
            value可以重复(同名同年龄的人视为同一个)
		 */
		//创建HashMap集合
		HashMap<String,Person> map = new HashMap<>();
		//往集合中添加元素
		map.put("北京",new Person("张三",18));
		map.put("上海",new Person("李四",19));
		map.put("广州",new Person("王五",20));
		map.put("北京",new Person("赵六",18));
		//使用keySet加增强for遍历Map集合
		Set<String> set = map.keySet();
		for (String key : set) {
			Person value = map.get(key);
			System.out.println(key+"-->"+value);
		}
		System.out.println("=================");



		/*
        HashMap存储自定义类型键值
        key:Person类型
            Person类就必须重写hashCode方法和equals方法,以保证key唯一
        value:String类型
            可以重复
		 */
		HashMap<Person,String> map2 = new HashMap<>();
		//往集合中添加元素
		map2.put(new Person("女王",18),"英国");
		map2.put(new Person("秦始皇",18),"秦国");
		map2.put(new Person("普京",30),"俄罗斯");
		map2.put(new Person("女王",18),"毛里求斯");
		//使用entrySet和增强for遍历Map集合
		Set<Map.Entry<Person, String>> set2 = map2.entrySet();
		for (Map.Entry<Person, String> entry : set2) {
			Person key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"-->"+value);
		}
	}

	//	LinkedHashMap
	private static void fun5() {
		/*
    java.util.LinkedHashMap<K,V> entends HashMap<K,V>
    Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序。
    底层原理:
        哈希表+链表(记录元素的顺序)
		 */
		HashMap<String,String> map = new HashMap<>();
		map.put("a","a");
		map.put("c","c");
		map.put("b","b");
		map.put("a","d");
		System.out.println(map);// key不允许重复,无序 {a=d, b=b, c=c}

		LinkedHashMap<String,String> linked = new LinkedHashMap<>();
		linked.put("a","a");
		linked.put("c","c");
		linked.put("b","b");
		linked.put("a","d");
		System.out.println(linked);// key不允许重复,有序 {a=d, c=c, b=b}
	}

	//	Hashtable
	private static void fun6() {
		/*
	    java.util.Hashtable<K,V>集合 implements Map<K,V>接口

	    Hashtable:底层也是一个哈希表,是一个线程安全的集合,是单线程集合,速度慢
	    HashMap:底层是一个哈希表,是一个线程不安全的集合,是多线程的集合,速度快

	    HashMap集合(之前学的所有的集合):可以存储null值,null键
	    Hashtable集合,不能存储null值,null键

	    Hashtable和Vector集合一样,在jdk1.2版本之后被更先进的集合(HashMap,ArrayList)取代了
	    Hashtable的子类Properties依然活跃在历史舞台
	    Properties集合是一个唯一和IO流相结合的集合
		 */
		HashMap<String,String> map = new HashMap<>();
		map.put(null,"a");
		map.put("b",null);
		map.put(null,null);
		System.out.println(map);//{null=null, b=null}

		Hashtable<String,String> table = new Hashtable<>();
		//table.put(null,"a");//NullPointerException
		//table.put("b",null);//NullPointerException
		table.put(null,null);//NullPointerException

	}
	private static void fun7() {
		/*
	    JDK9的新特性:
	        List接口,Set接口,Map接口:里边增加了一个静态的方法of,可以给集合一次性添加多个元素
	        static <E> List<E> of​(E... elements)
	        使用前提:
	            当集合中存储的元素的个数已经确定了,不在改变时使用
	     注意:
	        1.of方法只适用于List接口,Set接口,Map接口,不适用于接接口的实现类
	        2.of方法的返回值是一个不能改变的集合,集合不能再使用add,put方法添加元素,会抛出异常
	        3.Set接口和Map接口在调用of方法的时候,不能有重复的元素,否则会抛出异常
		 */
		List<String> list = List.of("a", "b", "a", "c", "d");
		System.out.println(list);//[a, b, a, c, d]
		//list.add("w");//UnsupportedOperationException:不支持操作异常

		//Set<String> set = Set.of("a", "b", "a", "c", "d");//IllegalArgumentException:非法参数异常,有重复的元素
		Set<String> set = Set.of("a", "b", "c", "d");
		System.out.println(set);
		//set.add("w");//UnsupportedOperationException:不支持操作异常

		//Map<String, Integer> map = Map.of("张三", 18, "李四", 19, "王五", 20,"张三",19);////IllegalArgumentException:非法参数异常,有重复的元素
		Map<String, Integer> map = Map.of("张三", 18, "李四", 19, "王五", 20);
		System.out.println(map);//{王五=20, 李四=19, 张三=18}
		//map.put("赵四",30);//UnsupportedOperationException:不支持操作异常
	}
	private static void fun8() {

	}
	private static void fun9() {

	}

	public static String _FUNC_() { 
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1]; 
		return traceElement.getMethodName(); 
	}

	public static int _LINE_() { 
		StackTraceElement traceElement = ((new Exception()).getStackTrace())[1]; 
		return traceElement.getLineNumber(); 
	}

}
