<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Haiku" %>
<%
//リクエストスコープからユーザー情報を取得
Haiku haiku = (Haiku)request.getAttribute("haiku");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
</head>
<body>
<% if(haiku != null) { %>
	<p align="center">俳句を投稿しました</p>
	<p align="center"><%= haiku.getText()%></p>
	<p align="center"><%= haiku.getWriter()%></p>
	<p align="center"><a href="/soueikai/Main">メイン画面へ</a></p>

<% } else { %>
	<p align="center">入力されていない項目があります。</p>
	<p align="center"><a href="/docoTsubu/PostHaiku">投稿画面へ</a></p>
<% } %>
</body>
</html>