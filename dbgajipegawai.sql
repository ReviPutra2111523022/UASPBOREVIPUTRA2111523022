-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2022 at 11:51 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbgajipegawai`
--

-- --------------------------------------------------------

--
-- Table structure for table `gajipegawai`
--

CREATE TABLE `gajipegawai` (
  `nopegawai` int(20) NOT NULL,
  `namapegawai` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `totalgaji` int(50) NOT NULL,
  `gajipokok` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gajipegawai`
--

INSERT INTO `gajipegawai` (`nopegawai`, `namapegawai`, `jabatan`, `totalgaji`, `gajipokok`) VALUES
(123, 'REPQ', '4', 6000000, 6000000),
(12365, 'PUTRA', '2', 10000000, 10000000),
(12213, 'AHMAD', '4', 6000000, 6000000),
(1928374, 'DIMAS', '4', 6000000, 6000000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
