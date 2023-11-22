<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="links.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<section>
		<div class="container">
			<div class="shopping_cart_heading text-center my-5">
				<h4>Checkout</h4>
			</div>
			
			<!-- include address page -->
			<%@include file="address.jsp" %>
			<!-- <div class="row align-items-start">
							
								<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
									<div class="form-group">
										<button class="btn borders full-width " id="showform"><i class="fas fa-plus me-2"></i>Add New Address</button>
									</div>
								</div>


							</div> -->
			<div class="row justify-content-between">
				<div class="col-12 col-lg-7 col-md-12">
				<div class="row align-items-start deleteaddress"
								id="mainaddressbody" class="removeaddress">
								<!--  add dynamic  -->


							</div>
					<form>
<!-- 						<h5 class="mb-4 ft-medium">Billing Details</h5>
 -->					<!-- 	<div class="row mb-3">
							<div class="col">
								<label class="form-label">First Name *</label> <input
									type="text" class="form-control" placeholder="First name" name="firstname">
							</div>
							<div class="col">
								<label class="form-label">Last Name *</label> <input type="text"
									class="form-control" placeholder="Last name" name="lastname">
							</div>
						</div> -->
						<!-- <div class="row mb-3">
							<div class="col">
								<label class="form-label">Email *</label> <input type="email"
									class="form-control" placeholder="Email" name="email">
							</div>
						</div> -->
						<!-- <div class="row mb-3">
							<div class="col">
								<label class="form-label">Address*</label> <input type="text"
									class="form-control" placeholder="Address " name="adderess">
							</div>
						</div> -->
						
                       <!--  <div class="row mb-3">
                            <div class="col">
                                <label class="form-label">Country *</label>
                                <select class="form-select" aria-label="Default select example" id="selection" selected>
                                </select>
                            </div>
                        </div> --> 
						<!-- <div class="row mb-3">
							<div class="col">
								<label class="form-label">City / Town *</label> <select
									class="form-select" aria-label="Default select example"
									id="cityselection" selected >
								</select>
							</div>
							<div class="col">
								<label class="form-label">ZIP / Postcode *</label> <input
									type="text" class="form-control" placeholder="ZIP / Postcode *">
								</select>
							</div>
						</div> -->
						<!-- <div class="row mb-3">
							<div class="col">
								<label class="form-label">Mobile Number *</label> <input
									type="number" class="form-control" placeholder="Mobile Number">
							</div>
						</div> -->
<!-- 						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Additional Information</label>
								<textarea class="form-control" rows="3"></textarea>
							</div>
						</div> -->
						<h5 class="mb-4 mt-5 ft-medium">Payments</h5>
						<div class="accordion accordion-flush" id="card">
							<div class="accordion-item">
								<h2 class="accordion-header" id="payment">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#payment-card"
										aria-expanded="false" aria-controls="payment-card">
										Debit Or Credit</button>
								</h2>
								<div id="payment-card" class="accordion-collapse collapse"
									aria-labelledby="payment" data-bs-parent="#card">
									<div class="accordion-body">

										<div class="row mb-3">
											<div class="col">
												<label class="form-label">Card Holder Name *</label> <input
													type="text" class="form-control" placeholder="Name">
											</div>
										</div>
										<div class="row mb-3">
											<div class="col">
												<label class="form-label">Card Number *</label> <input
													type="number" class="form-control"
													placeholder="0000 0000 0000 0000">
											</div>
										</div>
										<div class="row mb-3">
											<div class="col">
												<label class="form-label">Expire Month </label> <select
													class="form-select" aria-label="Default select example">
													<option selected="">Select Month</option>
													<option value="1">01</option>
													<option value="2">02</option>
													<option value="3">03</option>
													<option value="4">04</option>
													<option value="5">05</option>
													<option value="6">06</option>
													<option value="7">07</option>
													<option value="8">08</option>
													<option value="9">09</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
												</select>
											</div>
											<div class="col">
												<label class="form-label">Expire Year *</label> <input
													type="text" class="form-control" placeholder="YYYY">
											</div>
											<div class="col">
												<label class="form-label">CVC *</label> <input type="number"
													class="form-control" placeholder="CVC *">
											</div>
										</div>
										<button type="submit"
											class="btn btn_Checkout btn-block btn-dark mb-5 mt-3">Pay
											MRP: 5500/-</button>

									</div>
								</div>
							</div>
							<div class="accordion-item">
								<h2 class="accordion-header" id="flush-headingTwo">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
										aria-expanded="false" aria-controls="flush-collapseTwo">
										UPI</button>
								</h2>
								<div id="flush-collapseTwo" class="accordion-collapse collapse"
									aria-labelledby="flush-headingTwo"
									data-bs-parent="#accordionFlushExample">
									<!-- <div class="accordion-body">Placeholder content for this accordion, which is
                                        intended to demonstrate the <code>.accordion-flush</code> class. This is the
                                        second item's accordion body. Let's imagine this being filled with some actual
                                        content.</div> -->
								</div>
							</div>
						</div>
					</form>




				</div>
				<div class="col-12 col-md-12 col-lg-4">
					<div class="d-block mb-3">
						<h5 class="mb-4 countorderproducttotal">Order Items (2)</h5>
						<ul
							class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4" id="appendeddatacheckout">
							<%-- <c:if test="${!empty productList}">
								<c:forEach var="var" items="${productList }">
									<li class="list-group-item" id="appendeddatacheckout">
									
										<div class="row align-items-center">
											<div class="col-3">
												<!-- Image -->
