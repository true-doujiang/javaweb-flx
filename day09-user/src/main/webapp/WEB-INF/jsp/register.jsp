<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
  </head>
<body>
   
<form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
    <table width="40%" border="1" >
    	<tr>
    		<td>用户名</td>
    		<td>
    			<input type="text" name="username" value="${formbean.username }">
    			<span style="color:red;">${formbean.errors.username }</span>
    		</td>
    	</tr>
    	<tr>
    		<td>密码</td>
    		<td>
    			<input type="password" name="password" value="${formbean.password }">
    			<span style="color:red;">${formbean.errors.password }</span>
    		</td>
    	</tr>
    	<tr>
    		<td>确认密码</td>
    		<td>
    			<input type="password" name="password2" value="${formbean.password2 }">
    			<span style="color:red;">${formbean.errors.password2 }</span>
    		</td>
    	</tr>
    	<tr>
    		<td>邮箱</td>
    		<td>
    			<input type="text" name="email" value="${formbean.email }">
    			<span style="color:red;">${formbean.errors.email }</span>
    		</td>
    	</tr>
    	<tr>
    		<td>生日</td>
    		<td>
    			<input type="text" name="birthday" value="${formbean.birthday }">
    			<span style="color:red;">${formbean.errors.birthday }</span>
    		</td>
    	</tr>
    	<tr>
    		<td><input type="reset" value="清空"></td>
    		<td><input type="submit" value="注册"></td>
    	</tr>
    </table>
</form>
    
    
  </body>
</html>
