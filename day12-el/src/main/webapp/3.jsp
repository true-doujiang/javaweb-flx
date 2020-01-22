<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>el隐式对象</title>
  </head>
  <body>
  
    <%--  
    EL表达式语言中定义了11个隐含对象，使用这些隐含对象可以很方便地获取web开发中的一些常见对象，并读取这些对象的数据。
        语法：${隐式对象名称}  ：获得对象的引用
 	
 	--%>
    
    
    ${pageContext }  <%-- 如果key是隐式对象直接获得隐式对象的引用，如果不是再从域中寻找以key保存的数据 
    					  org.apache.jasper.runtime.PageContextImpl@2de8396e --%>
    <br/>
    
    <br/>---------------从指定的page域中查找数据------------------------<br/>
    <%  pageContext.setAttribute("name","aaa");  //map    %>
    ${pageScope.name } 
   
   
   	<br/>---------------从request域中获取数据------------------------<br/>
   	<%  request.setAttribute("name","bbb");  //map   	  %>
   	${requestScope.name }
   	
   	<br/>---------------从session域中获取数据------------------------<br/>
   	${sessionScope.user.username }
   	
   	<br/>---------------从application域中获取数据------------------------<br/>
   	${applicationScope.user }
   	
   	<br/>--------------获得用于保存请求参数map，并从map中获取数据,用于数据回显------------------------<br/>
   	<!-- http://localhost:8088/day12/3.jsp?name=aaa  -->
   	${param.username }  
   	<!-- 此表达式会经常用在数据回显上 -->
   	<form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
   		<input type="text" name="username" value="${param.username }">
   		<input type="submit" value="注册">
   	</form>
   	
   	<br/>--------------paramValues获得请求参数 //map{"",String[]}------------------------<br/>
   	<!-- http://localhost:8088/day12/3.jsp?like=aaa&like=bbb -->
   	${paramValues.like[0] }  
   	${paramValues.like[1] } 
   	
   	<br/>--------------header获得请求头------------------------<br/>
   	Accept: ${header.Accept }<br/> 
   	Host: ${header.Host }<br/> 
   	Accept-Encoding: ${header['Accept-Encoding'] }<br/>  <%--点号搞不定的用[] --%>
   	
   	
   	<br/>--------------获取客户机提交的cookie------------------------<br/>
   	<!-- 
   	从cookie隐式对象(表示一个保存了所有cookie的Map对象)
   	中根据名称获取到的是cookie对象,要想获取值，还需要.value 
   	-->
   	${cookie.JSESSIONID }<br/>
   	${cookie.JSESSIONID.name } =  ${cookie.JSESSIONID.value }  
   	
   	
   	<br/>--------------获取web应用初始化参数------------------------<br/><br/>
   	<%-- web.xml
   	<context-param>
	  	<param-name>root</param-name>
	  	<param-value>/day12</param-value>
  	</context-param>
   	 --%>
   	${initParam.root }
   	
  </body>
</html>
