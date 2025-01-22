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
-- Table structure for table `plat`
--

DROP TABLE IF EXISTS `plat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prix` decimal(8,2) DEFAULT NULL,
  `notes` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plat`
--

LOCK TABLES `plat` WRITE;
/*!40000 ALTER TABLE `plat` DISABLE KEYS */;
INSERT INTO `plat` VALUES (1,'napolitaine',25.25,NULL),(2,'chicago',19.75,NULL),(3,'détroit',26.00,NULL),(4,'italienne',30.00,NULL),(5,'neptune',10.00,NULL),(6,'escalope',13.00,NULL),(7,'couscous avec des legumes et pois chiche',5.50,'plus des legumes'),(8,'couscous avec viandes',18.00,NULL),(9,'couscous au poisson',17.50,NULL),(10,'couscous avec tajine',14.50,NULL),(11,'chocolat chaud',10.50,NULL),(12,'chocolat pancackes',12.50,NULL),(16,'gateau roler',10.50,NULL),(17,'petit dej complet',10.00,NULL),(18,'croissant au chocolat',12.00,NULL),(19,'croissant au beurre',18.00,NULL),(20,'crèpe',14.00,'chocolat'),(21,'céréales',11.00,NULL),(22,'porridge',5.00,NULL),(23,'yaourt & fruits ',6.00,NULL),(24,'oeufs nénédicts',10.00,NULL),(25,'gaufres',13.00,NULL),(26,'avocado toast',14.00,NULL),(27,'bagels',12.00,NULL),(28,'omlettes',11.00,NULL),(29,'petits pains au lait ',27.00,NULL),(30,'petits pains au chocolat',25.00,NULL),(31,'sandwiche',26.00,'escalope'),(32,'salade',23.00,NULL),(33,'sandwiche',4.80,'thon'),(34,'soupe',2.60,'viande'),(35,'soupe ',3.50,'poisson'),(36,'plat de pàtes ',2.50,'avec sauce tomate'),(37,'plat végétarien',14.00,NULL),(38,'quiches',16.00,NULL),(39,'plat de poisson ',11.00,NULL),(40,'steaks',17.00,NULL),(41,'poissons grillés',11.00,NULL),(42,'plat de fruit de mer',1.00,NULL),(43,'plat de viande',12.00,NULL),(44,'ragouts',14.00,NULL),(45,'légumes rotis',16.00,NULL),(46,'viande rotis',12.00,NULL),(47,'tarte au pommes',8.00,NULL),(48,'crème brulée',7.00,NULL),(49,'tiramisu',3.00,NULL),(50,'panna cotta',2.00,NULL),(51,'mousse au chocolat ',4.00,NULL),(52,'brownie',7.00,NULL),(53,'flan',9.00,NULL),(54,'biscuit',9.00,NULL),(55,'sablès',8.50,NULL),(56,'madeleine',4.50,NULL),(57,'eau',1.50,NULL),(58,'jus de fruits',4.50,NULL),(59,'limonade',2.50,NULL),(60,'thé',1.00,NULL),(61,'café',1.00,NULL),(62,'lait',1.00,NULL),(63,'coktail',2.00,NULL),(64,'lait d\'amande',7.00,NULL),(65,'lait de coco ',4.00,NULL),(67,'eau de coco ',7.00,NULL),(68,'boisson gazeuse',8.00,NULL),(69,'infusion',7.00,NULL),(70,'salade de riz ',25.00,NULL),(71,'salade de carrottes rapèés',32.00,NULL),(72,'salade de poulet ',12.00,NULL),(73,'salade de pates',21.00,NULL),(74,'salade de fruits de mer ',8.00,NULL),(75,'cheeseburger',7.00,NULL),(76,'hamburger',2.25,NULL),(77,'burger au poulet ',6.50,NULL),(78,'burger végétarien ',7.50,NULL),(79,'burger italien ',8.50,NULL);
/*!40000 ALTER TABLE `plat` ENABLE KEYS */;
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
