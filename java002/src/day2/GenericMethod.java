package day2;

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





