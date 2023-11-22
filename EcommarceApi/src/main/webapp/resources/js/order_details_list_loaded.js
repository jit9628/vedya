$(document)
	.ready(
		function(e) {
			order_details_list_loaded();
			/*$("#filteringDataValues").click(function() {
				debugger;
				var fd = $("#FD").val();
				var td = $("#TD").val();
				var mark = $("#mark").val();
				//var urls = '/api/test/getFilterDatas/' + fd + '/' + td + '/' + mark;
				var urls = '/api/test/getFilterDatas/2023-08-12/2023-08-18/Dispatch'; 


				$.ajax({
					type: 'GET',
					url: urls,
					success: function(data) {
						arr = data["message"];
						$("#order_details_data_append").remove();
						arr.forEach(appendTableData);

					},
					error: function(data) {
						
					}, complete: function(data) {

					
					}
				})
			});*/

	$("#formsearch").submit(function(event){
		event.preventDefault();
		alert("success");
	})
		});
/*========= Load Order Details ======================= */
function order_details_list_loaded() {
	//debugger;
	$.ajax({
		type: 'GET',
		url: '/api/test/allOrderLists/'+'In Progress',
		success: function(data) {

			arr = data["message"];
			arr.forEach(appendTableData);
			totalproducts=data['totalProducts'];
			totalcustomer=data["countByRolesId"];
			
			$('.totalproduct').text(totalproducts);
			totalordrr=data['totalordrr'];
			$(".totalorders").text(totalordrr);
			$(".totalcustomer").text(totalcustomer);
		},
		error: function(data) {

		}, complete: function(data) {
			//call every five second  api
			//setInterval(order_details_list_loaded, 1000);
		}

	});
	/*========= APPEND DATA TABLE ====*/
	function appendTableData(v, i, a) {

		var totalprice = 0;
		totalprice = totalprice + v.price;

		$("#order_details_data_append").append(
			'<tr>' +
			'<td><div class="best-product-box" >' +
			'<div class="product-image">' +
			'<img src="/resources/upload_file/' + v.orderimage + '" class="img-fluid" alt="Product">' +
			'</div>' +
			'<div class="product-name">' +
			'<h5>' + v.opname + '</h5>' +
			'<h6>26-12-2022</h6>' +
			'</div>' +
			'</div>' +
			'</td>' +
			'<td>' +
			'<div class="product-detail-box">' +
			'<h6>Price</h6>' +
			'<h5>' + v.price + '/-</h5>' +
			'</div>' +
			'</td>' +

			'<td>' +
			'<div class="product-detail-box">' +
			'<h6>Order Id</h6>' +
			'<h5>' + v.orderid + '</h5>' +
			'</div>' +
			'</td>' +
			'<td>' +
			'<div class="product-detail-box">' +
			'<h6>Customer Name</h6>' +
			'<h5>' + v.customername + '</h5>' +
			'</div>' +
			'</td>' +
			'</tr>'

		);

		$("#Order-list-all").append(
			'<tr><td><div class="table-image">' +
			'<img src="/resources/upload_file/' + v.orderimage + '"class="img-fluid" alt=""></div></td>' +
			'<td>' + v.opname + '</td>' +
			'<td>' + v.customername + '</td>' +
			'<td>' + v.orderid + '</td>' +
			'<td>' + v.price + '</td>' +

			'<td class="status-danger">' + v.orderstatus + '</td>' +
			'<td><ul>' +
			'<li><a href="/api/test/dispatchDetails/' + v.orderid + '"> <i class="ri-eye-line" onclick="appendDispatcherDetails(' + v.orderid + ')"></i></a></li>' +
			'<li><a data-bs-toggle="modal" data-bs-target="#updateordermodal"  href="javascript:void(0)" ><i class="ri-pencil-line"  id="orderid"  onclick="getorder(' + v.orderid + ')"></i></a></li>' +
			'<li></li>' +
			'<li><a href="#" data-bs-target="#exampleModalToggle2"> <iclass="ri-add-fill"></i></a></li></ul>' +
			'</td></tr>'
		);

		/*===== IF CLICKED FILTER BUTTON THEN REMOVE CURRENT  TEBLE AND APPEND NEW DATATABLE ===== */

		/*$("#Data_filter").click(()=>{
			data-bs-toggle="modal" data-bs-target="#updateordermodal"
			$("#order_details_data_append").remove();<a href="" data-bs-target="#exampleModalToggle2" >
		});*/
	}
	/*function orderStatusUpdate(oid){
		alert(oid);
	}*/
	/*function orderStatusUpdate(ids){
		alert(ids);
	}*/

	/*
	setTimeout(function(){
	   window.location.reload(order_details_list_loaded());
	}, 5000);
	
	'<td>' +
				'<div class="product-detail-box">' +
				'<h6>Delivery Address</h6>' +
				' <h5>' + v.orderaddress + '</h5>' +
				'</div>' +
				'</td>' +*/
	/*'<td>' + v.orderaddress + '</td>'+*/
}


