<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:useBean id="bean1" class="_01_register.model.MembersDAO" />
<jsp:useBean id="bean2" class="_02_friend.model.FriendsListDAO" />
<c:set var="subTitle" value="查詢會員資料(Lab05_09)" />
<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
table{
	border: "1";
	border-color: "black";
}
td{
	padding-right: 10;
}
.black{
	color: black;
}
.xxxxx{
	padding-top:5px; 
 	padding-left:5px; 
 	padding-right:5px; 
 	padding-bottom:5px; 
 	color: black;
}
.xxx{
	padding-top:3px; 
 	padding-left:3px; 
 	padding-right:3px; 
 	padding-bottom:3px; 
 	color: black;
}
</style>
  
<title>members</title>

		

<c:if test="${empty LoginOK}">
	<c:redirect url="/_01_register/login.jsp" />
</c:if>
 
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
     
       
      
     
	

	<!-- Intro Header -->

	<div class="intro-body">
		<table width="960" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr valign="top">
				<td width="260"
					style="padding: 10px 0px 10px 0px">
					<table width="230" border="0" align="center" cellpadding="0"
						cellspacing="0">
						

						<tr>
							<td align="center" bgcolor="#FFFFFF" style="padding: 5px 0px">
								<table width="200" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="center">
											<div id="iFilePic"
												style="position: relative; width: 200px; overflow: hidden">
												<div
													style="position: relative; width: 250px; left: -25px; text-align: center">
													
													
														
						                            <c:if test="${! empty LoginOK }">   
														
<img height='400px' width='300px' src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.members_Account}&type=MEMBER' />	
                                       
                                                    </c:if>
													
													
												</div>
											</div>
										</td>
									</tr>
								</table>

							</td>

						</tr>
					
					</table>
					
					</td>
					
					<!-- <table width="230" border="0" align="center" cellpadding="0"
						cellspacing="0" style="margin-top: 15px">

						<tr>
							<td
								style="background: url(http://img.ipimg.com/images/ifile/left_bg03.gif) bottom center repeat-y; padding: 10px 0px">
								<div
									style="margin: auto; width: 190px; font-size: 9pt; color: black; background-color: #f3f3f3; padding: 5px">
									交友編號： 7801534&nbsp;&nbsp; <br> 瀏覽次數： 0<br> 人氣指數： 159<br>
									友好指數： 1<br> 更新日期： 2016-09-02 15:43<br> 上次上站：
									2016-09-02 15:28
								</div>
								<table border="0" align="center" cellpadding="5" cellspacing="0"
									style="margin-top: 10px">
								</table>
							</td>
						</tr>
					</table> -->
				

				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						style="border-bottom: 1px solid #dddddd">
						<tr>
							<td style="padding: 15px 0px 4px 0px"><a
								href="/file/file_changedata.php"><img
									src="http://img.ipimg.com/images/ifile/btn_edit_data.gif"
									width="81" height="35" border="0"></a>
									
							</td>
							<td>
								<a href='<c:url value="/_02_friend/friendlist.jsp"/>'>
									好友名單
								</a>
							</td>
							<td>
								<input type="button" value="好友邀請" class="btn btn-danger" data-toggle="modal" data-target="#showinvites">
							</td>
							<td>
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
							</td>
						</tr>
					</table>
