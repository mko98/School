-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2016 at 02:51 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ISBN` int(11) NOT NULL,
  `Title` varchar(64) NOT NULL,
  `Author` varchar(32) NOT NULL,
  `Edition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ISBN`, `Title`, `Author`, `Edition`) VALUES
(1011, 'De avonden', 'Gerard van het Reve', 9),
(1014, 'Het boek van violet en dood', 'Gerard Reve', 9),
(1021, 'Ik heb nooit iets gelezen', 'Karel van het Reve', 2),
(1111, 'Het leven is vurrukkulluk', 'Remco Campert', 1),
(2222, 'De Ontdekking van de Hemel', 'Harry Mulisch', 5),
(2223, 'De Aanslag', 'Harry Mulisch', 8),
(3333, 'De Aanslag', 'Belastingdienst', 1),
(4001, 'De geverfde vogel', 'Jerzy Kosinski', 2),
(4003, 'Cockpit', 'Jerzy Kosinski', 1),
(4005, 'Aanwezig', 'Jerzy Kosinski', 4),
(8000, 'Ik, Jan Cremer', 'Jan Cremer', 22),
(8888, 'Ik, Jan Klaassen', 'Herman Finkers', 22);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ISBN`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