/*function deletecategory(id) {
	load_order_dispath_detail();
}*/
/*
function appendDispatcherDetails(orderid) {
	
	alert(orderid);
	//$("#Order-list-all").remove();
	load_order_dispath_detail()
}
*/

/*
function load_order_dispath_detail() {
	$.ajax({
		type: 'GET',
		url: '/api/test/dispatchDetails',
		success: function(data) {
			console.log(data);
			arr2 = data["message"];
				//totalprices = arr2[0].totalprice;
			//	console.log(totalprices);
				//order_id=arr2[0].orderid;
				//append_order_id(order_id);
			arr2.forEach(appendDispatchDetails);
			// total_price_for_order_dispatch(totalprices) ;
			//window.location.href = "/api/page/orderdetails";
		},
		error: function(data) {

		}, complete: function(data) {
window.location.href = "/api/page/orderdetails";

			
		}

	});
}
*/

/*============ Append Dispatch Details ========================== */
/*
function appendDispatchDetails(v, i, a) {
	$("#appendTotalOrderProduct").append(
		'<tr class="table-order">' +
		'<td>' +
		'<a href="javascript:void(0)">' +
		'<img src="/resources/upload_file/' + v.orderimage + '" class="img-fluid blur-up lazyload" alt="img">' +
		'</a>' +
		'</td>' +
		'<td>' +
		'<p>Product Name</p>' +
		'<h5>' + v.opname + '</h5>' +
		'</td>' +
		'<td>' +
		'<p>Price</p>' +
		'<h5>'+v.price+'</h5>' +
		'</td>' +
		'</tr>'


	);
}
*/
/*
function appendDispatchDetails(v, i, a) {
	$("#appendTotalOrderProduct").append(
		'<h1>Jitendra Shukla</h1>'
	);
	
	}
*/



/*
function total_price_for_order_dispatch(total_price) {
	$("#appendPriceContent").append(
		'<tr class="table-order">'+
			'<td colspan="3">'
			+
			'<h4 class="theme-color fw-bold">Total Price :</h4>'+
			'</td>'+
			'<td>'+
				'<h4 class="theme-color fw-bold">'+total_price+'</h4>'+
			'</td>'+
		'</tr>'

	);

}
*/

/*
function append_order_id(order_id) {
	$("#orderid").append(
		'<h5>Order #'+order_id+'</h5>'

	);

}*/
var values = 0.0;
function getorder(getorder) {
	values = getorder;

}


function statusUpdate() {
	var updatevalue = $("#selectupdatecontent").val();


	var urls = '/api/test/orderstatus/' + values + '/' + updatevalue;

	$.ajax({
		type: 'GET',
		url: urls,
		success: function(data) {
			window.location.href = "/api/page/testfile";
		},
		error: function(data) {
			window.location.href = "/api/page/testfile";
		}, complete: function(data) {
			//call every five second  api
			//setInterval(order_details_list_loaded, 1000);
			//		window.location.href="/api/page/testfile";
window.location.href = "/api/page/testfile";
		}

	});
}


/*=====FILTERING DATA ARE ========================*/







