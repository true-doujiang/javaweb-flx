<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@page import="cn.itcast.login.User"%>
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    
    <h2>欢迎您：${user.username}</h2>
    <a href="/day07/login.html">登陆</a> 
	<a href="/day07/servlet/LogoutServlet">退出登录</a>
   
  </body>
</html>
