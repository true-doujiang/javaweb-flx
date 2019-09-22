<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.itcast.domain.Person"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jstl+el表达式示例代码</title>
  </head>
  <body>
    <%--
    	1、找到standard.jar (每个jar下面都有个META-INF，相当于jar的配置文件)
    	2、最下面有个META-INF里面有个c.tld
    --%>
    
    <!-- 使用jstl+el表达式可以迭代list集合 -->
    <% 
    	List list = new ArrayList();
    	Person p1 = new Person();  p1.setName("马云");
    	Person p2 = new Person();  p2.setName("习大大");
    	list.add(p1); list.add(p2);
    	request.setAttribute("list",list);
    %>
    <c:forEach var="person" items="${list}">
    	${person.name } &nbsp;
    </c:forEach>
    
    <hr>
    
    <!-- 使用jstl+el表达式可以迭代map集合 -->
    <% 
    	Map map = new HashMap();
    	map.put("a","aaaaa");  map.put("b","bbbbb");
    	map.put("c","ccccc");  map.put("1","11111");
    	request.setAttribute("map",map);
    %>
   	<%-- items相当于Set<Map.Entry> set = map.entrySet()--%>
    <c:forEach var="me" items="${map}">  
    	${me.key } = ${me.value }<br/>
    </c:forEach>
    
    
    <br/><hr>
    <!-- 没有定义user这个可以 -->
    <c:if test="${user!=null}">
    	欢迎您：${user.uesrname }
    </c:if>
    
     <c:if test="${user==null}">
    	用户名：<input type="text" name="username"> <br/>
    	密码：   <input type="password" name="password"> <br/>
    		  <input type="submit" value="登陆">
    </c:if>
    
    ${1==1 }  //true
    
  </body>
</html>
