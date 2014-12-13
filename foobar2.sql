CREATE DATABASE  IF NOT EXISTS `foobar` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `foobar`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: foobar
-- ------------------------------------------------------
-- Server version	5.6.19-log

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
INSERT INTO `book` VALUES (13,'smith');
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
INSERT INTO `dvd` VALUES (14,'wilson');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foo_user`
--

LOCK TABLES `foo_user` WRITE;
/*!40000 ALTER TABLE `foo_user` DISABLE KEYS */;
INSERT INTO `foo_user` VALUES (1,'genericAdmin','asdf','adsf','asdfasd','9hog2p6qaKnwbbwXELEO8KZyCLIFmx9XavberCPCFfU=','nic_ft@yahoo.com',1,'DVD','1 asdf asdf 1123 AF','1 asdf asdf 1123 AF','2014-12-13 19:58:12');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,'K-Zone','Super Tech: The Bat is Back.',80,10,'Available','magazine'),(4,'Total Girl','Taylor\'s Story: Why we\'re sweet on swift.',80,7,'Available','magazine'),(7,'Fearless','Fearless is the second studio album by American singer-songwriter Taylor Swift. The album was released on November 11, 2008, by Big Machine Records. As with her debut, Swift wrote or co-wrote all thirteen tracks on Fearless. Most of the songs were written as the singer promoted her debut album as opening act for numerous country artists. Due to the unavailability of collaborators on the road, eight songs were self-pinned by Swift. Other songs were co-written with Liz Rose, Hillary Lindsey, Colbie Caillat, and John Rich. Swift also made her debut as a record producer, co-producing all songs on the album with Nathan Chapman.',200,10,'Available','cd'),(8,'Dear Diary','Dear Diary is a Christian rock opera, and the third studio album by the pop punk band FM Static. It was released on April 7, 2009 through Tooth & Nail Records.',250,8,'Available','cd'),(9,'harry porter','asdf',52.3,20,'Not Available','Book'),(10,'harry prouy','traila 2',42.3,2,'Not Available','Book'),(13,'jr smith','ahser',15.89,2,'Deleted','Book'),(14,'robocop','killing spree',300.5,10,'Available','DVD');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productlog`
--

DROP TABLE IF EXISTS `productlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productlog` (
  `userID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `logDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `activity` varchar(25) NOT NULL,
  PRIMARY KEY (`userID`,`productID`,`logDate`),
  KEY `productID` (`productID`),
  CONSTRAINT `productlog_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `foo_user` (`userID`),
  CONSTRAINT `productlog_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productlog`
--

LOCK TABLES `productlog` WRITE;
/*!40000 ALTER TABLE `productlog` DISABLE KEYS */;
INSERT INTO `productlog` VALUES (1,8,'2014-12-13 17:06:48','d-Book'),(1,9,'2014-12-13 17:44:26','A- Book'),(1,9,'2014-12-13 17:45:11','d- Book'),(1,10,'2014-12-13 17:54:47','A- Book'),(1,10,'2014-12-13 17:55:18','d- Book'),(1,13,'2014-12-13 19:10:17','A- Book'),(1,13,'2014-12-13 19:10:48','d- Book'),(1,14,'2014-12-13 20:02:53','A- DVD'),(1,14,'2014-12-13 20:03:35','d- DVD'),(1,14,'2014-12-13 20:04:01','E- DVSta'),(1,14,'2014-12-13 20:04:26','E- DVSto'),(1,14,'2014-12-13 20:04:54','E- DVD'),(1,14,'2014-12-13 20:04:55','E- DVSta'),(1,14,'2014-12-13 20:05:15','E- DVD');
/*!40000 ALTER TABLE `productlog` ENABLE KEYS */;
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
-- Table structure for table `signlog`
--

DROP TABLE IF EXISTS `signlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signlog` (
  `logID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `logDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lstatus` int(11) NOT NULL,
  PRIMARY KEY (`logID`),
  UNIQUE KEY `logID` (`logID`),
  KEY `userID` (`userID`),
  CONSTRAINT `signlog_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `foo_user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signlog`
--

LOCK TABLES `signlog` WRITE;
/*!40000 ALTER TABLE `signlog` DISABLE KEYS */;
INSERT INTO `signlog` VALUES (1,1,'2014-12-13 16:36:44',0),(2,1,'2014-12-13 16:37:48',1),(3,1,'2014-12-13 17:01:18',1),(4,1,'2014-12-13 17:11:20',1),(5,1,'2014-12-13 17:13:46',1),(6,1,'2014-12-13 17:24:14',1),(7,1,'2014-12-13 17:43:57',1),(8,1,'2014-12-13 17:54:21',1),(9,1,'2014-12-13 18:24:39',1),(10,1,'2014-12-13 19:09:30',1),(11,1,'2014-12-13 20:01:45',1);
/*!40000 ALTER TABLE `signlog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-14  4:30:24
