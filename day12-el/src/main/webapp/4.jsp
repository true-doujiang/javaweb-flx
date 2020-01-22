<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%@taglib uri="/WEB-INF/itcast.tld" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>el函数</title>
  </head>
  <body>
  <%--
  	EL表达式语法允许开发人员开发自定义函数，以调用Java类的方法。 示例：${prefix：method(params)}
	1、在EL表达式中调用的只能是Java类的 “静态” 方法。
	2、这个Java类的静态方法需要在tld文件中描述，才可以被EL表达式调用。
	3、EL自定义函数用于扩展EL表达式的功能，可以让EL表达式完成普通Java程序代码所能完成的功能。
	
	具体的看PPT
   --%>
  
  	<% 
  		List list = new ArrayList(); list.add("a");
  		request.setAttribute("list",list);  
  		
  		int arr[] = {1,2,3};
  		request.setAttribute("arr",arr);
  	%>
  
  
  	${fn:filter("<a href=''>点点</a>",arr) }
  	
  	<%-- el函数可以替换与web开发无关的代码，
  		 与web开发有关的代码无法移除，例如request，session.... --%>	
  		 
  </body>
</html>
