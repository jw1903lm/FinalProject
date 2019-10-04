<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/my-account.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:18 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>My Account</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <!-- Place favicon.ico in the root directory -->
        <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/view/img/favicon.ico">	
        <!-- All CSS Hear -->		
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/simple-line-icons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/animate.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/nice-select.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/jquery-ui.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/owl.carousel.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/mainmenu.css">
        <!-- Style CSS Hear -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/style.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/view/user/css/responsive.css">			
        <script src="<%=request.getContextPath()%>/view/user/js/vendor/modernizr-2.8.3.min.js"></script>
        <style>
            select {
                width: 100%;
                padding: 10px 15px;  
                border-radius: 4px;
            }
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                margin: 0; 
            }
        </style>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience. Thanks</p>
        <![endif]-->
        <!-- Add your application content here -->

        <div class="wrapper login-reg-page">
            <jsp:include page="header.jsp"/>

            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Account Detail</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- breadcrumb-area end -->

            <!-- main-content-wrap start -->
            <div class="main-content-wrap pt-100">
                <div class="container">
                    <div class="account-dashboard">
                        <div class="dashboard-upper-info">
                            <div class="row align-items-center no-gutters">
                                <div class="col-lg-3 col-md-12">
                                    <div class="d-single-info">
                                        <p class="user-name">Hello <span>${userInformation.userName}</span></p>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-12">
                                    <div class="d-single-info">
                                        <p>Need Assistance? Call our service at.</p>
                                        <p>${shopInformation.contactPhone}</p>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-12">
                                    <div class="d-single-info">
                                        <p>E-mail them at </p>
                                        <p>${shopInformation.contactEmail}</p>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-12">
                                    <div class="d-single-info text-lg-center">
                                        <a class="view-cart" href="<%=request.getContextPath()%>/userWishListController/toWishList.htm"><i class="fa fa-cart-plus"></i>View Wist List</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 col-lg-2">
                                <!-- Nav tabs -->
                                <ul class="nav flex-column dashboard-list" role="tablist">
                                    <li> <a class="nav-link active" data-toggle="tab" href="#orders">Orders</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#account-details">Account details</a></li>
                                    <li><a class="nav-link" data-toggle="tab" href="#change-password">Change Password</a></li>
                                    <li><a class="nav-link" href="<%=request.getContextPath()%>/userUsersController/logoutUser.htm">logout</a></li>
                                </ul>
                            </div>
                            <div class="col-md-12 col-lg-10">
                                <!-- Tab panes -->
                                <div class="tab-content dashboard-content">
                                    <div id="orders" class="tab-pane fade show active">
                                        <c:if test="${not empty listOrder}">
                                            <h3>Orders</h3>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Date</th>
                                                            <th>Status</th>
                                                            <th>Total</th>
                                                            <th>Actions</th>	 	 	 	
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${listOrder}" var="order">
                                                            <tr>
                                                                <td><fmt:formatDate type = "date" value = "${order.created}"/></td>
                                                                <td>${order.orderStatus.orderStatusName}</td>
                                                                <td>$<fmt:formatNumber type="number" maxFractionDigits="2" value="${order.totalPrice}"/></td>
                                                                <td><a class="view" href="<%=request.getContextPath()%>/userOrderController/initOrder.htm?orderId=${order.orderId}">view</a></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </c:if>
                                        <c:if test="${empty listOrder}">
                                            <h3>No Order</h3>   
                                        </c:if>
                                    </div>
                                    <div id="account-details" class="tab-pane fade">
                                        <h3>Account detail </h3>
                                        <div class="login">
                                            <div class="login-Register-info">
                                                <f:form action="updateUser.htm" commandName="userInformation">
                                                    <p class="coupon-input form-row-first">
                                                        <label>Email</label>
                                                        <f:input path="email" type="email" required="true"/>
                                                    </p>
                                                    <p class="coupon-input form-row-first">
                                                        <label>Full Name</label>
                                                        <f:input path="fullName" type="text" required="true"/>
                                                    </p>
                                                    <p class="coupon-input form-row-first">
                                                        <label>Phone</label>
                                                        <f:input path="phone" type="number"/>
                                                    </p>
                                                    <p class="coupon-input form-row-first">
                                                        <label>City</label>
                                                        <select name="chooseCity" >
                                                            <c:forEach items="${listCities}" var="city">
                                                                <c:if test="${city.cityId == myInformation.cities.cityId}">
                                                                    <option value="${city.cityId}" selected="true"> ${city.cityName}</option>
                                                                </c:if>
                                                                <c:if test="${city.cityId != myInformation.cities.cityId}">
                                                                    <option value="${city.cityId}"> ${city.cityName}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </p>
                                                    <p class="coupon-input form-row-first">
                                                        <label>Address</label>
                                                        <f:input path="userAddress" type="text"/>
                                                    </p>
                                                    <div class="button-box">
                                                        <button type="submit" class="default-btn">save</button>
                                                    </div>
                                                </f:form>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="change-password" class="tab-pane fade">
                                        <h3>Change Password</h3>
                                        <div class="login">
                                            <div class="login-Register-info">
                                                <f:form action="updatePassword.htm" commandName="userInformation">
                                                    <p class="coupon-input form-row-first">
                                                        <label>New Password</label>
                                                        <input name="newPassword" type="password" required="true"/>
                                                    </p>
                                                    <p class="coupon-input form-row-first">
                                                        <label>Retype Password</label>
                                                        <input name="retypePassword" type="password" required="true"/>
                                                    </p>
                                                    <p class="coupon-input form-row-first">
                                                        <label>Confirm Old Password</label>
                                                        <input name="oldPassword" type="password" required="true"/>
                                                    </p>
                                                    <div class="button-box">
                                                        <button type="submit" class="default-btn">change</button>
                                                    </div>
                                                </f:form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- main-content-wrap end -->

            <!-- footer-area start -->
            <jsp:include page="footer.jsp"/>
            <!-- footer-area end -->

            <!-- Modal start -->
            <div class="modal fade modal-wrapper" id="exampleModalCenter" >
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <div class="modal-inner-area row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="single-product-tab">
                                        <div class="zoomWrapper">
                                            <div id="img-1" class="zoomWrapper single-zoom">
                                                <a href="#">
                                                    <img id="zoom1" src="img/product/1.jpg" data-zoom-image="img/product/1.jpg" alt="big-1">
                                                </a>
                                            </div>
                                            <div class="single-zoom-thumb">
                                                <ul class="s-tab-zoom single-product-active owl-carousel" id="gallery_01">
                                                    <li>
                                                        <a href="#" class="elevatezoom-gallery active" data-update="" data-image="img/product/1.jpg" data-zoom-image="img/product/1.jpg"><img src="img/product/1.jpg" alt="zo-th-1"/></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="img/product/2.jpg" data-zoom-image="img/product/2.jpg"><img src="img/product/2.jpg" alt="zo-th-2"></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="img/product/3.jpg" data-zoom-image="img/product/3.jpg"><img src="img/product/3.jpg" alt="ex-big-3" /></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="img/product/4.jpg" data-zoom-image="img/product/4.jpg"><img src="img/product/4.jpg" alt="zo-th-4"></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="img/product/5.jpg" data-zoom-image="img/product/5.jpg"><img src="img/product/5.jpg" alt="zo-th-5"></a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div> 

                                </div>

                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <!-- product-thumbnail-content start -->
                                    <div class="quick-view-content">
                                        <div class="product-info">
                                            <h2>Product Name use hear</h2>
                                            <div class="rating-box">
                                                <ul class="rating d-flex">
                                                    <li><i class="icon-star"></i></li>
                                                    <li><i class="icon-star"></i></li>
                                                    <li><i class="icon-star"></i></li>
                                                    <li><i class="icon-star"></i></li>
                                                    <li><i class="icon-star"></i></li>
                                                </ul>
                                            </div>
                                            <div class="price-box">
                                                <span class="new-price">$25.50</span>
                                                <span class="old-price">$30.50</span>
                                            </div>
                                            <ul class="list-unstyled">
                                                <li>Brand: <a href="#">Hewlett-Packard</a></li>
                                                <li>Product Code: Digital</li>
                                                <li>Reward Points: 1000</li>
                                                <li>Availability: <span class="stock">In Stock</span></li>
                                            </ul>
                                            <div class="available-color">
                                                <h3>available color</h3>
                                                <ul class="color-list">
                                                    <li class="active"><a class="orange" href="#"></a></li>
                                                    <li><a class="paste" href="#"></a></li>
                                                </ul>
                                            </div>
                                            <form class="modal-cart">
                                                <div class="quantity">
                                                    <label>Quantity</label>
                                                    <div class="cart-plus-minus">
                                                        <input type="number" value="1" min="0" step="1" class="input-box">
                                                    </div>
                                                </div>
                                            </form>
                                            <ul class="quick-add-to-cart">
                                                <li><a href="#" class="add-to-cart"><i class="icon-basket-loaded"></i> Add to cart</a></li>
                                                <li><a class="wishlist-btn" href="#"><i class="icon-heart"></i></a></li>
                                                <li><a class="compare-btn" href="#"><i class="icon-refresh"></i></a></li>
                                            </ul>
                                            <p>Tags: <a href="#">Movado</a>,<a href="#">Omega</a><a href="#"></a></p>
                                        </div>
                                    </div>
                                    <!-- product-thumbnail-content end -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>   
            <!-- Modal end -->

        </div>   


        <!-- jquery -->		
        <script src="<%=request.getContextPath()%>/view/user/js/vendor/jquery-1.12.4.min.js"></script>
        <!-- all plugins JS hear -->		
        <script src="<%=request.getContextPath()%>/view/user/js/popper.min.js"></script>	
        <script src="<%=request.getContextPath()%>/view/user/js/bootstrap.min.js"></script>	
        <script src="<%=request.getContextPath()%>/view/user/js/owl.carousel.min.js"></script>
        <script src="<%=request.getContextPath()%>/view/user/js/jquery.mainmenu.js"></script>	
        <script src="<%=request.getContextPath()%>/view/user/js/ajax-email.js"></script>
        <script src="<%=request.getContextPath()%>/view/user/js/plugins.js"></script>
        <!-- main JS -->		
        <script src="<%=request.getContextPath()%>/view/user/js/main.js"></script>
    </body>

    <!-- Mirrored from demo.hasthemes.com/t90-v2/my-account.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:18 GMT -->
</html>