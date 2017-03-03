/*
Navicat MySQL Data Transfer

Source Server         : 192.169.31.215
Source Server Version : 50522
Source Host           : 192.169.31.215:3306
Source Database       : dream

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2016-03-07 20:11:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(100) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `cgname` varchar(255) NOT NULL COMMENT '评论的果品名',
  `ccontent` varchar(255) DEFAULT NULL COMMENT '评论的内容',
  `cdate` varchar(255) DEFAULT NULL COMMENT '评论的日期',
  `cip` varchar(255) DEFAULT NULL COMMENT '评论人IP',
  `cauthor` varchar(255) DEFAULT NULL COMMENT '评论人',
  PRIMARY KEY (`cid`),
  KEY `cgname` (`cgname`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`cgname`) REFERENCES `goods` (`gname`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '菲律宾凤梨', 'mm', '212', '121', '葛大傻');
INSERT INTO `comment` VALUES ('2', '菲律宾凤梨', '你是傻逼吗', '2016-3-4', '192.169.31.243', '晓风');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(100) NOT NULL AUTO_INCREMENT COMMENT '果品ID',
  `gname` varchar(255) NOT NULL COMMENT '果品名字',
  `gprice` double(100,0) DEFAULT NULL COMMENT '果品价格',
  `gtype` varchar(100) DEFAULT NULL COMMENT '果品类型',
  `gaddress` varchar(255) DEFAULT NULL COMMENT '果品产地',
  `gpic` varchar(255) DEFAULT NULL COMMENT '果品图片',
  `gdescribe` varchar(255) DEFAULT NULL COMMENT '果品描述',
  PRIMARY KEY (`gid`),
  KEY `gname` (`gname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '菲律宾凤梨', '38', '凤梨', '菲律宾', 'fengli.jpg', '新鲜好吃的的凤梨');
INSERT INTO `goods` VALUES ('3', '越南火龙果', '39', '火龙果', '越南', 'huolongguo.jpg', '新鲜好吃的的火龙果');
INSERT INTO `goods` VALUES ('4', '越南火龙果', '50', '火龙果', '越南', 'huolongguo.jpg', '新鲜好吃的的火龙果');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` int(100) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `opid` int(100) NOT NULL COMMENT '购买下单ID',
  `ouid` int(100) NOT NULL COMMENT '用户ID',
  `osid` int(100) NOT NULL COMMENT '店面ID',
  `ostatus` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `oaddress` varchar(255) DEFAULT NULL COMMENT '订单地址',
  `ostartdate` varchar(255) DEFAULT NULL COMMENT '订单起送时间',
  `oenddate` varchar(255) DEFAULT NULL COMMENT '订单送达时间',
  PRIMARY KEY (`oid`),
  KEY `opid` (`opid`),
  KEY `ouid` (`ouid`),
  KEY `osid` (`osid`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`opid`) REFERENCES `purchase` (`pid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`ouid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`osid`) REFERENCES `store` (`sid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '11', '1', '正在送往', '贵州省安顺市西秀区', '2016-03-04', '2016-03-06');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `pid` int(100) NOT NULL AUTO_INCREMENT COMMENT '购买下单ID',
  `psid` int(100) NOT NULL COMMENT '店面ID',
  `pgid` int(100) NOT NULL COMMENT '商品ID',
  `pnum` int(100) DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`pid`),
  KEY `psid` (`psid`),
  KEY `pgid` (`pgid`),
  CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`psid`) REFERENCES `store` (`sid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`pgid`) REFERENCES `goods` (`gid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('1', '1', '1', '5');
INSERT INTO `purchase` VALUES ('2', '1', '4', '10');

-- ----------------------------
-- Table structure for `repertory`
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory` (
  `rid` int(100) NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `rgid` int(100) NOT NULL COMMENT '果品ID',
  `rnum` int(100) DEFAULT NULL COMMENT '库存数量',
  `rsid` int(100) NOT NULL COMMENT '店面ID',
  PRIMARY KEY (`rid`),
  KEY `rgid` (`rgid`),
  KEY `rsid` (`rsid`),
  CONSTRAINT `repertory_ibfk_1` FOREIGN KEY (`rgid`) REFERENCES `goods` (`gid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `repertory_ibfk_2` FOREIGN KEY (`rsid`) REFERENCES `store` (`sid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repertory
-- ----------------------------
INSERT INTO `repertory` VALUES ('1', '1', '100', '1');
INSERT INTO `repertory` VALUES ('2', '3', '200', '1');

-- ----------------------------
-- Table structure for `sale`
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `said` int(100) NOT NULL AUTO_INCREMENT COMMENT '销售ID',
  `sanum` int(100) DEFAULT NULL COMMENT '成交数量',
  `saprice` double(100,0) DEFAULT NULL COMMENT '成交金额',
  `savisitor` int(100) DEFAULT NULL COMMENT '访客数目',
  `sasname` varchar(255) NOT NULL COMMENT '店面名字',
  PRIMARY KEY (`said`),
  KEY `sasname` (`sasname`),
  CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`sasname`) REFERENCES `store` (`sname`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES ('2', '3', '15', '20', '当然果园');
INSERT INTO `sale` VALUES ('3', '6', '50', '30', '当然果园');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `sid` int(100) NOT NULL AUTO_INCREMENT COMMENT '店面ID',
  `sname` varchar(255) NOT NULL COMMENT '店面名字',
  `sphone` varchar(255) DEFAULT NULL COMMENT '店面联系电话',
  `saddress` varchar(255) DEFAULT NULL COMMENT '店面地址',
  PRIMARY KEY (`sid`),
  KEY `sname` (`sname`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '当然果园', '10086', '厦门市湖里区');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(100) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `uname` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `upwd` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `sex` varchar(100) DEFAULT NULL COMMENT '用户性别',
  `ubir` varchar(100) DEFAULT NULL COMMENT '用户生日',
  `uphone` varchar(100) DEFAULT NULL COMMENT '用户电话',
  `umail` varchar(100) DEFAULT NULL COMMENT '用户邮箱',
  `uaddress` varchar(100) DEFAULT NULL COMMENT '用户常用地址',
  `uflag` varchar(100) DEFAULT NULL COMMENT '用户权限',
  `ulevel` varchar(100) DEFAULT NULL COMMENT '会员等级',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11', 'gerui', '12313', '男', '1992.12.13', '123123', '12@qq.com', '安徽合肥', 'normal', 'VIP1');
INSERT INTO `user` VALUES ('12', 'kxl', '55555', '女', '。。。', '。。。', '。。。', '。。。', '。。。', 'vip两万');
