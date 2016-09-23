<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="orderLists" class="_05_shoppingCart.model.OrderListsDAO" scope="page" />
<title>訂單列表</title>
<style>

	#aa
	{
	text-align: center;
	font-size: 30px;
	}

	tr td:hover{
			transform:scale(1.3);
			color:green;
			font-weight:bold;
			position:relative;
			top: 1px;
			left: 1px;
			cursor: pointer;
	}
	table{
			font-family:Microsoft JhengHei;
			border: solid 3px blue;
	}
	table tr{
	
	height:25px;
	}
/* Sortable tables */
	table.sortable thead {
	    background-color:#eee;
	    color:#666666;
	    font-weight: bold;
	    cursor: default;
	}
</style>
<script src="../js/sorttable.js"></script>


</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<center>
	<table id="bb" border="2" bordercolor="#f3dfeb" class="sortable">

		<tr>
			<th id="aa" colspan="5" style="color:pink">${LoginOK.members_Name }的訂單列表</th>
		</tr>
		<tr>
			<th style="width: 120px;text-align: center" >訂單編號</th>

			<th style="width: 120px;text-align: center" >訂購日期</th>

			<th style="width: 400px;text-align: center">寄送地址</th>

			<th style="width: 120px;text-align: center" >付款方式</th>

			<th style="width: 120px;text-align: center" >總金額</th>
		</tr>
		
		<c:forEach var="anOrderLists" varStatus="stat" items="${orderLists.allOrders}">
			<c:if test="${anOrderLists.members_ID==LoginOK.members_ID}">
			<tr>
				<td style="width: 120px;text-align: center">
					<a  href='<c:url value='ShoppingDetailsServlet.do?OrderLists_ID=${anOrderLists.orderLists_ID}' />'>
						${anOrderLists.orderLists_ID}
					</a>
				</td>
				<td style="width: 120px;text-align: center">${anOrderLists.orderLists_Date}</td>

				<td style="width: 400px;text-align: center">${anOrderLists.orderLists_Address }</td>

				<td style="width: 120px;text-align: center">${anOrderLists.orderLists_PaymentMethod }</td>

				<td style="width: 120px;text-align: center">${anOrderLists.orderLists_TotalAmount}</td>
			</tr>
			</c:if>
		</c:forEach>
		
	</table>
	</center>
	
</body>
</html>