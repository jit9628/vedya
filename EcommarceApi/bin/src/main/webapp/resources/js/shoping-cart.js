



$(document)
	.ready(
		function(e) {
			loadAddToCartData();

		});


/*========= append html data ============ */

function myFunction(v, i, a,arr2) {
	$("#appendeddata")
		.append('<li class="list-group-item">'+
			'<div class="row align-items-center">' +
			'<div class="col-3">' +
			'<a href="./product-detail.html"> <img src="/resources/upload_file/' + v.filesretrieve[0] + '" alt="img" class="img-fluid"></a>'
			+ '</div>' +
			'<div class="col d-flex align-items-center justify-content-between">' +
			'<div class="pl-2">' +
			'<h4 class="mb-1">' + v.productname + '</h4>' +
			'<p class="mb-1"><span class="text-dark"> ' + v.sizes + ' </span></p>' +
			'<h4 class="fs-md ft-medium mb-3 lh-1">MRP:' + v.price + '</h4>' +
			'</div>' +
			'<div>' +
			'<button class="close_slide gray removecart" id="removecart"><i class="fa-solid fa-xmark fs-6" onclick="deleteProductAddToCart(' + v.pid + ')"></span></i>'

			+ '</div>' +
			'</div>' +

			'</div>'+
			'</li>'
		);
}
function loadAddToCartData() {
	/*====load Add To Cart details ======*/
	$.ajax({
		type: 'GET',
		url: '/api/test/shoping-carts',
		success: function(data) {
			//console.log(data);
			arr = data['productList'];
			console.log(arr);
			arr.forEach(myFunction);
			amountcart(data);
			addtocartvalue(data['countAddToCartProductBasedOnUser']);
			arr2=data["allCategories"];
			arr2.forEach(myFunction2)
			
/*$("#amountdetails").append(
				'<ul class="list-group  list-group-flush-x">'+
				'<li class="list-group-item d-flex"><span>Subtotal</span> <span class="ms-auto fw-bold"> '+data["total"]+'</span></li>'+
				'<li class="list-group-item d-flex"><span>Tax</span> <span class="ms-auto fw-bold">'+data["Tax"]+' </span></li>'+
				'<li class="list-group-item d-flex"><span class="fw-bold">Total</span><span class="ms-auto fw-bold"> MRP '+data["total"]+'</span></li>'+
				'</ul>'
			);*/
		},
		error: function(data) {
			//console.log("error");
		//	console.log(data);
		}

	});
}

function amountcart(data){
	
	$("#amountdetails").append(
				'<ul class="list-group  list-group-flush-x">'+
				'<li class="list-group-item d-flex"><span>Subtotal</span> <span class="ms-auto fw-bold"> '+data["total"]+'</span></li>'+
				'<li class="list-group-item d-flex"><span>Tax</span> <span class="ms-auto fw-bold">'+data["Tax"]+' </span></li>'+
				'<li class="list-group-item d-flex"><span class="fw-bold">Total</span><span class="ms-auto fw-bold"> MRP '+data["total"]+'</span></li>'+
				
				
				
				'</ul>'
			);
	
	
}

function addtocartvalue(values){
	
	$("#countaddtocartvalue").text(values);
}




/*------------ delete product from add to cart----------------- */

function deleteProductAddToCart(id) {
	$.ajax({
		type: 'GET',
		url: '/api/test/remodeproductfromcart/' + id,
		success: function(data) {
			//console.log(data);
			//successMessage("Delete Your Product .. ");
			window.location.replace("/api/test/shoping-cart");

		},
		error: function(data) {
			//console.log("error");
			//console.log(data);
		},
		complete: function(datae) {
			//alert("complete");
			loadAddToCartData();
			amountcart(data);
			addtocartvalue(data['countAddToCartProductBasedOnUser']);

		}


	});
}


function successMessage(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'success',
		title: msg,
		showConfirmButton: false,
		timer: 5000
	})

	return 1;

}

function myFunction2(v,i,a){
	$("#appendcategorylist").append(
		
		'<li>'+
		'<a class="dropdown-item" href="/api/page/AllCategories" onclick="addClasses()">'+v.categoryname+'</a>'+
		'</li>'
									
	);
}

	$("#appendcategorylist").click(()=>{
		alert("success");
	});











