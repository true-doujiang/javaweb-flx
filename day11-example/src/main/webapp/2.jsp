<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="/itcast" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>c:if标签</title>
  </head>
  <body>
  
    <%  request.setAttribute("user","yhh"); %>
    
    <c:if test="${user==null }">
    	<h1>您还没有登录</h1>
    </c:if>
   
    <c:if test="${user!=null }">
    	<h1>欢迎您:${user }</h1>
    </c:if>
   
  </body>
</html>
