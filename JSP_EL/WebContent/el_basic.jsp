<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	pageContext.setAttribute("message", "pageContext message");
	request.setAttribute("message", "request message");
	session.setAttribute("message", "session message");
	application.setAttribute("message", "application message");

	pageContext.setAttribute("num", 1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Attribute message : ${sessionScope.message}</h1>
	<h1>Parameter message : ${param.message}</h1>
	
	<ul>//연산자
		<li> 산술연산 : ${num+1}<li>	
		<li> 문자열 더하기 : ${num}${message}<li>	
		<li> 비교연산 : ${num ge 3}<li>	
		<li> 유무연산 : ${empty num}, ${not empty requestScope.member }<li>	
	</ul>


</body>
</html>