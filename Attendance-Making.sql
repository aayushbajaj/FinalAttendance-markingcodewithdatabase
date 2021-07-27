/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.22 : Database - attendance-making
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`attendance-making` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `attendance-making`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `admin_id` bigint DEFAULT NULL,
  `age` varchar(225) DEFAULT NULL,
  `contact_no` varchar(225) DEFAULT NULL,
  `email_id` varchar(225) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `gender` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `status` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `admin` */

insert  into `admin`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`admin_id`,`age`,`contact_no`,`email_id`,`first_name`,`gender`,`last_name`,`password`,`role_id`,`status`) values 
(1,NULL,NULL,NULL,NULL,2000100101,'9685748596','Veniam id illum ir','zekozef@mailinator.com','Claudia','Male','Olson','Pa$$w0rd!',1,'Approve'),
(2,NULL,NULL,NULL,NULL,2000100102,'25','8545658545','kixojo@mailinator.com','Raven','Female','Wiley','Pa$$w0rd!',2,'Approve');

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `session_id` bigint NOT NULL,
  `status` varchar(225) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `session` bigint NOT NULL,
  `user` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi4gv2gx4idny41pn7kq4s0p6k` (`session`),
  KEY `FKdaeqq7yrqq75ngwd1d0utftgl` (`user`),
  CONSTRAINT `FKdaeqq7yrqq75ngwd1d0utftgl` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKi4gv2gx4idny41pn7kq4s0p6k` FOREIGN KEY (`session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `attendance` */

insert  into `attendance`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`session_id`,`status`,`user_id`,`session`,`user`) values 
(1,NULL,NULL,NULL,NULL,3,'Present',7,3,7);

/*Table structure for table `enroll` */

DROP TABLE IF EXISTS `enroll`;

CREATE TABLE `enroll` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `session_id` bigint NOT NULL,
  `status` varchar(225) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `session` bigint NOT NULL,
  `user` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe1voefgep6vilkqh78gbc010k` (`session`),
  KEY `FKtcb14m9hiumbyoenhyaoy0fj2` (`user`),
  CONSTRAINT `FKe1voefgep6vilkqh78gbc010k` FOREIGN KEY (`session`) REFERENCES `session` (`id`),
  CONSTRAINT `FKtcb14m9hiumbyoenhyaoy0fj2` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `enroll` */

insert  into `enroll`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`session_id`,`status`,`user_id`,`session`,`user`) values 
(2,NULL,NULL,NULL,NULL,3,'Approve',7,3,7);

/*Table structure for table `session` */

DROP TABLE IF EXISTS `session`;

CREATE TABLE `session` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `session_id` bigint NOT NULL,
  `date` date DEFAULT NULL,
  `skill_id` bigint NOT NULL,
  `slot` varchar(225) DEFAULT NULL,
  `time` varchar(225) DEFAULT NULL,
  `skill` bigint NOT NULL,
  `session_type` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9nws0pwkh44nnuy97tx9b1hme` (`skill`),
  CONSTRAINT `FK9nws0pwkh44nnuy97tx9b1hme` FOREIGN KEY (`skill`) REFERENCES `skill_set` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `session` */

insert  into `session`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`description`,`session_id`,`date`,`skill_id`,`slot`,`time`,`skill`,`session_type`) values 
(3,NULL,NULL,NULL,NULL,'sfdvdefve',401010,'2021-04-09',1,'1010','10 AM',1,'Class Room Session');

/*Table structure for table `skill_set` */

DROP TABLE IF EXISTS `skill_set`;

CREATE TABLE `skill_set` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `skill_id` bigint DEFAULT NULL,
  `type` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `skill_set` */

insert  into `skill_set`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`description`,`skill_id`,`type`) values 
(1,NULL,NULL,NULL,NULL,'Occaecat omnis irure',301010,'Sed id nulla consequ');

/*Table structure for table `trainer` */

DROP TABLE IF EXISTS `trainer`;

CREATE TABLE `trainer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `contact_no` varchar(225) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `session_id` bigint NOT NULL,
  `skill_id` bigint NOT NULL,
  `trainer_id` bigint DEFAULT NULL,
  `session` bigint NOT NULL,
  `skill` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK33jcqbwgj75mvaq0x91jufc9n` (`session`),
  KEY `FK25dofp2o5ifksnjlokthbq36x` (`skill`),
  CONSTRAINT `FK25dofp2o5ifksnjlokthbq36x` FOREIGN KEY (`skill`) REFERENCES `skill_set` (`id`),
  CONSTRAINT `FK33jcqbwgj75mvaq0x91jufc9n` FOREIGN KEY (`session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `trainer` */

insert  into `trainer`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`contact_no`,`email`,`name`,`session_id`,`skill_id`,`trainer_id`,`session`,`skill`) values 
(1,NULL,NULL,NULL,NULL,'9685456585','nepab@mailinator.com','Chantale Higgins',3,1,30001001,3,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `user_name` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `email_id` varchar(225) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`confirm_password`,`first_name`,`last_name`,`user_name`,`password`,`role_id`,`email_id`,`user_id`) values 
(7,NULL,NULL,NULL,NULL,NULL,'Connor','Dickerson',NULL,'Pa$$w0rd!',2,'ritun@mailinator.com',1000100101),
(8,NULL,NULL,NULL,NULL,NULL,'Leo','Hoover',NULL,'Pa$$w0rd!',2,'Hariomukati741@gmail.com',1000100102);

/*Table structure for table `user_feedback` */

DROP TABLE IF EXISTS `user_feedback`;

CREATE TABLE `user_feedback` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `message` varchar(225) DEFAULT NULL,
  `session_id` bigint NOT NULL,
  `subject` varchar(225) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `session` bigint NOT NULL,
  `user` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhfnf4fv6d3bkmcff4utcekda5` (`session`),
  KEY `FK9f09htxgbljb5ntrw8a10mwbo` (`user`),
  CONSTRAINT `FK9f09htxgbljb5ntrw8a10mwbo` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKhfnf4fv6d3bkmcff4utcekda5` FOREIGN KEY (`session`) REFERENCES `session` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `user_feedback` */

insert  into `user_feedback`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`message`,`session_id`,`subject`,`user_id`,`session`,`user`) values 
(1,NULL,NULL,NULL,NULL,'sfvdefdef',3,'FFFFFFFFFFFFFFF',7,3,7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
