 $("#searchproducts1").on("keyup",function(){
 	var keyword = $(this).val();
 console.log(keyword);
 	$.ajax({
 		url: '/api/test/search-product/' + keyword,
 		type: 'GET',
 		success: function(response) {
 			console.log(response["data"]);
 			
 			console.log("-----------------------");
 			arr = response["data"];
 		
 			
 		//	$("#responsesearchdata").remove();
 			//arr.forEach(myFunction);
 			/*if(arr.length==0){
 				$("#responsesearchdata").remove();
 			}
 			if(arr.length>0){
 					//$("#responsesearchdata").remove();
 				arr.forEach(myFunction);
 			}*/
 			//$(".modal-body").removeClass("d-none");
 			displayProducts(response["data"]) ;
 		},
 		error: function(error) {
			// $(".modal-body").removeClass("d-none");
 			// Handle errors here
 			//const productsContainer = document.querySelector(".productsdetails");
 			 productsContainer.innerHTML = "<p>No Products Available</p>";
 		console.log(error);
 		//productsContainer.
 		//	console.error(error);
 		}
 	});
 });
 var productsContainer = document.querySelector(".productsdetails");
 function displayProducts(products) {
	
   if (products.length > 0) {
     const product_details = products
       .map(
         (product) =>
 '<li><a href="/api/page/product-details/'+product.pid+'"><div class="d-flex"><div class="search_img"><img src="/resources/upload_file/' + product.files[0] + '" alt="img"></div><div><h6>'+product.productname+'</h6><p>'+product.price+'</p></div></div></a></li>'

       )
       .join("");

     productsContainer.innerHTML = product_details;
   } else {
     productsContainer.innerHTML = "<p>No Products Available</p>";
   }
 }
 /*function myFunction(v, i, a) {
 	//$("#responsesearchdata").remove();
 	$("#responsesearchdata").append(
 	'<li><a href="#"><div class="d-flex"><div class="search_img"><img src="/resources/upload_file/' + v.files[0] + '" alt="img"></div><div><h6>'+v.productname+'</h6><p>Rs. '+v.price+'</p></div></div></a></li>'
 );}*/
