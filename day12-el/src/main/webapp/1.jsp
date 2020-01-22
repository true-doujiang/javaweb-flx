<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.itcast.Person"%>
<%@page import="cn.itcast.Address"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>el表达式获取数据示例</title>
  </head>
  
  <body>
    
    <% request.setAttribute("name","aaa"); %>
    ${name }  <%-- 相当于：pageContext.findAttribute("name") --%>
    
    <br/><hr><br/>
   
    <!-- 在jsp页面中，使用el表达式可以获取bean的属性 -->
    <% 
    	Person p = new Person(); p.setAge(12);
    	request.setAttribute("person",p);
    %>
    ${person.age }

    <br/><hr><br/>
    <!-- 在jsp页面中，使用el表达式可以获取bean中的。。。。。。。。。的属性 -->
    <% 
    	Person person = new Person(); 
    	person.setAddress(new Address());
    	request.setAttribute("person",person);
    %>
   ${person.address.name }
    
    <br/><hr><br/>
    <!-- 在jsp页面中，使用el表达式获取list集合中指定位置的数据 -->
    <% 
    	Person p1 = new Person();  p1.setName("尤欢欢");
    	Person p2 = new Person();  p2.setName("吕兰兰");
    	
    	List list = new ArrayList();
    	list.add(p1); list.add(p2);
    	request.setAttribute("list",list);
    %>
    ${list[1].name }  <!-- 取list指定位置的数据 -->
    
    <br/><!-- 迭代集合 -->
    <c:forEach var="person" items="${list}">
    	${person.name }
    </c:forEach>
    
   <br/><hr><br/>
    
    
    <!-- 在jsp页面中，使用el表达式获取map集合的数据 -->
    <% 
    	Map map = new HashMap();
    	map.put("a","aaaaxxx"); map.put("b","bbbbyyy");
    	map.put("c","cccczzz"); map.put("1","aaaa1111");
    	request.setAttribute("map",map);
    %>
  	${map.c }  <!-- 根据关键字取map集合的数据 -->
  	${map["1"] }
  	<br/>
  	<c:forEach var="me" items="${map}" varStatus="status">
  		${status.count}:  ${me.key }=${me.value }<br/>
  	</c:forEach>
  	
    <br/><hr><br/>
    <!-- 获取当前web应用的根目录 -->
    ${pageContext.request.contextPath }
    <a href="${pageContext.request.contextPath }/index.jsp">首页</a>
    
    
  </body>
</html>
