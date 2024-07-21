CREATE DATABASE QLBH_PRO1041;
GO

USE QLBH_PRO1041;
GO
create table Ram (
	id_Ram int identity (1,1) primary key,
	MaRam as ('RM' + RIGHT('00000' + CAST(id_Ram as varchar(6)), 6)) persisted,
	DungLuongRam varchar(20) not null,
	TrangThai bit default 1
);

create table CPU (
	id_CPU int identity (1,1) primary key,
	MaCPU as ('CPU' + RIGHT('00000' + CAST(id_CPU as varchar(6)), 6)) persisted,
	TenCPU varchar(50) not null,
	TrangThai bit default 1
);

create table OCung (
	id_OCung int identity (1,1) primary key,
	MaOCung as ('OC' + RIGHT('00000' + CAST(id_OCung as varchar(6)), 6)) persisted,
	LoaiOCung varchar(30) not null
);


create table GPU (
	id_GPU int identity (1,1) primary key,
	MaGPU as ('GPU' + RIGHT('00000' + CAST(id_GPU as varchar(6)), 6)) persisted,
	TenGPU varchar(50) not null,
	TrangThai bit default 1
);

create table ManHinh (
	id_ManHinh int identity (1,1) primary key,
	MaManHinh as ('MH' + RIGHT('00000' + CAST(id_ManHinh as varchar(6)), 6)) persisted,
	KichThuoc varchar(20) not null,
	TrangThai bit default 1
);

create table Pin (
	id_Pin int identity (1,1) primary key,
	MaPin as ('Pin' + RIGHT('00000' + CAST(id_Pin as varchar(6)), 6)) persisted,
	DungLuongPin varchar(20) not null,
	TrangThai bit default 1 
);

CREATE TABLE SanPham (
    id_SanPham INT IDENTITY(1,1) PRIMARY KEY,
    id_Ram INT NOT NULL,
    id_CPU INT NOT NULL,
    id_GPU INT NOT NULL,
    id_ManHinh INT NOT NULL,
    id_OCung INT NOT NULL,
    id_Pin INT NOT NULL,
    MaSanPham AS ('SP' + RIGHT('00000' + CAST(id_SanPham AS VARCHAR(6)), 6)) PERSISTED,
    TenSanPham NVARCHAR(50) NOT NULL,
    HinhAnh VARCHAR(MAX) NOT NULL,
    SoLuong INT NOT NULL,
    GiaNhap MONEY NOT NULL,
    GiaBan MONEY NOT NULL,
    TrangThai BIT DEFAULT 1,
    FOREIGN KEY (id_Ram) REFERENCES Ram(id_Ram),
    FOREIGN KEY (id_CPU) REFERENCES CPU(id_CPU),
    FOREIGN KEY (id_GPU) REFERENCES GPU(id_GPU),
    FOREIGN KEY (id_ManHinh) REFERENCES ManHinh(id_ManHinh),
    FOREIGN KEY (id_OCung) REFERENCES OCung(id_OCung),
    FOREIGN KEY (id_Pin) REFERENCES Pin(id_Pin)
);

CREATE TABLE KhachHang (
    id_KhachHang INT IDENTITY(1,1) PRIMARY KEY,
    MaKhachHang AS ('KH' + RIGHT('00000' + CAST(id_KhachHang AS VARCHAR(6)), 6)) PERSISTED,
    HoTen NVARCHAR(50) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh BIT,
    SDT CHAR(10) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    DiaChi NVARCHAR(MAX) NOT NULL,
    TrangThai BIT DEFAULT 1
);

CREATE TABLE NhanVien (
    id_NhanVien INT IDENTITY(1,1) PRIMARY KEY,
    MaNhanVien AS ('NV' + RIGHT('00000' + CAST(id_NhanVien AS VARCHAR(6)), 6)) PERSISTED,
    UserName VARCHAR(50) NOT NULL,
    Pass VARCHAR(MAX) NOT NULL,
    HoTen NVARCHAR(50) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh BIT,
    SDT CHAR(10) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    DiaChi VARCHAR(MAX) NOT NULL,
    VaiTro BIT,
    TrangThai BIT DEFAULT 1
);

CREATE TABLE VaiTro (
    id_VaiTro INT IDENTITY(1,1) PRIMARY KEY,
    id_NhanVien INT,
    LoaiVaiTro BIT NOT NULL,
    FOREIGN KEY (id_NhanVien) REFERENCES NhanVien(id_NhanVien)
);

CREATE TABLE Voucher (
    id_Voucher INT IDENTITY(1,1) PRIMARY KEY,
    id_NhanVien INT,
    MaVoucher VARCHAR(50) NOT NULL,
    MoTa NVARCHAR(MAX),
    NgayPhatHanh DATE NOT NULL,
    NgayHetHan DATE NOT NULL,
    SoLuong INT CHECK (SoLuong > 0),
    MucGiaTri MONEY,
    GiaTriToiDa MONEY,
    NgaySuDung DATE NOT NULL,
    TrangThai BIT DEFAULT 1,
    FOREIGN KEY (id_NhanVien) REFERENCES NhanVien(id_NhanVien)
);

