package cn.itcast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 讲解 ServletContext对象(接口)
 *	 
 *	6、利用ServletContext对象读取资源文件。
 *	           ① 得到文件路径
 *	           ②读取资源文件的三种方式
 *	           ③.properties文件（属性文件）
 */
public class ServletDemo11 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test1();	
		//test2();	
		//test3();	
		
		
		String requestPath = request.getContextPath(); /* /day05  */
		System.out.println(requestPath);
		String contextPath = this.getServletContext().getRealPath(""); //获取web应用的绝对路径
		System.out.println(contextPath);/* D:\Program Files (x86)\apache-tomcat-6.0.43\webapps\day05  */
		
		
		File file = new File("a/yhh.txt"); //这里的路径时相对于tomcat的bin目录
		String path = file.getPath();  //a\yhh.txt
		System.out.println("path:"+path); 
		String absolutePath = file.getAbsolutePath(); //D:\Program Files (x86)\apache-tomcat-6.0.43\bin\a\yhh.txt
		System.out.println(absolutePath);
	}
	
	/**
	 * 缺点: 不能获取到资源文件的名字
	 * 1、直接通过ServletContext的getResourceAsStream读取资源文件流
	 */
	private void test1() throws IOException {
		//去发布工程里找属性文件   第一个/是web应用路径                                                 为毛第一个/不加也可以?????
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties props = new Properties();  //里面有个map
		props.load(in);
		System.out.println("url:" + props.getProperty("url"));
		System.out.println("username:" + props.getProperty("username"));
		System.out.println("password:" + props.getProperty("password"));
	}
	
	/**
	 * 优点: 可以获取到资源文件的名字
	 * 1、通过ServletContext的getRealPath得到资源文件的绝对路径。
	 * 2、在通过传统方式读取资源文件
	 */
	private void test2() throws IOException {
		
		//得到绝对路径
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		System.out.println("资源文件绝对路径:" + path);
		
		String filename = path.substring(path.lastIndexOf("\\")+1);
		System.out.println("资源文件的名字:" + filename);
		
		FileInputStream in2 = new FileInputStream(path);
		Properties props = new Properties();
		props.load(in2);
		System.out.println("资源文件的数据:");
		System.out.println(props.getProperty("url"));
		System.out.println(props.getProperty("username"));
		System.out.println(props.getProperty("password"));
	}
	
	
	/**
	 * web工程读取资源文件注意问题：下面代码不可行，应该采用ServletContext去读
	 */
	private void test3() throws IOException {
		/**
		 * HTTP Status 500 - classes\db.properties (系统找不到指定的路径。)
		 * 
		 * in2的相对路径是tomcat的bin目录，所以这种方法要在该目录下建立文件夹classes，并把文件放在这里
		 */
		FileInputStream in2 = new FileInputStream("classes/db.properties");
		Properties props=new Properties();
		props.load(in2);
		System.out.println(props.getProperty("url"));
	}
}
