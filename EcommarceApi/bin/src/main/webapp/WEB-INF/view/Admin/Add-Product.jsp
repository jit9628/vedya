<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%> --%>
<%-- <jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" /> --%>

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
										<h5>Add New Product</h5>
									</div>
									<!-- action="product/add" -->
									<form class="theme-form theme-form-2 mega-form"
										enctype="multipart/form-data" action="/api/test/add/product"
										method="POST" modelAttribute="productdata" onSubmit="javascript:return validate();">

										<c:if test="${!empty msg}">
											<div class="alert alert-danger alert-dismissible fade show"
												role="alert">
												<strong>${msg }</strong>
												<button type="button" class="btn-close"
													data-bs-dismiss="alert" aria-label="Close"></button>
											</div>
										</c:if>


										<%-- <c:if test="${status==false}">
											<div class="alert alert-danger alert-dismissible fade show"
												role="alert">
												<strong>localhost:8004/api/page/ProductPage/${msg }</strong>
												<button type="button" class="btn-close"
													data-bs-dismiss="alert" aria-label="Close"></button>
											</div>
										</c:if> --%>

										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Product
												Name</label>
											<div class="col-sm-9">
												<input class="form-control" type="text"
													placeholder="Product Name" name="productname"
													id="productname" value="${productdata.productname}">
												<form:errors path="productname" cssStyle="color: red;" />
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
													<form:errors path="catname" cssStyle="color: red;" />
												</select>
											</div>
										</div>
										<div class="mb-4 row align-items-center">
											<label class="col-sm-3 col-form-label form-label-title">Images</label>
											<div class="col-sm-9">
												<input class="form-control form-choose" type="file"
													id="file" multiple name="file"
													value="${productdata.files }">
												<c:out value="${files}" />
												<form:errors path="catname" cssStyle="color: red;" />
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
															<form:errors path="discription" cssStyle="color: red;" />
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0">Product
												Price</label>
											<div class="col-sm-9">
												<input class="form-control" type="number"
													placeholder="Product Price" name="price" id="productname"
													value="${productdata.price}">
												<form:errors path="${productDto.price}"
													cssStyle="color: red;" />
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
												<input class="form-control" type="number"
													placeholder="Stocks" name="stocks" id="productname"
													value="${productdata.stocks}">
											</div>
										</div>

										<div class="mb-4 row align-items-center">
											<label class="form-label-title col-sm-3 mb-0"> Size</label>
											<div class="col-sm-9">
												<div class="row">
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
												id="AddProductSubmit">Add Product</button>
										</div>
									</form>
								</div>
							</div>

							<!-- New Product Add End -->
							<%@include file="scriptfileslinks.jsp"%>

							<%-- 	<script
								src="${pageContext.request.contextPath}/resources/js/post.js"
							type="text/javascript"></script>  --%>

							<script
								src="${pageContext.request.contextPath}/resources/js/validateformfields.js"
								type="text/javascript"></script>
								
								
								
								
								
								
	<script >
    function validate(){
        if(document.form.productname.value == "" ) {
            alert("Enter productname  !");
            return false;}

       /*  else {
            var value = document.form.file.value;
            var ext = value.substr(dot, value.length);
            //ext = value.slice(file.indexOf(".")).toLowerCase();
            if ( ext=="txt" ) {
                return true; }
            else{
                alert("choose a .txt file");
                return false;}
            } */
       }
</script>							
					
								
								
								
								
								
								
								
								
</body>
</html>