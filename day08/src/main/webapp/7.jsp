<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jsp常用标签</title>
  </head>
  <body>
  	<%-- JSP标签也称之为Jsp Action(JSP动作)元素，它用于在Jsp页面中提供业务逻辑功能，
  	          避免在JSP页面中直接编写java代码，造成jsp页面难以维护。 
  	          
	  	<jsp:include>标签  (动态引入哦)
		<jsp:forward>标签  
		<jsp:param>  标签  
  	--%>
  	          
    <% String url = "/public/foot.jsp"; %>
    <jsp:include page="/public/head.jsp"/> 
   	 	这是页面内容 	
    <jsp:include page="<%=url %>"/>
    <%-- <%@include file="/public/foot.jsp" %> 静态引入 --%>
 
    
    <% request.setCharacterEncoding("UTF-8");  String team = "骑士"; %>
    <jsp:forward page="/servlet/ServletDemo1">
    	<jsp:param name="team" value="<%=team %>"/>
    	<jsp:param name="name" value="詹姆斯"/>
    </jsp:forward>

  
  </body>
</html>
