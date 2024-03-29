USE [ShowyClothes]
GO
SET IDENTITY_INSERT [dbo].[Catagories] ON 

INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (1, N'Do nam', 1, 0, CAST(N'2019-08-20 14:42:46.570' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (2, N'Do nu', 2, 0, CAST(N'2019-08-20 14:42:54.173' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (3, N'Giay dep', 4, 0, CAST(N'2019-08-20 14:43:02.457' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (4, N'Phu kien', 3, 0, CAST(N'2019-08-20 14:43:20.633' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (5, N'Ao da', 1, 1, CAST(N'2019-08-20 14:43:59.770' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (6, N'Quan jean', 3, 1, CAST(N'2019-08-20 14:44:35.467' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (7, N'So mi', 2, 1, CAST(N'2019-08-20 14:44:52.833' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (8, N'Vay', 3, 2, CAST(N'2019-08-20 14:45:06.687' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (9, N'Quan dai', 2, 2, CAST(N'2019-08-20 14:45:28.937' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (10, N'Ao dai', 1, 2, CAST(N'2019-08-20 14:45:40.473' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (11, N'Dep', 3, 3, CAST(N'2019-08-20 14:46:06.173' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (12, N'Sneaker', 2, 3, CAST(N'2019-08-20 14:46:20.940' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (13, N'Boot', 1, 3, CAST(N'2019-08-20 14:46:34.940' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (14, N'Dong ho', 2, 4, CAST(N'2019-08-20 14:46:44.833' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (15, N'Vong co', 3, 4, CAST(N'2019-08-20 14:47:21.240' AS DateTime), 0)
INSERT [dbo].[Catagories] ([CatagoryId], [CatagoryName], [CatagoryPriority], [ParentId], [Created], [isDisabled]) VALUES (16, N'That lung', 1, 4, CAST(N'2019-08-20 14:47:30.733' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Catagories] OFF
SET IDENTITY_INSERT [dbo].[Sales] ON 

INSERT [dbo].[Sales] ([SaleId], [SaleName], [Percentage], [Created], [isDisabled]) VALUES (1, N'Giam gia 2/9', 20, CAST(N'2019-08-21 21:19:22.783' AS DateTime), 0)
INSERT [dbo].[Sales] ([SaleId], [SaleName], [Percentage], [Created], [isDisabled]) VALUES (2, N'Giam gia tri an khach hang', 50, CAST(N'2019-08-21 21:42:39.600' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Sales] OFF
SET IDENTITY_INSERT [dbo].[Brands] ON 

INSERT [dbo].[Brands] ([BrandId], [BrandName], [Logo], [Created], [isDisabled]) VALUES (1, N'Uniqlo', N'brand/1.jpg', CAST(N'2019-08-21 21:20:59.590' AS DateTime), 0)
INSERT [dbo].[Brands] ([BrandId], [BrandName], [Logo], [Created], [isDisabled]) VALUES (3, N'Gucci ', N'brand/2.jpg', CAST(N'2019-08-21 21:21:18.980' AS DateTime), 0)
INSERT [dbo].[Brands] ([BrandId], [BrandName], [Logo], [Created], [isDisabled]) VALUES (4, N'Givenchy ', N'brand/3.jpg', CAST(N'2019-08-21 21:22:16.670' AS DateTime), 0)
INSERT [dbo].[Brands] ([BrandId], [BrandName], [Logo], [Created], [isDisabled]) VALUES (5, N'Versace ', N'brand/4.jpg', CAST(N'2019-08-21 21:22:32.150' AS DateTime), 0)
INSERT [dbo].[Brands] ([BrandId], [BrandName], [Logo], [Created], [isDisabled]) VALUES (6, N'Nike ', N'brand/5.jpg', CAST(N'2019-08-21 21:22:50.977' AS DateTime), 0)
INSERT [dbo].[Brands] ([BrandId], [BrandName], [Logo], [Created], [isDisabled]) VALUES (7, N'Prada ', N'brand/6.jpg', CAST(N'2019-08-21 21:23:03.633' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Brands] OFF
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (3, N'Ao khoac den', 98, N'Ao khoac den', 21, 1, 1, 1, CAST(N'2019-08-21 21:45:07.393' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (4, N'Ao mang to ', 188, N'Ao mang to', 22, 1, 2, 1, CAST(N'2019-08-21 21:45:57.760' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (5, N'Ao so mi co tau', 122, N'Day la ao', 21, 1, 1, 1, CAST(N'2019-08-21 21:47:17.410' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (7, N'Quan dui trang', 80, N'quan dui day', 34, 1, 1, 4, CAST(N'2019-08-21 21:49:29.380' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (8, N'Vay xoe', 100, N'cai vay dep', 5, 2, 1, 4, CAST(N'2019-08-21 21:53:07.613' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (9, N'Ao yem', 100, N'cai ao', 5, 2, NULL, 3, CAST(N'2019-08-21 21:53:28.370' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (12, N'Ao so mi cong so', 50, N'de di lam', 67, 2, NULL, 4, CAST(N'2019-08-21 21:55:33.977' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (13, N'Quan jean den', 70, N'quan jean', 1, 2, 1, 4, CAST(N'2019-08-21 21:57:59.990' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (14, N'Giay sneker trang', 200, N'giay trang dep', 23, 3, NULL, 3, CAST(N'2019-08-21 21:59:19.950' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (15, N'Boot cao co', 350, N'boot', 22, 3, 1, 3, CAST(N'2019-08-21 22:00:07.670' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (16, N'Dep cao su', 30, N'tien loi', 56, 3, NULL, 1, CAST(N'2019-08-21 22:01:48.673' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (17, N'Giay the thao', 150, N'de di choi the thao', 43, 3, 2, 4, CAST(N'2019-08-21 22:02:54.323' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (18, N'Dong ho co ', 400, N'sang trong', 44, 4, 1, 3, CAST(N'2019-08-21 22:03:37.903' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (19, N'Dong ho dien tu', 150, N'nang dong', 2, 4, NULL, 1, CAST(N'2019-08-21 22:04:55.090' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (20, N'Nhan kim cuong', 1000.45, N'de cau hon', 52, 4, 2, 1, CAST(N'2019-08-21 22:06:30.140' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (21, N'Ao phao', 100, N'Ao am mac mua dong', 24, 1, NULL, 1, CAST(N'2019-08-23 16:08:53.643' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (26, N'Quan jogger', 110, N'Quan dang the thao', 26, 5, 2, 5, CAST(N'2019-08-23 21:48:44.117' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (28, N'Ao phong trang', 122, N'ao phong', 22, 7, 2, 5, CAST(N'2019-10-04 16:21:23.000' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (29, N'Ao so mi tim', 50, N'ao so mi', 2, 1, NULL, 5, CAST(N'2019-10-04 16:23:48.000' AS DateTime), 0)
INSERT [dbo].[Products] ([ProductId], [ProductName], [Price], [ProductDescription], [BestSeller], [CatagoryId], [SaleId], [BrandId], [Created], [isDisabled]) VALUES (30, N'Quan ngo kaki', 110, N'quan ngu', 12, 9, 2, 5, CAST(N'2019-10-04 16:24:26.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Products] OFF
SET IDENTITY_INSERT [dbo].[Sizes] ON 

INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (1, N'S', 78, 3, CAST(N'2019-08-29 23:32:45.210' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (2, N'M', 2, 3, CAST(N'2019-08-29 23:33:03.140' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (3, N'S', 22, 4, CAST(N'2019-08-29 23:33:18.723' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (4, N'S', 1, 21, CAST(N'2019-08-29 23:33:56.740' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (5, N'L', 4, 21, CAST(N'2019-08-29 23:34:12.533' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (7, N'S', 31, 20, CAST(N'2019-08-30 11:17:27.713' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (8, N'M', 2, 19, CAST(N'2019-08-30 11:18:01.163' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (9, N'S', 29, 18, CAST(N'2019-08-30 11:19:55.990' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (10, N'L', 10, 18, CAST(N'2019-08-30 11:20:04.650' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (11, N'L', 3, 17, CAST(N'2019-08-30 11:22:36.727' AS DateTime), 0)
INSERT [dbo].[Sizes] ([SizeId], [SizeName], [Stock], [ProductId], [Created], [isDisabled]) VALUES (12, N'M', 37, 26, CAST(N'2019-09-25 22:31:18.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Sizes] OFF
SET IDENTITY_INSERT [dbo].[Cities] ON 

INSERT [dbo].[Cities] ([CityId], [CityName], [Distance], [Created], [isDisabled]) VALUES (1, N'Ha Noi', 0, CAST(N'2019-08-20 14:41:33.160' AS DateTime), 0)
INSERT [dbo].[Cities] ([CityId], [CityName], [Distance], [Created], [isDisabled]) VALUES (2, N'Da Nang', 600, CAST(N'2019-08-20 14:41:41.927' AS DateTime), 0)
INSERT [dbo].[Cities] ([CityId], [CityName], [Distance], [Created], [isDisabled]) VALUES (3, N'TP Ho Chi Minh', 1200, CAST(N'2019-08-20 14:41:57.367' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Cities] OFF
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserId], [UserName], [UserPassword], [Email], [FullName], [Phone], [CityId], [UserAddress], [Created], [isDisabled]) VALUES (26, N'nguyenminhquan', N'8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', N'nguyenminhquan291094@gmail.com', N'nguyen minh quan', N'123123', 3, N'So 7, Cong Hoa, quan Binh Thanh', CAST(N'2019-09-23 22:55:24.000' AS DateTime), 0)
INSERT [dbo].[Users] ([UserId], [UserName], [UserPassword], [Email], [FullName], [Phone], [CityId], [UserAddress], [Created], [isDisabled]) VALUES (27, N'thaianhtu', N'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', N'thaianhtu@gmail.com', N'thai anh tu', N'1234567', 1, N'So 5, Huynh Thuc Khang, quan Dong da', CAST(N'2019-09-23 23:00:58.000' AS DateTime), 0)
INSERT [dbo].[Users] ([UserId], [UserName], [UserPassword], [Email], [FullName], [Phone], [CityId], [UserAddress], [Created], [isDisabled]) VALUES (33, N'phamannam', N'481f6cc0511143ccdd7e2d1b1b94faf0a700a8b49cd13922a70b5ae28acaa8c5', N'phamannam@gmail.com', N'Phạm An Nam', N'123123', 2, N'So 5, Huynh Thuc Khang, quan Dong da', CAST(N'2019-09-29 10:20:50.000' AS DateTime), 0)
INSERT [dbo].[Users] ([UserId], [UserName], [UserPassword], [Email], [FullName], [Phone], [CityId], [UserAddress], [Created], [isDisabled]) VALUES (34, N'test 123', N'e0bc60c82713f64ef8a57c0c40d02ce24fd0141d5cc3086259c19b1e62a62bea', N'test123@gmail.com', N'nguyen minh quan', N'123123', 1, N'So 7, Cong Hoa, quan Binh Thanh', CAST(N'2019-09-30 20:12:50.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Users] OFF
SET IDENTITY_INSERT [dbo].[Ships] ON 

INSERT [dbo].[Ships] ([ShipId], [MinDistance], [MaxDistance], [Fee], [Created], [isDisabled]) VALUES (1, 0, 30, 0, CAST(N'2019-09-04 20:32:22.400' AS DateTime), 0)
INSERT [dbo].[Ships] ([ShipId], [MinDistance], [MaxDistance], [Fee], [Created], [isDisabled]) VALUES (3, 31, 500, 20, CAST(N'2019-09-04 20:32:52.863' AS DateTime), 0)
INSERT [dbo].[Ships] ([ShipId], [MinDistance], [MaxDistance], [Fee], [Created], [isDisabled]) VALUES (4, 501, 1000, 50, CAST(N'2019-09-04 20:33:10.870' AS DateTime), 0)
INSERT [dbo].[Ships] ([ShipId], [MinDistance], [MaxDistance], [Fee], [Created], [isDisabled]) VALUES (5, 1001, 2000, 100, CAST(N'2019-09-04 20:33:23.940' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Ships] OFF
SET IDENTITY_INSERT [dbo].[OrderStatus] ON 

INSERT [dbo].[OrderStatus] ([OrderStatusId], [OrderStatusName], [Created], [isDisabled]) VALUES (1, N'Processing', CAST(N'2019-09-04 20:35:22.657' AS DateTime), 0)
INSERT [dbo].[OrderStatus] ([OrderStatusId], [OrderStatusName], [Created], [isDisabled]) VALUES (2, N'Shipping', CAST(N'2019-09-04 20:35:26.680' AS DateTime), 0)
INSERT [dbo].[OrderStatus] ([OrderStatusId], [OrderStatusName], [Created], [isDisabled]) VALUES (3, N'Done', CAST(N'2019-09-04 20:35:33.633' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[OrderStatus] OFF
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (50, 26, N'nguyen minh quan', N'123123', N'nguyenminhquan291094@gmail.com', 1, N'So 7, Cong Hoa, quan Binh Thanh', N'123456', 86.24, 1, 2, CAST(N'2019-08-23 22:58:28.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (51, NULL, N'thai anh tu', N'123456', N'thaianhtu@gmail.com', 2, N'Ha Noi', N'12345', 110.5, 4, 1, CAST(N'2019-07-26 11:12:51.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (52, NULL, N'thai anh tu', N'123123', N'thaianhtu@gmail.com', 2, N'yen hoa', N'123444', 110.5, 4, 1, CAST(N'2019-07-26 11:16:04.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (53, 27, N'thai anh tu', N'123456', N'thaianhtu@gmail.com', 1, N'So 5, Huynh Thuc Khang, quan Dong da', N'4456545', 60.5, 1, 1, CAST(N'2019-11-26 11:22:30.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (58, NULL, N'thai anh tu', N'123123', N'thaianhtu@gmail.com', 3, N'Ha Noi', N'123456', 186.24, 5, 1, CAST(N'2019-09-27 19:36:40.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (59, NULL, N'nguyen minh quan', N'4563463', N'nguyenminhquan291094@gmail.com', 3, N'So 7, Cong Hoa, quan Binh Thanh', N'123123', 186.24, 5, 1, CAST(N'2019-09-27 19:40:02.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (62, NULL, N'thai anh tu', N'123456', N'thaianhtu@gmail.com', 1, N'yen hoa', N'124124', 86.240005493164062, 1, 1, CAST(N'2019-09-27 20:03:13.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (63, NULL, N'thai anh tu', N'123456', N'thaianhtu@gmail.com', 2, N'Ha Noi', N'123124', 136.24000549316406, 4, 1, CAST(N'2019-09-27 20:10:29.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (64, NULL, N'thai anh tu', N'123123', N'thaianhtu@gmail.com', 2, N'So 5, Huynh Thuc Khang, quan Dong da', N'132131', 136.24000549316406, 4, 1, CAST(N'2019-09-27 20:48:42.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (65, NULL, N'nguyen minh quan', N'123456', N'nguyenminhquan291094@gmail.com', 2, N'Ha Noi', N'1322111', 136.24000549316406, 4, 1, CAST(N'2019-05-27 20:50:01.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (66, NULL, N'thaianhtu', N'123456', N'thaianhtu@gmail.com', 2, N'So 5, Huynh Thuc Khang, quan Dong da', N'1234123', 136.24000549316406, 4, 1, CAST(N'2019-09-30 11:00:06.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (67, NULL, N'nguyen minh quan', N'12312312', N'nguyenminhquan291094@gmail.com', 2, N'the daty', N'1564546', 136.24000549316406, 4, 1, CAST(N'2019-09-30 19:45:07.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (68, 26, N'nguyen minh quan', N'123123', N'test123@gmail.com', 1, N'So 7, Cong Hoa, quan Binh Thanh', N'123456', 810.7330322265625, 1, 1, CAST(N'2019-04-30 20:12:57.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (69, 27, N'thai anh tu', N'1234567', N'thaianhtu@gmail.com', 1, N'So 5, Huynh Thuc Khang, quan Dong da', N'123456', 86.240005493164062, 1, 1, CAST(N'2019-10-02 21:29:25.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (70, NULL, N'thai anh tu', N'124', N'thaianhtu@gmail.com', 2, N'Ha Noi', N'123445', 222.48001098632813, 4, 1, CAST(N'2019-10-04 16:05:21.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (71, NULL, N'pham an nam ', N'123456', N'asdasd@gmail.com', 1, N'asdasd', N'1241', 86.240005493164062, 1, 1, CAST(N'2019-10-04 16:09:08.000' AS DateTime), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [FullName], [Phone], [Email], [CityId], [UserAddress], [PostcodeOrZip], [TotalPrice], [ShipId], [OrderStatusId], [Created], [isDisabled]) VALUES (72, NULL, N'thai anh tu', N'12312312', N'nguyenminhquan291094@gmail.com', 1, N'yen hoa', N'55555', 86.240005493164062, 1, 1, CAST(N'2019-10-04 16:12:57.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Orders] OFF
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (50, 3, 1, 1, 78.4, CAST(N'2019-09-23 22:58:28.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (53, 3, 1, 2, 156.8, CAST(N'2019-10-04 16:05:22.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (58, 3, 1, 1, 78.4, CAST(N'2019-09-27 19:36:41.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (59, 3, 1, 1, 78.4, CAST(N'2019-09-27 19:40:32.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (62, 3, 1, 1, 78.4, CAST(N'2019-09-27 20:03:13.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (63, 3, 1, 1, 78.4, CAST(N'2019-09-27 20:10:31.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (64, 3, 1, 1, 78.4, CAST(N'2019-09-27 20:48:42.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (65, 3, 1, 1, 78.4, CAST(N'2019-09-27 20:50:01.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (66, 3, 1, 1, 78.4, CAST(N'2019-09-30 11:00:07.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (67, 3, 1, 1, 78.4, CAST(N'2019-09-30 19:45:08.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (68, 3, 1, 1, 78.4, CAST(N'2019-09-30 20:12:58.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (68, 3, 2, 1, 78.4, CAST(N'2019-09-30 20:12:59.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (69, 3, 1, 1, 78.4, CAST(N'2019-10-02 21:29:27.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (71, 3, 1, 1, 78.4, CAST(N'2019-10-04 16:09:08.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (72, 3, 1, 1, 78.4, CAST(N'2019-10-04 16:12:58.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (68, 20, 7, 1, 500.23, CAST(N'2019-09-30 20:12:59.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (68, 21, 4, 1, 80, CAST(N'2019-09-30 20:12:59.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (51, 26, 12, 1, 55, CAST(N'2019-09-26 11:12:52.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (52, 26, 12, 1, 55, CAST(N'2019-09-26 11:16:04.000' AS DateTime), 0)
INSERT [dbo].[OrderDetail] ([OrderId], [ProductId], [SizeId], [Quantity], [TotalPrice], [Created], [isDisabled]) VALUES (53, 26, 12, 1, 55, CAST(N'2019-09-26 11:22:31.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[ProductComments] ON 

INSERT [dbo].[ProductComments] ([CommentId], [UserId], [FullName], [Review], [Rating], [ProductId], [Created], [isDisabled]) VALUES (23, 26, N'thaianhtu', N'san pham tot', 4, 3, CAST(N'2019-09-23 22:57:45.000' AS DateTime), 0)
INSERT [dbo].[ProductComments] ([CommentId], [UserId], [FullName], [Review], [Rating], [ProductId], [Created], [isDisabled]) VALUES (24, 27, N'thaianhtu', N'not good', 1, 3, CAST(N'2019-09-28 17:03:53.000' AS DateTime), 1)
INSERT [dbo].[ProductComments] ([CommentId], [UserId], [FullName], [Review], [Rating], [ProductId], [Created], [isDisabled]) VALUES (25, 27, N'thaianhtu', N'test 123 321', 2, 3, CAST(N'2019-09-30 20:17:23.000' AS DateTime), 1)
INSERT [dbo].[ProductComments] ([CommentId], [UserId], [FullName], [Review], [Rating], [ProductId], [Created], [isDisabled]) VALUES (26, 27, N'thaianhtu', N'ABC DS', 2, 3, CAST(N'2019-09-30 20:18:25.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[ProductComments] OFF
SET IDENTITY_INSERT [dbo].[UserFeedbacks] ON 

INSERT [dbo].[UserFeedbacks] ([FeedbackId], [UserId], [FullName], [Email], [ContactTitle], [ContactMessage], [Created], [isDisabled]) VALUES (5, 27, N'thai anh tu', N'thaianhtu@gmail.com', N'test 1', N'testag', CAST(N'2019-09-30 20:15:45.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[UserFeedbacks] OFF
INSERT [dbo].[WishList] ([ProductId], [UserId], [Created], [isDisabled]) VALUES (18, 27, CAST(N'2019-09-28 16:55:33.000' AS DateTime), 0)
INSERT [dbo].[WishList] ([ProductId], [UserId], [Created], [isDisabled]) VALUES (19, 27, CAST(N'2019-09-28 16:54:49.000' AS DateTime), 0)
INSERT [dbo].[WishList] ([ProductId], [UserId], [Created], [isDisabled]) VALUES (21, 27, CAST(N'2019-09-26 22:14:30.000' AS DateTime), 0)
INSERT [dbo].[WishList] ([ProductId], [UserId], [Created], [isDisabled]) VALUES (26, 27, CAST(N'2019-09-26 22:10:23.000' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[Banners] ON 

INSERT [dbo].[Banners] ([BannerId], [BannerName], [BannerDescription], [BannerImage], [Size], [CatagoryId], [Created], [isDisabled]) VALUES (1, N'hand bags', N'New collection', N'banner/11.jpg', 0, 4, CAST(N'2019-08-20 15:24:10.353' AS DateTime), 0)
INSERT [dbo].[Banners] ([BannerId], [BannerName], [BannerDescription], [BannerImage], [Size], [CatagoryId], [Created], [isDisabled]) VALUES (2, N'watches', N'Sale up to 70%  off', N'banner/9.jpg', 0, 4, CAST(N'2019-08-20 15:24:59.657' AS DateTime), 0)
INSERT [dbo].[Banners] ([BannerId], [BannerName], [BannerDescription], [BannerImage], [Size], [CatagoryId], [Created], [isDisabled]) VALUES (3, N'scarfs', N'Free shipping', N'banner/10.jpg', 0, 4, CAST(N'2019-08-20 15:26:11.543' AS DateTime), 0)
INSERT [dbo].[Banners] ([BannerId], [BannerName], [BannerDescription], [BannerImage], [Size], [CatagoryId], [Created], [isDisabled]) VALUES (4, N'exclusive backpack', N'best products for women & men', N'banner/12.jpg', 1, 4, CAST(N'2019-08-20 15:27:24.427' AS DateTime), 0)
INSERT [dbo].[Banners] ([BannerId], [BannerName], [BannerDescription], [BannerImage], [Size], [CatagoryId], [Created], [isDisabled]) VALUES (5, N'trendy backpack', N'for Student', N'banner/12.jpg', 1, 4, CAST(N'2019-08-20 15:27:58.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Banners] OFF
SET IDENTITY_INSERT [dbo].[ProductImages] ON 

INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (2, N'product/16.jpg', 5, CAST(N'2019-08-21 22:09:49.693' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (3, N'product/19.jpg', 4, CAST(N'2019-08-21 22:09:56.670' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (4, N'product/3.jpg', 5, CAST(N'2019-08-21 22:10:22.540' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (5, N'product/4.jpg', 7, CAST(N'2019-08-21 22:10:33.440' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (6, N'product/5.jpg', 8, CAST(N'2019-08-21 22:10:44.667' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (7, N'product/6.jpg', 9, CAST(N'2019-08-21 22:10:52.010' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (8, N'product/7.jpg', 12, CAST(N'2019-08-21 22:11:31.093' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (9, N'product/8.jpg', 13, CAST(N'2019-08-21 22:11:37.670' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (10, N'product/9.jpg', 14, CAST(N'2019-08-21 22:11:42.513' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (11, N'product/10.jpg', 15, CAST(N'2019-08-21 22:11:54.700' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (12, N'product/11.jpg', 16, CAST(N'2019-08-21 22:12:07.433' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (13, N'product/12.jpg', 17, CAST(N'2019-08-21 22:12:12.187' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (14, N'product/13.jpg', 18, CAST(N'2019-08-21 22:12:16.967' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (15, N'product/14.jpg', 19, CAST(N'2019-08-21 22:12:21.723' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (16, N'product/15.jpg', 20, CAST(N'2019-08-21 22:12:31.690' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (19, N'product/24.png', 3, CAST(N'2019-08-22 23:31:40.227' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (20, N'product/2.jpg', 3, CAST(N'2019-08-22 23:31:47.403' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (21, N'product/17.jpg', 3, CAST(N'2019-08-22 23:32:07.140' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (22, N'product/18.jpg', 3, CAST(N'2019-08-22 23:32:18.803' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (23, N'product/20.jpg', 21, CAST(N'2019-08-23 16:26:00.920' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (26, N'product/6.jpg', 3, CAST(N'2019-09-23 20:41:33.000' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (27, N'product/3.jpg', 3, CAST(N'2019-09-23 21:02:01.000' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (28, N'product/6.jpg', 3, CAST(N'2019-09-23 21:07:02.000' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (29, N'product/img95458212855952558818.jpg', 26, CAST(N'2019-10-04 16:18:38.000' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (30, N'product/img78396248868267632788.jpg', 28, CAST(N'2019-10-04 16:22:06.000' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (31, N'product/img25169810330318891278.jpg', 29, CAST(N'2019-10-04 16:24:40.000' AS DateTime), 0)
INSERT [dbo].[ProductImages] ([ImageId], [Link], [ProductId], [Created], [isDisabled]) VALUES (32, N'product/img83643972675827434978.jpg', 30, CAST(N'2019-10-04 16:24:51.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[ProductImages] OFF
SET IDENTITY_INSERT [dbo].[Sliders] ON 

INSERT [dbo].[Sliders] ([SliderId], [Title], [SubTitle], [Content], [ImageLink], [ProductId], [Created], [isDisabled]) VALUES (1, N'handbag for men’s 2018', N'Drawstring Backpack In Black', N'Boston based brand, New Balance began life in the 1900s as an arch support company. ', N'slider/home-04-1.jpg', 3, CAST(N'2019-08-20 14:50:43.120' AS DateTime), 0)
INSERT [dbo].[Sliders] ([SliderId], [Title], [SubTitle], [Content], [ImageLink], [ProductId], [Created], [isDisabled]) VALUES (2, N'SPRING  for men’s 2018', N'Spiral Classic handbag In Navy 2018', N'Bored with the basic backpack, Spiral''s bags pack a punch with bold, striking designs.', N'slider/home-04-2.jpg', 4, CAST(N'2019-08-20 14:51:14.640' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Sliders] OFF
SET IDENTITY_INSERT [dbo].[Admins] ON 

INSERT [dbo].[Admins] ([AdminId], [AdminName], [AdminPassword], [Created], [isDisabled], [Salt]) VALUES (5, N'nampa', N'9a6bc50875d37813bf40f41eec814364f6b26c4c13f80443225620db976a1445', CAST(N'2019-09-16 19:21:51.000' AS DateTime), 0, N'Y1SoUvBvfV')
SET IDENTITY_INSERT [dbo].[Admins] OFF
SET IDENTITY_INSERT [dbo].[Faq] ON 

INSERT [dbo].[Faq] ([FaqId], [Question], [Answer], [Created], [isDisabled]) VALUES (2, N'Cersei Lannister', N'Queen Cersei I Lannister was the twentieth ruler of the Seven Kingdoms and the widow of King Robert Baratheon, with whom she had her sole trueborn child. She was the daughter of Lord Tywin Lannister, twin sister of Ser Jaime Lannister and elder sister of Tyrion Lannister. She was involved in an incestuous relationship with Jaime, who was secretly the father of her three bastard children, Joffrey, Myrcella and Tommen, as well as an unborn child.', CAST(N'2019-09-15 21:02:08.657' AS DateTime), 0)
INSERT [dbo].[Faq] ([FaqId], [Question], [Answer], [Created], [isDisabled]) VALUES (3, N'Jaime Lannister', N'Ser Jaime Lannister was the eldest son of Lord Tywin Lannister, younger twin brother of Queen Cersei Lannister, and older brother of Tyrion Lannister. He was involved in an incestuous relationship with Cersei, and unknown to most, he was the biological father of her three bastard children, Joffrey, Myrcella, and Tommen, as well as her unborn child.', CAST(N'2019-09-15 21:02:30.693' AS DateTime), 0)
INSERT [dbo].[Faq] ([FaqId], [Question], [Answer], [Created], [isDisabled]) VALUES (4, N'Tywin Lanister', N'Lord Tywin Lannister was the head of House Lannister, Lord of Casterly Rock, Warden of the West, Lord Paramount of the Westerlands, Hand of the King for three different kings, and Protector of the Realm. He was the father of Cersei, Jaime, and Tyrion Lannister, and sole grandfather of the incest-born Joffrey, Myrcella, and Tommen Baratheon.', CAST(N'2019-09-15 21:04:01.983' AS DateTime), 0)
INSERT [dbo].[Faq] ([FaqId], [Question], [Answer], [Created], [isDisabled]) VALUES (5, N'Tyrion Lannister', N'Lord Tyrion Lannister is the youngest child of Lord Tywin Lannister and younger brother of Queen Cersei and Ser Jaime Lannister. A dwarf, he uses his wit and intellect to overcome the prejudice he faces.', CAST(N'2019-09-15 21:05:23.767' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Faq] OFF
SET IDENTITY_INSERT [dbo].[ShopInformation] ON 

INSERT [dbo].[ShopInformation] ([ShopInformationId], [LogoTop], [Slogan], [ShopImage], [ShopDescription], [FounderImage], [FounderQuote], [ContactEmail], [ContactPhone], [ContactAddress], [Created], [isDisabled], [LogoBottom]) VALUES (1, N'shopInformation/lgTop76229941554730011853.jpg', N'What trendy is handy', N'shopInformation/sImg06832598584910586269.jpg', N'We are the best shop', N'shopInformation/fImg34591018625027711660.jpg', N'We work our best for our customers and user', N'T90@gmail.com', N'+(1234) 567 890', N'170,Yen Hoa, Cau Giay, Ha Noi', CAST(N'2019-08-21 10:41:54.543' AS DateTime), 0, N'shopInformation/lgBot72495592207382222927.jpg')
SET IDENTITY_INSERT [dbo].[ShopInformation] OFF
SET IDENTITY_INSERT [dbo].[Stores] ON 

INSERT [dbo].[Stores] ([StoreId], [StoreName], [Email], [Phone], [StoreAddress], [Created], [isDisabled], [StoreImage]) VALUES (1, N'T90 Trendy', N'trendy@gmail.com', N'123456', N'So 6, Thai Ha', CAST(N'2019-09-16 15:01:51.213' AS DateTime), 0, N'store/store1.jpg')
INSERT [dbo].[Stores] ([StoreId], [StoreName], [Email], [Phone], [StoreAddress], [Created], [isDisabled], [StoreImage]) VALUES (13, N'T90 Basic', N'basic@gmail.com', N'222222', N'So 23, Cau Giay', CAST(N'2019-09-16 15:05:36.000' AS DateTime), 0, N'store/store2.jpg')
INSERT [dbo].[Stores] ([StoreId], [StoreName], [Email], [Phone], [StoreAddress], [Created], [isDisabled], [StoreImage]) VALUES (16, N'T90 Vintage', N'vintage@gmail.com', N'23233', N'So 155, Hoang Quoc Viet', CAST(N'2019-09-16 15:08:03.560' AS DateTime), 0, N'store/store3.jpg')
INSERT [dbo].[Stores] ([StoreId], [StoreName], [Email], [Phone], [StoreAddress], [Created], [isDisabled], [StoreImage]) VALUES (20, N'T90 Lady', N'lady@gmail.com', N'456789', N'So 30, Tran Hung Dao', CAST(N'2019-09-16 15:09:40.290' AS DateTime), 0, N'store/store4.jpg')
SET IDENTITY_INSERT [dbo].[Stores] OFF
