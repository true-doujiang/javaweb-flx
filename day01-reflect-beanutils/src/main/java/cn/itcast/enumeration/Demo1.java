/**
 * 
 */
package cn.itcast.enumeration;

import org.junit.Test;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午8:09:13
 * 描述： 
 */
public class Demo1 {

	
	@Test
	public void test() {
		print(Grade.B);
	}
	
	@Test
	public void test2(){
		System.out.println(Grade.A.name());
		System.out.println(Grade.C.ordinal());
		
		//把字符串转成枚举
		String str = "E";
		//Grade g = Grade.valueOf(Grade.class, str);
		Grade g = Grade.valueOf(str);
		System.out.println(g.getValue());
		
		/** values() 此方法虽然在JDK文档中查找不到，
		 *  但每个枚举类都具有该方法，它遍历枚举类的所有枚举值非常方便。
		 */
		Grade[] values = Grade.values();
		for (Grade grade : values) {
			System.out.println(grade+"("+grade.getValue()+")");
		}
	}

	private void print(Grade g) {
		String value = g.getValue();
		System.out.println(value);
	}
}

enum Grade{
	
	A("100-90"), B("89-80"), C("79-70"), D("69-60"), E("59-0");// object
	
	//封装每个对象对应的分数
	private String name;
	
	//枚举类的构造函数必须为私有的
	private Grade(String name){
		this.name = name;
	}
	
	public String getValue(){
		return name;
	}

	/*这也可以的
	public String getName() {
		return name;
	}*/
}

/*
JDK1.5之前没有枚举
class Grade{ 
	private Grade(){ }
	public static final Grade A=new Grade();
	public static final Grade B=new Grade();
	public static final Grade C=new Grade(); 
	public static final Grade D=new Grade();
	public static final Grade E=new Grade(); 
}
*/
