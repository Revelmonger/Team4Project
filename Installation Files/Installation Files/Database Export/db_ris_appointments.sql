CREATE DATABASE  IF NOT EXISTS `db_ris` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_ris`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_ris
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `patient` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `modality` int DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `radiologist` int DEFAULT NULL,
  `technician` int DEFAULT NULL,
  `phone_number` varchar(25) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `enrollee_name` varchar(50) DEFAULT NULL,
  `enrollee_id` varchar(50) DEFAULT NULL,
  `issuer` varchar(50) DEFAULT NULL,
  `checked_in` bit(1) DEFAULT NULL,
  `closed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (24,19,18,4,'2022-03-24 08:00:00',6,NULL,'234523454535','sdfgsdfgsdfgs',NULL,NULL,NULL,_binary '',_binary ''),(25,19,19,6,'2022-03-24 09:00:00',6,NULL,'1234','asdf',NULL,NULL,NULL,_binary '',_binary ''),(26,19,20,3,'2022-03-24 05:00:00',6,NULL,'2523','asdfgasdf',NULL,NULL,NULL,_binary '',_binary ''),(27,20,21,4,'2022-03-24 06:00:00',6,NULL,'234523','adfadfs',NULL,NULL,NULL,_binary '',_binary ''),(28,19,20,3,'2022-03-17 05:00:00',6,NULL,'2341234','asdfawsf',NULL,NULL,NULL,NULL,NULL),(29,19,22,3,'2022-03-29 06:00:00',6,NULL,'asdf','asdf',NULL,NULL,NULL,_binary '',_binary ''),(30,20,23,1,'2022-03-30 06:00:00',6,NULL,'1324','1243',NULL,NULL,NULL,_binary '',_binary ''),(31,19,24,1,'2022-03-30 05:00:00',6,NULL,'ASDF','234',NULL,NULL,NULL,_binary '',_binary ''),(32,20,25,2,'2022-03-30 06:00:00',6,NULL,'1234','qwer',NULL,NULL,NULL,_binary '',_binary ''),(33,88,33,3,'2022-04-01 11:00:00',6,NULL,'23452345','gsdfgsdfg',NULL,NULL,NULL,NULL,NULL),(34,88,34,3,'2022-04-02 06:00:00',6,NULL,'asdfadsf','fqwf',NULL,NULL,NULL,_binary '',_binary ''),(35,90,35,2,'2022-04-03 06:00:00',6,NULL,'23452345','',NULL,NULL,NULL,_binary '',_binary ''),(36,1,38,2,'2022-04-04 06:00:00',6,NULL,'252345','sagsg',NULL,NULL,NULL,_binary '',_binary ''),(37,97,44,1,'2022-04-04 07:00:00',6,NULL,'324543215','12345342',NULL,NULL,NULL,_binary '',_binary ''),(38,1,42,1,'2022-04-04 03:00:00',6,NULL,'asdfaf','asdfafsd',NULL,NULL,NULL,_binary '',_binary ''),(39,92,45,1,'2022-04-04 02:00:00',6,NULL,'2345','sdfg',NULL,NULL,NULL,_binary '',_binary ''),(40,97,43,1,'2022-04-04 07:00:00',6,NULL,'13241234','12341234',NULL,NULL,NULL,_binary '',_binary ''),(41,1,46,1,'2022-04-04 05:00:00',6,NULL,'432142','12431234',NULL,NULL,NULL,_binary '',_binary ''),(42,95,41,1,'2022-04-04 03:00:00',6,NULL,'1123','413241234312',NULL,NULL,NULL,_binary '',_binary '');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-05 22:58:49
