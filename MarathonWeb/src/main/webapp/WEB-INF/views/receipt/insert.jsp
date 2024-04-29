<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">



<link rel="icon" href="Favicon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<title>Laravel</title>
</head>
<body>
	<img src="/marathon/images/christmas.jpg"></p>
	

<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
<div class="container">
<a class="navbar-brand" href="#">Laravel</a>
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav ml-auto">
<li class="nav-item"><a class="nav-link" href="#">Login</a></li>
<li class="nav-item"><a class="nav-link" href="#">Register</a> </li>
</ul>

</div>
</div>
</nav>


<main class="my-form">
<div class="cotainer">
<div class="row justify-content-center">
<div class="col-md-8">
<div class="card">
<div class="card-header">Register</div>
<div class="card-body">
<form name="my-form"  action="/receipt/insert" method="post">
<div class="form-group row">
						
<select class="Marathon_name" aria-label="Disabled select example">
<c:forEach var="marathon" items="${marathonList}">
	<option value="${marathon.marathonId}">${marathon.marathonName}</option>"
	</c:forEach> 
</select>
				
								
								
								
<label for="user_name" class="col-md-4 col-form-label text-md-right">이름</label>
<div class="col-md-6">
<input type="text" id="user_name" class="form-control"name="userName" required>
	</div>
</div>


<div class="form-group row">
<label for="receipt_num"
class="col-md-4 col-form-label text-md-right"> 접수번호</label>
<div class="col-md-6">
<input type="text" id="receipt_num" class="form-control" name="receiptNum" required>
	</div>
</div>


<div class="form-group row">
<label for="user_email"
class="col-md-4 col-form-label text-md-right">E-Mail</label>
<div class="col-md-6">
<input type="text" id="user_email" class="form-control" name="userEmail" required>
	</div>
</div>



<div class="form-group row">
	<label for="phone_num"class="col-md-4 col-form-label text-md-right">Phone Num</label>
<div class="col-md-6">
<input type="text" id="phoneNum" name="phoneNum" class="form-control">
</div>
</div>



<div class="form-group row">
<label for="user_add" class="col-md-4 col-form-label text-md-right">User Add</label>
<div class="col-md-6">
<input type="text" id="userAdd" name="userAdd" class="form-control">
</div>
</div>



<div class="form-group row">
<label for="user_birth" class="col-md-4 col-form-label text-md-right">User Birth</label>
<div class="col-md-6">
<input type="text" id="userBirth" class="form-control" name="userBirth">
	</div>
</div>


<div class="form-group row">
<label for="Marathon_id" class="col-md-4 col-form-label text-md-right">Marathon Id</label>
<div class="col-md-6">
<input type="text" id="50" class="form-control" name="marathonId">
	</div>
</div>

<div class="form-group row">
<label for="user_password" class="col-md-4 col-form-label text-md-right">user password</label>
<div class="col-md-6">
<input type="text" id="user_password" class="form-control" name="userPassword">
	</div>
</div>

<div class="col-md-6 offset-md-4">
<button type="submit" class="btn btn-primary">Register</button>
</div>
${message}
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</main>
</body>
</html>