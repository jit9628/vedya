$(document)
	.ready(
		function(e) {
			loadProductDetails();

		});

/*================= load product details=============================== */

function loadProductDetails() {
	/*====load Add To Cart details ======*/
	$.ajax({
		type: 'GET',
		url: '/api/page/indexpage-Product-dtls',
		success: function(data) {
			if(data['status']==200){
			arr = data['listOfData'];
			addtocartvalue(data['countAddToCartProductBasedOnUser']);
			alert(data['countAddToCartProductBasedOnUser']);
			arr.forEach(myFunction);	
			}
	/*		
			arr = data['listOfData'];
			addtocartvalue(data['countAddToCartProductBasedOnUser']);
			arr.forEach(myFunction);*/
			
		},
		error: function(data) {

			
		}

	});
}


/*============================== Append Data into Html Page ============================ */
function myFunction(v, i, a) {
	$("#appendeddata")
		.append(
			'<div class="col-md-3">' +
			'<div class="product_item">' +
			'<a href="/api/page/product-details/'+v.pid+'">' +
			'<img src="/resources/upload_file/' + v.filesretrieve[0] + '" alt="img">' +
			'</a>' +
			'<div class="product_cart">' +
			'<ul>' +
			'<li><a href="javascript:void(0)" title="Add to Cart"><i class="fa-solid fa-cart-shopping"></i></a>' +
			'</li>' +
			'<li><a href="javascript:void(0)" title="quick-view"><i class="fa-solid fa-eye"></i></a></li>' +
			'</ul>' +
			'</div>' +
			'</div>' +
			'<div class="product_text">' +
			'<p>SKU: VJKS001</p> <h6>Pink Taffy</h6> <h5>MRP: '+v.price+'/-</h5>' +

/*
			'<h5>Size: ${var.productsize}-</h5>' +

			'<h5>Size: ${var.productsize}-</h5>' +*/

			'</div>' +
			'</div>'
		);

}

function addtocartvalue(values){
	alert(values);
	$("#countaddtocartvalue").text(values);
}




