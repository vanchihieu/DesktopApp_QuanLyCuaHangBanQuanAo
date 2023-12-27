-- TẠO DATABASE
CREATE DATABASE PTUD_QuanLyCuaHangQuanAo
GO

-- SỬ DỤNG DATABASE
USE PTUD_QuanLyCuaHangQuanAo
GO

create table LoaiSanPham
(
maLoaiSanPham varchar(6) not null primary key,
tenLoaiSanPham nvarchar(70) not null
)
create table SanPham
(
maSanPham varchar(6) not null primary key,
tenSanPham nvarchar(60) not null,
donVi nvarchar(20) not null,
nhaCungCap nvarchar(60) null,
hinhAnh nvarchar(255) null,
mauSac nvarchar(20) not null,
kichThuoc varchar(4) not null,
soLuong int null,
maLoaiSanPham varchar(6) not null foreign key references LoaiSanPham(maLoaiSanPham)
)
create table KhuyenMai
(
maKhuyenMai varchar(6) not null primary key,
tenKhuyenMai nvarchar(255) not null,
ngayBatDau date not null,
ngayKetThuc date not null
)
create table ChiTietKhuyenMai
(
maKhuyenMai varchar(6) not null,
maSanPham varchar(6) not null,
phanTramKhuyenMai float,
primary key(maKhuyenMai,maSanPham)
)
alter table ChiTietKhuyenMai
add constraint FK_maCTKMKM foreign key (maKhuyenMai) references KhuyenMai(maKhuyenMai)

alter table ChiTietKhuyenMai
add constraint FK_maCTKMSP foreign key (maSanPham) references SanPham(maSanPham)

create table LoaiNhanVien
(
maLoaiNhanVien varchar(6) not null primary key,
tenLoaiNhanVien nvarchar(30) not null
)
create table NhanVien
(
maNhanVien varchar(6) not null primary key,
tenNhanVien nvarchar(50) not null,
ngaySinh date null,
gioiTinh varchar(6) not null,
diaChi nvarchar(255) null,
soDienThoai varchar(10) not null,
quanLy varchar(6) null,
maLoaiNhanVien varchar(6) not null foreign key references LoaiNhanVien(maLoaiNhanVien)
)
create table TaiKhoan
(
maTaiKhoan varchar(6) not null primary key,
maNhanVien varchar(6) not null foreign key references NhanVien(maNhanVien) on delete cascade,
tenTaiKhoan varchar(20) not null,
matKhau varchar(20) not null,
email varchar(50) null,
quyenHan varchar(10) null
)
create table KhachHang
(
maKhachHang varchar(6) not null primary key,
tenKhachHang nvarchar(50) not null,
gioiTinh varchar(6) not null,
diaChi nvarchar(255) null,
soDienThoai varchar(10) not null,
email varchar(50) null
)
create table HoaDon
(
maHoaDon varchar(6) not null primary key,
ngayLap date not null,
nguoiLap varchar(6) not null foreign key references NhanVien(maNhanVien),
khachHang varchar(6) not null foreign key references KhachHang(maKhachHang),
tinhTrang nvarchar(20) not null
)
create table ChiTietHoaDon
(
maHoaDon varchar(6) not null,
maSanPham varchar(6) not null,
soLuong int not null,
primary key(maHoaDon,maSanPham)
)

alter table ChiTietHoaDon
add constraint FK_CTHDHD foreign key(maHoaDon) references HoaDon(maHoaDon) on delete cascade

alter table ChiTietHoaDon
add constraint FK_CTHDSP foreign key(maSanPham) references SanPham(maSanPham)

create table PhieuNhap
(
maPhieuNhap varchar(6) not null primary key,
ngayLap date not null,
nguoiLap varchar(6) not null foreign key references NhanVien(maNhanVien),
nhaCungCap nvarchar(60) null
)
create table ChiTietPhieuNhap
(
maPhieuNhap varchar(6) not null,
maSanPham varchar(6) not null,
soLuong int not null,
primary key(maPhieuNhap,maSanPham)
)
alter table ChiTietPhieuNhap
add constraint FK_CTPNPN foreign key(maPhieuNhap) references PhieuNhap(maPhieuNhap) on delete cascade

alter table ChiTietPhieuNhap
add constraint FK_CTPNSP foreign key(maSanPham) references SanPham(maSanPham)