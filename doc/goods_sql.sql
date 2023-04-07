/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.25 : Database - example_goods
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`example_goods` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `地址ID` int NOT NULL AUTO_INCREMENT,
  `地址` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`地址ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

/*Data for the table `address` */

insert  into `address`(`地址ID`,`地址`) values (1,'江海区五一路1'),(2,'蓬江区444号'),(3,'江海2'),(4,'江海路3'),(5,'江海路11号');

/*Table structure for table `bumen` */

DROP TABLE IF EXISTS `bumen`;

CREATE TABLE `bumen` (
  `buMenid` int NOT NULL AUTO_INCREMENT,
  `buMenName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`buMenid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

/*Data for the table `bumen` */

insert  into `bumen`(`buMenid`,`buMenName`) values (1,'买家'),(2,'公司办公室');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` int NOT NULL,
  `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类名',
  `level` int DEFAULT NULL COMMENT '等级',
  `parent_Id` int DEFAULT NULL COMMENT '父id',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片地址（头图或分类图片）',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

/*Data for the table `category` */

insert  into `category`(`cid`,`cname`,`level`,`parent_Id`,`img_url`) values (1,'居家生活',1,0,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_bg_1.webp'),(2,'宠物生活',1,0,NULL),(3,'个护清洁',1,0,NULL),(4,'母婴亲子',1,0,NULL),(5,'运动旅行',1,0,NULL),(6,'数码家电',1,0,NULL),(7,'服饰鞋包',1,0,NULL),(8,'严选全球',1,0,NULL),(9,'床品套件',2,1,NULL),(10,'被枕褥毯',2,1,NULL),(11,'四季款',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_1.webp'),(12,'秋冬款',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_2.webp'),(13,'床笠枕套',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_3.webp'),(14,'经典人气系列',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_4.webp'),(15,'高支轻奢系列',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_5.webp'),(16,'简约设计系列',3,10,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_6.webp');

/*Table structure for table `collection` */

DROP TABLE IF EXISTS `collection`;

CREATE TABLE `collection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int DEFAULT NULL COMMENT '商品id',
  `maijia_id` int DEFAULT NULL COMMENT '买家id',
  `collection_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '收藏时间',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商品名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `collection` */

insert  into `collection`(`id`,`goods_id`,`maijia_id`,`collection_time`,`goods_name`) values (1,1,2,'2022-04-15 22:15:25','爱疯10086'),(2,4,2,'2022-04-22 22:16:17','爱疯2'),(3,5,2,'2022-03-18 10:16:55','爱疯3'),(4,6,2,'2022-04-10 22:16:59','爱疯4');

/*Table structure for table `giants_shoulders` */

DROP TABLE IF EXISTS `giants_shoulders`;

CREATE TABLE `giants_shoulders` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '跳转路径',
  `icon_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标路径',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标题',
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '正文',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `giants_shoulders` */

