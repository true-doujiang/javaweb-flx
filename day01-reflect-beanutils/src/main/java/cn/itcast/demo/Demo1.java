package cn.itcast.demo;

import static java.lang.System.out;

import java.util.Arrays;
/**
 * 作者: 尤欢欢
 * 日期： 2017年10月28日 下午5:23:03
 * 描述：
 */
public class Demo1 {
	
	/** String类、Arrays类 的API学习一下
	String str = "abc";
	 等效于： 
	char data[] = {'a', 'b', 'c'};
	String str = new String(data);
	 */
	public static void main(String[] args) {
		//是因为直接把out对象import进来了
		out.println("main");
		
		int[] a = new int[]{14,2,3,0};//int b[] = new int[10];
		char[] c = new char[]{95,98,97,100,33};//字符类型数组 	//查ASCII码表   33=!
		//String[] strs = new String[4];
		
		for (int i = 0; i < c.length; i++) {
			 out.println(c[i] + " "); 
		}
		
		String str = new String(c);
		out.println(str);
		
		Arrays.sort(a);
		out.println(Arrays.toString(a));
	}

}
