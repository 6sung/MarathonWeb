<%@page import="com.webteam.marathon.dto.Marathon"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../marathon/nav.jsp" />
<link rel="stylesheet" href="../css/cardimg.css"/>
<title>ModuRun</title>
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
<!-- 상단 바 -->
<section class="py-5">
	<!-- <img src="../images/poster.png" class="d-block w-100" alt="..."> -->
	<div class="container">
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
		    	<div class="carousel-item active">
		      	<img src="../images/post2.png" class="d-block w-100" alt="...">
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

<div class="album py-5">
	<div class="container">
	<div class="row">
	<c:forEach var="marathon" items="${marathonList}">
		<div class="col-md-4">
			<div class="card mb-4 shadow-sm" >
				<img src="${marathon.marathonImg}" class="card-img-top" alt="...">
					<div class="card-body">
				 		<h5 class="card-title"><strong>   ${marathon.marathonName}</strong></h5>
				    	<p class="card-text">${marathon.marathonDate}</p>
				    	<a href="receipt/insert?marathonId=${marathon.marathonId}" class="btn btn-primary">접수하기</a>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
</div>

</body>
</html>