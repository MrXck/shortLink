/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : short

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2023-08-23 15:36:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `origin_url` varchar(256) NOT NULL,
  `short_url` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
