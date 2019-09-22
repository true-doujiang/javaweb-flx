<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    <script type="text/javascript">
		//js防止表单重复提交，漏洞太多，要与服务器一起使用
		/*
		//方法一
		var isCommitted = false;
		function dosubmit(){
			if(isCommitted==false){
				isCommitted = true;
				return true;
			}else{
				return false;
			}
		}
		*/

		//方法二
		function dosubmit(){
			var submit = document.getElementById("submit");
			submit.disabled= "disabled";
			return true;
		}
	</script>
  </head>
  <body>
  
   <!--  请访问
    http://localhost:8088/day07/servlet/FormServlet 转发到我这里获取token  
   -->
   
   	<form action="/day07/servlet/DoFormServlet" method="post"> <!-- onsubmit="return dosubmit()" -->
 				<input type="hidden" name="token" value="${token}">
 		用户名：	<input type="text" name="username" value=""><br/>
 				<input type="submit" value="提交">
   	</form>
    	
  </body>
</html>
