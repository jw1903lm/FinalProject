<%-- 
    Document   : productDetail
    Created on : Aug 22, 2019, 9:39:28 PM
    Author     : MinhQuan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/single-product.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:21 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Product Detail </title>
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
        <style>
            select {
            width: 30%;
            padding: 10px 15px;  
            border-radius: 4px;
         }
        </style>
        <script src="<%=request.getContextPath()%>/view/user/js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience. Thanks</p>
        <![endif]-->
        <!-- Add your application content here -->

        <div class="wrapper single-page">
            <jsp:include page="header.jsp"/>

            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Single product</li>
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
                        <div class="col">
                            <div class="sinlge-product-wrap">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6">
                                        <div class="single-product-tab">
                                            <div class="zoomWrapper">
                                                <div id="img-1" class="zoomWrapper single-zoom">
                                                    <c:if test="${productDetail.image != null}">
                                                        <img style="width: 540px;height: 688px" id="zoom1" src="<%=request.getContextPath()%>/view/img/${productDetail.image.link}" data-zoom-image="<%=request.getContextPath()%>/view/img/${productDetail.image.link}" alt="big-1"/>
                                                    </c:if>
                                                    <c:if test="${productDetail.image == null}">
                                                        <img style="width: 540px;height: 688px" id="zoom1" src="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png" data-zoom-image="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png" alt="big-1"/>
                                                    </c:if>
                                                </div>
                                                <c:if test="${productDetail.image != null}">
                                                    <div class="single-zoom-thumb">
                                                        <ul class="s-tab-zoom single-product-active owl-carousel" id="gallery_01">
                                                            <c:forEach items="${productDetail.product.productImageses}" var="productImage">
                                                                <c:if test="${productImage.imageId == productDetail.image.imageId}">
                                                                    <li>
                                                                        <a href="#"  class="elevatezoom-gallery active" data-update="" data-image="<%=request.getContextPath()%>/view/img/${productImage.link}" data-zoom-image="<%=request.getContextPath()%>/view/img/${productImage.link}"><img style="width: 100%;height: 150px" src="<%=request.getContextPath()%>/view/img/${productImage.link}" alt="zo-th-1"></a>
                                                                    </li>
                                                                </c:if>
                                                                <c:if test="${productImage.imageId != productDetail.image.imageId}">
                                                                    <li class="">
                                                                        <a href="#" class="elevatezoom-gallery" data-image="<%=request.getContextPath()%>/view/img/${productImage.link}" data-zoom-image="<%=request.getContextPath()%>/view/img/${productImage.link}"><img style="width: 100%;height: 150px" src="<%=request.getContextPath()%>/view/img/${productImage.link}" alt="zo-th-1"></a>
                                                                    </li>
                                                                </c:if>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div> 
                                    </div>
                                    <div class="col-lg-6 col-md-6">
                                        <!-- product-thumbnail-content start -->
                                        <div class="quick-view-content">
                                            <div class="product-info">
                                                <h2>${productDetail.product.productName}</h2>
                                                <div class="rating-box">
                                                    <c:if test="${totalRating != 0}">
                                                        <ul class="rating d-flex">
                                                            <c:forEach begin="1" end="${totalRating}">
                                                                <li><i class="icon-star"></i></li>
                                                                </c:forEach>
                                                        </ul>
                                                    </c:if>
                                                    <c:if test="${totalRating == 0}">
                                                        <span>No Rating</span>
                                                    </c:if>
                                                </div>
                                                <div class="price-box">
                                                    <span class="new-price">$${productDetail.salePrice}</span>
                                                    <c:if test="${productDetail.product.price != productDetail.salePrice}">
                                                        <span class="old-price">$${productDetail.product.price}</span>
                                                    </c:if>
                                                </div>
                                                <ul class="list-unstyled">
                                                    <c:if test="${productDetail.product.brands != null}">
                                                        <li>Brand: ${productDetail.product.brands.brandName}</li>
                                                        </c:if>
                                                        <c:if test="${productDetail.product.brands == null}">
                                                        <li>Brand: None</li>
                                                        </c:if>
                                                        <c:if test="${productDetail.available == true}">
                                                        <li>Availability: <span class="stock">In Stock</span></li>
                                                        </c:if>
                                                        <c:if test="${productDetail.available == false}">
                                                        <li>Availability: <span style="color: red">Out Stock</span></li>
                                                        </c:if>
                                                </ul> 
                                                <c:if test="${productDetail.available == true}">
                                                    <f:form action="../userCartController/addToCart.htm?productId=${productDetail.product.productId}" class="modal-cart">
                                                        <label>Choose Size</label>
                                                        <div>
                                                            <select name="size">
                                                                <c:forEach items="${productDetail.listSize}" var="size"> 
                                                                    <option value="${size.sizeId}">${size.sizeName} - ${size.stock} Available</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div style="margin-top: 10px"></div>
                                                        <div class="quantity">
                                                            <label>Quantity</label>
                                                            <div class="cart-plus-minus">
                                                                <input type="number" value="1" min="1" step="1" class="input-box" name="quantity">
                                                            </div>
                                                        </div> 
                                                        <ul class="quick-add-to-cart">
                                                            <li><button class="add-to-cart" type="submit"><i class="icon-basket-loaded"></i>Add to cart</button></li>  
                                                        </ul>     
                                                    </f:form>
                                                </c:if>
                                                <ul class="quick-add-to-cart">    
                                                    <c:if test="${loginUser != null}">
                                                        <li><a class="wishlist-btn" href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${productDetail.product.productId}&redirectProductId=${productDetail.product.productId}&redirectPage=product" title="Add to Wish List"><i class="icon-heart"></i></a></li>
                                                    </c:if>
                                                </ul> 
                                            </div>
                                        </div>
                                        <!-- product-thumbnail-content end -->
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="product-info-detailed mt-100">
                                            <div class="discription-tab-menu">
                                                <ul role="tablist" class="nav">
                                                    <li class="active"><a href="#description" data-toggle="tab" class="active show">Description</a></li>
                                                    <li><a href="#review" data-toggle="tab">Reviews (${countComment})</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="discription-content">
                                            <div class="tab-content">
                                                <div class="tab-pane fade in active show" id="description">
                                                    <div class="description-content">
                                                        <p style="text-align: center">${productDetail.product.productDescription}</p>
                                                    </div>
                                                </div>
                                                <div id="review" class="tab-pane fade">
                                                    <div class="form-review">
                                                        <c:forEach items="${listProductComments}" var="productComment">
                                                            <div class="review">
                                                                <table class="table table-striped table-bordered table-responsive">
                                                                    <tbody>
                                                                        <tr>
                                                                            <td class="table-name"><strong>${productComment.fullName}</strong></td>
                                                                            <td class="text-right"><fmt:formatDate type = "date" value = "${productComment.created}"/> </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td colspan="2">
                                                                                <p>${productComment.review}</p>   
                                                                                <c:if test="${loginUser != null}">
                                                                                    <c:if test="${productComment.users.userId == loginUser.userId}">
                                                                                        <div class="buttons clearfix" style="float: right">
                                                                                            <div class="pul-right">
                                                                                                <f:form action="deleteComment.htm?commentId=${productComment.commentId}">
                                                                                                    <input type="hidden" value="${productDetail.product.productId}" name="productId"/>
                                                                                                    <button class="button-review" type="submit">Delete</button>
                                                                                                </f:form>
                                                                                            </div>
                                                                                        </div>
                                                                                        </form>
                                                                                    </c:if>
                                                                                </c:if>
                                                                                <ul>
                                                                                    <c:forEach begin="1" end="${productComment.rating}">
                                                                                        <li><i class="fa fa-star-o"></i></li>
                                                                                        </c:forEach>
                                                                                </ul>  
                                                                            </td>
                                                                        </tr>
                                                                    </tbody>                      
                                                                </table>
                                                            </div>
                                                        </c:forEach>
                                                        <f:form action="addNewComment.htm?productId=${productDetail.product.productId}" commandName="newComment">
                                                            <div class="review-wrap">
                                                                <h2>Write a review</h2>
                                                                <div class="form-group row">
                                                                    <div class="col">
                                                                        <label class="control-label">Your Name</label>
                                                                        <c:if test="${loginUser != null}">
                                                                            <f:input path="fullName" type="text" class="form-control" value="${loginUser.userName}"/>
                                                                        </c:if>
                                                                        <c:if test="${loginUser == null}">
                                                                            <f:input path="fullName" type="text" class="form-control"/>
                                                                        </c:if> 
                                                                    </div>
                                                                </div>
                                                                <div class="form-group row">
                                                                    <div class="col">
                                                                        <label class="control-label">Your Review</label>
                                                                        <f:textarea path="review" type="text" class="form-control"/>
                                                                        <div class="help-block"><span class="text-danger">Note:</span> HTML is not translated!</div>
                                                                    </div>
                                                                </div>    
                                                                <div class="form-group row">
                                                                    <div class="col">
                                                                        <label class="control-label">Rating</label>
                                                                        &nbsp;&nbsp;&nbsp; Bad&nbsp;
                                                                        <f:radiobutton path="rating" value="1"/>
                                                                        &nbsp;
                                                                        <f:radiobutton path="rating" value="2"/>
                                                                        &nbsp;
                                                                        <f:radiobutton path="rating" value="2"/>
                                                                        &nbsp;
                                                                        <f:radiobutton path="rating" value="4"/>
                                                                        &nbsp;
                                                                        <f:radiobutton path="rating" value="5" checked="true"/>
                                                                        &nbsp;Good
                                                                    </div>
                                                                </div>
                                                                <c:if test="${loginUser != null}">
                                                                    <input type="hidden" value="${loginUser.userId}" name="userId"> 
                                                                </c:if>
                                                            </div>
                                                            <div class="buttons clearfix">
                                                                <div class="pul-right">
                                                                    <button class="button-review" type="submit">Send</button>
                                                                </div>
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
                    <div class="row">
                        <div class="col">
                            <div class="related-products box-module pt-100">
                                <div class="row">
                                    <div class="col">
                                        <div class="section-title text-center mb-50">
                                            <h4>our products</h4>
                                            <c:if test="${fn:length(listProductCatagory) > 0}">
                                                <h2>Related Products</h2>
                                            </c:if>
                                            <c:if test="${fn:length(listProductCatagory) == 0}">
                                                <h2>No Related Products</h2>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${fn:length(listProductCatagory) > 0}">
                                    <div class="row">
                                        <div class="product-active owl-carousel">
                                            <c:forEach items="${listProductCatagory}" var="product">
                                                <div class="col-lg-3">
                                                    <!-- single-product-area start -->
                                                    <div class="single-product-area">
                                                        <div class="product-thumb">
                                                            <c:if test="${product.image != null}">
                                                                <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">
                                                                    <img style="width: 100%;height: 334px" class="primary-image" src="<%=request.getContextPath()%>/view/img/${product.image.link}" alt="">
                                                                </a>
                                                            </c:if>
                                                            <c:if test="${product.image == null}">
                                                                <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${product.product.productId}">
                                                                    <img style="width: 100%;height: 334px" class="primary-image" src="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png" alt="">
                                                                </a>
                                                            </c:if>           
                                                            <c:if test="${product.salePrice != product.product.price}">
                                                                <div class="label-product label_sale">-${product.product.sales.percentage}%</div>
                                                            </c:if>
                                                            <div class="action-links">
                                                                <c:if test="${loginUser!=null}">
                                                                    <a href="<%=request.getContextPath()%>/userWishListController/insertWishList.htm?productId=${product.product.productId}&redirectProductId=${productDetail.product.productId}&redirectPage=product" class="wishlist-btn" title="Add to Wish List"><i class="icon-heart"></i></a>
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
                                </c:if>
                            </div>
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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/single-product.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:21 GMT -->
</html> 
