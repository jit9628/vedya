<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<a class="navbar-brand logo" href="/api/page/index"> <img
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
							<%
							if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {
							%>
							<li class="nav-item"><a class="nav-link" aria-current="page"
								href="/api/page/index">Home</a></li>
							<%
							} else {
							%>
							<li class="nav-item"><a class="nav-link" aria-current="page"
								href="/api/auth/userdashboard">Home</a></li>

							<%
							}
							%>

							<%
							if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {
							%>
							<li class="nav-item"><a class="nav-link "
								aria-current="page" href="/api/page/Product-dtl">Product</a></li>
							<%
							} else if (request.getSession().getAttribute("userid") != null || request.getSession().getAttribute("userid") != "") {
							{
							%>
							<li class="nav-item"><a class="nav-link "
								aria-current="page" href="/api/page/Product-dtl-usr">Product</a></li>
							<%
							}
							%>



							<%
							}
							%>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false" id="clicked">
									Category </a>
								<ul class="dropdown-menu " id="appendcategorylist">

									<%--  <c:forEach var="var" items="${CategoryDatalist }">
										<li><a class="dropdown-item"
											href="/api/page/AllCategories">${var.categoryname }</a></li>
										<li>
									</c:forEach>  --%>
									
								</ul></li>
						</ul>
						<div>

							<ul class="navbar-nav me-auto mb-2 mb-lg-0 align-middle">
								<%
								if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {
								%>
								<li class="nav-item"><a class="nav-link "
									aria-current="page" href="/api/page/about">About Brand</a></li>
								<%
								} else {
								%>
								<li class="nav-item"><a class="nav-link "
									aria-current="page" href="/api/auth/userdashboard">About
										Brand</a></li>
								<%
								}
								%>
								<%
								if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {
								%>
								<li class="nav-item"><a class="nav-link"
									aria-current="page" href="/api/page/LogIn">My Account </a></li>
								<%
								} else {
								%>

								<li class="nav-item"><a class="nav-link"
									aria-current="page" href="/api/auth/userdashboard">My
										Account </a></li>
								<%
								}
								%>
								<%
								if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {

								} else {
								%>


								<li class="nav-item"><a href="/api/test/shoping-cart">
										<i class="fa-solid fa-cart-shopping"></i> <span
										class="cart-count " id="countaddtocartvalue">${countAddToCartProductBasedOnUser }</span>
								</a></li>
								<%
								}
								%>

							</ul>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!-- Header Section End -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/category-loaded.js"
		type="text/javascript"></script>
	<%-- 	<script
		src="${pageContext.request.contextPath}/resources/js/product-derails.js"
		type="text/javascript"></script> --%>
</body>
</html>