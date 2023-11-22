$(document).ready(function() {

	/*$.ajax({
		type: 'GET',
		url: '/api/test/categoryLists',
		success: function(data) {

			arr = data["message"];
			console.log(arr);
			arr.forEach(myFunction);
		},
		error: function(data) {
			console.log("error");
			console.log(data);
		}

	});*/

	loadcategory();

});



function myFunction(v, i, a) {
	/*var ids = v.id;
	console.log("dynamic ids" + ids);
	console.log(v);//value
	console.log(v.id);
	console.log(i); //indx
	console.log(a);// a*/
	$("#tablebody")
		.append(
			'<tr>'+
			'<td>' + v.catid + '</td> '+
			'<td>' + v.categoryname + '</td> '+
			'<td><div class="table-image"><img src="/resources/upload_file/' + v.filecategory + '" class="mg-fluid" alt="">           </div></td>'+
			'<td><ul>'+
			
			'</li><li><a href="/api/test/categorypage/' + v.catid + '"><i class="ri-pencil-line"onclick="updatecategory(' + v.catid + ')"></i></a></li>'+
			'<li><a href="#"><i class="ri-delete-bin-line" onclick="deletecategory(' + v.catid + ')"></i></a></li>'+
			'</ul></td>'+
			'</tr>'
		);

}



/*--------------------- Ajax Init------------------------ */

function loadcategory() {
	$.ajax({
		type: 'GET',
		url: '/api/test/categoryLists',
		success: function(data) {

			arr = data["message"];
		
			arr.forEach(myFunction);
		},
		error: function(data) {
			
		
		}

	});







}

/* === delete category ==== */
function deletecategory(id) {
	$.ajax({
		type: 'GET',
		url: '/api/test/categoryRemoveByIds/' + id,
		success: function(data) {
			

		
			window.location.replace("/api/test/category/list");


		},
		error: function(data) {
			
		},
		complete: function(e) {
			loadcategory();
		}

	});

}
/* === delete category ==== */
/*function updatecategory(id){
	alert("update button set.. ")
	
	
}*/
