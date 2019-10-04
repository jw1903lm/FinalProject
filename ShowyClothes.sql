create database ShowyClothes
go
use ShowyClothes
go
create table Cities(
	CityId int identity(1,1) primary key,
	CityName nvarchar(50) unique null,
	Distance int not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Users(
	UserId int identity(1,1) primary key,
	UserName varchar(15) unique not null,
	UserPassword varchar(100) unique not null,
	Email varchar(100) unique not null,
	FullName nvarchar(50) null,
	Phone varchar(20) null,
	CityId int not null foreign key references Cities(CityId),
	UserAddress nvarchar(200) null,	
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Catagories(
	CatagoryId int identity(1,1) primary key,
	CatagoryName nvarchar(30) not null,
	CatagoryPriority int default 1,
	ParentId int default 0,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go 
create table Sales(
	SaleId int identity(1,1) primary key,
	SaleName nvarchar(100) not null,
	Percentage int not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go 
create table Brands(
	BrandId int identity(1,1) primary key,
	BrandName nvarchar(100) not null,
	Logo nvarchar(100) not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Products(
	ProductId int identity(1,1) primary key,
	ProductName nvarchar(100) not null,
	Price float not null,
	ProductDescription ntext null,
	BestSeller int default 0,
	CatagoryId int not null foreign key references Catagories(CatagoryId),
	SaleId int null foreign key references Sales(SaleId),
	BrandId int null foreign key references Brands(BrandId),
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Sizes(
	SizeId int identity(1,1) primary key,
	SizeName varchar(5) not null,
	Stock int not null,
	ProductId int not null foreign key references Products(ProductId),	
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table ProductImages(
	ImageId int identity(1,1) primary key,
	Link nvarchar(100) not null,
	ProductId int not null foreign key references Products(ProductId),
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table ProductComments(
	CommentId int identity(1,1) primary key,
	UserId int null foreign key references Users(UserId),
	FullName nvarchar(50) not null,
	Review ntext not null,
	Rating int,
	ProductId int not null foreign key references Products(ProductId),
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Ships(
	ShipId int identity(1,1) primary key,
	MinDistance int not null,
	MaxDistance int not null,
	Fee float not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table OrderStatus(
	OrderStatusId int identity(1,1) primary key,
	OrderStatusName nvarchar(20) null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
create table Orders(
	OrderId int identity(1,1) primary key,
	UserId int null foreign key references Users(UserId),
	FullName nvarchar(50) not null,
	Phone varchar(20) not null,
	Email varchar(100) not null,
	CityId int not null foreign key references Cities(CityId),
	UserAddress nvarchar(200) not null,
	PostcodeOrZip varchar(50) not null,
	TotalPrice float null,
	ShipId int not null foreign key references Ships(ShipId),
	OrderStatusId int null foreign key references OrderStatus(OrderStatusId),
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table OrderDetail(
	OrderId int not null foreign key references Orders(OrderId),
	ProductId int not null foreign key references Products(ProductId),
	SizeId int null foreign key references Sizes(SizeId),
	Quantity int not null,
	TotalPrice float null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
	primary key(ProductId, OrderId,SizeId)
)
go
create table UserFeedbacks(
	FeedbackId int identity(1,1) primary key,
	UserId int null foreign key references Users(UserId),
	FullName nvarchar(50) null, 
	Email varchar(100) null,
	ContactTitle ntext null,
	ContactMessage ntext not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table WishList(
	ProductId int not null foreign key references Products(ProductId),
	UserId int not null foreign key references Users(UserId),
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
	primary key(ProductId, UserId)
)
go
create table Sliders(
	SliderId int identity(1,1) primary key,
	Title nvarchar(100) null,
	SubTitle nvarchar(100) null,
	Content nvarchar(100) null,
	ImageLink varchar(100) not null,
	ProductId int not null foreign key references Products(ProductId),
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Banners(
	BannerId int identity(1,1) primary key,
	BannerName nvarchar(100) not null,
	BannerDescription nvarchar(500) null,
	BannerImage nvarchar(100) not null,
	Size bit not null default 0,
	CatagoryId int not null foreign key references Catagories(CatagoryId),
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Stores(
	StoreId int identity(1,1) primary key,
	StoreName nvarchar(20) not null,
	Email varchar(100) not null,
	Phone varchar(20) not null,
	StoreAddress nvarchar(200) not null,
	StoreImage varchar(100) not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table ShopInformation(
	ShopInformationId int identity(1,1) primary key,
	LogoTop varchar(100) not null,
	LogoBottom varchar(100) not null,
	Slogan nvarchar(500) not null,
	ShopImage varchar(100) null,
	ShopDescription ntext null,
	FounderImage varchar(100) null,
	FounderQuote ntext null,
	ContactEmail varchar(100) not null,
	ContactPhone varchar(20) not null,
	ContactAddress nvarchar(200) not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go
create table Faq(
	FaqId int identity(1,1) primary key,
	Question ntext not null,
	Answer ntext not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)
go 
create table Admins(
	AdminId int identity(1,1) primary key,
	AdminName varchar(15) unique not null,
	AdminPassword varchar(100) unique not null,
	Created datetime not null default getdate(),
	isDisabled bit  not null default 0
)