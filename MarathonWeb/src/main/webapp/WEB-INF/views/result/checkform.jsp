<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ModuRunner</title>
<jsp:include page="../marathon/nav.jsp" />
<link rel="stylesheet" href="../css/deletebox.css"/>
</head>
<body>
<div class="container_deletebox">

<div class="form-container">
<% if ("update".equals(request.getParameter("param"))) { %>
	<h2>Update Form</h2>
	<form action="./update" method="post">
	  접수 번호  <input type="text" name="rcpnum" required><p>
	  비밀번호  <input type="password" name="userpassword" required><p>
	  <input type="button" value="확인" onclick="return confirmUpdate(this.form)">
	</form>
	<!-- 알림창을 표시하는 스크립트 -->
<% if (request.getAttribute("message") != null) { %>
    <script>
        alert("${message}");
    </script>
<% } %>
	<script>
	function confirmUpdate(form){
		var rcpnum = form.rcpnum.value.trim();
		var userpassword = form.userpassword.value.trim();
		if(rcpnum === '' || userpassword === ''){
				alert("접수 번호와 비밀번호를 모두 입력해주세요.");
				return false;
			}
		if(confirm("수정하시겠습니까?")){
			window.location.href = "./update/" + rcpnum + "/" + userpassword;
		   return true;
		}else{
		   return false;
		}
	}
	</script>
 <% } else if ("delete".equals(request.getParameter("param"))) { %>
	
	<h2>Delete Form</h2>
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
 <% } %>
</div>
</div>

</body>
</html>