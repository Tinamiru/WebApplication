<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("message", "pageContext message");
	request.setAttribute("message", "request message");
	session.setAttribute("message", "session message");
	application.setAttribute("message", "application message");

	pageContext.setAttribute("num", 1);

	List<String> list = new ArrayList<String>();
	list.add("123");
	pageContext.setAttribute("list", list);
	
	MemberVO member = new MemberVO();
	member.setId("mimi");
	member.setPwd("mimi");
	pageContext.setAttribute("member", member);

	Map<String, String> map = new HashMap<String, String>();
	map.put("key", "12345");
	pageContext.setAttribute("map", map);
	
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

	<ul>
		//연산자
		<li>산술연산 : ${num+1}
		<li>
		<li>문자열 더하기 : ${num}${message}
		<li>
		<li>비교연산 : ${num ge 3}
		<li>
		<li>유무연산 : ${empty num}, ${not empty requestScope.member }
		<li>
	</ul>
	<ul>
		//메소드 호출
		<li>${str}</li>
		<%-- out.println(pageContext.getAttribute("str")); --%>
		<li>일반메소드 호출 : ${str.split(",")[2]}</li>
		<li>id   : ${member.id}</li>
		<li>pw   : ${member.pwd}</li>
		<li>list : ${list[0] }</li>
		<li>map  : ${map.key }</li>
	</ul>

</body>
</html>