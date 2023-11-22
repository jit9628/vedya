<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<%@ include file="links.jsp"%>
</head>
<body>
	<!-- include header file  -->
	<%@ include file="header.jsp"%>
	<!-- Category Section Start -->
	<section>
		<div class="container">
			<div class="heading">
				<h3>All Categories</h3>
			</div>
			<div class="row mb-5">

				<c:if test="${!empty CategoryDatalist}">
					<c:forEach var="var" items="${CategoryDatalist}">
						<div class="col-md-3 my-2">
							<div class="categorie_card">
								<a href="/api/page/CategoryWiseProduct/${var.catid}">
									<div class="card">
										<div class="card-body text-center">
											<div class="my-5">
												<div class="categorie_card_img">
													<img
														src="${pageContext.request.contextPath}/resources/upload_file/${var.filecategory}"
														alt=product>
												</div>
												<h6 class="mt-2">${var.categoryname}</h6>
											</div>
										</div>
									</div>
								</a>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<!-- <form action="/api/page/All-Category">
			<button class="btn m-auto d-block mb-5">View All Category</button>
		</form> -->
		</div>
	</section>
	<!-- Category Section End -->
	<!-- Collection Section Start  -->



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
	<!-- Contact Us Section End -->
	<!-- Footer Start -->
	<!--  link footer body-->
	<%@ include file="footer.jsp"%>
	<!-- Script Start -->

	<script>
		$('.owl-carousel').owlCarousel({
			loop : true,
			margin : 10,
			nav : true,
			autoplay : true,
			autoplayTimeout : 3000,
			dots : false,
			navText : false,
			responsive : {
				0 : {
					items : 1
				},
				600 : {
					items : 2
				},
				1000 : {
					items : 4
				}
			}
		})
	</script>




</body>
</html>