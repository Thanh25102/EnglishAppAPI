-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: LEARN_ENGLISH_APP
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.22.04.1

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
-- Table structure for table `account`
--
use heroku_1dd347ddf98eafc;

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'manhthanh','Thanh25102','BUi Manh THanh','manhthanh147@gmail.com'),(2,'manhthanh','Thanh25102','BUi Manh THanh','manhthanh147@gmail.com'),(3,'manhthanh147','$2a$12$dhFpzfV9KJXvQvT/vVK3wuDNeLdxic4H6wqyhiWHcaT68363kUEIW','Bui Manh Thanh','manhthanh147@gmail.com');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_detail`
--

DROP TABLE IF EXISTS `account_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `vocabulary_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `vocabulary_id` (`vocabulary_id`),
  CONSTRAINT `account_detail_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `account_detail_ibfk_2` FOREIGN KEY (`vocabulary_id`) REFERENCES `vocabulary` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_detail`
--

LOCK TABLES `account_detail` WRITE;
/*!40000 ALTER TABLE `account_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_rank`
--

DROP TABLE IF EXISTS `account_rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_rank` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `rank_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `rank_id` (`rank_id`),
  CONSTRAINT `account_rank_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `account_rank_ibfk_2` FOREIGN KEY (`rank_id`) REFERENCES `tbl_rank` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_rank`
--

LOCK TABLES `account_rank` WRITE;
/*!40000 ALTER TABLE `account_rank` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_topic`
--

DROP TABLE IF EXISTS `account_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_topic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `topic_id` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `topic_id` (`topic_id`),
  CONSTRAINT `account_topic_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `account_topic_ibfk_2` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_topic`
--

LOCK TABLES `account_topic` WRITE;
/*!40000 ALTER TABLE `account_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesson` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `target` varchar(255) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'Toeic 100','Thành thạo 1000 từ toeic','This is description t'),(2,'Ielt 100','Thành thạo 1000 từ ielt','This is description i'),(3,'Simple 100','Thành thạo 1000 từ simple','This is description s');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_rank`
--

DROP TABLE IF EXISTS `tbl_rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_rank` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `repersent` varchar(255) DEFAULT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_rank`
--

LOCK TABLES `tbl_rank` WRITE;
/*!40000 ALTER TABLE `tbl_rank` DISABLE KEYS */;
INSERT INTO `tbl_rank` VALUES (1,'Học 12 ngày liên tiếp','Bạn đã học 12 ngày','lt.png','Thanhtuu'),(2,'Học 13 ngày liên tiếp','Bạn đã học 13 ngày','lt.png','Thanhtuu'),(3,'Học 13 ngày liên tiếp','Bạn đã học 13 ngày','lt.png','Thanhtuu'),(4,'Học 15 ngày liên tiếp','Bạn đã học 15 ngày','lt.png','Thanhtuu');
/*!40000 ALTER TABLE `tbl_rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `represent` varchar(255) NOT NULL,
  `description` varchar(225) NOT NULL,
  `descriptive_meaning` varchar(255) NOT NULL,
  `lesson_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lesson_id` (`lesson_id`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'topic.png','This is topic from toeic 100 part1','Topic này thuộc về toeic 100 p1',1),(2,'tolo2.png','This is tol2o from toeic 100 part1','tolo này thuộc về toeic 100 p1',1);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vocabulary`
--

DROP TABLE IF EXISTS `vocabulary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vocabulary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vocabulary` varchar(100) NOT NULL,
  `phonetic` varchar(100) NOT NULL,
  `mean` varchar(100) NOT NULL,
  `audio` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `example_sentences` varchar(255) NOT NULL,
  `meaning_exp` varchar(255) NOT NULL,
  `topic_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_id` (`topic_id`),
  CONSTRAINT `vocabulary_ibfk_1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vocabulary`
--

LOCK TABLES `vocabulary` WRITE;
/*!40000 ALTER TABLE `vocabulary` DISABLE KEYS */;
INSERT INTO `vocabulary` VALUES (1,'Dog','dpg','Chó','concho.mp3','concho.png','This is a dog','Đây là con chó',1),(2,'Cat','kat','Mèo','conmeo.mp3','conmeo.png','This is a cat','Đây là con mèo',1),(3,'Pig','big','Heo','conheo.mp3','conheo.png','This is a heo','Đây là con heo',1);
/*!40000 ALTER TABLE `vocabulary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-22 19:45:24
