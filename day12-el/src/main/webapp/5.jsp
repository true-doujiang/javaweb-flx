<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.itcast.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>sun公司 el函数</title>
  </head>
  <body>
   -------------toLowerCase()函数-----------------------------------<br/> 
   
    ${fn:toLowerCase("AAAA") }
    
   <br/>-------------length()函数-----------------------------------<br/> 
    <% 
    	List list = Arrays.asList("1a","2b","3c");
    	request.setAttribute("list",list);
    %>
    <%-- ${fn:length(${list})} el表达式不可以嵌套使用 --%>
    ${fn:length(list) }     <br/>
    ${fn:length("aaaaa") }  <br/>
    
    
    <c:forEach var="i" begin="0" end="${fn:length(list)}">  <%-- forEach的新用法,就是for循环嘛 --%>
    	${i}=${list[i] }  <br/>
    </c:forEach>
    
    <br/>-------------fn:split()函数-----------------------------------<br/> 
    <%-- 
    fn:split函数以一个字符串作为分隔符，将一个  字符串数组  中的所有元素合并为一个字符串并返回合并后的结果字符串。
    fn:join函数接收两个参数，第一个参数是要操作的字符串数组，第二个参数是作为分隔符的字符串。 --%>
    ${fn:split("aaa.bbb.ccc",".")[0]}<br/>
   
    ${fn:join(fn:split("www,flx,com",","),".") }<br/>  <%-- 函数可以嵌套使用   el表达式不可以嵌套使用--%>
   
    <%  String str[] = new String[]{"tttt","bbbbbb","uuuuu"};
    	request.setAttribute("str",str);
    %>
    ${fn:join(str,"-")}   <br/>
    ${fn:contains(fn:join(str,"-"),"tttt-")}
    
     <br/><br/>---------------使用el函数回显数据（重要！！！）---------------------------<br/>
     <% 
    	User user = new User();
    	String likes[] = {"sing","dance"};
    	user.setLikes(likes);
    	request.setAttribute("user",user);
    %>
    <input type="checkbox" name="like" vlaue="sing" ${fn:contains(fn:join(user.likes,","),"sing")?'checked':'' }>唱歌
    <input type="checkbox" name="like" value="dance"  ${fn:contains(fn:join(user.likes,","),"dance")?'checked':'' }>跳舞
    <input type="checkbox" name="like" value="basketball"  ${fn:contains(fn:join(user.likes,","),"basketball")?'checked':'' }>蓝球
    <input type="checkbox" name="like" value="football"  ${fn:contains(fn:join(user.likes,","),"football")?'checked':'' }>足球
    
    <br/><br/>
    ${fn:escapeXml("<a href=''>点点</a>") }
    
  </body>
</html>
