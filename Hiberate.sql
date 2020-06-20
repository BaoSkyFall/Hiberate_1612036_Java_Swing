-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hiberate
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `id_class` int NOT NULL AUTO_INCREMENT,
  `name_class` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_class`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'16CTT1'),(2,'17CTT1'),(3,'18CTT1'),(16,'﻿17HCB');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grades` (
  `id_user` int DEFAULT NULL,
  `midterm_grade` int DEFAULT NULL,
  `other_grade` int DEFAULT NULL,
  `final_grade` int DEFAULT NULL,
  `average_grade` int DEFAULT NULL,
  `isReExamination` tinyint DEFAULT NULL
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
-- Table structure for table `listsubjectclass`
--

DROP TABLE IF EXISTS `listsubjectclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listsubjectclass` (
  `id_listSubjectClass` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `code_subject` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_listSubjectClass`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listsubjectclass`
--

LOCK TABLES `listsubjectclass` WRITE;
/*!40000 ALTER TABLE `listsubjectclass` DISABLE KEYS */;
INSERT INTO `listsubjectclass` VALUES (78,43,'CTT031'),(79,44,'CTT031'),(80,45,'CTT031'),(81,46,'CTT031'),(85,43,'CTT032'),(86,44,'CTT032'),(88,46,'CTT032'),(89,47,'CTT032'),(92,43,'CTT033'),(93,44,'CTT033'),(94,45,'CTT033'),(96,47,'CTT033'),(99,43,'CTT034'),(100,44,'CTT034'),(102,46,'CTT034'),(103,47,'CTT034'),(106,43,'CTT035'),(108,45,'CTT035'),(110,47,'CTT035');
/*!40000 ALTER TABLE `listsubjectclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `re_examinations`
--

DROP TABLE IF EXISTS `re_examinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `re_examinations` (
  `id_reExamination` int NOT NULL AUTO_INCREMENT,
  `id_user` varchar(45) DEFAULT NULL,
  `type_grade` int DEFAULT NULL,
  `expect_grade` int DEFAULT NULL,
  `reason` text,
  `status` int DEFAULT NULL,
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
  `id_subject` int NOT NULL AUTO_INCREMENT,
  `code_subject` varchar(45) DEFAULT NULL,
  `name_subject` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `room` varchar(45) DEFAULT NULL,
  `id_class` int DEFAULT NULL,
  PRIMARY KEY (`id_subject`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'CTT011','Thiết kế giao diện','C32',1),(2,'CTT012','Kiểm chứng phần mềm','C32',1),(3,'CTT001','Lập trình ứng dụng Java','C31',2),(4,'CTT002','Mạng máy tính','C31',2),(5,'CTT003','Cấu trúc dữ liệu và giải thuật','C33',3),(22,'CTT031','Kiến trúc máy tính và hợp ngữ','E31',16),(23,'CTT032','Hệ điều hành','E32',16),(24,'CTT033','Lập trình Windows','E33',16),(25,'CTT034','Nhập môn công nghệ phần mềm','E34',16),(26,'CTT035','Nhập môn công nghệ phần mềm','E35',16);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isStudent` tinyint NOT NULL DEFAULT '1',
  `name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `indentity_number` varchar(45) DEFAULT NULL,
  `gender` tinyint DEFAULT NULL,
  `indentity_student` varchar(45) DEFAULT NULL,
  `id_class` int DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1612036','1612036',1,'Quốc Bảo','025935889',0,'1612036',2),(2,'giaovu','giaovu',0,'Hồ Tuấn Thanh','025999999',0,'9999999',NULL),(3,'1612041','1612041',1,'Phan Hải Bình','155351184',0,'1612041',2),(4,'1612787','1612787',1,'Nguyễn Thanh Tuấn','856718734',0,'1612787',1),(5,'1612112','1612112',1,'Lê Minh Đức','194158170',0,'1612112',1),(6,'1612561','1612561',1,'Lâm Hửu Tiền','551403793',0,'1612561',1),(7,'1612074','1612074',1,'Nguyễn Hoàng Chương','396486106',0,'1612074',1),(8,'1612572','1612572',1,'Võ Duy Thanh','573686193',1,'1612572',1),(9,'1612291','1612291',1,'Nguyễn Đức Bảo Sơn','177345227',1,'1612291',1),(10,'1512080','1512080',1,'Lê Trung Phong','405508088',1,'1512080',2),(11,'1612187','1612187',1,'Nguyễn Hoàng Sang','299645343',1,'1612187',2),(12,'1612745','1612745',1,'Nguyễn Trương Quang','447560864',1,'1612745',2),(13,'1612715','1612715',1,'Lê Quốc Duy Quang','439301932',1,'1612715',2),(14,'1612582','1612582',1,'Phùng Trí Cường','403584682',0,'1612582',2),(15,'1612392','1612392',1,'Lê Đình Ngọc','612166808',0,'1612392',2),(16,'1612209','1612209',1,'Phạm Đình Sỹ','873656165',0,'1612209',3),(17,'1612670','1612670',1,'Nguyễn Thị Ngân Khánh','884330045',0,'1612670',3),(18,'1612785','1612785',1,'Lưu Tuấn Nguyên','117510772',1,'1612785',3),(19,'1612037','1612037',1,'Dương Văn Khang','663043789',1,'1612037',3),(20,'1612434','1612434',1,'Nguyễn Thanh Hậu','545108600',1,'1612434',3),(21,'1612580','1612580',1,'Lâm Đức Tài','025987632',1,'1612580',2),(43,'1742001','1742001',1,'Nguyễn Văn A','123456789',0,'1742001',16),(44,'1742002','1742002',1,'Trần Văn B','123456790',0,'1742002',16),(45,'1742003','1742003',1,'Huỳnh Thị C','123456791',0,'1742003',16),(46,'1742004','1742004',1,'Mai Văn D','123456792',0,'1742004',16),(47,'1742005','1742005',1,'Hồ Thị E','123456793',0,'1742005',16);
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

-- Dump completed on 2020-06-20 18:29:14
