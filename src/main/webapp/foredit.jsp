<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = (int) request.getAttribute("id");
	String uname = (String) request.getAttribute("uname");
	String dept = (String) request.getAttribute("dept");
	%>
	<form action="Confirm" method="post">
		<input type="text" name="uname" value=<%=uname%> /> 
		<input type="text" name="dept" value=<%=dept%> /> 
		<input type="hidden" name="id" value=<%= id %> />
		<input type="submit" value="Edit" />
	</form>
</body>
</html>