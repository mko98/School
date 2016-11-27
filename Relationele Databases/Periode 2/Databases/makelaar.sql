-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Serverversie: 5.5.25a
-- PHP-versie: 5.4.4
-- Informatica Breda (AE&I)
-- P1.2: Databases

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


--
-- Databank: `makelaar`
--
DROP DATABASE IF EXISTS `makelaar`;
CREATE DATABASE `makelaar`;
use `makelaar`;
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bezoek`
--

CREATE TABLE IF NOT EXISTS `bezoek` (
  `Hs_Huisnummer` int(11) NOT NULL,
  `Hs_Postcode` varchar(6) NOT NULL,
  `Bzkr_Naam` varchar(35) NOT NULL,
  `Bzkr_Telnummer` int(11) NOT NULL,
  `Datum` date NOT NULL,
  `Tijd` varchar(5) NOT NULL,
  PRIMARY KEY (`Hs_Huisnummer`,`Hs_Postcode`,`Bzkr_Naam`,`Bzkr_Telnummer`),
  KEY `Bzkr_Telnummer` (`Bzkr_Telnummer`),
  KEY `Hs_Postcode` (`Hs_Postcode`),
  KEY `Bzkr_Naam` (`Bzkr_Naam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `bezoek`
--

INSERT INTO `bezoek` (`Hs_Huisnummer`, `Hs_Postcode`, `Bzkr_Naam`, `Bzkr_Telnummer`, `Datum`, `Tijd`) VALUES(147, '4847DA', 'Willem Wever', 628641245, '2013-10-07', '10:00');
INSERT INTO `bezoek` (`Hs_Huisnummer`, `Hs_Postcode`, `Bzkr_Naam`, `Bzkr_Telnummer`, `Datum`, `Tijd`) VALUES(147, '4847DA', 'Wilma de Boer', 638641245, '2013-10-08', '10:00');
INSERT INTO `bezoek` (`Hs_Huisnummer`, `Hs_Postcode`, `Bzkr_Naam`, `Bzkr_Telnummer`, `Datum`, `Tijd`) VALUES(147, '4847DA', 'Pieter Klaaswijk', 628641242, '2013-10-09', '10:00');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bezoeker`
--

CREATE TABLE IF NOT EXISTS `bezoeker` (
  `Naam` varchar(35) NOT NULL,
  `Telnummer` int(11) NOT NULL,
  `Interesse` varchar(60) NOT NULL,
  `HbzkrNaam` varchar(35) DEFAULT NULL,
  `HbzkrTelnummer` int(11) DEFAULT NULL,
  PRIMARY KEY (`Naam`,`Telnummer`),
  KEY `Naam` (`Naam`),
  KEY `Telnummer` (`Telnummer`),
  KEY `Naam_2` (`Naam`),
  KEY `Telnummer_2` (`Telnummer`),
  KEY `HbzkrNaam` (`HbzkrNaam`),
  KEY `HbzkrTelnummer` (`HbzkrTelnummer`),
  KEY `Naam_3` (`Naam`),
  KEY `Telnummer_3` (`Telnummer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `bezoeker`
