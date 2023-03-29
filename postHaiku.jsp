<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
</head>
<body>
<h1 align="center"><a href="/soueikai/Main">メインへ</a></h1>
<h2 align="center"><a href="https://kigosai.sub.jp/001/">歳時記</a></h2>

<form action="/soueikai/PostHaiku" method="post">
<p align="center">俳句:<input type="text" name="text"></p>
<p align="center">季語<input type="text" name="kigo"></p>
<p align="center">季節:<input type="text" name="season"></p>
<p align="center">写真：<input type="text" name="photoId"></p>
<p align="center"><input type="submit" value="詠む"></p>
</form>
</body>
</html>