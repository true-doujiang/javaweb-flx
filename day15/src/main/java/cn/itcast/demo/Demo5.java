package cn.itcast.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import cn.itcast.utils.JdbcUtils;


public class Demo5 {

/**
	 调用存储过程：银行用的多，表结构都不会让程序员看到，只对外提供存储过程给程序员使用 
	 
 	delimiter $$

	CREATE PROCEDURE demoSp(IN inputParam VARCHAR(255), INOUT inOutParam varchar(255))
	BEGIN
	    SELECT CONCAT('zyxw---', inputParam) into inOutParam;
	END $$
	
	delimiter ;
	
 */
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		CallableStatement  st = null;   //CallableStatement
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			st = conn.prepareCall("{call demoSp(?,?)}");
			st.setString(1, "和规范和规范化");
			
			//Types.VARCHAR  告诉MySQL驱动存储过程返回值的类型   java.sql.Types 类里封装了所有的数据库数据类型
			st.registerOutParameter(2, Types.VARCHAR);
			st.execute();
			
			System.out.println(st.getString(2));
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

}
