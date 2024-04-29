<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접수내역 수정</title>
<link rel="stylesheet" href="../css/deletebox.css"/>
</head>
<body>
	<h1>접수내역 수정</h1>
	<form action="./update" method="post">
		<table border="1">
			<tr>
				<th>마라톤 대회 이름</th>
				<td><input type="text" name="marathonName" value="${newReceipt.marathonName}" readonly></td>
			</tr>
			<tr>
				<th>대회 날짜</th>
				<td><input type="text" name="marathonDate" value="${newReceipt.marathonDate}" readonly></td>
			</tr>
			<tr>
				<th>접수 번호</th>
				<td><input type="text" name="receiptNum" value="${newReceipt.receiptNum}" readonly></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="userName" value="${newReceipt.userName}" required></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phoneNum" value="${newReceipt.phoneNum}" required></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="userAdd" value="${newReceipt.userAdd}" required></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="userEmail" value="${newReceipt.userEmail}" required></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="userBirth" value="${newReceipt.userBirth}" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<script type=text/javascript>
	window.onload = function() {
	    var message = '${message}';
	    if (message) {
	        alert(message);
	    }
	}
	</script>
</body>
</html>