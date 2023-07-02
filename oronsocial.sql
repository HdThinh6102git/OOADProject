-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: oronsocial
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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'test2','2023-05-28 22:26:23','test2','2023-05-28 22:26:23','I want it',1,1,2),(2,'test2','2023-05-28 22:26:37','test2','2023-05-28 22:26:37','I want it so much',1,1,2),(3,'test2','2023-05-28 22:26:48','test2','2023-05-28 22:26:48','I want it h',1,2,2),(8,'test2','2023-05-29 09:30:49','test2','2023-05-29 09:30:49','Thank you teacher',1,10,2),(10,'test','2023-05-29 14:19:17','test','2023-05-29 14:19:17','hello',1,13,1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `display_scope` varchar(255) DEFAULT NULL,
  `number_reaction` int DEFAULT NULL,
  `pictures` varchar(2000) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK72mt33dhhs48hf9gcqrq4fxte` (`user_id`),
  CONSTRAINT `FK72mt33dhhs48hf9gcqrq4fxte` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'test','2023-05-26 16:15:36','anonymousUser','2023-05-28 20:12:36','Gobies fish','public',3,'https://upload.wikimedia.org/wikipedia/commons/3/31/Rhinogobius_sp._CB%28Hamamatsu%2CShizuoka%2CJapan%29.jpg',1,1),(2,'test2','2023-05-26 17:15:04','test2','2023-05-29 08:28:29','Chim khuyên','public',1,'https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Eopsaltria_australis_-_Mogo_Campground.jpg/640px-Eopsaltria_australis_-_Mogo_Campground.jpg',1,2),(3,'test2','2023-05-26 17:15:13','test2','2023-05-26 17:15:13','Chim sáo','public',0,'https://images.birdfact.com/production/starling_2021-03-09-151728.jpg?w=1200&h=900&q=80&fm=webp&fit=crop&crop=focalpoint&fp-x=0.5&fp-y=0.5&dm=1615303048&s=43851b96f07f939634a158008020e8ef',1,2),(4,'test2','2023-05-26 17:15:14','test2','2023-05-26 17:15:14','Chim cưỡng','public',0,'https://static01.nyt.com/images/2013/01/01/science/01OBBIRD_SPAN/01OBBIRD_SPAN-articleLarge-v2.jpg?quality=75&auto=webp&disable=upscale',1,2),(5,'test2','2023-05-26 17:15:16','test','2023-05-29 08:43:21','Chim đa đa','public',0,'https://images.pexels.com/photos/12000888/pexels-photo-12000888.jpeg?cs=srgb&dl=pexels-patrice-schoefolt-12000888.jpg&fm=jpg',1,2),(9,'test2','2023-05-27 13:46:44','test2','2023-05-27 13:46:44','Chim chào mào','public',0,'https://www.allaboutbirds.org/news/wp-content/uploads/2020/07/STanager-Shapiro-ML.jpg',1,2),(10,'test2','2023-05-27 13:49:20','test2','2023-05-27 13:49:20','Cá lia thia','public',0,'https://wikicacanh.com/wp-content/uploads/2022/10/ca-lia-thia-xiem.jpeg',1,1),(11,'test2','2023-05-27 13:49:31','test2','2023-05-29 08:27:58','Cá trầu','public',1,'https://1.bp.blogspot.com/-RK1_L5OknZc/W30SSu00pqI/AAAAAAAB2Jg/cB1SJlWJjGgPaeeEGazjJHdi04IWf1ozACLcBGAs/s1600/Ca%2Bloc.jpg',1,1),(12,'test','2023-05-27 14:23:17','test2','2023-05-29 08:27:52','Cá mú','public',3,'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Black_grouper2.jpg/800px-Black_grouper2.jpg',1,1),(13,'test','2023-05-27 14:23:32','test2','2023-05-29 08:38:12','Cá bò','public',4,'https://media.istockphoto.com/id/115746468/vi/anh/c%E1%BA%ADn-c%E1%BA%A3nh-m%E1%BB%99t-con-c%C3%A1-b%C3%B2-longhorn-d%C6%B0%E1%BB%9Bi-n%C6%B0%E1%BB%9Bc.jpg?s=612x612&w=0&k=20&c=vAs0kFBhGP5D1jjrWEfxbhylx6yqbo5czu4XpG_IZWM=',1,1);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnqmsp37ty5ls1kfjq0fyiyw0o` (`post_id`),
  KEY `FKlge7j322nfrl4e848e04511y3` (`user_id`),
  CONSTRAINT `FKlge7j322nfrl4e848e04511y3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKnqmsp37ty5ls1kfjq0fyiyw0o` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (12,'test2','2023-05-28 17:18:46','test2','2023-05-28 18:58:31',3,11,2),(31,'test','2023-05-29 08:42:25','test','2023-05-29 08:42:25',1,4,1),(33,'test2','2023-05-29 08:43:59','test2','2023-05-29 08:43:59',1,12,2),(34,'test2','2023-05-29 09:26:05','test2','2023-05-29 09:26:05',1,11,2),(37,'test2','2023-05-29 14:11:50','test2','2023-05-29 14:11:50',1,9,1);
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,NULL,NULL,'ADMIN','Admin'),(2,NULL,NULL,NULL,NULL,'USER','User');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `username` varchar(255) DEFAULT NULL,
  `cover_pic` varchar(255) DEFAULT NULL,
  `profile_pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'2023-05-06 15:26:59','user@gmail.com','2023-05-12 16:10:40','06 test','Dinh Thinh','test@gmail.com','test123','009164231',1,'test','https://images.unsplash.com/photo-1578985545062-69928b1d9587?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8NHx8fGVufDB8fHx8&w=1000&q=80','https://thumbs.dreamstime.com/z/icon-gentleman-image-presented-51918223.jpg'),(2,NULL,'2023-05-06 15:27:21','user@gmail.com','2023-05-12 16:11:26','06 test','Minh Nhat','test2@gmail.com','test123','009164231',1,'test2','https://images.pexels.com/photos/2607544/pexels-photo-2607544.jpeg?cs=srgb&dl=pexels-simona-kidri%C4%8D-2607544.jpg&fm=jpg','https://c8.alamy.com/comp/2JG2EJ2/500-best-handsome-boy-pictures-cute-stylish-boy-photos-download-beautiful-boy-stock-free-images-on-alamy-2JG2EJ2.jpg'),(3,NULL,'2023-05-06 15:27:34','user@gmail.com','2023-05-12 16:14:30','06 test','admin','admin@gmail.com','test123','009164231',1,'admin',NULL,NULL),(4,'anonymousUser','2023-05-29 13:48:25','anonymousUser','2023-05-29 13:48:25','19 district','Tam Nhu','tamnhu@gmail.com','test123','0903040201',1,'test4','https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Double-alaskan-rainbow.jpg/1200px-Double-alaskan-rainbow.jpg','https://kenh14cdn.com/thumb_w/640/pr/2022/photo1658478744850-1658478745126338382813-63794106863683.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,2),(2,2),(3,1),(4,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-02 21:32:28
