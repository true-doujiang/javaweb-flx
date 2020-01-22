package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.itcast.utils.JdbcUtils_DBCP;

public class Demo3 {

/** SQL标准定义了4种数据库隔离级别：MySQL全部支持、Oracle支持Serializable、read committed(默认的)
Serializable：可避免脏读、不可重复读、虚读情况的发生。（加锁了）别的事务要想操作表需要等到当前事务提交之后。
Repeatable read：可避免脏读、不可重复读情况的发生。 PS:这个级别比较特殊，居然在大多数情况下是可以避免虚读(幻读)的。但是毕竟不是专业防止幻读的
Read committed：可避免脏读情况发生（读已提交）。
Read uncommitted：最低级别，以上情况均无法保证。(读未提交)

set transaction isolation level xx; 设置事务隔离级别
select @@tx_isolation;	查询当前事务隔离级别  

 */
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			//MySQL的默认隔离级别：repeatable read
			//PS:这个级别比较特殊，居然在大多数情况下是可以避免虚读(幻读)的。但是毕竟不是专业防止幻读的
			conn = JdbcUtils_DBCP.getConnection(); 
			//设置隔离级别
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			conn.setAutoCommit(false);    //start transaction;
			
			String sql = "select * from account";
			rs = conn.prepareStatement(sql).executeQuery();
			
			Thread.sleep(1000*10);
			
			conn.commit();
			
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}

			//再使用命令行窗口start transaction 插入这张表观察效果
		}finally{
			JdbcUtils_DBCP.release(conn, st, rs);
		}
	}
}
