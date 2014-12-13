CREATE DATABASE  IF NOT EXISTS `foobar` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `foobar`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: foobar
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `productID` int(11) NOT NULL,
  `author` varchar(255) NOT NULL,
  PRIMARY KEY (`productID`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Nicholas Sparks'),(2,'J.K. Rowling');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cd`
--

DROP TABLE IF EXISTS `cd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cd` (
  `productID` int(11) NOT NULL,
  `artist` varchar(255) NOT NULL,
  PRIMARY KEY (`productID`),
  CONSTRAINT `cd_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cd`
--

LOCK TABLES `cd` WRITE;
/*!40000 ALTER TABLE `cd` DISABLE KEYS */;
INSERT INTO `cd` VALUES (7,'Taylor Swift'),(8,'FM Static');
/*!40000 ALTER TABLE `cd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dvd`
--

DROP TABLE IF EXISTS `dvd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dvd` (
  `productID` int(11) NOT NULL,
  `director` varchar(255) NOT NULL,
  PRIMARY KEY (`productID`),
  CONSTRAINT `dvd_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dvd`
--

LOCK TABLES `dvd` WRITE;
/*!40000 ALTER TABLE `dvd` DISABLE KEYS */;
INSERT INTO `dvd` VALUES (5,'Will Gluck'),(6,'Richard Curtis');
/*!40000 ALTER TABLE `dvd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foo_order`
--

DROP TABLE IF EXISTS `foo_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foo_order` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `orderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `orderID` (`orderID`),
  KEY `userID` (`userID`),
  CONSTRAINT `foo_order_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `foo_user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foo_order`
--

LOCK TABLES `foo_order` WRITE;
/*!40000 ALTER TABLE `foo_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `foo_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foo_user`
--

DROP TABLE IF EXISTS `foo_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foo_user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `minitial` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `pword` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ustatus` int(11) NOT NULL,
  `userType` varchar(50) NOT NULL,
  `billingAddress` varchar(255) DEFAULT NULL,
  `deliveryAddress` varchar(255) DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID` (`userID`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foo_user`
--

LOCK TABLES `foo_user` WRITE;
/*!40000 ALTER TABLE `foo_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `foo_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mag`
--

DROP TABLE IF EXISTS `mag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mag` (
  `productID` int(11) NOT NULL,
  `volNo` int(11) NOT NULL,
  `issueNo` int(11) NOT NULL,
  PRIMARY KEY (`productID`),
  CONSTRAINT `mag_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mag`
--

LOCK TABLES `mag` WRITE;
/*!40000 ALTER TABLE `mag` DISABLE KEYS */;
INSERT INTO `mag` VALUES (3,4,12),(4,2,10);
/*!40000 ALTER TABLE `mag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordering`
--

DROP TABLE IF EXISTS `ordering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordering` (
  `orderID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `price` float NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderID`,`productID`),
  KEY `productID` (`productID`),
  CONSTRAINT `ordering_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `foo_order` (`orderID`),
  CONSTRAINT `ordering_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordering`
--

LOCK TABLES `ordering` WRITE;
/*!40000 ALTER TABLE `ordering` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `summary` varchar(700) NOT NULL,
  `price` float NOT NULL,
  `stock` float NOT NULL,
  `pstatus` varchar(25) NOT NULL,
  `category` varchar(10) NOT NULL,
  PRIMARY KEY (`productID`),
  UNIQUE KEY `productID` (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'A walk to Remember','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',250,10,'Available','book'),(2,'Harry Potter and the Sorcerer\'s Stone','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',500,8,'Available','book'),(3,'K-Zone','Super Tech: The Bat is Back.',80,10,'Available','magazine'),(4,'Total Girl','Taylor\'s Story: Why we\'re sweet on swift.',80,7,'Available','magazine'),(5,'Friends with Benefits','The characters are falling in love, falling out of love, some are with right people, some are with the wrong people, some are looking to have an affair, some are in the period of mourning; a capsule summary of reality. Love begins and love ends. They flirt a lot. They are all flirting with love. At all ages and social levels, love is the theme. Romantic love and brotherly love is the hotchpotch through out the movie. Most of the movie is filmed in London, during Christmas and the characters all ended up at Heathrow airport a very uplifting note.',500,5,'Available','dvd'),(6,'Love Actually','The characters are falling in love, falling out of love, some are with right people, some are with the wrong people, some are looking to have an affair, some are in the period of mourning; a capsule summary of reality. Love begins and love ends. They flirt a lot. They are all flirting with love. At all ages and social levels, love is the theme. Romantic love and brotherly love is the hotchpotch through out the movie. Most of the movie is filmed in London, during Christmas and the characters all ended up at Heathrow airport a very uplifting note.',450,6,'Available','dvd'),(7,'Fearless','Fearless is the second studio album by American singer-songwriter Taylor Swift. The album was released on November 11, 2008, by Big Machine Records. As with her debut, Swift wrote or co-wrote all thirteen tracks on Fearless. Most of the songs were written as the singer promoted her debut album as opening act for numerous country artists. Due to the unavailability of collaborators on the road, eight songs were self-pinned by Swift. Other songs were co-written with Liz Rose, Hillary Lindsey, Colbie Caillat, and John Rich. Swift also made her debut as a record producer, co-producing all songs on the album with Nathan Chapman.',200,10,'Available','cd'),(8,'Dear Diary','Dear Diary is a Christian rock opera, and the third studio album by the pop punk band FM Static. It was released on April 7, 2009 through Tooth & Nail Records.',250,8,'Available','cd');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productLog`
--

DROP TABLE IF EXISTS `productLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productLog` (
  `userID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `logDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `activity` varchar(10) NOT NULL,
  PRIMARY KEY (`userID`,`productID`,`logDate`),
  KEY `productID` (`productID`),
  CONSTRAINT `productlog_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `foo_user` (`userID`),
  CONSTRAINT `productlog_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productLog`
--

LOCK TABLES `productLog` WRITE;
/*!40000 ALTER TABLE `productLog` DISABLE KEYS */;
/*!40000 ALTER TABLE `productLog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `reviewID` int(11) NOT NULL AUTO_INCREMENT,
  `review` varchar(500) NOT NULL,
  `reviewDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  PRIMARY KEY (`reviewID`),
  UNIQUE KEY `reviewID` (`reviewID`),
  KEY `userID` (`userID`),
  KEY `productID` (`productID`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `foo_user` (`userID`) ON DELETE CASCADE,
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signLog`
--

DROP TABLE IF EXISTS `signLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signLog` (
  `logID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `logDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lstatus` int(11) NOT NULL,
  PRIMARY KEY (`logID`),
  UNIQUE KEY `logID` (`logID`),
  KEY `userID` (`userID`),
  CONSTRAINT `signlog_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `foo_user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signLog`
--

LOCK TABLES `signLog` WRITE;
/*!40000 ALTER TABLE `signLog` DISABLE KEYS */;
/*!40000 ALTER TABLE `signLog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-13 19:46:43