--
INSERT INTO `bezoeker` (`Naam`, `Telnummer`, `Interesse`, `HbzkrNaam`, `HbzkrTelnummer`) VALUES('Willem Wever', 628641245, 'Bungalow', NULL, NULL);
INSERT INTO `bezoeker` (`Naam`, `Telnummer`, `Interesse`, `HbzkrNaam`, `HbzkrTelnummer`) VALUES('Anita Wever', 0, 'Bungalow', 'Willem Wever', 628641245);
INSERT INTO `bezoeker` (`Naam`, `Telnummer`, `Interesse`, `HbzkrNaam`, `HbzkrTelnummer`) VALUES('Femke Wever', 0, 'Bungalow', 'Willem Wever', 628641245);
INSERT INTO `bezoeker` (`Naam`, `Telnummer`, `Interesse`, `HbzkrNaam`, `HbzkrTelnummer`) VALUES('Pieter Klaaswijk', 628641242, 'Woonboot', NULL, NULL);
INSERT INTO `bezoeker` (`Naam`, `Telnummer`, `Interesse`, `HbzkrNaam`, `HbzkrTelnummer`) VALUES('Wilma de Boer', 638641245, 'Appartement', NULL, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `huis`
--

CREATE TABLE IF NOT EXISTS `huis` (
  `StraatNaam` varchar(35) NOT NULL,
  `Huisnummer` int(11) NOT NULL,
  `Postcode` varchar(6) NOT NULL,
  `Plaats` varchar(35) NOT NULL,
  `Bouwjaar` date NOT NULL,
  `Vraagprijs` int(11) NOT NULL,
  `AantalKamers` int(11) NOT NULL,
  `Inhoud` int(11) NOT NULL,
  `BSN` int(11) NOT NULL,
  PRIMARY KEY (`Huisnummer`,`Postcode`),
  KEY `BSN` (`BSN`),
  KEY `BSN_2` (`BSN`),
  KEY `Inhoud` (`Inhoud`),
  KEY `Huisnummer` (`Huisnummer`),
  KEY `Postcode` (`Postcode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `huis`
--

INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Schijfstraat', 147, '4847DA', 'Teteringen', '2011-01-01', 355000, 4, 550, 123456781);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Langelaar', 12, '4847SA', 'Teteringen', '1997-01-01', 420000, 6, 700, 123456782);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Stationstraat', 34, '4847AD', 'Breda', '1990-01-01', 220000, 2, 200, 123456783);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Hoofdstraat', 67, '4847ET', 'Breda', '2012-01-01', 180000, 1, 80, 123456784);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Hoogweg', 6, '1234EW', 'Amsterdam', '1999-01-01', 360000, 4, 600, 123456785);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Cruijf straat', 1, '1234RT', 'Amsterdam', '1980-01-01', 750000, 7, 750, 123456786);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Lange voren', 3, '1234ED', 'Amsterdam', '1965-01-01', 385000, 4, 590, 123456787);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Scheefstraat', 9, '1234AA', 'Amsterdam', '1960-01-01', 290000, 3, 300, 123456788);
INSERT INTO `huis` (`StraatNaam`, `Huisnummer`, `Postcode`, `Plaats`, `Bouwjaar`, `Vraagprijs`, `AantalKamers`, `Inhoud`, `BSN`) VALUES('Schaatsweg', 234, '8888AS', 'Leeuwarden', '1972-01-01', 300000, 5, 525, 123456789);
-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `makelaar`
--

CREATE TABLE IF NOT EXISTS `makelaar` (
  `NaamMakelaardij` varchar(35) NOT NULL,
  `Adres` varchar(35) NOT NULL,
  `Huisnummer` int(11) NOT NULL,
  `Postcode` varchar(6) NOT NULL,
  `Plaats` varchar(35) NOT NULL,
  `NaamMakelaar` varchar(35) NOT NULL,
  PRIMARY KEY (`Huisnummer`,`Postcode`),
  KEY `Huisnummer` (`Huisnummer`),
  KEY `Postcode` (`Postcode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `makelaar`
--

INSERT INTO `makelaar` (`NaamMakelaardij`, `Adres`, `Huisnummer`, `Postcode`, `Plaats`, `NaamMakelaar`) VALUES('Morris Real Estate', 'Strijpenlaan', 13, '4847AV', 'Teteringen', 'Morris Manders');
INSERT INTO `makelaar` (`NaamMakelaardij`, `Adres`, `Huisnummer`, `Postcode`, `Plaats`, `NaamMakelaar`) VALUES('Vastgoed Amsterdam', 'Langelaar', 69, '1234AS', 'Amsterdam', 'Jan Janssen');
INSERT INTO `makelaar` (`NaamMakelaardij`, `Adres`, `Huisnummer`, `Postcode`, `Plaats`, `NaamMakelaar`) VALUES('House for sale', 'Kerkstraat', 20, '3456TY', 'Tilburg', 'Ron Vlaar');
INSERT INTO `makelaar` (`NaamMakelaardij`, `Adres`, `Huisnummer`, `Postcode`, `Plaats`, `NaamMakelaar`) VALUES('De Sleutel', 'Bolderstraat', 120, '4321WE', 'Made', 'Willem Wever');
INSERT INTO `makelaar` (`NaamMakelaardij`, `Adres`, `Huisnummer`, `Postcode`, `Plaats`, `NaamMakelaar`) VALUES('ReMax', 'Kortestraat', 3, '8901ER', 'Groningen', 'Jaap de Groot');
INSERT INTO `makelaar` (`NaamMakelaardij`, `Adres`, `Huisnummer`, `Postcode`, `Plaats`, `NaamMakelaar`) VALUES('NVM', 'Lageweg', 1, '1234RT', 'Leeuwarden', 'Mirjam van Molenschot');


-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `verkoper`
--

CREATE TABLE IF NOT EXISTS `verkoper` (
  `Naam` varchar(35) NOT NULL,
  `Telefoonnummer` int(11) NOT NULL,
  `BSN` int(11) NOT NULL,
  `Mklr_Huisnummer` int(11) NOT NULL,
  `Mklr_Postcode` varchar(6) NOT NULL,
  PRIMARY KEY (`BSN`),
  KEY `Mklr_Huisnummer` (`Mklr_Huisnummer`),
  KEY `Mklr_Postcode` (`Mklr_Postcode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `verkoper`
--

INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Karin Janssen', 628451234, 123456781, 13, '4847AV');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Roy stassen', 628646734, 123456782, 13, '4847AV');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Jeanette de Beer', 621241234, 123456783, 69, '1234AS');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Jan de Groot', 628641784, 123456784, 69, '1234AS');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Henk de Bever', 628321234, 123456785, 69, '1234AS');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Anne-Marie de Wit', 628941234, 123456786, 20, '3456TY');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Jan Til', 628641984, 123456787, 20, '3456TY');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Wil Willink', 628621234, 123456788, 120, '4321WE');
INSERT INTO `verkoper` (`Naam`, `Telefoonnummer`, `BSN`, `Mklr_Huisnummer`, `Mklr_Postcode`) VALUES('Bert in het Veld', 634641234, 123456789, 3, '8901ER');
--
-- Beperkingen voor gedumpte tabellen
--

--
-- Beperkingen voor tabel `bezoek`
--
ALTER TABLE `bezoek`
  ADD CONSTRAINT `bezoek_ibfk_12` FOREIGN KEY (`Bzkr_Telnummer`) REFERENCES `bezoeker` (`Telnummer`),
  ADD CONSTRAINT `bezoek_ibfk_10` FOREIGN KEY (`Hs_Postcode`) REFERENCES `huis` (`Postcode`),
  ADD CONSTRAINT `bezoek_ibfk_11` FOREIGN KEY (`Bzkr_Naam`) REFERENCES `bezoeker` (`Naam`),
  ADD CONSTRAINT `bezoek_ibfk_9` FOREIGN KEY (`Hs_Huisnummer`) REFERENCES `huis` (`Huisnummer`);

--
-- Beperkingen voor tabel `bezoeker`
--
ALTER TABLE `bezoeker`
  ADD CONSTRAINT `bezoeker_ibfk_2` FOREIGN KEY (`HbzkrTelnummer`) REFERENCES `bezoeker` (`Telnummer`),
  ADD CONSTRAINT `bezoeker_ibfk_1` FOREIGN KEY (`HbzkrNaam`) REFERENCES `bezoeker` (`Naam`);

--
-- Beperkingen voor tabel `huis`
--
ALTER TABLE `huis`
  ADD CONSTRAINT `huis_ibfk_1` FOREIGN KEY (`BSN`) REFERENCES `verkoper` (`BSN`);

--
-- Beperkingen voor tabel `verkoper`
--
ALTER TABLE `verkoper`
  ADD CONSTRAINT `verkoper_ibfk_2` FOREIGN KEY (`Mklr_Postcode`) REFERENCES `makelaar` (`Postcode`),
  ADD CONSTRAINT `verkoper_ibfk_1` FOREIGN KEY (`Mklr_Huisnummer`) REFERENCES `makelaar` (`Huisnummer`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
