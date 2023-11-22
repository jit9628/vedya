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
										<h5>Product Update</h5>
									</div>
									<!-- action="product/add" -->
									<form class="theme-form theme-form-2 mega-form"
										enctype="multipart/form-data" action="/api/test/ProductUpdate"
										method="POST" modelAttribute="productdata">
										<c:if test="${status}">
											<div class="alert alert-success alert-dismissible fade show"
												role="alert">
												<strong>Product</strong> Updated
												<button type="button" class="btn-close"
													data-bs-dismiss="alert" aria-label="Close"></button>
											</div>
										</c:if>
										<div class="mb-4 d-none row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Product
												id </label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Product Name" name="pid" id="productname"
													value="${productdata.pid}">
											</div>
										</div>
										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Product
												Name </label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Product Name" name="productname"
													id="productname" value="${productdata.productname}">
											</div>
										</div>
										<div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">Category</label>
											<div class="col-sm-9">
												<select class="js-example-basic-single w-100" name="catname"
													id="categoryname">

													<c:forEach var="var" items="${categorydatavalue}">

														<option value="${var.catid}">${var.categoryname}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">Images</label>
											<div class="col-sm-9">
												<input class="form-control form-choose" type="file"
													id="file" multiple name="file" value="">
												<%-- <c:out value="${files}" />${files} --%>
											</div>
										</div>
										<div class="row">
											<div class="col-12">
												<div class="row">
													<label class="form-label-title col-sm-3 mb-0">Product
														Description</label>
													<div class="col-sm-9">
														<div id="editor">
															<textarea rows="5" cols="10" style="width: 100%"
																name="discription" id="desc"><c:out
																	value="${productdata.discription}" /></textarea>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Product
												Price</label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Product Price" name="price" id="productname"
													value="${productdata.price}">
											</div>
										</div>

										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0"> SKU</label>
											<div class="col-sm-9">
												<input class="form-control" type="text" placeholder="SKU"
													name="sku" id="productname" value="${productdata.sku}">
											</div>
										</div>

										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0"> Total
												Stocks</label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Total Stocks" name="stocks" id="productname"
													value="${productdata.stocks}">
											</div>
										</div>

										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0"> Size</label>
											<div class="col-sm-9">
												<div class="row">
												<%-- 	<%
													String m=request.getParameter("M");
													String L=request.getParameter("L");
													String xl=request.getParameter("xl");
													String xxl=request.getParameter("xxl");
													
													
													%> --%>
													<div class="form-check col-sm-3">
														<input class="form-check-input" type="checkbox" value="M"
															id="flexCheckDefault" name="M"> <label
															class="form-check-label" for="flexCheckDefault">
															M </label>
													</div>
													<div class="form-check col-sm-3">
														<input class="form-check-input" type="checkbox" value="L"
															id="flexCheckDefault" name="L"> <label
															class="form-check-label" for="flexCheckDefault">
															L </label>
													</div>
													<div class="form-check col-sm-3">
														<input class="form-check-input" type="checkbox" value="XL"
															id="flexCheckDefault" name="XL"> <label
															class="form-check-label" for="flexCheckDefault">
															XL </label>
													</div>
													<div class="form-check col-sm-3">
														<input class="form-check-input" type="checkbox"
															value="XXL" id="flexCheckDefault" name="XXL"> <label
															class="form-check-label" for="flexCheckDefault">
															XXL </label>
													</div>
												</div>
											</div>

										</div>
										<div class="row">
											<button class="btn btn-solid mt-5" type="submit"
												id="AddProductSubmit">Update Product</button>
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