<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	out.write("aaaaa我是中国人<br>"); //out默认有4K的缓存
	response.getWriter().write("bbbbb<br>"); //我先被输出到页面
%>

<%-- Tip： out隐式对象
	
1、out隐式对象用于向客户端发送文本数据。 
2、out对象是通过调用pageContext对象的getOut方法返回的，
     其作用和用法与ServletResponse.getWriter方法返回的PrintWriter对象非常相似。 
3、JSP页面中的out隐式对象的类型为JspWriter，JspWriter相当于一种带缓存功能的PrintWriter，
     设置JSP页面的page指令的buffer属性可以调整它的缓存大小，甚至关闭它的缓存。 
4、只有向out对象中写入了内容，且满足如下任何一个条件时，out对象才去调用ServletResponse.getWriter方法，
     并通过该方法返回的PrintWriter对象将out对象的缓冲区中的内容真正写入到Servlet引擎提供的缓冲区中：
	①设置page指令的buffer属性关闭了out对象的缓存功能
	②out对象的缓冲区已满    默认有4K的缓存
	③整个JSP页面结束
	
	Tip： out隐式对象的注意事项	
1、同时使用out和response.getwriter()同时输出数据  可能会先输出response.getwriter()的数据，因为out有4k的缓存。
用JSP实现文件下载。

--%>