<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="linking.jsp"%>
</head>
<body>
	<%@include file="headers.jsp"%>
	<div class="page-body">
		<!-- New Product Add Start -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="row">
						<div class="col-sm-8 m-auto">
							<div class="card">
								<div class="card-body">
									<div class="card-header-2">
										<h5>Category Update</h5>
									</div>
									<!-- action="/api/test/add/category" method="POST" -->
									<form class="theme-form theme-form-2 mega-form"
										action="/api/test/categoryupdate/${category.catid}" method="POST" enctype="multipart/form-data" >

								<%-- 		<c:if test="${!empty msg}">
											<div class="alert alert-danger alert-dismissible fade show"
												role="alert">
												<strong>${msg }</strong>
												<button type="button" class="btn-close"
													data-bs-dismiss="alert" aria-label="Close"></button>
											</div>
										</c:if> --%>
										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Category
												Name</label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Category Name" name="categoryname" value="${category.categoryname}">
											</div>
										</div>
										<div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">Images</label>
											<div class="col-sm-9">
												<input class="form-control form-choose" type="file"
													id="file" multiple name="file" value="">
											</div>
										</div>
										<button class="btn btn-solid mt-5" href="javascript:void(0)"
											type="submit">
											<!-- id="AddCategorySubmit" -->
											Update Category
											</butto>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- New Product Add End -->
		<%@include file="scriptfileslinks.jsp"%>
		<script>
async function uploadFile() {
  let formData = new FormData(); 
  formData.append("file", file.files[0]);
  let response = await fetch('/upload', {
    method: "POST", 
    body: formData
  }); 
  if (response.status == 200) {
    alert("File successfully uploaded.");
  }
}
</script>	
</body>
</html>