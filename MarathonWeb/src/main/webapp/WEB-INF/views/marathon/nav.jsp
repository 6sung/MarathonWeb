<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.js"/>
<!-- datepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>

<style type="text/css">
@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}
.navbar-brand{
	font-family: 'Pretendard-Regular';
	font-weight: 800;
}
.nav-link{
	font-family: 'Pretendard-Regular';
	font-weight: 300;
}
h1{
	font-family: 'Pretendard-Regular';
	font-weight: 800;
}
h2{
	font-family: 'Pretendard-Regular';
	font-weight: 700;
}
div{
	font-family: 'Pretendard-Regular';
	font-weight: 300;
}
</style>

<title>ModuRunner</title>

<!--nav bar-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="backdrop-filter: blur(30px); background-color: rgba(244, 244, 244, 0.5);">
	<div class="container d-flex justify-content-between">
		  <a class="navbar-brand" href="/list">ModuRunner</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="/result/info5">조회 <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/result/checkform?param=update">수정</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/result/checkform?param=delete" tabindex="-1" aria-disabled="true">접수취소</a>
		      </li>
		    </ul>
		    <form class="form-inline my-2 my-lg-0" action="../list" method="GET">
		      <input class="form-control mr-sm-2" type="search" placeholder="대회를 검색해보세요!" aria-label="Search" name="searchKeyword">
		      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">검색</button>
		    </form>
		  </div>
	  </div>
	</nav>
</head>