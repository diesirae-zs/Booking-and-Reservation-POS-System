-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 19, 2026 at 01:53 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbforct`
--

-- --------------------------------------------------------

--
-- Table structure for table `acctable`
--

CREATE TABLE `acctable` (
  `signinidDB` varchar(500) NOT NULL,
  `usernameDB` text NOT NULL,
  `passwordDB` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `acctableadmin`
--

CREATE TABLE `acctableadmin` (
  `signinidDB` varchar(500) NOT NULL,
  `usernameDB` varchar(20) NOT NULL,
  `passwordDB` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `acctableadmin`
--

INSERT INTO `acctableadmin` (`signinidDB`, `usernameDB`, `passwordDB`) VALUES
('299', 'spiderman', 'password12345');

-- --------------------------------------------------------

--
-- Table structure for table `dbstylistadmin`
--

CREATE TABLE `dbstylistadmin` (
  `idDB` varchar(251) NOT NULL,
  `stylistDB` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dbstylistadmin`
--

INSERT INTO `dbstylistadmin` (`idDB`, `stylistDB`) VALUES
('0', 'Creative Director'),
('2', 'Junior Stylist'),
('1', 'Senior Stylist');

-- --------------------------------------------------------

--
-- Table structure for table `dbtable`
--

CREATE TABLE `dbtable` (
  `idDB` longtext NOT NULL,
  `clientDB` varchar(64) NOT NULL,
  `tosDB` varchar(64) NOT NULL,
  `serviceDB` varchar(64) NOT NULL,
  `catDB` varchar(64) NOT NULL,
  `schedDB` varchar(64) NOT NULL,
  `amountDB` double NOT NULL,
  `stylistDB` varchar(251) NOT NULL,
  `contactDB` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dbtable2`
--

CREATE TABLE `dbtable2` (
  `idDB` longtext NOT NULL,
  `clientDB` varchar(251) NOT NULL,
  `tosDB` varchar(251) NOT NULL,
  `serviceDB` varchar(251) NOT NULL,
  `catDB` varchar(251) NOT NULL,
  `schedDB` varchar(251) NOT NULL,
  `amountDB` varchar(251) NOT NULL,
  `stylistDB` varchar(251) NOT NULL,
  `contactDB` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acctable`
--
ALTER TABLE `acctable`
  ADD UNIQUE KEY `signinidDB` (`signinidDB`),
  ADD UNIQUE KEY `user` (`usernameDB`) USING HASH;

--
-- Indexes for table `acctableadmin`
--
ALTER TABLE `acctableadmin`
  ADD UNIQUE KEY `username` (`usernameDB`),
  ADD UNIQUE KEY `signinidDB` (`signinidDB`);

--
-- Indexes for table `dbstylistadmin`
--
ALTER TABLE `dbstylistadmin`
  ADD UNIQUE KEY `stylistDB` (`stylistDB`);

--
-- Indexes for table `dbtable`
--
ALTER TABLE `dbtable`
  ADD UNIQUE KEY `idDB` (`idDB`) USING HASH;

--
-- Indexes for table `dbtable2`
--
ALTER TABLE `dbtable2`
  ADD KEY `idDB` (`idDB`(768));
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
