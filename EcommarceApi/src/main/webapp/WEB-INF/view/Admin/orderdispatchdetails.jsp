<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="linking.jsp"%>
</head>
<body>
	<%@include file="headers.jsp"%>

	<!-- Container-fluid starts-->
	<div class="page-body">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-body">
							<div class="title-header option-title">
								<h5>Order List</h5>
								<div class="right-options">
									<form >
										<ul>
											<li>
											<label class="form-lable-title fs-6">From Date</label>
											<input class="form-control" type="date" name="date1"
												placeholder="From Date" id="FD"></li>
											<li>
											<label class="form-lable-title fs-6">TO Date</label>
											<input class="form-control" type="date" name="date2"id="TD"
												placeholder="TO Date"></li>
											<li>
											<label class="form-lable-title fs-6">Remark</label>
											<select class="form-control" name="remarkvalue" id="mark">
													<option value="Delivered">Delivered</option>
													<option value="In Progress">In Progress</option>
													<option value="Dispatch">Dispatch</option>
											</select></li>
											<li>
											<label></label>
												<button class="btn btn-solid " id="filteringDataValues" >Search</button>
											</li>
											<!-- <li><a href="javascript:void(0)">import</a></li>
										<li><a href="javascript:void(0)">Export</a></li> -->
											<!-- <li><a class="btn btn-solid" href="/api/page/ProductPage">Add
												Product</a></li> -->
										</ul>
									</form>
								</div>
							</div>
							<div>
								<div class="table-responsive">
									<table class="table all-package theme-table table-product"
										id="table_id">
										<thead>
											<tr>
												<th>Product Image</th>
												<th>Product Name</th>
												<th>Customer Name</th>
												<th>Order Id</th>
												<th>Price</th>
												<!-- <th>Delivery Address</th> -->
												<th>Status</th>
												<th>Option</th>
											</tr>
										</thead>
										<tbody id="Order-list-all">


										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Container-fluid Ends-->
		<!-- data-bs-toggle="modal" -->
		<div class="container-fluid">
			<!-- footer start-->
			<footer class="footer">
				<div class="row">
					<div class="col-md-12 footer-copyright text-center">
						<p class="mb-0">Copyright 2022 © Vedakshi Jadaun</p>
					</div>
				</div>
			</footer>
		</div>
	</div>

	<%@include file="scriptfileslinks.jsp"%>


	<script
		src="${pageContext.request.contextPath}/resources/js/dispatch-detail.js"
		type="text/javascript"></script>
		<script
		src="${pageContext.request.contextPath}/resources/js/DataFilter.js"
		type="text/javascript"></script>


	<script type="text/javascript">
		/* function statusUpdate(){
		 var selectupdatecontent= $("#selectupdatecontent").val();
		 alert(selectupdatecontent);
		 } */
		/* 	$("#statusUpdate").click(()=>{
		 var selectupdatecontent= $("#selectupdatecontent").val();
		 alert(selectupdatecontent);
		
		 } */
		/* function orderStatusUpdate(idd){
			alert(idd);
			
		} */
		
		
		
		
		
	</script>
	
	<script type="text/javascript">/*$.noConflict();*/
	/*
	$("#filteringDataValues").click(function(){
		 $(document).ready(function() {
			
					//	debugger;
						var fd = $("#FD").val();
						var td = $("#TD").val();
						var mark = $("#mark").val();
						var urls = '/api/test/getFilterDatas/' + fd + '/' + td + '/' + mark;


alert(urls);
						$.ajax({
							type: 'GET',
							url: urls,
							success: function(data) {
								alert("SUCCESS");
								arr = data["message"];
								$("#order_details_data_append").remove();
					arr.forEach(appendTableData);

							},
							error: function(data) {
		alert("FAILLED");
							}, complete: function(data) {

		alert("COMPILETE");
							}

						});
					
	     });	
	});
	
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</script>
</body>

</html>