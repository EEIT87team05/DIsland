<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input, select { /*針對input作修改*/
	padding: 5px 15px;
	background: #ccc;
	border: 10 none;
	cursor: pointer; /*改變游標狀態*/
	-webkit-border-radius: 5px;
	width: 150px;
	background-color:#EBFF9C;
	font-color:#0000FF;
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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
<form action="Search.do">
	
	<div id="twzipcode">
	<select name="gen" >
			<option value="boy">男生</option>
			<option value="girl">女生</option>
	</select>
	</div>
	<input type="hidden" value="${LoginOK.members_ID}" name="memberId" >
	<input type="submit" value="搜尋" >
</form>
	<script type="text/javascript">
	$('#twzipcode').twzipcode({
	    'zipcodeSel'  : '106', // 此參數會優先於 countySel, districtSel
	    'countySel'   : '台北市',
	    'districtSel' : '大安區'
	});
	</script>
</body>
</html>