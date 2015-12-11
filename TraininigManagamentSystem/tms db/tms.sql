/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.27 : Database - trainingmanagementsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`trainingmanagementsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `trainingmanagementsystem`;

/*Table structure for table `courses` */

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `course_id` int(10) NOT NULL AUTO_INCREMENT,
  `course_title` varchar(10) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `reference_code` varchar(50) DEFAULT NULL,
  `image` varchar(10) DEFAULT NULL,
  `status_id` int(5) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `courses` */

insert  into `courses`(`course_id`,`course_title`,`description`,`reference_code`,`image`,`status_id`,`user_id`) values (5,'Java','java basics','bu6','image',0,2);

/*Table structure for table `designation` */

DROP TABLE IF EXISTS `designation`;

CREATE TABLE `designation` (
  `user_designationid` int(1) NOT NULL,
  `designation` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_designationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `designation` */

insert  into `designation`(`user_designationid`,`designation`) values (0,NULL),(1,'manager'),(2,'trainer'),(3,'trainee');

/*Table structure for table `heading` */

DROP TABLE IF EXISTS `heading`;

CREATE TABLE `heading` (
  `heading_id` int(10) NOT NULL AUTO_INCREMENT,
  `heading_text` varchar(50) DEFAULT NULL,
  `course_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`heading_id`),
  KEY `heading_ibfk_1` (`course_id`),
  CONSTRAINT `heading_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `heading` */

insert  into `heading`(`heading_id`,`heading_text`,`course_id`) values (14,'collections',5);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(1) NOT NULL,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role`) values (1,'user'),(2,'guest'),(3,'admin');

/*Table structure for table `status` */

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `status_id` int(1) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `status` */

insert  into `status`(`status_id`,`status`) values (0,'blocked'),(1,'active');

/*Table structure for table `subheading` */

DROP TABLE IF EXISTS `subheading`;

CREATE TABLE `subheading` (
  `heading_id` int(10) DEFAULT NULL,
  `subheading` varchar(50) DEFAULT NULL,
  `subheading_id` int(10) NOT NULL AUTO_INCREMENT,
  `completion_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`subheading_id`),
  KEY `subheading_ibfk_2` (`heading_id`),
  CONSTRAINT `subheading_ibfk_2` FOREIGN KEY (`heading_id`) REFERENCES `heading` (`heading_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `subheading` */

insert  into `subheading`(`heading_id`,`subheading`,`subheading_id`,`completion_status`) values (14,'list',4,'Completed');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(4) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `user_contact` varchar(10) DEFAULT NULL,
  `user_email_id` varchar(30) DEFAULT NULL,
  `user_designationid_fk` int(1) DEFAULT NULL,
  `user_role` int(1) DEFAULT NULL,
  `user_status` int(1) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_designationid_fk` (`user_designationid_fk`),
  KEY `user_status` (`user_status`),
  KEY `user_role` (`user_role`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_designationid_fk`) REFERENCES `designation` (`user_designationid`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`user_status`) REFERENCES `status` (`status_id`),
  CONSTRAINT `user_ibfk_3` FOREIGN KEY (`user_role`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_contact`,`user_email_id`,`user_designationid_fk`,`user_role`,`user_status`,`username`,`password`) values (1,'Mayank','9874352311','mayank.yadav',2,1,1,'trainer','trainer'),(2,' Mayank yadav','9584560064','mayank1yadav1@gmail.com',1,2,1,'admin','admin'),(4,' xcfasdfas','9303230871','adi.yash',3,2,1,'trainee','trainee');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
