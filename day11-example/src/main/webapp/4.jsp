<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/itcast.tld" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>foreach标签</title>
  </head>
  <body>
  
    <h3>1</h3>
    <% 
    	List list = new ArrayList();
    	list.add("aaa"); list.add("bbb");
    	list.add("ccc"); list.add("ddd");
    	request.setAttribute("list",list);
    %>
    <c:foreach var="str" items="${list}">
    	${str }
    </c:foreach>
    <%-- [Ljava.lang.Integer; cannot be cast to java.util.List
    <% 
    	Integer ii[] = new Integer[]{100,207,38};
		request.setAttribute("arr",ii);
    %>
    <c:foreach items="${arr}" var="str">
    	${str}
    </c:foreach>
  --%>
  
  <%-- -----------------------改用c:foreach2标签------------------------------------ --%>
    
    <hr>
    <h3>2</h3>
    <% 
    	list = new ArrayList();
    	list.add("axx"); list.add("byy");
    	request.setAttribute("list",list);
    %>
    <c:foreach2 items="${list}" var="str">
    	${str}
    </c:foreach2>
    
    <br/><hr>
    <% 
    	Integer arr[] = new Integer[]{100,207,38};
    	request.setAttribute("arr",arr);
    %>
    <h3>3</h3>
    <c:foreach2 items="${arr}" var="num">
    	${num }
    </c:foreach2>
    
     <br/><hr>
    <% 
    	Map map = new HashMap();
    	map.put("a","尤欢欢"); map.put("b","吕兰兰");
    	request.setAttribute("map",map);
    %>
     <h3>4</h3>
     <c:foreach2 items="${map}" var="me">
     	${me.key }=${me.value }<br/>
     </c:foreach2>
     
     <br/><hr>
     
     
     <!-- sun公司的jstl可以遍历8种基本数据类型的数组 -->
     
     <!-- 注意，基本数据类型数组的迭代  sun公司的jstl可以遍历8种基本数据类型--><%----%>
    <% 
    	int i[] = new int[]{1,2,3}; 
    	request.setAttribute("i",i);
    %>
    <h3>5</h3> 
    <c:foreach2 items="${i}" var="num">
    	${num }
    </c:foreach2>
    
    <hr>
    
   <% 
    	boolean b[] = {true,false,true}; request.setAttribute("b",b);
    %>
    <h3>6</h3> 
    <c:foreach2 items="${b}" var="b">
    	${b}
    </c:foreach2>
    
    
  </body>
</html>
