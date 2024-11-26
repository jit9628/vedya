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

			/*=====delete adderess=====*/

			/*	$(".deleteaddress").click(function(event) {
						
					var values = $("#addid").text();
					alert(values);
	
	
				})*/


			$(".editbutton").click(function() {


			});
			/*=================AJAX CALL========*/
			$("#adderessform")
				.click(
					function() {

						var firstname = $("#firstname")
							.val();
						var lastname = $("#lastname")
							.val();
						var email = $("#email").val();
						var localadderess = $(
							"#localadderess").val();
						var country = $("#country")
							.val();

						var city = $("#city").val();
						var postalcode = $(
							"#postalcode").val();
						var mobilenumber = $(
							"#mobilenumber").val();
						var additionalinfo = $(
							"#additionalinfo")
							.val();

						event.preventDefault();
						$
							.ajax({
								url: '/api/test/saveAdderess',
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
										"mobilenumber": mobilenumber,
										"additionalinfo": additionalinfo
									}),
								success: function(
									data,
									textStatus,
									xhr) {

									successMessage();

									window.location.href = "/api/auth/userdashboard";
									//window.locatiom.replace("/api/auth/userdashboard");
									/*=== get adderess====*/

									// getAllAdderess();

								},
								error: function(
									xhr,
									textStatus,
									errorThrown) {

									if (xhr["status"] == 409) {

										failureMessage(xhr["responseJSON"].message);
									}
								}, complete: function(xhr,
									textStatus,
									errorThrown) {
									//	window.locatiom.replace("/api/auth/userdashboard");

								}
							});
					});

			/*======== delete address after clicked crosss icons ======*/


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
			'<button type="button"class="border p-3 circle text-dark d-inline-flex align-items-center justify-content-center editbutton" onclick="deleteAdr()">' +
			'<i class="fas fa-pen-nib position-absolute"></i>' +
			'</button>' +
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

function deleteAdrr(id) {

	$.ajax({
		type: 'GET',
		url: '/api/user/deleteAddress/'+id,
		success: function(data) {
if(data['statusCode']==200){
	
}
if(data['statusCode']==226){
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
		timer: 1500
	})

}
function failureMessage(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'warning',
		title: msg,
		showConfirmButton: false,
		timer: 1500
	})

}
/*
function funcabc(id) {
	var vall = $('input[name="flexRadioDefault"]:checked').val();

	var totalprice = $(".totalprice").text();
	$("#placeorder").click(function() {
	
		// call ajax 
		$.ajax({
			type: 'GET',
			url: '/api/user/bookproduct?adrid=' + vall,
			success: function(data) {

				if ($.isEmptyObject(data['message'])) {

					$("#mainaddressbody").addClass(
						"d-none");
				} else {

					arr = data["message"];


					OrderSuccessMessageResponse(data["successResponse"]);


				}
				window.location.replace("/api/auth/userdashboard");
			},
			error: function(data) {
				console.log(data);
			}

		});
		//$('#placeorder').prop('disabled', true)
	});


}
*/

/*remove content */


function remove_order_detail_List() {

	$("v-pills-tabContent").on('load', () => {

		// $(this).empty();
	});

}










function OrderSuccessMessageResponse(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'success',
		title: msg,
		showConfirmButton: false,
		timer: 10000

	})
	window.location.replace("/api/auth/userdashboard");
}













/* function  getAllAdderess(){
	$.ajax({
		type : 'GET',
		url : '/api/test/getAdderess',
		success : function(data) {

			if ($.isEmptyObject(data['message'])) {
			
				$("#mainaddressbody").addClass(
						"d-none");
			} else {
								
				arr = data["message"];
				console.log(arr);
				arr.forEach(myFunction2);
			}
			

		},
		error : function(data) {
			console.log("error");
			console.log(data);
		}

	});
	
}	 */


