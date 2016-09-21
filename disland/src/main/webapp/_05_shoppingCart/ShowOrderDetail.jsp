<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>個人訂單明細</title>
</head>
<body>
	<jsp:include page="/fragment/top.jsp" />
	<center>
	<table border="1" bordercolor="white" style="background:rgb(168,200,235)">
		<tr >
			<td align="center" colspan="8" width="880" height="40" style="font-size:30px;">${LoginOK.members_Name }的訂單明細</td>
		</tr>
		<tr>
			<td colspan="2">訂單編號:${OrderListsVO.orderLists_ID}</td>
			<td colspan="4">出貨地址:${OrderListsVO.orderLists_Address}</td>
			<td colspan="2">訂購日期:${OrderListsVO.orderLists_Date}</td>
		</tr>
		<tr>
			<td width="40" height="20" align="center"></td>
			<td width="100" height="20" align="center">名稱</td>
			<td width="60" height="20" align="center">單價</td>
			<td width="40" height="20" align="center">數量</td>
			<td width="20" height="20" align="center">折扣</td>
			<td width="60" height="20" align="center">總價</td>
			<td width="100" height="20" align="center">出貨狀況</td>
			<td width="20" height="20" align="center">其它</td>
		</tr>
		<c:set var="subtotal" value="0" />
		<c:forEach var="detail" varStatus="stat" items="${OrderListsVO.details}">
			<c:choose>
				<c:when test="${ stat.count % 2 == 0 }">
				<c:set var="aColor" value="#E6FFA0" />
			</c:when>
			<c:otherwise>
				<c:set var="aColor" value="#EBFFEB" />
			</c:otherwise>
			</c:choose>
			
			<c:if test="${detail.shoppingDetails_BookQuantity > 0}" var="book" scope="page">
			<tr>
				<td width="40" height="20" align="center">${detail.productListingBook_ID}</td>
				<td width="100" height="20" align="center">${detail.productListingBook_Name }</td>
				<td width="60" height="20" align="center">${detail.shoppingDetails_BookPrice}</td>
				<td width="40" height="20" align="center">${detail.shoppingDetails_BookQuantity}</td>
				<td width="20" height="20" align="center">${detail.productListingBook_Discount}</td>
				<td width="60" height="20" align="center">
					<fmt:formatNumber value="${detail.shoppingDetails_BookPrice*detail.shoppingDetails_BookQuantity}"
								  pattern="#,###,###"/>元
				</td>
				<td width="100" height="20" align="center">${detail.shoppingDetails_isShipments }</td>
				<td width="20" height="20" align="center">-</td>
			</tr>
			</c:if>
			
			<c:if test="${detail.shoppingDetails_BookQuantity == 0}" var="food" scope="page">
			<tr>
				<td width="40" height="20" align="center">${detail.productListingFood_ID}</td>
				<td width="100" height="20" align="center">${OrderFoodShowBean.productListingFood_Name }</td>
				<td width="60" height="20" align="center">${detail.shoppingDetails_FoodPrice}</td>
				<td width="40" height="20" align="center">${detail.shoppingDetails_FoodQuantity}</td>
				<td width="20" height="20" align="center">${OrderFoodShowBean.productListingFood_Discount}</td>
				<td width="60" height="20" align="center">
					<fmt:formatNumber value="${detail.shoppingDetails_FoodPrice*detail.shoppingDetails_FoodQuantity}"
								  pattern="#,###,###"/>元
				</td>
				<td width="100" height="20" align="center">${detail.shoppingDetails_isShipments }</td>
				<td width="20" height="20" align="center">-</td>
			</tr>
			</c:if>
			
		</c:forEach>
		<tr>
			<td colspan="6" align="right">訂單總額:
				<fmt:formatNumber value="${OrderListsVO.orderLists_TotalAmount}"
				 				  pattern="#,###,###"/>元
			</td>
		</tr>
	</table>
	</center>
</body>
</html>