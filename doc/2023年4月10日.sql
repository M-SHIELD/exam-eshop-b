/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.36 : Database - goods_example
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`goods_example` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `e_activity` */

DROP TABLE IF EXISTS `e_activity`;

CREATE TABLE `e_activity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `activity_name` varchar(50) NOT NULL COMMENT '活动名称',
  `activity_desc` varchar(200) DEFAULT NULL COMMENT '活动描述',
  `activity_type` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '活动类型，0-普通活动，1-秒杀活动，2-团购活动',
  `start_time` datetime NOT NULL COMMENT '活动开始时间',
  `end_time` datetime NOT NULL COMMENT '活动结束时间',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '活动状态，0-未开始，1-进行中，2-已结束',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-否，1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='活动信息表';

/*Data for the table `e_activity` */

insert  into `e_activity`(`id`,`activity_name`,`activity_desc`,`activity_type`,`start_time`,`end_time`,`status`,`create_time`,`update_time`,`is_del`) values (1,'春季特惠','春季特别优惠活动',0,'2023-03-01 00:00:00','2023-03-31 23:59:59',2,'2023-04-09 17:28:47','2023-04-09 17:28:47',0),(2,'五一大促','五一购物季特别优惠活动',0,'2023-04-28 00:00:00','2023-05-05 23:59:59',0,'2023-04-09 17:28:47','2023-04-09 17:28:47',0),(3,'双11狂欢','双11购物季疯狂优惠活动',0,'2023-11-01 00:00:00','2023-11-11 23:59:59',0,'2023-04-09 17:28:47','2023-04-09 17:28:47',0),(4,'618大促','618购物季特别优惠活动',0,'2023-06-01 00:00:00','2023-06-18 23:59:59',0,'2023-04-09 17:28:47','2023-04-09 17:28:47',0),(5,'年货节','春节购物季特别优惠活动',0,'2024-01-10 00:00:00','2024-01-23 23:59:59',0,'2023-04-09 17:28:47','2023-04-09 17:28:47',0);

/*Table structure for table `e_address` */

DROP TABLE IF EXISTS `e_address`;

CREATE TABLE `e_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `real_name` varchar(50) NOT NULL COMMENT '收货人姓名',
  `phone` varchar(20) NOT NULL COMMENT '联系电话',
  `province` varchar(50) NOT NULL COMMENT '省份',
  `city` varchar(50) NOT NULL COMMENT '城市',
  `district` varchar(50) NOT NULL COMMENT '区/县',
  `detail` varchar(200) NOT NULL COMMENT '详细地址',
  `post_code` varchar(10) DEFAULT NULL COMMENT '邮编',
  `longitude` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,6) DEFAULT NULL COMMENT '纬度',
  `is_default` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否默认地址，0：否，1：是',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='收货地址表';

/*Data for the table `e_address` */

insert  into `e_address`(`id`,`uid`,`real_name`,`phone`,`province`,`city`,`district`,`detail`,`post_code`,`longitude`,`latitude`,`is_default`,`create_time`,`update_time`,`is_del`) values (1,1,'张三','13888888888','广东省','深圳市','南山区','高新南一道10000号','518057','113.958015','22.540054',1,'2022-10-01 10:00:00','2022-10-01 10:00:00',0),(2,1,'李四','13999999999','广东省','广州市','天河区','科韵路103号','510660','113.394818','23.137311',0,'2022-11-01 10:00:00','2022-11-01 10:00:00',0);

/*Table structure for table `e_category` */

DROP TABLE IF EXISTS `e_category`;

