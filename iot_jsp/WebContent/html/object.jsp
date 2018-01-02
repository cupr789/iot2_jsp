<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var objExam = function(){
	this.a = 3;
	this.callback = function(){
		alert(this.a);
	}
}
var AjaxObj = function(params){
	this.url = params.url;
	this.val = function(){
		alert("유효성검사 함수");
	}
	this.send= function(){
		this.oe = new objExam();
		this.oe.callback();
		alert(params.url + "로 ajax 전송 함수");
		this.callback("지금넘긴 변수");
		//alert(val);
		alert(this);
	}
	this.callback=params.func;
}

var func = function(res){
	alert(res);
}
 var ao = new AjaxObj({url : './test.jsp',func:func});
 alert(ao.val+"   ggggg");
 ao.send();
 
 var oe = new objExam();
 //ao.callback();
 
</script>
</body>
</html>