<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errors.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>1.jsp</title>
  </head>
  <body>
    
    当前时间是：
    <%
    	Date date = new Date();
    	String time = date.toLocaleString();
    	out.write(date.toLocaleString());
    %>
    
    <br/>
    <%=time%>  <!-- 脚本表达式，它的作用就是用于向浏览器输出数据 -->
    <br/>
  //HttpUrlConnection
    <% 
    	//if(1==1)
    		//throw new RuntimeException("..........abfdfdfd");
    %>
    
    <hr/>
    
  </body>
</html>
