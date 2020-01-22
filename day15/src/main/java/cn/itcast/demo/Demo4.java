package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.utils.JdbcUtils;

public class Demo4 {

	/**
	 获取自动生成的主键
	 create table test
	 (
	 	id int primary key auto_increment,
	 	name varchar(40)
	 );
	 
	 注：此参数仅对insert操作有效。
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null; //PreparedStatement
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "insert into test(name) values('vvv')";
			
			//不加Statement.RETURN_GENERATED_KEYS MySQL默认也是返回主键的     看看Connection的API
			st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			st.executeUpdate();
			
			rs = st.getGeneratedKeys(); //getGeneratedKeys() 
			if(rs.next()){
				System.out.println(rs.getInt(1));
			}
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

}
