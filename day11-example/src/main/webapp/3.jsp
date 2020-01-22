<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/itcast" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>if...else标签</title>
  </head>
  <body>
    
    <%  request.setAttribute("user","yhh");  %>
    
   <c:choose>   
   		<c:when test="${user!=null}"> 
   			<h1 style="color:red;">欢迎您${user }</h1>
   		</c:when>
   		<c:otherwise>  
   			请登录
   		</c:otherwise>
   </c:choose> 
    
  </body>
</html>
