<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
---- Include the above in your HEAD tag --------
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->

<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<jsp:include page="../marathon/nav.jsp" />

	<!-- Fonts -->
	<link rel="dns-prefetch" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
		rel="stylesheet" type="text/css">

	<link rel="icon" href="Favicon.png">
	<title>Insert Form</title>
</head>

<body>
<script>
window.onload = function() {
    var message = '${message}';
    if (message) {
        alert(message);
    }
}
</script>
<section class="py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="row gx-4 gx-lg-5 align-items-center">

			<div class="col-md-6">
				<img class="card-img-top mb-5 mb-md-0" 
				src="${marathon.marathonImg}" class="img-fluid" alt="...">
			</div>

			<div class="col-md-6">
				<div class=" mb-3">
				<h2>${marathon.marathonName}</h2>
				</div>

				<form name="my-form"  action="/receipt/insert" method="post" accept-charset="utf-8">


				<%-- <select class="Marathon_name" aria-label="Disabled select example">
				<c:forEach var="marathon" items="${marathonList}">
					<option value="${marathon.marathonId}">${marathon.marathonName}</option>"
					</c:forEach> 
				</select> --%>
				<div class="row mb-3">
				<label for="Marathon_id" class="col-sm-3 col-form-label"></label>
				<div class="col-sm-9">
				<input type="hidden" class="form-control" name="marathonId" value="${marathon.marathonId}">
				</div>
				</div>

				<div class="row mb-3">																						
				<label for="user_name" class="col-sm-3 col-form-label">이름</label>
				<div class="col-sm-9">
				<input type="text" id="user_name" class="form-control"name="userName" required>
				</div>
				</div>	

				<!-- <div class="row mb-3">
				<label for="receipt_num"
				class="col-sm-3 col-form-label">접수번호</label>
				<div class="col-sm-9">
				<input type="text" id="receipt_num" class="form-control" name="receiptNum" required>
					</div>
				</div> -->


				<div class="row mb-3">
				<label for="user_email"
				class="col-sm-3 col-form-label">이메일</label>
				<div class="col-sm-9">
				<input type="text" id="user_email" class="form-control" name="userEmail" required>
					</div>
				</div>

				<div class="row mb-3">
				<label for="phone_num"class="col-sm-3 col-form-label">전화번호</label>
				<div class="col-sm-9">
				<input type="text" id="phoneNum" name="phoneNum" class="form-control">
				</div>
				</div>

				<div class="row mb-3">
				<label for="user_add" class="col-sm-3 col-form-label">집주소</label>
				<div class="col-sm-9">
				<input type="text" id="userAdd" name="userAdd" class="form-control">
				</div>
				</div>


				<div class="row mb-3">
				<label for="user_birth" class="col-sm-3 col-form-label">생년월일</label>
				<div class="col-sm-9">
				<input type="date" id="userBirth" class="form-control" name="userBirth">
					</div>
				</div>


				<div class="row mb-3">
				<label for="user_password" class="col-sm-3 col-form-label">비밀번호</label>
				<div class="col-sm-9">
				<input type="password" id="user_password" class="form-control" name="userPassword">
				</div>
				</div>
				
				<div class="row mb-3">
    			<label for="confirm_password" class="col-sm-3 col-form-label">비밀번호 확인</label>
    			<div class="col-sm-9">
        		<input type="password" id="confirm_password" class="form-control" name="confirmPassword" required>
    			</div>
				</div>

				<div class="mb-3">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
				      <label class="form-check-label" for="invalidCheck">
				   		포스터 내 내용을 모두 숙지하였습니다.
				      </label>
				      <div class="invalid-feedback">Please check this box to continue.</div>
				    </div>
				 </div>


				<button type="submit" class="btn btn-primary">제출</button>
				</form>
			</div>
		</div>
	</div>
</section>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $('form[name="my-form"]').submit(function(e) {
            if ($('#user_password').val() !== $('#confirm_password').val()) {
                alert("비밀번호가 일치하지 않습니다.");
                e.preventDefault(); // 폼 제출을 막습니다.
            }
        });
    });
</script>
</body>
</html>