<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<h5 class="modal-title" id="staticBackdropLabel">Logging Out</h5>
					<p>Are you sure you want to log out?</p>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
					<div class="button-box">
						<form action="#">
							<button type="button" class="btn">
								<a href="/api/auth/logout" class="btn  btn--yes btn-primary">Yes</a>
							</button>
						</form>
						<button type="button" class="btn btn--no" data-bs-dismiss="modal">No</button>

					</div>
				</div>
			</div>
		</div>
	</div>




	<div class="modal fade" id="updateordermodal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<h5 class="modal-title" id="staticBackdropLabel">Update Order Status</h5>
					<select class="form-select" aria-label="Default select example" id="selectupdatecontent">
						<option selected>-- Select Order Status --</option>
						<option value="Dispatch">Dispatch</option>
						<option value="Delivered">Delivered</option>
					
					</select>

					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
					<div class="button-box">
						<form action="#">
							<button type="button" class="btn">
								<a href="javascript:void(0)" class="btn  btn--yes btn-primary" onclick="statusUpdate()" id="statusUpdate">Update</a>
							</button>
						</form>
						<button type="button" class="btn btn--no" data-bs-dismiss="modal">Cancel</button>

					</div>
				</div>
			</div>
		</div>
	</div>





	<!-- Delete Modal Box Start -->
	<div class="modal fade theme-modal remove-coupon"
		id="exampleModalToggle" aria-hidden="true" tabindex="-1">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header d-block text-center">
					<h5 class="modal-title w-100" id="exampleModalLabel22">Are You
						Sure ?</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="fas fa-times"></i>
					</button>
				</div>
				<div class="modal-body">
					<div class="remove-box">
						<p>The permission for the use/group, preview is inherited from
							the object, object will create a new permission for this object</p>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-animation btn-md fw-bold"
						data-bs-dismiss="modal">No</button>
					<button type="button" class="btn btn-animation btn-md fw-bold"
						data-bs-target="#exampleModalToggle2" data-bs-toggle="modal"
						data-bs-dismiss="modal" onclick="deleteElement()">yes</button>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade theme-modal remove-coupon"
		id="exampleModalToggle2" aria-hidden="true" tabindex="-1">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center" id="exampleModalLabel12">Done!</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="fas fa-times"></i>
					</button>
				</div>
				<div class="modal-body">
					<div class="remove-box text-center">
						<div class="wrapper">
							<svg class="checkmark" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 52 52">
                                <circle class="checkmark__circle"
									cx="26" cy="26" r="25" fill="none" />
                                <path class="checkmark__check"
									fill="none" d="M14.1 27.2l7.1 7.2 16.7-16.8" />
                            </svg>
						</div>
						<h4 class="text-content">It's Removed.</h4>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" data-bs-toggle="modal"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
</body>
</html>