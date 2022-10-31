<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Object o =request.getAttribute("message1");
	Object a =request.getAttribute("message2");
	Object b =request.getAttribute("message3");
	Object s =request.getAttribute("string");
	float float1 = (float)o;
	float float2 = (float)a;
	float float3 = (float)b;
	String String1 =(String)s;
	%>

<body>
<H1>DetectLanguage</H1>
<H3>文章：<%=String1%></H3>
<H3>結果<br>positive:<%=float1%><br>neutral:<%=float2%><br>negative:<%=float3%></H3>
</body>
</html>