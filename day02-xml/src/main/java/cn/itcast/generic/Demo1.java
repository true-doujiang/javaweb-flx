package cn.itcast.generic;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Demo1 {
	
	@Test
	public void test1(){
		List list = new ArrayList();
		list.add("111");
		list.add("222");
		list.add("333");
		//传统方式手工转换
		String i = (String) list.get(0);
		//下面注释代码手工转换编辑不报错，运行错误
		//Integer ii=(Integer) list.get(0);		
		System.out.println(i);		
	}
	
	@Test
	public void test2(){
		List <String>list=new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		//现在不需要强制转换
		String i=list.get(0);
		//下面注释代码编译通不过
		//Integer ii=(Integer) list.get(0);		
		System.out.println(i);		
	}
}
