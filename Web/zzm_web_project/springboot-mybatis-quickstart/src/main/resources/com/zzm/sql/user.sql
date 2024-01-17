/*
 Navicat Premium Data Transfer

 Source Server         : 本机MySQL
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 17/01/2024 16:12:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  `gender` tinyint(3) UNSIGNED NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '白眉鹰王', 55, 1, '18800000000');
INSERT INTO `user` VALUES (2, '金毛狮王', 45, 1, '18800000001');
INSERT INTO `user` VALUES (3, '青翼蝠王', 38, 1, '18800000002');
INSERT INTO `user` VALUES (4, '青衫龙王', 42, 2, '18800000003');
INSERT INTO `user` VALUES (5, '光明左使', 37, 1, '18800000004');
INSERT INTO `user` VALUES (6, '光明右使', 48, 1, '18800000005');

SET FOREIGN_KEY_CHECKS = 1;
