<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
<style>
* {
	
}

.col-md-1, .zero {
	text-align: center;
	fontSize: 1.5em;
	background-color: grey;
	width: 17%;
	margin: 10px;
	padding-top: 10px;
	padding-bottom: 10px;
	float: left;
}

.op {
	background-color: orange;
}

.wrapper {
	border: 5px solid black;
	width: 300px;
	height: 400px;
	padding: 20px;
}

input {
	width: 100%;
	height: 40px;
	text-align: right;
}

.row {
	width: 100%;
}
</style>
</head>
<body>
	<h1>계산기</h1>
	<div>

		<div class="wrapper">
			<div class="row">
				<input type="text" id="out" value="" />
			</div>
			<div class="row">
				<input type="text" id="show"
					value="<%out.print(request.getAttribute("result"));%>" />
			</div>
			<br>
			<div class="row">
				<div class="col-md-1" onclick="getNum('7')">7</div>
				<div class="col-md-1" onclick="getNum('8')">8</div>
				<div class="col-md-1" onclick="getNum('9')">9</div>
				<div class="col-md-1 op" onclick="getOper('*')">*</div>
			</div>
			<div class="row">
				<div class="col-md-1" onclick="getNum('4')">4</div>
				<div class="col-md-1" onclick="getNum('5')">5</div>
				<div class="col-md-1" onclick="getNum('6')">6</div>
				<div class="col-md-1 op" onclick="getOper('-')">-</div>
			</div>
			<div class="row">
				<div class="col-md-1" onclick="getNum('1')">1</div>
				<div class="col-md-1" onclick="getNum('2')">2</div>
				<div class="col-md-1" onclick="getNum('3')">3</div>
				<div class="col-md-1 op" onclick="getOper('/')">/</div>
			</div>
			<div class="row">
				<div class="col-md-1" onclick="getNum('0')">0</div>
				<div class="col-md-1" onclick="getDot('.')">.</div>
				<div class="col-md-1" onclick="send()" id="send">=</div>
				<div class="col-md-1 op" onclick="getOper('+')">+</div>
			</div>
		</div>
		<form action="/Calculator/calculator" method="post" id="form">
			<input type="hidden" name="firstNum" id="first" /> <input type="hidden"
				name="operator" id="opper"> <input type="hidden" name="secondNum"
				id="second" />
		</form>
	</div>
	<script>
		var out = document.getElementById('out');
		var numbers = "";
		var param = "";

		function send() {
			document.getElementById('second').value = numbers;
			document.getElemetById('form').submit();
		}
		function getNum(num) {
			if (document.getElementById('show').value == '0') {
				numbers = num;
			} else {
				numbers += num;
			}
			document.getElementById('show').value = numbers;
		}
		function getOper(oper) {
			document.getElementById('first').value = numbers;
			document.getElementById('opper').value = oper;
			document.getElementById('out').value = numbers + oper;
			numbers = "";
		}

		var myform = document.getElementById("form");
		document.getElementById("send").addEventListener("click", function() {
			myform.submit();
		});
	</script>
</body>
</html>