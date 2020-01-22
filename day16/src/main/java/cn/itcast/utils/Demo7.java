package cn.itcast.utils;

import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import cn.itcast.domain.Account;
/**
 * 这个Demo7之所以放在这里是因为JdbcUtils类里的结果处理器类权限是default的
 *
 */
//假设他是Dao
public class Demo7 {

	@Test
	public void test1() throws SQLException{
		Account a = new Account();
		a.setMoney(100000);
		a.setName("vvvvvv");
		add(a);
	}
	
	@Test
	public void test2() throws SQLException{
		delete(1);
	}
	
	@Test
	public void test3() throws SQLException{
		Account a = new Account();
		a.setMoney(9);
		a.setName("nnnn");
		a.setId(9);
		update(a);
	}
	
	@Test
	public void test4() throws SQLException{
		Account a = find(2);
		System.out.println(a.getId());
		System.out.println(a.getName());
		System.out.println(a.getMoney());
	}
	
	@Test
	public void test5() throws SQLException{
		List list = getAll();
		System.out.println(list);
	}
	
//========上面都是测试下面的方法========使用我自己jdbc框架=====================//	
	
	public void add(Account a) throws SQLException{
		String sql = "insert into account(name,money) values(?,?)";
		Object params[] = {a.getName(),a.getMoney()};
		JdbcUtils.update(sql, params);
	}
	
	public void delete(int id) throws SQLException{
		String sql = "delete from account where id=?";
		Object params[] = {id};
		JdbcUtils.update(sql, params);
	}
	
	public void update(Account a) throws SQLException{
		String sql = "update account set name=?,money=? where id=?";
		Object params[] = {a.getName(),a.getMoney(),a.getId()};
		JdbcUtils.update(sql, params);
	}
	
	
	
	public Account find(int id) throws SQLException{
		String sql = "select * from account where id=?";
		Object params[]= {id};
		return (Account) JdbcUtils.query(sql, params, new BeanHandler(Account.class));
	}
	
	public List getAll() throws SQLException{
		String sql = "select * from account";
		Object params[] = {};
		//不要参数也要传递一个空数组，弱了
		return (List) JdbcUtils.query(sql, params, new BeanListHandler(Account.class));
	}
	
}
