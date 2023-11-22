<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- page-wrapper Start-->
	<div class="page-wrapper compact-wrapper" id="pageWrapper">
		<!-- Page Header Start-->
		<div class="page-header">
			<div class="header-wrapper m-0">
				<div class="header-logo-wrapper p-0">
					<div class="logo-wrapper">
						<a href="#"> <img class="img-fluid main-logo"
							src="${pageContext.request.contextPath}/resources/design/images/logo-icon.png"
							alt="logo"> <img class="img-fluid white-logo"
							src="${pageContext.request.contextPath}/resources/design/images/logo-icon.png"
							alt="logo">
						</a>
					</div>
					<div class="toggle-sidebar">
						<i class="status_toggle middle sidebar-toggle"
							data-feather="align-center"></i> <a href="#"> <img
							src="${pageContext.request.contextPath}/resources/design/images/logo.png"
							class="img-fluid" alt="logo">
						</a>
					</div>
				</div>

				<form class="form-inline search-full" action="javascript:void(0)"
					method="get">
					<div class="form-group w-100">
						<div class="Typeahead Typeahead--twitterUsers">
							<div class="u-posRelative">
								<input
									class="demo-input Typeahead-input form-control-plaintext w-100"
									type="text" placeholder="Search .."> <i
									class="close-search" data-feather="x"></i>
								<!-- <div class="spinner-border Typeahead-spinner" role="status">
                                    <span class="sr-only">Loading...</span>
                                </div> -->
							</div>
							<!-- <div class="Typeahead-menu"></div> -->
						</div>
					</div>
				</form>
				<div class="nav-right col-6 pull-right right-header p-0">
					<ul class="nav-menus">
						<li><span class="header-search"> <i
								class="ri-search-line"></i>
						</span></li>

						<li>
							<div class="mode">
								<i class="ri-moon-line"></i>
							</div>
						</li>
						<li class="profile-nav onhover-dropdown pe-0 me-0">
							<div class="media profile-media">
								<img class="user-profile rounded-circle"
									src="${pageContext.request.contextPath}/resources/design/images/User/user01.jpg"
									alt="">
								<div class="user-name-hide media-body">
									<span>Emay Walter</span>
									<p class="mb-0 font-roboto">
										Admin<i class="middle ri-arrow-down-s-line"></i>
									</p>
								</div>
							</div>
							<ul class="profile-dropdown onhover-show-div">
								<!-- <li><a href="./Order-list.html"> <i
										data-feather="archive"></i> <span>Orders</span>
								</a></li> -->
								<li><a href="#"> <i
										data-feather="settings"></i> <span>Settings</span>
								</a></li>
								<li><a data-bs-toggle="modal"
									data-bs-target="#staticBackdrop" href="javascript:void(0)">
										<i data-feather="log-out"></i> <span>Log out</span>
								</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Page Header Ends-->

		<!-- Page Body Start-->
		<div class="page-body-wrapper">
			<!-- Page Sidebar Start-->
			<div class="sidebar-wrapper">
				<div id="sidebarEffect"></div>
				<div>
					<div class="logo-wrapper logo-wrapper-center">
						<a href="./Dashboard.html" data-bs-original-title="" title="">
							<img class="img-fluid for-white"
							src="${pageContext.request.contextPath}/resources/design/images/logo.png"
							alt="logo">
						</a>
						<div class="back-btn">
							<i class="fa fa-angle-left"></i>
						</div>
						<div class="toggle-sidebar">
							<i class="ri-apps-line status_toggle middle sidebar-toggle"></i>
						</div>
					</div>
					<div class="logo-icon-wrapper">
						<a href="./Dashboard.html"> <img
							class="img-fluid main-logo main-white"
							src="${pageContext.request.contextPath}/resources/design/images/logo-icon.png"
							alt="logo"> <img class="img-fluid main-logo main-dark"
							src="${pageContext.request.contextPath}/resources/design/images/logo-icon.png"
							alt="logo">
						</a>
					</div>
					<nav class="sidebar-main">
						<div class="left-arrow" id="left-arrow">
							<i data-feather="arrow-left"></i>
						</div>

						<div id="sidebar-menu">
							<ul class="sidebar-links" id="simple-bar">
								<li class="back-btn"></li>

								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title link-nav" href="/api/auth/admindashboard"> <i
										class="ri-home-line"></i> <span>Dashboard</span>
								</a></li>

								<li class="sidebar-list"><a
									class="linear-icon-link sidebar-link sidebar-title"
									href="javascript:void(0)"> <i class="ri-store-3-line"></i>
										<span>Product</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a href="/api/page/All-Product">Prodct List</a></li>

										<li><a href="/api/page/ProductPage">Add New Products</a>
										</li>
										<li><a href="/api/page/All-Product">Add More Product</a>
										</li>
									</ul></li>

								<li class="sidebar-list"><a
									class="linear-icon-link sidebar-link sidebar-title"
									href="javascript:void(0)"> <i class="ri-list-check-2"></i>
										<span>Category</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a href="/api/test/category/list">Category List</a></li>

										<li><a href="/api/page/addCategory">Add New Category</a>
										</li>
									</ul></li>

								<!-- <li class="sidebar-list"><a
									class="sidebar-link sidebar-title" href="javascript:void(0)">
										<i class="ri-user-3-line"></i> <span>Users</span>
								</a> -->
									<!-- <ul class="sidebar-submenu">
										<li><a href="javascript:void(0)">All users</a></li>
										<li><a href="javascript:void(0)">Add new user</a></li>
									</ul></li> -->
								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title" href="javascript:void(0)">
										<i class="ri-archive-line"></i> <span>Orders</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a href="/api/page/testfile">Order List</a></li>
										 <li><a href="/api/page/orderdetails">Order Delivered</a></li> 
										<li><a href="javascript:void(0)">Order Dispatch</a></li> 
									</ul></li>
								<li class="sidebar-list"><a
									class="linear-icon-link sidebar-link sidebar-title"
									href="javascript:void(0)"> <i class="ri-settings-line"></i>
										<span>Settings</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a href="javascript:void(0)">Profile Setting</a></li>
									</ul></li>
							</ul>
						</div>
						<div class="right-arrow" id="right-arrow">
							<i data-feather="arrow-right"></i>
						</div>
					</nav>
				</div>
			</div>
			<!-- Page Sidebar Ends-->
			<!-- Modal Start -->
		<!-- 	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
				data-bs-keyboard="false" tabindex="-1"
				aria-labelledby="staticBackdropLabel" aria-hidden="true">
				<div class="modal-dialog  modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-body">
							<h5 class="modal-title" id="staticBackdropLabel">Logging Out</h5>
							<p>Are you sure you want to log out?</p>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
							<div class="button-box">
								<form action="../login.html">
									<button type="button" class="btn">
										<a href="/api/auth/logout" class="btn  btn--yes btn-primary">Yes</a>
									</button>
								</form>
								<button type="button" class="btn btn--no"
									data-bs-dismiss="modal">No</button>

							</div>
						</div>
					</div>
				</div>
			</div> -->
			<%@include file="models.jsp"%>
			
		<script src="${pageContext.request.contextPath}/resources/js/order_details_list_loaded.js"
		type="text/javascript"></script>		
</body>
</html>