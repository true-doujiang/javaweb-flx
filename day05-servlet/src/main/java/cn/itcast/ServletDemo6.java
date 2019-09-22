package cn.itcast;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 讲解 ServletContext对象(接口)
 *  1、ServletConfig对象中维护了ServletContext对象的引用
 *  2、Servlet对象之间可以通过ServletContext对象来实现通讯
 *  3、多个Servlet通过ServletContext对象实现数据共享
 *  4、获取WEB应用的初始化参数。
 */
public class ServletDemo6 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	/** 2、Servlet对象之间可以通过ServletContext对象来实现通讯
	 *  servletContext示例,实现与ServletDemo8的数据通信
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/** 1、ServletConfig对象中维护了ServletContext对象的引用
		 * 
		 *  ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
		 *  可以通过ServletConfig.getServletContext方法获得ServletContext对象。
		 */
		//得到servletContext
		ServletContext context = this.getServletConfig().getServletContext();
		//ServletContext context2 = this.getServletContext();  //直接拿就可以了
		
		/**4、多个Servlet通过ServletContext对象实现数据共享 */
		context.setAttribute("data", "hello ServletDemo8 ");
		
		/**3、获取WEB应用的初始化参数。
		 * 
		 * 获取web.xml配置文件中的参数
		 * <context-param>
		 * 		<param-name>webdata</param-name>
 				<param-value>sadfds</param-value>
		 * <context-param>
		 */
		String contextdata = (String) this.getServletContext().getInitParameter("webdata");
		System.out.println(contextdata);
	}
}
