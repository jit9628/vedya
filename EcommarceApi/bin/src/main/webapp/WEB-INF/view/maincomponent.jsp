<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:forEach var="entry" items="${navbar}">

</c:forEach> --%>
	<!-- Header Section Start -->
	<header class=" bg-light">
		<div class="container">
			<nav class="navbar navbar-expand-lg py-4">
				<div class="container-fluid">
					<a class="navbar-brand logo" href="#"> <img
						src="${pageContext.request.contextPath}/resources/images/logo.png">
					</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">

							<li class="nav-item"><a class="nav-link" aria-current="page"
								href="#">Home</a></li>

							<li class="nav-item"><a class="nav-link "
								aria-current="page" href="/api/page/Product-dtl">Product</a></li>
							<li class="nav-item dropdown"><a class="nav-link "
								aria-current="page"> Category </a></li>
						</ul>
						<div>
							<ul class="navbar-nav me-auto mb-2 mb-lg-0 align-middle">
								<li class="nav-item"><a class="nav-link "
									aria-current="page" href="#">About Brand</a></li>
								<li class="nav-item"><a class="nav-link "
									aria-current="page" href="#">My Account </a></li>
								<li class="nav-item"><a href="/api/test/shoping-cart">
										<i class="fa-solid fa-cart-shopping"></i>
								</a></li>

							</ul>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!-- Header Section End -->
</body>
</html>