USE [master]
GO
/****** Object:  Database [qlBanHangQuanAo]    Script Date: 12/12/2023 10:41:54 PM ******/
CREATE DATABASE [qlBanHangQuanAo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'qlBanHangQuanAo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\qlBanHangQuanAo.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'qlBanHangQuanAo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\qlBanHangQuanAo_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [qlBanHangQuanAo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [qlBanHangQuanAo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET ARITHABORT OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [qlBanHangQuanAo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [qlBanHangQuanAo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET  DISABLE_BROKER 
GO
ALTER DATABASE [qlBanHangQuanAo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [qlBanHangQuanAo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET RECOVERY FULL 
GO
ALTER DATABASE [qlBanHangQuanAo] SET  MULTI_USER 
GO
ALTER DATABASE [qlBanHangQuanAo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [qlBanHangQuanAo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [qlBanHangQuanAo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [qlBanHangQuanAo] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [qlBanHangQuanAo] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [qlBanHangQuanAo] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'qlBanHangQuanAo', N'ON'
GO
ALTER DATABASE [qlBanHangQuanAo] SET QUERY_STORE = ON
GO
ALTER DATABASE [qlBanHangQuanAo] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [qlBanHangQuanAo]
GO
/****** Object:  Table [dbo].[CaLam]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CaLam](
	[maCaLam] [varchar](4) NOT NULL,
	[buoi] [nvarchar](10) NOT NULL,
	[thoiGianBatDau] [nvarchar](15) NULL,
	[thoiGianKetThuc] [nvarchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[maCaLam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [varchar](6) NOT NULL,
	[maSanPham] [varchar](6) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietKhuyenMai]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietKhuyenMai](
	[maKhuyenMai] [varchar](6) NOT NULL,
	[maSanPham] [varchar](6) NOT NULL,
	[phanTramKhuyenMai] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhuyenMai] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDatHang]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDatHang](
	[maPhieuDatHang] [varchar](6) NOT NULL,
	[maSanPham] [varchar](6) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuDatHang] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[maPhieuNhap] [varchar](6) NOT NULL,
	[maSanPham] [varchar](6) NOT NULL,
	[soLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [varchar](6) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[nguoiLap] [varchar](6) NOT NULL,
	[khachHang] [varchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [varchar](6) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[gioiTinh] [varchar](6) NOT NULL,
	[diaChi] [nvarchar](255) NULL,
	[soDienThoai] [varchar](10) NOT NULL,
	[email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKhuyenMai] [varchar](6) NOT NULL,
	[tenKhuyenMai] [nvarchar](255) NOT NULL,
	[ngayBatDau] [date] NOT NULL,
	[ngayKetThuc] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[maKichThuoc] [varchar](4) NOT NULL,
	[tenKichThuoc] [varchar](4) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKichThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiNhanVien]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiNhanVien](
	[maLoaiNhanVien] [varchar](6) NOT NULL,
	[tenLoaiNhanVien] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[maLoaiSanPham] [varchar](6) NOT NULL,
	[tenLoaiSanPham] [nvarchar](70) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[maMauSac] [varchar](4) NOT NULL,
	[tenMauSac] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maMauSac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [varchar](6) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [varchar](6) NOT NULL,
	[diaChi] [nvarchar](255) NULL,
	[soDienThoai] [varchar](10) NOT NULL,
	[quanLy] [varchar](6) NULL,
	[maLoaiNhanVien] [varchar](6) NOT NULL,
	[luong] [float] NOT NULL,
	[caLam] [varchar](4) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatHang]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatHang](
	[maPhieuDatHang] [varchar](6) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[nguoiLap] [varchar](6) NOT NULL,
	[khachHang] [varchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuDatHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[maPhieuNhap] [varchar](6) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[nguoiLap] [varchar](6) NOT NULL,
	[nhaCungCap] [nvarchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [varchar](6) NOT NULL,
	[tenSanPham] [nvarchar](60) NOT NULL,
	[donVi] [nvarchar](20) NOT NULL,
	[nhaCungCap] [nvarchar](60) NULL,
	[hinhAnh] [nvarchar](255) NULL,
	[mauSac] [varchar](4) NOT NULL,
	[kichThuoc] [varchar](4) NOT NULL,
	[soLuong] [int] NULL,
	[maLoaiSanPham] [varchar](6) NOT NULL,
	[donGia] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/12/2023 10:41:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTaiKhoan] [varchar](6) NOT NULL,
	[maNhanVien] [varchar](6) NOT NULL,
	[tenTaiKhoan] [varchar](20) NOT NULL,
	[matKhau] [varchar](20) NOT NULL,
	[email] [varchar](50) NULL,
	[quyenHan] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CaLam] ([maCaLam], [buoi], [thoiGianBatDau], [thoiGianKetThuc]) VALUES (N'CL01', N'sáng', N'9h', N'4h')
INSERT [dbo].[CaLam] ([maCaLam], [buoi], [thoiGianBatDau], [thoiGianKetThuc]) VALUES (N'CL02', N'chiều', N'4h', N'10h')
GO
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0001', N'SP0001', 2, 350000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0002', N'SP0001', 1, 350000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0002', N'SP0002', 1, 300000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0003', N'SP0001', 2, 350000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0003', N'SP0002', 1, 300000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0004', N'SP0002', 5, 300000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0004', N'SP0003', 5, 400000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0005', N'SP0001', 1, 420000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0005', N'SP0002', 2, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0006', N'SP0002', 4, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0007', N'SP0001', 2, 420000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0007', N'SP0003', 4, 480000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0008', N'SP0001', 3, 420000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0008', N'SP0002', 2, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0008', N'SP0003', 1, 480000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0009', N'SP0003', 1, 480000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0009', N'SP0004', 2, 336000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0010', N'SP0002', 1, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0011', N'SP0003', 3, 480000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0011', N'SP0004', 3, 336000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0012', N'SP0002', 2, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0013', N'SP0003', 1, 480000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0013', N'SP0004', 1, 336000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0014', N'SP0004', 2, 336000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0015', N'SP0004', 2, 336000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0016', N'SP0001', 1, 420000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0016', N'SP0002', 1, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0016', N'SP0004', 1, 336000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0017', N'SP0001', 1, 420000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0017', N'SP0002', 2, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0017', N'SP0003', 2, 480000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0018', N'SP0002', 2, 360000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0019', N'SP0001', 1, 390600)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0019', N'SP0002', 2, 324000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0021', N'SP0001', 1, 420000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD0021', N'SP0002', 1, 360000)
GO
INSERT [dbo].[ChiTietKhuyenMai] ([maKhuyenMai], [maSanPham], [phanTramKhuyenMai]) VALUES (N'KM0001', N'SP0001', 7)
INSERT [dbo].[ChiTietKhuyenMai] ([maKhuyenMai], [maSanPham], [phanTramKhuyenMai]) VALUES (N'KM0001', N'SP0002', 10)
INSERT [dbo].[ChiTietKhuyenMai] ([maKhuyenMai], [maSanPham], [phanTramKhuyenMai]) VALUES (N'KM0002', N'SP0004', 5)
GO
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0001', N'SP0001', 2, 420000)
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0001', N'SP0003', 2, 480000)
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0001', N'SP0004', 2, 336000)
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0002', N'SP0004', 3, 336000)
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0003', N'SP0001', 1, 420000)
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0003', N'SP0002', 1, 360000)
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0004', N'SP0001', 1, 390600)
INSERT [dbo].[ChiTietPhieuDatHang] ([maPhieuDatHang], [maSanPham], [soLuong], [donGia]) VALUES (N'DH0004', N'SP0002', 1, 324000)
GO
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0001', N'SP0001', 2)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0002', N'SP0002', 1)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0003', N'SP0003', 5)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0004', N'SP0001', 5)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0005', N'SP0002', 2)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0006', N'SP0002', 3)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0007', N'SP0003', 5)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0008', N'SP0003', 5)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0009', N'SP0004', 20)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0010', N'SP0001', 5)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0010', N'SP0002', 5)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0011', N'SP0004', 2)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0012', N'SP0003', 6)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0012', N'SP0004', 8)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0013', N'SP0003', 2)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0013', N'SP0004', 1)
INSERT [dbo].[ChiTietPhieuNhap] ([maPhieuNhap], [maSanPham], [soLuong]) VALUES (N'PN0014', N'SP0002', 8)
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0001', CAST(N'2023-10-23' AS Date), N'NV0001', N'KH0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0002', CAST(N'2023-10-23' AS Date), N'NV0001', N'KH0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0003', CAST(N'2023-10-23' AS Date), N'NV0001', N'KH0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0004', CAST(N'2023-10-31' AS Date), N'NV0001', N'KH0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0005', CAST(N'2023-11-06' AS Date), N'NV0001', N'KH0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0006', CAST(N'2023-11-06' AS Date), N'NV0001', N'KH0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0007', CAST(N'2023-11-11' AS Date), N'NV0001', N'KH0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0008', CAST(N'2023-11-11' AS Date), N'NV0001', N'KH0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0009', CAST(N'2023-11-11' AS Date), N'NV0001', N'KH0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0010', CAST(N'2023-11-11' AS Date), N'NV0001', N'KH0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0011', CAST(N'2023-11-11' AS Date), N'NV0001', N'KH0004')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0012', CAST(N'2023-11-13' AS Date), N'NV0001', N'KH0006')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0013', CAST(N'2023-11-13' AS Date), N'NV0001', N'KH0006')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0014', CAST(N'2023-11-13' AS Date), N'NV0004', N'KH0007')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0015', CAST(N'2023-11-13' AS Date), N'NV0001', N'KH0005')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0016', CAST(N'2023-11-14' AS Date), N'NV0001', N'KH0006')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0017', CAST(N'2023-11-14' AS Date), N'NV0001', N'KH0006')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0018', CAST(N'2023-11-21' AS Date), N'NV0001', N'KH0007')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0019', CAST(N'2023-11-21' AS Date), N'NV0001', N'KH0007')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0020', CAST(N'2023-12-11' AS Date), N'NV0001', N'KH0006')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'HD0021', CAST(N'2023-12-11' AS Date), N'NV0001', N'KH0006')
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [diaChi], [soDienThoai], [email]) VALUES (N'KH0001', N'Lê Văn C', N'nam', N'Q12', N'0908655223', NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [diaChi], [soDienThoai], [email]) VALUES (N'KH0002', N'Trần Trọng T', N'nam', N'Q12', N'0908654778', NULL)
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [diaChi], [soDienThoai], [email]) VALUES (N'KH0003', N'Nguyễn Thị C', N'nu', N'Gò Vấp', N'0908354188', N'C@gmail.com')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [diaChi], [soDienThoai], [email]) VALUES (N'KH0004', N'Nguyễn D', N'nu', N'Gò Vấp', N'0788213372', N'')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [diaChi], [soDienThoai], [email]) VALUES (N'KH0005', N'Lê Thị V', N'nu', N'Bình Tân', N'0774662892', N'LeThiV@gmail.com')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [diaChi], [soDienThoai], [email]) VALUES (N'KH0006', N'Trần Thanh B', N'nam', N'Tân Bình', N'0787622877', N'')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [diaChi], [soDienThoai], [email]) VALUES (N'KH0007', N'Đinh Tiến Đ', N'nam', N'Gò Vấp', N'0902221345', N'TienD123@gmail.com')
GO
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ngayBatDau], [ngayKetThuc]) VALUES (N'KM0001', N'sale 20% lần 1', CAST(N'2023-11-18' AS Date), CAST(N'2023-11-26' AS Date))
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ngayBatDau], [ngayKetThuc]) VALUES (N'KM0002', N'Sale Noel', CAST(N'2023-12-02' AS Date), CAST(N'2023-12-30' AS Date))
GO
INSERT [dbo].[KichThuoc] ([maKichThuoc], [tenKichThuoc]) VALUES (N'KT01', N'S')
INSERT [dbo].[KichThuoc] ([maKichThuoc], [tenKichThuoc]) VALUES (N'KT02', N'M')
INSERT [dbo].[KichThuoc] ([maKichThuoc], [tenKichThuoc]) VALUES (N'KT03', N'L')
INSERT [dbo].[KichThuoc] ([maKichThuoc], [tenKichThuoc]) VALUES (N'KT04', N'XL')
INSERT [dbo].[KichThuoc] ([maKichThuoc], [tenKichThuoc]) VALUES (N'KT05', N'XXL')
INSERT [dbo].[KichThuoc] ([maKichThuoc], [tenKichThuoc]) VALUES (N'KT06', N'XXXL')
GO
INSERT [dbo].[LoaiNhanVien] ([maLoaiNhanVien], [tenLoaiNhanVien]) VALUES (N'LNV001', N'Quản lý')
INSERT [dbo].[LoaiNhanVien] ([maLoaiNhanVien], [tenLoaiNhanVien]) VALUES (N'LNV002', N'Bán hàng')
GO
INSERT [dbo].[LoaiSanPham] ([maLoaiSanPham], [tenLoaiSanPham]) VALUES (N'LSP001', N'quần')
INSERT [dbo].[LoaiSanPham] ([maLoaiSanPham], [tenLoaiSanPham]) VALUES (N'LSP002', N'áo')
INSERT [dbo].[LoaiSanPham] ([maLoaiSanPham], [tenLoaiSanPham]) VALUES (N'LSP003', N'nón')
GO
INSERT [dbo].[MauSac] ([maMauSac], [tenMauSac]) VALUES (N'MS01', N'trắng')
INSERT [dbo].[MauSac] ([maMauSac], [tenMauSac]) VALUES (N'MS02', N'đen')
INSERT [dbo].[MauSac] ([maMauSac], [tenMauSac]) VALUES (N'MS03', N'đỏ')
INSERT [dbo].[MauSac] ([maMauSac], [tenMauSac]) VALUES (N'MS04', N'xanh')
INSERT [dbo].[MauSac] ([maMauSac], [tenMauSac]) VALUES (N'MS05', N'vàng')
INSERT [dbo].[MauSac] ([maMauSac], [tenMauSac]) VALUES (N'MS06', N'tím')
INSERT [dbo].[MauSac] ([maMauSac], [tenMauSac]) VALUES (N'MS07', N'hồng')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [quanLy], [maLoaiNhanVien], [luong], [caLam]) VALUES (N'NV0001', N'Nguyễn Văn A', CAST(N'2000-02-14' AS Date), N'nam', N'Q12', N'0795462375', NULL, N'LNV001', 10000000, N'CL01')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [quanLy], [maLoaiNhanVien], [luong], [caLam]) VALUES (N'NV0002', N'Trần Văn B', CAST(N'2001-08-24' AS Date), N'nu', N'Gò Vấp', N'078546221', N'NV0001', N'LNV002', 5000000, N'CL01')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [quanLy], [maLoaiNhanVien], [luong], [caLam]) VALUES (N'NV0003', N'Lê Văn C', CAST(N'2001-04-11' AS Date), N'nam', N'Gò Vấp', N'0908655761', N'NV0001', N'LNV002', 5500000, N'CL02')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [quanLy], [maLoaiNhanVien], [luong], [caLam]) VALUES (N'NV0004', N'Trương Chi Bảo', CAST(N'2003-06-15' AS Date), N'nam', N'Q12', N'0774025712', NULL, N'LNV001', 10000000, N'CL01')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [quanLy], [maLoaiNhanVien], [luong], [caLam]) VALUES (N'NV0005', N'Nguyễn Văn Đạt', CAST(N'2003-08-20' AS Date), N'nam', N'Bình Dương', N'0909888245', NULL, N'LNV001', 15000000, N'CL02')
GO
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'DH0001', CAST(N'2023-11-13' AS Date), N'NV0004', N'KH0007')
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'DH0002', CAST(N'2023-11-14' AS Date), N'NV0001', N'KH0005')
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'DH0003', CAST(N'2023-11-22' AS Date), N'NV0001', N'KH0006')
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [nguoiLap], [khachHang]) VALUES (N'DH0004', CAST(N'2023-11-22' AS Date), N'NV0001', N'KH0005')
GO
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0001', CAST(N'2023-10-31' AS Date), N'NV0001', N'SMSS')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0002', CAST(N'2023-10-31' AS Date), N'NV0001', N'SMSS')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0003', CAST(N'2023-10-31' AS Date), N'NV0001', N'AM')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0004', CAST(N'2023-10-31' AS Date), N'NV0001', N'SMSS')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0005', CAST(N'2023-10-31' AS Date), N'NV0001', N'SMSS')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0006', CAST(N'2023-10-31' AS Date), N'NV0001', N'SMSS')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0007', CAST(N'2023-10-31' AS Date), N'NV0001', N'AM')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0008', CAST(N'2023-10-31' AS Date), N'NV0001', N'AM')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0009', CAST(N'2023-11-10' AS Date), N'NV0001', N'AM')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0010', CAST(N'2023-11-13' AS Date), N'NV0004', N'SMSS')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0011', CAST(N'2023-11-13' AS Date), N'NV0001', N'am')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0012', CAST(N'2023-11-14' AS Date), N'NV0001', N'AM')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0013', CAST(N'2023-12-02' AS Date), N'NV0001', N'AM')
INSERT [dbo].[PhieuNhap] ([maPhieuNhap], [ngayLap], [nguoiLap], [nhaCungCap]) VALUES (N'PN0014', CAST(N'2023-12-12' AS Date), N'NV0001', N'SMSS')
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [donVi], [nhaCungCap], [hinhAnh], [mauSac], [kichThuoc], [soLuong], [maLoaiSanPham], [donGia]) VALUES (N'SP0001', N'Áo thun sọc', N'cái', N'SMSS', NULL, N'MS01', N'KT02', 6, N'LSP002', 350000)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [donVi], [nhaCungCap], [hinhAnh], [mauSac], [kichThuoc], [soLuong], [maLoaiSanPham], [donGia]) VALUES (N'SP0002', N'Áo polo sọc', N'cái', N'SMSS', NULL, N'MS02', N'KT03', 10, N'LSP002', 300000)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [donVi], [nhaCungCap], [hinhAnh], [mauSac], [kichThuoc], [soLuong], [maLoaiSanPham], [donGia]) VALUES (N'SP0003', N'Áo sơ mi logo rubik', N'cái', N'AM', N'', N'MS04', N'KT03', 20, N'LSP002', 400000)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [donVi], [nhaCungCap], [hinhAnh], [mauSac], [kichThuoc], [soLuong], [maLoaiSanPham], [donGia]) VALUES (N'SP0004', N'Quần thun túi ống', N'quần', N'AM', N'', N'MS01', N'KT01', 0, N'LSP001', 280000)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [donVi], [nhaCungCap], [hinhAnh], [mauSac], [kichThuoc], [soLuong], [maLoaiSanPham], [donGia]) VALUES (N'SP0005', N'Quần tây', N'cái', N'', N'', N'MS02', N'KT02', 0, N'LSP001', 400000)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [donVi], [nhaCungCap], [hinhAnh], [mauSac], [kichThuoc], [soLuong], [maLoaiSanPham], [donGia]) VALUES (N'SP0006', N'Áo len lông cừu', N'cái', N'', N'', N'MS01', N'KT01', 0, N'LSP002', 800000)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [donVi], [nhaCungCap], [hinhAnh], [mauSac], [kichThuoc], [soLuong], [maLoaiSanPham], [donGia]) VALUES (N'SP0007', N'Áo khoác da bò', N'quần', N'', N'', N'MS01', N'KT01', 0, N'LSP001', 500000)
GO
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maNhanVien], [tenTaiKhoan], [matKhau], [email], [quyenHan]) VALUES (N'TK0001', N'NV0001', N'nv0001', N'12345678', NULL, N'quan ly')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maNhanVien], [tenTaiKhoan], [matKhau], [email], [quyenHan]) VALUES (N'TK0002', N'NV0002', N'nv0002', N'12345678', N'', N'nhan vien')
INSERT [dbo].[TaiKhoan] ([maTaiKhoan], [maNhanVien], [tenTaiKhoan], [matKhau], [email], [quyenHan]) VALUES (N'TK0003', N'NV0004', N'nv0004', N'12345678', N'chibaotruongds@gmail.com', N'quan ly')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CTHDHD] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_CTHDHD]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CTHDSP] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_CTHDSP]
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai]  WITH CHECK ADD  CONSTRAINT [FK_maCTKMKM] FOREIGN KEY([maKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([maKhuyenMai])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai] CHECK CONSTRAINT [FK_maCTKMKM]
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai]  WITH CHECK ADD  CONSTRAINT [FK_maCTKMSP] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietKhuyenMai] CHECK CONSTRAINT [FK_maCTKMSP]
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK_CTDHHD] FOREIGN KEY([maPhieuDatHang])
REFERENCES [dbo].[PhieuDatHang] ([maPhieuDatHang])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang] CHECK CONSTRAINT [FK_CTDHHD]
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK_CTDHSP] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang] CHECK CONSTRAINT [FK_CTDHSP]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_CTPNPN] FOREIGN KEY([maPhieuNhap])
REFERENCES [dbo].[PhieuNhap] ([maPhieuNhap])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_CTPNPN]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_CTPNSP] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_CTPNSP]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([khachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([nguoiLap])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([maLoaiNhanVien])
REFERENCES [dbo].[LoaiNhanVien] ([maLoaiNhanVien])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NVCaLam] FOREIGN KEY([caLam])
REFERENCES [dbo].[CaLam] ([maCaLam])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NVCaLam]
GO
ALTER TABLE [dbo].[PhieuDatHang]  WITH CHECK ADD FOREIGN KEY([khachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[PhieuDatHang]  WITH CHECK ADD FOREIGN KEY([nguoiLap])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD FOREIGN KEY([nguoiLap])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([kichThuoc])
REFERENCES [dbo].[KichThuoc] ([maKichThuoc])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([maLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([mauSac])
REFERENCES [dbo].[MauSac] ([maMauSac])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [qlBanHangQuanAo] SET  READ_WRITE 
GO
