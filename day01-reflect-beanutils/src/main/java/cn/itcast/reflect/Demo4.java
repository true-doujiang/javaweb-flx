package cn.itcast.reflect;

import java.lang.reflect.Field;
import java.util.Date;

import org.junit.Test;

/**
 * 作者: 尤欢欢
 * 日期： 2017年10月28日 下午9:04:41
 * 描述： 反射类的字段  给它灌点数据
 */
public class Demo4 {
	
	@Test
	public void test1() throws Exception{
		//public String name="aaaa";
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		//Field field[] = clazz.getFields();  //获取所有字段
		Field f = clazz.getField("name");		
		Person p = new Person();		
		Object value = f.get(p);	//获取字段值  sun公司也不知道p的name属性里封装的是什么类型的值
		Class type = f.getType();	//字段类型
		System.out.println(type);	//class java.lang.String
		
		if(type.equals(String.class)){
			String S_value = (String)value;
			System.out.println(S_value);	//aaaa
		}
		
		//设置值
		f.set(p, "ppppp");
		System.out.println(f.get(p));//ppppp
	}
	
	@Test
	public void test2() throws Exception{
		//private int password;
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		// 反射私有的东西都要加Declared
		Field f = clazz.getDeclaredField("password");
		f.setAccessible(true);
		Person p = new Person();
		f.set(p, 123);
		System.out.println(f.get(p));// 123	
	}
	
	@Test
	public void test3() throws Exception{
		//private static int age=23;
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(null));// 23 //静态字段
	}
	
	@Test
	public void test4() throws Exception{
		//private Date birthday;
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Person p = new Person();
		Field f[] = clazz.getDeclaredFields();
		for(int i=0;i<f.length;i++){
			Field field = f[i];
			String fieldName = field.getName();
			System.out.println(fieldName);
			
			if(fieldName.equals("birthday")){
				field.setAccessible(true);	
				System.out.println( ((Date)field.get(p)).toLocaleString() );//23	
			}
		}
	}
	
}
