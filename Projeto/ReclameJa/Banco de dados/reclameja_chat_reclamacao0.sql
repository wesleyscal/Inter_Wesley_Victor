CREATE DATABASE  IF NOT EXISTS `reclameja` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `reclameja`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: reclameja
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `chat_reclamacao`
--

DROP TABLE IF EXISTS `chat_reclamacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat_reclamacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Mensagem` varchar(2000) NOT NULL,
  `Data_Envio` datetime NOT NULL,
  `id_Reclamacao` int NOT NULL,
  `Responsavel` varchar(13) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_reclamacao_idx` (`id_Reclamacao`),
  CONSTRAINT `id_reclamacao` FOREIGN KEY (`id_Reclamacao`) REFERENCES `reclamacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_reclamacao`
--

LOCK TABLES `chat_reclamacao` WRITE;
/*!40000 ALTER TABLE `chat_reclamacao` DISABLE KEYS */;
INSERT INTO `chat_reclamacao` VALUES (1,'Ola estou com problema','2021-11-11 11:02:35',1,'Consumidor'),(2,'Vi que seu problema e o fogao amaçado, logo te mandaremos um de subistituição','2021-11-11 11:05:50',1,'Empresa'),(3,'Ok Obrigada','2021-11-11 12:35:21',1,'Consumidor'),(4,'Ola eu gostaria de viajar','2021-10-09 12:25:33',2,'Consumidor'),(8,'Ok,vamos resolver isso para você, Fique de olho em seu email !','2021-10-17 00:00:00',2,'Empressa');
/*!40000 ALTER TABLE `chat_reclamacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 19:11:31