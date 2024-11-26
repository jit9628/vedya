
$("#cartaddviauser").click(function(){
		
		
		
		
		var e = document.getElementById("selectquantity");
var values = e.value;	
		var val = $("input[name='size']:checked").val();
		var color=$("input[name='color8']:checked").val();
		console.log(color);
		if(val==undefined||color==undefined){
			FailureResponseMessage("Please Select Color And Size","warning");
			//alert("Please Select Color And Size"+color);
		}
		
		else{
		var size = "&&size=" + val;
		var href=	$(".sp-current-big").attr('href');
		splits=href.split("/");
		//alert(href);
		//alert(splits);
		orderimagevalue=splits[3];
		 var orderimage ="&&orderimage=" + orderimagevalue;
		 var choosecolor="&&color="+color;
		var href = $('form').attr('action');
		var qty="&&qty=" + values;
		var finalurl = href + size + qty + orderimage + choosecolor;
		alert(finalurl);
		/*start Ajax Block*/
		$.ajax({
				url: finalurl,
					type: 'GET',
					/* 	dataType: 'json', */
					success: function(
						data,
						textStatus,
						xhr) {
						if (data["status"] == 200) {
							//successMessage("Product Is Add To Cart");
								window.location.href = "/api/test/shoping-cart";
								//console.log(data);
									//$('#message').removeClass("d-none").addClass("d-block");
								//window.location.href = "api/auth/userdashboard";
							}
						if (data["status"] == 226) {
							failledMessage(data['message']);
							window.setTimeout(() => { window.location.href = "/api/page/Product-dtl-usr"; }, 4000);
			
							}

						/*if (data["status"] == 409) {
					failledMessage("Product Is Exists into Cart");
						//console.log(data);
							//$('#message').removeClass("d-none").addClass("d-block");
						
						//window.location.href = "/api/test/shoping-cart";
	
					}
					*/

						/*
							if (data["status"] == 401) {
						failledMessage("Please Logged In... ");
							//console.log(data);
								//$('#message').removeClass("d-none").addClass("d-block");
							
							
		
						}*/

					},
					error: function(
						xhr,
						textStatus,
						errorThrown) {
					
						console.log(errorThrown);
						console.log(xhr);
						//console.log(xhr['status'])
						//console.log(errorThrown);
						if (xhr['responseJSON'].status == 401) {
							//console.log(xhr['responseJSON'].message);
							window.location.href = "/api/page/LogIn";
						}


						if (xhr['responseJSON'].status == 226) {
							//alert(" Is Exists..");
							//failledMessage("This Product Is Already Add To Cart..");
							//window.setTimeout(() => { window.location.href = "/api/page/Product-dtl-usr"; }, 4000);
						}
						/*	if (xhr['status']) {*/
						//	window.setTimeout(() => { window.location.href = "/api/page/Product-dtl-usr"; }, 4000);
						//	window.location.href = "/api/test/shoping-cart";

						/*	}*/

					}
				});
	}

	})		
		
		
		
		