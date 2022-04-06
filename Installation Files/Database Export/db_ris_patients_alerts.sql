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
-- Table structure for table `patients_alerts`
--

DROP TABLE IF EXISTS `patients_alerts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients_alerts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int NOT NULL,
  `alert_id` int NOT NULL,
  `alert_value` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `patient_fk_idx` (`patient_id`),
  KEY `alert_fk_idx` (`alert_id`),
  CONSTRAINT `alert_fk` FOREIGN KEY (`alert_id`) REFERENCES `alerts` (`alert_id`),
  CONSTRAINT `patient_fk` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients_alerts`
--

LOCK TABLES `patients_alerts` WRITE;
/*!40000 ALTER TABLE `patients_alerts` DISABLE KEYS */;
INSERT INTO `patients_alerts` VALUES (19,30,5,0),(20,30,5,0),(21,31,5,0),(22,31,5,0),(23,31,5,0),(24,31,5,0),(25,31,5,0),(26,32,5,0),(27,32,5,0),(28,32,5,0),(29,37,5,0),(30,45,5,0),(31,54,5,0),(32,55,5,0),(33,55,5,0),(34,55,5,0),(35,59,5,0),(36,59,5,0),(37,59,5,0),(38,59,5,0),(39,68,5,0),(40,68,5,0),(41,68,5,0),(42,68,5,0),(43,68,5,0),(44,71,5,0),(45,71,5,0),(46,71,5,0),(47,71,5,0),(48,74,5,0),(49,74,5,0),(50,74,5,0),(51,74,5,0),(52,78,5,0),(53,78,5,0),(54,78,5,0),(55,83,5,0),(56,83,5,0),(57,83,5,0),(58,83,5,0),(59,84,5,0),(60,84,5,0),(61,84,5,0),(62,84,5,0),(63,84,5,0),(64,85,5,0),(65,85,3,0),(66,85,1,0),(67,86,2,0),(68,87,1,0),(69,87,3,0),(70,87,4,0),(71,88,1,0),(72,88,5,0),(73,89,1,0),(74,89,2,0),(75,89,3,0),(76,89,4,0),(77,89,5,0),(78,91,1,0),(79,91,2,0),(80,91,3,0),(81,91,4,0),(82,92,1,0),(83,92,2,0),(84,92,3,0),(85,93,5,0),(86,94,1,0),(87,94,3,0),(88,94,4,0),(89,94,5,0),(90,95,5,0),(91,96,2,0),(92,97,1,0),(93,97,3,0),(94,98,2,0);
/*!40000 ALTER TABLE `patients_alerts` ENABLE KEYS */;
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
