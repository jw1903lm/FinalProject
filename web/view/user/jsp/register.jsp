<%-- 
    Document   : login
    Created on : Jul 17, 2019, 9:13:14 AM
    Author     : MinhQuan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/login-register.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:18 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Register </title>
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
        <!-- Style an mui ten thay doi gia tri cho input dang number  -->
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

        <div class="wrapper shop-page">
            <jsp:include page="header.jsp"/>

            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Register</li>
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
                        <div class="col-lg-6  col-md-6 col-sm-12">
                            <div class="customer-login-register">
                                <h3>Register</h3>
                                <div class="login-Register-info">
                                    <f:form action="registerUser.htm" commandName="userInfomation">
                                        <p class="coupon-input form-row-first">
                                            <label>Account<span class="required">*</span></label>
                                            <f:input path="userName" type="text" required="true"/>
                                        </p>
                                        <p class="coupon-input form-row-last">
                                            <label>Password<span class="required">*</span></label>
                                            <f:input path="userPassword" type="password" required="true"/>
                                        </p>
                                        <p class="coupon-input form-row-last">
                                            <label>Retype-Password<span class="required">*</span></label>
                                            <input type="password" name="retypePassword" required="true"/>
                                        </p>
                                        <p class="coupon-input form-row-first">
                                            <label>Email<span class="required">*</span></label>
                                            <f:input path="email" type="email" required="true"/>
                                        </p>
                                        <p class="coupon-input form-row-last">
                                            <label>Full Name</label>
                                            <f:input path="fullName" type="text"/>
                                        </p>
                                        <p class="coupon-input form-row-last">
                                            <label>Phone Number</label>
                                            <f:input path="phone" type="number"/>
                                        </p>
                                        <p class="coupon-input form-row-last">
                                            <label>City</label>
                                        <div>
                                            <select name="chooseCity" >
                                                <c:forEach items="${listCities}" var="city">
                                                    <option value="${city.cityId}"> ${city.cityName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        </p>
                                        <p class="coupon-input form-row-last">
                                            <label>Address</label>
                                            <f:input path="userAddress" type="text"/>
                                        </p>
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
                                        </c:if>
                                        <p>
                                            <button class="button-login" type="submit">Register</button>
                                        </p>
                                    </f:form>
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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/login-register.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:18 GMT -->
</html>