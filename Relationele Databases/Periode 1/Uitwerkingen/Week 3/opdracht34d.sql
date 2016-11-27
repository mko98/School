5CREATE TABLE `Docent` (
	`Docentcode` VARCHAR(20) PRIMARY KEY,
	`Naam` VARCHAR(20)
);

CREATE TABLE `Rooster` (
	`LesCode` VARCHAR(10),
	`Datum` DATE,
	`Tijd` INT,
	`Lokaal` VARCHAR(10),
	`AantalStudenten` INT,
	`Betrokkene` VARCHAR(20) NOT NULL,

	PRIMARY KEY(LesCode, Datum, Tijd, Lokaal),

	CONSTRAINT `RoosterFK`
		FOREIGN KEY (`Betrokkene`)
		REFERENCES `Docent` (`Docentcode`)
			ON UPDATE CASCADE
			ON DELETE CASCADE
);

INSERT INTO `Docent` VALUES ('SPIJ', 'Spijkerman');
INSERT INTO `Rooster` (`LesCode`, `Datum`, `Tijd`, `Lokaal`, `Betrokkene`) VALUES ('Datap', '2016-11-25', '1035', 'LA102', 'SPIJ');

INSERT INTO `Docent` VALUES ('JAPS', 'Japsman');
UPDATE `Rooster` SET `Betrokkene` = 'JAPS' WHERE `Betrokkene` = 'SPIJ';
UPDATE `Rooster` SET `AantalStudenten` = 24;
DELETE FROM `Rooster` WHERE `Betrokkene` = 'JAPS'