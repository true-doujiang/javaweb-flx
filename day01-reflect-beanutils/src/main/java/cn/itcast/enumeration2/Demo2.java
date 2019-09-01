/**
 * 
 */
package cn.itcast.enumeration2;

import org.junit.Test;


/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午8:26:58
 * 描述： 
 */
public class Demo2 {
	
	@Test
	public void test() {
		print(Grade.B);
	}
	
	

	private void print(Grade g) {
		String value = g.getValue();
		System.out.println(value);
		String local = g.localeValue();
		System.out.println(local); 
	}
}

enum Grade{
	
	A("100-90") {
		//这里必须实现抽象方法
		@Override
		public String localeValue() {
			return "优";
		}
	}, B("89-80") {
		@Override
		public String localeValue() {
			return "良";
		}
	}, C("79-70") {
		@Override
		public String localeValue() {
			return "一般";
		}
	}, D("69-60") {
		@Override
		public String localeValue() {
			return "差";
		}
	}, E("59-0") {
		@Override
		public String localeValue() {
			return "不及格";
		}
	};// object
	
	//封装每个对象对应的分数
	private String name;
	
	//枚举类的构造函数必须为私有的
	private Grade(String name){
		this.name = name;
	}
	
	public String getValue(){
		return name;
	}

	//抽象方法
	public abstract String localeValue(); 
}
