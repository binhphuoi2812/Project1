<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>WelcomeServlet</h1>
	<%
		int x = 10;
		int y = 10;
		int tong = x + y;
	%>

	<h2><%=tong%></h2>
	<%
		if (tong > 100) {
	%>
	<p>Hello 100</p>
	<%
		} else if (tong < 100) {
	%>
	<p>Hello</p>
	<%
		}
	%>
</body>
</html>