<iframe id="aaa" name="aaa" style="display:none"></iframe>

					<div style="padding: 10px 10px 0px; width: 435px; display: none">
						<div id="moodpost_fileview"
							style="background: url(http://img.ipimg.com/images2/moodpost/fileView_post.jpg) 0 0 no-repeat; width: 100%; height: 46px; display: block; line-height: 45px; padding-left: 26px">
						</div>
					</div> <script>
						moodpost_fileview('7801534')
					</script>

					<div style="padding: 10px">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td valign="top" bgcolor="#ddeeff"><img
									src="http://img.ipimg.com/images/coner_white_lt.gif" width="4"
									height="4"></td>
								<td align="right" valign="top" bgcolor="#ddeeff"><img
									src="http://img.ipimg.com/images/coner_white_rt.gif" width="4"
									height="4"></td>
								
							</tr>
							
							
							<tr>
								<td colspan="2"
									style="padding: 1px 5px; background-color: #ddeeff"><div
										style="margin: auto; background-color: black; border: 1px solid #c2e0ff; padding: 10px">
										<table width="100%" border="0" cellpadding="2" cellspacing="0">
											<tr>
												<td align="left" width="50%" nowrap style="font-size: 11pt"><font
													color="#c76900">暱 稱：</font>${Friend.name}<img
													src="http://img.i-part.com.tw/images/ifile/icon_c1.gif"
													border=0 class="reg_icon_click" id="recoginze_7801534"
													style="cursor: pointer"></td>
												<td align="left" style="font-size: 11pt"><font
													color="#c76900">性 別：</font> ${LoginOK.members_Gender}</td>
												<td align="right"><a href="/file/file_changedata.php">修改</a></td>
											</tr>
											<tr>
												<td align="left" style="font-size: 11pt"><font
													color="#c76900">年 齡：</font> 25 歲</td>
                                                       <!-- 	這要記得+EL -->
												<td align="left" colspan="2" style="font-size: 11pt"><font
													color="#c76900">星 座：</font>  ${LoginOK.members_Constellation}</td>
											</tr>
											<tr>
												<td align="left" style="font-size: 11pt"><font
													color="#c76900">身 高：</font> ${LoginOK.members_Height}</td>
												<td align="left" colspan="2" style="font-size: 11pt"><font
													color="#c76900">現居地：</font> ${LoginOK.members_City}</td>
											</tr>
											<tr>
												<td align="left" style="font-size: 11pt"><font
													color="#c76900">體 重：</font>  ${LoginOK.members_Weight}</td>
												<td align="left" colspan="2" style="font-size: 11pt"><font
													color="#c76900">地區：</font> ${LoginOK.members_Area}</td>
											</tr>
											<tr>
												<td align="left" style="font-size: 11pt"><font
													color="#c76900">感情：</font> ${LoginOK.members_RelationshipState}</td>
													<td align="left" colspan="2" style="font-size: 11pt"><font
													color="#c76900">職 業：</font> ${LoginOK.members_Job}</td>
											</tr>
											<tr>
												<td colspan="3" style="font-size: 11pt"></td>
											</tr>
										</table>

									</div></td>
							</tr>
						</table>

						

						



						<table width="100%" border="0" cellpadding="2" cellspacing="0"
							style="margin: 18px 0px 8px 0px; background-color: #ddeeff">
							<tr>
								<td align="left" style="color: #444444; font-weight: bold">&nbsp;<img
									src="http://img.ipimg.com/images/icon04.gif" width="13"
									height="11" align="absmiddle"> 自我介紹
								</td>
								<td align="right" style="padding-right: 5px"><a
									href="/file/file_changedata.php">修改</a></td>
							</tr>
						</table>

						<div align="left"
							style="padding: 2px 10px 0px 10px; width: 420px; height: auto; overflow: hidden">
							     ${LoginOK.members_Itroduce}
							
							
						</div>
						


					</div>
				</td>
				
				
				</tr>
			    </table></div>

				<!-- Footer -->
				

              


			
<script>
$(function(){
	var id = ${LoginOK.members_ID}
	$('#showinvites').one("mouseenter",function(){
		$.getJSON('<%=request.getContextPath()%>/_02_friend/InvitesFriendsServlet',{memberId:id},function(datas){
			var myBody = $('#test>tbody')
			$.each(datas,function(idx,friend){
				var cell1 = $('<td></td>').text(friend.addId).addClass('xxxxx')
				var cell2 = $('<td></td>').text(friend.addName).addClass('xxxxx')
				var cell3 = $('<td></td>').append('<form target="aaa"><input type="hidden" value='+${LoginOK.members_ID}+' name="addedId" id="addedId1"><input type="hidden" value='+friend.addId+' name="addId" id="addId1"><input type="button" value="確認" id="OK" class="OKOK"></form>')
				var cell4 = $('<td></td>').append('<input type="button" value="刪除" id="NO">')
				var row = $('<tr></tr>').append([cell1,cell2,cell3,cell4])
				myBody.append(row)
			})
		})
	})
	
	$('table').on('click','.OKOK',function(){
		var abc = $(this).parents("form").children("#addedId1").val();
		var def = $(this).parents("form").children("#addId1").val();
		$.ajax({
			url:'<%=request.getContextPath()%>/_02_friend/CheckInvitesServlet.do',
			data:'&addedId='+def+"&addId="+abc+"&type=add",
			type:'post',
			dataType:'html',
			success:function(){
			}
		})
		$(this).parents("tr").remove();
	})
})

</script>			
</body>
</html>