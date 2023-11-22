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
				<h2>Reset Password</h2>
				<form class="mt-4"  method="get">
					<div class="mb-3">
						<label class="form-label">Email address</label> <input type="text"
							class="form-control" placeholder="Enter Email" name="emails"
							id="email">
					</div>
					<div class="mb-3">
						<label class="form-label">New Password</label> <input type="password"
							class="form-control" placeholder="Enter Password" name="passwords"
							id="password">
					</div>
					<!-- <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" >
                            <label class="form-check-label">Check me out</label>
                        </div> -->
					<button type="button" class="btn mb-3 w-100" id="forgatepassword">Forget Password</button>
					<p><a href="/api/page/SignUp">Login Up</a>
					</p>
				</form>
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
<script>
$("#forgatepassword").click(function(){
	alert("clicked");
	
	 $.ajax({
		type:'post',
		url:'/api/test/reset-password',
		dataType: 'json',
		contentType: "application/json",
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		data: JSON
			.stringify({
				"emails": $("#email").val(),
				"passwords": $("#password").val(),
				
			}),
		success:function(response){
		alert(response['message']);
		
			window.location.href = "/api/page/LogIn";
			
		},
		error:function(response){
			window.location.href = "/api/page/forgote-password";
		}
		
	});
	 
	});

	





</script>






</body>
</html>