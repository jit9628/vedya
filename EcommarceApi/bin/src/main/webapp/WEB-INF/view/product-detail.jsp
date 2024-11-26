<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="ar" dir="ltr">

<head>
<%@ include file="links.jsp"%>

</head>

<body>
	<!-- Header Section Start -->
	<%@ include file="header.jsp"%>
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
								href="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"
								id="imagesourcename"> <img
								src="${pageContext.request.contextPath}/resources/upload_file/${details.filesretrieve[0]}"
								alt="">
							</a>
							<c:forEach var="imgvar" items="${sliderfile}">
								<a
									href="${pageContext.request.contextPath}/resources/upload_file/${imgvar}"
									onclick="selectimage()"> <img
									src="${pageContext.request.contextPath}/resources/upload_file/${imgvar}"
									alt="" id="imagesourcepath">
								</a>
							</c:forEach>
						</div>
						<!-- sliderfile -->
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
											name="color8" id="white8" value="white"> <label
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


									<c:forEach var="var2" items="${productsize}">

										<%-- <div
											class="form-check size-option form-option form-check-inline mb-2 ischecked">
											<input
												class="form-check-input d-none selectedsizevalue  accessid"
												type="radio" name="size" id="${var2 }" value="${var2 }"
												onclick="selectedSize()"> <label
												class="form-option-label  addcheck" for="${var2 }"
												onclick="setCheckedAttribute()"> ${var2}</label>
										</div> --%>
										<%-- <div
											class="form-check form-option size-option  form-check-inline mb-2">
											<input class="form-check-input  d-none selectedsizevalue"
												type="radio" name="size" id="${var2 }" value="${var2 }"
												onclick="selectedSize()"> 
												<label
												class="form-option-label" for="${var2 }"
												onclick="setCheckedAttribute()">${var2}</label>
										</div>
 --%>

										<div
											class="form-check form-option size-option  form-check-inline mb-2">
											<input class="form-check-input d-none" type="radio"
												name="size" id="${var2 }" value="${var2 }" onclick="selectedSize()"> 
												<label class="form-option-label"
												 for="${var2 }"
												onclick="setCheckedAttribute()">${var2}</label>
										</div>





									</c:forEach>
								</div>
							</div>



							<div class="prt_05 mb-4">
								<div class="row row-cols-auto">

									<div class="col">
										<form
											action="/api/test/addtocartproducts?products=${details.pid}">
											<!-- <button type="button"
												class="btn btn-block custom-height bg-dark text-white mb-2"
												id="cartadd">

												<i class="fa-solid fa-cart-shopping mx-2"></i>Add to Cart
											</button> -->
											<button type="button"
												class="btn btn-block custom-height bg-dark text-white mb-2"
												id="cartaddviauser">

												<i class="fa-solid fa-cart-shopping mx-2"></i>Add to Cart
											</button>
										</form>
										<%-- <a href="/api/test/addtocartproduct?products=${details.pid}"
											class="btn btn-block custom-height bg-dark text-white mb-2">
											<span> <i class="fa-solid fa-cart-shopping"></i> Add-To-Cart
										</span>
										</a> --%>
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
							<!-- <div class="prt_06">
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
							</div> -->

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
					<div class="owl-carousel owl-theme mb-5">
						<c:forEach var="varrr" items="${matchingproduct}">
							<div class="item">
								<div class="latest-product">
									<a href="/api/page/product-details/${varrr.pid}""> <img
										src="${pageContext.request.contextPath}/resources/upload_file/${varrr.filesretrieve[0]}"
										alt="">
										<div class="shop-thumbnail">
											<a href="javascript:void(0)"> <span> <i
													class="fa-solid fa-cart-shopping"></i>
											</span> <span> <i class="fa-solid fa-eye"></i>
											</span>
											</a>
										</div>
										<h5>${varrr.productname }</h5>
										<p>SKU: ${varrr.sku }</p>
										<h6>MRP: ${varrr.price }/-</h6>
									</a>
								</div>
							</div>
						</c:forEach>
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
						<form action="#">
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
						<p>Copyright � 2022 Vedya</p>
					</div>
					<div class="col-md-6">
						<p class="text-end">Powered by Vedya</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Mini Footer End -->
	<!-- Footer End  -->
	<!-- Script Start -->
	<script src="./js/bootstrap.bundle.min.js"></script>

	<!-- Product JS  -->
	<script src="./js/jquery.min.js"></script>
	<script src="./js/smoothproducts.js"></script>
	<script src="./js/custom.js"></script>

	<script src="./js/owl.carousel.min.js"></script>
	<script>
		$('.owl-carousel').owlCarousel({
			loop : true,
			margin : 10,
			nav : true,
			autoplay : false,
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
		
		
		
		
		
	
		/* function selectedSize() {
			var val = $("input[name='size']:checked").val(); */
			/* var size = "&&size=" + val;
			var href=	$(".sp-current-big").attr('href');
			splits=href.split("/");
			orderimagevalue=splits[3];
			 var orderimage ="&&orderimage=" + orderimagevalue;
			 alert(orderimage); */
	$("#cartaddviauser").click(function(){
		
		var val = $("input[name='size']:checked").val();
		var color=$("input[name='color8']:checked").val();
		console.log(color);
		if(val==undefined||color==undefined){
			alert("Please Select Color And Size"+color);
		}
		
		else{
		var size = "&&size=" + val;
		var href=	$(".sp-current-big").attr('href');
		splits=href.split("/");
		orderimagevalue=splits[3];
		 var orderimage ="&&orderimage=" + orderimagevalue;
		 var choosecolor="&&color="+color;
	
		var href = $('form').attr('action');
		var finalurl = href + size + orderimage + choosecolor;
		/*start Ajax Block*/
		$.ajax({
			
					url: finalurl,
					type: 'GET',
					/* 	dataType: 'json', */
					success: function(
						data,
						textStatus,
						xhr) {

						console.log(data);
						/*successMessage("Product Add To Cart ..") ;*/
					

						if (data["status"] == 200) {
							//successMessage("Product Is Add To Cart");
								window.location.href = "/api/test/shoping-cart";
								//console.log(data);
									//$('#message').removeClass("d-none").addClass("d-block");
								
								//window.location.href = "api/auth/userdashboard";
			
							}
						if (data["status"] == 226) {
							failledMessage(data['message']);
							window.setTimeout(() => { window.location.href = "/api/page/Product-dtl-usr"; }, 4000);
			
							}

						/*if (data["status"] == 409) {
					failledMessage("Product Is Exists into Cart");
						//console.log(data);
							//$('#message').removeClass("d-none").addClass("d-block");
						
						//window.location.href = "/api/test/shoping-cart";
	
					}
					*/

						/*
							if (data["status"] == 401) {
						failledMessage("Please Logged In... ");
							//console.log(data);
								//$('#message').removeClass("d-none").addClass("d-block");
							
							
		
						}*/



					},
					error: function(
						xhr,
						textStatus,
						errorThrown) {
					
						console.log(errorThrown);
						console.log(xhr);
						//console.log(xhr['status'])
						//console.log(errorThrown);
						if (xhr['responseJSON'].status == 401) {
							//console.log(xhr['responseJSON'].message);
							window.location.href = "/api/page/LogIn";
						}


						if (xhr['responseJSON'].status == 226) {
							//alert(" Is Exists..");
							//failledMessage("This Product Is Already Add To Cart..");
							//window.setTimeout(() => { window.location.href = "/api/page/Product-dtl-usr"; }, 4000);
						}
						/*	if (xhr['status']) {*/
						//	window.setTimeout(() => { window.location.href = "/api/page/Product-dtl-usr"; }, 4000);
						//	window.location.href = "/api/test/shoping-cart";

						/*	}*/

					}
				});
	}
		/*End Ajax Block*/
	})		
		//}	
		
		
		function FailureMessage(msg) {
			Swal.fire({
				icon: 'error',
				title: 'Oops...',
				text: msg,
				/* footer: '<a href="">Why do I have this issue?</a>'*/
				showConfirmButton: false,
				timer: 3000
			})
		}
	</script>


	<script src="${pageContext.request.contextPath}/resources/js/post.js"
		type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>

</html>