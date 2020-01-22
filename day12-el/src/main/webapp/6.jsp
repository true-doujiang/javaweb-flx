<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.itcast.User"%>
<%@taglib uri="/WEB-INF/itcast.tld" prefix="my" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>6</title>
  </head>
  <body>
  
  	<% 
    	User user = new User();
    	user.setUsername("钢铁侠");
    	session.setAttribute("user",user);
    	session.setAttribute("age",20);
    %>
     
    ${user!=null?my:add("欢迎您：",user.username):'请登录'}
    
    <hr/>

    ${my:test('吕兰兰',age) }
  </body>
</html>
