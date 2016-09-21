<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>
<%
response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.xxx{
	 padding-top:15px; 
 	 padding-left:10px; 
 	 padding-right:30px; 
 	 padding-bottom:40px; 
 	 border: 1px solid 000000; 
}
a.button {
    -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;

    text-decoration: none;
    color: initial;
}
</style>
<script type="text/javascript">
function bconfirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='UpdateBookItem.do?cmd=DEL&bookID=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}
function fconfirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='UpdateFoodItem.do?cmd=DEL&foodID=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}
function bmodify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		document.forms[0].action="<c:url value='UpdateBookItem.do?cmd=MOD&bookID=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}
function fmodify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		document.forms[0].action="<c:url value='UpdateFoodItem.do?cmd=MOD&foodID=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57)){
      return false;
   }
   return true;
}
function Checkout(qty) {
	if (qty == 0)  {
		alert("無購買任何商品，不需結帳");
		return false;
	}
	if (confirm("再次確認訂單內容 ? ") ) {
		return true;
	} else {
		return false;
	}
}
function Abort() {
	if (confirm("確定放棄購物 ? ") ) {
		return true;
	} else {
		return false;
	}
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購物清單</title>
</head>

<body>
	<jsp:include page="/fragment/top.jsp" />
	<c:choose>
	   <c:when test="${ShoppingCart.subtotal > 0}">
	      <c:set var="subtotalMessage" value="金額小計:${ShoppingCart.subtotal} 元"/>
	      <c:set var="subtotal" value="${ShoppingCart.subtotal}"/>  
	   </c:when>
	   <c:otherwise>
	      <c:set var="subtotalMessage" value="金額小計:  0 元"/>
	      <c:set var="subtotal" value="0"/>                
	   </c:otherwise>
	</c:choose>
	<center>
		<table border="1" bordercolor="white" style="background:rgb(168,200,235)">
			<tr>
				<td align="center" width="900" height="40" style="font-size:30px;" colspan="7">購物清單</td>
			</tr>
			<tr>
				<td width="230" height="20" align="center">商品名稱</td>
				<td width="170" height="20" align="center">作者/製造商</td>
				<td width="130" height="20" align="center">單價</td>
				<td width="60" height="20" align="center">數量</td>
				<td width="80" height="20" align="center">折扣</td>
				<td width="130" height="20" align="center">小計</td>
				<td width="100" height="20" align="center">修改</td>
			</tr>
			<c:forEach var="bcontent" varStatus="vs" items="${ShoppingCart.bookContent}">
				<c:if test="${bcontent.value.bqty == 0}">
					<c:forEach var="fcontent" varStatus="vs2" items="${ShoppingCart.foodContent}">
							<tr>
								<td width="230" height="20" align="center">${fcontent.value.productListingFood_Name }</td>
								<td width="170" height="20" align="center">${fcontent.value.productListingFood_Authors }</td>
								<td width="130" height="20" align="center">${fcontent.value.productListingFood_Price }</td>
								<td width="60" height="20" align="center">${fcontent.value.fqty }</td>
								<td width="80" height="20" align="center">${fcontent.value.productListingFood_Discount }</td>
								<td width="130" height="20" align="center">${fcontent.value.productListingFood_Price* fcontent.value.fqty*fcontent.value.productListingFood_Discount}</td>
								<td width="100" height="20" align="center">
	              					<input type="button" class="btn btn-default" name="update" value="修改" onclick="fmodify(${fcontent.key},${fcontent.value.fqty},${vs2.index })">
	              					<input type="button" class="btn btn-default" name="delete" value="刪除" onClick="fconfirmDelete(${fcontent.key})">
              					</td>	
							</tr>						
						</c:forEach>
				</c:if>
				<c:if test="${bcontent.value.bqty > 0 }">
					<tr>
						<td width="230" height="20" align="center">${bcontent.value.productListingBook_Name }</td>
						<td width="170" height="20" align="center">${bcontent.value.productListingBook_Authors }</td>
						<td width="130" height="20" align="center">${bcontent.value.productListingBook_Price }</td>
						<td width="60" height="20" align="center">${bcontent.value.bqty }</td>
						<td width="80" height="20" align="center">${bcontent.value.productListingBook_Discount }</td>
						<td width="130" height="20" align="center">${bcontent.value.productListingBook_Price* bcontent.value.bqty*bcontent.value.productListingBook_Discount}</td>
          				<td width="100" height="20" align="center">
          					<input type="button" class="btn btn-primary btn-sm" name="update" value="修改" onclick="bmodify(${bcontent.key},${bcontent.value.bqty},${vs.index })">
          					<input type="button" class="btn btn-primary btn-sm" name="delete" value="刪除" onClick="bconfirmDelete(${bcontent.key})">
          				</td>						
					</tr>
				</c:if>
				
			</c:forEach>
				<tr>
					<td colspan="6" align="right">合計金額:<fmt:formatNumber value="${subtotal}" pattern="#,###,###"/>元</td>
					<td></td>
				</tr>        
		</table>
		
		<table >
			<tr>
				
				<td width="300" align="center" class="xxx">
					<a href="<c:url value='/_04_product/ProductListingBookServlet?pageNo=1' />" class="button btn btn-info">繼續購物</a>
				</td>
				<td width="300" align="center" class="xxx">
					<a href="<c:url value='checkout.do' />" onClick="return Checkout(${subtotal});" class="button btn btn-success">確認結帳</a>
				</td>
				<td width="300" align="center" class="xxx">
					<a href="<c:url value='abort.do' />" onClick="return Abort();" class="button btn btn-danger">放棄購物</a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>