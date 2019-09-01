package cn.itcast.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Person {

	public String name="aaaa";
	private int password;
	private static int age=23;
	private Date birthday = new Date();
	
	//以下构造方法
	public Person(){
		System.out.println("new Person() 了");
	}
	
	public Person(String name){
		this.name=name;
		System.out.println("person name");
	}
	public Person(String name,int password){
		this.name=name;
		System.out.println("person name password");
	}
	//私有构造方法
	private Person(List list){
		System.out.println("list");
	}
	
	//以下实例方法
	public void aa1(){
		System.out.println("aa1");
	}
	
	public void aa1(String name,int password){
		System.out.println("name = "+name+" password ="+password);
	}
	
	public Class[] aa1(String name,int[] password){
		return new Class[]{Date.class};
	}
	
	private void aa1(InputStream in) throws IOException{
		String context = null;
		int len = 0;
		byte[] buffer = new byte[100];
		while((len=in.read(buffer,0,100))>0){ 
			System.out.println("len = " + len); 
			context += new String(buffer);
		}
		System.out.println(context);
	}
	
	//以下类方法
	public static void aa1(int num){
		System.out.println(num);
	}
	
	//这个方法反射要技巧
	public static void main(String []args){
		System.out.println("main");
		for(int i=0;i<args.length;i++){
			System.out.println(args[i] + ", "); 
		}
	}
	
	//这个方法好反射的
	public static void aa1(int i,String[] arr){
		System.out.println(i);
		System.out.println(arr); 
	}

	public static void aa1(String[] arr){
		System.out.println(arr); 
	}
}
