<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="ar" dir="ltr">
<head>
<!-- Required meta tags -->
<%@ include file="links.jsp"%>
</head>

<body>
	<%@ include file="header.jsp"%>
	<!-- Header Section Start -->
	<!-- My Account Section Start -->

	<section>
		<div class="container">
			<div class="row my-5">
				<div class="col-md-4 pe-5">
					<div class="d-block border rounded">
						<div class="px-2 py-5 text-center">
							<div class="circle p-1 border m-auto mb-2 profile_user_img">
								<form action="/api/test/upload/userimage"
									enctype="multipart/form-data" id="imageUploadForm">
									<img
										src="${pageContext.request.contextPath}/resources/upload_file/${findImage}"
										class="img-fluid circle" width="100" alt="img" id="blah">
									<label class="edit-button edit-avatar-button" for="edit-avatar"
										onclick="getDetails()" )> <input
										accept="image/x-png,image/jpeg" hidden="" id="edit-avatar"
										type="file" value="" id="imgInp" onclick="readURL(input)"
										name="file"> <span role="img" aria-label="edit"
										class="anticon anticon-edit" id="selectimage"><svg
												viewBox="64 64 896 896" focusable="false" data-icon="edit"
												width="1em" height="1em" fill="currentColor"
												aria-hidden="true">
											<path
													d="M257.7 752c2 0 4-.2 6-.5L431.9 722c2-.4 3.9-1.3 5.3-2.8l423.9-423.9a9.96 9.96 0 000-14.1L694.9 114.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2 1-7.1 2.9L256.8 538.8c-1.5 1.5-2.4 3.3-2.8 5.3l-29.5 168.2a33.5 33.5 0 009.4 29.8c6.6 6.4 14.9 9.9 23.8 9.9zm67.4-174.4L687.8 215l73.3 73.3-362.7 362.6-88.9 15.7 15.6-89zM880 836H144c-17.7 0-32 14.3-32 32v36c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-36c0-17.7-14.3-32-32-32z"></path></svg></span>
									</label>
								</form>
							</div>
							<div>
								<h4 class="fs-md ft-medium mb-0 lh-1">${firstname }</h4>
								<h4 class="fs-md ft-medium my-2 lh-1">${usernames }</h4>

								<span class="text-muted smalls">India</span>
							</div>
						</div>
						<div class="my_account_sidebar">
							<h6
								class="px-3 py-3 mb-0  gray text-muted text-uppercase text-left">Dashboard
								Navigation</h6>
							<div class="nav flex-column nav-pills" id="v-pills-tab"
								role="tablist" aria-orientation="vertical">
								<button class="nav-link active" data-bs-toggle="pill"
									data-bs-target="#my-order" type="button" role="tab"
									aria-controls="my-order" aria-selected="true">
									<i class="fa-solid fa-cart-shopping"></i>My Order
								</button>
								<!-- <button class="nav-link" data-bs-toggle="pill"
									data-bs-target="#wishlist" type="button" role="tab"
									aria-controls="wishlist" aria-selected="false">
									<i class="fa-regular fa-heart"></i>Wishlist
								</button> -->
								<button class="nav-link" data-bs-toggle="pill"
									data-bs-target="#profile-info" type="button" role="tab"
									aria-controls="profile-info" aria-selected="false">
									<i class="fa-regular fa-user"></i>Profile Info
								</button>
								<button class="nav-link" data-bs-toggle="pill"
									data-bs-target="#addresses" type="button" role="tab"
									aria-controls="addresses" aria-selected="false">
									<i class="fa-regular fa-map"></i>Addresses
								</button>
								<button class="nav-link" data-bs-toggle="pill"
									data-bs-target="#payment-methode" type="button" role="tab"
									aria-controls="payment-methode" aria-selected="false">
									<i class="fa-regular fa-money-bill-1"></i>Payment Methode
								</button>
								<form class="full-width" action="/api/auth/logout" method="GET">
									<button class="nav-link" data-bs-toggle="pill" type="submit"
										role="tab" aria-selected="false">
										<i class="fa-solid fa-arrow-right-from-bracket"></i>Log Out
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>

				<!--  MY-ORDER  -->
				<div class="col-md-8">
					<div class="tab-content">
							<div class="tab-pane fade show active my_order border mb-4 mfliud"
							id="my-order" role="tabpanel" tabindex="0">
							
							<div  id="v-pills-tabContent"></div>
						</div> 

						<div class="tab-pane fade" id="wishlist" role="tabpanel"
							tabindex="0">
							<div class="row">
								<div class="col-md-4">
									<div class="product_item">
										<a href="#"> <img
											src="${pageContext.request.contextPath}/resources/images/shop/p-01.jpg">
										</a>
										<div class="product_cart">
											<ul>
												<li><a href="javascript:void(0)" title="Add to Cart"><i
														class="fa-solid fa-cart-shopping"></i></a></li>
												<li><a href="javascript:void(0)" title="quick-view"><i
														class="fa-solid fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
									<div class="product_text">
										<p>SKU: VJKS001</p>
										<h6>ORANGE SUNRISE KURTA PALAZZO 3 PIECE SET</h6>
										<h5>MRP: 1899/-</h5>
									</div>
								</div>
								<div class="col-md-4">
									<div class="product_item">
										<a href="#"> <img
											src="${pageContext.request.contextPath}/resources/images/shop/p-02.jpg">
										</a>
										<div class="product_cart">
											<ul>
												<li><a href="javascript:void(0)" title="Add to Cart"><i
														class="fa-solid fa-cart-shopping"></i></a></li>
												<li><a href="javascript:void(0)" title="quick-view"><i
														class="fa-solid fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
									<div class="product_text">
										<p>SKU: VJKS004</p>
										<h6>GREEN PEAR KURTA PANT SET</h6>
										<h5>MRP: 1899/-</h5>
									</div>
								</div>
								<div class="col-md-4">
									<div class="product_item">
										<a href="#"> <img
											src="${pageContext.request.contextPath}/resources/images/shop/p-03.jpg">
										</a>
										<div class="product_cart">
											<ul>
												<li><a href="javascript:void(0)" title="Add to Cart"><i
														class="fa-solid fa-cart-shopping"></i></a></li>
												<li><a href="javascript:void(0)" title="quick-view"><i
														class="fa-solid fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
									<div class="product_text">
										<p>SKU: VJKS001</p>
										<h6>YELLOW MELLOW KURTA PANT SET</h6>
										<h5>MRP: 1899/-</h5>
									</div>
								</div>
								<div class="col-md-4">
									<div class="product_item">
										<a href="#"> <img
											src="${pageContext.request.contextPath}/resources/images/shop/p-04.jpg">
										</a>
										<div class="product_cart">
											<ul>
												<li><a href="javascript:void(0)" title="Add to Cart"><i
														class="fa-solid fa-cart-shopping"></i></a></li>
												<li><a href="javascript:void(0)" title="quick-view"><i
														class="fa-solid fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
									<div class="product_text">
										<p>SKU: VJKS001</p>
										<h6>ORANGE SUNRISE KURTA PALAZZO 3 PIECE SET</h6>
										<h5>MRP: 1899/-</h5>
									</div>
								</div>
								<div class="col-md-4">
									<div class="product_item">
										<a href="#"> <img
											src="${pageContext.request.contextPath}/resources/images/shop/p-05.jpg">
										</a>
										<div class="product_cart">
											<ul>
												<li><a href="javascript:void(0)" title="Add to Cart"><i
														class="fa-solid fa-cart-shopping"></i></a></li>
												<li><a href="javascript:void(0)" title="quick-view"><i
														class="fa-solid fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
									<div class="product_text">
										<p>SKU: VJKS001</p>
										<h6>ORANGE SUNRISE KURTA PALAZZO 3 PIECE SET</h6>
										<h5>MRP: 1899/-</h5>
									</div>
								</div>

							</div>
						</div>
						<div class="tab-pane fade" id="profile-info" role="tabpanel"
							tabindex="0">
							<div class="row align-items-center">
								<form class="row m-0">
									<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 mb-3">
										<div class="form-group">
											<label class="small text-dark ft-medium">First Name *</label>
											<input type="text" class="form-control"
												value="Test First Name">
										</div>
									</div>
									<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 mb-3">
										<div class="form-group">
											<label class="small text-dark ft-medium">Last Name *</label>
											<input type="text" class="form-control"
												value="Test Last Name">
										</div>
									</div>
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mb-3">
										<div class="form-group">
											<label class="small text-dark ft-medium">Email ID *</label> <input
												type="text" class="form-control" value="Test@gmail.com">
										</div>
									</div>
									<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 mb-3">
										<!-- <div class="form-group">
											<label class="small text-dark ft-medium">Current
												Password *</label> <input type="text" class="form-control"
												value="Current Password">
										</div> -->
									</div>
									<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 mb-3">
										<!-- <div class="form-group">
											<label class="small text-dark ft-medium">New Password
												*</label> <input type="text" class="form-control"
												value="New Password">
										</div> -->
									</div>
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mb-3">
										<!-- <div class="form-group">
											<button type="button" class="btn btn-dark">Save
												Changes</button>
										</div> -->
									</div>
								</form>
							</div>
						</div>

						<div class="tab-pane fade" id="addresses" role="tabpanel"
							tabindex="0">
							<div class="row align-items-start deleteaddress"
								class="removeaddress">
								<!--  add dynamic  -->
								<div class="col-md-12">
									<div id="mainaddressbody" class="row"></div>
								</div>
							</div>
							
							<!-- <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
								<div class="form-group mb-5">
									<button class="btn borders full-width " id="showform">
										<i class="fas fa-plus me-2"></i>Add New Address
									</button>
								</div>
							</div> -->
