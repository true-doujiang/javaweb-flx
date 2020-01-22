package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils_DBCP;

public class Demo1 {

	/**
	 create database day16;
	 create table account(
		id int primary key auto_increment,
		name varchar(40),
		money float
	 )character set utf8 collate utf8_general_ci;
	
	insert into account(name,money) values('aaa',1000);
	insert into account(name,money) values('bbb',1000);
	insert into account(name,money) values('ccc',1000);

	 a--->b转100元
	 * @throws SQLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws SQLException, InterruptedException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils_DBCP.getConnection();
			conn.setAutoCommit(false);    //start transaction; 默认是提交事务的
			
			String sql1 = "update account set money=money-100 where name='aaa'";
			String sql2 = "update account set money=money+100 where name='bbb'";
			
			st = conn.prepareStatement(sql1);
			st.executeUpdate();
			
			//Thread.sleep(5000);  //5s   赶紧看下DB
			//int x = 1/0; //模拟异常
			
			st = conn.prepareStatement(sql2);
			st.executeUpdate();
			
			conn.commit();           //commit;  这个时候Java才真正的发出sql语句
		}finally{
			//抛异常后就会到我这里，我有没有commit，所以数据库就会自动回滚了
			JdbcUtils_DBCP.release(conn, st, rs);
		}
		System.out.println("over");
	}

}
