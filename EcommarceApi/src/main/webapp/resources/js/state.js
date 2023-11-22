
$(document).ready(function() {
	/*========== CALL FOR REGISTRATION  */
	/*-------------------------------  Get State From Api--------------------------*/
	/*alert("page is loaded");*/
	$.ajax({
		url: '/api/test/findallstate',
		type: 'GET',
		success: function(
			data,
			textStatus,
			xhr) {
			//var parsingdata=JSON.parse(data["message "]); //  json parsing 

			//	var  status=parssingdata.status;
			if (data["status"] == 200) {
				var arr = {};
				arr = data["message"];
				arr.forEach(myFunction);
				/*$(
					'#message')
					.removeClass(
						"d-none")
					.addClass(
						"d-block");*/

			}
			else {
			}
		},
		error: function(
			xhr,
			textStatus,
			errorThrown) {

			

		}
	});

	$('#selection').on('change', function() {
		/* ========== call city api ===========*/

		$('#selection').each(function() {
			//	var ids = $("option:selected", this).text();
			var ids2 = $("option:selected", this).val();
			var urlsource = "/api/test/findcity/" + ids2;

			$.ajax({
				url: urlsource,
				type: 'GET',
				success: function(
					data,
					textStatus,
					xhr) {

					var arr = {};
					arr = data["message"];

					arr.forEach(myFunction2);
					//var parsingdata=JSON.parse(data["message "]); //  json parsing 
					//	var  status=parssingdata.status;
					/*if (data["status"] == 200) {
						console
							.log(data);
						
		
			
					}
					else if(data["status"] == 500) {
							alert(textStatus);
					}*/

				},
				error: function(
					xhr,
					textStatus,
					errorThrown) {
				}
			});
		});
	});
	/*});*/
});

/*=========== custom itterate array function ======= */
/*========= handle state =================== */
function myFunction(value, index, array) {
	var ids = "selectedvalues";
	$('#selection')
		.append(`<option value="${value.stateid}" id="${ids}">${value.statename}</option>`);
}

/*========= handle city =================== */
function myFunction2(v, i, a) {
	var ids = "selectedvalues2";
	console.log("inside finction body");
	console.log(v.stateid);
	/*   append tag inselect option tag */
	$('#cityselection')
		.append(`<option value="${v.cityid}" id="${ids}">${v.cityname}</option>`);

}

