<%-- 
    Document   : checkout
    Created on : Aug 26, 2019, 5:15:16 PM
    Author     : MinhQuan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:21 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Checkout</title>
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

        <div class="wrapper checkout-page">
            <jsp:include page="header.jsp"/>

            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Checkout</li>
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
                        <div class="col-lg-12">
                            <c:if test="${checkCart == false }">
                                <h2>Your cart is empty</h2>
                            </c:if>
                            <!-- coupon-area start -->
                            <c:if test="${loginUser == null}"> 
                                <div class="coupon-area">
                                    <div class="coupon-accordion">
                                        <h3>Returning customer? <span id="showlogin" class="coupon">Click here to login</span></h3>
                                        <div id="checkout-login" class="coupon-content">
                                            <div class="coupon-info">
                                                <p>If you have shopped with us before, please enter your details in the boxes below. If you are a new customer, please proceed to the Billing & Shipping section.</p>
                                                <f:form action="../userUsersController/loginCheckOutUser.htm" commandName="loginCheckOutUser">  
                                                    <p class="coupon-input form-row-first">
                                                        <label>Username or email <span class="required">*</span></label>
                                                        <f:input path="userName" type="text"  placeholder="Account or Email"/>
                                                    </p>
                                                    <p class="coupon-input form-row-last">
                                                        <label>Password <span class="required">*</span></label>
                                                        <f:input path="userPassword" type="password"  placeholder="Password"/>
                                                    </p>
                                                    <div class="clear"></div>
                                                    <p>
                                                        <button value="Login" name="login" class="button-login" type="submit">Login</button>
                                                        <label><input type="checkbox" value="1"><span>Remember me</span></label>
                                                    </p>
                                                    <p class="lost-password">
                                                        <a href="#">Lost your password?</a>
                                                    </p>
                                                </f:form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <!-- coupon-area end -->
                        </div>
                    </div>
                    <!-- checkout-area start -->
                    <div class="checkout-area">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-lg-6 col-sm-12">
                                        <f:form action="confirmCheckOut.htm" commandName="newOrder">
                                            <div class="checkbox-form mt-30">
                                                <h3 class="shoping-checkboxt-title">Billing Details</h3>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <p class="single-form-row">
                                                            <label>Full Name <span class="required">*</span></label>
                                                            <c:if test="${loginUser.fullName != null}">
                                                                <f:input path="fullName" type="text" value="${loginUser.fullName}" required="true"/>
                                                            </c:if>
                                                            <c:if test="${loginUser.fullName == null}">
                                                                <f:input path="fullName" type="text" required="true"/>
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <p class="single-form-row">
                                                            <label>Email <span class="required">*</span></label>
                                                            <c:if test="${loginUser.email != null}">
                                                                <f:input path="email" type="email" required="true" value="${loginUser.email}"/>
                                                            </c:if>
                                                            <c:if test="${loginUser.email == null}">
                                                                <f:input path="email" type="email" required="true"/>
                                                            </c:if>

                                                        </p>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <p class="single-form-row">
                                                            <label>Phone Number <span class="required">*</span></label>
                                                            <c:if test="${loginUser.phone != null}">
                                                                <f:input path="phone" type="number" required="true" value="${loginUser.phone}"/>
                                                            </c:if>
                                                            <c:if test="${loginUser.phone == null}">
                                                                <f:input path="phone" type="number" required="true"/>
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <div class="single-form-row">
                                                            <label>City <span class="required">*</span></label>
                                                            <div>
                                                                <select name="chooseCity" >
                                                                    <c:forEach items="${listCities}" var="city">
                                                                        <option value="${city.cityId}"> ${city.cityName}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <p class="single-form-row">
                                                            <label>Address <span class="required">*</span></label>
                                                            <c:if test="${loginUser.userAddress != null}">
                                                                <f:input path="userAddress" type="text" required="true" value="${loginUser.userAddress}"/>
                                                            </c:if>
                                                            <c:if test="${loginUser.userAddress == null}">
                                                                <f:input path="userAddress" type="text" required="true"/>
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <p class="single-form-row">
                                                            <label>Postcode / ZIP <span class="required">*</span></label>
                                                            <f:input path="postcodeOrZip" type="number" required="true"/>
                                                        </p>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <div class="single-form-row checkout-area">
                                                            <label><input type="checkbox" id="chekout-box"> Create an account?</label>
                                                            <div class="account-create single-form-row">
                                                                <label class="creat-pass">Account <span>*</span></label>
                                                                <input type="text" name="newUserName"/>
                                                                <label class="creat-pass">Password <span>*</span></label>
                                                                <input type="password" name="newUserPassword"/>
                                                                <label class="creat-pass">Retype-Password <span>*</span></label>
                                                                <input type="password" name="retypePassword"/>
                                                            </div>
                                                            <c:if test="${error != 0}">
                                                                <c:if test="${error == 1 }">
                                                                    <div><label style="color: red"> Duplicate Account, Password, Email</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 2 }">
                                                                    <div><label style="color: red"> Duplicate Account, Password</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 3 }">
                                                                    <div><label style="color: red"> Duplicate Account, Email</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 4 }">
                                                                    <div><label style="color: red"> Duplicate Account</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 5 }">
                                                                    <div><label style="color: red"> Duplicate Password, Email</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 6 }">
                                                                    <div><label style="color: red"> Duplicate Password</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 7 }">
                                                                    <div><label style="color: red"> Duplicate Email</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 8 }">
                                                                    <div><label style="color: red">Retype-Password Unmatch</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 9 }">
                                                                    <div><label style="color: red">Password Can Not Have Blank Space</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 10 }">
                                                                    <div><label style="color: red">Password Must Contains 6-15 Characters</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 11 }">
                                                                    <div><label style="color: red">Account Must Contains 6-15 Characters</label></div>
                                                                </c:if>
                                                                <c:if test="${error == 12 }">
                                                                    <div><label style="color: red">Product Out Of Stock</label></div>
                                                                </c:if>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                    <div class="checkout-payment">
                                                        <button class="button-continue-payment" type="submit" >Continue to payment</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </f:form>
                                    </div>
                                    <div class="col-lg-6 col-sm-12">
                                        <div class="checkout-review-order mt-30 ">
                                            <form action="#">
                                                <h3 class="shoping-checkboxt-title">Your order</h3>
                                                <table class="checkout-review-order-table">
                                                    <thead>
                                                        <tr>
                                                            <th class="t-product-name">Product</th>
                                                            <th class="product-total">Total</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${listCart}" var="cart">
                                                            <tr class="cart_item">
                                                                <td class="t-product-name">${cart.product.product.productName} - Size ${cart.size.sizeName}<strong class="product-quantity">× ${cart.quantity}</strong></td>
                                                                <td class="t-product-price"><span>$${cart.product.salePrice}</span></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr class="cart-subtotal">
                                                            <th>Subtotal</th>
                                                            <td><span>$${subTotalAmount}</span></td>
                                                        </tr>
                                                        <tr class="shipping">
                                                            <th>VAT(10%)</th>
                                                            <td>$${vat}</td>
                                                        </tr>
                                                        <tr class="order-total">
                                                            <th>Total</th>
                                                            <td><strong><span>$${totalAmount}</span></strong></td>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                                <div class="checkout-payment">
                                                    <div class="payment_methods">
                                                        <p><label>The total number above is not include shipping fee</label></p>
                                                        <p>Shipping fee will be add to your order after confirmation</p>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- checkout-area end -->
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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:22 GMT -->
</html>
