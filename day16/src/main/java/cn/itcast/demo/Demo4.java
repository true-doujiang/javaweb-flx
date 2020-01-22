package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;

import cn.itcast.utils.JdbcPool;
import cn.itcast.utils.JdbcUtils_C3P0;
import cn.itcast.utils.JdbcUtils_DBCP;

/**
 * 测试3中连接池
 */
public class Demo4 {

	@Test
	public  void test_DBCP() throws Exception{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils_DBCP.getConnection();
			System.out.println(conn.getClass().getName());
			//org.apache.commons.dbcp.PoolingDataSource$PoolGuardConnectionWrapper
			//返回的是dbcp连接池的connection,已经被包装过了 
		}finally{
			JdbcUtils_DBCP.release(conn, st, rs);
		}
	}
	
	@Test
	public  void test_c3p0() throws Exception{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils_C3P0.getConnection();
			System.out.println(conn.getClass().getName());
			//com.mchange.v2.c3p0.impl.NewProxyConnection
			//返回的是c3p0连接池的connection,已经被包装过了 
		}finally{
			JdbcUtils_C3P0.release(conn, st, rs);
		}
	}
	
	@Test
	public  void test_MyDataSource() throws Exception{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			JdbcPool myJdbcPool = new JdbcPool();
			conn = myJdbcPool.getConnection();
			System.out.println(conn.getClass().getName());
			//cn.itcast.utils.JdbcPool$MyConnection
		}finally{
			JdbcUtils_C3P0.release(conn, st, rs);
		}
	}
	
	/**
	 * 这个测试不了，到day16_datasource工程里
	 * @throws Exception
	 */
	/*@Test
	public  void test_Tomcat() throws Exception{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils_Tomcat.getConnection();
			System.out.println(conn.getClass().getName());
		}finally{
			JdbcUtils_DBCP.release(conn, st, rs);
		}
	}*/

}