insert  into `giants_shoulders`(`id`,`url`,`icon_path`,`title`,`text`) values (1,'www.baidu.com','https://img1.baidu.com/it/u=947100694,1150414340&fm=253&fmt=auto&app=120&f=JPEG?w=750&h=500','第一','哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈'),(2,'www.4399.com','https://img1.baidu.com/it/u=947100694,1150414340&fm=253&fmt=auto&app=120&f=JPEG?w=750&h=500','第二','嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名字',
  `price` double DEFAULT NULL COMMENT '价格',
  `flag` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标示：新品1，不是0',
  `picturePath` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图片路径',
  `category_id` int DEFAULT NULL COMMENT '商品分类',
  `descri` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品（产品）描述',
  `remark` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论',
  `isfictitious` int DEFAULT '0' COMMENT '积分商品为1，实际商品为0',
  `sales_volume` int DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`pid`) USING BTREE,
  KEY `products_fk` (`category_id`) USING BTREE,
  CONSTRAINT `products_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

/*Data for the table `goods` */

insert  into `goods`(`pid`,`pname`,`price`,`flag`,`picturePath`,`category_id`,`descri`,`remark`,`isfictitious`,`sales_volume`) values (1,'爱疯10086',5000,'0','http://localhost:8001/th.jpg',12,'这个很好',NULL,1,100),(2,'爱疯',3000,'0','http://localhost:8001/th.jpg',11,'使用方便',NULL,0,200),(4,'爱疯2',800,'0','http://localhost:8001/th.jpg',13,'操作简单 美观',NULL,0,123),(5,'爱疯3',200,'0','http://localhost:8001/th.jpg',12,'使用方便 操作简单 美观',NULL,1,23),(6,'爱疯4',450,'0','http://localhost:8001/th.jpg',12,' 美观',NULL,0,5),(7,'爱疯5',700,'0','http://localhost:8001/th.jpg',13,'操作简单',NULL,0,56),(8,'爱疯6',2680,'0','http://localhost:8001/th.jpg',11,'使用方便 操作简单 美观',NULL,0,2),(9,'爱疯7',590,'1','http://localhost:8001/th.jpg',14,'比较大的款式',NULL,0,1),(10,'爱疯XR',8900,'1','http://localhost:8001/th.jpg',15,'好',NULL,0,1),(11,'爱疯11',6900,'1','http://localhost:8001/th.jpg',16,'强',NULL,0,64),(12,'爱疯144',8900,'1','http://localhost:8001/th.jpg',11,'不错',NULL,0,6),(13,'爱疯12',6900,'1','http://localhost:8001/th.jpg',14,'用了都说好',NULL,1,156),(14,'爱疯13',9900,'1','http://localhost:8001/th.jpg',11,'王上王',NULL,1,84),(22,'爱疯666',1,'1','http://localhost:8001/th.jpg',11,'强中强',NULL,1,654);

/*Table structure for table `maijia` */

DROP TABLE IF EXISTS `maijia`;

CREATE TABLE `maijia` (
  `MaiJiaName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaiJiaID` int NOT NULL AUTO_INCREMENT,
  `buMenid` int NOT NULL,
  PRIMARY KEY (`MaiJiaID`) USING BTREE,
  KEY `buMenid` (`buMenid`) USING BTREE,
  CONSTRAINT `maijia_ibfk_1` FOREIGN KEY (`buMenid`) REFERENCES `bumen` (`buMenid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

/*Data for the table `maijia` */

insert  into `maijia`(`MaiJiaName`,`MaiJiaID`,`buMenid`) values ('小明',1,1),('陈晓红',2,1),('小张',3,1),('小青',4,2);

/*Table structure for table `recharge_scheme` */

DROP TABLE IF EXISTS `recharge_scheme`;

