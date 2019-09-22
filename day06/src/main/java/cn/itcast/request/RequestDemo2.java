package cn.itcast.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import cn.itcast.User;


/**
 * 获取请求头、获取请求数据(一般都要先检查再使用)
 *
 */
public class RequestDemo2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//访问： http://localhost:8088/day06/test.html
		
		//test1(request);
		test2(request);
	}

	/**
	 * 获取请求数据 
	 */
	private void test2(HttpServletRequest request) throws IOException {
		
		System.out.println("=======1========");
		
		String value = request.getParameter("username"); //获取表单提交数据
		if(value!=null && !value.trim().equals("")){
			System.out.println(value);
		}
		
		System.out.println("=======2========");
		
		//获取表单提交数据的所有名字
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}
		
		System.out.println("=======3========");
		
		//获取
		String value2 [] = request.getParameterValues("username");
		for(int i=0; value2!=null && i<value2.length;i++){
			System.out.println(value2[i]);
		}
		
		System.out.println("=======4========");
		
		//
		Map<String,String[]> map = request.getParameterMap();
		User user = new User();
		User formbean = new User(); //对应form表单的bean,可以验证提交的数据
		try {
			BeanUtils.populate(formbean, map);//用map集合填充bean
			BeanUtils.copyProperties(user, formbean);//bean的拷贝,只能拷贝8种基本数据类型,要自定义转化器
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(user);
		
		System.out.println("=======5========");
		
		//用在文件上传 获取数据
		InputStream in = request.getInputStream();
 		byte buffer[] = new byte[1024];
 		int len = 0;
 		while((len=in.read(buffer))>0){
 			System.out.println(new String(buffer,0,len));
 		}
	}

	/**
	 * 获取2请求头相关的方法
	 * getHeader("key")  
	 * getHeaderNames()
	 */
	@SuppressWarnings("unused")
	private void test1(HttpServletRequest request) {
		
		String headValue = request.getHeader("Accept-Encoding"); //获取指定头
		System.out.println(headValue);
		System.out.println("=======1========");
		
		//获取指定头的多个值，以枚举形式返回
		Enumeration e = request.getHeaders("Accept-Encoding");
		while(e.hasMoreElements()){
			String value = (String) e.nextElement();
			System.out.println(value);
		}
		System.out.println("=======2========");
		
		//获取所有的请求头，以枚举形式返回
		e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + ":" + value);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
