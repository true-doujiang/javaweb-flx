package com.yhh.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.yhh.jdbc.domain.User;


public class Demo2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//加上参数:?useUnicode=true&characterEncoding=UTF-8  确保返回的链接一定是UTF-8的
		String url = "jdbc:mysql://localhost/day14?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "ok";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs  = null;  //看看ResultSet的API
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			st = conn.createStatement();  //throw 
		 	rs = st.executeQuery("select * from users");
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				//rs.getDate("birthday") 返回的是sql包的Date他又是util包的Date的子类
				//System.out.println(rs.getTime("birthday"));
				//System.out.println(rs.getTimestamp("birthday"));
				System.out.println(user);
			}
		}finally{
			if(rs!=null){
				try{
					rs.close();   //throw new 
				}catch (Exception e) {
					e.printStackTrace();
				}
				rs = null; //MySQL文档里加了这么一句
			}
			if(st!=null){
				try{
					st.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				st = null;
			}
			if(conn!=null){
				try{
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//变态的释放链接法
			/*if(rs!=null){
				try{
					rs.close();   //throw new 
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(st!=null){
						try{
							st.close();
						}catch (Exception e) {
							e.printStackTrace();
						}finally{
							if(conn!=null){
								try{
									conn.close();
								}catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}*/
		}
	}

}
