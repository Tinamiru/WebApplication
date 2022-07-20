var out = document.getElementById('out');
var numbers = "";
var param = "";

function del() {
	if (document.getElementById('show').value != "") {
		numbers = numbers.substring(0, numbers.length - 1);
	}
	document.getElementById('show').value = numbers;
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
	if (document.getElementById('opper').value == "") {
		numbers = document.getElementById('show').value;
		document.getElementById('first').value = numbers;
		document.getElementById('opper').value = oper;
		document.getElementById('out').value = numbers + oper;
		numbers = "";
	}
}

var myform = document.getElementById("form");
document.getElementById("send").addEventListener("click", function() {
	if (numbers != "") {
		if (document.getElementById('opper').value != "") {
			document.getElementById('second').value = numbers;
			myform.submit();
		}
	}
});
