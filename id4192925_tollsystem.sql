-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 07, 2018 at 03:45 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id4192925_tollsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `User_id` int(11) NOT NULL,
  `Reg_id` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`User_id`, `Reg_id`, `Password`) VALUES
(1, 'KA09CV1234', 'password'),
(2, 'MP09BV78', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `paymentdetails`
--

CREATE TABLE `paymentdetails` (
  `regno` varchar(50) DEFAULT NULL,
  `Lastpaid` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentdetails`
--

INSERT INTO `paymentdetails` (`regno`, `Lastpaid`) VALUES
('KA09CV1234', '2018-01-07 03:32:40');

-- --------------------------------------------------------

--
-- Table structure for table `ratelist`
--

CREATE TABLE `ratelist` (
  `vid` decimal(20,0) DEFAULT NULL,
  `tollid` varchar(20) DEFAULT NULL,
  `rate` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ratelist`
--

INSERT INTO `ratelist` (`vid`, `tollid`, `rate`) VALUES
(1, '100', 50),
(1, '101', 60),
(1, '102', 30);

-- --------------------------------------------------------

--
-- Table structure for table `tollhistory`
--

CREATE TABLE `tollhistory` (
  `seqno` int(255) NOT NULL DEFAULT '0',
  `regno` varchar(50) DEFAULT NULL,
  `tollid` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tollhistory`
--

INSERT INTO `tollhistory` (`seqno`, `regno`, `tollid`, `date`) VALUES
(0, 'KA09CV1234', '101', '2018-01-06 09:11:18'),
(1, 'KA09CV1234', '100', '2018-01-04 00:00:00'),
(2, 'MP09BV78', '101', '2018-01-04 00:00:00'),
(3, 'KA09CV1234', '102', '2018-01-02 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `regno` varchar(50) NOT NULL DEFAULT '',
  `vtype` varchar(50) DEFAULT NULL,
  `vid` decimal(20,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`regno`, `vtype`, `vid`) VALUES
('KA09CV1234', 'CAR', 1),
('MP09BV78', 'CAR', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`User_id`);

--
-- Indexes for table `tollhistory`
--
ALTER TABLE `tollhistory`
  ADD PRIMARY KEY (`seqno`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`regno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `User_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
