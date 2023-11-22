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
	<div class="page-body">
		<!-- New Product Add Start enctype="multipart/form-data" -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="row">
						<div class="col-sm-8 m-auto">
							<div class="card">
								<div class="card-body">
									<div class="card-header-2">
										<h5>Add Product Property</h5>
									</div>
									<!-- action="product/add" -->
									<form class="theme-form theme-form-2 mega-form"
										enctype="multipart/form-data"
										action="/api/test/addMoreProductDetail" method="POST"
										modelAttribute="productdata">
										<!-- <div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Product
												Name</label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Product Name" name="productname"
													id="productname" value="">
											</div>
										</div> -->
										<div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">Size</label>
											<div class="col-sm-9">
												<select class="js-example-basic-single w-100" name="size"
													id="categoryname">
													<c:forEach var="var" items="${sizedata}">
														<option value="${var.optionId }">${var.optionname}</option>
													</c:forEach>

												</select>
											</div>
										</div>

										<div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">color</label>
											<div class="col-sm-9">
												<select class="js-example-basic-single w-100" name="colors"
													id="categoryname">
													<c:forEach var="var" items="${colordata}">
														<option value="${var.optionId }">${var.optionname}</option>

													</c:forEach>
												</select>
											</div>
										</div>
										<%-- <div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">Color</label>
											<div class="col-sm-9">
												<select class="js-example-basic-single w-100" name="catname"
													id="categoryname">

													<c:forEach var="var" items="${optiongroup}">
														<option value="${var.catid}">${var.groupname}</option>
													</c:forEach>
												</select>
											</div>
										</div> --%>
										<div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">Images</label>
											<div class="col-sm-9">
												<input class="form-control form-choose" type="file"
													id="file" multiple name="file" value="">
												<c:out value="" />
											</div>
										</div>


										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Product
												Price</label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Product Price" name="price" id="productname"
													value="">
											</div>
										</div>
										<div class="row">
											<button class="btn btn-solid mt-5" type="submit"
												id="AddProductSubmit">Add Product</button>
										</div>
									</form>
								</div>
							</div>

							<!-- New Product Add End -->
							<%@include file="scriptfileslinks.jsp"%>

							<%-- 	<script
								src="${pageContext.request.contextPath}/resources/js/post.js"
							type="text/javascript"></script> --%>
							<script>
								/*
									$(document).ready(function() {
										
										
										$("#AddProductSubmit")
										.click(function() {
											alert("call add function");
											event.preventDefault();
											var productname = $("#productname").val();
											var desc = $("#desc").val();
											var file = $("#file").val();
											var categoryname = $("#categoryname").val();
											console.log(productname);
											console.log(desc);
											console.log(file);
											console.log(categoryname);
											// Ajax call 
											
											$.ajax({
												url: 'http://localhost:8004/test/add/product',
												type: 'POST',
												dataType: 'json',
												contentType: "application/json",
												//enctype:'multipart/form-data',
												headers: {
													'Accept': 'application/json',
													'Content-Type': 'application/json'
												},
												data:  JSON.stringify({
													"productname": productname,
													"discription": desc,
													"files": file[0],
													"catname": categoryname,
												}),
												success: function(data, textStatus, xhr) {

													alert(data);

												},
												error: function(
													xhr,
													textStatus,
													errorThrown) {
													alert("error thrown");
													console
														.log('Error in Operation');
												}
											});
											
											
										});
										
										
									}); 
								 */
							</script>
</body>
</html>