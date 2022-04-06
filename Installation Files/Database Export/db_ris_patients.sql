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
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `sex` varchar(25) DEFAULT NULL,
  `race` varchar(50) DEFAULT NULL,
  `ethnicity` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (19,'Betty','White','1979-04-01','Female','White','Not Hispanic or Latino'),(20,'qwer','qwer','2022-03-24','Female','African American','Hispanic or Latino'),(21,'1234','1234','2022-03-17','Female','White','Not Hispanic or Latino'),(22,'1324','1324','2022-03-17','Female','American Indian','Not Hispanic or Latino'),(23,'1234','1324','2022-03-17','Female','African American','Not Hispanic or Latino'),(24,'3241234','12341324','2022-03-04','Other','American Indian','Hispanic or Latino'),(25,'aadsfa','af','2022-03-02','Other','White','Hispanic or Latino'),(26,'SD','ASDF','2022-03-23','Female','White','Not Hispanic or Latino'),(27,'asdf','asdfasdf','2022-03-10','Female','White','Not Hispanic or Latino'),(28,'asdf','asdfasdf','2022-03-10','Female','White','Not Hispanic or Latino'),(29,'asdfadf','asdfadfss','2022-03-23','Female','African American','Hispanic or Latino'),(30,'adfaf','adsfasfasd','2022-03-10','Female','White','Not Hispanic or Latino'),(31,'asdfads','asdfasfd','2022-03-04','Other','African American','Not Hispanic or Latino'),(32,'asdfadfs','adfsasdf','2022-03-10','Female','African American','Hispanic or Latino'),(33,'asdfasdf','adsfadsf','2022-03-17','Male','African American','Hispanic or Latino'),(34,'pop','tart','2022-03-13','Female','African American','Not Hispanic or Latino'),(35,'tartty','popcicle','2022-03-28','Female','African American','Hispanic or Latino'),(36,'yesterday','griffin','2022-03-31','Female','African American','Not Hispanic or Latino'),(37,'asdfasdf','asdfdsfa','2022-03-14','Other','African American','Not Hispanic or Latino'),(38,'afgsfdg','adfafds','2022-03-03','Other','African American','Hispanic or Latino'),(39,'asdfadsf','asdfasdf','2022-03-09','Other','American Indian','Not Hispanic or Latino'),(40,'asdfasfd','afsdasfd','2022-03-04','Female','White','Not Hispanic or Latino'),(41,'Tom','And Jerry','2022-03-24','Male','White','Not Hispanic or Latino'),(42,'Adam','Sandler','2022-03-25','Female','African American','Hispanic or Latino'),(43,'asdfsdf','asdfasfd','2022-03-10','Female','African American','Not Hispanic or Latino'),(44,'asdfasdf','adsfadsf','2022-03-15','Female','African American','Not Hispanic or Latino'),(45,'asdfasdf','adsfadsf','2022-03-15','Female','African American','Not Hispanic or Latino'),(46,'asdfasdf','afdasfd','2022-03-07','Male','White','Not Hispanic or Latino'),(47,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(48,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(49,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(50,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(51,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(52,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(53,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(54,'asdf','asdf','2022-03-03','Female','American Indian','Hispanic or Latino'),(55,'asdfaasd','fasdfas','2022-03-15','Female','African American','Not Hispanic or Latino'),(56,'fasdff','asdfasdf','2022-03-23','Male','White','Not Hispanic or Latino'),(57,'fqwef','dfqw','2022-03-15','Male','African American','Not Hispanic or Latino'),(58,'sdfadsf','asdfasdf','2022-03-17','Female','Asian','Not Hispanic or Latino'),(59,'asefadf','asdfasdf','2022-03-16','Male','African American','Not Hispanic or Latino'),(60,'dsafadsf','asdfasdf','2022-03-10','Female','American Indian','Not Hispanic or Latino'),(61,'sadfsadf','asdfasfd','2022-03-22','Female','American Indian','Hispanic or Latino'),(62,'sadfsadf','asdfasfd','2022-03-22','Female','American Indian','Hispanic or Latino'),(63,'asdfasf','adsfasfd','2022-03-02','Male','African American','Hispanic or Latino'),(64,'fasdf','adsfasdf','2022-03-03','Female','African American','Hispanic or Latino'),(65,'asfasa','asdfasdf','2022-03-16','Female','American Indian','Not Hispanic or Latino'),(66,'adsfasdf','adfsasd','2022-03-14','Other','African American','Not Hispanic or Latino'),(67,'adsfasdf','adfsasd','2022-03-14','Other','African American','Not Hispanic or Latino'),(68,'asdfasdf','asdffdas','2022-03-08','Female','African American','Not Hispanic or Latino'),(69,'fgsdfg','dfasgsfdg','2022-03-09','Female','African American','Not Hispanic or Latino'),(70,'asdfdsaf','asdfadsf','2022-03-03','Other','American Indian','Hispanic or Latino'),(71,'adfdsf','adsfadsf','2022-03-09','Other','African American','Hispanic or Latino'),(72,'dfadsf','asdffads','2022-03-16','Female','African American','Hispanic or Latino'),(73,'asfdas','afsasdf','2022-03-10','Female','African American','Hispanic or Latino'),(74,'asdfadsf','asdfdasf','2022-03-03','Female','African American','Hispanic or Latino'),(75,'sadfgasdf','asdfasdf','2022-03-16','Other','African American','Not Hispanic or Latino'),(76,'asdfasd','fasdf','2022-03-03','Female','White','Hispanic or Latino'),(77,'asdfasdf','asdfasdf','2022-03-02','Female','African American','Not Hispanic or Latino'),(78,'asfadsf','adsfdasf','2022-03-09','Female','White','Not Hispanic or Latino'),(79,'adsfaf','dsasdfasdf','2022-03-09','Other','African American','Hispanic or Latino'),(80,'asdffdaf','asdfsfd','2022-03-02','Female','African American','Hispanic or Latino'),(81,'Saddie','Smith','2022-03-22','Female','White','Hispanic or Latino'),(82,'John','Michleson','2022-03-10','Female','American Indian','Hispanic or Latino'),(83,'Abraham','Lincoln','2022-03-09','Female','African American','Not Hispanic or Latino'),(84,'asdfasdf','asdfasdf','2022-03-23','Female','African American','Not Hispanic or Latino'),(85,'tinm','tim','2022-03-08','Other','African American','Not Hispanic or Latino'),(86,'sadfdsaf','asdfasdf','2022-03-09','Male','African American','Hispanic or Latino'),(87,'Bob','Ross','2022-03-17','Male','White','Hispanic or Latino'),(88,'John','Xina','2022-03-23','Male','Asian','Not Hispanic or Latino'),(89,'John','Hopkins','2022-04-20','Female','African American','Hispanic or Latino'),(90,'No','Alert','2022-04-14','Male','African American','Hispanic or Latino'),(91,'ERWGWER','SDFGWER','2022-04-20','Male','African American','Not Hispanic or Latino'),(92,'Hello','World','2022-04-18','Female','African American','Not Hispanic or Latino'),(93,'George ','Washington','2022-04-27','Male','White','Not Hispanic or Latino'),(94,'qerqewr','qewrqwrewr','2022-04-05','Female','African American','Hispanic or Latino'),(95,'George`','Washington','2022-04-27','Male','White','Not Hispanic or Latino'),(96,'George ','Washington','2022-04-27','Male','African American','Hispanic or Latino'),(97,'Harrol','Harold','2022-04-01','Female','White','Hispanic or Latino'),(98,'aegasdf','asfg','2022-04-06','null','null','null'),(99,'141234 123','21341234','2022-04-04','Male','African American','Not Hispanic or Latino');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
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
