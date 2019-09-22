<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jsp:setProperty getProperty标签的使用</title>
  </head>
  <body>
     
     <!-- jsp:setProperty标签在工作时，它会自动把字符串转成八种基本数据类型 -->
     <jsp:useBean id="person" class="cn.itcast.domain.Person" scope="page" />
     
     <!-- 手工为bean属性赋值 -->
     <jsp:setProperty name="person" property="name" value="qqqq"/>
     <jsp:setProperty name="person" property="age" value="12"/>
     
     
     <!-- jsp:setProperty标签可以使用请求参数为bean的属性赋值  http://localhost:8088/day09/2.jsp?name=yhh&age=27-->
     <jsp:setProperty name="person" property="name" param="name"/>
     <jsp:setProperty name="person" property="age" param="age"/> <!-- int age  只支持8种基本数据类型的转化 -->
     <!-- 非要赋值的话只能这样了 value -->
     <jsp:setProperty name="person" property="birthday" value="<%=new Date() %>"/>
     
     
     <!-- jsp:setProperty标签用所有的请求参数为bean的属性赋值 
           http://localhost:8080/day09/2.jsp?name=flx&password=123&age=34-->
     <jsp:setProperty name="person" property="*"/>
    
    <% 
    	System.out.println(person.getName());
    	System.out.println(person.getPassword());
    	System.out.println(person.getAge());
    	System.out.println(person.getBirthday().toLocaleString());
    %>
    <hr/>
    <!-- 这个标签取不到值，就会输出null，不好，el表达式取不到值就输出一个空字符串，更好 -->
    <jsp:getProperty name="person" property="name"/>    <br/>
    <jsp:getProperty name="person" property="password"/><br/>
    <jsp:getProperty name="person" property="age"/>		<br/>
    <jsp:getProperty name="person" property="birthday"/><br/>
    
  </body>
</html>
