<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>pageContext访问其它域</title>
  </head>
  <body>
<%-- Tip： pageContext对象     用途: 用在自定义标签开发技术里面
	 pageContext对象是JSP技术中最重要的一个对象，它代表JSP页面的运行环境，
	 这个对象不仅封装了对其它8大隐式对象的引用，它自身还是一个域对象，可以用来保存数据。
	 并且，这个对象还封装了web开发中经常涉及到的一些常用操作，例如引入和跳转其它资源、检索其它域对象中的属性等。
	 
	通过pageContext获得其他对象  
	1、getException方法返回exception隐式对象 
	2、getPage方法返回page隐式对象
	3、getRequest方法返回request隐式对象 
	4、getResponse方法返回response隐式对象 
	5、getServletConfig方法返回config隐式对象
	6、getServletContext方法返回application隐式对象
	7、getSession方法返回session隐式对象 
	8、getOut方法返回out隐式对象(JspWrite)
 --%>
 
 <%-- Tip：pageContext作为域对象 
 
 	1、pageContext对象的方法 (作为域对象 )
	public void setAttribute(String name,Object value)
	public Object getAttribute(String name)
	public void removeAttribute(String name)
	
	2、pageContext对象中还封装了访问其它域的方法
	public Object getAttribute(String name, int scope)
	public void setAttribute(String name, Object value,int scope)
	public void removeAttribute(String name, int scope)
	
								代表各个域的常量
								PageContext.APPLICATION_SCOPE
								PageContext.SESSION_SCOPE
								PageContext.REQUEST_SCOPE
								PageContext.PAGE_SCOPE 
											
 	3、findAttribute方法    （*重点，查找各个域中的属性） EL表达式
  --%>
 
  	
<%
	pageContext.setAttribute("page","pageName");
	String pagedata = (String)pageContext.getAttribute("page");
	out.write("page=" + pagedata);
%>
  	<br/>
<% 
   	request.setAttribute("name","requestName");
    session.setAttribute("name","sessionName");
   	//pageContext访问其它域
	String name = (String)pageContext.getAttribute("name",PageContext.REQUEST_SCOPE);
	out.write(name);
%>	
	<br/>
 <%	
   	pageContext.setAttribute("data","xxxd2",PageContext.SESSION_SCOPE);
   	//findAttribute() 依次从 pageContext  Request    session   servletContext 找data
   	//					   page域               request域     session域   application域
   	String data = (String)pageContext.findAttribute("data"); 
   	out.write(data);
 %>
    <br/>
    <%=data %>
    <br/>
    el表达式就是用的findAttribute方法:  ${data } 
    
  </body>
</html>
