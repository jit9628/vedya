$(document).ready(function() {
	loadproduct();

});

/*--------------------- Ajax Init------------------------ */

function loadproduct() {
	$.ajax({
		type: 'GET',
		url: '/api/page/All-Products',
		success: function(data) {

			arr = data["message"];
			//console.log(arr);
			arr.forEach(myFunction);
			$("#table_id").DataTable();
		},
		error: function(data) {
			//console.log("error");
			//console.log(data);
		}
	});
}

/*====== dYNAMIC PAGE INITIALIZE======= */

function myFunction(v, i, a) {
	console.log(v);//value
	console.log(v.pid);
	console.log("0 position value is : " + v.filesretrieve[0])
	console.log(i); //index
	console.log(a);// array
	console.log(arr);
	//data-bs-toggle="modal" data-bs-target="#exampleModalToggle" 
	$("#tablebody")
		.append(
			'<tr> >   <td><div class="table-image"><img src="/resources/upload_file/' + v.filesretrieve[0] + '" class="mg-fluid" alt=""></div><td>' + v.productname + '</td> <td>' + v.stocks + '</td><td>' + v.price + '</td><td>' + v.active + '</td><td><ul><li><a href="/api/test/update-product/' + v.pid + '"><i class="ri-pencil-line"onclick="updatecategory(' + v.pid + ')"></i></a></li><li><a href=javascript:void(0)" ><i class="ri-delete-bin-line" onclick="deletecategory(' + v.pid + ')"></i></a></li></ul></td></tr>'

		);
}


/* === delete category ==== */


function deletecategory(id) {
	$.ajax({
		type: 'GET',
		url: '/api/test/deleteproduct/' + id,
		success: function(data) {

			//console.log(data['status']);

			if (data['status'] == 200) {
				successMessage("Product deleted ...", "success");
				//	window.setTimeout(()=>{window.location.href = "/api/page/All-Product";}, 1000)
				window.location.replace("/api/page/All-Product");


			}
			if (data['status'] == 226) {
				successMessage("Can not be dleted because its use ...", "warning");
				window.setTimeout(() => { window.location.href = "/api/page/All-Product"; }, 1500)
				//window.location.replace("/api/page/All-Product");	

			}





		},
		error: function(xhr,
			textStatus,
			errorThrown) {



		},
		complete: function(e) {
			loadproduct();
		}

	});





}


/* === delete category ==== */
/*function updatecategory(id){
	
	alert(id);
}*/




/* ==== alert message for delete product if ok product deleted otherwise product no deleted ====== */

function deleteAlert() {
	Swal.fire({
		title: 'Are you sure?',
		text: "You won't be able to revert this!",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, delete it!'
	}).then((result) => {
		if (result.isConfirmed) {

			Swal.fire(
				'Deleted!',
				'Your file has been deleted.',
				'success'
			)
		}
	})
}




function successMessage(msg, icons) {
	Swal.fire({
		position: 'top-center',
		icon: icons,
		title: msg,
		showConfirmButton: false,
		timer: 1000
	})
}

/*function del() {
	alert("deleted..");
}

function deleteElement() {

	alert("jitendra..");

}*/




