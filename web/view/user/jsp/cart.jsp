<%-- 
    Document   : cart
    Created on : Aug 25, 2019, 3:43:43 PM
    Author     : MinhQuan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:21 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Cart </title>
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

        <div class="wrapper cart-page">
            <jsp:include page="header.jsp"/>
            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Cart</li>
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
                            <form action="updateCart.htm" class="cart-table">
                                <div class="table-content table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th class="plantmore-product-remove">remove</th>
                                                <th class="plantmore-product-thumbnail">images</th>
                                                <th class="cart-product-name">Product</th>
                                                <th class="plantmore-product-price">Unit Price</th>
                                                <th class="plantmore-product-quantity">Quantity</th>
                                                <th class="plantmore-product-subtotal">Total</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                            <div class="table-content table-responsive">
                                                <c:forEach items="${listCart}" var="cart">
                                                    <tr>
                                                        <td class="plantmore-product-remove"><a href="remove.htm?productId=${cart.product.product.productId}"><i class="fa fa-times"></i></a></td>
                                                        <td class="plantmore-product-thumbnail"><a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${cart.product.product.productId}">
                                                                <c:if test="${cart.product.image != null}">
                                                                    <img style="width: 80px;height: 102px" src="<%=request.getContextPath()%>/view/img/${cart.product.image.link}" alt="">
                                                                </c:if>
                                                                <c:if test="${cart.product.image == null}">
                                                                    <img style="width: 80px;height: 102px"src="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png" alt="">
                                                                </c:if>
                                                            </a>
                                                        </td>
                                                        <td class="plantmore-product-name"><a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${cart.product.product.productId}">${cart.product.product.productName} - Size ${cart.size.sizeName}</a></td>
                                                        <td class="plantmore-product-price"><span class="amount">${cart.product.salePrice}</span></td>
                                                        <td class="plantmore-product-quantity">
                                                            <input value=${cart.quantity} type="number" name="quantity">
                                                        </td>
                                                        <td class="product-subtotal"><span class="amount">${cart.totalPrice}</span></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                                </table>
                                            </div>
                                            <div class="row">
                                                <div class="col-12">
                                                    <div class="coupon-all">
                                                        <div class="coupon2">
                                                            <input class="button" name="update_cart" value="Update cart" type="submit">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                        <div class="row">
                                            <div class="col-md-5 ml-auto">
                                                <div class="cart-page-total">
                                                    <h2>Cart totals</h2>
                                                    <ul>
                                                        <li>Sub-Total <span>$${subTotalAmount}</span></li>
                                                        <li>VAT(10%) <span>$${vat}</span></li>
                                                        <li>Total <span>$${totalAmount}</span></li>
                                                    </ul>
                                                    <a href="<%=request.getContextPath()%>/userOrderController/initCheckOut.htm?error=0">Proceed to checkout</a>
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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:21 GMT -->
</html>
