package cn.itcast.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * 如果读取资源文件的程序不是servlet的话，就只能通过类转载器去读了，文件不能太大。
 * PS: 放在内存里占空间，会导致内存溢出）
 */
public class UserDao {

	private static Properties dbconfig = new Properties();
	
	/**
	 * 代码块里的异常不能抛了
	 * 装载配置方法一：不能加载改动后的配置文件，只加载一次
	 */
//	static {
//		/**
//		 * 通过类装载器加载配置文件，原理同加载类，只在第一次加载，以后就不加载了，并不是因为静态代码块的原因
//		 * 所以修改配置文件（服务器里的）也不加载了
//		 */
//												//src 相当于 classes 目录             若在WEB-INF下路径为    "..\\db.properties"
//		InputStream in = UserDao.class.getClassLoader().getResourceAsStream("db.properties");
//		try {
//			dbconfig.load(in);
//		} catch (IOException e) {
//			throw new ExceptionInInitializerError(e);
//		}	
//	}
	
	/**
	 * 装载配置方法二 更好：能加载改动后的配置文件(改tomcat里的db.properties)，只加载一次	
	 */
	static{
		/**
		 * 1.通过类装载方式得到资源文件位置
		 * 2.在通过传统方式读取资源文件数据，这样可以读取更新后的资源  
		 * 3.修改服务器里的配置文件
		 * 
		 * 4.但是这里又放在静态代码块里所以又不能加载修改后的了
		 * http://blog.163.com/baijie_1123/blog/static/133104049201112611858184/
		 */
		URL url = UserDao.class.getClassLoader().getResource("db.properties");
		String path = url.getPath(); //通过类装载器获取资源文件的路径
		System.out.println(Thread.currentThread().getName() + " path= " + path);
		//有空格路径就不对了   D:/Program%20Files%20(x86)/apache-tomcat-6.0.43/webapps/day05/WEB-INF/classes/db.properties
		
		try {								
			InputStream in2 = new FileInputStream(URLDecoder.decode(path, "UTF-8"));
			dbconfig.load(in2);
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	public void update() {
		
		//这里是为了证明db.properties只加载一次并不是因为静态代码块的原因
		InputStream inputStream = UserDao.class.getClassLoader().getResourceAsStream("db.properties"); //就这一句只执行一次
		
		try {
			dbconfig.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(dbconfig.get("url"));
	}
}
 