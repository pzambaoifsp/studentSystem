DROP DATABASE IF EXISTS `student_system`;
CREATE DATABASE `student_system`;
USE `student_system`;

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `idCourse` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  `semester` INT DEFAULT NULL,
  `idUser` VARCHAR(100) DEFAULT NULL,
  KEY (`idCourse`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `disciplines`;
CREATE TABLE `disciplines` (
	`idDiscipline` INT NOT NULL AUTO_INCREMENT,
  `idCourse` INT NOT NULL,
  `name` VARCHAR(100) DEFAULT NULL,
  `idUser` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`idDiscipline`),
  KEY `idCourse` (`idCourse`),
  FOREIGN KEY (`idCourse`) REFERENCES `courses` (`idCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades` (
  `idGrade` INT NOT NULL AUTO_INCREMENT,
  `idCourse` INT NOT NULL,
  `name` VARCHAR(100) DEFAULT NULL,
  `grade` float DEFAULT NULL,
  `idUser` VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (`idGrade`),
  KEY `idCourse` (`idCourse`),
  FOREIGN KEY (`idCourse`) REFERENCES `courses` (`idCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `frequences`;
CREATE TABLE `frequences` (
	`idFrequence` INT NOT NULL AUTO_INCREMENT,
	`idDiscipline` INT NOT NULL,
  `date` DATE NOT NULL,
  `presence` BOOLEAN,
  `idUser` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`idFrequence`),
  KEY `idDiscipline` (`idDiscipline`),
	FOREIGN KEY (`idDiscipline`) REFERENCES `disciplines` (`idDiscipline`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;