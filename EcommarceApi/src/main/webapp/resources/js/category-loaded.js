$(document).ready(function() {
	loadCategory();
});



function loadCategory(){
	$.ajax({
		type: 'GET',
		url: '/api/page/All-Category-list',
		success: function(data) {

			arr = data["CategoryDatalist"];
			console.log(arr);
			lengthofcategory=arr.length;
			
			
			arr.forEach(myFunction);
		},
		error: function(data) {
		}
	});
}

function myFunction(v,i,a){
	
	/*$("#clicked").click(function(){
		
	})*/
	$("#appendcategorylist").append(
		
		'<li>'+
		'<a class="dropdown-item" href="/api/page/CategoryWiseProduct/'+v.catid+'" onclick="addClasses('+v.catid+')" id="abc">'+v.categoryname+'</a>'+
		'</li>'+
		'<li>'+
		'<hr class="dropdown-divider m-0"/>'+
		'</li>'
		
									
	);
	
	/*for(var j=0;j<a.length-1;j++){
		 addHrTag();
	}*/
	
	
	
	
}

/*function addClasses(id){
	alert(id);
	loadProductBasedOnCategory(id);
}*/

/*function addHrTag(){

	
	$("#appendcategorylist").append(
		
		'<li>'+
		'<hr class="dropdown-divider m-0"/>'+
		'</li>'
		
									
	);
}*/

