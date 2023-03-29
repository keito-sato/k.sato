<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
</head>
<body>
<p align="center"><a href="/soueikai/Main">メインへ</a></p>
<form action="/soueikai/Register" method="post">
<p align="center">ユーザー名:<input type="text" name="name"></p>
<p align="center">パスワード:<input type="password" name="pass1"></p>
<p align="center">パスワード確認用：<input type="password" name="pass2"></p>
<p align="center"><input type="submit" value="アカウント登録"></p>
</form>
</body>
</html>