CREATE TABLE HoaDon (
    id_HoaDon INT IDENTITY(1,1) PRIMARY KEY,
    id_KhachHang INT,
    id_NhanVien INT,
    id_Voucher INT,
    MaHoaDon AS ('HD' + RIGHT('00000' + CAST(id_HoaDon AS VARCHAR(6)), 6)) PERSISTED,
    NgayThanhToan DATE NOT NULL,
    TongTien MONEY NOT NULL,
    TienVoucher MONEY NOT NULL,
    ThanhTien MONEY,
    PhuongThucThanhToan NVARCHAR(30) NOT NULL,
    GhiChu NVARCHAR(50),
    TrangThai BIT DEFAULT 1,
    FOREIGN KEY (id_KhachHang) REFERENCES KhachHang(id_KhachHang),
    FOREIGN KEY (id_NhanVien) REFERENCES NhanVien(id_NhanVien),
    FOREIGN KEY (id_Voucher) REFERENCES Voucher(id_Voucher)
);

CREATE TABLE HoaDonChiTiet (
    id_HDCT INT IDENTITY(1,1) PRIMARY KEY,
    id_HoaDon INT,
    id_SanPham INT,
    SoLuong INT CHECK (SoLuong > 0),
    DonGia MONEY NOT NULL,
    TongTien MONEY NOT NULL,
    TrangThai BIT DEFAULT 1,
    FOREIGN KEY (id_SanPham) REFERENCES SanPham(id_SanPham),
    FOREIGN KEY (id_HoaDon) REFERENCES HoaDon(id_HoaDon)
);

CREATE TABLE Imei (
    id_Imei INT IDENTITY(1,1) PRIMARY KEY,
    id_SanPham INT NOT NULL,
    Ma_Imei VARCHAR(50) NOT NULL,
    TrangThai BIT DEFAULT 1,
    FOREIGN KEY (id_SanPham) REFERENCES SanPham(id_SanPham)
);

CREATE TABLE ImeiDaBan (
    id_ImeiDaBan INT IDENTITY(1,1) PRIMARY KEY,
    id_HDCT INT,
    Ma_Imei VARCHAR(50) NOT NULL,
    TrangThai BIT DEFAULT 1,
    FOREIGN KEY (id_HDCT) REFERENCES HoaDonChiTiet(id_HDCT)
);
GO

INSERT INTO Ram (DungLuongRam) VALUES ('8GB'), ('16GB'), ('32GB'), ('64GB');
INSERT INTO CPU (TenCPU) VALUES ('Intel Core i5'), ('Intel Core i7'), ('AMD Ryzen 5'), ('AMD Ryzen 7');
INSERT INTO OCung (LoaiOCung) VALUES ('SSD256GB'), ('SSD512GB'), ('HDD1TB'), ('HDD2TB');
INSERT INTO GPU (TenGPU) VALUES ('NVIDIA GTX 1660'), ('NVIDIA RTX 3060'), ('AMD Radeon RX 5700'), ('AMD Radeon RX 6800');
INSERT INTO ManHinh (KichThuoc) VALUES ('13.3 inch'), ('15.6 inch'), ('17.3 inch'), ('14 inch');
INSERT INTO Pin (DungLuongPin) VALUES ('75 Wh'), ('60 Wh'), ('65 Wh'), ('70 Wh');

INSERT INTO SanPham (id_Ram, id_CPU, id_GPU, id_ManHinh, id_OCung, id_Pin, TenSanPham, HinhAnh, SoLuong, GiaNhap, GiaBan)
VALUES 
(1, 1, 1, 1, 1, 1, N'Lenovo Legion 2023', 'hinh1.jpg', 10, 11500000, 15000000),
(2, 2, 2, 2, 2, 2, N'Lenovo Ideapad 5', 'hinh2.jpg', 20, 13800000, 18000000),
(3, 3, 3, 3, 3, 3, N'Lenovo Thinkpad x13', 'hinh3.jpg', 15, 16100000, 21000000),
(4, 4, 4, 4, 4, 4, N'Lenovo LOQ 2023', 'hinh4.jpg', 5, 18400000, 24000000);

