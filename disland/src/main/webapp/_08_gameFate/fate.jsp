
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
<title>邱比特 緣點</title>


<c:if test="${empty LoginOK}">
	<c:redirect url="../_01_register/login.jsp" />
</c:if>
</head>
<body>
	<jsp:include page="../fragment/top.jsp" />
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


						</td>



						<Form action="<c:url value='/_08_game/controller/Fate1Servlet.java' />" method="POST">

							${LoginOK.members_Name}  
							<P />
							<input type="hidden" name="id" value="${LoginOK.members_ID }">
							<input type="hidden" name="name" value="${LoginOK.members_Name }">
							<input type="hidden" name="sex" value="${LoginOK.members_Sexuality }">
							<input type="submit" value="開始緣點">
							<P />
						</Form>
						<Form action="<c:url value='/_08_game/controller/FatecheckServlet.java' />" method="POST">											
							<input type="hidden" name="id" value="${LoginOK.members_ID }">
							<input type="hidden" name="name" value="${LoginOK.members_Name }">
							<input type="submit" value="查看緣分">
							<P />
						</Form>
					</tr>


				</table>
			</div>
			</header>
		</c:otherwise>
	</c:choose>

</body>
</html>