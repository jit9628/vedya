<!doctype html>
<html lang="ar" dir="ltr">

<head>
   <%@ include file="links.jsp"%>
</head>

<body>
    <!-- Header Section Start -->
    <%@ include file="header.jsp"%>
    <!-- Header Section End -->
    <!-- Shopping Cart Section Start -->
    <section>
        <div class="container">
            <div class="shopping_cart_heading text-center my-5">
                <h4>Shopping Cart </h4>
            </div>
            <div class="row justify-content-between">
                <div class="col-12 col-lg-7 col-md-12">
                    <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x mb-4">
                        <li class="list-group-item">
                            <div class="row align-items-center">
                                <div class="col-3">
                                    <!-- Image -->
                                    <a href="#">
                                        <img src="./images/shop/p-01.jpg" alt="img" class="img-fluid">
                                    </a>
                                </div>
                                <div class="col d-flex align-items-center justify-content-between">
                                    <div class="pl-2">
                                        <h4 class="mb-1">Women Striped Shirt Dress
                                        </h4>
                                        <p class="mb-1"><span class="text-dark">Size: 40</span></p>
                                        <p class="mb-3"><span class="text-dark">Color: Blue</span></p>
                                        <h4 class="fs-md ft-medium mb-3 lh-1">MRP: 1899/- </h4>
                                        <select class="mb-2 custom-select w-auto">
                                            <option value="1" selected="">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </div>
                                    <div class="fls_last">
                                        <button class="close_slide gray"><i class="fa-solid fa-xmark fs-6"></i></button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="col-12 col-md-12 col-lg-4">
                    <div class="card">
                        <div class="card-header card_bg">
                            <h5 class="fw-bold">Cart totals</h5>
                        </div>
                        <div class="card-body">
                            <ul class="list-group  list-group-flush-x">
                                <li class="list-group-item d-flex">
                                    <span>Subtotal</span>
                                    <span class="ms-auto fw-bold"> MRP - 5000</span>
                                </li>
                                <li class="list-group-item d-flex">
                                    <span>Tax</span>
                                    <span class="ms-auto fw-bold"> MRP - 500</span>
                                </li>
                                <li class="list-group-item d-flex">
                                    <span class="fw-bold">Total</span>
                                    <span class="ms-auto fw-bold"> MRP - 5500</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <a href="#" class="btn btn_Checkout btn-block btn-dark mb-5 mt-3" id="disabledval">Proceed to
                            Checkout </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->
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
    <!-- Footer Start -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <h4>Product Links</h4>
                    <ul>
                        <li><a href="./shop.html">All Products</a></li>
                        <li><a href="javascript:void(0)">MariGold Yellow Festive Set</a></li>
                        <li><a href="javascript:void(0)">Slate Blue Lace Set</a></li>
                        <li><a href="javascript:void(0)">Carnation Pink Lace Set</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h4>Men's</h4>
                    <ul>
                        <li><a href="javascript:void(0)">Sage Green Mens Set</a></li>
                        <li><a href="javascript:void(0)">Mustard Yellow Mens Set</a></li>
                        <li><a href="javascript:void(0)">Pine Green Mens Set</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h4>Women's </h4>
                    <ul>
                        <li><a href="javascript:void(0)">SeeoCarrot Orange Festive Set</a></li>
                        <li><a href="javascript:void(0)">Olive Green Festive Set</a></li>
                        <li><a href="javascript:void(0)">Apricot Peach</a></li>
                        <li><a href="javascript:void(0)">Canvas Tan</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h4>NewsLetter</h4>
                    <ul>
                        <li><a href="javascript:void(0)">Have Questions?</a></li>
                        <form action="./ContactUs.html">
                            <button class="btn">Contact Us</button>
                        </form>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    <!-- Mini Footer Start -->
    <section>
        <div class="container">
            <div class="mini_footer">
                <div class="row">
                    <div class="col-md-6">
                        <p>Copyright © 2022 vedakshi jadaun</p>
                    </div>
                    <div class="col-md-6">
                        <p class="text-end">Powered by vedakshi jadaun</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Mini Footer End -->
    <!-- Footer End  -->
    <!-- Script Start -->
    <script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</body>

</html>