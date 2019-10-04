<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%
        String contextPath = request.getContextPath();
        HttpSession sessionObj = request.getSession(true);
        String adminName = (String) sessionObj.getAttribute("adminName");
        if (adminName == null || "".equals(adminName)) {

            response.sendRedirect("login.htm");
        } else {
            sessionObj.setMaxInactiveInterval(300);
        }%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Administration Page</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/AdminLTE.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/_all-skins.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/ShowyClothes/view/admin/format/css/style.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="${contextPath}/ShowyClothes/adminIndexController/index.htm" class="logo">
                    <span class="logo-mini"><b>A</b>LT</span>
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
                                <li><a href="${contextPath}/ShowyClothes/adminIndexController/logout.htm">Logout</a></li>
                                <li><a href="${contextPath}/ShowyClothes/userIndexController/index.htm">User Page</a></li>
                            </ul>
                        </li>
                    </ul>

                </nav>
            </header>
            <aside class="main-sidebar">
                <section class="sidebar">
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
                        <li>
                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        Showy Clothes Administration
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    </ol>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-aqua">
                                <div class="inner">
                                    <h3>${activeUser}</h3>

                                    <p>Active Users</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-bag"></i>
                                </div>
                                <a href="${contextPath}/ShowyClothes/adminUsersController/getAll.htm" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                        <!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3>${activeProduct}</h3>

                                    <p>Active Products</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="${contextPath}/ShowyClothes/adminProductsController/getAll.htm" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                        <!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-purple">
                                <div class="inner">
                                    <h3>${registedOrder}</h3>

                                    <p>Registed-User Orders</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-person-add"></i>
                                </div>
                                <a href="${contextPath}/ShowyClothes/adminOrdersController/getAll.htm" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                        <!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-yellow">
                                <div class="inner">
                                    <h3>${visitorOrder}</h3>

                                    <p>Visitor Orders</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>
                                <a href="${contextPath}/ShowyClothes/adminOrdersController/getAll.htm" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                        <!-- ./col -->
                        <!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">
                                    <h3>${feedBack}</h3>

                                    <p>Customer Feedbacks</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>
                                <a href="${contextPath}/ShowyClothes/adminUserFeedbacksController/getAll.htm" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                        <!-- ./col -->
                    </div>                     
                    <div id="curve_chart" style="width: 1250px; height: 500px"></div>
                    <div><h3 style="text-align: center"><strong>Shop Income And Profit Over Months 2019</strong></h3></div>
                </section>
            </div>

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.4.0
                </div>
                <strong>Copyright &copy; 2019 <a href="https://adminlte.io">AdminLTE</a>.</strong> All rights
                reserved.
            </footer>
        </div>
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/jquery.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/bootstrap.min.js"></script>
        <script src="${contextPath}/ShowyClothes/view/admin/format/js/adminlte.min.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
//                var data = google.visualization.arrayToDataTable([
//                    ['Month', 'Sales', 'Expenses'],
//                    ['Jan', 1000, 400],
//                    ['Feb', 1170, 460],
//                    ['Mar', 1465, 754],
//                    ['Apr', 1000, 400],
//                    ['May', 1170, 460],
//                    ['Jun', 1465, 754],
//                    ['Jul', 1000, 400],
//                    ['Aug', 1170, 460],
//                    ['Sep', 1465, 754],
//                    ['Oct', 1500, 500],
//                    ['Nov', 1546, 764],
//                    ['Dec', 1670, 675],
//                ]);
                var data = google.visualization.arrayToDataTable([
                    ['Month', 'Income', 'Profit'],
                    ['Jan', ${jan},300],
                    ['Feb', ${feb},450],
                    ['Mar', ${mar},567],
                    ['Apr', ${apr},440],
                    ['May', ${may},476],
                    ['Jun', ${jun},780],
                    ['Jul', ${jul},1023],
                    ['Aug', ${aug},944],
                    ['Sep', ${sep},832],
                    ['Oct', ${oct},449],
                    ['Nov', ${nov},662],
                    ['Dec', ${dec},904],
                ]);

                var options = {
                    curveType: 'function',
                    legend: {position: 'bottom'}
                };

                var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

                chart.draw(data, options);
            }
        </script>
    </body>
</html>
