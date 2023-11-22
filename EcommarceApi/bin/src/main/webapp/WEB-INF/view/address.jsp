<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row align-items-start">

		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
			<div class="form-group">
				<button class="btn borders full-width " id="showform">
					<i class="fas fa-plus me-2"></i>Add New Address
				</button>
			</div>
		</div>


	</div>
	<div class="col-12 col-lg-12 col-md-12 d-none" id="showformopen">
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
											<!-- 	<select
												class="form-select" aria-label="Default select example"
												id="selection" selected="">
											</select -->
											<input type="text" class="form-control" placeholder="country"
												name="country" id="country">
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
							</div>
							
</body>
</html>