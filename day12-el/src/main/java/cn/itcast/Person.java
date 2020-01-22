package cn.itcast;

import lombok.Data;

import java.util.Date;


@Data
public class Person {
	
	private String name = "aaa";
	private String password;
	private int age;
	private Date birthday;
	private Address address;
	

	
	
	
}
