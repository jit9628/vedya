<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="linking.jsp"%>
</head>
<body>
	<%@include file="headers.jsp"%>



	<!-- page-wrapper Start-->
	<div class="page-wrapper compact-wrapper" id="pageWrapper">


		<!-- Page Body Start-->
		<div class="page-body-wrapper">



			<!-- Container-fluid starts-->
			<div class="page-body">
				<!-- tracking table start -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-12">
							<div class="card">
								<div class="card-body">
									<div class="title-header title-header-block package-card">
										<div id="orderid">
											<h5>${orderid }</h5>

										</div>
										<!-- <div class="card-order-section">
											<ul>
												<li>October 21, 2021 at 9:08 pm</li>
												<li>6 items</li>
												<li>Total ₹5,882.00</li>
											</ul>
										</div> -->
									</div>
									<div class="bg-inner cart-section order-details-table">
										<div class="row g-4">
											<div class="col-xl-8">
												<div class="table-responsive table-details">
													<table class="table cart-table table-borderless">
														<thead>
															<tr>
																<th colspan="2">Items</th>
																<!-- 	<th class="text-end" colspan="2"><a
																	href="javascript:void(0)" class="theme-color">Edit
																		Items</a></th> -->
															</tr>
														</thead>

														<tbody>

															<c:forEach var="data" items="${bookingDetail}">
																<tr>
																	<td><div class="best-product-box">
																			<div class="product-image">
																				<img
																					src="${pageContext.request.contextPath}/resources/upload_file/${data.orderimage }"
																					class="img-fluid" alt="Product">
																			</div>
																			<div class="product-name">
																				<h5>${data.opname}</h5>
																				<h6>26-12-2022</h6>
																			</div>
																		</div></td>
																	<td>
																		<div class="product-detail-box">
																			<h6>Price</h6>
																			<h5>${data.price }</h5>
																		</div>
																	</td>
																	<td>
																		<div class="product-detail-box">
																			<h6>Order Id</h6>
																			<h5>${data.orderid}</h5>
																		</div>
																	</td>
																	<td>
																		<div class="product-detail-box">
																			<h6>Customer Name</h6>
																			<h5>${data.customername }</h5>
																		</div>
																	</td>
																</tr>
															</c:forEach>
														</tbody>

														<tfoot id="appendPriceContent">
															<!-- <tr class="table-order">
																<td colspan="3">
																	<h5>Subtotal :</h5>
																</td>
																<td>
																	<h4>₹55.00</h4>
																</td>
															</tr>

															<tr class="table-order">
																<td colspan="3">
																	<h5>Shipping :</h5>
																</td>
																<td>
																	<h4>₹12.00</h4>
																</td>
															</tr> -->

															<!-- <tr class="table-order">
																<td colspan="3">
																	<h5>Tax(GST) :</h5>
																</td>
																<td>
																	<h4>₹10.00</h4>
																</td>
															</tr> -->
															<tr class="table-order">
																<td colspan="3">
																	<h5>Total Price :</h5>
																</td>
																<td>
																	<h4>${getTotalprice }</h4>
																</td>
															</tr>

														</tfoot>
													</table>
												</div>
											</div>

											<div class="col-xl-4">
												<div class="order-success">
													<div class="row g-4">
														<!-- <h4>summery</h4>
														<ul class="order-details">
															<li>Order ID: 5563853658932</li>
															<li>Order Date: October 22, 2018</li>
															<li>Order Total: ₹907.28</li>
														</ul> -->
														<h4>shipping address</h4>
														<ul class="order-details">
															<li>${localaddress }</li>
															<li>568, Suite Ave.</li>
															<li>Austrlia, 235153 Contact No. 48465465465</li>
														</ul>

														<!-- <div class="payment-mode">
															<h4>payment method</h4>
															<p>Pay on Delivery (Cash/Card). Cash on delivery
																(COD) available. Card/Net banking acceptance subject to
																device availability.</p>
														</div> -->

														<!-- <div class="delivery-sec">
															<h3>
																expected date of delivery: <span>october 22, 2018</span>
															</h3>
															<a href="#">track order</a>
														</div> -->
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- section end -->
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- page-wrapper End-->



	<!-- Delete Modal Box Start -->


	<!-- Delete Modal Box End -->
	<!-- Offcanvas Box Start -->
	<div class="offcanvas offcanvas-end order-offcanvas" tabindex="-1"
		id="order-details" aria-labelledby="offcanvasExampleLabel"
		aria-expanded="false">
		<div class="offcanvas-header">
			<h4 class="offcanvas-title" id="offcanvasExampleLabel">#573-685572</h4>
			<button type="button" class="btn-close text-reset"
				data-bs-dismiss="offcanvas" aria-label="Close">
				<i class="fas fa-times"></i>
			</button>
		</div>
		<div class="offcanvas-body">
			<div class="order-date">
				<h6>
					September 17, 2022 <span class="ms-3">8:12 PM</span>
				</h6>
				<a href="javascript:void(0)" class="d-block mt-1">Cancel Order</a>
			</div>

			<div class="accordion accordion-flush custome-accordion"
				id="accordionFlushExample">
				<div class="accordion-item">
					<h2 class="accordion-header" id="flush-headingOne">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
							aria-expanded="false" aria-controls="flush-collapseOne">
							Status</button>
					</h2>
					<div id="flush-collapseOne" class="accordion-collapse collapse"
						aria-labelledby="flush-headingOne"
						data-bs-parent="#accordionFlushExample">
						<div class="accordion-body">
							<ul class="status-list">
								<li><a href="javascript:void(0)">Shipped</a></li>
								<li><a href="javascript:void(0)">Pending</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header" id="flush-headingTwo">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
							aria-expanded="false" aria-controls="flush-collapseTwo">
							Accordion Item #2</button>
					</h2>
					<div id="flush-collapseTwo" class="accordion-collapse collapse"
						aria-labelledby="flush-headingTwo"
						data-bs-parent="#accordionFlushExample">
						<div class="accordion-body">
							Placeholder content for this accordion, which is intended to
							demonstrate the
							<code>.accordion-flush</code>
							class. This is the second item's accordion body. Let's imagine
							this being filled with some actual content.
						</div>
					</div>
				</div>
				<div class="accordion-item">
					<h2 class="accordion-header" id="flush-headingThree">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#flush-collapseThree"
							aria-expanded="false" aria-controls="flush-collapseThree">
							Accordion Item #3</button>
					</h2>
					<div id="flush-collapseThree" class="accordion-collapse collapse"
						aria-labelledby="flush-headingThree"
						data-bs-parent="#accordionFlushExample">
						<div class="accordion-body">
							Placeholder content for this accordion, which is intended to
							demonstrate the
							<code>.accordion-flush</code>
							class. This is the third item's accordion body. Nothing more
							exciting happening here in terms of content, but just filling up
							the space to make it look, at least at first glance, a bit more
							representative of how this would look in a real-world
							application.
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="scriptfileslinks.jsp"%>

	<%-- <script
		src="${pageContext.request.contextPath}/resources/js/order_dispatch_list_loaded.js"
		type="text/javascript"></script>
 --%>


	<%-- <script
		src="${pageContext.request.contextPath}/resources/js/order_details_list_loaded.js"
		type="text/javascript"></script>
		 --%>

</body>

</html>