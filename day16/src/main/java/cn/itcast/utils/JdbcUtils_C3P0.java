package cn.itcast.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 使用c3p0连接池的工具类
 */
public class JdbcUtils_C3P0 {
	/*
	 * c3p0-0.9.2-pre1.jar  mchange-commons-0.2.jar 
	 * 如果是Oracle还要加入 c3p0-oracle-thin-extras-0.9.2-pre1.jar
	 * 
	 * 看看文档就知道了
	 * By default, c3p0 will look for an XML configuration file 
	 * 		in its classloader's resource path under the name "/c3p0-config.xml". 
	 * That means the XML file should be placed in a directly or jar file directly named 
	 * 	in your applications CLASSPATH, in WEB-INF/classes, or some similar location. 
	 */
	
	private static ComboPooledDataSource ds = null;
	static{
		try{
			ds = new ComboPooledDataSource(); //这里使用c3p0.xml里的默认链接
			//ds = new ComboPooledDataSource("mysql"); //这里使用c3p0.xml里的mysql链接
		}catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();   //throw new 
			}catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
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
	}
}	
