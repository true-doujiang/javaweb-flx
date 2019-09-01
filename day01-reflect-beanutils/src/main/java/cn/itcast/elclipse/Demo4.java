package cn.itcast.elclipse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo4 {
	
	private Person p;
	
	@Before
	public void before(){
		//初始化资源
		p = new Person();
		System.out.println("before");
	}
	
	@Test
	public void testRun(){
		//Person p = new Person();
		p.run();
	}
	
	@Test
	public void testEat(){
		//Person p = new Person();
		p.eat();		
	}
	
	@After
	public void after(){
		//销毁资源
		p = null;
		System.out.println("after");
	}
}
