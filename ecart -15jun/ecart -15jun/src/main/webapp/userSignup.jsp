<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div>
		<c:if test="${isValied}">
			<h1 class="text-danger">
				<c:out value="${errorMsg}" />
			</h1>
		</c:if>
	</div>
	<h1 class="display-4 text-center text-success">User Register</h1>


	<div class="container card card-body mt-5 w-50">


		<form action="./register" method="post">

			<div class="mb-3">
				<label for="InputUserName" class="form-label">User Name </label> <input
					type="text" class="form-control" id="InputUserName"
					required="required" aria-describedby="userName" name="uname">
			</div>

			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail1" name="email" required="required">

			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password
					:</label> <input type="password" class="form-control"
					id="exampleInputPassword1" name="pwd" required="required">
			</div>

			<div class="mb-3">
				<label for="InputMobileNo" class="form-label">MobileNumber</label> <input
					type="number" class="form-control" id="InputMobileNo"
					name="mobleNo">
			</div>

			<div class="mb-3">
				<label for="InputAddress" class="form-label">Address</label> <input
					type="text" class="form-control" id="InputAddress" name="address">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</div>


	<%@include file="footer.jsp"%>
</body>
</html>