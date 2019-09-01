package cn.itcast.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;


//这里内省 不需要导入任何jar包 ,这是sun公司操作bean的工具。
//但是Apache觉得太垃圾所以自己又开发了beanutils框架
public class Demo1 {
	
	//得到bean所有属性
	@Test
	public void test1() throws IntrospectionException{
		//查JDK的API Introspector  java.beans.*   	Introspector 内省、反省
		BeanInfo info = Introspector.getBeanInfo(Person.class);  //获取所有“属性”
		//去掉Object里的属性
		//BeanInfo info=Introspector.getBeanInfo(Person.class,Object.class);
		
		//获取每个属性的 属性描述器
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
			//ab age class name	password
		}
	}
	
	//操纵bean的指定属性：age   直接new属性描述器
	@Test
	public void test2() throws  Exception{
		Person p = new Person();
		//属性描述器可以直接new
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		//得到属性的写方法，为属性赋值
		Method method = pd.getWriteMethod();
		method.invoke(p, 45);
		System.out.println(p.getAge());//45
		
		//获取属性的值
		method = pd.getReadMethod();  //得到属性的读方法，
		System.out.println(method.invoke(p, null));//45
	}
	
	
	//高级内容，获取当前操作的属性的类型
	@Test
	public void test3() throws  Exception{
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
			
		//得到属性的写方法，为属性赋值
		Method method = pd.getWriteMethod();
		Class claxx = pd.getPropertyType();
		System.out.println(claxx);//int 
	}
}
