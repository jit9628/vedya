$(".form-check").on('change',function(){
	var valueprice = $("input[name='flexRadioDefault']:checked").val();
	console.log("Value Price Is :: "+valueprice);
	var priceone=valueprice.split(" ")[0];
	var pricetwo=valueprice.split(" ")[1];
		console.log("priceone Price Is :: "+priceone);
		console.log("pricetwo Price Is :: "+pricetwo);
	fetchListOfData(priceone,pricetwo);
	
});

function fetchListOfData(priceone,pricetwo){
		$.ajax({
				url: '/api/user/filterPrice/'+priceone+'/'+pricetwo,
					type: 'GET',
					/* 	dataType: 'json', */
					success: function(data) {	
			if(data['status']==200){
			arr = data['listOfData'];
			arr.forEach(filterPriceData);	
			}

		},
		error: function(data) {
			//console.log(data);
		}
				});
	
}
function filterPriceData(v, i, a) {
	$(".appendFilterPriceData")
		.append(
			'<div class="col-md-3">' +
			'<div class="product_item">' +
			'<a href="/api/page/product-details/'+v.pid+'">' +
			'<img src="/resources/upload_file/' +v.filesretrieve[0] +'"'+
			'</a>' +
			'<div class="product_cart">' +
			'<ul>' 
			
			 +
			'</ul>' +
			'</div>' +
			'</div>' +
			'<div class="product_text">' +
			'<p>SKU: '+v.sku+'</p> <h6>'+v.productname+'</h6> <h5>MRP: '+v.price+'/-</h5>' +

/*
			'<h5>Size: ${var.productsize}-</h5>' +

			'<h5>Size: ${var.productsize}-</h5>' +*/

			'</div>' +
			'</div>'
		);

}