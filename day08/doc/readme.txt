
*** web开发接触到了4个域对象,这4个域对象是学习web的重点，也是笔试经常考察的知识点
	1、pageContext   （称之为page域）
	2、request	         （称之为request域）
	3、session	         （称之为session域）
	4、servletContext（称之为application域）


引入方式
	<jsp:include>标签  	动态引入
	request.getRequestDispatcher("/public/head.jsp").include(request,response); 动态引入
	<%@include file="/public/head.jsp" %>  静态引入
	pageContext.include("/public/head.jsp");

转发方式
	<jsp:forward page="/servlet/ServletDemo1"></jsp:forward>
	request.getRequestDispatcher("/public/head.jsp").forward(request,response);
	pageContext.forward("/1.jsp");
	this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);