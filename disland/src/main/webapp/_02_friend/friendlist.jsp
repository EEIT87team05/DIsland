
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="firendlist" class="_02_friend.model.FriendsListDAO" scope="page"/>
<title>friendlist1</title>

</head>
<body>
<jsp:include page="/fragment/top.jsp"/>
<center>
	<table>
		<tr>
			<th>${LoginOK.members_Name}的好友名單</th>
		</tr>
		<tr>
			<th>好友編號</th>
			<th>好友姓名</th>
		</tr>
		<c:forEach var="friend" varStatus="stat" items="${firendlist.allFriend }">
			<c:if test="${friend.members_ID==LoginOK.members_ID }">
				<tr>
					<td>${friend.mem_Members_ID2 }</td>
					<td>${friend.name }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</center>
</body>
</html>