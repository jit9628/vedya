
var datavalues = {};

$(document).ready(function() {
	$.ajax({
		url: 'http://localhost:8004/api/test/category/list',
		type: 'GET',
		dataType: 'json',
		success: function(data, textStatus, xhr) {
			console.log(data);

			/*    for(data:val){
				   datavalues=data;
			   } */
			alert(datavalues);
			/*  itterate the response  */

			for (var i = 0; i <= data.length; i++) {
				datavalues = data[i];
				$("#tablebody")
					.append('"<tr><td>${data[0]["categoryname"]}</td></tr>"')

			}
			datavalues = data;
			alert("data values are " + datavalues[0]);
			console.log("Response Data assaign local variable  is :: " + datavalues[0]["categoryname"]);
			console.log("Response Data Length is :: " + data.length);
		},
		error: function(xhr, textStatus, errorThrown) {
			alert("error thrown");
			console.log('Error in Operation');
		}
	});


});



