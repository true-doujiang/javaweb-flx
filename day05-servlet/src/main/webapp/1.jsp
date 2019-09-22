<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>1jsp</title>
  </head>
  <body>
  
    request.getContextPath() = <%out.write(path);%>     <br>
    <%out.write(basePath);%> <br>
    
    <h1>
    	<span style="color:red">
    	 <%
	    	String contextdata = (String)application.getAttribute("jspdata");
	    	out.write(contextdata);
	    	//这里取不到，配置文件里的参数 
	    	String webdata = (String)application.getAttribute("webdata");
	    	out.write(webdata);
    	%>
    	</span>
    </h1>
    
     <address>${jspdata}</address>
    
    
  </body>
</html>
