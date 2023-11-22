/*$(document)
	.ready(
		function(e) {
			load_order_dispath_detail();
		});




function load_order_dispath_detail() {
	$.ajax({
		type: 'GET',
		url: '/api/test/dispatchDetails',
		success: function(data) {
			console.log(data);
			arr2 = data["message"];
				totalprices = arr2[0].totalprice;
				console.log(totalprices);
				order_id=arr2[0].orderid;
				append_order_id(order_id);
			arr2.forEach(appendDispatchDetails);
			 total_price_for_order_dispatch(totalprices) 
		},
		error: function(data) {
		}, complete: function(data) {	
		}

	});
}

============ Append Dispatch Details ========================== 

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
		'<p>Quantity</p>' +
		'<h5>1</h5>' +
		'</td>' +
		'<td>' +
		'<p>Price</p>' +
		'<h5>'+v.price+'</h5>' +
		'</td>' +
		'</tr>'


	);
}

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

function append_order_id(order_id) {
	$("#orderid").append(
		'<h5>Order #'+order_id+'</h5>'

	);

}
*/