<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>include指令(静态包含)</title>
  </head>
  <body>
  			<%-- 面试题  --%>
  	
  	<%-- include属于静态包含，它会把所有的jsp合为1个jsp,再翻译为1个Servlet  所以性能比动态包含要好点--%>
  	<%-- 第一个/代表服务器 --%>
  	<%@include file="/public/head.jsp" %>
    	<br>当前页面内容. <br>
    <%@include file="/public/foot.jsp" %>
    
    
    
    <%-- 动态包含 把3个jsp翻译为3个Servlet，运行的时候再包含进来 --%>
    <%
    	request.getRequestDispatcher("/public/head.jsp").include(request,response);
    	response.getWriter().write("当前页面内容<br>");
    	request.getRequestDispatcher("/public/foot.jsp").include(request,response);
    %>
  </body>
</html>
