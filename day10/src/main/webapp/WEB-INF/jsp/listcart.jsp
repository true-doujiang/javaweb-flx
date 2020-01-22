<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listcart</title>
    <script type="text/javascript">
	    function deleteItem(id){
			var b = window.confirm("您确定要删除吗？？");
			if(b){					//这种必须在JSP里写，js文件不行
				window.location.href="${pageContext.request.contextPath }/servlet/DeleteServlet?bookid="+id;
			}
		}
		
    	function clearcart(){
    		var b = window.confirm("您确定要清空购物车吗？？");
    		if(b){
    			window.location.href="${pageContext.request.contextPath}/servlet/ClearCartServlet"
    		}
    	}
    	
    	function updateCart(input,id,oldvalue){
        	//得到要修改以后的数量
    		var quantity = input.value;
    		//1、检验输入的数量是不是一个数字
    		/*if(isNaN(quantity)){
				alert("请输入数字!");
				input.value=oldvalue;
				return;
        	}*/
    		//2、检验输入的数量是不是一个正整数  这里的判读非常巧，上面的完全可以不用验了
    		if(quantity<0 || quantity!=parseInt(quantity)){
				alert("请输入正整数"); 
				input.value=oldvalue;
				return;
        	}
        	
    		var b = window.confirm("您确认把书的数量修改为:" + quantity);
    		if(b){
    			window.location.href="${pageContext.request.contextPath}/servlet/UpdateCartServlet?bookid="+id + "&quantity=" + quantity;
    		}else{
    			input.value=oldvalue;  //发现用户取消的话，把input输入值改为原始值
    		}
    	}
</script>
</head>
<body style="text-align: center;">
   
    <h2>购物车列表</h2>
    <br/>
    
   <c:if test="${!empty(cart.map)}">
	    <table border="1" width="80%" style="border-collapse: collapse;">
	    	<tr>
	    		<td>书名</td>
	    		<td>作者</td>
	    		<td>单价</td>
	    		<td>数量</td>
	    		<td>小计</td>
	    		<td>操作</td>
	    	</tr>
	    	<c:forEach var="me" items="${cart.map }">
		    	<tr>
		    		<td>${me.value.book.name }</td>
		    		<td>${me.value.book.author }</td>
		    		<td>${me.value.book.price }</td>
		    		<td>
		    			<input type="text" name="quantity" value="${me.value.quantity }" style="width: 30px" onchange="updateCart(this,${me.value.book.id },${me.value.quantity })">
		    		</td>
		    		<td>${me.value.price }</td>
		    		<td>
		    			<a href="javascript:void(0)" onclick="deleteItem(${me.value.book.id })">删除</a>
		    		</td>
	    		</tr>
	    	</c:forEach>
	    	<tr>
	    		<td colspan="2">合计</td>
	    		<td colspan="3">${cart.price }</td>
	    		<td colspan="1"><a href="javascript:clearcart()">清空购物车</a></td>
	    	</tr>
	    </table>
   </c:if>
   
   <!-- empty()既可以判断=null又可以判断map里为空  -->
   <c:if test="${empty(cart.map)}"> 
    	对不起，您还没有购买任何商品
   </c:if>
    
  </body>
</html>
