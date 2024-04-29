<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청 취소</title>
<link rel="stylesheet" href="../css/deletebox.css"/>
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
<div class="container_deletebox">
<h2>마라톤 접수 취소</h2>
<div class="form-container">
<form action="./delete" method="post">
  접수 번호  <input type="text" name="rcpnum" required><p>
  비밀번호  <input type="password" name="userpassword" required><p>
  <input type="button" value="접수 취소" onclick="return confirmDelete(this.form)">
</form>
<script>
function confirmDelete(form){
	var rcpnum = form.rcpnum.value.trim();
	var userpassword = form.userpassword.value.trim();
	if(rcpnum === '' || userpassword === ''){
		alert("접수 번호와 비밀번호를 모두 입력해주세요.");
		return false;
	}
	if(confirm("정말 삭제하시겠습니까?")){
	   form.submit();
	   return true;
	}else{
	   return false;
	}
}
</script>
</div>
</div>
</body>
</html>

