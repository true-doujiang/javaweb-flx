/**
 * 
 */
package cn.itcast.generic;

import java.util.Date;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午9:32:45
 * 描述： 
 */
public class Demo3 {

	public static void main(String[] args) {
		Demo<String> demo = new Demo<String>();
		demo.a("111");  
		Demo<Integer> demo2 = new Demo<Integer>();
		demo2.a(100);
		
		char cc[] = new char[]{'A','a'};
		char[] re = demo.b("yyy", 11, cc);
		
		Demo.c(new Date());
	}
}

//自定义类上的泛型
class Demo <T>{ //类上的泛型作用在整个类上
	
	
	public  void  a(T t){
		System.out.println(t);
	}
	
	public <E,K> K b(T t,E e,K k){
		System.out.println(t);
		System.out.println(e);
		System.out.println(k); 
		return k; 
	}	
	
	//类上的泛型不能作用于静态方法,所以要另外定义
	public static <T> T  c(T t){
		System.out.println(t);
		
		return t;
	}
}