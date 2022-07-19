<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>국어: <%out.println(request.getParameter("kor"));%></li>
		<li>영어: <%out.println(request.getParameter("eng"));%></li>
		<li>수학: <%out.println(request.getParameter("math"));%></li>
		<li>과학: <%out.println(request.getParameter("sci"));%></li>
		<li>총점: <%out.println(request.getAttribute("total"));%></li>
		<li>평균: <%out.println(request.getAttribute("avg")); %></li>
	</ul>
</body>
</html>