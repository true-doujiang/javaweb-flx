<%@ page language="java" import="java.util.*" session="true" pageEncoding="UTF-8"
		 contentType="text/html; charset=UTF-8" errorPage="/errors.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>脚本片段</title>
  </head>
  <body>
  		<%-- 具体的看jsp.ppt --%>
  		
  		<%
  	 	//session="true" 创建session了，默认true ，false不创建
  	 	out.write(session.getId());
  	    %>
		
		<br/>
	    <%
			int x = 10;
			out.println(x);
		%>
		<p>这是JSP页面文本</p>
		<%
			int y = 20;
			out.println(y);
		%>
		
		
		<hr/>
		
		<%for (int i=1; i<5; i++){%>
			<H1>www.it315.org</H1>
		<%}%>
		
		<%!
			//这里是jsp申明，会被翻译到service方法外面   顶多算个面试题，没人用
			public void run(){
				System.out.println("run run ...");
			}
			private int id;
			static{
				
			}
		%>
		<%
			this.run();
		%>
		<%-- 
			这里是JSP方式的注释，你看不到哦，查看页面原码的时候，不可以看到我
		  --%>
		  
	    <!-- 
			这里是html方式的注释，你看不到哦，查看页面原码的时候，可以看到我
		-->
 		<%
 		   //if(true){
 		   //	   int x = 1/0;
 		   //}
 		%>	
 		
 	 <!-- 使用page指令解决JSP中文乱码
		 pageEncoding 属性功能:
			 1.控制Ctrl+s保存JSP文件的编码
			 2.通知服务器以什么码表读取JSP页面的中文
			 3.控制contentType的charset，也就控制了浏览器以什么码表打开页面
  	 -->
</body>
</html>
