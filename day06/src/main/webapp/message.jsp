<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>message</title>
  </head>
  <body>
    <br/>
    <%
    	//application中的数据用request是取不到的，属于不同的域 
	    String mess=(String)request.getAttribute("message");
	    out.write(mess);    
     %>
     <br/>
     <br/>
     
     <h3> 从requestDemo5中取的数据:<span>${message}</span> </h3>
     
  </body>
</html>
