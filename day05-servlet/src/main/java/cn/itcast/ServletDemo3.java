package cn.itcast;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//讲解Servlet的细节4
public class ServletDemo3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {
		//super.init();
		/**
		 * 服务器只会创建一个Servlet实例对象(第一次访问这个Servlet的时候)，也就是说Servlet实例对象一旦创建，
		 * 它就会驻留在内存中，为后续的其它请求服务，直至web容器退出，servlet实例对象才会销毁。
		 */
		System.out.println("第一次访问我时，Servlet初始化");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 	在Servlet的整个生命周期内，Servlet的init方法只被调用一次。
		 	而对一个Servlet的每次访问请求都导致Servlet引擎调用一次Servlet的service方法。
		 	对于每次访问请求，Servlet引擎都会创建一个新的HttpServletRequest请求对象
		 	和一个新的HttpServletResponse响应对象，然后将这两个对象作为参数传递给它调用的Servlet的service()方法，
		 	service方法再根据请求方式分别调用doXXX方法。
		 */
		System.out.println("service");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		System.out.println("关闭tomcat时(不是关闭虚拟机)，Servlet灭亡");
	}
}
