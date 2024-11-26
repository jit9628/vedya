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
			<nav class="navbar bg-light fixed-top py-4">
				<div class="container">
					<!-- <a class="navbar-brand" href="#">Offcanvas navbar</a> -->

					<button class="navbar-toggler" type="button"
						data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
						aria-controls="offcanvasNavbar">
						<span class="navbar-toggler-icon"></span>
					</button>
					<!--<a class="navbar-brand logo" href="/api/page/index"> <img
						src="${pageContext.request.contextPath}/resources/images/logo(3).png"
						alt="img" style="height>
					</a>-->

					<%
					if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {
					%>
					<div class="d-flex" role="search">
						<a class="meu_icon" href="#" data-bs-toggle="modal"
							data-bs-target="#searchModal"> <i class="fa-solid fa-search"></i>
						</a> <a class="meu_icon" href="/api/page/index"> <i
							class="fa-solid fa-cart-shopping"></i> <!--  <span class="cart-count"
							id="countaddtocartvalue">0</span> -->
						</a>
					</div>
					<%
					} else {
					%>

					<div class="d-flex" role="search">
						<a class="meu_icon" href="#" data-bs-toggle="modal"
							data-bs-target="#searchModal"> <i class="fa-solid fa-search"></i>
						</a> <a class="meu_icon" href="/api/test/shoping-cart"> <i
							class="fa-solid fa-cart-shopping"></i> <span class="cart-count"
							id="countaddtocartvalue">${countAddToCartProductBasedOnUser }</span>
						</a>
					</div>
					
					<%
					}
					%>
					<div class="offcanvas offcanvas-start" tabindex="-1"
						id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
						<div class="offcanvas-header">
							<h5 class="offcanvas-title" id="offcanvasNavbarLabel"></h5>
							<button type="button" class="btn-close"
								data-bs-dismiss="offcanvas" aria-label="Close"></button>
						</div>
						<div class="offcanvas-body">
							<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
								<%
								if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {
								%>
								<li class="nav-item"><a class="nav-link"
									aria-current="page" href="/api/page/index">Home</a></li>
								<%
								} else {
								%>
								<li class="nav-item"><a class="nav-link"
									aria-current="page" href="/api/page/index">Home</a></li>

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
									<ul class="dropdown-menu" id="appendcategorylist">
									</ul></li>

								<%
								if (request.getSession().getAttribute("userid") == null || request.getSession().getAttribute("userid") == "") {
								%>
								<li class="nav-item"><a class="nav-link "
									aria-current="page" href="/api/page/about">About Brand</a></li>
								<%
								} else {
								%>
								<li class="nav-item"><a class="nav-link "
									aria-current="page" href="/api/page/about">About Brand</a></li>
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

							</ul>

						</div>
					</div>
				</div>
			</nav>








			<%-- 
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
								href="/api/page/index">Home</a></li>

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

									 <c:forEach var="var" items="${CategoryDatalist }">
										<li><a class="dropdown-item"
											href="/api/page/AllCategories">${var.categoryname }</a></li>
										<li>
									</c:forEach> 

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
									aria-current="page" href="/api/page/about">About Brand</a></li>
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
			</nav> --%>

		</div>



	</header>

	<section>
		<div class="modal fade" id="searchModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<div class="row">
							<div class="col-md-12"></div>
						</div>
						<div class="search_form">
							<div class="input-group input-group-sm mb-3">
								<input type="text" class="form-control" placeholder="Search"
									id="searchproducts1">
								<button type="button">
									<i class="fa-solid fa-search"></i>
								</button>
							</div>
						</div>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close" id="search-cross"></button>
					</div>
					
					<div class="modal-body d-none">
						<div class="search_modal_data">
							<ul  class="productsdetails">
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		



	</section>


	<script type="text/javascript">
const productsContainer = document.querySelector(".productsdetails");
 $("#searchproducts1").on("keyup",function(){
 	var keyword = $(this).val();
	//alert(keyword);
	if(keyword==""){
		//alert(keyword);	
		productsContainer.innerHTML = "<p>No Products Available</p>";
	}
 	$.ajax({
 		url: '/api/test/search-product/' + keyword,
 		type: 'GET',
 		success: function(response) {
 			arr = response["data"];		
 			displayProducts(response["data"]) ;
 		},
 		error: function(error) {
 		console.log(error);
 		}
 	});
 	
 });
 //const productsContainer = document.querySelector(".productsdetails");
 function displayProducts(products) {
   if (products.length > 0) {
	//alert(products.length);
     const product_details = products
       .map(
         (product) =>
 '<li><a href="/api/page/product-details/'+product.pid+'"><div class="d-flex"><div class="search_img"><img src="/resources/upload_file/' + product.files[0] + '" alt="img"></div><div><h6>'+product.productname+'</h6><p>'+product.price+'</p></div></div></a></li>'

       )
       .join("");

     productsContainer.innerHTML = product_details;
     $(".modal-body").removeClass("d-none");
   } else {
     productsContainer.innerHTML = "<p>No Products Available</p>";
   }
 }
 $("#search-cross").click(()=>{
	
	productsContainer.innerHTML = "<p>No Products Available</p>";
	document.getElementById("searchproducts1").value = "";
 })
 </script>
	<!-- Header Section End -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/category-loaded.js"
		type="text/javascript"></script>
	<%-- <script
		src="${pageContext.request.contextPath}/resources/js/search-product.js"
		type="text/javascript"></script> --%>
</body>
</html>