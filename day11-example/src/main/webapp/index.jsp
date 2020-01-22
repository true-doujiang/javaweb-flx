<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  
  	<h1>首页</h1>
  	<span>这里是网站首页，有各种广告。只有通过首页访问1.jsp才能成功。<br/> 直接访问1.jsp没门。</span>
    
    <br>
    <a href="${pageContext.request.contextPath }/1.jsp">凤姐日记</a>
    
  </body>
</html>
