<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
select{
	background-color: #EBFF9C;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
<form action="Search.do">
	<div id="twzipcode">
	<select name="gen">
			<option value="boy">男生</option>
			<option value="girl">女生</option>
	</select>
	</div>
	
	<input TYPE="submit" value="搜尋" class="btn btn-primary btn-xs">
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