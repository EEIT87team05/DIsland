<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="_01_register.model.*"%>

<jsp:useBean id="bean1" class="_01_register.model.MembersDAO" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="../css/grayscale.css" rel="stylesheet"> -->
<title>邱比特 隨機配對1人</title>
<style type="text/css">
.btnR {
	background: #3498db;
	background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
	background-image: -moz-linear-gradient(top, #3498db, #2980b9);
	background-image: -ms-linear-gradient(top, #3498db, #2980b9);
	background-image: -o-linear-gradient(top, #3498db, #2980b9);
	background-image: linear-gradient(to bottom, #3498db, #2980b9);
	-webkit-border-radius: 28;
	-moz-border-radius: 28;
	border-radius: 28px;
	text-shadow: 1px 1px 3px #1a1d54;
	font-family: Arial;
	color: #ffffff;
	font-size: 30px;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
}

.btnR:hover {
	background: #3cb0fd;
	background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
	background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
	text-decoration: none;
}
</style>

<c:if test="${empty LoginOK}">
	<c:redirect url="../_01_register/login.jsp" />
</c:if>
</head>
<body>
	<jsp:include page="/fragment/top.jsp" />
	<c:choose>
		<c:when test="${ empty bean1.allMembers1}">
          目前尚未有任何會員資料
          
          
      </c:when>
		<c:otherwise>
			<header class="intro">

			<div class="intro-body">
				<table width="960" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr valign="top">
						<td width="260">


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

															<a class="photoBiger"
																href="http://van.ipimg.com/ialbum/34/15/80/07/7801534/photo_1472801276.jpg">
																<img height='400px' width='300px'
																src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.members_ID}&type=MEMBER2' />
															</a>
														</div>

													</div>
												</td>

											</tr>


										</table>

									</td>

								</tr>
							</table>

							<table width="230" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td colspan="2"
										style="padding: 1px 5px; background-color: black"><div
											style="margin: auto; background-color: black; border: 1px solid black; padding: 10px">
											<table width="100%" border="0" cellpadding="2"
												cellspacing="0">
												<tr>
													<td align="left" width="50%" nowrap style="font-size: 11pt"><font
														color="white">暱 稱：</font>${LoginOK.members_Name}</td>

												</tr>
												<tr>
													<td align="left" style="font-size: 11pt"><font
														color="white">年 齡：</font> 25 歲</td>
													<!-- 	這要記得+EL -->
													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">星座：</font> ${LoginOK.members_Constellation}</td>
												</tr>
												<tr>
													<td align="left" style="font-size: 11pt"><font
														color="white">身高：</font> ${LoginOK.members_Height}</td>
													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">現居：</font> ${LoginOK.members_City}</td>
												</tr>
												<tr>
													<td align="left" style="font-size: 11pt"><font
														color="white">體 重：</font> ${LoginOK.members_Weight}</td>
													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">地區：</font> ${LoginOK.members_Area}</td>
												</tr>
												<tr>

													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">職 業：</font> ${LoginOK.members_Job}</td>
												</tr>
												<tr>
													<td colspan="3" style="font-size: 11pt"></td>
												</tr>
											</table>

										</div></td>
								</tr>
							</table>
						</td>
						<td>
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
															<a class="photoBiger"
																href="http://van.ipimg.com/ialbum/34/15/80/07/7801534/photo_1472801276.jpg">
																<img height='400px' width='300px'
																src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${luckyNumber}&type=LUCKY' />
															</a>
														</div>
													</div>
												</td>
											</tr>
										</table>

									</td>


								</tr>
							</table>

                            
                            <table width="230" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td colspan="2"
										style="padding: 1px 5px; background-color: black">
										<div
											style="margin: auto; background-color: black; border: 1px solid black; padding: 10px">
											<table width="100%" border="0" cellpadding="2"
												cellspacing="0">
												<tr>
													<td align="left" width="50%" nowrap style="font-size: 11pt"><font
														color="white">暱 稱：</font>${luckyNumber2.members_Name}</td>

												</tr>
												<tr>
													<td align="left" style="font-size: 11pt"><font
														color="white">年 齡：</font> 25 歲</td>
													<!-- 	這要記得+EL -->
													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">星座：</font>${luckyNumber2.members_Constellation}</td>
												</tr>
												<tr>
													<td align="left" style="font-size: 11pt"><font
														color="white">身高：</font> ${luckyNumber2.members_Height}</td>
													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">現居：</font> ${luckyNumber2.members_City}</td>
												</tr>
												<tr>
													<td align="left" style="font-size: 11pt"><font
														color="white">體 重：</font> ${luckyNumber2.members_Weight}</td>
													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">地區：</font> ${luckyNumber2.members_Area}</td>
												</tr>
												<tr>

													<td align="left" colspan="2" style="font-size: 11pt"><font
														color="white">職 業：</font> ${luckyNumber2.members_Job}</td>
												</tr>
												<tr>
													<td colspan="3" style="font-size: 11pt"></td>
												</tr>
											</table>


										</div>

									</td>

								</tr>
								<tr>
									<td>
										<Form
											action="<c:url value='/_07_game/controller/LotteryFriendServlet.java' />"
											method="POST">


											<P />

											<input type="hidden" name="id" value="${LoginOK.members_ID }">
											<input type="hidden" name="name" value="${luckyNumber}">
											<input type="submit" value="加入好友">

											<P />
										</Form>
										<a href="<%=request.getContextPath()%>/_07_game/random-first.jsp"class="button">不喜歡</a>
										

									</td>
								</tr>
							</table>



							<table width="230" border="0" align="center" cellpadding="0"
								cellspacing="0">
								
								<tr>
									<td>
										<%-- <Form
											action="<c:url value='/_07_game/controller/LotteryFriendServlet.java' />"
											method="POST">


											
                                            <P />
											<input type="hidden" name="id" value="${LoginOK.members_ID }">
											<input type="hidden" name="name" value="${luckyNumber}">
											<input type="submit" value="顯示個人資料">

											
										</Form> --%>	
<%-- 								<a href="<%=request.getContextPath()%>/_07_game/random-first.jsp"class="button">不喜歡</a> --%>

									</td>
								</tr>
							</table>


						</td>
					</tr>


				</table>

			</div>
			</header>
		</c:otherwise>
	</c:choose>

</body>
</html>