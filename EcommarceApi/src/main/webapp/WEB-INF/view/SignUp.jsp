<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%> --%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<!--  itself add -->

<style type="text/css">
label.error {
		color: red;
		font-size: 16px;
		font-weight: normal;
		line-height: 1.4;
		margin-top: 0.5em;
		width: 100%;
		float: none;
	}

</style>
</head>
<body>
	<!--link header file  -->
	<%@ include file="header.jsp"%>
	<!--  Sign Up Section Start action="/auth/register method="POST""   [action="/api/auth/signup"]-->
	<section>
		<div class="container">
			<div class="row my-5">

				<div class="col-md-6 offset-md-3 p-5 login">
					<h2>Sign Up</h2>
					<form : form class="mt-4" modelAttribute="signUpRequest"<%-- method="POST" --%> id="validForm">


						<div
							class="alert alert-success alert-dismissible fade show d-none"
							role="alert" id="message">
							Your Account Is Created
						
						</div>
						<div
							class="alert alert-danger alert-dismissible fade show d-none"
							role="alert" id="message">
							Your Account is Existed 
						
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">First Name</label> <input type="text"
									class="form-control" placeholder="First name" name="firstname"
									id="firstname">
								<form:errors path="fisrtname" cssStyle="color: #ff0000;"></form:errors>
                                    <span id="first"> </span>
							</div>

							<!-- <form :Error path="name"/> -->
							<div class="col">
								<label class="form-label">Last Name</label> <input type="text"
									class="form-control" placeholder="Last name" name="lastname"
									id="lastname">
								<form:errors path="lastname" cssStyle="color: #ff0000;"></form:errors>
							  <span id="second"> </span>
							</div>
						</div>


						<div class="mb-3">
							<label class="form-label">Email</label> <input
								type="email" class="form-control" placeholder="Enter Email"
								name="email" id="email" required>
							<form:errors path="email" cssStyle="color: #ff0000;"></form:errors>
						  <span id="third"> </span>
						</div>
						<div class="mb-3">
							<label class="form-label">Mobile Number</label> 
							<input
								type="number" class="form-control"
								placeholder="Enter Your Mobile Number" name="mobile" id="mobile">
							<form:errors path="mobile" cssStyle="color: #ff0000;"></form:errors>
						 <span id="four"> </span>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Password</label> <input type="password"
									class="form-control" placeholder="Password" name="password"
									id="password">
								<form:errors path="password" cssStyle="color: #ff0000;"></form:errors>
							 <span id="five"> </span>
							</div>
							<div class="col">
								<label class="form-label">Confirm Password</label> <input
									type="password" class="form-control" placeholder="Confirm Password"
									name="cpassword" id="cpassword">
									 <span id="six"> </span>
							</div>
						</div>
						<button type="button" class="btn mb-3" id="registerd">Sign
							Up</button>
							
						<p>
							Already have an account? <a href="/api/page/LogIn">Sign In</a>
						</p>
					</form :form>
				</div>
			</div>
		</div>
	</section>
	<!--  Sign Up Section End -->
	<!--  -->
	<%@ include file="links.jsp"%>

	<script src="${pageContext.request.contextPath}/resources/js/post.js"
		type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/js/responseMessage.js"
		type="text/javascript"></script>
			<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>

</html>