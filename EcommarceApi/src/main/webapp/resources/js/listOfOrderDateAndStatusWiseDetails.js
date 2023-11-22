$("#filteringDataValues").click(function() {
alert("clicked Search Button ");
	var fd = $("#FD").val();
	var td = $("#TD").val();
	var mark = $("#mark").val();
	//var urls = '/api/test/getFilterDatas/' + fd + '/' + td + '/' + mark;
	var urls = '/api/test/getFilterDatas/2023-09-12/2023-09-12/Dispatch';


	$.ajax({
		type: 'GET',
		url: urls,
		success: function(data) {
			arr = data["message"];
			condole.log(data);
			console.log(data["message"]);
		},
		error: function(data) {
			condole.log(data);
			console.log(data["message"]);
		},
		complete: function(data) {


		}
	})
});