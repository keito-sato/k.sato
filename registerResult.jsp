<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//セッションスコープからユーザー情報を取得
User user = (User)session.getAttribute("User");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>想永会</title>
</head>

<body>
<h1 align="center">アカウント登録</h1>
	<% if(user != null) { %>
		<p align="center">アカウント登録成功しました</p>
		<p align="center">ようこそ<%= user.getName() %>さん</p>
		<p align="center"><a href="/soueikai/Main">俳句の世界へGo!!</a></p>
	<% } else { %>
		<p align="center">アカウント登録失敗</p>
		<p align="center"><a href="/soueikai/">TOPへ</a></p>
	<% } %>
</body>
</html>