CREATE TABLE `e_category` (
  `id` int(11) NOT NULL,
  `cname` varchar(50) DEFAULT NULL COMMENT '分类名',
  `level` int(11) DEFAULT NULL COMMENT '等级',
  `parent_id` int(11) DEFAULT NULL COMMENT '父id',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片地址（头图或分类图片）',
  `is_show` int(1) DEFAULT NULL COMMENT '是否展示1是0否',
  `is_del` int(1) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品分类表';

/*Data for the table `e_category` */

insert  into `e_category`(`id`,`cname`,`level`,`parent_id`,`img_url`,`is_show`,`is_del`,`create_time`,`update_time`,`sort`) values (1,'居家生活',1,0,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_bg_1.webp',1,0,NULL,NULL,7),(2,'宠物生活',1,0,NULL,1,0,NULL,NULL,94),(3,'个护清洁',1,0,NULL,1,0,NULL,NULL,49),(4,'母婴亲子',1,0,NULL,1,0,NULL,NULL,62),(5,'运动旅行',1,0,NULL,1,0,NULL,NULL,64),(6,'数码家电',1,0,NULL,1,0,NULL,NULL,34),(7,'服饰鞋包',1,0,NULL,1,0,NULL,NULL,77),(8,'严选全球',1,0,NULL,1,0,NULL,NULL,84),(9,'床品套件',2,1,NULL,1,0,NULL,NULL,90),(10,'被枕褥毯',2,1,NULL,1,0,NULL,NULL,99),(11,'四季款',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_1.webp',1,0,NULL,NULL,25),(12,'秋冬款',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_2.webp',1,0,NULL,NULL,27),(13,'床笠枕套',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_3.webp',1,0,NULL,NULL,62),(14,'经典人气系列',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_4.webp',1,0,NULL,NULL,30),(15,'高支轻奢系列',3,9,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_5.webp',1,0,NULL,NULL,66),(16,'简约设计系列',3,10,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_6.webp',1,0,NULL,NULL,40),(17,'狗狗用品',2,2,NULL,1,0,NULL,NULL,0),(18,'猫咪用品',2,2,NULL,1,0,NULL,NULL,82),(19,'沐浴用品',2,3,NULL,1,0,NULL,NULL,9),(20,'口腔护理',2,3,NULL,1,0,NULL,NULL,1),(21,'奶瓶/餐具',2,4,NULL,1,0,NULL,NULL,79),(22,'儿童玩具',2,4,NULL,1,0,NULL,NULL,92),(23,'户外装备',2,5,NULL,1,0,NULL,NULL,22),(24,'运动服装',2,5,NULL,1,0,NULL,NULL,34),(25,'手机配件',2,6,NULL,1,0,NULL,NULL,5),(26,'厨房电器',2,6,NULL,1,0,NULL,NULL,26),(27,'女士服装',2,7,NULL,1,0,NULL,NULL,13),(28,'男士服装',2,7,NULL,1,0,NULL,NULL,89),(29,'进口食品',2,8,NULL,1,0,NULL,NULL,4),(30,'国内特产',2,8,NULL,1,0,NULL,NULL,57),(31,'床垫',3,9,'https://www.ake1.com/mkoss/2023-04-09/a72505dc.png',1,0,NULL,NULL,72),(32,'被子',3,10,'https://www.ake1.com/mkoss/2023-04-09/01f2ee98.png',1,0,NULL,NULL,88),(33,'枕头',3,10,'https://www.ake1.com/mkoss/2023-04-09/9df90bc3.png',1,0,NULL,NULL,26),(34,'毯子',3,10,'https://www.ake1.com/mkoss/2023-04-09/1d5712f9.png',1,0,NULL,NULL,66),(35,'T恤',3,27,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_11.webp',1,0,NULL,NULL,54),(36,'衬衫',3,27,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_12.webp',1,0,NULL,NULL,72),(37,'裤子',3,28,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_13.webp',1,0,NULL,NULL,96),(38,'鞋子',3,28,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_14.webp',1,0,NULL,NULL,68),(39,'巧克力',3,29,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_15.webp',1,0,NULL,NULL,52),(40,'坚果炒货',3,29,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_16.webp',1,0,NULL,NULL,54),(41,'泰国进口',3,30,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_17.webp',1,0,NULL,NULL,17),(42,'东北特产',3,30,'https://xunda-ui.oss-cn-shenzhen.aliyuncs.com/pan/icon-init/type_l_18.webp',1,0,NULL,NULL,22);

/*Table structure for table `e_evaluation` */

DROP TABLE IF EXISTS `e_evaluation`;

CREATE TABLE `e_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '评分',
  `content` varchar(500) DEFAULT NULL COMMENT '评价内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='评价表';

/*Data for the table `e_evaluation` */

insert  into `e_evaluation`(`id`,`order_id`,`uid`,`score`,`content`,`create_time`,`update_time`,`is_del`) values (1,10001,100,4,'商品质量不错，物流速度也很快，非常满意！','2022-01-01 10:00:00','2022-01-02 10:00:00',0),(2,10002,101,5,'非常好的购物体验，物超所值！','2022-01-02 10:00:00','2022-01-03 10:00:00',0),(3,10002,102,3,'商品不太满意，质量有点差，但物流还不错。','2022-01-03 10:00:00','2022-01-04 10:00:00',0),(4,10003,103,4,'商品不错，就是物流太慢了。','2022-01-04 10:00:00','2022-01-05 10:00:00',0),(5,10003,104,5,'商品质量好，物流速度快，赞！','2022-01-05 10:00:00','2022-01-06 10:00:00',0);

/*Table structure for table `e_logistics` */

DROP TABLE IF EXISTS `e_logistics`;

CREATE TABLE `e_logistics` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` bigint(20) unsigned NOT NULL COMMENT '订单ID',
  `logistics_no` varchar(50) NOT NULL COMMENT '物流单号',
  `logistics_company` varchar(50) NOT NULL COMMENT '物流公司名称',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '物流状态，0-待发货，1-已发货，2-已签收',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-否，1-是',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='物流信息表';

/*Data for the table `e_logistics` */

insert  into `e_logistics`(`id`,`order_id`,`logistics_no`,`logistics_company`,`status`,`create_time`,`update_time`,`is_del`) values (1,10001,'1234567890','顺丰快递',1,'2022-01-01 10:00:00','2022-01-02 12:00:00',0),(2,10002,'2345678901','圆通快递',0,'2022-01-03 14:00:00','2022-01-04 16:00:00',0),(3,10003,'3456789012','中通快递',2,'2022-01-05 18:00:00','2022-01-06 20:00:00',0),(4,10004,'4567890123','申通快递',1,'2022-01-07 22:00:00','2022-01-08 00:00:00',0);

/*Table structure for table `e_order` */

DROP TABLE IF EXISTS `e_order`;

CREATE TABLE `e_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_no` varchar(50) NOT NULL COMMENT '订单号',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `total_amount` decimal(10,2) NOT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10,2) NOT NULL COMMENT '实际支付金额',
  `pay_type` tinyint(1) NOT NULL COMMENT '支付方式，1：支付宝，2：微信',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订单状态，0：待支付，1：已支付，2：已发货，3：已收货，4：已完成，5：已取消，6：已退款，7：已删除',
  `create_time` datetime NOT NULL COMMENT '订单创建时间',
  `update_time` datetime NOT NULL COMMENT '订单更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `order_no` (`order_no`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

/*Data for the table `e_order` */

insert  into `e_order`(`id`,`order_no`,`uid`,`total_amount`,`pay_amount`,`pay_type`,`status`,`create_time`,`update_time`,`is_del`) values (1,'202204100001',1,'199.99','199.99',1,1,'2022-04-10 10:00:00','2022-04-10 10:00:00',0),(2,'202204110001',1,'399.99','399.99',2,1,'2022-04-11 10:00:00','2022-04-11 10:00:00',0),(3,'202204120001',1,'599.99','599.99',1,2,'2022-04-12 10:00:00','2022-04-12 10:00:00',0),(4,'202204130001',1,'799.99','799.99',2,3,'2022-04-13 10:00:00','2022-04-13 10:00:00',0),(5,'202204140001',1,'999.99','999.99',1,4,'2022-04-14 10:00:00','2022-04-14 10:00:00',0);

/*Table structure for table `e_order_item` */

DROP TABLE IF EXISTS `e_order_item`;

CREATE TABLE `e_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `product_id` bigint(20) NOT NULL COMMENT '商品ID',
  `product_name` varchar(100) NOT NULL COMMENT '商品名称',
  `product_image` varchar(255) NOT NULL COMMENT '商品图片',
  `product_price` decimal(10,2) NOT NULL COMMENT '商品单价',
  `quantity` int(11) NOT NULL COMMENT '商品数量',
  `subtotal_amount` decimal(10,2) NOT NULL COMMENT '小计金额',
  `create_time` datetime NOT NULL COMMENT '订单详情创建时间',
  `update_time` datetime NOT NULL COMMENT '订单详情更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

/*Data for the table `e_order_item` */

insert  into `e_order_item`(`id`,`order_id`,`product_id`,`product_name`,`product_image`,`product_price`,`quantity`,`subtotal_amount`,`create_time`,`update_time`,`is_del`) values (1,1,1,'商品1','/product/image/1.jpg','199.99',1,'199.99','2022-04-10 10:00:00','2022-04-10 10:00:00',0),(2,2,2,'商品2','/product/image/2.jpg','399.99',1,'399.99','2022-04-11 10:00:00','2022-04-11 10:00:00',0),(3,3,3,'商品3','/product/image/3.jpg','199.99',3,'599.97','2022-04-12 10:00:00','2022-04-12 10:00:00',0),(4,4,4,'商品4','/product/image/4.jpg','99.99',8,'799.92','2022-04-13 10:00:00','2022-04-13 10:00:00',0),(5,5,5,'商品5','/product/image/5.jpg','99.99',10,'999.90','2022-04-14 10:00:00','2022-04-14 10:00:00',0);

/*Table structure for table `e_point` */

DROP TABLE IF EXISTS `e_point`;

CREATE TABLE `e_point` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `uid` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `total_point` int(11) NOT NULL DEFAULT '0' COMMENT '积分总数',
  `available_point` int(11) NOT NULL DEFAULT '0' COMMENT '可用积分',
  `frozen_point` int(11) NOT NULL DEFAULT '0' COMMENT '冻结积分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示已删除',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='积分表';

/*Data for the table `e_point` */

insert  into `e_point`(`id`,`uid`,`total_point`,`available_point`,`frozen_point`,`create_time`,`update_time`,`is_del`) values (1,1,1000,800,200,'2023-04-09 17:20:00','2023-04-09 17:20:00',0),(2,2,500,500,0,'2023-04-09 17:20:00','2023-04-09 17:20:00',0),(3,3,2000,1200,800,'2023-04-09 17:20:00','2023-04-09 17:20:00',0);

/*Table structure for table `e_product` */

DROP TABLE IF EXISTS `e_product`;

CREATE TABLE `e_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(255) NOT NULL COMMENT '商品名称',
  `description` text NOT NULL COMMENT '商品描述',
  `category_id` bigint(20) NOT NULL COMMENT '商品分类ID',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `stock` int(11) NOT NULL COMMENT '商品库存',
  `sales` int(11) NOT NULL DEFAULT '0' COMMENT '商品销量',
  `is_integral` tinyint(1) DEFAULT '0' COMMENT '是否为积分商品，0表示不是，1表示是',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '商品状态，0：下架，1：在售',
  `create_time` datetime NOT NULL COMMENT '商品创建时间',
  `update_time` datetime NOT NULL COMMENT '商品更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';

/*Data for the table `e_product` */

insert  into `e_product`(`id`,`name`,`description`,`category_id`,`price`,`stock`,`sales`,`is_integral`,`status`,`create_time`,`update_time`,`is_del`) values (1,'Apple iPhone 12 Pro Max','iPhone 12 Pro Max 搭载了 5 纳米 A14 Bionic 芯片，性能比上一代更加出色，同时也拥有强大的摄像头和更好的显示效果。',1,'1099.00',100,50,0,1,'2022-04-10 10:00:00','2022-04-10 10:00:00',0),(2,'Samsung Galaxy S21 Ultra','Galaxy S21 Ultra 拥有 6.8 英寸的 AMOLED 显示屏、Exynos 2100 处理器以及 108MP 主摄像头等功能，同时还支持 5G 网络。',1,'899.00',200,80,0,1,'2022-04-11 10:00:00','2022-04-11 10:00:00',0),(3,'Sony PlayStation 5','PlayStation 5 是索尼游戏机的最新一代，采用了全新的定制处理器和高速固态硬盘，带来更加流畅的游戏体验。',2,'499.00',50,20,0,1,'2022-04-12 10:00:00','2022-04-12 10:00:00',0);

/*Table structure for table `e_recharge_plan` */

DROP TABLE IF EXISTS `e_recharge_plan`;

CREATE TABLE `e_recharge_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(50) NOT NULL COMMENT '充值方案名称',
  `amount` decimal(10,2) NOT NULL COMMENT '充值金额',
  `give_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '赠送金额',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='充值方案表';

/*Data for the table `e_recharge_plan` */

insert  into `e_recharge_plan`(`id`,`name`,`amount`,`give_amount`,`create_time`,`update_time`,`is_del`) values (1,'充值100元','100.00','0.00','2022-03-01 10:23:45','2022-03-01 10:23:45',0),(2,'充值200元','200.00','20.00','2022-03-02 13:45:12','2022-03-02 13:45:12',0),(3,'充值500元','500.00','50.00','2022-03-03 16:12:34','2022-03-03 16:12:34',0);

/*Table structure for table `e_shop` */

DROP TABLE IF EXISTS `e_shop`;

CREATE TABLE `e_shop` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `shop_name` varchar(50) NOT NULL COMMENT '店铺名称',
  `shop_desc` varchar(200) DEFAULT NULL COMMENT '店铺描述',
  `logo_url` varchar(200) NOT NULL COMMENT '店铺LOGO URL',
  `banner_url` varchar(200) DEFAULT NULL COMMENT '店铺横幅 URL',
  `province` varchar(20) NOT NULL COMMENT '省份',
  `city` varchar(20) NOT NULL COMMENT '城市',
  `district` varchar(20) NOT NULL COMMENT '区域',
  `detail` varchar(200) NOT NULL COMMENT '详细地址',
  `longitude` decimal(10,7) NOT NULL COMMENT '经度',
  `latitude` decimal(10,7) NOT NULL COMMENT '纬度',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-否，1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='店铺信息表';

/*Data for the table `e_shop` */

insert  into `e_shop`(`id`,`shop_name`,`shop_desc`,`logo_url`,`banner_url`,`province`,`city`,`district`,`detail`,`longitude`,`latitude`,`create_time`,`update_time`,`is_del`) values (1,'小米官方旗舰店','小米科技有限公司官方旗舰店','https://img14.360buyimg.com/n0/jfs/t1/130466/24/6321/21482/5f812308Ebbf37a33/82d94b9acdc081f3.png','https://img14.360buyimg.com/n0/jfs/t1/134056/15/10534/19007/5f81233dEf23d93c7/69ca81b566032c2d.jpg','北京市','北京市','朝阳区','三里屯SOHO','116.4619417','39.9416982','2022-01-01 10:00:00','2022-01-02 12:00:00',0),(2,'华为官方旗舰店','华为技术有限公司官方旗舰店','https://img14.360buyimg.com/n0/jfs/t1/115245/11/20162/26202/5f84e268E0b03ac99/9c0f1ed63d63c242.png','https://img14.360buyimg.com/n0/jfs/t1/157430/2/1125/15050/5f84e30eE78d89b10/f72d5e5c5f8e9de4.jpg','广东省','深圳市','南山区','华为基地','113.9338370','22.5477890','2022-01-03 14:00:00','2022-01-04 16:00:00',0);

/*Table structure for table `e_shopping_cart` */

DROP TABLE IF EXISTS `e_shopping_cart`;

CREATE TABLE `e_shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `sku_id` int(11) NOT NULL COMMENT 'SKU ID',
  `quantity` int(11) NOT NULL COMMENT '商品数量',
  `selected` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否选中，1为选中，0为未选中',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0为未删除，1为已删除',
  PRIMARY KEY (`id`),
  KEY `uid_index` (`uid`),
  KEY `product_id_index` (`product_id`),
  KEY `sku_id_index` (`sku_id`),
  KEY `selected_index` (`selected`),
  KEY `is_del_index` (`is_del`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='购物车表';

/*Data for the table `e_shopping_cart` */

insert  into `e_shopping_cart`(`id`,`uid`,`product_id`,`sku_id`,`quantity`,`selected`,`create_time`,`update_time`,`is_del`) values (1,10001,1,1,2,1,'2023-04-10 10:00:00','2023-04-10 10:00:00',0),(2,10001,2,3,1,0,'2023-04-10 10:00:00','2023-04-10 10:00:00',0),(3,10002,1,2,1,1,'2023-04-10 10:00:00','2023-04-10 10:00:00',0),(4,10002,3,5,3,1,'2023-04-10 10:00:00','2023-04-10 10:00:00',0),(5,10003,2,4,2,0,'2023-04-10 10:00:00','2023-04-10 10:00:00',0),(6,10004,4,8,1,1,'2023-04-10 10:00:00','2023-04-10 10:00:00',0),(7,10004,5,10,2,1,'2023-04-10 10:00:00','2023-04-10 10:00:00',0);

/*Table structure for table `e_sku` */

DROP TABLE IF EXISTS `e_sku`;

CREATE TABLE `e_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `product_id` bigint(20) NOT NULL COMMENT '商品ID',
  `sku_code` varchar(50) NOT NULL COMMENT 'SKU编码',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `stock` int(11) NOT NULL COMMENT '库存',
  `specification` varchar(255) NOT NULL COMMENT '规格，如"颜色:红色,尺寸:XL"',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='SKU表';

/*Data for the table `e_sku` */

insert  into `e_sku`(`id`,`product_id`,`sku_code`,`price`,`stock`,`specification`,`create_time`,`update_time`,`is_del`) values (1,1,'1001','99.00',100,'颜色:红色,尺寸:XL','2022-03-01 10:23:45','2022-03-01 10:23:45',0),(2,1,'1002','99.00',200,'颜色:蓝色,尺寸:L','2022-03-02 13:45:12','2022-03-02 13:45:12',0),(3,2,'2001','199.00',50,'颜色:黑色,尺寸:M','2022-03-03 16:12:34','2022-03-03 16:12:34',0);

/*Table structure for table `e_system_info` */

DROP TABLE IF EXISTS `e_system_info`;

CREATE TABLE `e_system_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(50) NOT NULL COMMENT '信息名称',
  `value` varchar(200) DEFAULT NULL COMMENT '信息值',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-否，1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='系统信息存储表';

/*Data for the table `e_system_info` */

insert  into `e_system_info`(`id`,`name`,`value`,`create_time`,`update_time`,`is_del`) values (1,'客服电话','400-888-8888','2022-01-01 00:00:00','2022-01-01 00:00:00',0),(2,'客服QQ','12345678','2022-01-01 00:00:00','2022-01-01 00:00:00',0),(3,'客服邮箱','service@mall.com','2022-01-01 00:00:00','2022-01-01 00:00:00',0),(4,'备案号','京ICP备12345678号','2022-01-01 00:00:00','2022-01-01 00:00:00',0),(5,'版权信息','©2022 mall.com','2022-01-01 00:00:00','2022-01-01 00:00:00',0);

/*Table structure for table `e_system_message` */

DROP TABLE IF EXISTS `e_system_message`;

CREATE TABLE `e_system_message` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `title` varchar(100) NOT NULL COMMENT '消息标题',
  `content` text NOT NULL COMMENT '消息内容',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '消息状态，0-未读，1-已读',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-否，1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='系统消息表';

/*Data for the table `e_system_message` */

insert  into `e_system_message`(`id`,`title`,`content`,`status`,`create_time`,`update_time`,`is_del`) values (1,'优惠券到账提醒','尊敬的用户，恭喜您获得了一张10元优惠券，有效期为7天，请尽快使用哦~',0,'2022-02-01 08:00:00','2022-02-01 08:00:00',0),(2,'订单发货提醒','尊敬的用户，您的订单已发货，物流单号为1234567890，请注意查收哦~',0,'2022-02-02 14:30:00','2022-02-02 14:30:00',0),(3,'新品上架通知','尊敬的用户，我们有新品上架啦，快来抢购吧~',0,'2022-02-05 10:00:00','2022-02-05 10:00:00',0),(4,'订单退款通知','尊敬的用户，您的订单已申请退款，我们会尽快处理，退款金额将在3个工作日内返还至您的账户，请您耐心等待哦~',0,'2022-02-08 16:20:00','2022-02-08 16:20:00',0),(5,'积分变动通知','尊敬的用户，您的积分增加了50分，当前积分余额为150分，感谢您的支持~',0,'2022-02-10 11:30:00','2022-02-10 11:30:00',0),(6,'系统维护通知','尊敬的用户，为了更好的用户体验，我们将于明天上午进行系统维护，届时商城将无法访问，请您提前做好准备，给您带来的不便敬请谅解~',0,'2022-02-10 11:30:00','2022-02-10 11:30:00',0);

/*Table structure for table `e_user` */

DROP TABLE IF EXISTS `e_user`;

CREATE TABLE `e_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `avator` varchar(1000) DEFAULT NULL COMMENT '头像',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `e_user` */

insert  into `e_user`(`id`,`username`,`password`,`avator`,`email`,`phone`,`is_del`,`create_time`,`update_time`) values (1,'user1','e10adc3949ba59abbe56e057f20f883e','https://api.multiavatar.com/micah.png','user1@example.com','13800138001',0,'2021-01-01 00:00:00','2021-01-01 00:00:00'),(2,'user2','e10adc3949ba59abbe56e057f20f883e','https://th.bing.com/th/id/R.629105f8e48009c659b8a4048adef1cc?rik=0LttQdHqnl3ang&riu=http%3a%2f%2fimg.wxcha.com%2ffile%2f202005%2f19%2fdeb4d01b77.jpg&ehk=6DKzNVR5O4Oa%2fZxvhM9ea0W9jpJVSfAZVW4mPemcz3k%3d&risl=&pid=ImgRaw&r=0','user2@example.com','13800138002',0,'2021-01-02 00:00:00','2021-01-02 00:00:00'),(3,'micah','1231','https://th.bing.com/th/id/R.629105f8e48009c659b8a4048adef1cc?rik=0LttQdHqnl3ang&riu=http%3a%2f%2fimg.wxcha.com%2ffile%2f202005%2f19%2fdeb4d01b77.jpg&ehk=6DKzNVR5O4Oa%2fZxvhM9ea0W9jpJVSfAZVW4mPemcz3k%3d&risl=&pid=ImgRaw&r=0','1231','13312341234',0,'2023-04-08 15:54:00','2023-04-08 15:54:00'),(10,'userr','e10adc3949ba59abbe56e057f20f883e',NULL,'1352779729@qq.com','13345674123',0,'2023-04-09 12:56:14','2023-04-09 12:56:14');

/*Table structure for table `e_user_behavior` */

DROP TABLE IF EXISTS `e_user_behavior`;

CREATE TABLE `e_user_behavior` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `product_id` bigint(20) NOT NULL COMMENT '商品ID',
  `behavior_type` tinyint(1) NOT NULL COMMENT '用户行为类型，1：收藏，2：点赞，3：足迹',
  `create_time` datetime NOT NULL COMMENT '行为创建时间',
  `update_time` datetime NOT NULL COMMENT '行为更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  KEY `behavior_type` (`behavior_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户行为表';

/*Data for the table `e_user_behavior` */

insert  into `e_user_behavior`(`id`,`user_id`,`product_id`,`behavior_type`,`create_time`,`update_time`,`is_del`) values (1,1,1,1,'2022-04-10 10:00:00','2022-04-10 10:00:00',0),(2,1,2,1,'2022-04-11 10:00:00','2022-04-11 10:00:00',0),(3,1,3,1,'2022-04-12 10:00:00','2022-04-12 10:00:00',0),(4,2,3,1,'2022-04-13 10:00:00','2022-04-13 10:00:00',0),(5,2,4,2,'2022-04-14 10:00:00','2022-04-14 10:00:00',0),(6,2,5,3,'2022-04-15 10:00:00','2022-04-15 10:00:00',0);

/*Table structure for table `e_wallet` */

DROP TABLE IF EXISTS `e_wallet`;

CREATE TABLE `e_wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '余额',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='用户钱包表';

/*Data for the table `e_wallet` */

insert  into `e_wallet`(`id`,`uid`,`balance`,`create_time`,`update_time`,`is_del`) values (1,1001,'5000.00','2022-03-01 10:23:45','2022-03-01 10:23:45',0),(2,1002,'10000.00','2022-03-02 13:45:12','2022-03-02 13:45:12',0),(3,1003,'3000.00','2022-03-03 16:12:34','2022-03-03 16:12:34',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
