<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
table{
	border: "1";
	border-color: "black";
}
td{
	color: black;
	padding-right: 10;
}
.black{
	color: black;
}
a{
	color: black;
}
.xxxxx{
	padding-top:5px; 
 	padding-left:5px; 
 	padding-right:5px; 
 	padding-bottom:5px; 
}
.xxx{
	padding-top:3px; 
 	padding-left:3px; 
 	padding-right:3px; 
 	padding-bottom:3px; 

}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp"/>

<input type="button" value="好友邀請" class="btn btn-danger" data-toggle="modal" data-target="#showinvites">

<div class="modal fade" id="showinvites" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
	        <span aria-hidden="true">&times;</span>
	        <span class="sr-only">Close</span>
        </button>
        <h4 class="modal-title black" id="myModalLabel">好友邀請</h4>
      </div>
      <div class="modal-body">
        <table id="test">
			<tbody></tbody>
		</table>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
	var id = ${LoginOK.members_ID}
	$('#showinvites').one("mouseenter",function(){
		$.getJSON('<%=request.getContextPath()%>/_02_friend/InvitesFriendsServlet',{memberId:id},function(datas){
			var myBody = $('#test>tbody')
			$.each(datas,function(idx,friend){
				var addedId = friend.addedId
				var addId = friend.addId
				var addName = friend.addName
				var cell1 = $("<td></td>").text(friend.addId).addClass('xxxxx');
				var cell2 = $("<td></td>").text(friend.addName).addClass('xxxxx');
				var cell3 = $("<td></td>").append('<a href="${pageContext.servletContext.contextPath}/CheckInvitesServlet.do?type=add&addedId='+addedId+'&addId='+addId+'" class="btn btn-primary btn-xs active" role="button">確認</a>').addClass('xxx');
				var cell4 = $("<td></td>").append('<a href="${pageContext.servletContext.contextPath}/CheckInvitesServlet.do?type=delete&addedId='+addedId+'&addId='+addId+'" class="btn btn-default btn-xs active" role="button">刪除邀請</a>').addClass('xxx');
				var row = $("<tr></tr>").append([cell1,cell2,cell3,cell4]);
				myBody.append(row);
			})
		})
	})
</script>


</body>
</html>