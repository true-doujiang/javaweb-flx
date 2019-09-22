<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.itcast.domain.Person"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jsp:usebean标签</title>
  </head>
  <body>
  
  	<%  //pageContext.setAttribute("person",new Person()); %>
    
    						<!-- class属性必须指定bean的完整类名 -->
    <!-- 标签体内容只在实例化bean时执行: 先从page域找有没有person实例，没有我再实例化person-->
    <jsp:useBean id="person" class="cn.itcast.domain.Person" scope="page">
    	xxxx
    </jsp:useBean>
    <% System.out.println(person.getName());%>


  </body>
</html>
