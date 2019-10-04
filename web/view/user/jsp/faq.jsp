<%-- 
    Document   : faq
    Created on : Aug 26, 2019, 5:03:22 PM
    Author     : MinhQuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from demo.hasthemes.com/t90-v2/frequently-question.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:18 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>FAQ</title>
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

        <div class="wrapper faq-page">
            <jsp:include page="header.jsp"/>

            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">FAQ</li>
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
                            <div class="feequently-about-content">
                                <h4>Below are frequently asked questions, you may find the answer for yourself</h4>
                                <p>For any futher question, please contact or e-mail to our customer service</p>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12 col-sm-12">
                            <div class="faequently-area-inner">
                                <div class="faequently-accordion">
                                    <c:forEach items="${listFaq}" var="faq">
                                        <!--panel body start-->
                                        <h4>${faq.question}</h4>
                                        <div class="faequently-description">
                                            <p>${faq.answer}</p>
                                        </div>
                                        <!--panel body end-->
                                    </c:forEach>
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

    <!-- Mirrored from demo.hasthemes.com/t90-v2/frequently-question.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:18 GMT -->
</html>
