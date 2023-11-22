<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<%@ include file="links.jsp"%>
</head>
<body>
	<!-- include header file  -->
	<%@ include file="header.jsp"%>
	<!-- Banner Start -->
	<section>
		<div class="container">
			<div id="carouselExampleDark" class="carousel carousel-dark slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active" data-bs-interval="700">
						<img
							src="${pageContext.request.contextPath}/resources/images/Home/Banner.jpg"
							class="d-block w-100" alt="img">
						<div class="carousel-caption d-md-block">
							<h1>Style Comfort & Affordable</h1>
							<p>Some representative placeholder content for the first
								slide.</p>
							<form action="#">
								<button class="btn">Explore Store</button>
							</form>
						</div>
					</div>
					<div class="carousel-item" data-bs-interval="1500">
						<img
							src="${pageContext.request.contextPath}/resources/images/Home/Banner-2.jpg"
							class="d-block w-100" alt="img">
						<!-- <div class="carousel-caption d-md-block">
                            <h1>Get up to 50% off Black Friday</h1>
                            <p>Some representative placeholder content for the second slide.</p>
                            <form action="#">
                                <button class="btn">Explore Store</button>
                            </form>
                        </div> -->
					</div>
					<div class="carousel-item" data-bs-interval="3000">
						<img
							src="${pageContext.request.contextPath}/resources/images/Home/Banner-3.jpg"
							class="d-block w-100" alt="img">
						<!-- <div class="carousel-caption  d-md-block">
                            <h1>Online Fashion Shop</h1>
                            <p>Some representative placeholder content for the third slide.</p>
                            <form action="#">
                                <button class="btn">Explore Store</button>
                            </form>
                        </div> -->
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</section>
	<!-- Banner End -->
	<!-- Category Section Start -->
	<section>
		<div class="container">
			<div class="heading">
				<h3>Our Latest Categories</h3>
			</div>
			<div class="row mb-5">

				<c:if test="${!empty CategoryDatalist}">
					<c:forEach var="var" items="${CategoryDatalist}">
						<div class="col-md-3 my-2">
							<div class="categorie_card">
								<a href="/api/page/CategoryWiseProduct/${var.catid}">
									<div class="card">
										<div class="card-body text-center">
											<div class="my-5">
												<div class="categorie_card_img">
													<img
														src="${pageContext.request.contextPath}/resources/upload_file/${var.filecategory}"
														alt=product>
												</div>
												<h6 class="mt-2">${var.categoryname}</h6>
											</div>
										</div>
									</div>
								</a>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<!--     /api/page/All-Category-->
		<form action="/api/page/AllCategories">
			<button class="btn m-auto d-block mb-5">View All Category</button>
		</form>
		</div>
	</section>
	<!-- Category Section End -->
	<!-- Collection Section Start  -->
	<section class="Collection_my_8">
		<div class="container">
			<div class="row my-5">
				<div class="col-md-4">
					<div class="collection_card">
						<img
							src="${pageContext.request.contextPath}/resources/images/Home/Collection/card-01.jpg"
							alt="img">
					</div>
				</div>
				<div class="col-md-8">
					<div class="collection_card_bg">
						<h2>Phula Patti Collection</h2>
						<p>Launch Offer 15% Off!</p>
						<form action="#">
							<button class="btn">View Collection</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Collection Section End -->
	<!-- Categories start  -->
	<section class="gray_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="categories text-center">
						<a href="javascript:void(0)">
							<div class="card rounded-circle mb-3">
								<div class="card-body">
									<img
										src="${pageContext.request.contextPath}/resources/images/Home/Categories/globe.png"
										alt="img">
								</div>
							</div>
						</a>
						<p>Worldwide Shipping</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="categories text-center">
						<a href="javascript:void(0)">
							<div class="card rounded-circle mb-3">
								<div class="card-body">
									<img
										src="${pageContext.request.contextPath}/resources/images/Home/Categories/quality.png"
										alt="img">
								</div>
							</div>
						</a>
						<p>Best Quality</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="categories text-center">
						<a href="javascript:void(0)">
							<div class="card rounded-circle mb-3">
								<div class="card-body">
									<img
										src="${pageContext.request.contextPath}/resources/images/Home/Categories/tag.png"
										alt="img">
								</div>
							</div>
						</a>
						<p>Best Offers</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="categories text-center">
						<a href="javascript:void(0)">
							<div class="card rounded-circle mb-3">
								<div class="card-body">
									<img
										src="${pageContext.request.contextPath}/resources/images/Home/Categories/lock.png"
										alt="img">
								</div>
							</div>
						</a>
						<p>Secure Payments</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Categories End -->

	<!-- Sale Section Start -->
	<section class="my-4">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<a href="#"> <img
						src="${pageContext.request.contextPath}/resources/images/Home/Sale/Sale.jpg"
						alt="img">
					</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Sale Section End  -->
	<!-- Latest Products Start -->
	<section class="latest-product_section">
		<div class="container">
			<div class="heading">
				<h3>Our Latest Products</h3>
			</div>

			<div class="row">
				<div class="owl-carousel owl-theme">
					<c:if test="${!empty listOfData}">
						<c:forEach var="var" items="${listOfData}">
							<div class="item">
								<div class="latest-product">
									<a href="/api/page/product-details/${var.pid}"> <img
										src="${pageContext.request.contextPath}/resources/upload_file/${var.filesretrieve[0]}"
										alt="img">
										<%-- <div class="shop-thumbnail">

											<a href="/api/test/addtocartproduct?products=${var.pid}">
												<span> <i class="fa-solid fa-cart-shopping"></i>
											</span> <span> <i class="fa-solid fa-eye"></i>
											</span>
											</a>
										</div> --%>
										<h5>${var.productname}</h5>
										<p>SKU: ${var.sku}</p>
										<h6>MRP: ${var.price}/-</h6>
									</a>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
	</section>
	<!-- Latest Products End -->
	<!-- Contact Us Section Start -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="contact_bg">
						<h4>Connect with Us</h4>
						<ul>
							<li><a href="javascript:void(0)"><i
									class="fa-brands fa-facebook"></i></a></li>
							<li><a href="javascript:void(0)"><i
									class="fa-brands fa-twitter"></i></a></li>
							<li><a href="javascript:void(0)"><i
									class="fa-brands fa-instagram"></i></a></li>
							<!-- <li><a href="#"><i class="fa-brands fa-pinterest"></i></a></li> -->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Contact Us Section End -->
	<!-- Footer Start -->
	<!--  link footer body-->
	<%@ include file="footer.jsp"%>
	<!-- Script Start -->

	<script>
		$('.owl-carousel').owlCarousel({
			loop : true,
			margin : 10,
			nav : true,
			autoplay : true,
			autoplayTimeout : 3000,
			dots : false,
			navText : false,
			responsive : {
				0 : {
					items : 1
				},
				600 : {
					items : 2
				},
				1000 : {
					items : 4
				}
			}
		})
	</script>




</body>
</html>