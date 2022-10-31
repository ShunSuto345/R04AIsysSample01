<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sentimentを使うサイト</title>
</head>

<body>
<h1>Sentimentを使うサイト</h1>

<h3>文章を入力してください</h3>
<form method="POST" action="./sentimentresult">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>