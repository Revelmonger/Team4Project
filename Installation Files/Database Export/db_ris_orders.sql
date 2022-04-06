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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `patient` int DEFAULT NULL,
  `referral_md` int DEFAULT NULL,
  `modality` int DEFAULT NULL,
  `appointment` int DEFAULT NULL,
  `notes` varchar(250) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `report` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `referral_md` (`referral_md`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`referral_md`) REFERENCES `referralmds` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (18,19,4,4,24,'Kill this bitch',4,1),(19,19,4,6,25,'Brain Scan',4,1),(20,19,4,3,28,'qwerqwe',1,NULL),(21,20,4,4,27,'wqefwqe',2,1),(22,19,4,3,29,'efwwq',3,1),(23,20,4,1,30,'1234',2,1),(24,19,4,1,31,'asdf',2,1),(25,20,4,2,32,'4234',3,1),(26,21,4,2,NULL,'qwerqewr',2,NULL),(27,81,4,2,NULL,'adfadsf',2,NULL),(28,82,4,1,NULL,'dsfad',4,NULL),(29,83,4,1,NULL,'dfwq',4,NULL),(30,84,4,1,NULL,'afadf',4,NULL),(31,87,4,1,NULL,'qerfqwe',4,NULL),(32,88,4,1,NULL,'sdfwerqwe',4,NULL),(33,88,4,3,33,'sardgfsfdaasdfa',4,NULL),(34,88,4,3,34,'adf',3,1),(35,90,4,2,35,'sadffgsad',3,1),(36,1,4,1,NULL,'X-Ray',4,NULL),(37,1,4,1,NULL,'awfafwe',4,NULL),(38,1,4,2,36,'ewfwq',3,NULL),(39,1,4,2,NULL,'qewfewfw',4,NULL),(40,94,4,1,NULL,'qwf',4,NULL),(41,95,4,1,42,'qwef',4,NULL),(42,1,4,1,38,'qwef',3,NULL),(43,97,4,1,40,'ag',2,1),(44,97,4,1,37,'New patient\n',2,1),(45,92,4,1,39,'hello world',2,1),(46,1,4,1,41,'q	weqe	wew',4,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
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
