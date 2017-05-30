
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu page</title>
</head>
<body>
<form method="post" action="loginsuccess.jsp">
<input type="submit" value="뒤로"></form>
<form method="post" action="MenuWeek.do">
<input type="submit" value="주간 메뉴"></form>


<center><h1>인성관 메뉴</h1>

<table width='600' border='1'>
<tr>
	<th>일자</th><th>위치</th><th>종류</th><th>이름</th><th>가격</th>
</tr>
<c:forEach var="menu" items="${menuInSungList}">
<tr>
<td>${menu.mn_date}</td>
<td>${menu.chain}</td>
<td>${menu.mn_type}</td>
<td>${menu.mn_name}</td>
<td>${menu.mn_price}</td>
</tr>
</c:forEach>
</table>
</center>
<br>
<br>
<br>
<br>
<center><h1>환경과학대학 메뉴</h1>

<table width='600' border='1'>
<tr>
	<th>일자</th><th>위치</th><th>종류</th><th>이름</th><th>가격</th>
</tr>
<c:forEach var="menu" items="${menuHwanList}">
<tr>
<td>${menu.mn_date}</td>
<td>${menu.chain}</td>
<td>${menu.mn_type}</td>
<td>${menu.mn_name}</td>
<td>${menu.mn_price}</td>
</tr>
</c:forEach>
</table>
<br>
<br>
<br>
<br>
</center>


<center><h1>기숙사 메뉴</h1>

<table width='600' border='1'>
<tr>
	<th>일자</th><th>위치</th><th>종류</th><th>이름</th><th>가격</th>
</tr>
<c:forEach var="menu" items="${menuDormList}">
<tr>
<td>${menu.mn_date}</td>
<td>${menu.chain}</td>
<td>${menu.mn_type}</td>
<td>${menu.mn_name}</td>
<td>${menu.mn_price}</td>
</tr>
</c:forEach>
</table>
</center>

</body>
</html>
