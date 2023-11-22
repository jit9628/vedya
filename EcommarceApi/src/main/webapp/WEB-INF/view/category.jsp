<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- include liks   -->
<%@ include file="links.jsp"%>
</head>
<body>

	<!-- include header  -->

	<%@ include file="header.jsp"%>
	<section>
		<div class="container">
			<div class="heading">
				<h3>Our Latest Categories</h3>
			</div>
			<div class="row mb-5">
				<c:if test="${!empty CategoryDatalist}">
					<c:forEach var="var" items="${CategoryDatalist}">
						<div class="col-md-3 mb-4">
						<div class="item">
                            <div class="latest-product">
                                <a href="/api/page/CategoryWiseProduct/${var.catid}">
                                    <img src="${pageContext.request.contextPath}/resources/upload_file/${var.filecategory}" alt="img">
                                    <h5 class="text-uppercase">${var.categoryname}</h5>
                                </a>
                            </div>
                        </div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		</div>
	</section>

	<!-- Contact Us Section Start -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="contact_bg">
						<h4>Connect with Us</h4>
						<ul>
							<li><a href="javascript:void(0)"><i
									class="fa-brands fa-facebook"></i></a></li>
							<li><a href="javascript:void(0)"><i
									class="fa-brands fa-twitter"></i></a></li>
							<li><a href="javascript:void(0)"><i
									class="fa-brands fa-instagram"></i></a></li>
							<!-- <li><a href="#"><i class="fa-brands fa-pinterest"></i></a></li> -->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Category Section End -->


	<!-- Contact Us Section End -->


	<!-- include footer  -->

	<%@ include file="footer.jsp"%>

	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>