<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login success page</title>
</head>
<body>
<form method="post" action="Mainpage.jsp">
<input type="submit" value="뒤로"></form>
<div style="position:absolute; top:10px; left:370px">
<form method="post" action="student.jsp"><input type="submit" value="김재하"></form>
<form method="post" action="Mainpage.jsp"><input type="submit" value="로그아웃"></form>
</div>
		<form method="post" action="menu.jsp">
		<input type="submit" value="메뉴보기"></form>
		<form method="post" action="recharge.jsp">
		<input type="submit" value="충전하기"></form>
		<form method="post" action="usage.jsp">
		<input type="submit" value="사용내역"></form>
</body>
</html>