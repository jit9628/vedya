/*
$(document).ready(function() {
	========== CALL FOR REGISTRATION  ========================-
	-------------------------------  Get State From Api--------------------------
	
	$("#login").click(function(e){
		
		var username=$("#username").val();
		alert(username);
		var password=$("#password").val();
		
		
		$
		.ajax({
			url: '/api/auth/login',
			type: 'POST',
			dataType: 'json',
			contentType: "application/json",
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			data: JSON
				.stringify({
					"username": username,
					"password": password
				}),
			success: function(
				data,
				textStatus,
				xhr) {
					alert(data);
				var parsingdata=JSON.parse(data["message "]);
				console.log(data);
				//	var  status=parssingdata.status;
				if (data["status"] == 200) {
					console.log("success ::");
					//localStorage.setItem('token', data["tokens"]);

					// alert(localStorage.getItem('token'));
				}
				else {
console.log("Failled ::");
				}
			},
			error: function(
				xhr,
				textStatus,
				errorThrown) {
console.log(xhr);
				alert("Fill All Details");

			}
		});
		
	});
	
	
});
*/