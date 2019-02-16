package com.yhh.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 作者: 尤欢欢
 * 日期： 2018年2月22日 下午3:42:25
 * 描述：
 */
public class Demo1 {

	/**
	 create database day14;
	 use day14;
	 create table users(
		id int primary key,
		name varchar(40),
		password varchar(40),
		email varchar(60),
		birthday date
	);
	
	insert into users(id,name,password,email,birthday) values(1,'zs','123456','zs@sina.com','1980-12-04');
	insert into users(id,name,password,email,birthday) values(2,'lisi','123456','lisi@sina.com','1981-12-04');
	insert into users(id,name,password,email,birthday) values(3,'wangwu','123456','wangwu@sina.com','1979-12-04');
	 */
	
	/**
	 * 可以看看这几个类的API
	 * 这里的代码都是参考MySQL的文档 26连接器
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//加上参数:?useUnicode=true&characterEncoding=UTF-8  确保返回的链接一定是UTF-8的
		String url = "jdbc:mysql://localhost:3306/day14"; // url="jdbc:mysql:///day14" 也可以
		String username = "root";
		String password = "ok";
		
		//1.加载驱动   PS：在实际开发中并不推荐采用registerDriver方法注册驱动。 
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());  //jar包里的Driver
		//推荐方式：
		Class.forName("com.mysql.jdbc.Driver"); //Driver类实例化的时候自己就把自己注册到DriverManager类里了(看源码)
		//2.获取链接,链的接默认码表同安装数据库时的码表，
		Connection conn = DriverManager.getConnection(url, username, password);
		//3.获取向数据库发sql语句的statament对象
		Statement st = conn.createStatement();
		//4.向数据库发送sql，获取数据库返回的结果集   PS：rs里面维护了一个游标
		ResultSet rs = st.executeQuery("select * from users");
		//5.从结果集中获取数据
		while(rs.next()){	//控制游标移动
			System.out.print("id=" + rs.getObject("id"));  //这里偷懒  都用getObject("col")
			System.out.print(" name=" + rs.getObject("name"));
			System.out.print(" password=" + rs.getObject("password"));
			System.out.print(" email=" + rs.getObject("email"));
			System.out.print(" birthday=" + rs.getObject("birthday"));
			System.out.println();
		}
		//6.释放资源（释放链接）释放顺序反着来
		rs.close(); //释放内存里的结果集，不然占内存
		st.close();
		conn.close();//释放数据库的链接
	}

}
