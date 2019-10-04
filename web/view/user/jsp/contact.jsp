<%-- 
    Document   : contact
    Created on : Aug 26, 2019, 4:51:42 PM
    Author     : MinhQuan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
    
<!-- Mirrored from demo.hasthemes.com/t90-v2/contact.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:21 GMT -->
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Contact</title>
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
        
        <div class="wrapper contact-page">
            <jsp:include page="header.jsp"/>
            
            <!-- breadcrumb-area start -->
            <div class="breadcrumb-area ptb-30 bg-gray">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <ul class="breadcrumb-list">
                                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/userIndexController/index.htm">Home</a></li>
                                <li class="breadcrumb-item active">Contact</li>
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
                        <div class="col-lg-7 col-sm-12">
                            <div class="contact-form mt-100">
                                <div class="contact-form-info">
                                    <div class="contact-title">
                                        <h2>Send us your feedback</h2>
                                    </div>
                                    <f:form action="insertContact.htm" commandName="userFeedback">
                                       <div class="contact-page-form">
                                           <div class="contact-input">
                                                <div class="contact-inner">
                                                    <h5>Full Name</h5>
                                                    <c:if test="${userInfomation==null}">
                                                        <f:input path="fullName" type="text" id="first-name"/>
                                                    </c:if>
                                                    <c:if test="${userInfomation!=null}">
                                                        <f:input path="fullName" type="text" id="first-name" value="${userInfomation.fullName}"/>
                                                    </c:if>
                                                </div>
                                                <div class="contact-inner">
                                                    <h5>Email</h5>
                                                    <c:if test="${userInfomation==null}">
                                                        <f:input path="email" type="text" id="email"/>
                                                    </c:if>
                                                    <c:if test="${userInfomation!=null}">
                                                        <f:input path="email" type="text" id="email" value="${userInfomation.email}"/>
                                                    </c:if>
                                                </div>
                                                <div class="contact-inner">
                                                    <h5>Title</h5>
                                                    <f:input path="contactTitle" type="text" id="subject"/>
                                                </div>
                                                <div class="contact-inner contact-message">
                                                    <h5>Message</h5>
                                                    <f:textarea path="contactMessage"/>
                                                </div>
                                            </div>
                                            <div class="contact-submit-btn">
                                                <button class="submit-btn" type="submit">Send</button>
                                                <p class="form-messege"></p>
                                            </div>
                                       </div>
                                    </f:form>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-5 col-sm-12">
                            <div class="contact-infor mt-100">
                                <div class="contact-title">
                                    <h3>CONTACT US</h3>
                                </div>
                                <div class="contact-dec">
                                    <p>You can contact us with phone, mail or email</p>
                                </div>
                                <div class="contact-address">
                                    <ul>
                                        <li><i class="fa fa-fax"> </i> Address : ${shopInformation.contactAddress}</li>
                                        <li><i class="fa fa-phone">&nbsp;</i> Phone: ${shopInformation.contactPhone}</li>
                                        <li><i class="fa fa-envelope-o">&nbsp;</i> Email: ${shopInformation.contactEmail}</li>
                                    </ul>
                                </div>
                                <div class="work-hours">
                                    <h3><strong>Working hours</strong></h3>
                                    <p><strong>Monday &ndash; Saturday</strong>: &nbsp;08AM &ndash; 22PM</p>
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

<!-- Mirrored from demo.hasthemes.com/t90-v2/contact.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 14 Aug 2019 12:47:21 GMT -->
</html>
