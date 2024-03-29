<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <% String contextPath = request.getContextPath();%>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="${contextPath}/ShowyClothes/view/admin/format/images/icons/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/vendor/animate/animate.css">	
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/vendor/animsition/css/animsition.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/vendor/select2/select2.min.css">	
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/vendor/daterangepicker/daterangepicker.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/util.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/main.css">
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
                    <f:form class="login100-form validate-form" action="validate.htm">
                        <span class="login100-form-title p-b-33">
                            Admin Login
                        </span>

                        <div class="wrap-input100 validate-input" data-validate = "Admin account is required">
                            <input class="input100" type="text" name="adminName" placeholder="Admin account">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>

                        <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
                            <input class="input100" type="password" name="adminPassword" placeholder="Password">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>

                        <div class="container-login100-form-btn m-t-20">
                            <button type="submit" class="login100-form-btn">
                                Sign in
                            </button>
                        </div>
                    </f:form>
                </div>
            </div>
        </div>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/animsition/js/animsition.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/bootstrap/js/popper.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/select2/select2.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/daterangepicker/moment.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/daterangepicker/daterangepicker.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/vendor/countdowntime/countdowntime.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/main.js"></script>
    </body>
</html>