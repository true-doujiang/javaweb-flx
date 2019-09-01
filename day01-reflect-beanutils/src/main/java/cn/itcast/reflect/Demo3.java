/**
 * 
 */
package cn.itcast.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午8:43:54
 * 描述： 
 */
public class Demo3 {

	@Test
	public void test1() throws Exception {
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		/**
		 * 第一个参数：方法的名字
		 * 第二个参数：参数类型 
		 */
		Method m = clazz.getMethod("aa1", null);
		Person p = new Person();
		m.invoke(p, null);  //aa1
	}
	
	
	@Test
	public void test2() throws Exception{
		//public void aa1(String name,int password)
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Method method = clazz.getMethod("aa1", String.class,int.class);
		Person p = new Person();		//person
		method.invoke(p, "xxxx",99);	//name= xxxx password=99
	}
	
	//public Class[] aa1(String name,int[] password)
	@Test
	public void test3() throws Exception{
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		
												//int[].class
		Method method = clazz.getMethod("aa1", String.class,int[].class);
		Person p = new Person();		//person
		Class cs[] = (Class[]) method.invoke(p, "xxxx",new int[]{1,2,3});//name= xxxx password=99
		System.out.println(cs[0]);		//class java.util.Date
	}
	
	@Test
	public void test4() throws Exception{
		//private void aa1(InputStream in)
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Method method = clazz.getDeclaredMethod("aa1",InputStream.class);
		method.setAccessible(true);  //强暴她
		Person p = new Person();	//Person()
		method.invoke(p,new FileInputStream("E://迅雷下载/JavaWeb-方立勋/视频说明.txt"));//
	}
	
	@Test
	public void test5() throws Exception{
		//public static void aa1(int num)
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Method method = clazz.getMethod("aa1",int.class);
		method.invoke(null,777);	//777  静态方法调用不需要对象，给对象也行
	}
	
	
		@Test
		public void test6() throws Exception{
			// 陷阱	public static void main(String []args){
			Class clazz = Class.forName("cn.itcast.reflect.Person");
			Method method = clazz.getMethod("main",String [].class);
			//java.lang.IllegalArgumentException: wrong number of arguments 错误的参数个数
			//method.invoke(null,new String[]{"a","c"});	 
			
			//同上
			//method.invoke(null,"a","c");	
			//java.lang.IllegalArgumentException: argument type mismatch
			//method.invoke(null,"a");		
			
			String []str = {"xa","ya","za"};
			method.invoke(null,(Object)str);	//欺骗法 ,它看到数组就会拆一下，我活我不是数组，它就相信了，不拆了
			//method.invoke(null,new Object[]{new String[]{"a","c"} });	//让他拆一次
			//method.invoke(null,(Object)new String[]{"a","c"}); 		//同上上  欺骗法
		}
		
		/**	jdk1.4和jdk1.5的invoke方法的区别：
			Jdk1.5：public Object invoke(Object obj,Object... args)
			Jdk1.4：public Object invoke(Object obj,Object[] args)，
			即按jdk1.4的语法，需要将一个数组作为参数传递给invoke方法时，数组中的每个元素分别对应被调用方法中的一个参数，
			所以，调用charAt方法的代码也可以用Jdk1.4改写为 charAt.invoke(“str”, new Object[]{1})形式。
		*/
		
		
		//public static void aa1(int i,String[] arr){
		@Test
		public void test7() throws Exception{
			Class clazz = Class.forName("cn.itcast.reflect.Person");
			
			Method method = clazz.getMethod("aa1",int.class,String[].class);
			method.invoke(null,12,new String[]{"a","c"});	
			
			String []str = {"xa","ya","za"};
			//method.invoke(null, 100,str);	
		}
		
		//public static void aa1(String[] arr){
		@Test
		public void test8() throws Exception{
			Class clazz = Class.forName("cn.itcast.reflect.Person");
			
			Method method = clazz.getMethod("aa1",String[].class);
			/**
			 *  java.lang.IllegalArgumentException: wrong number of arguments
			 *  method.invoke(null,new String[]{"a","c"});  jdk1.4把String数组拆开变成了参数"a"、参数"c" 而方法要的是String[]一个参数，所以会包参数个数不对
			 *  
			 *  java.lang.IllegalArgumentException: argument type mismatch
			 *  method.invoke(null,new String[]{"c"});      jdk1.4把String数组拆开变成了参数"c"而方法要的是String[]类型的参数，所以会包参数类型不匹配了
			 *  
			 */
			method.invoke(null, (Object)new String[]{"a","c"});
			/**
			 * jdk1.4把参数(Object)new String[]{"a","c"}拆成new String[]{"a","c"}刚好满足要求
			 */
		}
		
}
