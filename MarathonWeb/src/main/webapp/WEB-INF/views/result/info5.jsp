<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>신청 정보들 조회</title>
    <jsp:include page="../marathon/nav.jsp" />
</head>
<script>
function handleSubmit(actionType) {
    var checkboxes = document.querySelectorAll('input[name="receiptNum"]:checked');
    var passwordInput = document.getElementById('passwordInput');
    if (checkboxes.length === 0) {
        alert("적어도 하나의 아이템을 선택해주세요.");
        return;
    }
    
    var selectedValue = checkboxes[0].value;
    var passwordValue = passwordInput.value;
    
    var baseURL = "/result";
    var actionURL;
    if (actionType === 'update') {
        // 수정 페이지로 이동하는 URL에서 쿼리 스트링 대신 경로의 일부로 비밀번호 포함
        actionURL = baseURL + "/update/" + selectedValue + "/" + passwordValue;
    } else if (actionType === 'delete') {
        // 삭제 동작을 처리하는 URL에서도 비슷하게 적용할 수 있습니다.
        actionURL = baseURL + "/delete/" + selectedValue + "/" + passwordValue;
    } else {
        console.error("Unknown action type");
        return;
    }
    
    window.location.href = actionURL;
}
</script>
<script>
$(function(){
    $('#onDisplay').click(function(){
	    if($("#noneDiv").css("display") == "none"){
            $('#noneDiv').show();
    	}
    });
});
</script>
<body>
<!-- 	<h2>신청 정보들 조회</h2>
	<form action="/marathon/result/info5" method="post">
	<p>이름<input type="text" name="userName"></p>
	<p>전화번호<input type="text" name="phoneNum"></p><br>
	<input type="submit" value="검색">
	</form> -->

<body>
<section class="py-5">
<div class="container px-4 px-lg-5 my-5">
	<div class="row gx-4 gx-lg-5 align-items-center">
		<div class="col-lg-8 col-md-10 mx-auto">
			<h1>접수 조회</h1>
			신청시 작성하신 이름과 전화번호를 입력해주시면 해당 접수내역이 조회됩니다.<p>
			<form action="/result/info5" method="post">
				<div class="row mb-3">
					<label for="phone_num"class="col-sm-3 col-form-label">이름</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="userName">
					</div>
				</div>
				
				<div class="row mb-3">
					<label for="user_add" class="col-sm-3 col-form-label">전화번호</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="phoneNum">
					</div>
				</div>
				<input type="submit" class="btn btn-primary" value="검색">
			</form>
		</div>
	</div>
</div>
</section>

<section   class="py-5 bg-light">
<div class="container px-4 px-lg-5 mt-5">
	<h2 class="fw-bolder mb-4">조회결과</h2>
	수정, 삭제하시고자 하는 접수내역을 체크하고 접수 시 작성하셨던 비밀번호를 입력 후 버튼을 클릭해주세요.<p>
	<form id="form" action="" method="get">
	<table class="table">
	<tr>
	   <td><p>접수내역</p></td>
	   <td><p>이름</p></td>
	   <td><p>전화번호</p></td>
	   <td><p>마라톤</p></td>
	</tr>
	<c:forEach var="receipt" items="${receipts}">
	
	 <tr>
	    <td> <input type="checkbox" name="receiptNum" value="${receipt.receiptNum}">  <p>${receipt.receiptNum} 번</p></td>
	    <td><p>${receipt.userName}</p></td>
	    <td><p>${receipt.phoneNum}</p></td>
	    <td>
	        <!-- 마라톤 ID 대신 이름을 찾아서 출력 -->
	        <c:forEach var="marathon" items="${marathonList}">
	            <c:if test="${marathon.marathonId == receipt.marathonId}">
	                <p>${marathon.marathonName}</p>
	            </c:if>
	        </c:forEach>
	    </td>
	 </tr>
	 <!-- c:forEach 반복 내용 -->
	
	</c:forEach>
	</table>
	<div class="row">
	<div class="col-3">
	<input class="form-control" type="password" id="passwordInput" placeholder="비밀번호를 입력하세요">
	</div>
	<div class="col-3">
	<input class="btn btn-primary" type="button" value="수정하기" onclick="handleSubmit('update')">
	<input class="btn btn-primary" type="button" value="삭제하기" onclick="handleSubmit('delete')">
	</div>
	</div>
	</form>
</div>
</section>


</body>
</html>