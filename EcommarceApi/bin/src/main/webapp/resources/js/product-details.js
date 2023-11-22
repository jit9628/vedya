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
		url: '/api/page/Product-dtls',
		success: function(data) {
			
			
			if(data['status']==200){
			arr = data['listOfData'];
			arr2=data["CategoryDatalist"];
			arr2.forEach(myFunction2);
			//console.log(arr2);
			addtocartvalue(data['countAddToCartProductBasedOnUser']);
			arr.forEach(myFunction);	
			}
	/*		
			arr = data['listOfData'];
			addtocartvalue(data['countAddToCartProductBasedOnUser']);
			arr.forEach(myFunction);*/
			
			if(data['status']==201){
			arr = data['listOfData'];
			arr2=data["CategoryDatalist"];
			//console.log(arr2);
			arr2.forEach(myFunction2);
			//addtocartvalue(data['countAddToCartProductBasedOnUser']);
			arr.forEach(myFunction);	
			}
		},
		error: function(data) {

			//console.log(data);
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
			'<img src="/resources/upload_file/' + v.filesretrieve[0] + '" alt="img" class="selectedimage">' +
			'</a>' +
			'<div class="product_cart">' +
			'<ul>' 
			
			 +
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
	
	$("#countaddtocartvalue").text(values);
}
function myFunction2(v,i,a){
	console.log(v);
	
	$("#appendcategorylist").append(
		
		'<li>'+
		'<a class="dropdown-item" href="/api/page/AllCategories" onclick="addClasses()">'+v.categoryname+'</a>'+
		'</li>'
									
	);
	
}


		$("#clicked").click(function(){
			$("#clicked").addClass("show");
			$("#appendcategorylist").addClass("show");
		});
			
		
	
	
	
	$(".selectedimage").change(function(){
		alert("success");
	})
	



