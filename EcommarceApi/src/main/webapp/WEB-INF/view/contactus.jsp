<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="links.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- ContactUs Section End -->
	<section>
		<div class="container">
			<div class="row my-5">
				<div class="col-md-6 offset-md-3 mt-4">
					<div class="contact_left_section">
						<h4 class="mb-3">Contact Us</h4>
						<div class="block">
							<div class="icon">
								<i class="fa-sharp fa-solid fa-location-dot"></i>
							</div>
							<div class="data">76, luv kush nagar 1st tonk phatak Jaipur
								302015 Rajasthan</div>
						</div>
						<hr />
						<div class="block">
							<div class="icon">
								<i class="fa-solid fa-phone"></i>
							</div>
							<div class="data">+91 7357763666</div>
						</div>
						<hr />
						<div class="block">
							<div class="icon">
								<i class="fa-solid fa-envelope"></i>
							</div>
							<div class="data">vedakshijadaun@gmail.com</div>
						</div>
					</div>
				</div>
				<!-- <div class="col-xs-12 col-sm-8 col-md-9">
                    <div class="contact_form">
                        <form>
                            <div class="form-group row">
                                <div class="col-md-9 col-md-offset-3">
                                    <h3>Contact us</h3>
                                </div>
                            </div>
                            <div class="row g-3 ">
                                <div class="col-md-4">
                                    <label class="form-label">First name</label>
                                    <input type="text" class="form-control">
                                </div>
                                <div class="col-md-4">
                                    <label class="form-label">Last name</label>
                                    <input type="text" class="form-control">
                                </div>
                                <div class="col-md-4">
                                    <label class="form-label">Email</label>
                                    <input type="email" class="form-control">
                                </div>
                                <div class="col-md-6">
                                    <label class="form-label">City</label>
                                    <input type="text" class="form-control">
                                </div>
                                <div class="col-md-3">
                                    <label class="form-label">State</label>
                                    <select class="form-select">
                                        <option selected disabled value="">Choose...</option>
                                        <option>...</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label class="form-label">Zip</label>
                                    <input type="text" class="form-control">
                                </div>
                                <div class="col-12">
                                    <label  class="form-label">Message</label>
                                    <textarea class="form-control"  rows="3"></textarea>
                                </div>
                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="">
                                        <label class="form-check-label">
                                            Agree to terms and conditions
                                        </label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button class="btn btn-primary" type="submit">Submit form</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div> -->
			</div>
		</div>
	</section>

	<%@ include file="footer.jsp"%>
	<!-- Header Section End -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/category-loaded.js"
		type="text/javascript"></script>
	<%-- 	<script
		src="${pageContext.request.contextPath}/resources/js/product-derails.js"
		type="text/javascript"></script> --%>
</body>
</html>