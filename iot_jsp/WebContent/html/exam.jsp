<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String param = request.getParameter("param");
	Gson gs = new Gson();
 	HashMap hm = gs.fromJson(param, HashMap.class);
 	System.out.println(hm);
 	out.println(gs.toJson(hm));

%>