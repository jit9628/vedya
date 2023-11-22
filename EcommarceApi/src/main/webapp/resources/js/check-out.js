$(document)
	.ready(
		function(e) {
			loadAddToCartData();
			

		});
		
		
function loadAddToCartData() {
	/*====load Add To Cart details ======*/
	$.ajax({
		type: 'GET',
		url: '/api/test/shoping-carts',
		success: function(data) {
arr2=data['countAddToCartProductBasedOnUser'];
arr = data['productList'];
	console.log(arr2);		
			amountcart(data);
			arr.forEach(myFunction);
			$(".countorderproducttotal").text("Order Items ("+arr2 +")");
		},
		error: function(data) {	
		},complete:function(data){	
		}
	});
}		



/*------ APPEND  DATA --------- */

function myFunction(v, i, a) {
	$("#appendeddatacheckout")
	.append('<li class="list-group-item">'+'<div class="row align-items-center">'+
'<div class="col-3">'+
'<a href="./shop.html"> <img src="/resources/upload_file/'+v.filesretrieve[0]+'"alt="img" class="img-fluid"></a>'
+'</div>'+
'<div class="col d-flex align-items-center">'+
'<div class="cart_single_caption pl-2">'+
'<h6 class="product_title fs-md ft-medium mb-1 lh-1">Women Striped Shirt Dress</h6>'+
'</div>'+
'</div>'
+
'</div>','</li>');

}

function amountcart(data){
	
	$("#amountdetails").append(
				'<ul class="list-group  list-group-flush-x">'+
				'<li class="list-group-item d-flex"><span>Subtotal</span> <span class="ms-auto fw-bold"> '+data["total"]+'</span></li>'+
				'<li class="list-group-item d-flex"><span>Tax</span> <span class="ms-auto fw-bold">'+data["Tax"]+' </span></li>'+
				'<li class="list-group-item d-flex"><span class="fw-bold">Total</span><span class="ms-auto fw-bold  totalprice"> MRP '+data["total"]+'</span></li>'+
				
				
				
				'</ul>'
			);
	
	
}




$("#disableval").click((events)=>{
	events.preventDefault();

	
})


function proccedToCheckOut(){
		$.ajax({
		type: 'GET',
		url: '/api/test/shoping-carts',
		success: function(data) {
arr2=data;


			arr = data['productList'];
			
			
			amountcart(data);
			
			
			arr.forEach(myFunction);
			
			

		},
		error: function(data) {
		console.log(data);
		}

	});
}








		
		