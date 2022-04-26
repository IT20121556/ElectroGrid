-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2022 at 07:38 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `electricitypower`
--

-- --------------------------------------------------------

--
-- Table structure for table `customermanage`
--

CREATE TABLE IF NOT EXISTS `customermanage` (
  `cusID` int(6) NOT NULL AUTO_INCREMENT,
  `cusName` varchar(200) NOT NULL,
  `cusAddress` varchar(200) NOT NULL,
  `cusNIC` varchar(200) NOT NULL,
  `cusEmail` varchar(200) NOT NULL,
  `cusPno` varchar(200) NOT NULL,
  PRIMARY KEY (`cusID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `empmanage`
--

CREATE TABLE IF NOT EXISTS `empmanage` (
  `empID` int(6) NOT NULL AUTO_INCREMENT,
  `empName` varchar(200) NOT NULL,
  `empAddress` varchar(200) NOT NULL,
  `empNIC` varchar(200) NOT NULL,
  `empDOB` varchar(200) NOT NULL,
  `empContact` varchar(200) NOT NULL,
  PRIMARY KEY (`empID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `paymanage`
--

CREATE TABLE IF NOT EXISTS `paymanage` (
  `pID` int(6) NOT NULL AUTO_INCREMENT,
  `pAccNo` varchar(200) NOT NULL,
  `pCus` varchar(200) NOT NULL,
  `pDate` varchar(200) NOT NULL,
  `pAmount` varchar(200) NOT NULL,
  PRIMARY KEY (`pID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `powermanage`
--

CREATE TABLE IF NOT EXISTS `powermanage` (
  `pdID` int(6) NOT NULL AUTO_INCREMENT,
  `pdCusName` varchar(200) NOT NULL,
  `pdAccNo` varchar(200) NOT NULL,
  `psUnit` varchar(200) NOT NULL,
  `pdDate` varchar(200) NOT NULL,
  `pdPay` varchar(200) NOT NULL,
  PRIMARY KEY (`pdID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
