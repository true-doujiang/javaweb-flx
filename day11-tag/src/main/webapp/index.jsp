<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>index</title>
</head>
<body>
This is my JSP page. <br>
您的IP是:<% String ip = request.getRemoteAddr(); out.write(ip); %>
</body>
</html>
