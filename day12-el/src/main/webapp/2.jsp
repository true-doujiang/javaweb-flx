<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.itcast.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>el表达式运算符</title>
  </head>
  <body>
  
  	<% 
  	request.setAttribute("username","yhh"); 
  	request.setAttribute("password","123");%>
  	
  	${username=='yhh'&& password==123 }  
  	${12>10 }
    ${12*30 }
    ${1+9 }
    ${9-1 }
    ${10/2 }
    <%-- ${'AAA'+'BBB' }  字符串不可以相加，否则报错 --%>
    
    
   	<br/>===================empty运算符=======================<br>
    <% 
    	//List list = null;
    	List list = new ArrayList();
    	list.add("a");  list.add("b");
    	request.setAttribute("list",list);
    %>
    ${empty(list) }<br/>
    
    <c:if test="${!empty(list)}"> <!-- empty既可以判断null，又可以判断空的list  -->
    	<c:forEach var="str" items="${list}">
    		${str }
    	</c:forEach>
    </c:if>
    <c:if test="${empty(list)}">
    	对不起，没有您想看的数据
    </c:if>
    
    <br/>
    <br/>===================二元运算符用法=======================<br>
    <br/>
    <% session.setAttribute("user",new User("莱昂纳德")); %>
    ${user==null? "对不起，您没有登陆 " : user.username }
    
    <br/>
    <br/>===================二元运算符（数据回显）=======================<br>
    <% 
    	User user = new User(); user.setGender("人妖");
    	request.setAttribute("user",user);
    %>
   	<input type="radio" name="gender" value="male" ${user.gender=='male'?'checked':'' }>男
   	<input type="radio" name="gender" value="female" ${user.gender=='female'?'checked':'' }>女
    <input type="radio" name="gender" value="人妖" ${user.gender=='人妖'? 'checked' : '' }>人妖
   <br/>
   
    <% 
    	user = new User();
    	String likes[] = {"sing","dance","football"};
    	user.setLikes(likes);
    	request.setAttribute("user",user);
    %>
    <!-- 这里要用到el函数，先放着 5.jsp里解决了  -->
    <label><input type="checkbox" name="like" vlaue="sing">唱歌</label>
    <label><input type="checkbox" name="like" value="dance">跳舞</label>
    <label><input type="checkbox" name="like" value="basketball">蓝球</label>
    <label><input type="checkbox" name="like" value="football">足球</label>
   
    
  </body>
</html>
