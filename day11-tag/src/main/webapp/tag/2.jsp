<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 这样引入标签也可以 --%>
<%@taglib uri="/WEB-INF/itcast.tld" prefix="itcast" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>控制标签体是否执行</title>
  </head>
  <body>
  
   <itcast:demo1> 
  		xxxx 不能看到我噢
  </itcast:demo1>
  
  </body>
</html>