<%@include file="address.jsp" %>

							<!-- <div class="col-12 col-lg-12 col-md-12 d-none" id="showformopen">
								<form class="border rounded mb-4 p-4 mt-5">
									<h5 class="mb-4 ft-medium">Billing Details</h5>
									<div class="row mb-3">
										<div class="col">
											<label class="form-label">First Name *</label> <input
												type="text" class="form-control" placeholder="First name"
												name="firstname" id="firstname">
										</div>
										<div class="col">
											<label class="form-label">Last Name *</label> <input
												type="text" class="form-control" placeholder="Last name"
												name="lastname" id="lastname">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col">
											<label class="form-label">Email *</label> <input type="email"
												class="form-control" placeholder="Email" name="email"
												id="email">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col">
											<label class="form-label">Address*</label> 
											<input type="text"class="form-control" placeholder="Address"
												name="localadderess" id="localadderess">
										</div>
									</div>

									<div class="row mb-3">
										<div class="col">
											<label class="form-label">Country *</label>
												<select
												class="form-select" aria-label="Default select example"
												id="selection" selected="">
											</select
											<input type="text" class="form-control" placeholder="country"
												name="country" id="country">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col">
											<label class="form-label">City / Town *</label>
											<select
												class="form-select" aria-label="Default select example"
												id="cityselection" selected="">
											</select>

											<input type="text" class="form-control" placeholder="city"
												name="city" id="city">
										</div>
										<div class="col">
											<label class="form-label">ZIP / Postcode *</label> <input
												type="text" class="form-control"
												placeholder="ZIP / Postcode *" name="postalcode"
												id="postalcode">

										</div>
									</div>
									<div class="row mb-3">
										<div class="col">
											<label class="form-label">Mobile Number *</label> <input
												type="number" class="form-control"
												placeholder="Mobile Number" name="mobilenumber"
												id="mobilenumber">
										</div>
									</div>
									<div class="row mb-3">
										<div class="col">
											<label class="form-label">Additional Information</label>
											<textarea class="form-control" rows="3" name="additionalinfo"
												id="additionalinfo"></textarea>
										</div>
									</div>
									<button class="btn borders full-width" id="adderessform">Submit</button>
								</form>
							</div> -->
							
							
							
							
							
							
							
							
							
						</div>
						<div class="tab-pane fade" id="payment-methode" role="tabpanel"
							tabindex="0">
							<div class="row align-items-start">
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
									<div class="card-wrap border rounded mb-4">
										<div
											class="px-3 py-2 br-bottom d-flex align-items-center justify-content-between">
											<div>
												<h4 class="fs-md ft-bold">Debit / Credit Card</h4>
											</div>
											<div>
												<!-- Button -->
												<a
													class="border p-3 circle text-dark d-inline-flex align-items-center justify-content-center"
													href="javascript:void(0)"> <i
													class="fas fa-pen-nib position-absolute"></i>
												</a>
												<!-- Button -->
												<button
													class="border bg-white text-danger p-3 circle text-dark d-inline-flex align-items-center justify-content-center">
													<i class="fas fa-times position-absolute"></i>
												</button>
											</div>
										</div>
										<div class="card-wrap-body px-3 py-3">
											<h5 class="ft-medium mb-1">Card Number</h5>
											<p>1470 **** **** 6325 (Visa)</p>
											<h5 class="ft-medium mb-1">Card Holder</h5>
											<p>Dhananjay Preet</p>
											<h5 class="ft-medium mb-1">Expired</h5>
											<p>January 2027</p>

										</div>
									</div>
								</div>
								<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
									<div class="form-group">
										<a href="#" class="btn borders full-width"><i
											class="fas fa-plus me-2"></i>Add New Card</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- My Account Section End -->
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
<%@ include file="footer.jsp"%>
	<!-- Script Start -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
	<%-- <%
}
%> --%>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/fileHandling.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/load-order-details.js"
		type="text/javascript"></script>


</body>

</html>