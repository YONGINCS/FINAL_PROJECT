<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recharge page</title>
</head>
<body>
<form method="post" action="loginsuccess.jsp">
<input type="submit" value="뒤로"></form>
<div style="position:absolute; top:200px; right:315px"><input type="submit" value="충전하기"></div>
<table cellpadding="10px" style="position:relative; left:100px; top:50px;">
	<tr>
		<td><input type="radio" name="price" value="1000원">1000원</td>
	</tr>
	<tr>
		<td><input type="radio" name="price" value="2000원">2000원</td>
	</tr>
	<tr>
		<td><input type="radio" name="price" value="3000원">3000원</td>
	</tr>
	<tr>
		<td><input type="radio" name="price" value="3500원">3500원</td>
	</tr>
	<tr>
		<td><input type="radio" name="price" value="5000원">5000원</td>
	</tr>
	<tr>
		<td><input type="radio" name="price" value="10000원">10000원</td>
	</tr>
</table>
</body>
</html>