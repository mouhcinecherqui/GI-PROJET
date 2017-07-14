CREATE DATABASE  IF NOT EXISTS `gidb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gidb`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: gidb
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `domaine`
--

DROP TABLE IF EXISTS `domaine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domaine` (
  `DMN` varchar(45) NOT NULL,
  `NOMDOMAINE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DMN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domaine`
--

LOCK TABLES `domaine` WRITE;
/*!40000 ALTER TABLE `domaine` DISABLE KEYS */;
INSERT INTO `domaine` VALUES ('dom1',NULL),('dom2',NULL),('dom3',NULL);
/*!40000 ALTER TABLE `domaine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imputation`
--

DROP TABLE IF EXISTS `imputation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imputation` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CODEALLIANCE` varchar(45) DEFAULT NULL,
  `CODEPROJET` varchar(45) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `JOUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imputation`
--

LOCK TABLES `imputation` WRITE;
/*!40000 ALTER TABLE `imputation` DISABLE KEYS */;
INSERT INTO `imputation` VALUES (123,'abcd1234','projet1','2017-06-13 21:52:22',5),(129,'abcd1234',NULL,'2017-07-13 21:52:22',1),(130,'abcd1234',NULL,'2017-07-13 21:52:24',1);
/*!40000 ALTER TABLE `imputation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projet`
--

DROP TABLE IF EXISTS `projet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projet` (
  `CODEPROJET` varchar(50) NOT NULL,
  `NOMPROJET` varchar(45) DEFAULT NULL,
  `NOMCOMPLET` varchar(100) DEFAULT NULL,
  `DESCRIPTIONPROJET` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CODEPROJET`),
  UNIQUE KEY `CODEPROJET_UNIQUE` (`CODEPROJET`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projet`
--

LOCK TABLES `projet` WRITE;
/*!40000 ALTER TABLE `projet` DISABLE KEYS */;
INSERT INTO `projet` VALUES ('projet1',NULL,NULL,NULL),('projet2',NULL,NULL,NULL);
/*!40000 ALTER TABLE `projet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ROLE` varchar(45) NOT NULL,
  `NOMROLE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('role1',NULL),('role2',NULL),('role3',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `CODEALLIANCE` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `ROLE` varchar(45) DEFAULT NULL,
  `DMN` varchar(45) NOT NULL,
  PRIMARY KEY (`CODEALLIANCE`),
  UNIQUE KEY `CODEALLIANCE_UNIQUE` (`CODEALLIANCE`),
  UNIQUE KEY `PASSWORD_UNIQUE` (`PASSWORD`),
  KEY `DMN` (`DMN`),
  KEY `ROLE` (`ROLE`),
  CONSTRAINT `DMN` FOREIGN KEY (`DMN`) REFERENCES `domaine` (`DMN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ROLE` FOREIGN KEY (`ROLE`) REFERENCES `role` (`ROLE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES ('Mouhcine','Cherqui','abcd1234','mimi1234','mouhcinecherqui@gmail.com','role1','dom1'),('marwan ','rais','azer1234','marwan1234','marwan.rais@gmail.com','role2','dom2'),('badr','amri','efgh5678','badr1234','badramri@gmail.com','role1','dom1');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-14 18:18:01
