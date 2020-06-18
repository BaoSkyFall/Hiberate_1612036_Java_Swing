-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: f2l.ctgwpvncwnsg.us-east-1.rds.amazonaws.com    Database: hiberate
-- ------------------------------------------------------
-- Server version	8.0.11

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `id_class` int(11) NOT NULL AUTO_INCREMENT,
  `name_class` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grades` (
  `id_user` int(11) DEFAULT NULL,
  `midterm_grade` int(11) DEFAULT NULL,
  `other_grade` int(11) DEFAULT NULL,
  `final_grade` int(11) DEFAULT NULL,
  `average_grade` int(11) DEFAULT NULL,
  `isReExamination` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `re_examinations`
--

DROP TABLE IF EXISTS `re_examinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `re_examinations` (
  `id_reExamination` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` varchar(45) DEFAULT NULL,
  `type_grade` int(11) DEFAULT NULL,
  `expect_grade` int(11) DEFAULT NULL,
  `reason` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_reExamination`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `re_examinations`
--

LOCK TABLES `re_examinations` WRITE;
/*!40000 ALTER TABLE `re_examinations` DISABLE KEYS */;
/*!40000 ALTER TABLE `re_examinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id_subject` int(11) NOT NULL AUTO_INCREMENT,
  `code_subject` varchar(45) DEFAULT NULL,
  `name_subject` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `room` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isStudent` tinyint(4) NOT NULL,
  `name` varchar(155) NOT NULL,
  `indentity_number` varchar(45) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `indentity_student` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1612036','1612036',1,'Quốc Bảo','025935889',0,'1612036'),(2,'giaovu','giaovu',0,'Hồ Tuấn Thanh','025999999',0,'9999999'),(3,'1612041','1612041',1,'Phan Hải Bình','155351184',0,'1612041'),(4,'1612787','1612787',1,'Nguyễn Thanh Tuấn','856718734',0,'1612787'),(5,'1612112','1612112',1,'Lê Minh Đức','194158170',0,'1612112'),(6,'1612561','1612561',1,'Lâm Hửu Tiền','551403793',0,'1612561'),(7,'1612074','1612074',1,'Nguyễn Hoàng Chương','396486106',0,'1612074'),(8,'1612572','1612572',1,'Võ Duy Thanh','573686193',1,'1612572'),(9,'1612291','1612291',1,'Nguyễn Đức Bảo Sơn','177345227',1,'1612291'),(10,'1512080','1512080',1,'Lê Trung Phong','405508088',1,'1512080'),(11,'1612187','1612187',1,'Nguyễn Hoàng Sang','299645343',1,'1612187'),(12,'1612745','1612745',1,'Nguyễn Trương Quang','447560864',1,'1612745'),(13,'1612715','1612715',1,'Lê Quốc Duy Quang','439301932',1,'1612715'),(14,'1612582','1612582',1,'Phùng Trí Cường','403584682',0,'1612582'),(15,'1612392','1612392',1,'Lê Đình Ngọc','612166808',0,'1612392'),(16,'1612209','1612209',1,'Phạm Đình Sỹ','873656165',0,'1612209'),(17,'1612670','1612670',1,'Nguyễn Thị Ngân Khánh','884330045',0,'1612670'),(18,'1612785','1612785',1,'Lưu Tuấn Nguyên','117510772',1,'1612785'),(19,'1612037','1612037',1,'Dương Văn Khang','663043789',1,'1612037'),(20,'1612434','1612434',1,'Nguyễn Thanh Hậu','545108600',1,'1612434'),(21,'1612580','1612580',1,'Lâm Đức Tài','025987632',1,'1612580');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hiberate'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-18 18:09:23
