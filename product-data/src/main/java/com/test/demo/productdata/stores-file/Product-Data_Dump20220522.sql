-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: test_schema
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
-- Table structure for table `product_data`
--

DROP TABLE IF EXISTS `product_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_data` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `picture` text,
  `invalid_at` date DEFAULT NULL,
  `has_active` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_data`
--

LOCK TABLES `product_data` WRITE;
/*!40000 ALTER TABLE `product_data` DISABLE KEYS */;
INSERT INTO `product_data` VALUES (1,'produk satu',10,'gambar_satu.jpg','2023-05-20',1),(2,'produk dua',12,'gambar_dua.jpg','2023-05-21',1),(3,'produk tiga',30,'gambar_tiga.jpg','2023-05-21',1),(4,'produk empat',25,'gambar_empat.jpg','2023-05-21',1),(5,'produk lima',35,'gambar_lima.jpg','2023-05-21',0),(6,'produk lima',35,'gambar_lima.jpg','2023-05-21',1),(7,'produk tujuh',5,'gambar_tujuh.jpg','2023-05-21',1);
/*!40000 ALTER TABLE `product_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'test_schema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-22 13:38:56
