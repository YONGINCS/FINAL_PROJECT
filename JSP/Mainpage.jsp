<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
</head>
<body>
<br><br>
<center><h1>QR학식 코드</h1></center><br><br>
<center>
<table cellpadding="10px">
	<tr>
		<td width="40%">학&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;번</td>
		<td><input type="text" name="std_ID" size="20"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="std_pwd" size="21"></td>
	</tr>
</table>
</center>
<br>
<center>
<form method="post" action="loginsuccess.jsp">
<input type="submit" value="로그인"></form>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<form method="post" action="Mainpage.jsp">
<input type="reset" value="취소"></form>
</center>
</body>
</html>