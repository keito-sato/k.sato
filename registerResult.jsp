<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//セッションスコープからユーザー情報を取得
User user = (User)session.getAttribute("User");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
</head>
<body>
<h1>アカウント登録</h1>
<% if(user != null) { %>
	<p>アカウント登録成功しました</p>
	<p>ようこそ<%= user.getName() %>さん</p>
	<a href="/soueikai/Main">俳句の世界へGo!!</a>
<% } else { %>
	<p>アカウント登録失敗</p>
	<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>
	<a href="/soueikai/">TOPへ</a>
<% } %>
</body>
</html>