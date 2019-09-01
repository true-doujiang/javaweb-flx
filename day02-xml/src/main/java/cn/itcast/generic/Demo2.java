package cn.itcast.generic;

import org.junit.Test;

//自定义带泛型的方法
public class Demo2 {
	
	@Test
	public void test1() {
		String a = a("4"); 
		Integer a2 = a(4);  
		System.out.println(a);
		System.out.println(a2);
		
		int arr[] = c("123");
		System.out.println(arr); 
	}
	
	
	@Test
	public void testa(){
		String result1 = a("aaaa");
		System.out.println(result1);
		
		int result2 = a(100);
		System.out.println(result2);
	}
	
	//先定义<T>，在使用
	public <T> T  a(T t){
		
		return t;
	}
	
	public <T,E,K> void b(T t,E e,K k){
		
	}
	
	public <T,E> E c(T t){
		int arr[] = {1,2,3};
		
		return (E) arr;
	}
	

}
