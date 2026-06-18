/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : db_blog_manage

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2026-06-03 11:12:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(32) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sign` varchar(256) DEFAULT NULL COMMENT '签名',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '123456', '老刘', '不爱学习，我是被逼的', '2026-05-18 09:37:11', '2026-05-26 10:26:53');

-- ----------------------------
-- Table structure for `t_blog`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `summary` varchar(256) DEFAULT NULL,
  `photo` varchar(256) DEFAULT NULL,
  `content` text,
  `click_num` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES ('1', 'vue3语法和vue2语法的区别', '1', 'Vue 2 到 Vue 3 的进化，代表了选项式 API (Options API) 到组合式 API (Composition API) 的编程范式转移', null, 'Vue 2 (选项式)：就像整理衣柜时，把所有上衣放一格，所有裤子放另一格。对于简单组件很清晰，但逻辑复杂时，处理同一个功能的代码会散落在 data、methods、mounted 等不同地方，阅读和修改时需要反复跳转。\r\n\r\nVue 3 (组合式)：好比把一套完整的衣服（上衣、裤子、袜子）放在同一个格子里。你可以把某个功能相关的所有代码（数据、方法、生命周期钩子）都写在一个 setup 或一个自定义函数里，内聚性更强。', '14', '2026-05-18 09:41:34', '2026-06-03 11:04:01');
INSERT INTO `t_blog` VALUES ('2', '你也会在深夜突然难过吗？', '2', '“那天晚上十一点，我关掉电脑，发现房间安静得只剩下空调的嗡嗡声。忽然觉得，有些话特别想说……”', null, '那天晚上十一点，我关掉电脑，发现房间安静得只剩下空调的嗡嗡声。忽然觉得，有些话特别想说。\r\n\r\n但那不是一种突如其来的倾诉欲，更像是什么东西在心里慢慢胀满了，到了非说不可的程度。\r\n\r\n屏幕黑了之后，倒映在屏幕上的我自己反而清晰起来——蓬乱的头发，没换的家居服，还有脸上那个不知道什么时候冒出来的、被我无意识抠了好多次的痘印。空调设定在24度，它固执地想把一个夏天的夜晚变成秋天，而我就在这半冷半暖的虚假温度里，呆了整整一个晚上。\r\n\r\n我翻了翻手机。微信列表里，置顶的、星标的、群聊的，一行行划过去，头像下面都是安安静静的，没有人找我，我也没找任何人。朋友圈有人发了九宫格晚餐，有人晒了两张电影票，有人抱怨加班到十点——我忽然想，那些看起来很热闹的生活，是不是也像我一样，被消化成了一条无声的动态？', '14', '2026-05-18 09:42:59', '2026-06-03 11:04:04');
INSERT INTO `t_blog` VALUES ('3', 'iPhone 16 Pro Max 开箱评测：大就是正义', '3', '我想和你分享的是，把 iPhone 16 Pro Max 从盒子里拿出来的那一刻，以及之后一周真实使用下来，那些让我“哇”出来，或者“嗯？”了一下的瞬间。', null, '快递到了。撕开外包装，露出那个熟悉的、带着微微浮雕感的包装盒。正面的 iPhone 16 Pro Max 图片，边框已经和真机一样窄了。\r\n\r\n第一感觉：这盒子也太薄了吧。\r\n\r\n苹果这几年一直在“环保”的路上狂飙，这次包装盒也不例外。撕开背面的纸质封条（不得不吐槽，这种设计虽然环保，但真的比塑料膜难撕多了），打开上盖——\r\n\r\n熟悉的三件套静静地躺在里面：手机本体、一根编织的 USB-C 充电线、一小沓说明书和保修卡。\r\n\r\n就这么多了。\r\n\r\n看着空荡荡的盒子内部，再看看手中的手机，我突然意识到：这种“空旷感”本身就是一种仪式感。 它不是在提醒你失去了什么，而是在暗示你——真正重要的东西，已经在你手里了。', '24', '2026-05-18 09:44:06', '2026-06-03 10:51:13');
INSERT INTO `t_blog` VALUES ('4', 'Spring Boot入门教程', '5', '本文详细介绍了Spring Boot的基本使用方法和核心特性', '', '<p>Spring Boot是一个快速开发框架...</p><h2>核心特性</h2><p>自动配置、起步依赖...</p>', '0', '2026-05-22 09:48:51', '2026-05-22 09:48:51');

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '技术前沿', '分享最新技术动态', '2026-05-18 09:38:18', '2026-05-18');
INSERT INTO `t_category` VALUES ('2', '心灵驿站', '分享内心思考，情感故事', '2026-05-18 09:38:43', '2026-05-18');
INSERT INTO `t_category` VALUES ('3', '数码玩家', '发布手机、电脑、智能设备的开箱和评测', '2026-05-18 09:39:19', '2026-05-18');
