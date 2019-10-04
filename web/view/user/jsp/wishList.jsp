<%-- 
    Document   : wishList
    Created on : Aug 26, 2019, 5:28:47 PM
    Author     : MinhQuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/wishlist.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:19 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Wish List</title>
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
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience. Thanks</p>
        <![endif]-->
        <!-- Add your application content here -->

        <div class="wrapper wishlist-page">
            <jsp:include page="header.jsp"/>

            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Wishlist</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- breadcrumb-area end -->

            <!-- main-content-wrap start -->
            <div class="main-content-wrap pt-100">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <form action="#">
                                <c:if test="${not empty listProduct}">
                                    <div class=" table-content table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th class="plantmore-product-remove">remove</th>
                                                    <th class="plantmore-product-thumbnail">images</th>
                                                    <th class="cart-product-name">Product</th>
                                                    <th class="plantmore-product-price">Unit Price</th>
                                                    <th class="plantmore-product-stock-status">Stock Status</th>
                                                    <th class="plantmore-product-add-cart">add to cart</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listProduct}" var="product">
                                                    <tr>
                                                        <td class="plantmore-product-remove"><a href="<%=request.getContextPath()%>/userWishListController/updateWishList.htm?productId=${product.product.productId}"><i class="fa fa-times"></i></a></td>
                                                        <td class="plantmore-product-thumbnail"><a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">
                                                                <c:if test="${product.image != null}">
                                                                    <img style="width: 80px;height: 102px"alt="" src="<%=request.getContextPath()%>/view/img/${product.image.link}">
                                                                </c:if>
                                                                <c:if test="${product.image == null}">
                                                                    <img style="width: 80px;height: 102px"alt="" src="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png">
                                                                </c:if>
                                                            </a>
                                                        </td>
                                                        <td class="plantmore-product-name"><a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">${product.product.productName}</a></td>
                                                        <td class="plantmore-product-price"><span class="amount">$${product.salePrice}</span></td>
                                                        <c:if test="${product.available==true}">
                                                            <td class="plantmore-product-stock-status"><span class="in-stock">in stock</span></td>
                                                        </c:if>
                                                        <c:if test="${product.available==false}">
                                                            <td class="plantmore-product-stock-status"><span class="out-stock">out stock</span></td>
                                                        </c:if>
                                                        <td class="plantmore-product-add-cart"><a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="quick-view" title="Add to Cart">add to cart</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </c:if>
                                <c:if test="${empty listProduct}">
                                    <h3>Your Wish List Is Empty</h3>
                                </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- main-content-wrap end -->

            <!-- footer-area start -->
            <jsp:include page="footer.jsp"/>
            <!-- footer-area end -->

            <!-- Modal -->
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
                                                    <img id="zoom1" src="<%=request.getContextPath()%>/view/img/product/1.jpg" data-zoom-image="<%=request.getContextPath()%>/view/img/product/1.jpg" alt="big-1">
                                                </a>
                                            </div>
                                            <div class="single-zoom-thumb">
                                                <ul class="s-tab-zoom single-product-active owl-carousel" id="gallery_01">
                                                    <li>
                                                        <a href="#" class="elevatezoom-gallery active" data-update="" data-image="<%=request.getContextPath()%>/view/img/product/1.jpg" data-zoom-image="<%=request.getContextPath()%>/view/img/product/1.jpg"><img src="<%=request.getContextPath()%>/view/img/product/1.jpg" alt="zo-th-1"/></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="<%=request.getContextPath()%>/view/img/product/2.jpg" data-zoom-image="<%=request.getContextPath()%>/view/img/product/2.jpg"><img src="<%=request.getContextPath()%>/view/img/product/2.jpg" alt="zo-th-2"></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="<%=request.getContextPath()%>/view/img/product/3.jpg" data-zoom-image="<%=request.getContextPath()%>/view/img/product/3.jpg"><img src="<%=request.getContextPath()%>/view/img/product/3.jpg" alt="ex-big-3" /></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="<%=request.getContextPath()%>/view/img/product/4.jpg" data-zoom-image="<%=request.getContextPath()%>/view/img/product/4.jpg"><img src="<%=request.getContextPath()%>/view/img/product/4.jpg" alt="zo-th-4"></a>
                                                    </li>
                                                    <li class="">
                                                        <a href="#" class="elevatezoom-gallery" data-image="<%=request.getContextPath()%>/view/img/product/5.jpg" data-zoom-image="<%=request.getContextPath()%>/view/img/product/5.jpg"><img src="<%=request.getContextPath()%>/view/img/product/5.jpg" alt="zo-th-5"></a>
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
                                                <li>Brand: Hewlett-Packard</li>
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
                                                <li><a href="" class="add-to-cart"><i class="icon-basket-loaded"></i> Add to cart</a></li>
                                                <li><a class="wishlist-btn" href="#"><i class="icon-heart"></i></a></li>
                                                <li><a class="compare-btn" href="#"><i class="icon-refresh"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!-- product-thumbnail-content end -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/wishlist.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:20 GMT -->
</html>
