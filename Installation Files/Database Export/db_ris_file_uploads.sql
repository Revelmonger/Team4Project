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
-- Table structure for table `file_uploads`
--

DROP TABLE IF EXISTS `file_uploads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_uploads` (
  `file_upload_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `file_name` varchar(50) DEFAULT NULL,
  `file_type` varchar(50) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `upload_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_upload_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_uploads`
--

LOCK TABLES `file_uploads` WRITE;
/*!40000 ALTER TABLE `file_uploads` DISABLE KEYS */;
INSERT INTO `file_uploads` VALUES (49,18,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(50,19,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(51,20,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(52,21,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(53,22,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(54,23,'RIS_33.jpg','jpg',_binary '','C:\\Users\\School Account\\Downloads\\RIS_33.jpg'),(55,24,'salimi_what.png','png',_binary '','C:\\Users\\School Account\\Downloads\\salimi_what.png'),(56,25,'salimi_what.png','png',_binary '','C:\\Users\\School Account\\Downloads\\salimi_what.png'),(57,34,'kindpng_1082101.png','png',_binary '','C:\\Users\\School Account\\Downloads\\kindpng_1082101.png'),(58,35,'salimi_what.png','png',_binary '','C:\\Users\\School Account\\Downloads\\salimi_what.png'),(59,38,NULL,NULL,_binary '','No file chosen'),(60,44,'salimi_what.png','png',_binary '','C:\\Users\\School Account\\Downloads\\salimi_what.png'),(61,42,'RIS_33.jpg','jpg',_binary '','C:\\Users\\School Account\\Downloads\\RIS_33.jpg'),(62,45,'salimi_what.png','png',_binary '','C:\\Users\\School Account\\Downloads\\salimi_what.png'),(63,46,NULL,NULL,_binary '','No file chosen'),(64,43,'RIS_33.jpg','jpg',_binary '','C:\\Users\\School Account\\Downloads\\RIS_33.jpg'),(65,41,NULL,NULL,_binary '','No file chosen');
/*!40000 ALTER TABLE `file_uploads` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-05 22:58:51
