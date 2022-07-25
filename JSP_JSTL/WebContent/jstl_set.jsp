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
	<c:set var="k" value="123" scope="page" />
	<c:set var="k" value="abc" scope="request" />
	<h1>${k}</h1>
	<h1>${requestScope.k}</h1>

</body>
</html>