<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>国际化的页面</title>
  </head>
  <body>
    
    <a href="/day12/login.jsp?language=zh">中文(网页)</a>
  	<a href="/day12/login.jsp?language=en">english(pages)</a>
    <% 
    	String language = request.getParameter("language");
    	if(language==null || language.equals("")){
    		language = "zh";
    	}
    	Locale locale = new Locale(language);
    	ResourceBundle bundle = ResourceBundle.getBundle("cn.itcast.resource.myproperties",locale);
    %>
    <form action="#">
    	<%=bundle.getString("username") %><input type="text" name="username"><br/>
    	<%=bundle.getString("password") %><input type="text" name="password"><br/>
    	<input type="submit" value="<%=bundle.getString("submit") %>">
    </form>
    
    
  </body>
</html>
