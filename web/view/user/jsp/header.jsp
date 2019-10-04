<%-- 
    Document   : header
    Created on : Aug 20, 2019, 11:06:21 AM
    Author     : MinhQuan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <header>
            <!-- header-top-area start -->
            <div id="stickymenu" class="header-area bg-white solidblockmenu">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="header-inner clearfix">
                                <div class="container-inner">
                                    <!-- logo-container start -->
                                    <div class="logo-container">
                                        <div class="logo">
                                            <a href="<%=request.getContextPath()%>/userIndexController/index.htm"><img src="<%=request.getContextPath()%>/view/img/${shopInformation.logoTop}" alt=""></a>
                                        </div>
                                    </div>
                                    <!-- logo-container end -->
                                    <!-- main-menu-area start -->
                                    <div class="horizontal-menu main-menu-area d-none d-lg-block">
                                        <nav>
                                            <ul>
                                                <li><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                                <li class="mega_parent"><a href="<%=request.getContextPath()%>/userCatagoryController/toCatagoryId.htm?catagoryId=0">Categories <i class="icon-arrow-down"></i></a>
                                                    <ul class="mega-menu mega_menu-2">
                                                        <c:forEach items="${listParentCatagories}" var="parentCatagory">
                                                            <li><a style="color: red" href="<%=request.getContextPath()%>/userCatagoryController/toCatagoryId.htm?catagoryId=${parentCatagory.catagoryId}">${parentCatagory.catagoryName}</a>
                                                                <ul>
                                                                    <c:forEach items="${listSubCatagories}" var="subCatagory">
                                                                        <c:if test="${subCatagory.parentId == parentCatagory.catagoryId}">
                                                                            <li><a href="<%=request.getContextPath()%>/userCatagoryController/toCatagoryId.htm?catagoryId=${subCatagory.catagoryId}">${subCatagory.catagoryName}</a></li>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                </ul>
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </li>
                                                <li><a href="<%=request.getContextPath()%>/userAboutController/toAbout.htm">About Us</a></li>
                                                <li><a href="<%=request.getContextPath()%>/userContactController/initContact.htm">Contact US</a></li>
                                                <li><a href="<%=request.getContextPath()%>/userFAQController/toFaq.htm">FAQ</a></li>  
                                            </ul>
                                        </nav>
                                    </div>
                                    <!-- main-menu-area end -->
                                    <!-- box-right start -->
                                    <div class="box-right">
                                        <!-- search-box-area start -->
                                        <div class="search-box-area">
                                            <span class="sidebar-trigger-search"><i class="icon-magnifier icons"></i></span>
                                        </div>
                                        <!-- search-box-area end -->
                                        <!-- box-setting start -->
                                        <div class="box-setting">
                                            <div class="btn-group">	
                                                <button class="settings-box-inner dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="icon-settings icons"></i>
                                                </button>
                                                <div class="dropdown-menu setting-content">
                                                    <div class="account">
                                                        <c:if test="${loginId != null}">
                                                            <button class="setting-btn">${loginUser.userName} <i class="icon-arrow-down"></i></button>
                                                            </c:if>
                                                            <c:if test="${loginId == null}">
                                                            <button class="setting-btn">My Account <i class="icon-arrow-down"></i></button>
                                                            </c:if>
                                                        <ul class="setting-list">
                                                            <c:if test="${loginId != null}">
                                                                <li><a href="<%=request.getContextPath()%>/userUsersController/myAccount.htm">Account Detail</a></li>
                                                                <li><a href="<%=request.getContextPath()%>/userWishListController/toWishList.htm">Wish List</a></li>
                                                                <li><a href="<%=request.getContextPath()%>/userUsersController/logoutUser.htm">Logout</a></li>                                                    
                                                                </c:if>
                                                                <c:if test="${loginId == null}">
                                                                <li><a href="<%=request.getContextPath()%>/userUsersController/initRegister.htm?error=0">Register</a></li>
                                                                <li><a href="<%=request.getContextPath()%>/userUsersController/initLogin.htm">Login</a></li>
                                                                </c:if>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- box-setting end -->
                                        <!-- top-shopoing-cart start -->
                                        <div id="top-shopoing-cart" class="btn-group">
                                            <button class="shopping-cart dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="icon-basket-loaded icons"></i>
                                                <span class="top-cart-total">
                                                    <span class="item-text-number">${cartNumber}</span>
                                                </span>
                                            </button>
                                            <div class="dropdown-menu">
                                                <ul class="mini-cart-sub">
                                                    <c:forEach items="${headerListCart}" var="cart">
                                                        <li class="single-cart">
                                                            <div class="cart-img">
                                                                <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${cart.product.product.productId}">
                                                                <c:if test="${cart.product.image != null}">
                                                                    <img style="width: 80px;height: 102px" src="<%=request.getContextPath()%>/view/img/${cart.product.image.link}" alt="">
                                                                </c:if>
                                                                <c:if test="${cart.product.image == null}">
                                                                    <img style="width: 80px;height: 102px"src="<%=request.getContextPath()%>/view/user/img/icon/no-product-image.png" alt="">
                                                                </c:if>
                                                                </a>
                                                            </div>
                                                            <div class="cart-info">
                                                                <a href="<%=request.getContextPath()%>/userProductController/productDetail.htm?productId=${cart.product.product.productId}">${cart.product.product.productName} - Size ${cart.size.sizeName}</a>
                                                                <p class="cart-quantity">×${cart.quantity}</p>
                                                                <p class="cart-price">$${cart.totalPrice}</p>
                                                            </div>
                                                            <button class="cart-remove" title="Remove"><i class="ion-android-close"></i></button>
                                                        </li>
                                                    </c:forEach>
                                                    <li class="cart-total-box">
                                                        <h5>Sub-Total :<span class="float-right">$${subTotalAmount}</span></h5>
                                                        <h5>VAT (20%) :<span class="float-right">$${vat}</span></h5>
                                                        <h5>Total :<span class="float-right">$${totalAmount}</span></h5>
                                                    </li>
                                                    <li>
                                                        <p class="text-center cart-button">
                                                            <a href="<%=request.getContextPath()%>/userCartController/toCart.htm">View Cart</a>
                                                            <a href="<%=request.getContextPath()%>/userOrderController/initCheckOut.htm?error=0">Checkout</a>
                                                        </p>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!-- top-shopoing-cart end -->
                                    </div>
                                    <!-- box-right end -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- header-top-area end -->
            <!-- main-search start -->
            <div class="main-search-active">
                <div class="sidebar-search-icon">
                    <button class="search-close"><span class="icon-close"></span></button>
                </div>
                <div class="sidebar-search-input">
                    <form action="<%=request.getContextPath()%>/userCatagoryController/toSearch.htm">
                        <div class="form-search">
                            <input name="name" id="search" class="input-text" value="" placeholder="Search entire store here ..." type="search">
                            <input type="hidden" value="1" name="page">
                            <button class="search-btn" type="submit">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- main-search start -->
        </header>
    </body>
</html>
