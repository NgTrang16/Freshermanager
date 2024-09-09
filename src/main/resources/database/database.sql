-- MySQL dump 10.13  Distrib 9.0.1, for macos13.6 (x86_64)
--
-- Host: 127.0.0.1    Database: FresherManager
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Assignment`
--

DROP TABLE IF EXISTS `Assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Assignment` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `score1` float DEFAULT NULL,
                              `score2` float DEFAULT NULL,
                              `score3` float DEFAULT NULL,
                              `name` varchar(150) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `UKjo2vugpt2bwm1dch9ub4a7rk2` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Assignment`
--

LOCK TABLES `Assignment` WRITE;
/*!40000 ALTER TABLE `Assignment` DISABLE KEYS */;
INSERT INTO `Assignment` VALUES (1,7,9,5,'Java Backend Development');
INSERT INTO `Assignment` VALUES (2,10,9,6,'Spring Boot REST API');
INSERT INTO `Assignment` VALUES (3,10,8,10,'Database Design');
INSERT INTO `Assignment` VALUES (4,6,7,10,'Microservices Architecture');
INSERT INTO `Assignment` VALUES (5,5,10,7,'Security Implementation');
INSERT INTO `Assignment` VALUES (6,10,6,7,'Unit Testing and TDD');
INSERT INTO `Assignment` VALUES (7,7,8,9,'OAuth2 Authentication');
INSERT INTO `Assignment` VALUES (8,7,10,6,'Docker and Kubernetes');
INSERT INTO `Assignment` VALUES (9,9,10,8,'CI/CD Pipeline');
INSERT INTO `Assignment` VALUES (10,9,10,5,'Logging and Monitoring');
INSERT INTO `Assignment` VALUES (11,10,5,8,'Cloud Integration');
INSERT INTO `Assignment` VALUES (12,8,6,7,'API Documentation with Swagger');
INSERT INTO `Assignment` VALUES (13,5,5,7,'Performance Optimization');
INSERT INTO `Assignment` VALUES (14,8,5,5,'Caching Strategies');
INSERT INTO `Assignment` VALUES (15,10,8,8,'GraphQL Integration');
INSERT INTO `Assignment` VALUES (16,8,8,5,'Event-Driven Architecture');
INSERT INTO `Assignment` VALUES (17,9,7,8,'Message Queue Implementation');
INSERT INTO `Assignment` VALUES (18,8,9,5,'WebSocket Communication');
INSERT INTO `Assignment` VALUES (19,6,7,7,'Version Control with Git');
INSERT INTO `Assignment` VALUES (20,10,5,10,'Refactoring Legacy Code');
/*!40000 ALTER TABLE `Assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Center`
--

DROP TABLE IF EXISTS `Center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Center` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `name` varchar(100) NOT NULL,
                          `address` varchar(150) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Center`
--

LOCK TABLES `Center` WRITE;
/*!40000 ALTER TABLE `Center` DISABLE KEYS */;
INSERT INTO `Center` VALUES (1,'VietTech IT Center','Số 1, Đường Láng Hạ, Quận Đống Đa, Hà Nội, Việt Nam');
INSERT INTO `Center` VALUES (2,'Saigon Tech Hub','Tầng 10, Tòa nhà Landmark 81, Quận Bình Thạnh, TP. Hồ Chí Minh, Việt Nam');
INSERT INTO `Center` VALUES (3,'Da Nang IT Innovation Center','Số 45, Đường Võ Văn Kiệt, Quận Sơn Trà, Đà Nẵng, Việt Nam');
INSERT INTO `Center` VALUES (4,'Can Tho Software Park','Số 123, Đường Nguyễn Văn Linh, Quận Ninh Kiều, Cần Thơ, Việt Nam');
INSERT INTO `Center` VALUES (5,'Hue Digital Learning Center','Số 7, Đường Lê Lợi, Thành phố Huế, Thừa Thiên Huế, Việt Nam');
INSERT INTO `Center` VALUES (6,'Bac Ninh Tech Center','Số 9, Đường Ngô Gia Tự, Thành phố Bắc Ninh, Bắc Ninh, Việt Nam');
INSERT INTO `Center` VALUES (7,'Hai Phong IT Park','Số 15, Đường Trần Hưng Đạo, Quận Hồng Bàng, Hải Phòng, Việt Nam');
INSERT INTO `Center` VALUES (8,'Vinh IT Center','Số 21, Đường Quang Trung, Thành phố Vinh, Nghệ An, Việt Nam');
INSERT INTO `Center` VALUES (9,'Quy Nhon Tech Center','Số 5, Đường Nguyễn Tất Thành, Thành phố Quy Nhơn, Bình Định, Việt Nam');
INSERT INTO `Center` VALUES (10,'Nha Trang Digital Hub','Số 8, Đường Trần Phú, Thành phố Nha Trang, Khánh Hòa, Việt Nam');
/*!40000 ALTER TABLE `Center` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Center_fresher`
--

DROP TABLE IF EXISTS `Center_fresher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Center_fresher` (
                                  `Center_id` bigint NOT NULL,
                                  `fresher_id` bigint NOT NULL,
                                  UNIQUE KEY `UK7xpoellbtmrjsfoojic8an7i7` (`fresher_id`),
                                  KEY `FKj7xtxwtqqrqa02ybsbi9gtfkf` (`Center_id`),
                                  CONSTRAINT `FKj7xtxwtqqrqa02ybsbi9gtfkf` FOREIGN KEY (`Center_id`) REFERENCES `Center` (`id`),
                                  CONSTRAINT `FKr89qexeyhinbx898rkr1ae513` FOREIGN KEY (`fresher_id`) REFERENCES `Fresher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Center_fresher`
--

LOCK TABLES `Center_fresher` WRITE;
/*!40000 ALTER TABLE `Center_fresher` DISABLE KEYS */;
INSERT INTO `Center_fresher` VALUES (5,2);
INSERT INTO `Center_fresher` VALUES (5,4);
/*!40000 ALTER TABLE `Center_fresher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fresher`
--

DROP TABLE IF EXISTS `Fresher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Fresher` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(100) NOT NULL,
                           `email` varchar(100) NOT NULL,
                           `programming_language` varchar(50) DEFAULT NULL,
                           `center_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `UK94r49u3mu6nx01ig3dbkm7ac0` (`email`),
                           UNIQUE KEY `UK7gmi1tux6vtq1uqn2xxg1kxfn` (`name`),
                           KEY `FKsyin3xwpex43d7wxsfmtnyce6` (`center_id`),
                           CONSTRAINT `FKsyin3xwpex43d7wxsfmtnyce6` FOREIGN KEY (`center_id`) REFERENCES `Center` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fresher`
--

LOCK TABLES `Fresher` WRITE;
/*!40000 ALTER TABLE `Fresher` DISABLE KEYS */;
INSERT INTO `Fresher` VALUES (2,'Trần Thị Bích','tranthibich@gmail.com','Java',1);
INSERT INTO `Fresher` VALUES (3,'Lê Văn Cường','levancuong@gmail.com','Java',3);
INSERT INTO `Fresher` VALUES (4,'Phạm Thị Dung','phamthidung@gmail.com','C#',3);
INSERT INTO `Fresher` VALUES (5,'Hoàng Văn Đồng','hoangvandong@gmail.com','Python',NULL);
INSERT INTO `Fresher` VALUES (7,'Bùi Thị Hoa','buithihoa@gmail.com','C',NULL);
INSERT INTO `Fresher` VALUES (8,'Trần Thị Lan','tranthilan@gmail.com','C++',NULL);
INSERT INTO `Fresher` VALUES (9,'Lê Văn Hùng','levanhung@gmail.com','C',NULL);
INSERT INTO `Fresher` VALUES (10,'Nguyễn Văn Tùng','tung@gmail.com','C',NULL);
INSERT INTO `Fresher` VALUES (11,'Phạm Văn Khải','phamvankhai@gmail.com','JavaScipt',NULL);
INSERT INTO `Fresher` VALUES (12,'Nguyễn Thị Mai','nguyenthimai@gmail.com','Python',NULL);
INSERT INTO `Fresher` VALUES (13,'Trần Văn Bình','tranvanbinh@gmail.com','Java',NULL);
INSERT INTO `Fresher` VALUES (14,'Lê Thị Thu','lethithu@gmail.com','C++',NULL);
INSERT INTO `Fresher` VALUES (15,'Ngô Văn Đức','ngovanduc@gmail.com','C#',NULL);
INSERT INTO `Fresher` VALUES (16,'Trịnh Thị Yến','trinhthiyen@gmail.com','Swift',NULL);
INSERT INTO `Fresher` VALUES (17,'Đỗ Văn Khoa','dovankhoa@gmail.com','PHP',NULL);
INSERT INTO `Fresher` VALUES (18,'Phan Thị Phương','phanthiphuong@gmail.com','Go',NULL);
INSERT INTO `Fresher` VALUES (19,'Vũ Văn Minh','vuvanminh@gmail.com','Kotlin',NULL);
INSERT INTO `Fresher` VALUES (20,'Lê Thị Hiền','lethihien@gmail.com','JavaScript',NULL);
/*!40000 ALTER TABLE `Fresher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fresher_assignment`
--

DROP TABLE IF EXISTS `fresher_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fresher_assignment` (
                                      `fresher_id` bigint NOT NULL,
                                      `assignment_id` bigint NOT NULL,
                                      PRIMARY KEY (`fresher_id`,`assignment_id`),
                                      KEY `FKp019ptdw1hjhn87nay4mgy1ru` (`assignment_id`),
                                      CONSTRAINT `FKjn046j5600yp76x81d1fphrp0` FOREIGN KEY (`fresher_id`) REFERENCES `Fresher` (`id`),
                                      CONSTRAINT `FKp019ptdw1hjhn87nay4mgy1ru` FOREIGN KEY (`assignment_id`) REFERENCES `Assignment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fresher_assignment`
--

LOCK TABLES `fresher_assignment` WRITE;
/*!40000 ALTER TABLE `fresher_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `fresher_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fresher_project`
--

DROP TABLE IF EXISTS `fresher_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fresher_project` (
                                   `fresher_id` bigint NOT NULL,
                                   `project_id` bigint NOT NULL,
                                   PRIMARY KEY (`fresher_id`,`project_id`),
                                   KEY `FKbytu3w15fj7xne8t49a41t87m` (`project_id`),
                                   CONSTRAINT `FK509mtu57en4y2uqxg93ml3ra7` FOREIGN KEY (`fresher_id`) REFERENCES `Fresher` (`id`),
                                   CONSTRAINT `FKbytu3w15fj7xne8t49a41t87m` FOREIGN KEY (`project_id`) REFERENCES `Project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fresher_project`
--

LOCK TABLES `fresher_project` WRITE;
/*!40000 ALTER TABLE `fresher_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `fresher_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Project`
--

DROP TABLE IF EXISTS `Project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Project` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `endDate` date DEFAULT NULL,
                           `Manager` varchar(100) NOT NULL,
                           `name` varchar(100) NOT NULL,
                           `programingLanguage` varchar(50) DEFAULT NULL,
                           `startDate` date DEFAULT NULL,
                           `status` varchar(50) DEFAULT NULL,
                           `center_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FKo8lgrntmi75cvwnxvmnou302y` (`center_id`),
                           CONSTRAINT `FKo8lgrntmi75cvwnxvmnou302y` FOREIGN KEY (`center_id`) REFERENCES `Center` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Project`
--

LOCK TABLES `Project` WRITE;
/*!40000 ALTER TABLE `Project` DISABLE KEYS */;
INSERT INTO `Project` VALUES (1,'2023-06-15','Nguyễn Văn An','Project Alpha','Java','2023-01-15','Completed',3);
INSERT INTO `Project` VALUES (2,'2023-07-30','Trần Thị Bích','Project Beta','Python','2023-03-01','In Progress',4);
INSERT INTO `Project` VALUES (3,'2023-08-20','Lê Văn Cường','Project Gamma','C#','2023-02-20','Completed',1);
INSERT INTO `Project` VALUES (4,'2023-10-10','Phạm Thị Dung','Project Delta','JavaScript','2023-04-10','In Progress',5);
INSERT INTO `Project` VALUES (5,'2023-12-15','Hoàng Văn Đồng','Project Epsilon','C++','2023-05-15','Pending',5);
INSERT INTO `Project` VALUES (6,'2023-11-01','Nguyễn Văn An','Project Zeta','Ruby','2023-06-01','Completed',6);
INSERT INTO `Project` VALUES (7,'2023-12-15','Bùi Thị Hoa','Project Eta','PHP','2023-07-15','In Progress',7);
INSERT INTO `Project` VALUES (8,'2024-01-01','Trần Thị Lan','Project Theta','Java','2023-08-01','Pending',3);
INSERT INTO `Project` VALUES (9,'2024-03-15','Lê Văn Hùng','Project Iota','C#','2023-09-15','In Progress',3);
INSERT INTO `Project` VALUES (10,'2024-04-01','Nguyễn Văn Tùng','Project Kappa','Python','2023-10-01','Pending',9);
INSERT INTO `Project` VALUES (11,'2024-05-15','Nguyễn Văn An','Project Lambda','Java','2023-11-15','In Progress',8);
INSERT INTO `Project` VALUES (12,'2024-06-01','Trần Thị Bích','Project Mu','JavaScript','2023-12-01','Completed',8);
INSERT INTO `Project` VALUES (13,'2024-07-15','Lê Văn Cường','Project Nu','C++','2024-01-15','Pending',6);
INSERT INTO `Project` VALUES (14,'2024-08-01','Phạm Thị Dung','Project Xi','Ruby','2024-02-01','In Progress',6);
INSERT INTO `Project` VALUES (15,'2024-09-15','Hoàng Văn Đồng','Project Omicron','PHP','2024-03-15','Completed',6);
INSERT INTO `Project` VALUES (16,'2024-10-01','Bùi Thị Hoa','Project Pi','Java','2024-04-01','In Progress',5);
INSERT INTO `Project` VALUES (17,'2024-11-15','Trần Thị Lan','Project Rho','C#','2024-05-15','Pending',5);
INSERT INTO `Project` VALUES (18,'2024-12-01','Lê Văn Hùng','Project Sigma','Python','2024-06-01','In Progress',4);
INSERT INTO `Project` VALUES (19,'2025-01-15','Nguyễn Văn Tùng','Project Tau','JavaScript','2024-07-15','Completed',2);
INSERT INTO `Project` VALUES (20,'2025-02-01','Nguyễn Văn An','Project Upsilon','C++','2024-08-01','Pending',2);
INSERT INTO `Project` VALUES (21,'2025-03-15','Trần Thị Bích','Project Phi','Ruby','2024-09-15','In Progress',10);
/*!40000 ALTER TABLE `Project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-08 22:33:02
