-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 19 أبريل 2016 الساعة 14:51
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `faculity_table`
--

-- --------------------------------------------------------

--
-- بنية الجدول `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `ClassId` int(11) NOT NULL AUTO_INCREMENT,
  `ClassName` varchar(200) CHARACTER SET utf8 NOT NULL,
  `ClassStudentsNumber` int(6) NOT NULL,
  `ClassType` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ClassSectionsNumber` int(3) NOT NULL,
  PRIMARY KEY (`ClassId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- إرجاع أو استيراد بيانات الجدول `class`
--

INSERT INTO `class` (`ClassId`, `ClassName`, `ClassStudentsNumber`, `ClassType`, `ClassSectionsNumber`) VALUES
(1, 'Class1', 150, 'General', 5),
(2, 'Class2', 100, 'General', 3);

-- --------------------------------------------------------

--
-- بنية الجدول `classcourse`
--

CREATE TABLE IF NOT EXISTS `classcourse` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ClassId` int(11) NOT NULL,
  `CourseId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `ClassCourse_ibfk_1` (`ClassId`),
  KEY `ClassCourse_ibfk_2` (`CourseId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- إرجاع أو استيراد بيانات الجدول `classcourse`
--

INSERT INTO `classcourse` (`Id`, `ClassId`, `CourseId`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(6, 2, 1);

-- --------------------------------------------------------

--
-- بنية الجدول `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `CourseId` int(11) NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(200) CHARACTER SET utf8 NOT NULL,
  `CourseSerial` varchar(50) CHARACTER SET utf8 NOT NULL,
  `MaxCourseSectionNumber` int(3) NOT NULL,
  `GeneralityLab` int(1) NOT NULL,
  PRIMARY KEY (`CourseId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- إرجاع أو استيراد بيانات الجدول `course`
--

INSERT INTO `course` (`CourseId`, `CourseName`, `CourseSerial`, `MaxCourseSectionNumber`, `GeneralityLab`) VALUES
(1, 'Course1', '1', 1, 0),
(2, 'Course2', '2', 1, 1),
(3, 'Course3', '3', 3, 1),
(4, 'Course4', '4', 3, 1),
(5, 'Course5', '5', 1, 1);

-- --------------------------------------------------------

--
-- بنية الجدول `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `DoctorId` int(11) NOT NULL AUTO_INCREMENT,
  `DoctorName` varchar(200) CHARACTER SET utf8 NOT NULL,
  `DoctorPhone` varchar(100) CHARACTER SET utf8 NOT NULL,
  `DoctorStatus` varchar(20) CHARACTER SET utf8 NOT NULL,
  `DoctorMail` varchar(200) CHARACTER SET utf8 NOT NULL,
  `DoctorAvailability` int(11) NOT NULL,
  PRIMARY KEY (`DoctorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- إرجاع أو استيراد بيانات الجدول `doctor`
--

INSERT INTO `doctor` (`DoctorId`, `DoctorName`, `DoctorPhone`, `DoctorStatus`, `DoctorMail`, `DoctorAvailability`) VALUES
(1, 'Doctor1', '0100', 'Doctor', '@yahoo.com', 1),
(2, 'Doctor2', '0100', 'Doctor', '@yahoo.com', 1),
(3, 'Doctor3', '0100', 'Doctor', '@yahoo.com', 0),
(4, 'Demonstator1', '011', 'Demonstrator', '@gmail.com', 1),
(5, 'Demonstator2', '011', 'Demonstrator', '@gmail.com', 1),
(6, 'Demonstator3', '011', 'Demonstrator', '@gmail.com', 1),
(7, 'Demonstator4', '011', 'Demonstrator', '@gmail.com', 1),
(8, 'Demonstator5', '011', 'Demonstrator', '@gmail.com', 1),
(9, 'Demonstator6', '011', 'Demonstrator', '@gmail.com', 1),
(10, 'Demonstator7', '011', 'Demonstrator', '@gmail.com', 1),
(11, 'Demonstator8', '011', 'Demonstrator', '@gmail.com', 1),
(12, 'Demonstator9', '011', 'Demonstrator', '@gmail.com', 1),
(13, 'Demonstator10', '011', 'Demonstrator', '@gmail.com', 1);

-- --------------------------------------------------------

--
-- بنية الجدول `doctorconstrains`
--

CREATE TABLE IF NOT EXISTS `doctorconstrains` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `DoctorId` int(11) NOT NULL,
  `Day` varchar(10) CHARACTER SET utf8 NOT NULL,
  `From` time NOT NULL,
  `To` time NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `DoctorConstrains_ibfk_1` (`DoctorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- إرجاع أو استيراد بيانات الجدول `doctorconstrains`
--

INSERT INTO `doctorconstrains` (`Id`, `DoctorId`, `Day`, `From`, `To`) VALUES
(1, 3, 'SATURDAY', '09:00:00', '14:30:00'),
(2, 3, 'SUNDAY', '09:00:00', '16:30:00');

-- --------------------------------------------------------

--
-- بنية الجدول `facultytable`
--

CREATE TABLE IF NOT EXISTS `facultytable` (
  `CellId` int(11) NOT NULL AUTO_INCREMENT,
  `ClassId` int(11) NOT NULL,
  `CourseId` int(11) NOT NULL,
  `DoctorId` int(11) NOT NULL,
  `PlaceId` int(11) DEFAULT NULL,
  `StartSection` int(3) NOT NULL,
  `EndSection` int(3) NOT NULL,
  `StartTime` time DEFAULT NULL,
  `EndTime` time DEFAULT NULL,
  `Day` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `Type` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Year` int(11) NOT NULL,
  PRIMARY KEY (`CellId`),
  KEY `FacultyTable_ibfk_1` (`ClassId`),
  KEY `FacultyTable_ibfk_2` (`CourseId`),
  KEY `FacultyTable_ibfk_3` (`DoctorId`),
  KEY `FacultyTable_ibfk_4` (`PlaceId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- إرجاع أو استيراد بيانات الجدول `facultytable`
--

INSERT INTO `facultytable` (`CellId`, `ClassId`, `CourseId`, `DoctorId`, `PlaceId`, `StartSection`, `EndSection`, `StartTime`, `EndTime`, `Day`, `Type`, `Year`) VALUES
(1, 1, 1, 1, NULL, 1, 1, '09:00:00', '11:30:00', 'SATURDAY', 'Secton', 2015);

-- --------------------------------------------------------

--
-- بنية الجدول `generalinformation`
--

CREATE TABLE IF NOT EXISTS `generalinformation` (
  `DayHoursNumber` time NOT NULL,
  `SectionPeriod` time NOT NULL,
  `LecturePeriod` time NOT NULL,
  `DayStartingTime` time NOT NULL,
  `DayEndingTime` time NOT NULL,
  `MaxGrouPNumber` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `generalinformation`
--

INSERT INTO `generalinformation` (`DayHoursNumber`, `SectionPeriod`, `LecturePeriod`, `DayStartingTime`, `DayEndingTime`, `MaxGrouPNumber`) VALUES
('07:30:00', '02:30:00', '02:30:00', '09:00:00', '16:30:00', 3);

-- --------------------------------------------------------

--
-- بنية الجدول `place`
--

CREATE TABLE IF NOT EXISTS `place` (
  `PlaceId` int(11) NOT NULL AUTO_INCREMENT,
  `PlaceName` varchar(200) CHARACTER SET utf8 NOT NULL,
  `PlaceCapacity` int(11) NOT NULL,
  `PlaceTimeAvailability` int(11) NOT NULL,
  `PlaceGenerality` int(11) NOT NULL,
  PRIMARY KEY (`PlaceId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- إرجاع أو استيراد بيانات الجدول `place`
--

INSERT INTO `place` (`PlaceId`, `PlaceName`, `PlaceCapacity`, `PlaceTimeAvailability`, `PlaceGenerality`) VALUES
(1, 'Lab-501', 35, 1, 1),
(2, 'Lab-502', 35, 1, 1),
(3, 'Lab-503', 35, 1, 1),
(4, 'Lab-504', 35, 1, 1),
(5, 'Lab-505', 35, 1, 1),
(6, 'Stage1', 350, 0, 1),
(7, 'Lab-course 1', 35, 1, 0);

-- --------------------------------------------------------

--
-- بنية الجدول `placeconstrains`
--

CREATE TABLE IF NOT EXISTS `placeconstrains` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PlaceId` int(11) NOT NULL,
  `Day` varchar(10) CHARACTER SET utf8 NOT NULL,
  `From` time NOT NULL,
  `To` time NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `PlaceConstrains_ibfk_1` (`PlaceId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- إرجاع أو استيراد بيانات الجدول `placeconstrains`
--

INSERT INTO `placeconstrains` (`Id`, `PlaceId`, `Day`, `From`, `To`) VALUES
(1, 6, 'SATURDAY', '09:00:00', '14:00:00'),
(2, 6, 'TUESDAY', '09:00:00', '16:30:00'),
(3, 6, 'MONDAY', '09:00:00', '16:30:00'),
(4, 6, 'WEDNESDAY', '09:00:00', '14:00:00');

-- --------------------------------------------------------

--
-- بنية الجدول `placecourseconstrains`
--

CREATE TABLE IF NOT EXISTS `placecourseconstrains` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PlaceId` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `PlaceCourseConstrains_ibfk_1` (`PlaceId`),
  KEY `PlaceCourseConstrains_ibfk_2` (`CourseID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- إرجاع أو استيراد بيانات الجدول `placecourseconstrains`
--

INSERT INTO `placecourseconstrains` (`Id`, `PlaceId`, `CourseID`) VALUES
(1, 7, 1);

-- --------------------------------------------------------

--
-- بنية الجدول `tableitemsprobabilities`
--

CREATE TABLE IF NOT EXISTS `tableitemsprobabilities` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CellId` int(11) NOT NULL,
  `PlaceId` int(11) NOT NULL,
  `Day` varchar(10) CHARACTER SET utf8 NOT NULL,
  `From` time NOT NULL,
  `to` time NOT NULL,
  `mood` varchar(30) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `tableitemsprobabilities_ibfk_1` (`CellId`),
  KEY `tableitemsprobabilities_ibfk_2` (`PlaceId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- إرجاع أو استيراد بيانات الجدول `tableitemsprobabilities`
--

INSERT INTO `tableitemsprobabilities` (`Id`, `CellId`, `PlaceId`, `Day`, `From`, `to`, `mood`) VALUES
(1, 1, 1, 'SATURDAY', '09:00:00', '11:30:00', 'Good');

-- --------------------------------------------------------

--
-- بنية الجدول `workingdays`
--

CREATE TABLE IF NOT EXISTS `workingdays` (
  `Day` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Day`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `workingdays`
--

INSERT INTO `workingdays` (`Day`) VALUES
('MONDAY'),
('SATURDAY'),
('SUNDAY'),
('THURSDAY'),
('TUESDAY'),
('WEDNESDAY');

--
-- قيود الجداول المحفوظة
--

--
-- القيود للجدول `classcourse`
--
ALTER TABLE `classcourse`
  ADD CONSTRAINT `ClassCourse_ibfk_1` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ClassCourse_ibfk_2` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- القيود للجدول `doctorconstrains`
--
ALTER TABLE `doctorconstrains`
  ADD CONSTRAINT `DoctorConstrains_ibfk_1` FOREIGN KEY (`DoctorId`) REFERENCES `doctor` (`DoctorId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- القيود للجدول `facultytable`
--
ALTER TABLE `facultytable`
  ADD CONSTRAINT `FacultyTable_ibfk_1` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FacultyTable_ibfk_2` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FacultyTable_ibfk_3` FOREIGN KEY (`DoctorId`) REFERENCES `doctor` (`DoctorId`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FacultyTable_ibfk_4` FOREIGN KEY (`PlaceId`) REFERENCES `place` (`PlaceId`) ON UPDATE CASCADE;

--
-- القيود للجدول `placeconstrains`
--
ALTER TABLE `placeconstrains`
  ADD CONSTRAINT `PlaceConstrains_ibfk_1` FOREIGN KEY (`PlaceId`) REFERENCES `place` (`PlaceId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- القيود للجدول `placecourseconstrains`
--
ALTER TABLE `placecourseconstrains`
  ADD CONSTRAINT `PlaceCourseConstrains_ibfk_1` FOREIGN KEY (`PlaceId`) REFERENCES `place` (`PlaceId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PlaceCourseConstrains_ibfk_2` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- القيود للجدول `tableitemsprobabilities`
--
ALTER TABLE `tableitemsprobabilities`
  ADD CONSTRAINT `tableitemsprobabilities_ibfk_1` FOREIGN KEY (`CellId`) REFERENCES `facultytable` (`CellId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tableitemsprobabilities_ibfk_2` FOREIGN KEY (`PlaceId`) REFERENCES `place` (`PlaceId`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
