<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>結果</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
<center>
	<table>
		<c:forEach var="rs" varStatus="stat" items="${Result.result}">
			<c:if test="${District==rs.members_Area && Gen==rs.members_Gender}">
				<tr>
					<td>
						<img height='40px' width='30px' src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${rs.members_ID}&type=MEMBER' />
					</td>
					<td>${rs.members_City }</td>
					<td>${rs.members_Area}</td>
					<td>${rs.members_Name}</td>
					<td>${rs.members_Job}</td>
					<td>
						<form action="AddFriendInvites.do" method="post">
							<input type="hidden" value="${rs.members_ID }" name="added">
							<input type="hidden" value="${LoginOK.members_ID }" name="add">
							<input type="submit" value="加入好友">
						</form>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</center>
</body>
</html>