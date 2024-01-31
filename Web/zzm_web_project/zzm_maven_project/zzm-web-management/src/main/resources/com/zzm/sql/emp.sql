/*
 Navicat Premium Data Transfer

 Source Server         : 本机MySQL
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : zzm

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 17/01/2024 16:08:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `gender` tinyint(3) UNSIGNED NOT NULL COMMENT '性别，说明: 1 男，2 女',
  `image` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图像',
  `job` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '职位，说明:1 班主任,2 讲师，3 学工主管，4 教研主管，5 咨询师',
  `entrydate` date NULL DEFAULT NULL COMMENT '入职时间',
  `dept_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '员工表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, '2024-01-09 16:57:42', '2024-01-09 16:57:42');
INSERT INTO `emp` VALUES (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, '2024-01-09 16:57:42', '2024-01-09 16:57:42');
INSERT INTO `emp` VALUES (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, '2024-01-09 16:57:42', '2024-01-09 16:57:42');
INSERT INTO `emp` VALUES (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, '2024-01-09 16:57:42', '2024-01-09 16:57:42');
INSERT INTO `emp` VALUES (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', 2, '2024-01-09 16:57:42', '2024-01-09 16:57:42');
INSERT INTO `emp` VALUES (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, '2024-01-09 16:57:42', '2024-01-09 16:57:42');
INSERT INTO `emp` VALUES (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, '2024-01-09 16:58:21', '2024-01-09 16:58:21');
INSERT INTO `emp` VALUES (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, '2024-01-09 16:58:32', '2024-01-09 16:58:32');
INSERT INTO `emp` VALUES (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (11, 'luzhangke', '123456', '鹿杖客', 1, '1l.jpg', 5, '2007-02-01', 3, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', 2, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', 2, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (16, 'songyuangiao', '123456', '宋远桥', 1, '16.jpg', 2, '2007-01-01', 2, '2024-01-09 16:58:50', '2024-01-09 16:58:50');
INSERT INTO `emp` VALUES (17, 'chenyouliang', '123456', '陈友谅', 1, '17.jpg', NULL, '2015-03-21', NULL, '2024-01-09 16:58:50', '2024-01-09 16:58:50');

SET FOREIGN_KEY_CHECKS = 1;
