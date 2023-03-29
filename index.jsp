<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
</head>
<body>
<h1 align="center">想永会へようこそ</h1>
<form action="/soueikai/Login" method="post">
<p align="center">ユーザー名:<input type="text" name="name"></p>
<p align="center">パスワード:<input type="password" name="pass"></p>
<p align="center"><input type="submit" value="ログイン"></p>
</form>
<p align="center"><a href="/soueikai/Register">アカウント登録</a></p>
</body>
</html>