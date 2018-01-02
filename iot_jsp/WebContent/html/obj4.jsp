<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.2.1.js"></script>
<script>
/* function checkValue(){
	//id pwd name 라는 변수를 가지고있는 var user를 선언하여 화면에있는 각 id의 값들과 일치하는 element의값을 저장 console.log로 출력하는 예제를 작성해주세요.
	var user = {id:document.getElementById("id"),pwd:document.getElementById("pwd"),name:document.getElementById("name")};
	
	alert(user.id.value);
	alert(user.pwd.value);
	alert(user.name.value);
	document.getElementById("outResult").innerHTML += "ID : "+user.id.value+"<br> PWD : "+user.pwd.value+"<br> NAME : "+user.name.value;
}


function initss(){
	var rrt = document.getElementsByTagName("input");
	for(var aa of rrt){
		if(aa.type != "button"){
			if(aa.onfocus()=="true"){
				aa.onclick = blank(aa);
			}
		}
	}
}

function blank(para){
	var aaa= para;
	aaa.value="";
} */


/*
 * person.jsp
 	no :  , id:  , name : ,  age : ,gender :  , address : ;
 	리턴해준다.
 	
 	exam.jsp
 	
 	person.jsp에서 넘겨준 저위의 구조를 가지고 파싱을 해서 추가를 해주면 되는데 no버튼은 클릭할때마다 ++;
 	
 	
 */

function callback(res){
	var obj = JSON.parse(res);
	alert(obj.msg);
}

function checkValue(){
	var user = {id:"",pwd:"",name:""};
	for(var key in user){
		var elObj = document.getElementById(key);
		user[key] = elObj.value;
	}
	var data = "param="+encodeURIComponent(JSON.stringify(user));
	$.ajax({
		url : "./test.jsp",
		data : data,
		type:"get",
		success : callback,
		error: function(xhr,status,error){
			$("#result_div").html(xhr.responseText);
		}
	})
}
</script>

<body>
<input type="text" id="id" value="id 입력" >
<input type="text" id="pwd" value="pwd 입력" >
<input type="text" id="name" value="name입력" >
<input type="button" value="값 확인" onclick="checkValue()">
<h4 id="result_div"></h4>
</body>
</html>