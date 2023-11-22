<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp"%>
</head>
<body>
	<!-- <sec:authentication property="principal.authorities"> 
<sec:authorize access="!isAuthenticated()">
<h1>Jitendra shukla </h1>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
  Logout
</sec:authorize>

<h1>Jitendra</h1>-->
	<!-- </sec:authentication> -->
	<form  id="formsearch">
		<ul>
			<li><label class="form-lable-title fs-6">From Date</label> <input
				class="form-control" type="date" name="date1"
				placeholder="From Date" id="FD"></li>
			<li><label class="form-lable-title fs-6">TO Date</label> <input
				class="form-control" type="date" name="date2" id="TD"
				placeholder="TO Date"></li>
			<li><label class="form-lable-title fs-6">Remark</label> <select
				class="form-control" name="remarkvalue" id="mark">
					<option value="Delivered">Delivered</option>
					<option value="In Progress">In Progress</option>
					<option value="Dispatch">Dispatch</option>
			</select></li>
			<li><label></label>
				<button class="btn btn-solid " type="button" id="filteringDataValues">Search</button></li>
			<!-- <li><a href="javascript:void(0)">import</a></li>
										<li><a href="javascript:void(0)">Export</a></li> -->
			<!-- <li><a class="btn btn-solid" href="/api/page/ProductPage">Add
												Product</a></li> -->
		</ul>
	</form>
	<script>
/* $("#filteringDataValues").click(function(){
	alert("success");
	$.ajax({
		url :"/api/test/getFilterDatas/"+'2023-08-12'+'/'+'2023-08-18'+'/'+'Dispatch',
		type : 'GET',
		success : function(
				data,
				textStatus,
				xhr) {

			console
					.log(xhr);

			
		},
		error : function(
				xhr,
				textStatus,
				errorThrown) {
			console
					.log(xhr["responseJSON"]);
		}
	});
}); */																
	</script>


<%-- <script src="${pageContext.request.contextPath}/resources/js/listOfOrderDateAndStatusWiseDetails.js"
		type="text/javascript"></script> --%>
</body>
</html>