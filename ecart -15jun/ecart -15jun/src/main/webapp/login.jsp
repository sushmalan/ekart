<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="header.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<h1 class="display-4 text-center text-success">User Register</h1>
	<div class="container card card-body mt-5 w-50">

		<form action="./login" method="post">


			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail1" name="email">

			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control"
					id="exampleInputPassword1" name="pwd">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</div>


	<%@include file="footer.jsp"%>
</body>
</html>