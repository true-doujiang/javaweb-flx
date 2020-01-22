package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.utils.JdbcUtils;
import org.junit.Test;


public class Demo3 {

	/*
	 create table testbatch
	 (
	 	id varchar(40) primary key,
	 	name varchar(40)
	 );
	 
	 truncate table testbatch; 删除所有数据块       摧毁表重建表结构
	*/
	
	
	/**
	 * 实现批处理第一种方式
	 * 1.可以发多条sql
	 * 2.sql没有预处理
	 * 
	 * 优点：可以向数据库发送多条不同的ＳＱＬ语句。
	 * 缺点：
	 *	SQL语句没有预编译。
	 *	当向数据库发送多条语句相同，但仅参数不同的SQL语句时，需重复写上很多条SQL语句
	 */
	@Test
	public void test1() throws SQLException{
		Connection conn = null;
		Statement st = null; //不是PreparedStatement
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql1 = "insert into testbatch(id,name) values('1','aaa')";
			String sql2 = "update testbatch set name='bbb' where id='1'";
			
			st = conn.createStatement();  //st里维护了一个list
			st.addBatch(sql1);
			st.addBatch(sql2);
			
			//[3,4]  每条sql语句影响的行数
			int a[] = st.executeBatch();
			st.clearBatch();//清除批处理命令  别忘了
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	
	/**
	 * 实现批处理的第二种方式
	 * 1.只有一条sql，适合做批量插入、批量更新
	 * 2.sql语句预处理了(对应同一个sql语句要执行多次的话，最好将它预编译，以调高DB性能)
	 * 
	 * 优点：发送的是预编译后的SQL语句，执行效率高。
	 * 缺点：只能应用在SQL语句相同，但参数不同的批处理中。
	 *      因此此种形式的批处理经常用于在同一个表中批量插入数据，或批量更新表的数据。
	 * 
	 * MySQL 1s大概能插入1000条，一千万条要花3个小时
	 * Oracle 3分钟就可以插完。
	 * 
	 * 我的MySQL 插入1000条要70s左右  弱爆了
	 */
	/*
	 sql = "INSERT INTO testbatch (name,password) VALUES
		('张三','123'),
		('李四','123'),
		('王五','123'),
		('赵六','123'),
		('田七','123')........";
		这样效率更高点
	 */
	@Test
	public void test2() throws SQLException{
		long starttime = System.currentTimeMillis(); 
		Connection conn = null;
		PreparedStatement st = null; //是PreparedStatement
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "insert into testbatch(id,name) values(?,?)"; //作批量插入   批量更新
			st = conn.prepareStatement(sql);
			for(int i=1;i<=1000;i++){
				st.setString(1, i+"");
				st.setString(2, "aa" + i);
				st.addBatch();	//添加到st维护的list里
				if(i%10==0){
					st.executeBatch();
					st.clearBatch();
				}
			}
			st.executeBatch();
			st.clearBatch();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		long endtime = System.currentTimeMillis(); 
		System.out.println("PreparedStatement总花了：" + (endtime-starttime)/1000 + "秒");
	}
	
	/**
	 * Statement与PreparedStatement做性能对比
	 */
	@Test
	public void test3() throws SQLException{
		long starttime = System.currentTimeMillis();
		Connection conn = null;
		Statement st = null; //不是PreparedStatement
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();  //st里维护了一个list
			for(int i=1; i<=1000; i++){
				String sql1 = "insert into testbatch(id,name) values('"+i+"','aaa')";
				st.addBatch(sql1);
				if(i%10==0){
					st.executeBatch();
					st.clearBatch();
				}
			}
			st.executeBatch();
			st.clearBatch();//清除批处理命令  别忘了
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		long endtime = System.currentTimeMillis(); 
		System.out.println("Statement总花了：" + (endtime-starttime)/1000 + "秒");
	}
}
