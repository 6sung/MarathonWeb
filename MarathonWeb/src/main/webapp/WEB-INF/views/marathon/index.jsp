<%@page import="com.webteam.marathon.dto.Marathon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../marathon/nav.jsp" />
<title>Test</title>
</head>
<body>
<%--<h1>마라톤 테스트용 조회</h1>
<p>마라톤 아이디와 이름이 뜹니다
<table>
<c:forEach var="marathon" items="${marathonList}">
<tr>
	<td>${marathon.marathonId}</td>
	<td>${marathon.marathonName}</td>
</tr>
</c:forEach>
</table> --%>

<!-- 상단 바 -->
<section>
	<div class="container">
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="https://i.pinimg.com/564x/fa/d2/b5/fad2b5ffc07c3ccb23d534e1dee37e9f.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="https://i.pinimg.com/564x/8f/0f/3e/8f0f3e77c8caf77e40889f2cf96719d2.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="https://i.pinimg.com/564x/0c/77/73/0c77734f2d358941595b4f5cb737f223.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	</div>
</section>

<div class="album py-5 bg-light">
	<div class="container">
	<div class="row">
	<c:forEach var="marathon" items="${marathonList}">
					<div class="col-md-4">
				<div class="card mb-4 shadow-sm" >
				<img src="https://i.pinimg.com/564x/d1/12/8c/d1128ccc57c4bbcbf328a4683a48c374.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title"><strong>${marathon.marathonName}</strong></h5>
				    <p class="card-text">${marathon.marathonDate}</p>
				    <a href="insert?marathonId=${marathon.marathonId}" class="btn btn-success">접수하기</a>

				  </div>
				</div>
			</div>
	</c:forEach>
	</div>
	</div>
</div>

${message}

</body>
</html>