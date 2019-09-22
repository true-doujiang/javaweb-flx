<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.itcast.domain.Person"%>
<%@page import="cn.itcast.domain.Address"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>el表达式</title>
  </head>
  <body>
    
    <% request.setAttribute("name","aaa");%>
    
    <!-- 1、翻译为：pageContext.findAttribute("name")   page request session application-->
    ${name } 
    	
    <br/>
   
    <!-- 2、使用el表达式可以获取bean的属性 -->
    <% 
    	Person p = new Person(); p.setAge(12);
    	request.setAttribute("person",p);
    %>
    ${person.age }
    
	<br/>
    
    <!-- 3、使用el表达式可以获取bean中的属性的属性 -->
    <% 
    	Person person = new Person();
    	Address address = new Address();
    	address.setName("徐州响水");
    	person.setAddress(address);
    	request.setAttribute("person",person);
    %>
    ${person.address.name }
    
    <br/>
    
    <!-- 4、使用el表达式获取list集合中指定位置的数据 -->
    <% 
    	Person p1 = new Person(); p1.setName("方立勋");
    	Person p2 = new Person(); p2.setName("李炎恢");
    	List list = new ArrayList();
    	list.add(p1); list.add(p2);
    	request.setAttribute("list",list);
    %>
    ${list[0].name } 
    ${list[1].name }<!-- 配合jstl才能实现迭代 -->
   
    <br/>
      
    <!-- 5、使用el表达式获取map集合的数据 -->
    <% 
    	Map map = new HashMap();
    	Person p3 = new Person(); p3.setName("詹姆斯");
    	map.put("a",p3); map.put("b","bbbb");
    	map.put("c","cccc");   map.put("1","1111111");
    	request.setAttribute("keymap",map);
    %>
    ${keymap.a.name }
    ${keymap["1"] } <!-- el表达式在取数据是同时用.号，若取不出来用[]，实际是因为关键字用了数字 -->
    
    <br/>
      
    <!-- 利用el表达式获取web应用的名称 -->${pageContext.request.contextPath }  <br/>
    <%out.write(request.getContextPath()); %>
    <br/>
  
    
  </body>
</html>
