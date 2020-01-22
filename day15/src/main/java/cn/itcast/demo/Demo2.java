package cn.itcast.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils;
import org.junit.Test;


public class Demo2 {

	/*
	 create table testblob
	 (
	 	id varchar(40) primary key,
	 	image blob
	 ); 
	 
	实际项目中并不会直接把图片存到数据库里，如果很多占内存，占链接
	 */
	
	@Test
	public void insert() throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "insert into testblob(id,image) values(?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, "3");
			File file = new File("src/1.jpg");
			FileInputStream in = new FileInputStream(file);
			//设置二进制数据
			st.setBinaryStream(2, in, (int) file.length());
			st.executeUpdate();
			in.close();
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
			String sql = "select id,image from testblob where id='1'";
			rs = conn.prepareStatement(sql).executeQuery();
			if(rs.next()){
				InputStream in = rs.getBinaryStream("image");
				//InputStream in2 = rs.getBlob(2).getBinaryStream();
				OutputStream out = new FileOutputStream("e:\\1.jpg");;
				try {
					int len = 0;
					byte buffer[] = new byte[1024]; //字节数组
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
				} finally {
					if (in != null)
						in.close();
					if (out != null)
						out.close();
				}
			}
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
}