<a href="./shop.html"> <img src="${pageContext.request.contextPath}/resources/upload_file/${var.filesretrieve[0]}"alt="img" class="img-fluid"></a>
											</div>
											<div class="col d-flex align-items-center">
												<div class="cart_single_caption pl-2">
													<h6 class="product_title fs-md ft-medium mb-1 lh-1">Women
														Striped Shirt Dress</h6>
													<p class="mb-1 lh-1">
														<span class="text-dark">Size: ${var.sizes }</span>
													</p>
													<p class="mb-3 lh-1">
														<span class="text-dark">Color: Blue</span>
													</p>
													<h6 class="fs-md ft-medium mb-3 lh-1">MRP: ${var.price }/-</h6>
												</div>
											</div>
										</div>
									</li>
								</c:forEach>
							</c:if>

 --%>
						</ul>
					</div>
					<div class="card">
						<div class="card-header card_bg">
							<h5 class="fw-bold">Cart totals</h5>
						</div>
						<div class="card-body" id="amountdetails">
								<%-- <ul class="list-group  list-group-flush-x">
								<li class="list-group-item d-flex"><span>Subtotal</span> <span
									class="ms-auto fw-bold"> ${total}</span></li>
								<li class="list-group-item d-flex"><span>Tax</span> <span class="ms-auto fw-bold">${Tax}</span></li>
								<li class="list-group-item d-flex"><span class="fw-bold">Total</span><span class="ms-auto fw-bold"> MRP ${subtotal }</span></li>
							</ul> --%>
						</div>
					</div>
					<div>
						<button href="#" class="btn btn_Checkout btn-block btn-dark mb-5 mt-3" id="placeorder">Place
							Your Order</button>
					</div>
				</div>
			</div>
			
		</div>
	</section>
	<%@include file="footer.jsp"%>
	<%--  <script src="${pageContext.request.contextPath}/resources/js/state.js"
		type="text/javascript"></script> --%>
		<script src="${pageContext.request.contextPath}/resources/js/fileHandling.js"
		type="text/javascript"></script>
		
		
	<%--	<script type="text/javascript">
		function funcabc(id){
			var vall=$('input[name="flexRadioDefault"]:checked').val();		
			$("#placeorder").click(function(){
				alert("Your Order Is Place Your Address :: ");
				 // call ajax 
					$.ajax({
					type : 'GET',
					url : '/api/test/bookproduct',
					success : function(data) {

						if ($.isEmptyObject(data['message'])) {
						
							$("#mainaddressbody").addClass(
									"d-none");
						} else {
											
							arr = data["message"];
							console.log(arr);
					
							
							
						}
						

					},
					error : function(data) {
						console.log("error");
						console.log(data);
					}

				});
				//$('#placeorder').prop('disabled', true)
			});


			}
		</script>
		 --%>
		
		
		
		
		
		
		
		
		
		<script src="${pageContext.request.contextPath}/resources/js/check-out.js"
		type="text/javascript"></script>
		
</body>
</html>