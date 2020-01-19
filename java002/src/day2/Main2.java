package day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Main2 {

	public static void main(String[] args) {
		fun4();
	}


	//	Collection接口 集合
	private static void fun1() {
		/*
	    java.util.Collection接口
	        所有单列集合的最顶层的接口,里边定义了所有单列集合共性的方法
	        任意的单列集合都可以使用Collection接口中的方法


	    共性的方法:
	      public boolean add(E e)：  把给定的对象添加到当前集合中 。
	      public void clear() :清空集合中所有的元素。
	      public boolean remove(E e): 把给定的对象在当前集合中删除。
	      public boolean contains(E e): 判断当前集合中是否包含给定的对象。
	      public boolean isEmpty(): 判断当前集合是否为空。
	      public int size(): 返回集合中元素的个数。
	      public Object[] toArray(): 把集合中的元素，存储到数组中。
		 */

		//创建集合对象,可以使用多态
		//Collection<String> coll = new ArrayList<>();
		Collection<String> coll = new HashSet<>();
		System.out.println(coll);//重写了toString方法  []

		/*
            public boolean add(E e)：  把给定的对象添加到当前集合中 。
            返回值是一个boolean值,一般都返回true,所以可以不用接收
		 */
		boolean b1 = coll.add("张三");
		System.out.println("b1:"+b1);//b1:true
		System.out.println(coll);//[张三]
		coll.add("李四");
		coll.add("李四");
		coll.add("赵六");
		coll.add("田七");
		System.out.println(coll);//[张三, 李四, 赵六, 田七]

		/*
            public boolean remove(E e): 把给定的对象在当前集合中删除。
            返回值是一个boolean值,集合中存在元素,删除元素,返回true
                                集合中不存在元素,删除失败,返回false
		 */
		boolean b2 = coll.remove("赵六");
		System.out.println("b2:"+b2);//b2:true

		boolean b3 = coll.remove("赵四");
		System.out.println("b3:"+b3);//b3:false
		System.out.println(coll);//[张三, 李四, 田七]

		/*
            public boolean contains(E e): 判断当前集合中是否包含给定的对象。
            包含返回true
            不包含返回false
		 */
		boolean b4 = coll.contains("李四");
		System.out.println("b4:"+b4);//b4:true

		boolean b5 = coll.contains("赵四");
		System.out.println("b5:"+b5);//b5:false

		//public boolean isEmpty(): 判断当前集合是否为空。 集合为空返回true,集合不为空返回false
		boolean b6 = coll.isEmpty();
		System.out.println("b6:"+b6);//b6:false

		//public int size(): 返回集合中元素的个数。
		int size = coll.size();
		System.out.println("size:"+size);//size:3

		//public Object[] toArray(): 把集合中的元素，存储到数组中。
		Object[] arr = coll.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		//public void clear() :清空集合中所有的元素。但是不删除集合,集合还存在
		coll.clear();
		System.out.println(coll);//[]
		System.out.println(coll.isEmpty());//true
	}

	//	迭代器 增强for循环
	private static void fun2() {
		/*
	    java.util.Iterator接口:迭代器(对集合进行遍历)
	    有两个常用的方法
	        boolean hasNext() 如果仍有元素可以迭代，则返回 true。
	            判断集合中还有没有下一个元素,有就返回true,没有就返回false
	        E next() 返回迭代的下一个元素。
	            取出集合中的下一个元素
	    Iterator迭代器,是一个接口,我们无法直接使用,需要使用Iterator接口的实现类对象,获取实现类的方式比较特殊
	    Collection接口中有一个方法,叫iterator(),这个方法返回的就是迭代器的实现类对象
	        Iterator<E> iterator() 返回在此 collection 的元素上进行迭代的迭代器。

	    迭代器的使用步骤(重点):
	        1.使用集合中的方法iterator()获取迭代器的实现类对象,使用Iterator接口接收(多态)
	        2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
	        3.使用Iterator接口中的方法next取出集合中的下一个元素
		 */
		//创建一个集合对象
		Collection<String> coll = new ArrayList<>();
		//往集合中添加元素
		coll.add("姚明");
		coll.add("科比");
		coll.add("麦迪");
		coll.add("詹姆斯");
		coll.add("艾弗森");
		/*
        1.使用集合中的方法iterator()获取迭代器的实现类对象,使用Iterator接口接收(多态)
        注意:
            Iterator<E>接口也是有泛型的,迭代器的泛型跟着集合走,集合是什么泛型,迭代器就是什么泛型
		 */
		//多态  接口            实现类对象
		Iterator<String> it = coll.iterator();
		/*
        发现使用迭代器取出集合中元素的代码,是一个重复的过程
        所以我们可以使用循环优化
        不知道集合中有多少元素,使用while循环
        循环结束的条件,hasNext方法返回false
		 */
		while(it.hasNext()){
			String e = it.next();
			System.out.println(e);
		}

		/*增强for循环:用来遍历集合和数组

		格式:
			for(集合/数组的数据类型 变量名: 集合名/数组名){
				sout(变量名);
			}*/
		//		遍历数组
		int[] arr = {1,2,3,4,5};
		for(int i:arr){
			System.out.println(i);
		}
		//		遍历集合
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		for(String s : list){
			System.out.println(s);
		}
	}

	//	范型
	private static void fun4() {
		//		1.范型类的定义🍺🍺🍺🍺🍺🍺🍺🍺🍺
		/*
		 范型类的定义
		public class GenerialClass<E> {
			private E name;
			public E getName() {
				return name;
			}
			public void setName(E name) {
				this.name = name;
			}
		}
		 */
		GenerialClass<String> gClass = new GenerialClass<String>();
		gClass.setName("xiaolaopo");
		System.out.println(gClass.getName());

		//		2.含有泛型的方法🍺🍺🍺🍺🍺🍺🍺🍺🍺
		/*
		public class GenericMethod {
		    //定义一个含有泛型的方法
			public <E> void method01(E e) {
				System.out.println(e);
			}
		    //定义一个含有泛型的静态方法
			public static <S> void method02(S s){
				System.out.println(s);
			}
		}
		 */
		//创建GenericMethod对象
		GenericMethod gm = new GenericMethod();

		/*
            调用含有泛型的方法method01
            传递什么类型,泛型就是什么类型
		 */
		gm.method01(10);
		gm.method01("abc");
		gm.method01(8.8);
		gm.method01(true);
		gm.method02("静态方法,不建议创建对象使用");
		//静态方法,通过类名.方法名(参数)可以直接使用
		GenericMethod.method02("静态方法");
		GenericMethod.method02(1);

		//		3.含有泛型的接口🍺🍺🍺🍺🍺🍺🍺🍺🍺
		/* 范型接口定义
        public interface GenericInterface<E> {
        	public abstract void method(E e);
        }
		 */

		/* 接口实现类1
        public class GenericInterfaceImpl1<E> implements GenericInterface<String> {
        	@Override
        	public void method(String s) {
        		System.out.println(s);		
        	}
        }*/

		/*接口实现类2
        public class GenericInterfaceImpl2<E> implements GenericInterface<E> {
        	@Override
        	public void method(E e) {
        		System.out.println(e);
        	}
        }*/

		GenericInterfaceImpl1 gi1 = new GenericInterfaceImpl1();
		gi1.method("xiaolaopo---");

		GenericInterfaceImpl2<Integer> gi2 = new GenericInterfaceImpl2<Integer>();
		gi2.method(122);

		GenericInterfaceImpl2<String> gi3 = new GenericInterfaceImpl2<String>();
		gi3.method("xlp");

		//		3.泛型的通配符🍺🍺🍺🍺🍺🍺🍺🍺🍺
		/*
        泛型的通配符:
            ?:代表任意的数据类型
        使用方式:
            不能创建对象使用
            只能作为方法的参数使用
		 */
		ArrayList<Integer> list01 = new ArrayList<>();
		list01.add(1);
		list01.add(2);

		ArrayList<String> list02 = new ArrayList<>();
		list02.add("a");
		list02.add("b");
		printArray(list01);
		printArray(list02);

		//		4.泛型的上限限定 下限限定 🍺🍺🍺🍺🍺🍺🍺🍺🍺
		/*
	    泛型的上限限定: ? extends E  代表使用的泛型只能是E类型的子类/本身
	    泛型的下限限定: ? super E    代表使用的泛型只能是E类型的父类/本身
		 */
		Collection<Integer> list1 = new ArrayList<Integer>();
		Collection<String> list2 = new ArrayList<String>();
		Collection<Number> list3 = new ArrayList<Number>();
		Collection<Object> list4 = new ArrayList<Object>();

		getElement1(list1);
		//getElement1(list2);//报错
		getElement1(list3);
		//getElement1(list4);//报错

		//getElement2(list1);//报错
		//getElement2(list2);//报错
		getElement2(list3);
		getElement2(list4);
	}
	 // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll){}
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){}
	
	/*
    定义一个方法,能遍历所有类型的ArrayList集合
    这时候我们不知道ArrayList集合使用什么数据类型,可以泛型的通配符?来接收数据类型
    注意:
        泛型没有继承概念的
	 */
	public static void printArray(ArrayList<?> list){
		//使用迭代器遍历集合
		Iterator<?> it = list.iterator();
		while(it.hasNext()){
			//it.next()方法,取出的元素是Object,可以接收任意的数据类型
			Object o = it.next();
			System.out.println(o);
		}
	}




}
