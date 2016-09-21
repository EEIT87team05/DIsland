
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登錄</title>
<style>
body{
font-family: Microsoft JhengHei
}
input, select { /*針對input作修改*/
	padding: 5px 15px;
	background: #ccc;
	border: 10 none;
	cursor: pointer; /*改變游標狀態*/
	-webkit-border-radius: 5px;
	width: 180px;
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
	font-family: Arial;
	color: #ffffff;
	font-size: 15px;
	padding: 9px 20px 10px 20px;
	text-decoration: none;
	cursor: pointer; /*改變游標狀態*/
}
input[type="button"] {
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
	font-family: Arial;
	color: #ffffff;
	font-size: 15px;
	padding: 9px 20px 10px 20px;
	text-decoration: none;
	cursor: pointer; /*改變游標狀態*/
}

</style>
<link rel="stylesheet" href="../css/animate.css">
</head>
<body>
<jsp:include page="/fragment/top.jsp"/>
<CENTER>  
<!-- 
<Form Action="login.do" method="POST">
 -->
 <!-- 
<Form Action="<c:url value='login.do' />" method="POST">
 -->
<Form Action="<c:url value='login.do' />" method="POST">
	<Table width='430'  border="solid 1px red" style="float:right;margin-right:50px;" >
         <tr>
         	<th colspan="3">
            	<h2 align="CENTER"  class="animated infinite flash">會員登入</h2>
         	</th>
         </tr>
         <tr>
             <td align="RIGHT"  width='120'>帳號：</td>
             <td align="LEFT">
             	<input type="text" name="userId" size="10" style="background-color:#EBFF9C;">
             </td>
             <td width='120'>
             	<small>
             		<Font color='red' size="-1" >${ErrorMsgKey.AccountEmptyError}</Font>
             	</small>
             </td>
         </tr>
         
         <tr>
             <td align="RIGHT"  width='120'>密碼：</td>
             <td align="LEFT" >
             	<input	type="password" name="pswd"  size="10" style="background-color:#EBFF9C;">
             </td>
             <td width='120'>
             	<small>
             		<Font color='red'  size="-1">${ErrorMsgKey.PasswordEmptyError}</Font>
             	</small>
             </td>
         </tr>
         <tr>
           <td align="CENTER" colspan='3' align="center">
             	<Font color='red' size="-1" >${ErrorMsgKey.LoginError}&nbsp;</Font>
             </td>
             <td></td>
             <td></td>
         </tr>           
         <tr>
               <td colspan='3' align="CENTER">
         		 <input type="button" value="立即註冊"  align="center"
         		 onclick=" javascript:window.location.href='../_01_register/register.jsp' ">
         	</td>
         	 <td></td>
             <td></td>
         </tr>
        <tr>
            <td colspan="3" align="center">
                  <input type="submit" value="提交">
            </td>
             <td></td>
             <td></td>
        </tr>
	</Table>        
         
</Form>
</CENTER>
</body>

</html>
