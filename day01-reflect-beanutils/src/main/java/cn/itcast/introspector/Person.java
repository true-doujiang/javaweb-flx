package cn.itcast.introspector;

import java.util.Date;

//该类共有5个属性  属性由get或set方法决定的，不加get或set方法只能叫字段
public class Person {
	
	private String name;  	//没有set、get方法时叫：字段
	private String password;//没有set、get方法时叫：字段
	private int age;		//没有set、get方法时叫：字段
	private Date birthday;
	//还继承Object类的 getClass（）属性
	
	public void setAb(int a){	//也算一个属性ab
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
}
