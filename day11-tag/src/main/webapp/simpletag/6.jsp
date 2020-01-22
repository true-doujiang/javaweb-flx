<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/simpleitcast" prefix="itcast"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>如果标签接收的是一个复杂类型，如果给其赋值</title>
  </head>
  <body>
  
  <% 
  	Date d = new Date();    request.setAttribute("date",d);
  %>
  <%--
     只支持8种基本数据类型的转换，所以这里要报500
   Unable to convert string "1990-02-01" to class "java.util.Date" for attribute "date"
  --%>
  <%--
	  <itcast:demo6 date="1990-02-01">
	  </itcast:demo6>
  --%>
    
    
  <itcast:demo6 date="${date}">
  </itcast:demo6>
  
  <itcast:demo6 date="<%=new Date() %>">
  </itcast:demo6>
 	
  </body>
</html>
