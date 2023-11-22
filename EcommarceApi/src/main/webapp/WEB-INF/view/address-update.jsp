
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp"%>
<!-- <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css"> -->

</head>
<body>
	<%@ include file="header.jsp"%>
	<section class="mb-5">
		<div class="container">

			<div class="row">
				<div class="col-12 col-lg-12 col-md-12" id="showformopen">
					<form class="border rounded mb-4 p-4 mt-5" id="myForm">
						<h5 class="mb-4 ft-medium">Billing Details</h5>
						<span class="d-none" id="idd">${updateaddress.getId() }</span>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">First Name *</label> <input
									type="text" class="form-control" placeholder="First name"
									name="firstname" id="firstname"
									value="${updateaddress.getFirstname() }"> <span
									id="first"> </span>
							</div>
							<div class="col">
								<label class="form-label">Last Name *</label> <input type="text"
									class="form-control" placeholder="Last name" name="lastname"
									id="lastname" value="${updateaddress.getLastname() }">
								<span id="second"> </span>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Email *</label> <input type="email"
									class="form-control" placeholder="Email" name="email"
									id="email" value="${updateaddress.getEmail() }"> <span
									id="third"> </span>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Address*</label> <input type="text"
									class="form-control" placeholder="Address" name="localadderess"
									id="localadderess" value="${updateaddress.getLocaladderess() }">
								<span id="fourth"> </span>
							</div>
						</div>

						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Country *</label>
								<!-- 	<select
												class="form-select" aria-label="Default select example"
												id="selection" selected="">
											</select -->
								<input type="text" class="form-control" placeholder="country"
									name="country" id="country"
									value="${updateaddress.getCountry() }"> <span id="five">
								</span>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">City / Town *</label>
								<!-- <select
												class="form-select" aria-label="Default select example"
												id="cityselection" selected="">
											</select> -->

								<input type="text" class="form-control" placeholder="city"
									name="city" id="city" value="${updateaddress.getCity() }">
								<span id="six"> </span>
							</div>
							<div class="col">
								<label class="form-label">ZIP / Postcode *</label> <input
									type="number" class="form-control"
									placeholder="ZIP / Postcode *" name="postalcode"
									id="postalcode" value="${updateaddress.getPostalcode() }">
								<span id="seven"> </span>

							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Mobile Number *</label> <input
									type="text" class="form-control" placeholder="Mobile Number"
									name="mobilenumber" id="contact"
									value="${updateaddress.getMobilenumber() }"> <span
									id="eight"> </span>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Additional Information</label>
								<textarea class="form-control" rows="3" name="additionalinfo"
									id="additionalinfo"
									value="${updateaddress.getAdditionalinfo() }"></textarea>
								<span id="nine"> </span>

							</div>
						</div>
						<button class="btn borders full-width" id="adderessformupdate">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</section>
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
	<%@ include file="footer.jsp"%>
	
	

<script src="${pageContext.request.contextPath}/resources/js/updateAddress.js"
		type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/responseMessage.js"
		type="text/javascript"></script>
</body>
</html>