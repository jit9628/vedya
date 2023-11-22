/*$("#adderessformupdate")
	.click(
		function() {
			alert("updated here..");
			event.preventDefault();

			var validRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

			var firstname = $("#firstname").val();
			var lastname = $("#lastname").val();
			var email = $("#email").val();
			var localadderess = $("#localadderess").val();
			var country = $("#country").val();

			var city = $("#city").val();
			var postalcode = $("#postalcode").val();
			var contactnumber = $("#contact").val();
			var additionalinfo = $("#additionalinfo").val();

			if (firstname == "" || firstname == null) {
				$("#first").text("please fill Firstname");
				$("#first").addClass("text-danger");
				$("#firstname")
					.addClass("border border-danger");

			} else {

				$("#first").text("");
				$("#firstname").removeClass(
					"border border-danger");
				$("#firstname").addClass(
					"border border-success");

			}

			if (lastname == "" || lastname == null) {

				$("#second").text("please fill lastname");
				$("#second").addClass("text-danger");
				$("#lastname").addClass("border border-danger");

			} else {
				$("#second").text("");
				$("#lastname").removeClass(
					"border border-danger");
				$("#lastname")
					.addClass("border border-success");
			}

			if (email == "" || email == null) {

				$("#third").text("please fill Valid email");
				$("#third").addClass("text-danger");
				$("#email").addClass("border border-danger");

			} else {
				$("#third").text("");
				$("#third").removeClass("text-danger");
				$("#email").removeClass("border border-danger");
			}

			if (email.match(validRegex)) {

				$("#third").text("");
				$("#email").addClass("border border-success");
			} else {
				$("#third").text("Email Invalid");
				$("#third").addClass("text-danger");
				$("#email").addClass("border border-danger");

			}
			if (localadderess == "" || localadderess == null) {

				$("#fourth").text("please fill localadderess");
				$("#fourth").addClass("text-danger");
				$("#localadderess").addClass(
					"border border-danger");
			} else {
				$("#fourth").text("");
				$("#localadderess").removeClass(
					"border border-danger");
				$("#localadderess").addClass(
					"border border-success");
			}
			if (country == "" || country == null) {
				$("#five").text("please fill country");
				$("#five").addClass("text-danger");
				$("#country").addClass("border border-danger");
			} else {
				$("#five").text("");
				$("#country").removeClass(
					"border border-danger");
				$("#country").addClass("border border-success");
			}
			if (city == "" || city == null) {
				$("#six").text("please fill city");
				$("#six").addClass("text-danger");
				$("#city").addClass("border border-danger");
			} else {
				$("#six").text("");
				$("#city").removeClass("border border-danger");
				$("#city").addClass("border border-success");
			}
			if (postalcode == "" || postalcode == null) {
				$("#seven").text("please fill postalcode");
				$("#seven").addClass("text-danger");
				$("#postalcode").addClass(
					"border border-danger");
			} else {
				$("#seven").text("");
				$("#postalcode").removeClass(
					"border border-danger");
				$("#postalcode").addClass(
					"border border-success");

				$
					.ajax({
						url: '/api/test/editAddress/'+ $("#idd").text(),
						type: 'POST',
						dataType: 'json',
						contentType: "application/json",
						headers: {
							'Accept': 'application/json',
							'Content-Type': 'application/json'
						},
						data: JSON
							.stringify({
								"firstname": firstname,
								"lastname": lastname,
								"email": email,
								"localadderess": localadderess,
								"country": country,
								"city": city,
								"postalcode": postalcode,
								"mobilenumber": contactnumber,
								"additionalinfo": additionalinfo
							}),
						success: function(data,
							textStatus, xhr) {


							if (data['message'] == "Please Fill Mobile Number") {
								$("#eight")
									.text(
										"please fill Mobile Number");
								$("#eight").addClass(
									"text-danger");
								$("#mobilenumber")
									.addClass(
										"border border-danger");
							} else {
													
												}

							else if (data['message'] == "valid mobile number") {
								$("#eight").text("");
								$("#mobilenumber")
										.removeClass(
												"border border-danger");
								$("#mobilenumber")
										.addClass(
												"border border-success");

								successMessage();

								window.location.href = "/api/auth/userdashboard";
							} 
							
							else {
								$("#eight").text("");
								$("#mobilenumber")
									.removeClass(
										"border border-danger");
								$("#mobilenumber")
									.addClass(
										"border border-success");

								successMessageupdate();

								window.location.href = "/api/auth/userdashboard";
							}
if(data['statuscode']==200){
	alert("2052");
}
if(data['statuscode']==202){
	alert("202");
}





						},
						error: function(xhr, textStatus,
							errorThrown) {

							if (xhr["status"] == 409) {

								//	failureMessage("Please Fill All Details");
							}
						},
						complete: function(xhr,
							textStatus, errorThrown) {
							//	window.locatiom.replace("/api/auth/userdashboard");

						}
					});
			}

		});
		

		function successMessageupdate() {
			Swal.fire({
				position : 'top-end',
				position : 'center',
				icon : 'success',
				title : ' Your Adderess Is Updated',
				showConfirmButton : false,
				timer : 6000
			})

		}

*/





