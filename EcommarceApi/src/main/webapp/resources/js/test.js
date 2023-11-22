$(document).ready(function() {
	$.ajax({
		type: 'GET',
		url: '/api/page/specificProduct/31',
		success: function(data) {
			console.log(data);
			arr = data["sliderfile"];
			arr.forEach(apendSliderImage);
			//arr.forEach(appendsize);
			/* if(data['status']==200){
			arr = data['listOfData'];
			arr2=data["CategoryDatalist"];
			arr2.forEach(myFunction2); */
			//console.log(arr2);
			/* 	addtocartvalue(data['countAddToCartProductBasedOnUser']);
				arr.forEach(myFunction);	 */

			/*		
					arr = data['listOfData'];
					addtocartvalue(data['countAddToCartProductBasedOnUser']);
					arr.forEach(myFunction);*/

			/* if(data['status']==201){
			arr = data['listOfData'];
			arr2=data["CategoryDatalist"]; */
			//console.log(arr2);
			//arr2.forEach(myFunction2);
			//addtocartvalue(data['countAddToCartProductBasedOnUser']);
			//arr.forEach(myFunction);	


		},
		error: function(data) {

			//console.log(data);
		},
		complete: function(data) {
			/*console.log(data);

			arr2 = data["responseJSON"].sliderfile;
			arr2.forEach(apendSliderImage);
			console.log(arr2);
*/
		}

	});

	/*function appendsize(v, i, a) {
		$("#appendsize").append(
			'<input class="form-check-input d-none selectedsizevalue  accessid" type="radio" name="size" id="" value="' + v + '">' +
			'<label class="form-option-label  addcheck" for="' + v + '">' + v + '</label>'


		);
	}*/
	function apendSliderImage(v, i, a) {
		$("#appendimagefile").append(
   '<a href="/resources/upload_file/'+v+'" onclick="getimagesource()">'+
'<img src="/resources/upload_file/'+v+'"alt=""></a>'

	)}
});