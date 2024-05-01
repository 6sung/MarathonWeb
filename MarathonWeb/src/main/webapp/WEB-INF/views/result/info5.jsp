<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ModuRunner</title>
    <jsp:include page="../marathon/nav.jsp" />
</head>
<script>
function handleSubmit(actionType) {
    var checkboxes = document.querySelectorAll('input[name="receiptNum"]:checked');
    
    var passwordInput = document.getElementById('passwordInput');
    var selectedValue = checkboxes.length > 0 ? checkboxes[0].value : null; // 선택된 체크박스가 없는 경우 null로 처리
    var passwordValue = passwordInput ? passwordInput.value : null; // getPasswordInput이 null이 아닌지 확인
    
    const passwordElement = document.querySelector('input[name="userPassword'+selectedValue+'"]'); //hidden 처리된 userPassword 값중 체크된 값을 저장
    const passwordValue2 = passwordElement ? passwordElement.value : null; //passwordElement 값이 널인지 아닌지 확인

    
    // 체크 박스 선택 여부 확인
    if (!selectedValue) {
        alert("하나의 목록을 선택해주세요.");
        return;
    }
    // 비밀번호 입력 확인
    if (!passwordValue) {
        alert("비밀번호를 입력해주세요.");
        return;
    }
    // 비밀번호 일치 확인
      if (passwordValue != passwordValue2) {
        alert("비밀번호가 틀립니다. ");
        return;
    }  

    // actionType에 따른 분기 처리
    var baseURL = "/result";
    var actionURL;
    if(actionType === 'update' || actionType === 'delete') {
        // 선택된 액션에 따라 URL 설정
        actionURL = baseURL + "/" + actionType + "/" + selectedValue + "/" + encodeURIComponent(passwordValue); // URL 인코딩 추가
        window.location.href = actionURL;
    } else {
        console.error("Unknown action type");
    }
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
      <td><p>선택</p></td>
      <td><p>접수내역</p></td>
      <td><p>이름</p></td>
      <td><p>전화번호</p></td>
      <td><p>마라톤</p></td>
   </tr>
   <c:forEach var="receipt" items="${receipts}">

    <tr>
       <td> <input type="checkbox" name="receiptNum" value="${receipt.receiptNum}"><input type="hidden" name="userPassword${receipt.receiptNum}" value="${receipt.userPassword}">  </td>
       <td><p>${receipt.receiptNum} 번</p></td>
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