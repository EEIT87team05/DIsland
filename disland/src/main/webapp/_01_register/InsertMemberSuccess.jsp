<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>註冊成功!請開始享用本系統</h2>
<h2>會員 ${ memberBean.name } 的資料新增成功</h2>
編號: ${ memberBean.memberId }<BR>
帳號: ${ memberBean.account}<BR>
地址: ${ memberBean.address }<BR>
生日: ${ memberBean.birthday }<BR>
註冊時間: ${ memberBean.registerDate }<BR>


</body>
</html>