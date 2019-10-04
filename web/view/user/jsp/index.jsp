<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/index-4.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:07 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Index </title>
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
        <div class="wrapper home-4">
            <jsp:include page="header.jsp"/>
            <!-- slider-main-area start -->
            <div class="slider-main-area">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="slider-active owl-carousel">
                                <c:forEach items="${listSliders}" var="slider">
                                    <div class="slider-wrapper-4" style="width: 1170px; height: 578px; background-image:url(<%=request.getContextPath()%>/view/img/${slider.imageLink})">
                                        <div class="row">
                                            <div class="col-lg-6 offset-md-1 col-md-8 col-12">
                                                <div class="slider-text-info style-4 slider-text-animation">
                                                    <h2 class="title1">${slider.title}</h2>
                                                    <h1 class="sub-title">${slider.subTitle}</h1>
                                                    <div class="slider-1-des">
                                                        <p>${slider.content}</p>
                                                    </div>
                                                    <div class="slier-btn-1">
                                                        <a title="shop now" href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${slider.products.productId}" class="btn">see more</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- slider-main-area start -->

            <!-- banner-area start -->
            <div class="banner-area">
                <div class="container">
                    <div class="row">
                        <c:forEach items="${listSmallBanners}" var="smallBanner">
                            <div class="col-lg-4 col-md-4">
                                <div class="single-banner-static mt-30">
                                    <a href="<%=request.getContextPath()%>/userCatagoryController/toCatagoryId.htm?catagoryId=${smallBanner.catagories.catagoryId}">
                                        <img style="width: 100%;height: 214px" src="<%=request.getContextPath()%>/view/img/${smallBanner.bannerImage}" alt="">
                                        <span class="static-banner-text">
                                            <span class="text1">${smallBanner.bannerName}</span>
                                            <span class="text2">${smallBanner.bannerDescription}</span>
                                        </span>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>                   
                    </div>
                </div>
            </div>
            <!-- banner-area end -->

            <!-- product-area start -->
            <div class="product-area pt-100">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="section-title-2">
                                <div class="tabs-categorys-list">
                                    <ul class="nav" role="tablist">
                                        <li role="presentation" class="active"><a href="#new-arrivals" aria-controls="new-arrivals" role="tab" data-toggle="tab">New arrivals</a></li>
                                        <li role="presentation"><a href="#best-sellers" aria-controls="best-sellers" role="tab" data-toggle="tab">Sale products</a></li>
                                        <li role="presentation"><a href="#on-sellers" aria-controls="on-sellers" role="tab" data-toggle="tab">bestselling</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="new-arrivals">
                            <div class="row">
                                <div class="product-active owl-carousel">
                                    <c:forEach items="${listNewArrival}" var="product">
                                        <div class="col-lg-3">
                                            <!-- single-product-area start -->
                                            <div class="single-product-area">
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
                                                            <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=index" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-caption">
                                                    <h4 class="product-name"><a href="single-product.html">${product.product.productName}</a></h4>
                                                    <div class="price-box">
                                                        <span class="new-price">$${product.salePrice}</span>
                                                        <c:if test="${product.salePrice != product.product.price}">
                                                            <span class="old-price">$${product.product.price}</span>
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${product.available == true}">
                                                        <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="action-cart-btn">
                                                            Add to Cart
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.available == false}">
                                                        <span class="action-cart-btn">Out Stock</span>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <!-- single-product-area end -->
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="best-sellers">
                            <div class="row">
                                <div class="product-active owl-carousel">
                                    <c:forEach items="${listSaleProduct}" var="product">
                                        <div class="col-lg-3">
                                            <!-- single-product-area start -->
                                            <div class="single-product-area">
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
                                                            <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=index" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-caption">
                                                    <h4 class="product-name"><a href="single-product.html">${product.product.productName}</a></h4>
                                                    <div class="price-box">
                                                        <span class="new-price">$${product.salePrice}</span>
                                                        <c:if test="${product.salePrice != product.product.price}">
                                                            <span class="old-price">$${product.product.price}</span>
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${product.available == true}">
                                                        <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="action-cart-btn">
                                                            Add to Cart
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.available == false}">
                                                        <span class="action-cart-btn">Out Stock</span>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <!-- single-product-area end -->
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="on-sellers">
                            <div class="row">
                                <div class="product-active owl-carousel">
                                    <c:forEach items="${listBestselling}" var="product">
                                        <div class="col-lg-3">
                                            <!-- single-product-area start -->
                                            <div class="single-product-area">
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
                                                            <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=index" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-caption">
                                                    <h4 class="product-name"><a href="single-product.html">${product.product.productName}</a></h4>
                                                    <div class="price-box">
                                                        <span class="new-price">$${product.salePrice}</span>
                                                        <c:if test="${product.salePrice != product.product.price}">
                                                            <span class="old-price">$${product.product.price}</span>
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${product.available == true}">
                                                        <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="action-cart-btn">
                                                            Add to Cart
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.available == false}">
                                                        <span class="action-cart-btn">Out Stock</span>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <!-- single-product-area end -->
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- product-area end -->

            <!-- banner-area start -->
            <div class="banner-area pt-100">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="single-banner-static">
                                <a href="<%=request.getContextPath()%>/userCatagoryController/toCatagoryId.htm?catagoryId=${upperBanner.catagories.catagoryId}">
                                    <img style="width: 100%;height: 196px" src="<%=request.getContextPath()%>/view/img/${upperBanner.bannerImage}" alt="">
                                    <span class="banner-text-right text-center">
                                        <span class="text1">${upperBanner.bannerName}</span>
                                        <span class="text2">${upperBanner.bannerDescription}</span>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- banner-area end -->

            <!-- product-area start -->
            <div class="product-area pt-100">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="section-title-2">
                                <div class="tabs-categorys-list">
                                    <ul class="nav" role="tablist">
                                        <li role="presentation" class="active"><a href="#body" aria-controls="body" role="tab" data-toggle="tab"> ${firstBrand}</a></li>
                                        <li role="presentation"><a href="#hands" aria-controls="hands" role="tab" data-toggle="tab">${secondBrand} </a></li>
                                        <li role="presentation"><a href="#neck" aria-controls="neck" role="tab" data-toggle="tab">${thirdBrand}</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="body">
                            <div class="row">
                                <div class="product-active owl-carousel">
                                    <c:forEach items="${listProductFirstBrand}" var="product">
                                        <div class="col-lg-3">
                                            <!-- single-product-area start -->
                                            <div class="single-product-area">
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
                                                            <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=index" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-caption">
                                                    <h4 class="product-name"><a href="single-product.html">${product.product.productName}</a></h4>
                                                    <div class="price-box">
                                                        <span class="new-price">$${product.salePrice}</span>
                                                        <c:if test="${product.salePrice != product.product.price}">
                                                            <span class="old-price">$${product.product.price}</span>
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${product.available == true}">
                                                        <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="action-cart-btn">
                                                            Add to Cart
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.available == false}">
                                                        <span class="action-cart-btn">Out Stock</span>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <!-- single-product-area end -->
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="hands">
                            <div class="row">
                                <div class="product-active owl-carousel">
                                    <c:forEach items="${listProductSecondBrand}" var="product">
                                        <div class="col-lg-3">
                                            <!-- single-product-area start -->
                                            <div class="single-product-area">
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
                                                            <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=index" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-caption">
                                                    <h4 class="product-name"><a href="single-product.html">${product.product.productName}</a></h4>
                                                    <div class="price-box">
                                                        <span class="new-price">$${product.salePrice}</span>
                                                        <c:if test="${product.salePrice != product.product.price}">
                                                            <span class="old-price">$${product.product.price}</span>
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${product.available == true}">
                                                        <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="action-cart-btn">
                                                            Add to Cart
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.available == false}">
                                                        <span class="action-cart-btn">Out Stock</span>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <!-- single-product-area end -->
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="neck">
                            <div class="row">
                                <div class="product-active owl-carousel">
                                    <c:forEach items="${listProductThirdBrand}" var="product">
                                        <div class="col-lg-3">
                                            <!-- single-product-area start -->
                                            <div class="single-product-area">
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
                                                            <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=0&redirectPage=index" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-caption">
                                                    <h4 class="product-name"><a href="single-product.html">${product.product.productName}</a></h4>
                                                    <div class="price-box">
                                                        <span class="new-price">$${product.salePrice}</span>
                                                        <c:if test="${product.salePrice != product.product.price}">
                                                            <span class="old-price">$${product.product.price}</span>
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${product.available == true}">
                                                        <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}" class="action-cart-btn">
                                                            Add to Cart
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${product.available == false}">
                                                        <span class="action-cart-btn">Out Stock</span>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <!-- single-product-area end -->
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- product-area end -->

            <!-- banner-area start -->
            <div class="banner-area pt-100">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="single-banner-static">
                                <a href="<%=request.getContextPath()%>/userCatagoryController/toCatagoryId.htm?catagoryId=${lowerBanner.catagories.catagoryId}">
                                    <img style="width: 100%;height: 196px" src="<%=request.getContextPath()%>/view/img/${lowerBanner.bannerImage}" alt="">
                                    <span class="banner-text-right text-center">
                                        <span class="text1">${lowerBanner.bannerName}</span>
                                        <span class="text2">${lowerBanner.bannerDescription}</span>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- banner-area end -->

            <!-- our-brand-area start -->
            <div class="our-brand-area">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="our-brand-active border-area owl-carousel ptb-50">
                                <c:forEach items="${listBrandsShowLogo}" var="brand">
                                    <div class="brand-single-item">
                                        <a href="<%=request.getContextPath()%>/userCatagoryController/toCatagory.htm?page=1&catagoryId=0&min=0&max=0&brandId=${brand.brandId}"><img style="width: 100% ; height: 88.45px" src="<%=request.getContextPath()%>/view/img/${brand.logo}" alt=""></a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- our-brand-area end -->
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
                                                <li><a href="#" class="add-to-cart"><i class="icon-basket-loaded"></i> Add to cart</a></li>
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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/index-4.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:14 GMT -->
</html>