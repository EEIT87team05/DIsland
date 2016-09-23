
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="_01_register.model.*"%>

<jsp:useBean id="bean1" class="_01_register.model.MembersDAO" />
<link href="http://www.WSEZ.NET/favicon.ico" rel="shortcut icon"/>
<link href="../css/base.css?version=130404" type="text/css" rel="stylesheet" />

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
	<jsp:include page="../fragment/top.jsp" />
	<c:choose>
		<c:when test="${ empty bean1.allMembers1}">
          目前尚未有任何會員資料
          
          
      </c:when>
		<c:otherwise>

			<table>
				<tr>
					<td>
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

																	<a
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

							</tr>
						</table>
					</td>
					<td>
						<div class="top_slider" id="pl_app_focus">
							<div class="ts_inner" node-type="slider">
								<ul class="slider_list">
									<li class="slider_item ">

										<div class="column_large ">
											<div class="column_large_one" action-type="showdesc">
												<div class="column_img_container">
													<img class="column_large_img" width="390" height="260"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=1&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 84%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>
										</div>





										<div class="column_small middle_column">
											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=2&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 84%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>






											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=3&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 84%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>

										</div>





										<div class="column_small ">
											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=4&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 82%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>






											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=6&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 84%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>

										</div>



									</li>
									<li class="slider_item ">

										<div class="column_small ">
											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=7&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 68%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>






											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=8&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 82%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>

										</div>





										<div class="column_large middle_column">
											<div class="column_large_one" action-type="showdesc">
												<div class="column_img_container">
													<img class="column_large_img" width="390" height="260"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=10&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: %"
																class="star_bar"></i></i> <span class="column_play_count"></span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>
										</div>





										<div class="column_small ">
											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=11&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 0%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>






											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=12&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 86%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>

										</div>



									</li>
									<li class="slider_item ">

										<div class="column_small ">
											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=14&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 100%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜。</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>






											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=15&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 68%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>

										</div>





										<div class="column_small middle_column">
											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=16&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 86%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>






											<div class="column_small_first " action-type="showdesc">
												<div class="column_img_container">
													<img class="column_small_img" width="195" height="130"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=17&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 84%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>

										</div>





										<div class="column_large ">
											<div class="column_large_one" action-type="showdesc">
												<div class="column_img_container">
													<img class="column_large_img" width="390" height="260"
														src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=18&type=MEMBER2" alt="" />
												</div>
												<div class="column_select_layer">
													<div class="layer_content">
														<p class="column_title">ZHIME内衣丝袜</p>
														<div class="column_info">
															<i class="allstar"><i style="width: 84%"
																class="star_bar"></i></i> <span class="column_play_count">女人需要编织自己才能获得甜蜜</span>
														</div>
													</div>
													<div class="layer_mask"></div>
												</div>
												<a class="column_item_link" href="http://www.wsez.net/"
													title="" target="_blank"></a>
											</div>
										</div>



									</li>
								</ul>
								<a class="slider_btn_left" href="javascript:;" title=""
									node-type="prev"></a> <a class="slider_btn_right"
									href="javascript:;" title="" node-type="next"></a>
							</div>
						</div> 
						<script type="text/javascript" src="../js/slider.js?version=130404"></script>
						<script type="text/javascript" src="../js/base.js?version=130404"></script>
					</td>
				</tr>


				<tr>
					<td>
						
					</td>
					<td>
					<table>
							<Form
								action="<c:url value='/_07_game/controller/LotteryServlet.java' />"
								method="POST">

								${LoginOK.members_Name}
								${other.members_Name}
								<P />

								<input type="hidden" name="id" value="${LoginOK.members_ID }">
								<input type="hidden" name="name"
									value="${LoginOK.members_Name }"> <input type="hidden"
									name="sex" value="${LoginOK.members_Sexuality }"> <input
									type="submit" value="邱比特的箭">
								<P />
							</Form>
						</table>
					</td>
				</tr>

			</table>






		</c:otherwise>
	</c:choose>

</body>
</html>