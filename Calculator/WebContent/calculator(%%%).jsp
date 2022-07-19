<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	결과값 =
	<%out.print(request.getAttribute("result"));%>
	<script>
		param += "firstNum=" + $("첫번째 숫자").val();
		param += "&operator=" + $("연산자").val();
		param += "&secondNum=" + $("두번째숫자").val();


	</script>
</body>
</html>