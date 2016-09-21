<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<<<<<<< HEAD
<jsp:useBean id="bean1" class="_01_register.model.MembersDAO" />
<jsp:useBean id="bean2" class="_02_friend.model.FriendsListDAO" />
<c:set var="subTitle" value="查詢會員資料(Lab05_09)" />
<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
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
}
.xxx{
	padding-top:3px; 
 	padding-left:3px; 
 	padding-right:3px; 
 	padding-bottom:3px; 

}
</style>
  
<title>members</title>

		

<c:if test="${empty LoginOK}">
	<c:redirect url="/_01_register/login.jsp" />
</c:if>
 
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
<jsp:include page="/fragment/top.jsp" />
       <c:choose>
       
        <c:when test="${ empty bean1.allMembers1}">
          目前尚未有任何會員資料
      </c:when>
      <c:otherwise>
	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-main-collapse">
				Menu <i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="../index.jsp"> <i
				class="fa fa-camera-retro fa-x"></i> <span class="light">D-</span>
				island
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div
			class="collapse navbar-collapse navbar-right navbar-main-collapse">
			<ul class="nav navbar-nav">
				<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
				<li class="hidden"><a href="#top"></a></li>
				<li><a href="#about">立即療傷</a></li>
				<li><a href="<%=request.getContextPath()%>/_07_game/regionPairing.jsp">立即交友</a></li>
				<li><a href="#contact">討拍</a></li>
				<li><a href="<%=request.getContextPath()%>/_01_register/members.jsp">會員專區</a></li>
				<li><a href="<%=request.getContextPath()%>/_07_game/random-first.jsp">邱比特</a></li>
				<li><a href="<%=request.getContextPath()%>/_08_gameFate/fate.jsp">緣點</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Intro Header -->
	<header class="intro">
	<div class="intro-body">
		<table width="960" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr valign="top">
				<td width="260"
					style="padding: 10px 0px 10px 0px; background: url(../img/other/background1.jpg) repeat left top">
					<table width="230" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td align="center" valign="top"
								style="background: url(http://img.ipimg.com/images/ifile/left_bg01.gif) bottom center no-repeat; font-size: 9pt; height: 32px">
								<div align="center">
									<img src="http://img.ipimg.com/images/space.gif" width="1"
										height="4">
								</div> <!-- <a>公寓造型</a> / <a>本人照片</a> -->
							</td>
						</tr>

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
													
													<a class="photoBiger" 
														href="http://van.ipimg.com/ialbum/34/15/80/07/7801534/photo_1472801276.jpg">
														
						                            <c:if test="${! empty LoginOK }">   
														
<img height='400px' width='300px' src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.members_Account}&type=MEMBER5' />	
                                       
                                                    </c:if>
													</a>
													
												</div>
											</div>
										</td>
									</tr>
								</table>

							</td>

						</tr>

						<tr>
							<td></td>
						</tr>


					</table>
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
				</td>

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
								<a href='<c:url value="../_02_friend/friendlist.jsp"/>'>
									好友名單
								</a>
							</td>
							<td>
								<input type="button" value="好友邀請" class="btn btn-danger" data-toggle="modal" data-target="#showinvites">
							</td>
							
						</tr>
					</table>


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
							
							
<%-- 							<c:forEach var="aBean" items="${ bean1.allMembers1}" > --%>
							<tr>
								<td colspan="2"
									style="padding: 1px 5px; background-color: #ddeeff"><div
										style="margin: auto; background-color: black; border: 1px solid #c2e0ff; padding: 10px">
										<table width="100%" border="0" cellpadding="2" cellspacing="0">
											<tr>
												<td align="left" width="50%" nowrap style="font-size: 11pt"><font
													color="#c76900">暱 稱：</font>${LoginOK.members_Name}<img
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
									height="11" align="absmiddle"> 基本資料
								</td>
								<td align="right" style="padding-right: 5px"><a
									href="/file/file_changedata.php">修改</a></td>
							</tr>
						</table>

						<table width="100%" border="0" cellpadding="2" cellspacing="0"
							style="background-color: black">
							<tr>
								<td width="278" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" /> <font color="#C76900">現居住：</font>
									台灣> 新北市 > 淡水區</td>
							</tr>
							<tr>
								<td width="278" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" />&nbsp; <font color="#C76900">家
										鄉：</font> 台灣> 新北市 > 淡水區</td>
							</tr>
							<!--<tr>
            <td style="border-bottom:1px dashed #999999;padding-left:10px"><img src="http://img.ipimg.com/images/arrow11.gif" width="9" height="9" align="absmiddle" />&nbsp; <font color="#C76900">職　　業：</font> 資訊</td>
          </tr>-->
							<tr>
								<td align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" />&nbsp; <font color="#C76900">收
										入：</font> 保密</td>
							</tr>
							<tr>
								<td align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" />&nbsp; <font color="#C76900">抽
										煙：</font></td>
							</tr>
							<tr>
								<td align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" />&nbsp; <font color="#C76900">飲
										酒：</font></td>
							</tr>
							<tr>
								<td height="27" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><table
										width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="87"><img
												src="http://img.ipimg.com/images/arrow11.gif" width="9"
												height="9" style="vertical-align: middle">&nbsp; <font
												color="#C76900">個 性：</font></td>
											<td>不拘</td>
										</tr>
									</table></td>
							</tr>
							<tr>
								<td align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" />&nbsp; <font color="#C76900">信
										仰：</font></td>
							</tr>
							<tr>
								<td align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" />&nbsp; <font color="#C76900">學
										歷：</font></td>
							</tr>
							<tr>
								<td align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" align="absmiddle" />&nbsp; <font color="#C76900">學
										校：</font> 尚未填寫</td>
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
						<table width="100%" border="0" cellpadding="2" cellspacing="0"
							style="margin: 18px 0px 8px 0px; background-color: #ddeeff">
							<tr>
								<td align="left" style="color: #444444; font-weight: bold">&nbsp;<img
									src="http://img.ipimg.com/images/icon04.gif" width="13"
									height="11" align="absmiddle"> 擇友條件
								</td>
								<td align="right" style="padding-right: 5px"><a
									href="/file/file_friend.php">修改</a></td>
							</tr>
						</table>
						<table width="100%" border="0" cellpadding="2" cellspacing="0">
							<tr>
								<td colspan="2" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" style="vertical-align: middle">&nbsp; <font
									color="#C76900">年齡要求：</font> ${xxxxxx.Mem_Members_ID2}</td>
							</tr>
							<tr>
								<td colspan="2" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" style="vertical-align: middle">&nbsp; <font
									color="#C76900">身高要求：</font> 0cm~0cm</td>
							</tr>
							<tr>
								<td colspan="2" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" style="vertical-align: middle">&nbsp; <font
									color="#C76900">體重要求：</font> 0kg~0kg</td>
							</tr>
							<tr>
								<td colspan="2" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" style="vertical-align: middle">&nbsp; <font
									color="#C76900">學歷要求：</font></td>
							</tr>
							<tr>
								<td colspan="2" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" style="vertical-align: middle">&nbsp; <font
									color="#C76900">信仰要求：</font></td>
							</tr>
							<tr>
								<td colspan="2" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" style="vertical-align: middle">&nbsp; <font
									color="#C76900">個性要求：</font> 不拘</td>
							</tr>
							<tr>
								<td colspan="2" align="left"
									style="border-bottom: 1px dashed #999999; padding-left: 10px"><img
									src="http://img.ipimg.com/images/arrow11.gif" width="9"
									height="9" style="vertical-align: middle">&nbsp; <font
									color="#C76900">希望交往關係：</font> 談心好友,男女朋友,純情邂逅</td>
							</tr>
						</table>


					</div>
				</td>
				
				
				
				</header>

				<!-- Footer -->
				<footer>
				<div class="container text-center">
					<p></p>
				</div>
				</footer>

                  </c:otherwise>
				 </c:choose>
