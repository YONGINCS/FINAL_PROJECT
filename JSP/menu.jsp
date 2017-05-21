<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;

	String url="jdbc:mysql://localhost:3306/project";
	String uid="root";
	String pwd="system";
	String sql="select * from menu";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu page</title>
</head>
<body>
<form method="post" action="loginsuccess.jsp">
<input type="submit" value="뒤로"></form>
<table width='600' border='1'>
<tr>
	<th>일자</th><th>메뉴명</th><th>가격</th><th>조식/중식</th><th>종류</th><th>매진</th>
</tr>
<%
try{
	Class.forName("org.gjt.mm.mysql.Driver");
	conn = DriverManager.getConnection(url, uid, pwd);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>"+rs.getString("DATE")+"</td>");
		out.println("<td>"+rs.getString("MN_NAME")+"</td>");
		out.println("<td>"+rs.getString("MN_PRICE")+"</td>");
		out.println("<td>"+rs.getString("CHAIN")+"</td>");
		out.println("<td>"+rs.getString("MN_TYPE")+"</td>");
		out.println("<td>"+"</td>");
		out.println("</tr>");
	}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</table>
</body>
</html>