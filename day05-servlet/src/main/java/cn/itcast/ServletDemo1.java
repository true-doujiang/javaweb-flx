package cn.itcast;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//GenericServlet是ServletDemo1的爷爷
//servlet继承GenericServlet 而 GenericServlet implements Servlet, ServletConfig, java.io.Serializable
public class ServletDemo1 extends GenericServlet {

	private static final long serialVersionUID = 1L;

	
	@Override	//实现service方法
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		
		byte arr[] = "Aahello!!".getBytes();
		/*for(int i=0,len=arr.length; i<len; i++){
			System.out.println(arr[i] + "=" + (char)arr[i]);
		}*/
		res.getOutputStream().write("hello!!".getBytes(),0,3);//hel
	}
}
