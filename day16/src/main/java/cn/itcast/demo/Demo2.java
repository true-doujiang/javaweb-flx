package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import cn.itcast.utils.JdbcUtils_DBCP;

public class Demo2 {

	/** 事务的四大特性(ACID)
	 * 1、原子性: 指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
	 * 2、一致性: 事务前后数据的完整性必须保持一致(eg: 银行转账)。
	 * 3、隔离性(重点): 事务的隔离性是多个用户 并发访问 数据库时，数据库为每一个用户开启的事务，
	 *               不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
	 * 4、持久性: 指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，
	 * 			   接下来即使数据库发生故障也不应该对其有任何影响。(这个好屌 断电了怎么办)
	 */
	
	//事务回滚点
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try{
			conn = JdbcUtils_DBCP.getConnection();   //mysql默认的事务隔离级别 repeatable read
			conn.setAutoCommit(false);    //start transaction;
			
			String sql1 = "update account set money=money-100 where name='aaa'";
			String sql2 = "update account set money=money+100 where name='bbb'";
			String sql3 = "update account set money=money+100 where name='ccc'";
			
			st = conn.prepareStatement(sql1);
			st.executeUpdate();
			
			sp = conn.setSavepoint(); //设置回滚点（从异常的地方回滚到这个点）
			
			st = conn.prepareStatement(sql2);
			st.executeUpdate();
			
			int x = 1/0;//异常
			
			st = conn.prepareStatement(sql3);
			st.executeUpdate();
			
			conn.commit();
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback(sp);//手动回滚
			conn.commit();    //切记： 手动回滚后，一定要记得提交事务,否则"MySQL"会将所有的sql都回滚掉
		}finally{
			JdbcUtils_DBCP.release(conn, st, rs);
		}
	}

}