$("#myForm").submit(function(event) {
	event.preventDefault(); // Prevent default form submission
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var email = $("#email").val();
	var localadderess = $("#localadderess").val();
	var country = $("#country").val();

	var city = $("#city").val();
	var postalcode = $("#postalcode").val();
	var contactnumber = $("#contact").val();
	var additionalinfo = $("#additionalinfo").val();

	// Validate the form
	if (validateForm()) {
		// If the form is valid, send it via AJAX
		alert("success");
		$.ajax({
			url: '/api/test/editAddress/' + $("#idd").text(),
			type: 'POST',
			dataType: 'json',
			contentType: "application/json",
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			/*data: $(this).serialize(),*/
			data: JSON
				.stringify({
					"firstname": firstname,
					"lastname": lastname,
					"email": email,
					"localadderess": localadderess,
					"country": country,
					"city": city,
					"postalcode": postalcode,
					"mobilenumber": contactnumber,
					"additionalinfo": additionalinfo
				}),
			success: function(response) {
				// Handle the successful response here
				successResponseMessage("Your Address Is Updated ..");
				//window.setTimeout(() => { window.location.href = "/api/page/Product-dtl-usr"; }, 4000);
         window.location.href = "/api/test/check-out"; 
				console.log("Form submitted successfully");

			},
			error: function(error) {
				// Handle errors here
				console.error("Form submission error:", error);
			}
		});
	}
});





function validateForm() {
	var isValid = true;

	// Validate the name field (you can add more validations here)
	var firstname = $("#firstname").val();
	if (firstname.trim() === "") {
		isValid = false;
		$("#first").text("please fill Firstname");
		$("#first").addClass("text-danger");
		$("#firstname")
			.addClass("border border-danger");
	} else {

		$("#first").text("");
		$("#firstname").removeClass(
			"border border-danger");
		$("#firstname").addClass(
			"border border-success");

	}

	var lastname = $("#lastname").val();
	if (lastname.trim() === "") {
		isValid = false;
		$("#second").text("please fill Firstname");
		$("#second").addClass("text-danger");
		$("#lastname")
			.addClass("border border-danger");
	}

	else {
		$("#second").text("");
		$("#lastname").removeClass(
			"border border-danger");
		$("#lastname")
			.addClass("border border-success");

	}



	// Validate the email field (you can add more validations here)
	var email = $("#email").val();
	if (email.trim() === "") {
		isValid = false;
		$("#third").text("please fill email");
		$("#third").addClass("text-danger");
		$("#email")
			.addClass("border border-danger");
	} else if (!isValidEmail(email)) {
		isValid = false;
		$("#third").text("please fill is Valid Email");
		$("#third").addClass("text-danger");
		$("#email")
			.addClass("border border-danger");
	} else {


		$("#email").removeClass("border border-danger");
		$("#email").addClass("border border-success");

	}

	var localAddress = $("#localadderess").val();
	if (localAddress.trim() === "") {
		isValid = false;
		$("#fourth").text("please fill Address");
		$("#fourth").addClass("text-danger");
		$("#localAddress")
			.addClass("border border-danger");
	}

	else {
		$("#fourth").text("");
		$("#localAddress").removeClass(
			"border border-danger");
		$("#localAddress")
			.addClass("border border-success");

	}

	var countries = $("#country").val();

	if (countries.trim() === "") {
		isValid = false;
		$("#five").text("please fill country");
		$("#five").addClass("text-danger");
		$("#country")
			.addClass("border border-danger");
	}

	else {
		$("#five").text("");
		$("#country").removeClass(
			"border border-danger");
		$("#country")
			.addClass("border border-success");

	}


	var ct = $("#city").val();

	if (ct.trim() === "") {
		isValid = false;
		$("#six").text("please fill city");
		$("#six").addClass("text-danger");
		$("#city")
			.addClass("border border-danger");
	}

	else {
		$("#six").text("");
		$("#city").removeClass(
			"border border-danger");
		$("#city")
			.addClass("border border-success");

	}


	var zip = $("#postalcode").val();

	if (zip.trim() === "") {
		isValid = false;
		$("#seven").text("please fill city");
		$("#seven").addClass("text-danger");
		$("#postalcode")
			.addClass("border border-danger");
	}

	else {
		$("#seven").text("");
		$("#postalcode").removeClass(
			"border border-danger");
		$("#postalcode")
			.addClass("border border-success");

	}
	var mobile = $("#contact").val();

	if (mobile.trim() === "") {
		isValid = false;
		$("#eight").text("please fill number");
		$("#eight").addClass("text-danger");
		$("#contact")
			.addClass("border border-danger");
	}

	else if (!validateMobile()) {
		isValid = false;
		$("#eight").text("please fill valid phone number");
		$("#eight").addClass("text-danger");
		$("#contact")
			.addClass("border border-danger");



	}

	else {
		$("#eight").text("");
		$("#contact").removeClass(
			"border border-danger");
		$("#contact")
			.addClass("border border-success");

	}
	return isValid;
}

function isValidEmail(email) {
	var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var validRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

	return validRegex.test(email);
}

function validateMobile() {
	var mobileNumbers = $("#contact").val();
	// Define a regular expression for a valid mobile number format
	var mobileRegex = /^[0-9]{10}$/;
	return mobileRegex.test(mobileNumbers);
}















