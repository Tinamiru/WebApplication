<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>일반 for문 jsp</h1>
	<%
		for (int i = 1; i < 10 + 1; i++) {
			out.print(i + "<br>");
		}
	%>
	<hr />
	<h1>일반 for문 jstl</h1>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }<br>
	</c:forEach>

	<hr />
	<h1>집합 for문 jsp</h1>
	<%
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i : data) {
			out.print(i + "<br>");
		}
	%>
	<hr />
	<h1>집합 for문 jstl</h1>
	<c:set var="data" value="<%=data%>" />
	<c:forEach var="i" items="${data }">
		${i }<br>
	</c:forEach>
</body>
</html>