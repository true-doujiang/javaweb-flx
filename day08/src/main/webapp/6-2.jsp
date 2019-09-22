<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>pageContext对象的其它用途</title>
  </head>
  <body>
    <%-- Tip：引入和跳转到其他资源  
    PageContext类中定义了一个forward方法和两个include方法来分别简化和替代RequestDispatcher.forward方法和include方法。
	方法接收的资源如果以“/”开头， “/”代表当前web应用。
    --%>

	<%
	//pageContext.include("/public/head.jsp"); 
	//out.write("当前页面");
	//pageContext.include("/public/foot.jsp");
	
	pageContext.forward("/1.jsp");
	%>
	
	

  </body>
</html>