INSERT INTO KhachHang (HoTen, NgaySinh, GioiTinh, SDT, Email, DiaChi) 
VALUES 
(N'Nguyễn Văn Lực', '1985-05-10', 1, '0912345678', 'a@gmail.com', N'123 Đường A'),
(N'Trần Thị Sương', '1990-08-15', 0, '0987654321', 'b@yahoo.com', N'456 Đường B'),
(N'Lê Văn Sướng', '1992-09-20', 1, '0901234567', 'c@hotmail.com', N'789 Đường C'),
(N'Phạm Thị Thu Hương', '1988-12-25', 0, '0934567890', 'd@outlook.com', N'101 Đường D');
INSERT INTO NhanVien (UserName, Pass, HoTen, NgaySinh, GioiTinh, SDT, Email, DiaChi, VaiTro) 
VALUES 
('user1', 'password1', N'Lê Quang Hải', '1980-01-01', 1, '0911222333', 'h@example.com', N'100 Đường H', 0),
('user2', 'password2', N'Nguyễn Thị Vy', '1985-02-02', 0, '0922333444', 'k@example.com', N'200 Đường K', 1),
('user3', 'password3', N'Phạm Văn Minh', '1990-03-03', 1, '0933444555', 'm@example.com', N'300 Đường M', 0),
('user4', 'password4', N'Trần Thị Tuyết', '1995-04-04', 0, '0944555666', 'n@example.com', N'400 Đường N', 1);

INSERT INTO VaiTro (id_NhanVien, LoaiVaiTro) 
VALUES 
(1, 0), -- NhanVien with id 1 is a nhân viên
(2, 1), -- NhanVien with id 2 is an admin
(3, 0), -- NhanVien with id 3 is a nhân viên
(4, 1); -- NhanVien with id 4 is an admin

INSERT INTO Voucher (id_NhanVien, MaVoucher, MoTa, NgayPhatHanh, NgayHetHan, SoLuong, MucGiaTri, GiaTriToiDa, NgaySuDung)
VALUES 
(1, 'VOUCHER100', N'Giảm giá 100K', '2024-01-01', '2024-12-31', 50, 100000, NULL, '2024-01-02'),
(2, 'VOUCHER200', N'Giảm giá 200K', '2024-01-01', '2024-12-31', 30, 200000, NULL, '2024-01-02'),
(3, 'VOUCHER300', N'Giảm giá 300K', '2024-01-01', '2024-12-31', 20, 300000, NULL, '2024-01-02'),
(4, 'VOUCHER400', N'Giảm giá 400K', '2024-01-01', '2024-12-31', 10, 400000, NULL, '2024-01-02');

INSERT INTO HoaDon (id_KhachHang, id_NhanVien, id_Voucher, NgayThanhToan, TongTien, TienVoucher, ThanhTien, PhuongThucThanhToan, GhiChu)
VALUES 
(1, 1, 1, '2024-02-01', 15000000, 100000, 14900000, N'Thẻ tín dụng', N'Thanh toán đầy đủ'),
(2, 2, 2, '2024-02-02', 18000000, 200000, 17800000, N'Tiền mặt', N'Thanh toán đầy đủ'),
(3, 3, 3, '2024-02-03', 21000000, 300000, 20700000, N'Thẻ tín dụng', N'Thanh toán đầy đủ'),
(4, 4, 4, '2024-02-04', 24000000, 400000, 23600000, N'Tiền mặt', N'Thanh toán đầy đủ');

INSERT INTO HoaDonChiTiet (id_HoaDon, id_SanPham, SoLuong, DonGia, TongTien)
VALUES 
(1, 1, 1, 15000000, 15000000),
(2, 2, 1, 18000000, 18000000),
(3, 3, 1, 21000000, 21000000),
(4, 4, 1, 24000000, 24000000);

INSERT INTO Imei (id_SanPham, Ma_Imei) 
VALUES 
(1, '1234567890'), 
(2, '2345678901'), 
(3, '3456789012'), 
(4, '4567890123');

INSERT INTO ImeiDaBan (id_HDCT, Ma_Imei) 
VALUES 
(1, '1234567890'), 
(2, '2345678901'), 
(3, '3456789012'), 
(4, '4567890123');

select * from CPU
select * from GPU
select * from Ram
select * from ManHinh
select * from Imei
select * from KhachHang
select * from OCung
select * from NhanVien
select * from HoaDon
select * from HoaDonChiTiet
select * from VaiTro
select * from Voucher
select * from SanPham
go
go
	SELECT 
    HoaDon.MaHoaDon as 'MaHoaDon',
    KhachHang.HoTen as 'kh',
    Voucher.MaVoucher as 'MaVoucher',
    NhanVien.HoTen as 'nv',
    FORMAT(HoaDon.NgayThanhToan, 'dd-MM-yyyy') as 'NgayThanhToan',
    HoaDon.TongTien as 'TongTien',
    HoaDon.TienVoucher as 'TienVoucher',
    HoaDon.ThanhTien as 'ThanhTien',
    HoaDon.PhuongThucThanhToan as 'PhuongThuc',
    HoaDon.GhiChu as 'GhiChu'
FROM HoaDon
JOIN KhachHang ON KhachHang.id_KhachHang = HoaDon.id_KhachHang
JOIN Voucher ON Voucher.id_Voucher = HoaDon.id_Voucher
JOIN NhanVien ON NhanVien.id_NhanVien = HoaDon.id_NhanVien
WHERE HoaDon.TrangThai = 1;
GO
Update HoaDon set TrangThai = 0 where MaHoaDon=?
	