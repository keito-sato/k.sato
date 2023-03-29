<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
<%
//セッションスコープからユーザー情報を取得
User loginUser = (User)session.getAttribute("User");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
</head>
<body>
<h1 align="center">想永会ログイン</h1>
<% if(loginUser != null) { %>
	<h2 align="center">ログインに成功しました<br>
	 ようこそ<%= loginUser.getName() %>さん<br>
	 <a href="/soueikai/Main">メイン画面へ</a></h2>
<% } else { %>
	<p align="center">ログインに失敗しました</p>
	<p align="center"><a href="/soueikai/">TOPへ</a></p>
<% } %>
</body>
</html>