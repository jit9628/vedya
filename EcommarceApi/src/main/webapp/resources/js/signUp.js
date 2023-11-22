

$("#saveRegisterDetail").submit(function(event) {
	event.preventDefault(); // Prevent default form submission
	var firstname = $("#firstname")
		.val();
	var lastname = $("#lastname")
		.val();
	var email = $("#email").val();
	var mobile = $("#mobile").val();
	var password = $("#password")
		.val();
	var cpassword = $("#cpassword")
		.val();

	// Validate the form
	if (validateForm()) {
		// If the form is valid, send it via AJAX
		alert("success");
		$.ajax({
			url: '/api/auth/signup',
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
					"mobile": mobile,
					"password": password
				}),
			success: function(
				data,
				textStatus,
				xhr) {
				console.log(data);
				if (data["status"] == 200) {
					alert(data["message"]);
					console
						.log("You Have Logger In ");
					//	successMessage("Your Account Is Created");
					successResponseMessage("Your Account Is Created");
					window.setTimeout(sendLogInPage, 5000);
				}

				if (data["status"] == 202) {
					alert(data["message"]);
					$("#five").text("please fill password");
					$("#five").addClass("text-danger");
				}
			},
			error: function(
				xhr,
				textStatus,
				errorThrown) {
					alert(data["message"]);
				//	console.log(xhr['responseJSON'].status);
				if (xhr['responseJSON'].status == 409) {

					FailureMessage(xhr['responseJSON'].message);
				}


			}
		});
	}
});
/*==validate all fields ========== */
function validateForm() {
	var isValid = true;

	// Validate the name field (you can add more validations here)

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

	if (email.trim() === "") {
		isValid = false;
		$("#third").text("please fill email");
		$("#third").addClass("text-danger");
		$("#email")
			.addClass("border border-danger");
	} else if (!isValidEmail(email)) {
		isValid = false;
		$("#third").text();
		$("#third").text("please fill is Valid Email");
		$("#third").addClass("text-danger");
		$("#email")
			.addClass("border border-danger");
	} else {

		$("#third").text("");
		$("#email").removeClass("border border-danger");
		$("#email").addClass("border border-success");

	}
	if (mobile.trim() === "") {
		isValid = false;
		$("#four").text("please fill number");
		$("#four").addClass("text-danger");
		$("#mobile")
			.addClass("border border-danger");
	}
	else if (!validateMobile()) {
		isValid = false;
		$("#four").text("please fill valid phone number");
		$("#four").addClass("text-danger");
		$("#mobile")
			.addClass("border border-danger");
	}
	else {
		$("#four").text("");
		$("#mobile").removeClass(
			"border border-danger");
		$("#mobile")
			.addClass("border border-success");

	}
	return isValid;
}
/*====validate Email=======*/
function isValidEmail(email) {
	//	var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var validRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

	return validRegex.test(email);
}
/*====validate mobile number===*/
function validateMobile() {
	var mobileNumbers = $("#contact").val();
	// Define a regular expression for a valid mobile number format
	var mobileRegex = /^[0-9]{10}$/;
	return mobileRegex.test(mobileNumbers);
}

/*====validate mobile number===*/
function validatePostalCode() {
	var postalcodes = $("#postalcode").val();
	// Define a regular expression for a valid mobile number format
	var postalcodeRegex = /^[0-9]{6}$/;
	return postalcodeRegex.test(postalcodes);
}
