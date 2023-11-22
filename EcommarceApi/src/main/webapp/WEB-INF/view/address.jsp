<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css"> -->

</head>
<body>

	<div class="row align-items-start">

		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
			<div class="form-group">
				<button class="btn borders full-width mb-4 " id="showform">
					<i class="fas fa-plus me-2"></i>Add New Address
				</button>
			</div>
		</div>
	</div>
	<div class="col-12 col-lg-12 col-md-12 d-none" id="showformopen">
		<form class="border rounded mb-4 p-4 mt-5" id="myFormSave">
			<h5 class="mb-4 ft-medium">Billing Details</h5>
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">First Name *</label> <input type="text"
						class="form-control" placeholder="First name" name="firstname"
						id="firstname"> <span id="first"> </span>
				</div>
				<div class="col">
					<label class="form-label">Last Name *</label> <input type="text"
						class="form-control" placeholder="Last name" name="lastname"
						id="lastname"> <span id="second"> </span>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Email *</label> <input type="text"
						class="form-control" placeholder="Email" name="email" id="email">
					<span id="third"> </span>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Address*</label> <input type="text"
						class="form-control" placeholder="Address" name="localadderess"
						id="localadderess"> <span id="fourth"> </span>
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
						name="country" id="country"> <span id="five"> </span>
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
						name="city" id="city"> <span id="six"> </span>
				</div>
				<div class="col">
					<label class="form-label">ZIP / Postcode *</label> <input
						type="text" class="form-control" placeholder="ZIP / Postcode *"
						name="postalcode" id="postalcode"> <span id="seven">
					</span>

				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Mobile Number *</label> <input
						type="text" class="form-control" placeholder="Mobile Number" 
						name="mobilenumber"  id="contact" > <span id="eight">
					</span>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Additional Information</label>
					<textarea class="form-control" rows="3" name="additionalinfo"
						id="additionalinfo"></textarea>
					<span id="nine"> </span>

				</div>
			</div>
			<button class="btn borders full-width" id="adderessform">Submit</button>
		</form>
	</div>
	<!-- <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/add-address.js"
		type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/js/responseMessage.js"
		type="text/javascript"></script>
</body>
</html>