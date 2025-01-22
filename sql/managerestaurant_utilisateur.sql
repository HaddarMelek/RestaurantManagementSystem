CREATE DATABASE  IF NOT EXISTS `managerestaurant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `managerestaurant`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: managerestaurant
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `motDePasse` varchar(50) DEFAULT NULL,
  `nomComplet` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'ahr','123','ayehaddar','14785236','ayer@gmail.com',1),(2,'mèlèk','456','MèlèkHaddar','26379765','haddarmalek@isimg.tn',1),(3,'mmb','123','mohamed','21007586','mouhammed@gmail.com',3),(4,'ohr','123','oumayma','21653246','haddaroumay8@gmail.com',2),(5,'nour','456','nouran','02148785','nouran@gmail.com',1),(6,'malak','415','malak','65465748','malak@gmail.com',3),(7,'maha','211','mahamaha','15984622','maha@gmail.com',2),(8,'ayadya','007','hdrAyadya','25369741','ayd@gmail.com',3),(9,'tesnim','power','tasnimTASNIM','24015780','tasnim@gmail.com',2),(10,'salem','password@','salemSALEM','21200500','salem@gmail.com',3),(11,'hdrayd','password','haddarAyadya','27882736','haddarayadya@gmail.com',2),(12,'saleh','pass%','salahHaddar','25007264','haddarmalek23@gmail.com',1),(13,'aymen','java','aymen@@','97850468','aymen@gmail.com',1),(14,'najib','95@@','najib@@','25009142','najib@gmail.com',1),(15,'kamel','uh','kamel@@','66546876','kamel@gmail.com',1),(16,'hdr','hdr','haddar','21548769','haddar.hdr@gmail.com',1),(17,'maloukahdr','pass','malouka','216216216','molka@gmail.com',1);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-12 18:09:01
