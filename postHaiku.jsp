<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/soueikai/main/">詠む</a>
<a href="https://kigosai.sub.jp/001/">歳時記</a>

<form action="/soueikai/Main" method="post">
俳句:<input type="text" name="text"><br>
季語<input type="text" name="kigo"><br>
季節:<input type="text" name="season"><br>
発表日:<input type="text" name="date"><br>
<input type="submit" value="詠む">
</form>
</body>
</html>