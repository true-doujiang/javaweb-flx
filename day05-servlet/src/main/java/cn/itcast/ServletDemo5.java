package cn.itcast;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 讲解 ServletConfig接口
 *  在实际开发，有一些东西不适合在servlet程序中写死，这类数据就可以通过配置方式配给servlet，
 *  例如：servlet采用哪个码表、servlet链接哪个数据库，servlet使用哪个配置文件
 */
public class ServletDemo5 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/*	
	private ServletConfig  config;
	
    HttpServlet已经拿到了ServletConfig对象，所以不需要自己在拿了
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}
	*/

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//直接这么拿ServletConfig就可以了
		//ServletConfig myconfig = this.getServletConfig();
		String value1 = this.getServletConfig().getInitParameter("data1");
		String value2 = this.getServletConfig().getInitParameter("data2");
		System.out.println(value1 + " , " + value2);

		//得到所有的参数名字的枚举类型
		//Enumeration e = this.getInitParameterNames();  //这样也可以
		Enumeration e = this.getServletConfig().getInitParameterNames();  
		while(e.hasMoreElements()){
			String a = (String) e.nextElement();
			String v = this.getServletConfig().getInitParameter(a);
			System.out.println(a + "=" + v);
		}
	}



}
