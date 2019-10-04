<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String contextPath = request.getContextPath();
        HttpSession sessionObj = request.getSession(true);
        String adminName = (String) sessionObj.getAttribute("adminName");
        if (adminName == null || "".equals(adminName)) {

            response.sendRedirect(contextPath + "/adminIndexController/login.htm");
        } else {
            sessionObj.setMaxInactiveInterval(300);
        }%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Administration Page</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/ionicons.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/AdminLTE.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/_all-skins.min.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/style.css">
        <style>
            select{width:175px;}
        </style>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="${contextPath}/ShowyClothes/adminIndexController/index.htm" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>A</b>LT</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Admin</b>LTE</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <ul class="nav navbar-nav navbar-right" style="margin-right: 10px">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hi Admin Manager <b class="caret"></b></a>
                            <ul class="dropdown-menu">

                                <li><a href="${contextPath}/ShowyClothes/adminIndexController/logout.htm">Thoát tài khoản</a></li>
                            </ul>
                        </li>
                    </ul>

                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">MAIN NAVIGATION</li>

                        <li class="treeview active">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Tables</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="${contextPath}/ShowyClothes/adminAdminsController/getAll.htm"><i class="fa fa-circle-o"></i> Admins</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminBannersController/getAll.htm"><i class="fa fa-circle-o"></i> Banners</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminBrandsController/getAll.htm"><i class="fa fa-circle-o"></i> Brands</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminCategoriesController/getAll.htm"><i class="fa fa-circle-o"></i> Categories</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminCitiesController/getAll.htm"><i class="fa fa-circle-o"></i> Cities</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminFAQController/getAll.htm"><i class="fa fa-circle-o"></i> FAQ</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminOrderDetailsController/getAll.htm"><i class="fa fa-circle-o"></i> Order Detail</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminOrdersController/getAll.htm"><i class="fa fa-circle-o"></i> Orders</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminOrderStatusController/getAll.htm"><i class="fa fa-circle-o"></i> Order Status</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminProductCommentsController/getAll.htm"><i class="fa fa-circle-o"></i> Product Comments</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminProductImagesController/getAll.htm"><i class="fa fa-circle-o"></i> Product Images</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminProductsController/getAll.htm"><i class="fa fa-circle-o"></i> Products</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminSalesController/getAll.htm"><i class="fa fa-circle-o"></i> Sales</a></li>                               
                                <li><a href="${contextPath}/ShowyClothes/adminShipsController/getAll.htm"><i class="fa fa-circle-o"></i> Ships</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminShopInformationsController/getAll.htm"><i class="fa fa-circle-o"></i> Shop Information</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminSizesController/getAll.htm"><i class="fa fa-circle-o"></i> Size</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminSlidersController/getAll.htm"><i class="fa fa-circle-o"></i> Sliders</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminStoresController/getAll.htm"><i class="fa fa-circle-o"></i> Stores</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminUserFeedbacksController/getAll.htm"><i class="fa fa-circle-o"></i> User Feedbacks</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminUsersController/getAll.htm"><i class="fa fa-circle-o"></i> Users</a></li>
                                <li><a href="${contextPath}/ShowyClothes/adminWishListsController/getAll.htm"><i class="fa fa-circle-o"></i> Wish Lists</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        User Feedbacks Administration
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Tables</a></li>
                        <li class="active">User Feedbacks</li>
                    </ol>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Update Feedback</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <f:form method="post" action="update.htm" commandName="ufbUpdate">
                                        <table id="example2" class="table table-bordered table-hover">
                                            <tr>
                                                <td width="150px">Feedback ID</td> 
                                                <td><f:input path="feedbackId" readonly="true"/></td>
                                            </tr>
                                            <tr>
                                                <td>User ID</td>
                                                <td>
                                                    <f:input path="users.userId" readonly="true"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Full Name</td> 
                                                <td><f:input path="fullName" readonly="true"/></td>
                                            </tr>
                                            <tr>
                                                <td>Email</td> 
                                                <td><f:input path="email" readonly="true"/></td>
                                            </tr>
                                            <tr>
                                                <td>Contact Title</td> 
                                                <td><f:input path="contactTitle" readonly="true"/></td>
                                            </tr>
                                            <tr>
                                                <td>Contact Message</td> 
                                                <td><f:input path="contactMessage" readonly="true"/></td>
                                            </tr>
                                            <tr>
                                                <td>Disabled</td> 
                                                <td >True <f:radiobutton value="true" path="isDisabled"/>
                                                    False <f:radiobutton value="false" path="isDisabled"/></td>
                                            </tr>         
                                        </table>  
                                        <input type="submit" value="Update"/> 
                                        <button><a style="text-decorations:none; color:inherit;" href="${contextPath}/ShowyClothes/adminUserFeedbacksController/getAll.htm">Turn back</a></button>
                                    </f:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.4.18-pre
                </div>
                <strong>Copyright &copy; 2019 <a href="">AdminLTE</a>.</strong> All rights
                reserved.
            </footer>
            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Create the tabs -->
                <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                    <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                    <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
                </ul>
            </aside>
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->
        <!-- jQuery 3 -->
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/bootstrap.min.js"></script>
        <!-- DataTables -->
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/jquery.dataTables.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/dataTables.bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/demo.js"></script>
        <!-- page script -->
        <script>
            $(function () {
                $('#example1').DataTable()
                $('#example2').DataTable({
                    'paging': true,
                    'lengthChange': false,
                    'searching': false,
                    'ordering': true,
                    'info': true,
                    'autoWidth': true
                })
            })
        </script>
    </body>
</html>