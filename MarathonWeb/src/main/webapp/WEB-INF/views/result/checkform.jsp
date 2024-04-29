<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청 수정</title>
<link rel="stylesheet" href="../css/deletebox.css"/>
</head>
<body>
<div class="container_deletebox">
<h2>마라톤 접수 수정</h2>
<div class="form-container">
<form action="./update" method="post">
  접수 번호  <input type="text" name="rcpnum" required><p>
  비밀번호  <input type="password" name="userpassword" required><p>
  <input type="button" value="확인" onclick="return confirmUpdate(this.form)">
</form>
<script>
function confirmUpdate(form){
	var rcpnum = form.rcpnum.value.trim();
	var userpassword = form.userpassword.value.trim();
	if(rcpnum === '' || userpassword === ''){
		alert("접수 번호와 비밀번호를 모두 입력해주세요.");
		return false;
	}
	if(confirm("정말 삭제하시겠습니까?")){
	   form.submit();
	   return handleSubmit('update');
	}else{
	   return false;
	}
}
</script>
<!-- todo: add a form for the user to enter the new information -->
</div>
</div>
</body>
</body>
</html>