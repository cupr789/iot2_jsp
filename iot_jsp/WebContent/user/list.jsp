<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.iot.common.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>
</head>
<body>

<table border="1">
<tr>
<th>번호</th>
<th>이름</th>
<th>아이디</th>
<th>비밀번호</th>
<th>수업번호</th>
<th>가입날짜시간</th>
<th>주소</th>
</tr>
<%
DBCon dbcon = new DBCon();
String sql = "select ui.uino,uiname,uiid,uipwd,ci.ciname,uiregdate,address  from user_info ui,class_info ci where ci.cino=ui.cino";
ArrayList<HashMap<String,Object>> userList = dbcon.executeQuery(sql,null);

for(HashMap<String,Object> hm: userList){
	String str = "<tr>";
	str+= "<td>"+hm.get("uino")+"</td>";
	str+= "<td>"+hm.get("uiname")+"</td>";
	str+= "<td>"+hm.get("uiid")+"</td>";
	str+= "<td>"+hm.get("uipwd")+"</td>";
	str+= "<td>"+hm.get("ciname")+"</td>";
	str+= "<td>"+hm.get("uiregdate")+"</td>";
	str+= "<td>"+hm.get("address")+"</td>";
	str+= "</tr>";
	out.println(str);
}

 sql = "select * from class_info";
 ArrayList<HashMap<String,Object>> classList = dbcon.executeQuery(sql,null);
 String str ="<table border="+"1"+"><br>";
 for(HashMap<String,Object> hm: classList){
		str += "<tr>";
		str+= "<td>"+hm.get("cino")+"</td>";
		str+= "<td>"+hm.get("ciname")+"</td>";
		str+= "<td>"+hm.get("cidesc")+"</td>";
		str+= "</tr><br>";
		
	}
 str += "</table>";
 out.println(str);

%>
</table>
</body>
</html>