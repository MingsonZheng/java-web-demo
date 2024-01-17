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

 Date: 17/01/2024 16:19:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '部门名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '学工部', '2024-01-08 21:48:39', '2024-01-08 21:48:39');
INSERT INTO `dept` VALUES (2, '教研部', '2024-01-08 21:48:39', '2024-01-08 21:48:39');
INSERT INTO `dept` VALUES (3, '咨询部', '2024-01-08 21:48:39', '2024-01-08 21:48:39');
INSERT INTO `dept` VALUES (4, '就业部', '2024-01-08 21:48:39', '2024-01-08 21:48:39');
INSERT INTO `dept` VALUES (5, '人事部', '2024-01-08 21:48:39', '2024-01-08 21:48:39');

SET FOREIGN_KEY_CHECKS = 1;
