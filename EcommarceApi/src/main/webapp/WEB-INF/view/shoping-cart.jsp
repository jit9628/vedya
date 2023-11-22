<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title }</title>
<%@ include file="links.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<section>
		<div class="container">
			<div class="shopping_cart_heading text-center my-5">
				<h4>Shopping Cart</h4>
			</div>
			<div class="row justify-content-between">

				<div class="col-12 col-lg-7 col-md-12">
					<ul
						class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4" id="appendeddata">
						<%-- <c:if test="${!empty productList}">
							<c:forEach var="var" items="${productList }"> --%>
							<!-- 	<li class="list-group-item"> -->
								
								<%-- 	<div class="row align-items-center">
										<div class="col-3">
											<!-- Image -->
											<a href="./product-detail.html"> <img
												src="${pageContext.request.contextPath}/resources/upload_file/${var.filesretrieve[0]}"
												alt="img" class="img-fluid"></a>
										</div>
										<div
											class="col d-flex align-items-center justify-content-between">
											<div class="pl-2">
												<h4 class="mb-1">${var.productname }</h4>
					<p class="mb-1"><span class="text-dark"> ${var.sizes } </span></p>
												<p class="mb-3">
													<span class="text-dark">Color: Blue</span>
												</p>
												<h4 class="fs-md ft-medium mb-3 lh-1">MRP: ${var.price }/-</h4>
												<!-- <select class="mb-2 custom-select w-auto">
												<option value="1" selected="">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
											</select> -->
											</div>
											<div class="fls_last">
<button class="close_slide gray removecart" id="removecart"><i class="fa-solid fa-xmark fs-6"> <span class="d-none valuessid" id="valuesid">${var.pid }</span>
													</i>

												</button>

											</div>
										</div>
									</div>  --%>
								<!-- </li> -->



					</ul>
				</div>
				<div class="col-12 col-md-12 col-lg-4">
					<div class="card">
						<div class="card-header card_bg">
							<h5 class="fw-bold">Cart totals</h5>
						</div>
						<div class="card-body" id="amountdetails">
						<%-- 	<ul class="list-group  list-group-flush-x">
								<li class="list-group-item d-flex"><span>Subtotal</span> <span
									class="ms-auto fw-bold"> ${total}</span></li>
								<li class="list-group-item d-flex"><span>Tax</span> <span
									class="ms-auto fw-bold">${Tax}</span></li>
								<li class="list-group-item d-flex"><span class="fw-bold">Total</span>
									<span class="ms-auto fw-bold"> MRP ${subtotal }</span></li>
							</ul> --%>
						</div>

					</div>
					<div>
						<a href="/api/test/check-out" class="btn btn_Checkout btn-block btn-dark mb-5 mt-3"
							id="disableval">Proceed to Checkout </a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="footer.jsp"%>



	<!-- 	</script>	<script type="text/javascript">
		$(document).ready(function() {

		
		});
	</script> -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="${pageContext.request.contextPath}/resources/js/post.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/shoping-cart.js"
		type="text/javascript"></script>


</body>
</html>
