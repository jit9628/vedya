<%@page import="java.awt.Window"%>
<%-- <%@page import="java.net.http.HttpClient.Redirect"% --%>
<%@page import="org.springframework.web.servlet.DispatcherServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" dir="ltr">
<head>
<%@include file="linking.jsp"%>

<!--  this script responsible for after logout back button block
s-->
<!-- <script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script> -->
</head>
<body>
	<%-- <sec:authorize access="hasRole('ROLE_ADMIN')" > --%>
	<%
	  response.setHeader("Cache-Control","no-cache");
	  response.setHeader("Cache-Control","no-store");
	  response.setHeader("Pragma","no-cache");
	  response.setDateHeader ("Expires", 0);
	request.getSession().getAttribute("userid");
	System.out.println("userid is " + request.getSession().getAttribute("userid"));
	if (request.getSession().getAttribute("userid") != null
			&& request.getSession().getAttribute("userid") != ""
			||
			request.getSession().getAttribute("auth") != null && request.getSession().getAttribute("userid") != ""
			
			
			
			
			) {
	%>>
	<%@include file="headers.jsp"%>
	<%@include file="Content-Body.jsp"%>
	<div class="container-fluid">
		<footer class="footer">
			<div class="row">
				<div class="col-md-12 footer-copyright text-center">
					<p class="mb-0">Copyright 2022 © Vedya</p>
				</div>
			</div>
		</footer>
	</div>
	<!-- footer End-->
	</div>
	<!-- index body end -->
	</div>
	<!-- Page Body End -->
	</div>
	<!-- page-wrapper End-->
	<%-- </sec:authorize>  --%>
	<!-- Modal End -->
	<%@include file="scriptfileslinks.jsp"%>
	<%
	} else {
	response.sendRedirect("/api/auth/sign");
	}
	%>
	
		<script src="${pageContext.request.contextPath}/resources/js/order_details_list_loaded.js"
		type="text/javascript"></script>
</body>
</html>