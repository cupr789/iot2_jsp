<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
var car = {
		wheels:4,
		engines:1,
		seats:5		
}

function load(){
document.getElementById("result_div").innerHTML += "자동차 휠 개수 : "+car.wheels+"<br> 엔진갯수 : "+car.engines+"<br> 시트갯수 : "+ car.seats;
}
//carNM.innerHTML += "자동차 휠 개수 : "+car.wheels+"<br> 엔진갯수 : "+car.engines+"<br> 시트갯수 : "+ car.seats;
//위에 선언된 car변수를 사용하여 result_div에 자동차 휠 갯수 : 엔진 갯수: 시트개수: 라는 html을 입력해주시기바랍니다.

</script>
<body onload="load()">
<div id="result_div"></div>
</body>
</html>