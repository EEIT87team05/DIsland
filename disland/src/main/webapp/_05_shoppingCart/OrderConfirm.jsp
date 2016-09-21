<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.black{
	color:black;
	padding-top:5px; 
 	 padding-left:5px; 
 	 padding-right:5px; 
 	 padding-bottom:5px; 
}
.ttt{
	color:#8A52FF
}
</style>
<script type="text/javascript">
function cancelOrder() {
	if (confirm("確定取消此份訂單 ? ") ) {
		// 接收此資料的Servlet會使用 finalDecision 參數的值
		document.forms[0].finalDecision.value = "CANCEL";
		return true;
	} else {
		return false;
	}
}
function reconfirmOrder() {
	if (confirm("確定送出此份訂單 ? ") ) {
		// 接收此資料的Servlet會使用 finalDecision 參數的值
		document.forms[0].finalDecision.value = "ORDER";
		return true;
	} else {
		return false;
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 取得今天的日期，今天的日期應當在最後確認時才取得 -->
<jsp:useBean   id="today"  class="java.util.Date" scope="session"/> 
<title>訂單明細資訊確認</title>
</head>
<body>
	<jsp:include page="/fragment/top.jsp" />
	<CENTER>
	
	
			
		
		<form action='<c:url value="ProcessOrder.do" />' method="post">
<!-- 		<form action='ProcessOrder.do' method="post"> -->
		<table>
			<tr >
				<td  width="800" height="60" style="font-size:24px;" colspan="6" class="black">請確認下列資訊是否正確</td>
			</tr>
			<tr>
				<td colspan="2" class="black">會員姓名:${LoginOK.members_Name }</td>
			</tr>	
			<tr>
				<td width="800" height="20" colspan="6" class="black">
					 會員地址:${LoginOK.members_City}${LoginOK.members_Area}${LoginOK.members_Address }
				</td>
			</tr>
			<tr>
				<td width="800" height="20" colspan="6" class="black">
					寄送地址:  
					<input type="text" size="45" style="background-color: #EBFF9C;"
							 name="ShippingAddress" value="${LoginOK.members_City}${LoginOK.members_Area}${LoginOK.members_Address }">
					<font color="red" size="-1">${MsgMap.errorAddressEmpty}</font>
				</td>
			</tr>
			<tr>
				<td width="800" height="20" colspan="6" class="black">
				付款方式:
					<select  style="background-color: #EBFF9C;" name="PaymentMethod">
						<option value="creditCard">信用卡</option>
						<option value="transfer">ATM轉帳</option>
						<option value="cashOnDelivery">貨到付款</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="4" class="black">訂購日期:<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/></td>
			</tr>	
		</table>
		<br>

		<table>
			<tr>
					<td width="230" height="20" class="black">產品名稱</td>
					<td width="170" height="20" class="black">作者/製造商</td>
					<td width="130" height="20" class="black">單價</td>
					<td width="60" height="20" class="black">數量</td>
					<td width="80" height="20" class="black">折扣</td>
					<td width="130" height="20" class="black">小計</td>
				</tr>
				
				<c:forEach var="bcontent" varStatus="vs" items="${ShoppingCart.bookContent}">
					<c:if test="${bcontent.value.bqty == 0 }" var="food" scope="page">
						<c:forEach var="fcontent" varStatus="vs2" items="${ShoppingCart.foodContent}">
							<tr>
								<td width="230" height="20">${fcontent.value.productListingFood_Name }</td>
								<td width="170" height="20">${fcontent.value.productListingFood_Authors }</td>
								<td width="130" height="20">${fcontent.value.productListingFood_Price }</td>
								<td width="60" height="20">${fcontent.value.fqty }</td>
								<td width="80" height="20">${fcontent.value.productListingFood_Discount }</td>
								<td width="130" height="20">${fcontent.value.productListingFood_Price* fcontent.value.fqty*fcontent.value.productListingFood_Discount}</td>
							</tr>						
						</c:forEach>
					</c:if>
					
					<c:if test="${bcontent.value.bqty > 0 }" var="book" scope="page">
						<tr>
							<td width="230" height="20">${bcontent.value.productListingBook_Name }</td>
							<td width="170" height="20">${bcontent.value.productListingBook_Authors }</td>
							<td width="130" height="20">${bcontent.value.productListingBook_Price }</td>
							<td width="60" height="20">${bcontent.value.bqty }</td>
							<td width="80" height="20">${bcontent.value.productListingBook_Discount }</td>
							<td width="130" height="20">${bcontent.value.productListingBook_Price* bcontent.value.bqty*bcontent.value.productListingBook_Discount}</td>
						</tr>
					</c:if>
				</c:forEach>
		</table>
		<br>
		<br>
		<table>
			<tr>
			<td width="300" align="center" class="xxx">
				<INPUT TYPE="hidden" name="finalDecision"  value=""> 
		  	    <INPUT TYPE="SUBMIT" name="CancelBtn" value="取消訂單" class="button btn-default" onclick="return cancelOrder();">
				<INPUT TYPE="SUBMIT" name="OrderBtn"  value="確定送出" class="button btn btn-primary" onclick="return reconfirmOrder();">
		</table>
	</form>
	</CENTER>
</body>
</html>