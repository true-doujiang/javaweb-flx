package cn.itcast.elclipse;

import junit.framework.Assert;

import org.junit.Test;

public class Demo6 {
	
	@Test
	public void testRun(){
		Person p = new Person();
		Assert.assertEquals("2", p.run());
	}
}
