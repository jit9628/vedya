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
	<%
	/*     Message message=new Message();
	String files=message.getFiles();
	System.out.println(files); */
	%>

	<!-- Container-fluid starts-->
	<div class="page-body">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-body">
							<div class="title-header option-title">
								<h5>Products List</h5>
								<div class="right-options">
									<ul>
										<li><a href="javascript:void(0)">import</a></li>
										<li><a href="javascript:void(0)">Export</a></li>
										<li><a class="btn btn-solid" href="/api/page/ProductPage">Add
												Product</a></li>
									</ul>
								</div>
							</div>
							<div>
								<div class="table-responsive">
									<table class="table all-package theme-table table-product" id="table_id">
										<!-- id="table_id" -->
										<thead>
											<tr>
												<th>Product Image</th>
												<th>Product Name</th>
												<!--  <th>Category</th> -->
												<th>Stocks</th>
												<th>Price</th>
												<th>Status</th>
												<th>Option</th>
											</tr>
										</thead>


										<%-- 	<c:if test="${empty listOfData}"> --%>

										<tbody id="tablebody">
										
										<%-- <c:if test="${!empty listOfData}">
											<c:forEach var="var" items="${listOfData}">
												<tr>
													<td>

														<div class="table-image">

															<img
																src="${pageContext.request.contextPath}/resources/upload_file/${var.filesretrieve[0]}"
																class="
																img-fluid" alt="">

														</div>
													</td>

													<td>${var.productname}</td>

													<td>${var.stocks }</td>

													<td>${var.price }</td>

													<td class="status-danger">${var.active}</td>
													<td>
														<ul>
															<li><a href="/api/page/product-view/${var.pid }"> <i
																	class="ri-eye-line"></i>
															</a></li>

															<li><a href="/api/test/update-product/${var.pid }">
																	<i class="ri-pencil-line"></i>
															</a></li>

															<li><a href="/api/test/product/${var.pid}"
																data-bs-target="#exampleModalToggle2"> <i
																	class="ri-delete-bin-line"></i>
															</a></li>

																<li><a href="/api/page/productproperty/${var.pid}"
																data-bs-target="#exampleModalToggle2"> <i
																	class="ri-add-fill"></i>
															</a></li>
														</ul>
													</td>
												</tr>
											</c:forEach>
											</c:if> --%>
										</tbody>
										<%-- </c:if> --%>
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
						<p class="mb-0">Copyright 2022 © Vedya</p>
					</div>
				</div>
			</footer>
		</div>
	</div>

<%-- 	<div class="modal fade theme-modal remove-coupon"
		id="exampleModalToggle2" aria-hidden="true" tabindex="-1">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-center" id="exampleModalLabel12">Done!</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="fas fa-times"></i>
					</button>
				</div>
				<div class="modal-body">
					<div class="remove-box text-center">
						<div class="wrapper">
							<svg class="checkmark" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 52 52">
                                <circle class="checkmark__circle"
									cx="26" cy="26" r="25" fill="none" />
                                <path class="checkmark__check"
									fill="none" d="M14.1 27.2l7.1 7.2 16.7-16.8" />
                            </svg>
						</div>
						<h4 class="text-content">It's Removed.</h4>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" data-bs-toggle="modal"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div> --%>
	<%@include file="scriptfileslinks.jsp"%>
	<%@include file="models.jsp"%>
			<!--  ${pageContext.request.contextPath} -->
	<script src="/resources/js/jquery.dataTables.js"
		type="text/javascript"></script>
		
		<script src="/resources/js/productloaded.js"
		type="text/javascript"></script>
		
		
			<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>	
</body>

</html>