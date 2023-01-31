<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>想永会</title>
</head>
<body>
<a href="/soueikai/postHaiku/">詠む</a>
<a href="/soueikai/searchHaiku/">検索</a>
<a href="/soueikai/photo/">お題写真館</a>
<a href="/soueikai/myPage/">マイページ</a>

<c:forEach var="haiku" items="${haikuList}" >
	<p><c:out value="${haiku.text}" /><br>
		<c:out value="${haiku.writer}" /></p>
</c:forEach>
</body>
</html>