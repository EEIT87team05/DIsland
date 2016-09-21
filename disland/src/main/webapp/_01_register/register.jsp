<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
<!-- include 註冊頁面所需要的格式 -->
<link rel="stylesheet" type="text/css" href="../css/register.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">


</head>
<body>
	<br>
	<h2>HerePlaceFragments</h2>
	<hr>
	<!--
		<form>標籤的 method屬性必須是"post", 而且enctype屬性必須是"multipart/form-data"
		enctype屬性的預設值為"application/x-www-form-urlencoded"

		-->
	<form id="RegisterForm" name="RegisterForm" method="post"
		action="<c:url value='register.do' />" enctype="multipart/form-data">
		<fieldset>
			<legend> 個人資訊 </legend>
			<table>
				<tr>
					<td style="text-align: right"><label for="account">E-mail(帳號):</label></td>
					<td><input type="text" id="account" name="account"
						placeholder="請輸入E-mail" required> <!-- value="${param.account}" -->
						<span id="errorMsgAccount"></span>
					<td rowspan="13"><img id="ImgShowBox" name="ImgShowBox"
						style="width: 400px; height: 400px"></td>
				</tr>

				<tr>
					<td style="text-align: right"><label for="pwd">密碼:</label></td>
					<td><input type="password" id="pwd" name="pwd"
						placeholder="請輸入6-16密碼含英文大小寫及數字" required> <!-- value="${param.pwd}" -->
						<span id="errorMsgPwd"></span></td>

				</tr>

				<tr>
					<td style="text-align: right"><label for="pwd_check">密碼確認:</label></td>
					<td><input type="password" id="pwd_check" name="pwd_check"
						placeholder="請再次輸入密碼" required> <!-- value="${param.pwd_check}" -->
						<span id="errorMsgPwd_check"></span></td>
				</tr>
				
				<tr>
					<td style="text-align: right"><label for="name">真實姓名:</label></td>
					<td><input type="text" id="name" name="name"
						placeholder="請輸入姓名" required> <!-- value="${param.birthday}" -->
						<span id="errorMsgName"></span></td>
				</tr>
				
				<tr>
					<td style="text-align: right"><label for="birthday">生日:</label></td>
					<td><input type="text" id="birthday" name="birthday"
						placeholder="請輸入生日" required> <!-- value="${param.birthday}" -->
						<span id="errorMsgBirthday"></span></td>
				</tr>

				<tr>
					<td style="text-align: right"><label for="nickname">暱稱:(交友顯示的暱稱)</label></td>
					<td><input type="text" id="nickname" name="nickname"
						placeholder="請輸入暱稱" required > <!-- value="${param.nickname}" -->
						<span id="errorMsgNickname"></span></td>
				</tr>

				<tr>
					<td style="text-align: right"><label for="location">居住地區</label></td>
					<td id="location" ><div id="twzipcode"></div>
						<span id="errorMsgLocation"></span></td>
				</tr>

				<tr>
					<td style="text-align: right"><label for="height">身高:</label></td>
					<td><select id="height" name="height">
							<script>
								for (var i = 100; i <= 200; i++) {
									document.write("<option value=" + i + ">"+ i + "</option>");
								}
							</script>
					</select><span id="errorMsgHeight"> </span></td>
				</tr>

				<tr>
					<td style="text-align: right"><label for="weight">體重:</label></td>
					<td><select id="weight" name="weight">
							<script>
								for (var i = 20; i <= 120; i++) {
									document.write("<option value=" + i + ">"
											+ i + "</option>");
								}
							</script>
							</select>
							<span id="errorMsgWeight"></span></td>
				</tr>

				<tr>
					<td style="text-align: right"><label for="job">職業:</label></td>
					<td><input type="text" id="job" name="job" placeholder="請輸入職業"
						required> <!-- value="${param.job}" --> <span
						id="errorMsgJob"></span></td>
				</tr>
				<tr>
					<td style="text-align: right"><label for="relationship">感情狀況:</label></td>
					<td><select id="relationship" name="relationship">
							<option value="single">單身</option>
							<option value="nsingle">死會</option>
							<option value="nsinglebut">死會但仍有交友空間</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right"><label for="gender">性別:</label></td>
					<td><select id="gender" name="gender">
							<option value="male">男</option>
							<option value="female">女</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right"><label for="sex">性取向:</label></td>
					<td><select  id="sex" name="sex">
							<option value="female">女</option>
							<option value="male">男</option>
							<option value="both">兩者皆可</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right"><label for="upload"> 上傳大頭貼:
					</label></td>
					<td><a href="" class="file">來一張美美的大頭貼吧 <input type="file"
							id="upload" name="upload" size="40" onchange="checkFile()">
					</a></td>
				</tr>
			

			</table>
		</fieldset>
		<fieldset class="submit">
			<input class="submit" type="submit" value="送出" />
		</fieldset>

	</form>
	
</body>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="../js/jquery-1.12.4.js"></script>
<script src="../js/jquery-ui.js"></script>
<script src="../js/jquery.twzipcode.js"></script>
<script src="../js/jquery.twzipcode.min.js"></script>
<script src="../js/register.js"></script>

</html>