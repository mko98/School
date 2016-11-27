-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 15 sep 2016 om 14:17
-- Serverversie: 10.1.13-MariaDB
-- PHP-versie: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lezensvreugd`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `boek`
--

CREATE TABLE `boek` (
  `ISBN` int(15) NOT NULL,
  `Titel` varchar(20) DEFAULT NULL,
  `Auteur` varchar(15) DEFAULT NULL,
  `Editie` int(3) DEFAULT NULL
    `Lidnr` int(8) NOT NULL,
  
  FOREIGN KEY (`Lidnr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `boek`
--

INSERT INTO `boek` (`ISBN`, `Titel`, `Auteur`, `Editie`) VALUES
(1, 'Dolfje Weerwolfje', 'Sjon de Mol', 1),
(2, 'Geen genade', 'Andy van der meijde', 3),
(3, 'Harry Potter', 'J.K. Rowling', 2),
(4, 'HAY', 'F.J. Modder', 5),
(5, 'Huidpijn', 'Pauw Witteman', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `dvd`
--

CREATE TABLE `dvd` (
  `Titel` varchar(20) DEFAULT NULL,
  `Regisseur` varchar(20) DEFAULT NULL,
  `Label` varchar(20) DEFAULT NULL,
  `Streepjescode` int(15) NOT NULL
    `Lidnr` int(8) NOT NULL,
  
  FOREIGN KEY (`Lidnr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `dvd`
--

INSERT INTO `dvd` (`Titel`, `Regisseur`, `Label`, `Streepjescode`) VALUES
('Dolfje Weerwolfje', 'Spielberg', 'W.B.', 1),
('Cabin in the woods', 'Lucas', 'Universal', 2),
('SUicide Squad', 'Tarantino', 'FOX', 3),
('Conjuring', 'Spielberg', 'Disney', 4),
('Apocalypse', 'Verhoeven', 'Dutch', 5);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `geleend`
--

CREATE TABLE `geleend` (
  `Lidnr` int(8) DEFAULT NULL,
  `ISBN` int(15) DEFAULT NULL,
  `Streepjescode` int(15) DEFAULT NULL,
  `Uitleendatum` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `geleend`
--

INSERT INTO `geleend` (`Lidnr`, `ISBN`, `Streepjescode`, `Uitleendatum`) VALUES
(1, 2, NULL, '2016-09-11'),
(1, NULL, 3, '2016-09-03'),
(2, 4, NULL, '2016-09-10'),
(3, 4, NULL, '2016-09-21');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `lid`
--

CREATE TABLE `lid` (
  `Lidnr` int(8) NOT NULL,
  `Naam` varchar(20) DEFAULT NULL,
  `Straat` varchar(30) DEFAULT NULL,
  `Huisnummer` varchar(6) DEFAULT NULL,
  `Plaats` varchar(20) DEFAULT NULL,
  `Geboortedatum` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `lid`
--

INSERT INTO `lid` (`Lidnr`, `Naam`, `Straat`, `Huisnummer`, `Plaats`, `Geboortedatum`) VALUES
(1, 'Jan Jaap', 'Straatje', '1', 'Uitwijk', NULL),
(2, 'Pieter Piet', 'Weggetje', '14', 'Woudrichem', NULL),
(3, 'Henk Henkus', 'Steegje', '235', 'Rijswijk', NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `reververing`
--

CREATE TABLE `reververing` (
  `Lidnr` int(8) DEFAULT NULL,
  `ISBN` int(15) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Aantal` int(1) DEFAULT NULL
  `Lidnr` int(8) NOT NULL,
  
  FOREIGN KEY (`Lidnr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `boek`
--
ALTER TABLE `boek`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexen voor tabel `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`Streepjescode`);

--
-- Indexen voor tabel `lid`
--
ALTER TABLE `lid`
  ADD PRIMARY KEY (`Lidnr`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
