<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp"%>
</head>
<body>

<!-- include header  -->

<%@ include file="header.jsp"%>
    
    <section>
        <div class="container-fluid">
            <div class="row bg-secondary bg-opacity-25">
                <div class="col-xs-12 py-1">
                    <a href="/home" class="text-dark">Home</a>
                    <span aria-hidden="true">|</span>
                    <span>Products</span>
                </div>
            </div>
            <div class="content-area">
                <div class="filter_header">
                    <div class="button">
                        <!-- <button class="btn"><i class="fa-solid fa-bars me-2"></i> Filter</button> -->
                    </div>
                    <div class="filter_toolbar">
                        <select class="form-select" aria-label="Default select example">
                            <option selected>Default sorting</option>
                            <option value="1">Sort by popularity</option>
                            <option value="2">Sort by average rating</option>
                            <option value="3">Sort by latest</option>
                            <option value="4">Sort by price: low to high</option>
                            <option value="5">Sort by price: high to low</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <div class="side_filter">
                            <h6>FILTER</h6>
                            <div class="accordion">

                                <div class="accordion-item">
                                    <h5 class="accordion-header" id="filter-one">
                                        <button class="accordion-button collapsed" type="button"
                                            data-bs-toggle="collapse" data-bs-target="#peice" aria-expanded="false"
                                            aria-controls="peice">
                                            PRICE
                                        </button>
                                    </h5>
                                    <div id="peice" class="accordion-collapse collapse" aria-labelledby="filter-one">
                                        <div class="accordion-body">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="peice-01">
                                                <label class="form-check-label" for="peice-01">
                                                    MRP- 500 to 1000
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="peice-02">
                                                <label class="form-check-label" for="peice-02">
                                                    MRP- 1500 to 2000
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="peice-03">
                                                <label class="form-check-label" for="peice-03">
                                                    MRP- 2000 to 3000
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="filter-two">
                                        <button class="accordion-button collapsed" type="button"
                                            data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo"
                                            aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                                            DISCOUNT
                                        </button>
                                    </h2>
                                    <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse"
                                        aria-labelledby="filter-two">
                                        <div class="accordion-body">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                    id="discount01">
                                                <label class="form-check-label" for="discount01">
                                                    10% and above
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                    id="discount02">
                                                <label class="form-check-label" for="discount02">
                                                    20% and above
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                    id="discount03">
                                                <label class="form-check-label" for="discount03">
                                                    30% and above
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                    id="discount04">
                                                <label class="form-check-label" for="discount04">
                                                    40% and above
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value=""
                                                    id="discount05">
                                                <label class="form-check-label" for="discount05">
                                                    50% and above
                                                </label>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="filter-Three">
                                        <button class="accordion-button collapsed" type="button"
                                            data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree"
                                            aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                                            COLOUR
                                        </button>
                                    </h2>
                                    <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse"
                                        aria-labelledby="filter-Three">
                                        <div class="accordion-body">
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="color-01">
                                                <label class="form-check-label" for="color-01">
                                                    Baby Pink
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="color-02">
                                                <label class="form-check-label" for="color-02">
                                                    Black
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="color-03">
                                                <label class="form-check-label" for="color-03">
                                                    Cream
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10">
                        <div class="row" id="appendeddata">
                      <%--   <c:forEach var="var" items="${listOfData}">
                       
                            <div class="col-md-3">
                                <div class="product_item">
                                    <a href="/api/page/product-details/${var.pid}">
                                        <img src="${pageContext.request.contextPath}/resources/upload_file/${var.filesretrieve[0]}" alt="img">
                                    </a>
                                    <div class="product_cart">
                                        <ul>
              <li><a href="javascript:void(0)" title="Add to Cart"><i class="fa-solid fa-cart-shopping"></i></a>
                                            </li>
               <li><a href="javascript:void(0)" title="quick-view"><i class="fa-solid fa-eye"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="product_text">
                                    <p>SKU: VJKS001</p> <h6>Pink Taffy</h6> <h5>MRP: 1899/-</h5>
                                    
                                     <c:forEach var="var2" items="${var.productsize}">
                                    <h5>Size: ${var.productsize}-</h5>
                                    </c:forEach>
                                    <h5>Size: ${var.productsize}-</h5>
                                    
                                </div>
                            </div>
                            </c:forEach> --%>

                        </div>
                    </div>
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
                            <li><a href="javascript:void(0)"><i class="fa-brands fa-facebook"></i></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-brands fa-twitter"></i></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-brands fa-instagram"></i></a></li>
                            <!-- <li><a href="#"><i class="fa-brands fa-pinterest"></i></a></li> -->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact Us Section End -->
    
    <!-- include footer  -->
    
    
<%@ include file="footer.jsp"%>
	<script src="${pageContext.request.contextPath}/resources/js/post.js"
		type="text/javascript"></script>
		
		<script src="${pageContext.request.contextPath}/resources/js/product-details.js"
		type="text/javascript"></script>
	<%-- 	<script src="${pageContext.request.contextPath}/resources/js/category-loaded.js"
		type="text/javascript"></script> --%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
$("#filter-one").click(()=>{
	
	//alert("price clicked..");
	
});








</script>




























</body>
</html>