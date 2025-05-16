<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String uname = (String) session.getAttribute("uname");
	String dept = (String) session.getAttribute("dept");
	%>
	<p>
		Username:
		<%=uname%></p>
	<p>
		Department:
		<%=dept%></p>
</body>
</html>