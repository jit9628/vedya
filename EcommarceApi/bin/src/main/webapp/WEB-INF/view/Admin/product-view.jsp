<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="ar" dir="ltr">

<head>
<%@ include file="linking.jsp"%>
</head>

<body>
	<!-- Header Section Start -->
	<%@ include file="headers.jsp"%>
	<!-- Header Section End -->
	<!-- Product Details Section Start -->
	<section>
		<div class="container">
			<div class="product_detail my-5">
				<div class="row">

					<%-- <div class="col-xl-4 col-lg-4col-md-12 col-sm-12">
						<div class="sp-loading">
							<img src="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}" alt=""><br>LOADING
							IMAGES
						</div>
						<div class="sp-wrap">

						
								<a href=""><img
									src="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"
									alt=""></a>
						</div>
					</div>  --%>
					<div class="col-xl-4 col-lg-4col-md-12 col-sm-12">
						<div class="sp-loading">
							<img
								src="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"
								alt=""><br>LOADING IMAGES
						</div>
						<div class="sp-wrap">

							<a
								href="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"><img
								src="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"
								alt=""></a> <a
								href="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"><img
								src="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"
								alt=""></a>

						</div>
					</div>

					<div class="col-xl-8 col-lg-8 col-md-12 col-sm-12">
						<div class="prd_details">

							<div class="prt_01 mb-1">
								<span class="text-purple bg-light-purple rounded py-1">${categorydtl.categoryname}</span>
							</div>
							<div class="prt_02 mb-3">
								<h2 class="ft-bold mb-1">${details.productname}</h2>
								<div class="text-left">
									<div
										class="star-rating align-items-center d-flex justify-content-left mb-1 p-0">
										<i class="fas fa-star filled"></i> <i
											class="fas fa-star filled"></i> <i class="fas fa-star filled"></i>
										<i class="fas fa-star filled"></i> <i class="fas fa-star"></i>
										<!-- <span class="small">(412 Reviews)</span> -->
									</div>
									<div class="elis_rty">
										<span class="ft-medium text-muted line-through fs-md mr-2">MRP:
											${details.price}/- </span> <span
											class="ft-bold theme-cl fs-lg mx-2 fw-bold">MRP:
											${details.price}/-</span>
									</div>
								</div>
							</div>

							<div class="prt_03 mb-4">
								<p>${details.discription}</p>
							</div>




							<div class="prt_04 mb-2">
								<p class="d-flex align-items-center mb-0 text-dark ft-medium">Color:</p>
								<div class="text-left">
									<div class="form-check form-option form-check-inline mb-1">
										<input class="form-check-input d-none" type="radio"
											name="color8" id="white8"> <label
											class="form-option-label rounded-circle" for="white8"><span
											class="form-option-color rounded-circle blc7"></span></label>
									</div>
									<div class="form-check form-option form-check-inline mb-1">
										<input class="form-check-input d-none" type="radio"
											name="color8" id="blue8"> <label
											class="form-option-label rounded-circle" for="blue8"><span
											class="form-option-color rounded-circle blc2"></span></label>
									</div>
									<div class="form-check form-option form-check-inline mb-1">
										<input class="form-check-input d-none" type="radio"
											name="color8" id="yellow8"> <label
											class="form-option-label rounded-circle" for="yellow8"><span
											class="form-option-color rounded-circle blc5"></span></label>
									</div>
									<div class="form-check form-option form-check-inline mb-1">
										<input class="form-check-input d-none" type="radio"
											name="color8" id="pink8"> <label
											class="form-option-label rounded-circle" for="pink8"><span
											class="form-option-color rounded-circle blc3"></span></label>
									</div>
									<div class="form-check form-option form-check-inline mb-1">
										<input class="form-check-input d-none" type="radio"
											name="color8" id="red"> <label
											class="form-option-label rounded-circle" for="red"><span
											class="form-option-color rounded-circle blc4"></span></label>
									</div>
									<div class="form-check form-option form-check-inline mb-1">
										<input class="form-check-input d-none" type="radio"
											name="color8" id="green"> <label
											class="form-option-label rounded-circle" for="green"><span
											class="form-option-color rounded-circle blc6"></span></label>
									</div>
								</div>
							</div>

							<div class="prt_04 mb-4">
								<p class="d-flex align-items-center mb-0 text-dark ft-medium">Size:</p>
								<div class="text-left pb-0 pt-2">
									<div
										class="form-check size-option form-option form-check-inline mb-2">
										<input class="form-check-input d-none" type="radio"
											name="size" id="xs" checked=""> <label
											class="form-option-label" for="xs">XS</label>
									</div>
									<div
										class="form-check form-option size-option  form-check-inline mb-2">
										<input class="form-check-input d-none" type="radio"
											name="size" id="s"> <label class="form-option-label"
											for="s">S</label>
									</div>
									<div
										class="form-check form-option size-option  form-check-inline mb-2">
										<input class="form-check-input d-none" type="radio"
											name="size" id="m"> <label class="form-option-label"
											for="m">M</label>
									</div>
									<div
										class="form-check form-option size-option  form-check-inline mb-2">
										<input class="form-check-input d-none" type="radio"
											name="size" id="l"> <label class="form-option-label"
											for="l">L</label>
									</div>
									<div
										class="form-check form-option size-option  form-check-inline mb-2">
										<input class="form-check-input d-none" type="radio"
											name="size" id="xl"> <label class="form-option-label"
											for="xl">XL</label>
									</div>
									<div
										class="form-check form-option size-option  form-check-inline mb-2">
										<input class="form-check-input d-none" type="radio"
											name="size" id="xxl"> <label
											class="form-option-label" for="xxl">XXL</label>
									</div>
								</div>
							</div>

							<div class="prt_05 mb-4">
								<div class="row row-cols-auto">

									<div class="col">
										<form action="./Shopping-Cart.html">
											<button type="submit"
												class="btn btn-block custom-height bg-dark text-white mb-2">
												<i class="fa-solid fa-cart-shopping mx-2"></i>Add to Cart
											</button>
										</form>
									</div>
									<div class="col">
										<button
											class="btn custom-height btn-default btn-block mb-2 text-dark"
											data-toggle="button">
											<!-- <i class="lni lni-heart mr-2"></i> -->
											<i class="fa-solid fa-heart me-2"></i> Wishlist
										</button>
									</div>
								</div>

							</div>

							<div class="prt_06">
								<p class="mb-0 d-flex align-items-center">
									<span class="mr-4">Share:</span> <a
										class="d-inline-flex align-items-center justify-content-center p-3 gray circle fs-sm text-muted mr-2"
										href="javascript:void(0)"> <i
										class="fab fa-twitter position-absolute"></i>
									</a> <a
										class="d-inline-flex align-items-center justify-content-center p-3 gray circle fs-sm text-muted mr-2"
										href="javascript:void(0)"> <i
										class="fab fa-facebook-f position-absolute"></i>
									</a> <a
										class="d-inline-flex align-items-center justify-content-center p-3 gray circle fs-sm text-muted"
										href="javascript:void(0)"> <i
										class="fab fa-pinterest-p position-absolute"></i>
									</a>
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section End -->
	<!-- Matching Product Section Start -->
	<section>
		<div class="container">
			<div>
				<h4>Matching Product</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="owl-carousel owl-theme">
						<div class="item">
							<div class="latest-product">
								<a href="javascript:void(0)"> <img
									src="./images/Home/Latest-Products/product-01.jpg" alt="img">
									<div class="shop-thumbnail">
										<a href="javascript:void(0)"> <span> <i
												class="fa-solid fa-cart-shopping"></i>
										</span> <span> <i class="fa-solid fa-eye"></i>
										</span>
										</a>
									</div>
									<h5>Olive Green Festive Set</h5>
									<p>SKU: VJKS001</p>
									<h6>MRP: 1899/-</h6>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Matching Product Section End -->
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
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<h4>Product Links</h4>
					<ul>
						<li><a href="./shop.html">All Products</a></li>
						<li><a href="javascript:void(0)">MariGold Yellow Festive
								Set</a></li>
						<li><a href="javascript:void(0)">Slate Blue Lace Set</a></li>
						<li><a href="javascript:void(0)">Carnation Pink Lace Set</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h4>Men's</h4>
					<ul>
						<li><a href="javascript:void(0)">Sage Green Mens Set</a></li>
						<li><a href="javascript:void(0)">Mustard Yellow Mens Set</a></li>
						<li><a href="javascript:void(0)">Pine Green Mens Set</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h4>Women's</h4>
					<ul>
						<li><a href="javascript:void(0)">SeeoCarrot Orange
								Festive Set</a></li>
						<li><a href="javascript:void(0)">Olive Green Festive Set</a></li>
						<li><a href="javascript:void(0)">Apricot Peach</a></li>
						<li><a href="javascript:void(0)">Canvas Tan</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h4>NewsLetter</h4>
					<ul>
						<li><a href="javascript:void(0)">Have Questions?</a></li>
						<form action="./ContactUs.html">
							<button class="btn">Contact Us</button>
						</form>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!-- Mini Footer Start -->
	<section>
		<div class="container">
			<div class="mini_footer">
				<div class="row">
					<div class="col-md-6">
						<p>Copyright © 2022 vedakshi jadaun</p>
					</div>
					<div class="col-md-6">
						<p class="text-end">Powered by vedakshi jadaun</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Mini Footer End -->
	<!-- Footer End  -->
	<!-- Script Start -->

	<script>
		$('.owl-carousel').owlCarousel({
			loop : true,
			margin : 10,
			nav : true,
			autoplay : true,
			autoplayTimeout : 2000,
			dots : true,
			navText : false,
			responsive : {
				0 : {
					items : 1
				},
				600 : {
					items : 3
				},
				1000 : {
					items : 5
				}
			}
		})
	</script>

	<%@include file="scriptfileslinks.jsp"%>
</body>

</html>