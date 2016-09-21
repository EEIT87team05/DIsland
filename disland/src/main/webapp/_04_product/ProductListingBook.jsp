<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="SYSTEM" class="_00_init.GlobalService"
	scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/animate.css">
<c:set var="AppName" value="${SYSTEM.systemName}" scope="application" />
<title>${AppName}</title>
<style>
#content{
		position:absolute;
		left:20%;
		top:20%;
}
input[type="button"] {
	background: #3498db;
	/* Standard */
	background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
	/* Firefox */
	background-image: -moz-linear-gradient(top, #3498db, #2980b9);
	background-image: -ms-linear-gradient(top, #3498db, #2980b9);
	background-image: -o-linear-gradient(top, #3498db, #2980b9);
	background-image: linear-gradient(to bottom, #3498db, #2980b9);
	-webkit-border-radius: 28;
	-moz-border-radius: 28;
	border-radius: 28px;
	font-family: Arial;
	color: #ffffff;
	font-size: 15px;
	padding: 9px 20px 10px 20px;
	text-decoration: none;
	cursor: pointer; /*改變游標狀態*/
}

</style>

</head>
<body >
<jsp:include page="/fragment/top.jsp"/>
	<div id='content' >
		<table border='2' width='820'>
			<!--   購物車的標題     -->
			<tr>
				<td colspan='4'>
					<table width="820" style="background: #FFE4C4" border='0'>
						<tr height='2'>
							<th width="270">&nbsp;</th>
							<th width="280">&nbsp;</th>
							<th width="270">&nbsp;</th>
						</tr>
						<tr height='10'>
							<td width="240">&nbsp;</td>
							<td width="400" align='center'><font color='#8000FA'
								size='+3' style="font-weight: 800;" 
								id="AppName" class="fontStyle"> ${AppName} </font></td>
							<td width="240" align='right'><FONT color='red' size='-1'>

							</FONT></td>
						</tr>

					</table>
				</td>
			</tr>

			<!-- forEach 顯示購物車的內容
         識別字串products_DPP是由_03_listBooks.controller.DisplayPageProducts.java放入request物件內-->
			<c:forEach varStatus="stVar" var="aBookBean" items="${products_DPP}">
				<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
				<c:set var="rowColor" value="#DEFADE" />
				<c:if test="${stVar.count % 2 == 0}">
					<c:set var="rowColor" value="#FFEBFF" />
				</c:if>
				<tr bgColor="${rowColor}" height='25'>
					<td rowspan='3' width='64'>
						<!-- 
                 getImage所對應的Servlet會到資料庫讀取圖片並傳送給前端的瀏覽器
              --> <img height='100' width='80'
						src='${pageContext.servletContext.contextPath}/_04_product.controller/GetImageFromDB?id=${aBookBean.productListingBook_ID}&type=BOOK'>
					</td>
					<td height='32' width='560'>
						<TABLE border='1'>
							<tr height='30'>
								<td width='560'>書名：${aBookBean.productListingBook_Name}</td>
							</tr>
						</TABLE>
					</td>
					<td rowspan='3' width='180' align='center'>
						<!-- <FORM  action='BuyBook.do' method="POST">  --> <!-- 
          FORM表單的資料會送後端的 _03_listBooks.controller.BuyBookServlet.java
                         來處理 
       -->
						<FORM action="<c:url value='BuyBook.do' />" method="POST">
							購買數量: <select name='qty'>
								<c:if test="${aBookBean.productListingBook_Quantity < 1}"></c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 1}">
									<option value="1">1</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 2}">
									<option value="1">1</option>
									<option value="2">2</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 3}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 4}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 5}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 6}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 7}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 8}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 9}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Quantity == 10}">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
								</c:if>
							</select>
							<!-- 這些隱藏欄位都會送到後端 -->
							<Input type='hidden' name='ProductListingBook_ID'
								value='${aBookBean.productListingBook_ID}'>
							<P />
							<Input type='hidden' name='ProductListingBook_Name'
								value='${aBookBean.productListingBook_Name}'>
							<P />
							<Input type='hidden' name='ProductListingBook_Authors'
								value='${aBookBean.productListingBook_Authors}'>
							<P />
							<Input type='hidden' name='ProductListingBook_Price'
								value='${aBookBean.productListingBook_Price}'>
							<P />
							<Input type='hidden' name='ProductListingBook_Discount'
								value='${aBookBean.productListingBook_Discount}'>
							<P />
							<Input type='hidden' name='pageNo' value='${param.pageNo}'>
							<P />
							<Input type='submit' value='加入購物車'>
						</FORM>
					</td>
				</tr>
				<tr height='32' bgColor="${rowColor}">
					<td width='560'>
						<TABLE border='1'>
							<tr height='31'>
								<td width='420'>作者：${aBookBean.productListingBook_Authors}</td>
								<td width='140'>出版社：${fn:substring(aBookBean.productListingBook_Publisher,0,2)}</td>
							</tr>
						</TABLE>
					</td>
				</tr>
				<tr height='32' bgColor="${rowColor}">
					<td width='560'>
						<TABLE border='1'>
							<tr height='31'>
								<td width='160'>剩餘數量：${aBookBean.productListingBook_Quantity}</td>
								<td width='140'>訂價：<fmt:formatNumber
										value="${aBookBean.productListingBook_Price}" pattern="####" />元
								</td>
								<c:if test="${ aBookBean.productListingBook_Discount != 1 }">
									<td width='260'><Font color='red'>
											${aBookBean.discountStr},&nbsp; 實售<fmt:formatNumber
												value="${aBookBean.productListingBook_Price*aBookBean.productListingBook_Discount}"
												pattern="####" /> 元,&nbsp;省<fmt:formatNumber
												value="${aBookBean.productListingBook_Price - aBookBean.productListingBook_Price*aBookBean.productListingBook_Discount}"
												pattern="####" />元
									</Font></td>
								</c:if>
								<c:if test="${aBookBean.productListingBook_Discount==1}">
									<td width='260'>&nbsp;</td>
								</c:if>
							</tr>
						</TABLE>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="paging" style="heght:300px">
		<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
		<hr style="border: solid 2px pink; width: 80%; float: left;">
		<br>
		<table border="2" style="float:left; ">
			<tr>
				<td width='100'><c:if test="${pageNo > 1}">
						<div id="pfirst">
							<a href="<c:url value='ProductListingBookServlet?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
						</div>
					</c:if></td>
				<td width='100'><c:if test="${pageNo > 1}">
						<div id="pprev">
							<a
								href="<c:url value='ProductListingBookServlet?pageNo=${pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
						</div>
					</c:if></td>
				<td width='100'><c:if test="${pageNo != totalPages}">
						<div id="pnext">
							<a
								href="<c:url value='ProductListingBookServlet?pageNo=${pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
						</div>
					</c:if></td>
				<td width='100'><c:if test="${pageNo != totalPages}">
						<div id="plast">
							<a
								href="<c:url value='ProductListingBookServlet?pageNo=${totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
						</div>
					</c:if></td>
				<td width='120' align="center">第${pageNo}頁 / 共${totalPages}頁</td>
			</tr>
		</table>
	</div><br><br><br>
	<hr style="border: solid 2px pink; width: 80%; ">
	<br>
<%-- 	<a href="<c:url value='/_05_shoppingCart/ShowCartContent.jsp' />"> --%>
<!-- 		<span>結帳</span> -->
<!-- 	</a> -->
	<input type="button" value="結帳"
	onclick=" javascript:window.location.href='../_05_shoppingCart/ShowCartContent.jsp'  ">
	</div>
	


</body>


</html>