<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접수내역 수정</title>
</head>
<body>
	<h1>접수내역 수정</h1>
	<form action="./update" method="post">
		<table border="1">
			<tr>
				<th>마라톤 대회 이름</th>
				<td><input type="text" name="marathonName" value="${receiptHistory.marathonName}"></td>
			</tr>
			<tr>
				<th>대회 날짜</th>
				<td><input type="text" name="marathonDate" value="${receiptHistory.marathonDate}"></td>
			</tr>
			<tr>
				<th>접수 번호</th>
				<td><input type="text" name="receiptNum" value="${receiptHistory.receiptNum}"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="userName" value="${receiptHistory.userName}"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phoneNum" value="${receiptHistory.phoneNum}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="userAdd" value="${receiptHistory.userAdd}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="userEmail" value="${receiptHistory.userEmail}"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="userBirth" value="${receiptHistory.userBirth}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>