-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 19, 2016 at 02:09 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `duo_1`
--



-- --------------------------------------------------------

--
-- Table structure for table `band_artiest`
--

CREATE TABLE `band_artiest` (
  `Sleutel` int(11) NOT NULL,
  `Naam` varchar(10) DEFAULT NULL,
  `Beschrijving` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `band_artiest`
--

INSERT INTO `band_artiest` (`Sleutel`, `Naam`, `Beschrijving`) VALUES
(1, 'A', 'AA'),
(2, 'B', 'BB'),
(3, 'C', 'CC'),
(4, 'D', 'DD');

-- --------------------------------------------------------

--
-- Table structure for table `optreden`
--

CREATE TABLE `optreden` (
  `Sleutel` int(11) NOT NULL,
  `Podium` varchar(10) DEFAULT NULL,
  `Starttijd` time DEFAULT NULL,
  `Eindtijd` time DEFAULT NULL,
  `Band_Artiest` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `optreden`
--

INSERT INTO `optreden` (`Sleutel`, `Podium`, `Starttijd`, `Eindtijd`, `Band_Artiest`) VALUES
(1, 'P1', '20:00:00', '22:00:00', 4),
(2, 'P2', '10:00:00', '16:00:00', 3),
(3, 'P3', '20:00:00', '23:00:00', 2),
(4, 'P4', '12:00:00', '16:00:00', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `band_artiest`
--
ALTER TABLE `band_artiest`
  ADD PRIMARY KEY (`Sleutel`);

--
-- Indexes for table `optreden`
--
ALTER TABLE `optreden`
  ADD PRIMARY KEY (`Sleutel`),
  ADD KEY `Band_Artiest` (`Band_Artiest`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `optreden`
--
ALTER TABLE `optreden`
  ADD CONSTRAINT `optreden_ibfk_1` FOREIGN KEY (`Band_Artiest`) REFERENCES `band_artiest` (`Sleutel`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
