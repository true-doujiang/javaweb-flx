/**
 * 
 */
package cn.itcast.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午8:35:11
 * 描述： 反射类的构造函数，创建类的对象
 */
public class Demo2 {

	
	@Test
	public void test1() throws Exception {
		//反射类的构造函数 public Person()
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);   //Person()
		System.out.println(p.name);//aaaa
	}
	
	@Test
	public void test2() throws Exception{
		//public Person(String name)
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Constructor c = clazz.getConstructor(String.class);  //参数的类型
		Person p = (Person) c.newInstance("abc");	//person name
		System.out.println(p.name);					//abc
	}
	
	@Test
	public void test3() throws Exception{
		//public Person(String name,int password)
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		//Integer.class 不可以,如果参数类型是Integer这里就必须用Integer.class
		Constructor c = clazz.getConstructor(String.class,int.class); 
		Person p = (Person) c.newInstance("abc",999);//person name password
		System.out.println(p.name);					 //abc
	}
	
	//private Person(List list)
	@Test
	public void test4() throws Exception{
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		
		//反射私有的要加Declared
		Constructor c = clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);		//暴力反射，统统打开访问权限(必须强暴它一下) 
		Person p = (Person) c.newInstance(new ArrayList());//list
		System.out.println(p.name);		//aaaa
	}
	
	//创建对象的另外一种途径，无参构造方法，等效test1  没有反射构造方法  
	@Test
	public void test5() throws Exception{
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Person p = (Person) clazz.newInstance();   //用无参构造函数创建实例，所以必须要有无参构造函数 
		System.out.println(p.name);//aaaa
	}
}