<%-- 				  </c:forEach> --%>


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
				
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>members</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">

<!-- Theme CSS -->
<link href="../css/grayscale.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>Insert title here</title>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-main-collapse">
				Menu <i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top"> <i
				class="fa fa-camera-retro fa-x"></i> <span class="light">D-</span>
				island
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div
			class="collapse navbar-collapse navbar-right navbar-main-collapse">
			<ul class="nav navbar-nav">
				<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
				<li class="hidden"><a href="#page-top"></a></li>
				<li><a href="#about">立即療傷</a></li>
				<li><a href="#download">立即交友</a></li>
				<li><a href="#contact">討拍</a></li>
				<li><a href="#contact">會員專區</a></li>
				<li><a href="#contact">邱比特</a></li>
				<li><a href="#contact">緣點</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Intro Header -->
	<header class="intro">
	<div class="intro-body">
		<table width="960" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr valign="top">
				<td width="260"
					style="padding: 10px 0px 10px 0px; background: url(../img/other/background1.jpg) repeat left top">
					<table width="230" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td align="center" valign="top"
								style="background: url(http://img.ipimg.com/images/ifile/left_bg01.gif) bottom center no-repeat; font-size: 9pt; height: 32px">
								<div align="center">
									<img src="http://img.ipimg.com/images/space.gif" width="1"
										height="4">
								</div> <a>公寓造型</a> / <a>本人照片</a>
							</td>
						</tr>

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
													<a class="photoBiger"
														href="http://van.ipimg.com/ialbum/34/15/80/07/7801534/photo_1472801276.jpg">
														<img
														src="http://van.ipimg.com/ialbum/34/15/80/07/7801534/photo_1472801276m.jpg"
														border="0">
														
														<!-- 這裡到時候記得修改EL，連接到資料庫拿照片 -->
														
														
													</a>
												</div>
											</div>






										</td>
									</tr>
								</table>

							</td>

						</tr>

						<tr>
							<td></td>
						</tr>

					</table>
					<table width="230" border="0" align="center" cellpadding="0"
						cellspacing="0" style="margin-top: 15px">
						
						<tr>
							<td
								style="background: url(http://img.ipimg.com/images/ifile/left_bg03.gif) bottom center repeat-y; padding: 10px 0px">
								<div
									style="margin: auto; width: 190px; font-size: 9pt;color:black; background-color: #f3f3f3; padding: 5px">
									交友編號： 7801534&nbsp;&nbsp; <br> 瀏覽次數： 0<br> 人氣指數： 159<br>
									友好指數： 1<br> 更新日期： 2016-09-02 15:43<br> 上次上站：
									2016-09-02 15:28
								</div>



								

								
								
								
								<table border="0" align="center" cellpadding="5" cellspacing="0"
									style="margin-top: 10px">
								</table>


							</td>
						</tr>
						
					</table>

				</td>
			</tr>
		</table>
	</div>
	</header>

	<!-- Footer -->
	<footer>
	<div class="container text-center">
		<p>Hello, World!</p>
	</div>
	</footer>






	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="../https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<script type="../text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

	<!-- Theme JavaScript -->
	<script src="../js/grayscale.min.js"></script>

>>>>>>> branch 'master' of https://github.com/EEIT87team05/DIsland.git
</body>
</html>