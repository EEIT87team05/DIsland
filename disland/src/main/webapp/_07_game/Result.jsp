<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/modernizr.custom.53451.js"></script>
<title>結果</title>
<style type="text/css">
input, select { /*針對input作修改*/
	padding: 5px 15px;
	background: #ccc;
	border: 10 none;
	cursor: pointer; /*改變游標狀態*/
	-webkit-border-radius: 5px;
	width: 150px;
	background-color: #EBFF9C;
}

input[type="submit"] {
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
	color: #ffffff;
	font-size: 16px;
	padding: 5px 5px 5px 5px;
	text-decoration: none;
	cursor: pointer; /*改變游標狀態*/
}

input[type="submit"]:hover {
	background: #fc3c73;
	background-image: -webkit-linear-gradient(top, #fc3c73, #3498db);
	background-image: -moz-linear-gradient(top, #fc3c73, #3498db);
	background-image: -ms-linear-gradient(top, #fc3c73, #3498db);
	background-image: -o-linear-gradient(top, #fc3c73, #3498db);
	background-image: linear-gradient(to bottom, #fc3c73, #3498db);
	text-decoration: none;
	cursor: pointer; /*改變游標狀態*/
}

.dg-container {
	width: 100%;
	height: 450px;
	position: relative;
}

.dg-wrapper {
	width: 300px;
	height: 300px;
	margin: 0 auto;
	position: relative;
	-webkit-transform-style: preserve-3d;
	-moz-transform-style: preserve-3d;
	-o-transform-style: preserve-3d;
	-ms-transform-style: preserve-3d;
	transform-style: preserve-3d;
	-webkit-perspective: 1000px;
	-moz-perspective: 1000px;
	-o-perspective: 1000px;
	-ms-perspective: 1000px;
	perspective: 1000px;
}

.dg-wrapper a {
	width: 300px;
	height: 300px;
	display: block;
	position: absolute;
	left: 0;
	top: 0;
	box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.3);
}

.dg-wrapper a.dg-transition {
	-webkit-transition: all 0.5s ease-in-out;
	-moz-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	-ms-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
}

.dg-wrapper a img {
	display: block;
	padding: 2px 0px 0px 1px;
}

.dg-wrapper a div {
	font-style: italic;
	text-align: center;
	line-height: 50px;
	text-shadow: 1px 1px 1px rgba(255, 255, 255, 0.5);
	color: #333;
	font-size: 16px;
	width: 100%;
	bottom: -55px;
	display: none;
	position: absolute;
}

.dg-wrapper a.dg-center div {
	display: block;
}

.dg-container nav {
	width: 58px;
	position: absolute;
	z-index: 1000;
	bottom: 40px;
	left: 50%;
	margin-left: -29px;
}

.dg-container nav span {
	text-indent: -9000px;
	float: left;
	cursor: pointer;
	width: 24px;
	height: 25px;
	opacity: 0.8;
	background: transparent url(../img/arrows.png) no-repeat top left;
}

.dg-container nav span:hover {
	opacity: 1;
}

.dg-container nav span.dg-next {
	background-position: top right;
	margin-left: 10px;
}

body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form,
	fieldset, input, textarea, p, blockquote, th, td {
	margin: 0;
	padding: 0;
}

html, body {
	margin: 0;
	padding: 0;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

fieldset, img {
	border: 0;
}

address, caption, cite, code, dfn, th, var {
	font-style: normal;
	font-weight: normal;
}

ol, ul {
	list-style: none;
}

caption, th {
	text-align: left;
}

h1, h2, h3, h4, h5, h6 {
	font-size: 100%;
	font-weight: normal;
}

q:before, q:after {
	content: '';
}

abbr, acronym {
	border: 0;
}

section, header {
	display: block;
}
/* General Demo Style */
body {
	font-family: Cambria, Palatino, "Palatino Linotype", "Palatino LT STD",
		Georgia, serif;
	background: #333 url(../../img/bg.jpg) repeat top left;
	font-weight: 400;
	font-size: 15px;
	color: #f0f0f0;
	overflow-y: scroll;
}

a {
	color: #ddd;
	text-decoration: none;
}

a:hover {
	color: #fff;
}

.container {
	width: 100%;
	position: relative;
	text-align: center;
}

.clr {
	clear: both;
}

.container>header {
	padding: 20px 30px 10px 30px;
	margin-bottom: 40px;
	position: relative;
	display: block;
	text-align: center;
}

.container>header h1 {
	font-family: "BebasNeueRegular", Arial, sans-serif;
	font-size: 35px;
	position: relative;
	font-weight: 300;
	text-transform: uppercase;
	color: rgba(101, 141, 114, 0.9);
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.2);
	padding: 0px 0px 5px 0px;
}

.container>header h1 span {
	color: #a0caad;
	text-shadow: 1px 1px 1px rgba(255, 255, 255, 0.4);
}

.container>header h2 {
	
}
/* Header Style */
.codrops-top {
	line-height: 24px;
	font-size: 11px;
	background: rgba(255, 255, 255, 0.5);
	text-transform: uppercase;
	z-index: 9999;
	position: relative;
	box-shadow: 1px 0px 2px rgba(0, 0, 0, 0.2);
	-webkit-animation: slideOut 0.5s ease-in-out 0.3s backwards;
}

@-webkit-keyframes slideOut { 0%{
	top: -30px;
	opacity: 0;
}

100%{
top
:
0px;
 
opacity
:
 
1;
}
}
.codrops-top a {
	padding: 0px 10px;
	letter-spacing: 1px;
	color: #333;
	text-shadow: 0px 1px 1px #fff;
	display: block;
	float: left;
}

.codrops-top a:hover {
	background: #fff;
}

.codrops-top span.right {
	float: right;
}

.codrops-top span.right a {
	float: left;
	display: block;
}

.codrops-demos {
	text-align: center;
	display: block;
	padding-top: 20px;
}

.codrops-demos a, .codrops-demos a.current-demo, .codrops-demos a.current-demo:hover
	{
	display: inline-block;
	border: 1px solid #719c7f;
	padding: 4px 10px 3px;
	font-size: 13px;
	line-height: 18px;
	margin: 0px 3px;
	font-weight: 800;
	-webkit-box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.1);
	-moz-box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.1);
	box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.1);
	color: #fff;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.9);
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	background: #90bd9e;
	background: -moz-linear-gradient(top, #90bd9e 0%, #72a081 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #90bd9e),
		color-stop(100%, #72a081));
	background: -webkit-linear-gradient(top, #90bd9e 0%, #72a081 100%);
	background: -o-linear-gradient(top, #90bd9e 0%, #72a081 100%);
	background: -ms-linear-gradient(top, #90bd9e 0%, #72a081 100%);
	background: linear-gradient(top, #90bd9e 0%, #72a081 100%);
}

.codrops-demos a:hover {
	background: #85b995;
}

.codrops-demos a:active {
	-webkit-box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.4);
	-moz-box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.4);
	box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.4);
}

.codrops-demos a.current-demo, .codrops-demos a.current-demo:hover {
	color: #506757;
	text-shadow: 0px 1px 1px rgba(255, 255, 255, 0.3);
}
/* Media Queries */
@media screen and (max-width: 767px) {
	.container>header {
		text-align: center;
	}
	p.codrops-demos {
		position: relative;
		top: auto;
		left: auto;
	}
}
</style>
</head>
<body>
	<jsp:include page="/fragment/top.jsp" />
	
	<center>
		<div class="container">

			<div style="text-align: center; clear: both;">
				<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
				<script src="/follow.js" type="text/javascript"></script>
			</div>

			<section id="dg-container" class="dg-container">
			<div class="dg-wrapper">
				<c:forEach var="rs" varStatus="stat" items="${Result.resultset}">
					<a href="#"><img height='300px' width='300px'
						src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${rs.members_Account}&type=MEMBER"
						alt="image01">
					<div>${rs.members_Name}</div></a>

				</c:forEach>
			</div>
			<nav> <span class="dg-prev">&lt;</span> <span class="dg-next">&gt;</span>
			</nav> </section>
		</div>

	</center>
	<iframe id="aaa" name="aaa" style="display: none"></iframe>
	<form action="Search.do">
				<div id="twzipcode">
					<select name="gen">
						<option value="boy">男生</option>
						<option value="girl">女生</option>
					</select>
				</div>
				<input type="hidden" value="${LoginOK.members_ID}" name="memberId">
				<input type="submit" value="搜尋">
	</form>
</body>
<script type="text/javascript">
	$(function() {
		$('table').on('click', '.btn-primary', function() {
			$(this).val('已送出邀請')
		})
	})
	$(function() {
				$('#dg-container').gallery();
	});
	$('#twzipcode').twzipcode({
		'zipcodeSel' : '106', // 此參數會優先於 countySel, districtSel
		'countySel' : '台北市',
		'districtSel' : '大安區'
	});
</script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.gallery.js"></script>

</html>