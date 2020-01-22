package cn.itcast.utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**编写自己的jdbc框架  
 * 缺点:1、bean的属性名必须与字段名相同
 * 2、sql没有参数也要传个空数组
 * 
 * 原来是没有连接池的，现在这个类被改成使用dbcp连接池了
 * 所以db.properties属性文件在本工程里没用了
 */
public class JdbcUtils {
	
	private static DataSource ds = null;
	static{
		try{
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			ds = factory.createDataSource(prop);
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

	
	//insert update delete功能
	//String sql = "insert into account(id,name,money) values(?,?,?)"   object[]{1,"aaa","10000"};
	public static void update(String sql,Object params[]) throws SQLException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1,params[i]); //直接用setObject
			}
			st.executeUpdate();
		}finally{
			release(conn, st, rs);
		}
	}
	
	//find功能       Account List --Object   这个有技术含量     不要参数也要传递一个空数组，弱了
	public static Object query(String sql,Object params[],ResultSetHandler handler) throws SQLException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1,params[i]);
			}
			rs = st.executeQuery();
			//我又不知道用户用那一个处理器列所以只能用handler接口啊
			return handler.handler(rs);
		}finally{
			release(conn, st, rs);
		}
	}
}//JdbcUtils	

//--------------------------------------------------------------//

//结果处理器接口
interface ResultSetHandler{
	public Object handler(ResultSet rs);
}

//结果处理器实现类1，对常用的结果类型进行设计的
class BeanHandler implements ResultSetHandler{
	
	private Class clazz;
	public BeanHandler(Class clazz){//这里也可以直接接收要返回的对象，但是不优雅
		this.clazz = clazz;
	}
	
	public Object handler(ResultSet rs) {
		try{
			if(!rs.next()){  //结果集里没有数据
				return null;
			}
			//1、创建封装结果集的bean
			Object bean = clazz.newInstance();
			//得到结果集的元数据，以获取结果集的信息
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for(int i=0;i<count;i++){
				String name = meta.getColumnName(i+1); //获取到结果集每列的列名  id
				Object value = rs.getObject(name);     //获取这列的值
				//反射出bean上与列名相应的属性
				Field f = bean.getClass().getDeclaredField(name);
				f.setAccessible(true);   //属性一般私有的，所以强暴它一下
				f.set(bean, value);
			}
			return bean;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
//结果处理器实现类2
class BeanListHandler implements ResultSetHandler{
	private Class clazz;
	public BeanListHandler(Class clazz){
		this.clazz = clazz;
	}
	
	public Object handler(ResultSet rs) {
		List list = new ArrayList();
		try{
			while(rs.next()){
				Object bean = clazz.newInstance();
				ResultSetMetaData  meta = rs.getMetaData();
				int count = meta.getColumnCount();
				for(int i=0;i<count;i++){
					String name = meta.getColumnName(i+1);
					Object value = rs.getObject(name);
					Field f = bean.getClass().getDeclaredField(name);
					f.setAccessible(true);
					f.set(bean, value);
				}
				list.add(bean);
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}

