package day12.demo01.FunctionalInterface;
/*
    @Override注解
    检查方法是否为重写的方法
        是:编译成功
        否:编译失败
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface{
	@Override
	public void method() {
		System.out.println("使用");
	}

    /*@Override
    public void method2() {

    }*/

    /*@Override
    public void method3() {

    }*/
}