CREATE TABLE `recharge_scheme` (
  `rid` int NOT NULL AUTO_INCREMENT COMMENT '充值方案',
  `recharge_quantity` int DEFAULT NULL COMMENT '充值金额',
  `give` int DEFAULT NULL COMMENT '赠送',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `recharge_scheme` */

insert  into `recharge_scheme`(`rid`,`recharge_quantity`,`give`) values (1,100,10),(2,1,1000);

/*Table structure for table `sku` */

DROP TABLE IF EXISTS `sku`;

CREATE TABLE `sku` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gid` int DEFAULT NULL COMMENT 'goodsId',
  `goods_sku` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品规格',
  `stock` int DEFAULT NULL COMMENT '库存',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `state` int DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `goodsId` (`gid`) USING BTREE,
  CONSTRAINT `goodsId` FOREIGN KEY (`gid`) REFERENCES `goods` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `sku` */

insert  into `sku`(`id`,`gid`,`goods_sku`,`stock`,`price`,`state`) values (1,8,'{\"颜色\":\"红色\"}',100,'1.00',1),(2,8,'{\"颜色\":\"蓝色\"}',50,'2.00',1);

/*Table structure for table `sku_key` */

DROP TABLE IF EXISTS `sku_key`;

CREATE TABLE `sku_key` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'skuValueId：规格值 id',
  `category_id` int DEFAULT NULL COMMENT '商品类型id',
  `sku_v` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'sku属性值',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `categoryId` (`category_id`) USING BTREE,
  CONSTRAINT `categoryId` FOREIGN KEY (`category_id`) REFERENCES `category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `sku_key` */

insert  into `sku_key`(`id`,`category_id`,`sku_v`) values (1,11,'颜色'),(2,11,'尺码');

/*Table structure for table `sku_value` */

DROP TABLE IF EXISTS `sku_value`;

CREATE TABLE `sku_value` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sku_key_id` int DEFAULT NULL,
  `sku_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `skuKeyId` (`sku_key_id`) USING BTREE,
  CONSTRAINT `skuKeyId` FOREIGN KEY (`sku_key_id`) REFERENCES `sku_key` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `sku_value` */

insert  into `sku_value`(`id`,`sku_key_id`,`sku_value`) values (1,1,'红色'),(2,1,'蓝色');

/*Table structure for table `wallet` */

DROP TABLE IF EXISTS `wallet`;

CREATE TABLE `wallet` (
  `wid` int NOT NULL AUTO_INCREMENT,
  `MaiJiaID` int DEFAULT NULL COMMENT '买家id',
  `money` double DEFAULT '0' COMMENT '总资产',
  `total_recharge` double DEFAULT '0' COMMENT '累计充值',
  `total_consumption` double DEFAULT '0' COMMENT '累计消费',
  PRIMARY KEY (`wid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

/*Data for the table `wallet` */

insert  into `wallet`(`wid`,`MaiJiaID`,`money`,`total_recharge`,`total_consumption`) values (1,2,10086,2131,23),(2,1,1611,1611,0),(3,4,120,123,153),(4,3,556,56,56);

/*Table structure for table `商品订单` */

DROP TABLE IF EXISTS `商品订单`;

CREATE TABLE `商品订单` (
  `订单ID` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL,
  `时间` datetime DEFAULT NULL,
  `MaiJiaID` int DEFAULT NULL,
  `number` int DEFAULT NULL COMMENT '数量',
  `地址ID` int NOT NULL,
  `state` int DEFAULT NULL COMMENT '商品状态：默认为空，0未支付，1待发货，2待收货，3待评价',
  `isEnd` int DEFAULT '0' COMMENT '交易是否已完成，默认为0，1已完成\r\n',
  PRIMARY KEY (`订单ID`) USING BTREE,
  KEY `aa2` (`pid`) USING BTREE,
  KEY `iii` (`MaiJiaID`) USING BTREE,
  KEY `aa45` (`地址ID`) USING BTREE,
  CONSTRAINT `aa12` FOREIGN KEY (`MaiJiaID`) REFERENCES `maijia` (`MaiJiaID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `aa2` FOREIGN KEY (`pid`) REFERENCES `goods` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `aa45` FOREIGN KEY (`地址ID`) REFERENCES `address` (`地址ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

/*Data for the table `商品订单` */

insert  into `商品订单`(`订单ID`,`pid`,`时间`,`MaiJiaID`,`number`,`地址ID`,`state`,`isEnd`) values (1,8,'2022-04-13 21:46:04',2,34,1,1,0),(2,9,'2022-03-08 21:46:11',2,4,1,1,0),(3,9,'2022-04-07 21:46:15',1,7,2,1,0),(4,2,'2022-05-06 21:46:19',4,7,2,1,0),(5,2,'2022-04-02 21:46:21',2,5,2,1,0),(6,5,'2022-04-17 21:46:24',2,2,2,3,1),(7,7,'2022-04-17 21:46:24',2,2,2,4,1),(8,11,'2022-04-14 22:46:24',2,1,1,2,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
