$(document).ready(function() {

	orderList();
});

/*====================== loading order details ========== */
function orderList() {
	$.ajax({
		type: 'GET',
		url: '/api/user/my-order',
		success: function(data) {

			bookingDetailarray = data["bookingDetail"];
			//console.log("products :: "+arr[0].bid);
			//arr2=data["CategoryDatalist"];
			//arr2.forEach(categoryLists);
			bookingDetailarray.forEach(loadOrderDetails);
		},
		error: function(data) {


		},
		complete: function(data) {

		}
	});
}


function loadOrderDetails(v, i, a) {
/*var elements = "<div>name 1";
if(v.remark == "Delivered") {    
  elements += 
    "<a href='#'>" +
      "<div id='add'>Add</div>" +
    "</a>";
}
elements += "<div>Available</div>";
elements += "</div>";
	
	$("#v-pills-tabContent")
		.append(elements);*/
	
	
	
	

	$("#v-pills-tabContent")
		.append(
			'<div class="tab-pane fade show active my_order border mb-4 mfliud" id="my-order" role="tabpanel" tabindex="0">' +
			'<div class="gray d-flex align-items-center justify-content-between px-3 py-3">' +
			'<div><p class="m-0 p-0"><span class="text-muted">Order Number</span></p>' +
			'<h6 class="mb-0 ft-medium">#' + v.order_booking_id + '</h6>' +
			'</div>' +
			'<div><a href="javascript:void(0);" class="btn btn-sm btn-dark">TrackOrder</a></div>' +
			'</div>' +
			'<div class="text-left">' +
			'<div class="row align-items-center justify-content-center m-0 py-4 br-bottom">' +
			'<div class="col-xl-5 col-lg-5 col-md-5 col-12">' +
			'<div class="d-flex align-items-start">' +
			'<a href="javascript:void(0)">' +
			'<img src="/resources/upload_file/' + v.orderimages + '"width="75" class="img-fluid rounded" alt="img">' +
			'</a>' +
			'<div class="ps-3"><p class="mb-0"><span class="text-muted small">Dresses</span></p>' +
			'<h4 class="product_title fs-sm ft-medium mb-1 lh-1">' + v.productname + '</h4>' +
			'<p class="mb-2"><span class="text-dark medium">Size: 36</span>, <span class="text-dark medium">Color: Red</span></p>' +
			'<h4 class="fs-sm ft-bold mb-0 lh-1">MRP: ' + v.price + '/-</h4>' +
			'</div>' +
			'</div>' +
			'</div>' +
			'<div class="col-xl-3 col-lg-3 col-md-3 col-6">' +
			'<p class="mb-1 p-0">' +
			'<span class="text-muted">Status</span>' +
			'</p>' +
			'<div>' +
			'<span class="ft-medium small text-warning bg-light-warning rounded px-3 py-1">' + v.remark + '</span>' +
			'</div>' +
			'</div>' +
			'<div class="col-xl-4 col-lg-4 col-md-4 col-6">' +
			'<p class="mb-1 p-0">' +
			'<span class="text-muted">Expected date by:</span>' +
			'</p>' +
			'<h6 class="mb-0 ft-medium fs-sm">22 September 2021</h6>' +
			'</div>' +
			'</div>' +
			'<div class="d-flex align-items-center justify-content-between br-top px-3">' +
			'<div class="col-xl-3 col-lg-3 col-md-4 olf_flex text-left px-0 py-2 br-right">' +
			
			'<a href="javascript:void(0)" class="ft-medium fs-sm" onclick="cancelOrder(' + v.bid + ')"><i class="fa-solid fa-xmark me-2"></i>Cancel Order' +
			'</a>' +
			'</div>' +
			'<div class="col-xl-9 col-lg-9 col-md-8 pr-0 py-2 olf_flex d-flex align-items-center justify-content-between ps-3">' +
			'<div class="olf_flex_inner hide_mob">' +
			'<p class="m-0 p-0"><span class="text-muted medium"></span>' +
			'</p>' +
			'</div>' +
			'<div class="olf_inner_right">' +
			'<h5 class="mb-0 fs-sm ft-bold">' +
			'<strong>MRP: ' + v.price + '/-</strong>' +
			'</h5>' +
			'</div>' +
			'</div>' +
			'</div>' +
			'</div>' +
			'</div>'
		);




}


/*================== load Order ajax function list=========== */



/*function categoryLists(v,i,a){
	//console.log(v);
}*/


$("#clicked").click(function() {
	$("#clicked").addClass("show");
	$("#appendcategorylist").addClass("show");
});


/*================ Order Cancel ======================= */

function cancelOrder(orderid) {
	$.ajax({
		type: "GET",
		url: "/api/user/cancelorder?bid=" + orderid,
		success: function(data) {

			if (data["statusCode"] == 200) {
				succssMessage(data["message"]);
			}
			if (data["statusCode"] == 226) {
				failure(data["message"]);
			}
			//window.location.replace("/api/auth/userdashboard")


		},
		error: function(data) {

			if (data["status"] == 451) {
				failure("This Product Is Allready Delivered Your Destination Adderess ..");
			}

		}
	})
}

/*================ Response Message ======================= */
function succssMessage(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'success',
		title: msg,
		showConfirmButton: true,
		timer: 300000,
		width: 500

	})
	setInterval(function() { window.location.replace("/api/auth/userdashboard") }, 1000)

}

function failure(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'warning',
		title: msg,
		showConfirmButton: true,
		timer: 300000,
		width: 500,
		height: 500

	})
	setInterval(function() { window.location.replace("/api/auth/userdashboard") }, 1000)
	//window.location.replace("/api/auth/userdashboard")
}




