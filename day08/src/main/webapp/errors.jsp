<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" 
	isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>errors.jsp</title>
  </head>
  <body>
  	<%   pageContext.getOut().write("aaaaaa");%> <br/>
	<%   String message = exception.getMessage(); %>
	
	<%=message %>		<br/>
	
	    对不起哟，我出错了哟！！！<br/>
	    对不起哟，我出错了哟！！！<br/>


  </body>
</html>
