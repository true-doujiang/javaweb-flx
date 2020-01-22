package cn.itcast.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils;
import org.junit.Test;

public class Demo1 {

	/**
	 1、基本概念：大数据也称之为LOB(Large Objects)，LOB又分为：
	 	clob和blob
		clob用于存储大文本。Text
		blob用于存储二进制数据，例如图像、声音、二进制文等。
	
	 2、对MySQL而言只有blob，而没有clob，mysql存储大文本采用的是Text，Text和blob分别又分为：
	 TINYTEXT、TEXT、MEDIUMTEXT和LONGTEXT
	 TINYBLOB、BLOB、MEDIUMBLOB和LONGBLOB 
	 
	 具体的看 jdbc2.ppt
	 
	 读写大文本
	 create table testclob
	 (
	 	id varchar(40) primary key,
	 	resume text
	 );

	 */
	@Test
	public void insert() throws SQLException, FileNotFoundException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "insert into testclob(id,resume) values(?,?)";
			st = conn.prepareStatement(sql);
			
			st.setString(1, "5"); 
			File file = new File("C:\\Users\\Administrator\\Desktop\\ssr.txt"); //普通Java工程可以这么写
			FileReader reader = new FileReader(file); //这样的东西不可以读到内存里，因为太大的话会导致内存溢出,所以一定要用流
			//第2个参数要流
			st.setCharacterStream(2, reader, (int)file.length()); //jdk1.6就不要强转了，因为这个被方法就重载了
			
			int num = st.executeUpdate();
			if(num>0){
				System.out.println("插入成功！！");
			}
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	@Test
	public void read() throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select id,resume from testclob where id='1'";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				//1.此方法也可以取出数据，但是当resume里的数据非常大时，就会导致内存溢出 (不推荐)
				//String resume = rs.getString("resume"); 
				//2、返回的是字符流
				Reader reader = rs.getCharacterStream("resume"); 
				//3. 也可  reader = rs.getClob(2).getCharacterStream();
				FileWriter writer = new FileWriter("e:\\1.txt");
				try {
					int len = 0;
					char buffer[] = new char[1024];  //字符数组不是字节数组
					while ((len = reader.read(buffer)) > 0) {
						writer.write(buffer, 0, len);
					}
				} finally {
					if (reader != null) {
						reader.close();   //流一定要关闭，不然网站会越来越卡，最好就崩了
					}
					writer.close();
				}
			}
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	@Test
	public void testMuLu(){
		File file = new File("src/1.txt"); //普通Java工程可以这么写
		System.out.println(file.getAbsolutePath()); 
		//C:\Users\Administrator\Workspaces\MyEclipse 8.5\day15\src\1.txt
		System.out.println(file.getPath());
		
		File file2 = new File(""); 
		System.out.println(file2.getAbsolutePath()); 
		//C:\Users\Administrator\Workspaces\MyEclipse 8.5\day15
		System.out.println(file2.getPath()); //获取相对路径 "" 也就是空了
		/**
		 * 如果是web工程此时的new File("");是相对于tomcat的启动目录bin
		 */
	}
	
}
