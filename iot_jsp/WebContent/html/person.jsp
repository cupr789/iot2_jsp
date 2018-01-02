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
var cnt =1;
function callback(res){
	var obj  = JSON.parse(res);
	document.getElementById("result_div").innerHTML += "[no :"+obj.no+", id : "+obj.id+", name : "+obj.name+", age : "+obj.age+", gender : "+obj.gender+", address : "+obj.address+"]";	
}

function insertValue(){

	var person = {no:"",id:"",name:"",age:"",gender:"",address:""};
	for(var key in person){
		if(key=="no"){
			person[key]=cnt;
		}
		else{
			var elObj = document.getElementById(key);
			person[key] = elObj.value;
		}
	}
	var data = "param="+encodeURIComponent(JSON.stringify(person));
	
	$.ajax({
		url : "./exam.jsp",
		data : data,
		type : "get",
		success : callback,
		error : function(xhr,status,error){
			alert(xhr.responseText);
		}
		
	})
	cnt++;
}

</script>
<body>
아이디: <input type="text" id="id"><br>
이름: <input type="text" id="name"><br>
나이 : <input type="text" id="age"><br>
성별 : <input type="text" id="gender"><br>
주소 : <input type="text" id="address"><br>
<input type="button" id="insert" value="입력" onclick="insertValue()">
<div id="result_div"></div>
</body>
</html>