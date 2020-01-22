<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 导入标签库 --%>
<%@taglib uri="http://www.itcast.cn" prefix="itcast" %> 
							<%-- prefix最好与对应的tld文件名同名方便维护--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>输出客户机的IP</title>
  </head>
  <body>
  
     	您的IP是：<itcast:viewIP/>
     	
  </body>
</html>
