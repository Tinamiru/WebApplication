<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Date today = new Date();
		out.print(today);
		out.print("<br/>");
		String todayStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(today);
		out.print(todayStr);
	%>
	<hr />
	<c:set var="today" value="<%=today%>" />
	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${today}" />

</body>
</html>