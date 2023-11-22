<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
        window.history.forward();
        function noBack() {
        window.history.forward();
        }
    </script>
<%@ include file="links.jsp"%>


</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- Login Section Start  action="/api/auth/signin" method="post" -->
	<div class="container">
		<div class="row my-5">
			<div class="col-md-4 offset-md-4 p-5 login">
				<h2>Login</h2>
				<form class="mt-4" action="/api/auth/signin" method="post"
					modelAttribute="loginRequest">
					<div class="mb-3">
						<label class="form-label">Email address</label> <input type="text"
							class="form-control" placeholder="Enter Email" name="username"
							id="username">
					</div>
					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" placeholder="Enter Password" name="password"
							id="password">
					</div>
					<!-- <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" >
                            <label class="form-check-label">Check me out</label>
                        </div> -->
					<button type="submit" class="btn mb-3" id="login">Login</button>

					<a href="/api/page/forgote-password">Forgot Password? </a>
					<p>
						Don't have account? <a href="/api/page/SignUp">Sign Up</a>
					</p>
				</form>
				<c:if test="${!isNotValid}">
					<div class="alert alert-danger alert-dismissible fade show"
						id="box1">
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							id="close"></button>
						<b> invalid username or password ${isNotValid} </b>
					</div>
				</c:if>

			</div>
		</div>
	</div>
	</section>
	<!-- Login Section End -->
	<script type="text/javascript">
		
	<%@ include file="footer.jsp"%>
		<script src="${pageContext.request.contextPath}/resources/js/post.js"  type="text/javascript">
	</script>


	<%@ include file="footer.jsp"%>
	<script
		src="${pageContext.request.contextPath}/resources/js/loginstate.js"
		type="text/javascript">
	</script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script type="text/javascript">
	function successMessage(msg) {
		Swal.fire({
			position: 'top-end',
			position: 'center',
			icon: 'success',
			title: msg,
			showConfirmButton: false,
			timer: 1500
		})
	
	
	</script>







</body>
</html>