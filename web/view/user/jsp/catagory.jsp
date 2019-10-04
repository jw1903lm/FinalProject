<%-- 
    Document   : catagory
    Created on : Aug 26, 2019, 5:21:38 PM
    Author     : MinhQuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/shop.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:17 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Category</title>
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

        <div class="wrapper shop-page">
            <jsp:include page="header.jsp"/>

            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Shop</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- breadcrumb-area end -->

            <!-- main-content-wrap start -->
            <div class="main-content-wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 order-2 order-lg-1">
                            <!-- filter-wrapper start -->
                            <div class="filter-wrapper pt-100">
                                <!-- filter-wrap start -->
                                <div class="filter-wrap mb-30">
                                    <h4 class="filter-title">Price</h4>
                                    <div class="list_group_item">
                                        <ul>
                                            <c:if test="${catagoryDetail.min == 0 && catagoryDetail.max == 0}">
                                                <li><a style="color: red" href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=0&brandId=${catagoryDetail.brandId}">All Price</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=100&brandId=${catagoryDetail.brandId}">$0 - $100</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=100&max=400&brandId=${catagoryDetail.brandId}">$100 - $400</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=400&max=700&brandId=${catagoryDetail.brandId}">$400 - $700</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=700&max=1000&brandId=${catagoryDetail.brandId}">$700 - $1000</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=1000&max=10000&brandId=${catagoryDetail.brandId}">More than $1000</a></li>
                                                </c:if>
                                                <c:if test="${catagoryDetail.min == 0 && catagoryDetail.max == 100}">
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=0&brandId=${catagoryDetail.brandId}">All Price</a></li>
                                                <li><a style="color: red" href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=100&brandId=${catagoryDetail.brandId}">$0 - $100</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=100&max=400&brandId=${catagoryDetail.brandId}">$100 - $400</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=400&max=700&brandId=${catagoryDetail.brandId}">$400 - $700</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=700&max=1000&brandId=${catagoryDetail.brandId}">$700 - $1000</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=1000&max=10000&brandId=${catagoryDetail.brandId}">More than $1000</a></li>
                                                </c:if>
                                                <c:if test="${catagoryDetail.min == 100 && catagoryDetail.max == 400}">
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=0&brandId=${catagoryDetail.brandId}">All Price</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=100&brandId=${catagoryDetail.brandId}">$0 - $100</a></li>
                                                <li><a style="color: red" href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=100&max=400&brandId=${catagoryDetail.brandId}">$100 - $400</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=400&max=700&brandId=${catagoryDetail.brandId}">$400 - $700</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=700&max=1000&brandId=${catagoryDetail.brandId}">$700 - $1000</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=1000&max=10000&brandId=${catagoryDetail.brandId}">More than $1000</a></li>
                                                </c:if>
                                                <c:if test="${catagoryDetail.min == 400 && catagoryDetail.max == 700}">
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=0&brandId=${catagoryDetail.brandId}">All Price</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=100&brandId=${catagoryDetail.brandId}">$0 - $100</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=100&max=400&brandId=${catagoryDetail.brandId}">$100 - $400</a></li>
                                                <li><a style="color: red" href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=400&max=700&brandId=${catagoryDetail.brandId}">$400 - $700</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=700&max=1000&brandId=${catagoryDetail.brandId}">$700 - $1000</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=1000&max=10000&brandId=${catagoryDetail.brandId}">More than $1000</a></li>
                                                </c:if> 
                                                <c:if test="${catagoryDetail.min == 700 && catagoryDetail.max == 1000}">
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=0&brandId=${catagoryDetail.brandId}">All Price</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=100&brandId=${catagoryDetail.brandId}">$0 - $100</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=100&max=400&brandId=${catagoryDetail.brandId}">$100 - $400</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=400&max=700&brandId=${catagoryDetail.brandId}">$400 - $700</a></li>
                                                <li><a style="color: red" href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=700&max=1000&brandId=${catagoryDetail.brandId}">$700 - $1000</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=1000&max=10000&brandId=${catagoryDetail.brandId}">More than $1000</a></li>
                                                </c:if>
                                                <c:if test="${catagoryDetail.min == 1000 && catagoryDetail.max == 10000}">
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=0&brandId=${catagoryDetail.brandId}">All Price</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=0&max=100&brandId=${catagoryDetail.brandId}">$0 - $100</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=100&max=400&brandId=${catagoryDetail.brandId}">$100 - $400</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=400&max=700&brandId=${catagoryDetail.brandId}">$400 - $700</a></li>
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=700&max=1000&brandId=${catagoryDetail.brandId}">$700 - $1000</a></li>
                                                <li><a style="color: red" href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=1000&max=10000&brandId=${catagoryDetail.brandId}">More than $1000</a></li>
                                                </c:if>
                                        </ul>
                                    </div>
                                </div>
                                <!-- filter-wrap end -->
                                <!-- filter-wrap start -->
                                <div class="filter-wrap mb-30">
                                    <h4 class="filter-title">Brands</h4>
                                    <div class="list_group_item">
                                        <ul>
                                            <c:if test="${catagoryDetail.brandId != 0}">
                                                <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=${catagoryDetail.min}&max=${catagoryDetail.max}&brandId=0">All Brand</a></li>
                                            </c:if>
                                            <c:if test="${catagoryDetail.brandId == 0}">
                                                <li><a style="color: red"href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=${catagoryDetail.min}&max=${catagoryDetail.max}&brandId=0">All Brand</a></li>
                                            </c:if>
                                            <c:forEach items="${listBrand}" var="brand">
                                                <c:if test="${brand.brandId != catagoryDetail.brandId}">
                                                    <li><a href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=${catagoryDetail.min}&max=${catagoryDetail.max}&brandId=${brand.brandId}">${brand.brandName}</a></li>
                                                </c:if>
                                                <c:if test="${brand.brandId == catagoryDetail.brandId}">
                                                    <li><a style="color: red"href="toCatagory.htm?page=1&catagoryId=${catagoryDetail.catagoryId}&min=${catagoryDetail.min}&max=${catagoryDetail.max}&brandId=${brand.brandId}">${brand.brandName}</a></li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <!-- filter-wrap end -->
                                <!-- filter-wrap start -->
                            </div>
                            <!-- filter-wrapper end -->
                        </div>
                        <div class="col-lg-9 order-1 order-lg-2">
                            <div class="shop-top-bar pt-100">
                                <div class="shop-bar-inner">
                                    <div class="product-view-mode">
                                        <!-- shop-item-filter-list start -->
                                        <ul role="tablist" class="nav shop-item-filter-list">
                                            <li role="presentation" class="active"><a href="#grid-view" aria-controls="grid-view" role="tab" data-toggle="tab" class="active show" aria-selected="true"><i class="fa fa-th"></i></a></li>
                                            <li role="presentation"><a href="#list-view" aria-controls="list-view" role="tab" data-toggle="tab"><i class="fa fa-th-list"></i></a></li>
                                        </ul>
                                        <!-- shop-item-filter-list end -->
                                    </div>
                                    <div class="toolbar-amount">
                                        <span>Total: ${totalRecords}</span>
                                    </div>
                                </div>
                                <!-- product-select-box start -->
                                <div class="product-select-box">
                                    <div class="product-short">
                                        <label>Sort By: </label>
                                        <select class="nice-select">
                                            <option value="Relevance">Relevance</option>
                                            <option value="Name">Name (A - Z)</option>
                                            <option value="Name">Name (Z - A)</option>
                                            <option value="Price">Price (Low &gt; High)</option>
                                            <option value="Rating">Rating (Lowest)</option>
                                            <option value="Model-asc">Model (A - Z)</option>
                                            <option value="Model-az">Model (Z - A)</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- product-select-box end -->
                            </div>
                            <!--  shop-products-wrapper strar -->
                            <div class="shop-products-wrapper">
                                <!-- tab-content start -->
                                <div class="tab-content">
                                    <div id="grid-view" class="tab-pane fade active show" role="tabpanel">
                                        <div class="shop-product-area">
                                            <div class="row">
                                                <c:forEach items="${listProduct}" var="product">
                                                    <div class="col-lg-4 col-md-4 col-sm-6">
                                                        <!-- single-product-area start -->
                                                        <div class="single-product-area mt-30">
                                                            <div class="product-thumb">
                                                                <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">
                                                                    <c:if test="${product.image != null}">
                                                                        <img style="width: 100%;height: 334px" class="primary-image" src="<%=request.getContextPath()%>/view/img/${product.image.link}" alt="">
                                                                    </c:if>
                                                                    <c:if test="${product.image == null}">
                                                                        <img style="width: 100%;height: 334px" class="primary-image" src="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png" alt="">
                                                                    </c:if>
                                                                </a>
                                                                <c:if test="${product.salePrice != product.product.price}">
                                                                    <div class="label-product label_sale">-${product.product.sales.percentage}%</div>
                                                                </c:if>
                                                                <div class="action-links">
                                                                    <c:if test="${loginUser != null}">
                                                                        <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=catagory" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
                                                                        </c:if>
                                                                </div>
                                                            </div>
                                                            <div class="product-caption">
                                                                <h4 class="product-name"><a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">${product.product.productName}</a></h4>
                                                                <div class="price-box">
                                                                    <span class="new-price">$${product.salePrice}</span>
                                                                    <c:if test="${product.salePrice != product.product.price}">
                                                                        <span class="old-price">$${product.product.price}</span>
                                                                    </c:if>
                                                                </div>
                                                                <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="action-cart-btn">
                                                                    Add to Cart
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <!-- single-product-area end -->
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="list-view" class="tab-pane fade" role="tabpanel">
                                        <div class="row">
                                            <div class="col">
                                                <c:forEach items="${listProduct}" var="product">
                                                    <div class="row product-layout-list">
                                                        <div class="col-lg-4 col-md-4">
                                                            <div class="product-thumb">
                                                                <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">
                                                                    <c:if test="${product.image != null}">
                                                                        <img style="width: 100%;height: 334px" class="primary-image" src="<%=request.getContextPath()%>/view/img/${product.image.link}" alt="">
                                                                    </c:if>
                                                                    <c:if test="${product.image == null}">
                                                                        <img style="width: 100%;height: 334px" class="primary-image" src="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png" alt="">
                                                                    </c:if>
                                                                </a>
                                                                <c:if test="${product.salePrice != product.product.price}">
                                                                    <div class="label-product label_sale">-${product.product.sales.percentage}%</div>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-8 col-md-8">
                                                            <div class="product-caption">
                                                                <h4 class="product-name"><a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">${product.product.productName}</a></h4>
                                                                <div class="rating-box">
                                                                    <c:if test="${product.rating != 0}">
                                                                        <ul class="rating d-flex">
                                                                            <c:forEach begin="1" end="${product.rating}">
                                                                                <li><i class="icon-star"></i></li>
                                                                                </c:forEach>
                                                                        </ul>
                                                                    </c:if>
                                                                    <c:if test="${product.rating == 0}">
                                                                        <span>No Rating</span>
                                                                    </c:if>
                                                                </div>
                                                                <div class="price-box">
                                                                    <span class="new-price">$${product.salePrice}</span>
                                                                    <c:if test="${product.salePrice != product.product.price}">
                                                                        <span class="old-price">$${product.product.price}</span>
                                                                    </c:if>
                                                                </div>
                                                                <p class="product-des">${product.product.productDescription}</p>
                                                                <ul class="quick-add-to-cart">
                                                                    <li><a class="add-to-cart" href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}"><i class="icon-basket-loaded"></i> Add to cart</a></li>                              
                                                                </ul>
                                                                <div style="margin-top: 5px"></div>
                                                                <c:if test="${loginUser != null}">
                                                                    <ul class="quick-add-to-cart">
                                                                        <li><a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=catagory" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a></li>
                                                                    </ul>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- paginatoin-area start -->
                                    <div class="paginatoin-area">
                                        <div class="row">
                                            <div class="col-12">
                                                <c:if test="${totalPages > 1}">
                                                    <ul class="pagination-box">
                                                        <c:forEach items="${listPage}" var = "page">
                                                            <c:if test="${page == catagoryDetail.page}">
                                                                <li><a style="color: red" href="toCatagory.htm?page=${page}&catagoryId=${catagoryDetail.catagoryId}&min=${catagoryDetail.min}&max=${catagoryDetail.max}&brandId=${catagoryDetail.brandId}">${page}</a></li>
                                                            </c:if>
                                                            <c:if test="${page != catagoryDetail.page}">
                                                                <li><a href="toCatagory.htm?page=${page}&catagoryId=${catagoryDetail.catagoryId}&min=${catagoryDetail.min}&max=${catagoryDetail.max}&brandId=${catagoryDetail.brandId}">${page}</a></li>
                                                            </c:if>
                                                        </c:forEach>
                                                    </ul>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- paginatoin-area end -->
                                </div>
                                <!-- tab-content end -->
                            </div>
                            <!--  shop-products-wrapper end -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- main-content-wrap end -->

            <!-- footer-area start -->
            <jsp:include page="footer.jsp"/>
            <!-- footer-area end -->

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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/shop.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:18 GMT -->
</html>