<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
<style>
	p{
	display: table-cell;
  width: 100px;
  height: 300px;
  writing-mode: vertical-rl;
  background-color: #acf2f4;
  vertical-align: middle;
  text-align: center;
	}
	h1{
	text-align: center;
	}
</style>
</head>
<body>
<h1>
	<a href="/soueikai/PostHaiku">詠む</a>
	<a href="/soueikai/searchHaiku/">検索</a>
	<a href="/soueikai/photo/">お題写真館</a>
	<a href="/soueikai/myPage/">マイページ</a>
	<a href="/soueikai/Logout">ログアウト</a>
</h1>
<h2>直近句</h2>
<c:forEach var="haiku" items="${haikuList}" >
	<p>
		<c:out value="${haiku.text}" /><br>
		<c:out value="${haiku.writer}" /><br>
	</p>
</c:forEach>

</body>
</html>