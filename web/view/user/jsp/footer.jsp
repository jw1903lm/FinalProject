<%-- 
    Document   : footer
    Created on : Aug 20, 2019, 11:06:34 AM
    Author     : MinhQuan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer</title>
    </head>
    <body>
        
            <footer class="footer-area bg-black mt-100">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <!-- footer-top start -->
                            <div class="footer-top">
                                <div class="row">
                                    <div class="col-lg-3 col-md-6 col-sm-6">
                                        <div class="footer-content mb-30">
                                            <a href="<%=request.getContextPath()%>/userIndexController/index.htm" class="logo-footer"><img alt="logo-footer" src="<%=request.getContextPath()%>/view/img/${shopInformation.logoBottom}"></a>
                                            <ul class="footer-contact">
                                                <li class="address">Address: ${shopInformation.contactAddress}</li>
                                                <li class="phone">Phone: ${shopInformation.contactPhone}</li>
                                                <li class="email">Email: ${shopInformation.contactEmail}</li>
                                            </ul>

                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6 col-sm-6">
                                        <div class="single-footer-wrap mb-30">
                                            <div class="footer-title"><h5>Information</h5></div>
                                            <div class="footer-content">
                                                <ul class="text-content">
                                                    <li><a href="<%=request.getContextPath()%>/userAboutController/toAbout.htm">About Us</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/userContactController/initContact.htm">Contact Us</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div><div class="col-lg-3 col-md-6 col-sm-6">
                                        <div class="single-footer-wrap mb-30">
                                            <div class="footer-title"><h5>Extra</h5></div>
                                            <div class="footer-content">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6 col-sm-6">
                                        <div class="single-footer-wrap mb-30">
                                            <div class="footer-title"><h5>Follow us</h5></div>
                                            <div class="footer-content">
                                                <ul class="text-content">
                                                    <li><a href="https://twitter.com" target="_blank">twitter</a></li>
                                                    <li><a href="https://www.google.com" target="_blank"> google</a></li>
                                                    <li><a href="https://www.facebook.com" target="_blank">facebook</a></li>
                                                    <li><a href="https://www.youtube.com" target="_blank">youtube</a></li>
                                                    <li><a href="https://www.instagram.com" target="_blank">Instagram</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- footer-top end -->
                        </div>
                    </div>
                </div>
                <!-- footer-bottom end -->
                <!-- footer-bottom start -->
                <div class="footer-bottom border-top-dashed">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="footer-copyright">
                                    <p>Copyright &copy; 2019 <a href="#">Quan_holy</a> <span>All Right Reserved.</span></p>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="footer-payment">
                                    <img src="<%=request.getContextPath()%>/view//user/img/icon/payment.png" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- footer-bottom end -->
            </footer>
            
    </body>
</html>
