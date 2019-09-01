package cn.itcast.beanutils;

import java.util.Date;

public class Person {
	
	private String name;
	private String password;
	private int age;
	private Date birthday;
	private Idea idea;  //如果设置的属性值是其他的引用数据类型，此时必须要注册一个类型转换器才能实现自动的转换
	
	
	
	public Idea getIdea() {
		return idea;
	}
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", birthday=" + birthday + ", idea="
				+ idea + ", name=" + name + ", password=" + password + "]";
	}
}
