package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils_C3P0;

/**
 * 编写自己的jdbc框架，先储备的知识  看jdbc3.PPT
 * 元数据：数据库、表、列的定义信息。（做框架使用）
 */
public class Demo5 {

	/** 获取数据库的元数据
	 */
	@Test
	public void test1() throws SQLException{
		Connection conn = JdbcUtils_C3P0.getConnection();
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println(meta.getDatabaseProductName()); //MySQL
		System.out.println(meta.getDatabaseMajorVersion());//5
		System.out.println(meta.getDatabaseMinorVersion());//0
		//还有自己试试看
	}
	
	/** 参数元数据
	 */
	@Test
	public void test2() throws SQLException{
		Connection conn = JdbcUtils_C3P0.getConnection();
		String sql = "insert into user(id,name) values(?,?)"; //sql随便写的
		PreparedStatement st = conn.prepareStatement(sql);
		ParameterMetaData meta = st.getParameterMetaData();
		
		System.out.println(meta.getParameterCount());
		//mysql的驱动不支持获取参数的类型，所以这里会抛异常
		//System.out.println(meta.getParameterType(1));
	}
	
	/** 结果集元数据
	 */
	@Test
	public void test3() throws SQLException{
		Connection conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from account";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ResultSetMetaData  meta = rs.getMetaData();
		System.out.println(meta.getColumnCount());
		System.out.println(meta.getColumnName(1));
		System.out.println(meta.getColumnTypeName(1));
		System.out.println(meta.getColumnName(2));
		System.out.println(meta.getColumnTypeName(2));
		System.out.println(meta.getColumnName(3));	
		System.out.println(meta.getColumnTypeName(3));
	}
}
