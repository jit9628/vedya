<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="linking.jsp"%>
<script
	src="${pageContext.request.contextPath}/resources/design/js/getscriptdata"></script>
</head>
<body>
	<%@include file="headers.jsp"%>
	<div class="page-body">
		<!-- All User Table Start -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-body">
							<div class="title-header option-title">
								<h5>All Category</h5>
								<form class="d-inline-flex">
									<a href="/api/page/addCategory"
										class="align-items-center btn btn-theme"> <i
										data-feather="plus-square"></i>Add New
									</a>
								</form>
							</div>

							<div class="table-responsive category-table">
							<%-- 	<c:if test="${not empty msg}">
									<div class="alert alert-danger alert-dismissible fade show"
										role="alert">
										<strong>${msg }</strong>
										<button type="button" class="btn-close"
											data-bs-dismiss="alert" aria-label="Close"></button>
									</div>
								</c:if> --%>
								<table class="table all-package theme-table" id="table_id">
									<thead>
										<tr>
											<th>Category Id</th>
											<th>Category Name</th>
											<th>category image</th>
											<th>Operation</th>

										</tr>
									</thead>
									<tbody id="tablebody">
										<%-- <c:forEach var="var" items="${allcategory}">
											<tr>
												<td>${var.catid}</td>
												<td id="categoryname">${var.categoryname}</td>

												<td>
													<div class="table-image">

														<img
															src="${pageContext.request.contextPath}/resources/upload_file/${var.filecategory}"
															class="mg-fluid" alt="">
													</div>
												</td>
												<td> <ul><li><a href="#"><i class="ri-eye-line"></i></a></li><li><a href="#"><i class="ri-pencil-line"></i></a></li><li><a href="#"><i class="ri-delete-bin-line"></i></a></li></ul>
													<ul>
														<li><a href="/category/delete/${var.catid}" id="read">
																<i class="ri-eye-line"></i>
														</a></li>

														<li><a href="/category/delete/${var.catid}" id="edit">
																<i class="ri-pencil-line"></i>
														</a></li>

														<li onclick="getproductid()"><a
															href="/api/test/categoryRemoveById/${var.catid}"> <i class="ri-delete-bin-line"></i>
														</a></li>
													</ul>
												</td>
											</tr>
											<!-- data-bs-toggle="modal"
															data-bs-target="#exampleModalToggle" -->
										</c:forEach> --%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<!-- All User Table Ends-->
		<%@include file="scriptfileslinks.jsp"%>
		<script type="text/javascript">
		function getproductid(){
			alert("clicked..");

		}
		
		
		
		</script>
		
		
		
	<script src="${pageContext.request.contextPath}/resources/js/categoryloaded.js"
		type="text/javascript"></script>
			<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>	
		
		
		
</body>
</html>