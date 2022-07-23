<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<table id="calTable" border="2px">
		</table>
		<div id="toast"></div>
	</div>
	<div>
		<form action="calculator" method="post" id="form">
			<input type="hidden" name="firstNum" id="first" value="${result}" />
			<input type="hidden" name="operator" id="opper" value="${operator}" />
			<input type="hidden" name="secondNum" id="second" /> <input
				type="hidden" name="secondOpper" id="secondOpper"
				value="${secondOpper}" />
		</form>
	</div>
	<script>
		var dotAlertFlag = ${alertFlag}; 	
		// 계산 가능 허용치 이상의 경고알람 설정
		window.onload = function(){
			if(document.getElementById("show").value + 1 > 9223372036854775807){
				toast("정수 9223372036854775807 이하만 표현 가능합니다.")
				document.getElementById("out").value = ""
				document.getElementById("show").value = ""
			} else if (dotAlertFlag) {
				toast("소수점 6자리 이상만 표현 가능합니다.");
				dotAlertFlag = false;
			}
		}
		
		
		// 테이블내의 UI 생성
		let value = ["😍","AC", "DEL", "/", 
					 "7", "8", "9", "*",
					 "4", "5", "6", "-",
					 "1", "2", "3", "+",
					 "0", ".", "🥰", "="];
					 
		let clazz = ["col-md-1 num", "col-md-1 op"];
		
		let script ="";
		script += `<tr class="row">
					<td colspan="4"><input class="inputText" id="out" value="${formula}" readonly/></td>
				   	</tr>
					<tr class="row">
					<td colspan="4"><input class="inputText" id="show" value="${result}" readonly/></td>
					</tr>`;
					
		let cnt = 0;
		
		for(let i = 0; i < 5; i++){
			script += "<tr class='row'>";
			for(let j = 0; j < 4; j++){
				script += "<td>";
				if(j == 3){
					script += "<input type='button' class='" + clazz[1] + "' value='" + value[cnt] + "'/>";						
				}else{
					script += "<input type='button' class='" + clazz[0] + "' value='" + value[cnt] + "'/>";						
				}
				cnt++
				script += "</td>";
			}
		}
		document.getElementById("calTable").innerHTML = script;
		
		// num클래스 클릭 이벤트
		$(".num").on('click', (e) => {
			key = e.target.value;
				// key 파라미터가 숫자가 아닐경우
				if (isNaN(key)) {
					switch (key) {
						case "AC":
							$(location).attr('href', '/Calculator/calculator');
							break;
						case ".":
							getDot(key)
							break;
						case "DEL":
							del()
							break;
						case "😍":
						case "🥰":
							toast("😍😍완전소중~🥰🥰")
							break;
					}
				// key 파라미터가 숫자일 경우
				}else{
					getNum(key);
				}
			document.getElementById('secondOpper').value = "";
		});
			

		
		$(".op").on('click', (e) => {
			key = e.target.value;
			out = document.getElementById('out');
			if(key == "="){
				submits();
			}else if (document.getElementById('secondOpper').value == ""){
				getOper(key);
			}else{
				document.getElementById('opper').value = key;
				outValue = out.value.substring(0, out.value.length - 1);
				outValue += key;
				document.getElementById('out').value = outValue;
			}
		
		});
		
		// 입력 숫자를 담을 변수
		var numbers = "";
		// dot 입력 플래그 스위치
		var dotFlag = true;
			
		// 연산자 입력시
		function getOper(key) {
			// 연산자 이전의 숫자를 담은 변수
			numbers = document.getElementById('show').value;
			if(numbers != ""){
				if(document.getElementById('opper').value == ""){
					document.getElementById('first').value = numbers;
					document.getElementById('opper').value = key;
					document.getElementById('out').value = numbers + key;
					numbers = "";
					document.getElementById('show').value = numbers;
				}else{
					document.getElementById('secondOpper').value = key;
					submits();
				}
			dotFlag = true;
			}
		}
		
		// dot입력시
		function getDot(dot) {
			if (document.getElementById('show').value != '') {
				if (dotFlag) {
					numbers += dot;
					dotFlag = false;
				}
			}
			document.getElementById('show').value = numbers;
		}
		
		// del키가 입력시
		function del() {
			if (document.getElementById('show').value != "") {
				if (numbers.substr(-1) == ".") {
					dotFlag = true;
				}
				numbers = numbers.substring(0, numbers.length - 1);
			}
			document.getElementById('show').value = numbers;
		}

		// 숫자가 입력시
		function getNum(num) {
			if (document.getElementById('show').value == '0') {
				numbers = num
			} else {
				numbers += num;
			}
			document.getElementById('show').value = numbers;
		}
		
		// form 태그의 값들을 post방식으로 서블렛에 전송
		function submits() {
			let myform = document.getElementById("form");
			if (numbers != "") {
				if (document.getElementById('opper').value != "") {
					document.getElementById('second').value = numbers;
					myform.submit();
				}
			}
		}
		
		let removeToast;

		function toast(string) {
		    const toast = document.getElementById("toast");

		    toast.classList.contains("reveal") ?
		        (clearTimeout(removeToast), removeToast = setTimeout(function () {
		            document.getElementById("toast").classList.remove("reveal")
		        }, 1000)) :
		        removeToast = setTimeout(function () {
		            document.getElementById("toast").classList.remove("reveal")
		        }, 1000)
		    toast.classList.add("reveal"),
		        toast.innerText = string
		}
		</script>
</body>
</html>