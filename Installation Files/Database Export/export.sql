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
-- Table structure for table `alerts`
--

DROP TABLE IF EXISTS `alerts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alerts` (
  `alert_id` int NOT NULL AUTO_INCREMENT,
  `alert_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`alert_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alerts`
--

LOCK TABLES `alerts` WRITE;
/*!40000 ALTER TABLE `alerts` DISABLE KEYS */;
INSERT INTO `alerts` VALUES (1,'Pacemaker'),(2,'Iodine Allergy'),(3,'Contrast Allergy'),(4,'Latex Allergy'),(5,'Shrapnel');
/*!40000 ALTER TABLE `alerts` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (24,19,18,4,'2022-03-24 08:00:00',6,NULL,'234523454535','sdfgsdfgsdfgs',NULL,NULL,NULL,_binary '',_binary ''),(25,19,19,6,'2022-03-24 09:00:00',6,NULL,'1234','asdf',NULL,NULL,NULL,_binary '',_binary ''),(26,19,20,3,'2022-03-24 05:00:00',6,NULL,'2523','asdfgasdf',NULL,NULL,NULL,_binary '',_binary ''),(27,20,21,4,'2022-03-24 06:00:00',6,NULL,'234523','adfadfs',NULL,NULL,NULL,_binary '',_binary ''),(28,19,20,3,'2022-03-17 05:00:00',6,NULL,'2341234','asdfawsf',NULL,NULL,NULL,NULL,NULL),(29,19,22,3,'2022-03-29 06:00:00',6,NULL,'asdf','asdf',NULL,NULL,NULL,_binary '',_binary ''),(30,20,23,1,'2022-03-30 06:00:00',6,NULL,'1324','1243',NULL,NULL,NULL,_binary '',_binary ''),(31,19,24,1,'2022-03-30 05:00:00',6,NULL,'ASDF','234',NULL,NULL,NULL,_binary '',_binary ''),(32,20,25,2,'2022-03-30 06:00:00',6,NULL,'1234','qwer',NULL,NULL,NULL,_binary '',NULL);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostic_reports`
--

DROP TABLE IF EXISTS `diagnostic_reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostic_reports` (
  `diagnostic_report_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `patient` int DEFAULT NULL,
  `radiologist` int DEFAULT NULL,
  `diagnostic` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`diagnostic_report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostic_reports`
--

LOCK TABLES `diagnostic_reports` WRITE;
/*!40000 ALTER TABLE `diagnostic_reports` DISABLE KEYS */;
INSERT INTO `diagnostic_reports` VALUES (20,18,19,18,'DOne'),(21,18,NULL,6,'dfsgdh'),(22,19,19,18,'Brain Looks Good'),(23,21,20,18,'sgse'),(24,24,19,1,'Aids');
/*!40000 ALTER TABLE `diagnostic_reports` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_uploads`
--

LOCK TABLES `file_uploads` WRITE;
/*!40000 ALTER TABLE `file_uploads` DISABLE KEYS */;
INSERT INTO `file_uploads` VALUES (49,18,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(50,19,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(51,20,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(52,21,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(53,22,'RIS_33.jpg','jpg',_binary '','C:UsersSchool AccountDownloadsRIS_33.jpg'),(54,23,'RIS_33.jpg','jpg',_binary '','C:\\Users\\School Account\\Downloads\\RIS_33.jpg'),(55,24,'salimi_what.png','png',_binary '','C:\\Users\\School Account\\Downloads\\salimi_what.png');
/*!40000 ALTER TABLE `file_uploads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imaging_info`
--

DROP TABLE IF EXISTS `imaging_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imaging_info` (
  `imaging_id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `imaging` bigint DEFAULT NULL,
  `modality` bigint DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `patient` bigint DEFAULT NULL,
  `technician` bigint DEFAULT NULL,
  PRIMARY KEY (`imaging_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imaging_info`
--

LOCK TABLES `imaging_info` WRITE;
/*!40000 ALTER TABLE `imaging_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `imaging_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalities`
--

DROP TABLE IF EXISTS `modalities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalities` (
  `modality_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`modality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalities`
--

LOCK TABLES `modalities` WRITE;
/*!40000 ALTER TABLE `modalities` DISABLE KEYS */;
INSERT INTO `modalities` VALUES (1,'X-ray','1500'),(2,'MRI','2000'),(3,'Ultrasound','1000'),(4,'CT','3000'),(5,'PET ','2000'),(6,'PET-MRI','2500'),(7,'Fluoroscopy','1000');
/*!40000 ALTER TABLE `modalities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status` (
  `order_status_id` int NOT NULL AUTO_INCREMENT,
  `order_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`order_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (1,'On Hold'),(2,'Closed'),(3,'Completed'),(4,'Not Completed');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (18,19,4,4,24,'Kill this bitch',4,1),(19,19,4,6,25,'Brain Scan',4,1),(20,19,4,3,28,'qwerqwe',1,NULL),(21,20,4,4,27,'wqefwqe',2,1),(22,19,4,3,29,'efwwq',2,NULL),(23,20,4,1,30,'1234',3,NULL),(24,19,4,1,31,'asdf',2,1),(25,20,4,2,32,'4234',2,NULL),(26,21,4,2,NULL,'qwerqewr',2,NULL),(27,81,4,2,NULL,'adfadsf',2,NULL),(28,82,4,1,NULL,'dsfad',4,NULL),(29,83,4,1,NULL,'dfwq',4,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (19,'Betty','White','1979-04-01','Female','White','Not Hispanic or Latino'),(20,'qwer','qwer','2022-03-24','Female','African American','Hispanic or Latino'),(21,'1234','1234','2022-03-17','Female','White','Not Hispanic or Latino'),(22,'1324','1324','2022-03-17','Female','American Indian','Not Hispanic or Latino'),(23,'1234','1324','2022-03-17','Female','African American','Not Hispanic or Latino'),(24,'3241234','12341324','2022-03-04','Other','American Indian','Hispanic or Latino'),(25,'aadsfa','af','2022-03-02','Other','White','Hispanic or Latino'),(26,'SD','ASDF','2022-03-23','Female','White','Not Hispanic or Latino'),(27,'asdf','asdfasdf','2022-03-10','Female','White','Not Hispanic or Latino'),(28,'asdf','asdfasdf','2022-03-10','Female','White','Not Hispanic or Latino'),(29,'asdfadf','asdfadfss','2022-03-23','Female','African American','Hispanic or Latino'),(30,'adfaf','adsfasfasd','2022-03-10','Female','White','Not Hispanic or Latino'),(31,'asdfads','asdfasfd','2022-03-04','Other','African American','Not Hispanic or Latino'),(32,'asdfadfs','adfsasdf','2022-03-10','Female','African American','Hispanic or Latino'),(33,'asdfasdf','adsfadsf','2022-03-17','Male','African American','Hispanic or Latino'),(34,'pop','tart','2022-03-13','Female','African American','Not Hispanic or Latino'),(35,'tartty','popcicle','2022-03-28','Female','African American','Hispanic or Latino'),(36,'yesterday','griffin','2022-03-31','Female','African American','Not Hispanic or Latino'),(37,'asdfasdf','asdfdsfa','2022-03-14','Other','African American','Not Hispanic or Latino'),(38,'afgsfdg','adfafds','2022-03-03','Other','African American','Hispanic or Latino'),(39,'asdfadsf','asdfasdf','2022-03-09','Other','American Indian','Not Hispanic or Latino'),(40,'asdfasfd','afsdasfd','2022-03-04','Female','White','Not Hispanic or Latino'),(41,'Tom','And Jerry','2022-03-24','Male','White','Not Hispanic or Latino'),(42,'Adam','Sandler','2022-03-25','Female','African American','Hispanic or Latino'),(43,'asdfsdf','asdfasfd','2022-03-10','Female','African American','Not Hispanic or Latino'),(44,'asdfasdf','adsfadsf','2022-03-15','Female','African American','Not Hispanic or Latino'),(45,'asdfasdf','adsfadsf','2022-03-15','Female','African American','Not Hispanic or Latino'),(46,'asdfasdf','afdasfd','2022-03-07','Male','White','Not Hispanic or Latino'),(47,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(48,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(49,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(50,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(51,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(52,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(53,'John','Williams','2022-03-09','Female','African American','Hispanic or Latino'),(54,'asdf','asdf','2022-03-03','Female','American Indian','Hispanic or Latino'),(55,'asdfaasd','fasdfas','2022-03-15','Female','African American','Not Hispanic or Latino'),(56,'fasdff','asdfasdf','2022-03-23','Male','White','Not Hispanic or Latino'),(57,'fqwef','dfqw','2022-03-15','Male','African American','Not Hispanic or Latino'),(58,'sdfadsf','asdfasdf','2022-03-17','Female','Asian','Not Hispanic or Latino'),(59,'asefadf','asdfasdf','2022-03-16','Male','African American','Not Hispanic or Latino'),(60,'dsafadsf','asdfasdf','2022-03-10','Female','American Indian','Not Hispanic or Latino'),(61,'sadfsadf','asdfasfd','2022-03-22','Female','American Indian','Hispanic or Latino'),(62,'sadfsadf','asdfasfd','2022-03-22','Female','American Indian','Hispanic or Latino'),(63,'asdfasf','adsfasfd','2022-03-02','Male','African American','Hispanic or Latino'),(64,'fasdf','adsfasdf','2022-03-03','Female','African American','Hispanic or Latino'),(65,'asfasa','asdfasdf','2022-03-16','Female','American Indian','Not Hispanic or Latino'),(66,'adsfasdf','adfsasd','2022-03-14','Other','African American','Not Hispanic or Latino'),(67,'adsfasdf','adfsasd','2022-03-14','Other','African American','Not Hispanic or Latino'),(68,'asdfasdf','asdffdas','2022-03-08','Female','African American','Not Hispanic or Latino'),(69,'fgsdfg','dfasgsfdg','2022-03-09','Female','African American','Not Hispanic or Latino'),(70,'asdfdsaf','asdfadsf','2022-03-03','Other','American Indian','Hispanic or Latino'),(71,'adfdsf','adsfadsf','2022-03-09','Other','African American','Hispanic or Latino'),(72,'dfadsf','asdffads','2022-03-16','Female','African American','Hispanic or Latino'),(73,'asfdas','afsasdf','2022-03-10','Female','African American','Hispanic or Latino'),(74,'asdfadsf','asdfdasf','2022-03-03','Female','African American','Hispanic or Latino'),(75,'sadfgasdf','asdfasdf','2022-03-16','Other','African American','Not Hispanic or Latino'),(76,'asdfasd','fasdf','2022-03-03','Female','White','Hispanic or Latino'),(77,'asdfasdf','asdfasdf','2022-03-02','Female','African American','Not Hispanic or Latino'),(78,'asfadsf','adsfdasf','2022-03-09','Female','White','Not Hispanic or Latino'),(79,'adsfaf','dsasdfasdf','2022-03-09','Other','African American','Hispanic or Latino'),(80,'asdffdaf','asdfsfd','2022-03-02','Female','African American','Hispanic or Latino'),(81,'Saddie','Smith','2022-03-22','Female','White','Hispanic or Latino'),(82,'John','Michleson','2022-03-10','Female','American Indian','Hispanic or Latino'),(83,'Abraham','Lincoln','2022-03-09','Female','African American','Not Hispanic or Latino');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients_alerts`
--

LOCK TABLES `patients_alerts` WRITE;
/*!40000 ALTER TABLE `patients_alerts` DISABLE KEYS */;
INSERT INTO `patients_alerts` VALUES (19,30,5,0),(20,30,5,0),(21,31,5,0),(22,31,5,0),(23,31,5,0),(24,31,5,0),(25,31,5,0),(26,32,5,0),(27,32,5,0),(28,32,5,0),(29,37,5,0),(30,45,5,0),(31,54,5,0),(32,55,5,0),(33,55,5,0),(34,55,5,0),(35,59,5,0),(36,59,5,0),(37,59,5,0),(38,59,5,0),(39,68,5,0),(40,68,5,0),(41,68,5,0),(42,68,5,0),(43,68,5,0),(44,71,5,0),(45,71,5,0),(46,71,5,0),(47,71,5,0),(48,74,5,0),(49,74,5,0),(50,74,5,0),(51,74,5,0),(52,78,5,0),(53,78,5,0),(54,78,5,0),(55,83,5,0),(56,83,5,0),(57,83,5,0),(58,83,5,0);
/*!40000 ALTER TABLE `patients_alerts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radiologists`
--

DROP TABLE IF EXISTS `radiologists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radiologists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `radiologists_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radiologists`
--

LOCK TABLES `radiologists` WRITE;
/*!40000 ALTER TABLE `radiologists` DISABLE KEYS */;
INSERT INTO `radiologists` VALUES (6,'Radio',18);
/*!40000 ALTER TABLE `radiologists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referralmds`
--

DROP TABLE IF EXISTS `referralmds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referralmds` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `referralmds_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referralmds`
--

LOCK TABLES `referralmds` WRITE;
/*!40000 ALTER TABLE `referralmds` DISABLE KEYS */;
INSERT INTO `referralmds` VALUES (4,'Doctor',16);
/*!40000 ALTER TABLE `referralmds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'USER'),(3,'REFERRAL_DOCTOR'),(4,'RECEPTIONIST'),(5,'TECHNICIAN'),(6,'RADIOLOGIST');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@example.com','test admin','admin','admin',1),(16,'Doc','Doctor','doc','doc',NULL),(17,'desk','DESKLADY','desk','desk',NULL),(18,'Radi','Radio','radio','radio',NULL),(21,'user','user','user','user',NULL),(22,'tech','tech','tech','tech',NULL),(29,'TECHghgwge','TECH','TECH','TECH',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1,1),(16,3,112),(17,4,113),(18,6,114),(21,2,115),(22,5,116),(29,5,117);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-31 18:27:12
