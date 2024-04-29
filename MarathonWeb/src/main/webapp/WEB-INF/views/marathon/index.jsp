<%@page import="com.webteam.marathon.dto.Marathon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
<h1>마라톤 테스트용 조회</h1>
<p>마라톤 아이디와 이름이 뜹니다
<table>
<tr>
	<th>marathon_id</th>
	<th>marathon_name</th>
</tr>
<c:forEach var="marathon" items="${marathonList}">
<tr>
	<td>${marathon.marathonId}</td>
	<td>${marathon.marathonName}</td>
</tr>
</c:forEach>
</table>

${message}

</body>
</html>