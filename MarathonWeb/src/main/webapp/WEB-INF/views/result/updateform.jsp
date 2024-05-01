<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ModuRunner</title>
<jsp:include page="../marathon/nav.jsp" />
</head>
<body>
<section class="py-5">
<div class="container px-4 px-lg-5 my-5">
<div class="row gx-4 gx-lg-5 align-items-center">
<div class="col-lg-8 col-md-10 mx-auto">
	<h1>접수내역 수정</h1>
	<form action="./update" method="post">
		<div class="row mb-3">																						
		<label for="user_name" class="col-sm-3 col-form-label">대회명</label>
		<div class="col-sm-9">
		<input type="text" class="form-control"name="marathonName" value="${newReceipt.marathonName}" disabled>
		</div>
		</div>	

		<div class="row mb-3">
		<label for="receipt_num"
		class="col-sm-3 col-form-label">대회날짜</label>
		<div class="col-sm-9">
		<input type="text" class="form-control" name="marathonDate" value="${newReceipt.marathonDate}" disabled>
			</div>
		</div>


		<div class="row mb-3">
		<label for="user_email"
		class="col-sm-3 col-form-label">접수번호</label>
		<div class="col-sm-9">
		<input type="text" class="form-control" name="receiptNum" value="${newReceipt.receiptNum}" disabled>
			</div>
		</div>

		<div class="row mb-3">
		<label for="phone_num"class="col-sm-3 col-form-label">이름</label>
		<div class="col-sm-9">
		<input type="text" class="form-control" name="userName" value="${newReceipt.userName}">
		</div>
		</div>
		
		<div class="row mb-3">
		<label for="user_password" class="col-sm-3 col-form-label">이메일</label>
		<div class="col-sm-9">
		<input type="text" class="form-control" name="userEmail" value="${newReceipt.userEmail}">
		</div>
		</div>
		
		<div class="row mb-3">
		<label for="user_add" class="col-sm-3 col-form-label">전화번호</label>
		<div class="col-sm-9">
		<input type="text" class="form-control" name="phoneNum" value="${newReceipt.phoneNum}">
		</div>
		</div>

		<div class="row mb-3">
		<label for="user_birth" class="col-sm-3 col-form-label">집주소</label>
		<div class="col-sm-9">
		<input type="text" class="form-control" name="userAdd" value="${newReceipt.userAdd}">
			</div>
		</div>
		
		<div class="row mb-3">
		<label for="user_password" class="col-sm-3 col-form-label">생년월일</label>
		<div class="col-sm-9">
		<input type="date" class="form-control" name="userBirth" value="${newReceipt.userBirth}">
		</div>
		</div>

		<input type="submit" class="btn btn-success" value="수정">
		<input type="reset" class="btn btn-outline-success" value="취소">
	</form>
</div>
</div>
</div>
</section>
</body>
</html>