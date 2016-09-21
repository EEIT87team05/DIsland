
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:useBean id="bean2" class="_02_friend.model.FriendsListDAO" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>friendlist1</title>

<c:if test="${empty LoginOK}">
	<c:redirect url="/_01_register/login.jsp" />
</c:if>
</head>
<body>
<jsp:include page="/fragment/top.jsp"/>
 <div style="background-color: pink; height: 150px; text-align: center;">
		<br />
		<div class="select_join" style="margin-left: 15px">
			<select name="txtCountry" style="color: white;">
				<option value="0" selected>-- 請選擇縣市 --</option>
				<option value="1">Georgia</option>
				<option value="2">Afghanistan</option>
			</select>
		</div>
	</div>
</body>
</html>