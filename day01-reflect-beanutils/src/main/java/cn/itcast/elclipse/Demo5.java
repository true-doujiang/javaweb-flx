package cn.itcast.elclipse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Demo5 {
	//运行类才能看出效果
	
	@BeforeClass  //此方法必须静态   只执行一次
	public static void beforeClass(){
		System.out.println("beforeclass");
	}
	
	@Test
	public void testRun(){
		Person p=new Person();
		p.run();
	}
	
	@Test
	public void testEat(){
		Person p=new Person();
		p.eat();		
	}
	
	@AfterClass  //此方法必须静态    只执行一次
	public static void afterClass(){
		System.out.println("afterclass");
	}
}
