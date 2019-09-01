package cn.itcast.reflect;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		
		//反射：加载类，获得类的字节码   加载到内存里 
		
		//方式1
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		//方式2
		Class clazz1 = new Person().getClass();
		//方式3
		Class clazz2 = Person.class;
		
		System.out.println(clazz); //class cn.itcast.reflect.Person
	}

}
