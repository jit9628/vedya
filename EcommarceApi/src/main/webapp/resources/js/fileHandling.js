$(document)
	.ready(
		function(e) {
			remove_order_detail_List();
			/*====load adderess details ======*/
			$.ajax({
				type: 'GET',
				url: '/api/test/getAdderess',
				success: function(data) {
					if ($.isEmptyObject(data['message'])) {
						$("#mainaddressbody").addClass(
							"d-none");
					} else {

						arr = data["message"];
						//console.log(arr);
						arr.forEach(appendAddress);
					}
				},
				error: function(data) {
					//console.log("error");
					//console.log(data);
				},
				complete: function() {

				}

			});

			$('#imageUploadForm')
				.on(
					'submit',
					(function(e) {
						e.preventDefault();
						var formData = new FormData(
							this);
						$
							.ajax({
								type: 'POST',
								url: $(this).attr(
									'action'),
								data: formData,
								cache: false,
								contentType: false,
								processData: false,
								success: function(
									data) {


									window.location
										.replace("/api/auth/userdashboard");
								},
								error: function(
									data) {

								}
							});
					}));

			$("#edit-avatar").on("change", function() {
				/*$("id").attr("src","")*/
				$("#imageUploadForm").submit();

			});

			$("#showform").click(function() {
				if ($("#showformopen").hasClass("d-none")) {
					$("#showformopen").removeClass("d-none");
				} else {
					$("#showformopen").addClass("d-none");
				}
			});




			$(".editbutton").click(function() {


			});

		});

function appendAddress(v, i, a) {
	var ids = v.id;



	/* $("#listofaddress")
	.append('<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 d-flex" id="mainaddressbody"> </div>'); */
	$("#mainaddressbody")
		.append(
			'<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6" id="mainaddressbody"> <div class="card-wrap border rounded mb-4"> <div class="px-3 py-2 br-bottom d-flex align-items-center justify-content-between">'
			+ '<div> <h4 class="fs-md ft-bold mb-2">Shipping Address</h4><p class="m-0 p-0"><span class="text-success bg-light-success small ft-medium px-2 py-1">' + v.accounttype + '</span></p></div>'
			+ '<div>' +
			'<a href="/api/page/updateAddress/' + ids + '" type="button"class="border p-3 me-2 circle text-dark d-inline-flex align-items-center justify-content-center editbutton" >' +
			'<i class="fas fa-pen-nib position-absolute"></i>' +
			'</a>' +
			'<button type="button" class="border bg-white text-danger p-3 circle text-dark d-inline-flex align-items-center justify-content-center removeadr"onclick="deleteAdrr(' + ids + ')">' +
			'<span id="addid" class="add d-none">'
			+ ids
			+ '</span><i class="fas fa-times position-absolute"></i></button></div></div><div class="card-wrap-body px-3 py-3"> FullName: <span id="fullname : ">'
			+ v.firstname
			+ ' '
			+ v.lastname
			+ '</span>' +
			' <p>Address : <span id="fulladderess">' + v.localadderess + ' ' + "  ,  " + ' ' + v.city + '</span><span id="cities"></span><span id="countries">' + " , " + '' + v.country + '</span></p> <p class="lh-1 text-dark ">Email: <span id="mailid">' + v.email + '</span></p><p class="text-dark "> Call: <span id="mobilenumber">' + v.mobilenumber + '</span></p>' +
			'<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"  value="' + ids + '"  onclick="funcabc(' + ids + ')" ></div></div></div>' +
			'');

}


