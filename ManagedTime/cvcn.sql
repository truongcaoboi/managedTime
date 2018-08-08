-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 08, 2018 lúc 10:59 AM
-- Phiên bản máy phục vụ: 10.1.31-MariaDB
-- Phiên bản PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cvcn`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `username`, `password`) VALUES
('user', 'truong', 'Password');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `congviec`
--

CREATE TABLE `congviec` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `title` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `content` varchar(2000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `level` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sequence` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `email`
--

CREATE TABLE `email` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `email`
--

INSERT INTO `email` (`id`, `user`, `email`, `type`) VALUES
('0dSTXRCDEf', 'KTy512CNnN', 'fsaf', 'moi'),
('eaLjs3sks6', 'gvdUCsp1Oc', 'dfa', 'moi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ghichu`
--

CREATE TABLE `ghichu` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_exe` date DEFAULT NULL,
  `content` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `grouphuman`
--

CREATE TABLE `grouphuman` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `grouphuman`
--

INSERT INTO `grouphuman` (`id`, `name`) VALUES
(0, 'Bạn bè'),
(1, 'Gia đình'),
(2, 'Cơ quan'),
(3, 'Khách hàng'),
(4, 'Không');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `humans`
--

CREATE TABLE `humans` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `job` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `company` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `birth` date NOT NULL,
  `gender` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `groupHumans` int(11) NOT NULL,
  `nickname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `iden_no` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `humans`
--

INSERT INTO `humans` (`id`, `name`, `address`, `job`, `company`, `birth`, `gender`, `groupHumans`, `nickname`, `iden_no`) VALUES
('201514018', 'fsdfadsfa', 'fds', 'fds', 'fds', '2020-02-02', 'nam', 0, 'fasfadsfa', ''),
('gvdUCsp1Oc', 'fsaaf', 'fadf', 'fafd', 'adfa', '2018-08-22', 'Không', 4, 'ádfa', '0'),
('KTy512CNnN', 'dang thi tham', 'Ha Noi', 'hoc sinh', 'Yen Vien', '2018-08-30', 'Không', 4, 'hao hoa', '0'),
('STfyt8gPwq', 'fsfs', 'fsfd', 'fsfd', 'fsdfs', '2020-08-13', 'Không', 4, 'fsf', ''),
('user', 'dang Xuan truong', 'ha noi', 'sinhvien', 'bach khoa', '2018-08-08', 'Nam', 0, 'TDZZ', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phone`
--

CREATE TABLE `phone` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phone`
--

INSERT INTO `phone` (`id`, `user`, `phone`, `type`) VALUES
('GlV6Rjc6jd', 'gvdUCsp1Oc', 'fadfa', 'moi'),
('ZmKtK11crs', 'KTy512CNnN', 'fsafa', 'moi');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `congviec`
--
ALTER TABLE `congviec`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`id`),
  ADD KEY `email_fk` (`user`);

--
-- Chỉ mục cho bảng `ghichu`
--
ALTER TABLE `ghichu`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `grouphuman`
--
ALTER TABLE `grouphuman`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `humans`
--
ALTER TABLE `humans`
  ADD PRIMARY KEY (`id`),
  ADD KEY `humans_fk` (`groupHumans`);

--
-- Chỉ mục cho bảng `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `phone_fk` (`user`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `email`
--
ALTER TABLE `email`
  ADD CONSTRAINT `email_fk` FOREIGN KEY (`user`) REFERENCES `humans` (`id`);

--
-- Các ràng buộc cho bảng `humans`
--
ALTER TABLE `humans`
  ADD CONSTRAINT `humans_fk` FOREIGN KEY (`groupHumans`) REFERENCES `grouphuman` (`id`);

--
-- Các ràng buộc cho bảng `phone`
--
ALTER TABLE `phone`
  ADD CONSTRAINT `phone_fk` FOREIGN KEY (`user`) REFERENCES `humans` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
