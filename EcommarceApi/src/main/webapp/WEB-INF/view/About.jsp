<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Vedya</title>
<!-- CSS -->
<%@ include file="links.jsp"%>
<!--    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/bootstrap.rtl.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css" type="text/css"> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">


</head>

<body>
	<%@ include file="header.jsp"%>
	<!-- About Us Section Start -->
	<section>
		<div class="container">
			<div class="about_banner mt-4">
				<img
					src="${pageContext.request.contextPath}/resources/images/about-banner.jpg"
					alt="img" />
			</div>
			<div class="row">
				<div class="col-md-12 my-5">

					<p>The VJ (Vedya) is a fashion Textile Brand from
						Jaipur (Rajasthan) which is a folk representation to indian finest
						Craftsmanship, We aim to praise traditional textiles, Together
						with all artisanship who appeared active in preserving the
						artistry. We are embracing rituals in it's purest form with
						ageless approach to fashion in capricious world.</p>
					<p>Vedakshi symbolises- Eyes with sacred knowledge , The
						Jadaun's are a clan of Rajputs</p>


					<p>We speak for "The Intrinsic Bannai" by creating essential
						elements, minimalist artwork, elegant sight and workmanship.</p>
					<p>We Consisting of unique garment range made from scratch to
						finished product using zero polyster policy, we bring about our
						forte from pure raw cotton fabrics carry on by wholesome dying
						process to fine embroidery detailing using cotton thread finishing
						it with precise stitchery.</p>
					<p>Our garments are made sensibly with 100% natural fabrics,
						safe dyes alongside we are functioning for less textile waste.</p>
					<p>We ensure consistently good quality, fine detailing and well
						finished product.</p>
					<p class="mb-5">We take care of our "tribe the karigar's" by
						admiring their creativity, Helping with fair wages under suitable
						terms and conditions.</p>
						
						
					<!-- <span class="fw-bold">
						<p>प्रत्यात्माम् पृष्ठतः एकम् अव्यक्तम् आख्यानम् अस्ति, यः संस्कारस्य नैतिकमूलात् उपजायते</p>
					</span> -->
				</div>
				<!-- <div class="col-md-4">
                    <div class="about_logo align-middle">
                        <img src="./images/logo.png" alt="img">
                    </div>
                </div> -->
			</div>
		</div>
	</section>
	<!-- About Us Section End -->
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



	<!-- Script Start -->
	<script src="./js/bootstrap.bundle.min.js"></script>

	<%@ include file="footer.jsp"%>
	<%-- <script src="${pageContext.request.contextPath}/resources/js/test.js"
		type="text/javascript">
		
	</script> --%>


</body>
</html>