function editAdr(id) {



	/*$.ajax({
		type: 'GET',
		url: '/api/page/updateAddress/' + id,
		success: function(data) {
			console.log("Address Data Are :: "+data['message']['firstname']);
			var firstname=data['message']['firstname'];
			var lastname=data['message']['lastname'];
			var email=data['message']['email'];
			var mobilenumber=data['message']['mobilenumber'];
			
			var localadderess=data['message']['localadderess'];
			var country=data['message']['country'];
			var postalcode=data['message']['postalcode'];
			var city=data['message']['city'];
			var additionalinfo=data['message']['additionalinfo'];
			
			if ($("#showformopen1").hasClass("d-none")) {
		$("#showformopen1").removeClass("d-none");
		$('input[name="firstname"]').val(firstname);
		$('input[name="lastname"]').val(lastname);
		$('input[name="email"]').val(email);
		$('input[name="localadderess"]').val(localadderess);
		$('input[name="country"]').val(country);
		$('input[name="postalcode"]').val(postalcode);
		$('input[name="mobilenumber"]').val(mobilenumber);
			$('input[name="city"]').val(city);
		
	} else {
		$("#showformopen1").addClass("d-none");
	}
	
	
		},
		error: function(data) {
			console.log(data);
		},
		complete: function() {
	
		}
	});*/



}
function deleteAdrr(id) {

	$.ajax({
		type: 'GET',
		url: '/api/user/deleteAddress/' + id,
		success: function(data) {
			if (data['statusCode'] == 200) {
				successMessagedel();
			}
			if (data['statusCode'] == 226) {
				alert(data['message']);
			}
		},
		error: function(data) {
			console.log(data);
		},
		complete: function() {
			window.location.href = "/api/auth/userdashboard";
		}
	});
}






function successMessage() {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'success',
		title: 'Add Your Adderess',
		showConfirmButton: false,
		timer: 6000
	})

}
function successMessagedel() {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'success',
		title: ' Your Adderess delete',
		showConfirmButton: false,
		timer: 6000
	})

}
function failureMessage(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'warning',
		title: msg,
		showConfirmButton: false,
		timer: 6000
	})

}

function funcabc(id) {
	var vall = $('input[name="flexRadioDefault"]:checked').val();
	alert("address id "+vall);
	var totalprice = $(".totalprice").text();
	$("#placeorder").click(function() {
		/*alert("Your Order Is Place Your Address :: ");*/
		// call ajax 
		$.ajax({
			type: 'GET',
			url: '/api/user/bookproduct?adrid=' + vall,
			success: function(data) {

				/*if ($.isEmptyObject(data['message'])) {

					$("#mainaddressbody").addClass(
						"d-none");
					OrderSuccessMessageResponse(data["successResponse"]);
					window.location.replace("/api/auth/userdashboard");
				} else {
					arr = data["message"];
					OrderSuccessMessageResponse(data["successResponse"]);

				}*/
				OrderSuccessMessageResponse(data["successResponse"]);
				//	window.location.replace("/api/auth/userdashboard");
			},
			error: function(data) {
				
				console.log(data);
			}

		});
		//$('#placeorder').prop('disabled', true)
	});


}

/*=== cjeck address is select or not =======*/

$("#placeorder").click(function() {
	alert("Order Placed ..");
	const today = new Date();
	const nextThreeDays = new Date(today.setDate(today.getDate() + 3));
	console.log(nextThreeDays);
	var dates = convert(nextThreeDays.toString);
	//alert(dates);
	//console.log(dates);
	var vall = $('input[name="flexRadioDefault"]:checked').val();
	
	if (vall == undefined) {
		orderFailureResponse("Please Select Addressss");
	}

});

/*remove content */


function remove_order_detail_List() {

	$("v-pills-tabContent").on('load', () => {

		// $(this).empty();
	});

}

function convert(str) {
	var date = new Date(str),
		mnth = ("0" + (date.getMonth() + 1)).slice(-2),
		day = ("0" + date.getDate()).slice(-2);
	return [date.getFullYear(), mnth, day].join("-");
}





function OrderSuccessMessageResponse(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'success',
		title: msg,
		showConfirmButton: false,
		timer: 300000

	})
	setInterval(function() { window.location.replace("/api/auth/userdashboard") }, 1000);

	//window.location.replace("/api/auth/userdashboard");
}

function orderFailureResponse(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'error',
		title: msg,
		showConfirmButton: false,
		timer: 3000

	})
	setInterval(function() { window.location.replace("/api/auth/userdashboard") }, 1000)

}
