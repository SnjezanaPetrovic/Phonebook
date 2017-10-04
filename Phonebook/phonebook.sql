CREATE DATABASE  IF NOT EXISTS `phonebook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `phonebook`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: phonebook
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_ID` int(11) NOT NULL AUTO_INCREMENT,
  `first_Name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`admin_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Snjezana','Petrovic','nikita','mod'),(3,'Momcilo','Petrovic','momo','admin'),(7,'Sanjin','Vasiljevic','nani','admin'),(9,'Amer','Sarajlic','amer','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts` (
  `contact_ID` int(11) NOT NULL AUTO_INCREMENT,
  `first_Name` varchar(45) NOT NULL,
  `last_Name` varchar(45) NOT NULL,
  `phone_Number` varchar(45) NOT NULL,
  `number_Type` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `comment` varchar(10) NOT NULL,
  PRIMARY KEY (`contact_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'Joe','Smith','0038765234234','mob','personal','Karadjordjeva 12, Teslic,BiH','invalid'),(2,'Aleksa','Jovic','0038766345231','mob','company','Titova 34, Sarajevo,BiH','valid'),(6,'Sanja','Berg','0038765743345','mob','company','Safeta Susica 12,BiH','valid'),(7,'Amer','Kljajic','0038752345678','home','personal','Karadjordjeva d45,BiH','valid'),(8,'Alexa','Smith','0048067854362','home','personal','Fitzstr.24,Germany','valid'),(9,'Matt','Porter','0049092548795','mob','personal','Alt-Moabit 3,Germany','valid'),(10,'Cory','Robins','0049169483899','mob','company','Kastanienallee 1277 625 Detern, Germany','valid'),(11,'Irma','Craig','0049189746379','home','personal','Inge Beisheim Platz 618 3934 Heede, Germany','valid'),(12,'Matt','Brown','0038752137990','home','company','Gotzkowskystraße 9766 7716 Soest, Germany','valid'),(13,'Susie','Gray','0049109854970','mob','company','Marseiller Strasse 6292 9710 Wallgau, Germany','valid'),(14,'Kristin','Malone','0049156432176','mob','personal','Schaarsteinweg 1229 5353 Neunburg, Germany','valid');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_ID` int(11) NOT NULL AUTO_INCREMENT,
  `first_Name` varchar(45) NOT NULL,
  `last_Name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Maja','Austin','maja'),(2,'Liam','Klein','liam'),(3,'William','Keller','willi'),(5,'Sanja','Aero','smit'),(6,'Irma','Harmon','irma'),(7,'Jacob','Weber','jacob'),(8,'Nora','George','nora'),(9,'James','Brock','james'),(10,'Alexander','Washington','alexander'),(11,'Marita','Monroe','marita');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-04 21:07:14
