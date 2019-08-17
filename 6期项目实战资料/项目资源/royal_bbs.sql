/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.5.49 : Database - royal_bbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`royal_bbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `royal_bbs`;

/*Table structure for table `bbs_article_table` */

DROP TABLE IF EXISTS `bbs_article_table`;

CREATE TABLE `bbs_article_table` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子编号',
  `title` varchar(500) DEFAULT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `sendTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  `senderName` varchar(255) NOT NULL COMMENT '发送人编号',
  `isTop` int(11) NOT NULL DEFAULT '0' COMMENT '是否置顶，如果是0，代表不置顶；如果是1，代表置顶；',
  `replyCount` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `upvoteCount` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `browseCount` int(11) NOT NULL DEFAULT '0' COMMENT '浏览数',
  `zoneId` int(11) NOT NULL COMMENT '所在交流区',
  `isReport` int(2) DEFAULT '0' COMMENT '举报状态',
  PRIMARY KEY (`articleId`) USING BTREE,
  KEY `FK_bbs_article_table` (`zoneId`) USING BTREE,
  CONSTRAINT `FK_bbs_article_table` FOREIGN KEY (`zoneId`) REFERENCES `bbs_zone_table` (`zoneId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_article_table` */

insert  into `bbs_article_table`(`articleId`,`title`,`content`,`sendTime`,`senderName`,`isTop`,`replyCount`,`upvoteCount`,`browseCount`,`zoneId`,`isReport`) values 
(2,'桂林游记','<span style=\"background-color:#FFE500;\">桂林米粉很好吃！下次请你们!</span>','2017-05-14 22:10:10','jacky',0,3,3,426,1,0),
(6,'娃哈哈','娃哈哈123','2017-05-17 13:34:57','admin',0,2,0,0,1,0),
(7,'今天天气不错！','今天天气不错！','2017-05-17 13:38:02','admin',0,8,1,0,1,1),
(8,'王者荣耀我来了！','王者荣耀我来了！','2017-05-19 15:36:48','admin',1,5,6,87,1,0),
(11,'哈哈哈','哈哈哈','2017-05-21 20:31:19','admin',0,0,0,0,1,0),
(12,'嘻嘻嘻嘻','嘻嘻嘻嘻','2017-05-21 20:32:52','admin',1,5,1,0,1,0),
(13,'王者荣耀归来啦！','王者荣耀归来啦！','2017-05-22 17:38:11','admin',1,0,0,0,1,0);

/*Table structure for table `bbs_comment_table` */

DROP TABLE IF EXISTS `bbs_comment_table`;

CREATE TABLE `bbs_comment_table` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `commentContent` varchar(255) NOT NULL COMMENT '评论内容',
  `commentTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `commentUserName` varchar(255) NOT NULL COMMENT '评论人',
  `commentStatus` int(11) DEFAULT '0' COMMENT '评论状态，1代表屏蔽，0代表解除',
  `articleId` int(11) NOT NULL COMMENT '帖子编号',
  PRIMARY KEY (`commentId`) USING BTREE,
  KEY `FK_bbs_comment_table` (`articleId`) USING BTREE,
  CONSTRAINT `FK_bbs_comment_table` FOREIGN KEY (`articleId`) REFERENCES `bbs_article_table` (`articleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_comment_table` */

/*Table structure for table `bbs_reply_table` */

DROP TABLE IF EXISTS `bbs_reply_table`;

CREATE TABLE `bbs_reply_table` (
  `replyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复编号',
  `replyContent` varchar(255) NOT NULL COMMENT '回复内容',
  `replyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
  `replyUserName` varchar(255) NOT NULL COMMENT '回复人',
  `commentId` int(11) DEFAULT NULL COMMENT '评论编号',
  PRIMARY KEY (`replyId`) USING BTREE,
  KEY `FK_bbs_reply_table` (`commentId`) USING BTREE,
  CONSTRAINT `FK_bbs_reply_table` FOREIGN KEY (`commentId`) REFERENCES `bbs_comment_table` (`commentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_reply_table` */

/*Table structure for table `bbs_report_table` */

DROP TABLE IF EXISTS `bbs_report_table`;

CREATE TABLE `bbs_report_table` (
  `reportId` int(11) NOT NULL AUTO_INCREMENT,
  `reportContent` varchar(255) DEFAULT NULL COMMENT '举报内容',
  `reportTime` timestamp NULL DEFAULT NULL COMMENT '举报时间',
  `reportUserName` varchar(255) DEFAULT NULL COMMENT '举报人',
  `reportStatus` int(2) DEFAULT NULL COMMENT '处理状态',
  `articleId` int(11) DEFAULT NULL COMMENT '文章ID',
  PRIMARY KEY (`reportId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_report_table` */

insert  into `bbs_report_table`(`reportId`,`reportContent`,`reportTime`,`reportUserName`,`reportStatus`,`articleId`) values 
(1,'敏感词汇','2019-06-22 10:57:11','zhangsan',1,8),
(2,'内容有问题','2019-06-22 11:27:33','zhangsan1',1,8);

/*Table structure for table `bbs_upvote_table` */

DROP TABLE IF EXISTS `bbs_upvote_table`;

CREATE TABLE `bbs_upvote_table` (
  `upvoteUserName` varchar(255) NOT NULL COMMENT '点赞人',
  `upvoteArticleId` int(11) NOT NULL COMMENT '点赞帖子',
  `isUpvote` int(11) NOT NULL DEFAULT '1' COMMENT '点赞状态，0代表未点赞，1代表已点赞（默认）',
  PRIMARY KEY (`upvoteUserName`,`upvoteArticleId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_upvote_table` */

insert  into `bbs_upvote_table`(`upvoteUserName`,`upvoteArticleId`,`isUpvote`) values 
('admin',8,1);

/*Table structure for table `bbs_user_table` */

DROP TABLE IF EXISTS `bbs_user_table`;

CREATE TABLE `bbs_user_table` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `userPass` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `picUrl` varchar(255) DEFAULT NULL COMMENT '头像',
  `role` int(11) NOT NULL DEFAULT '1' COMMENT '1代表普通用户；2代表高级用户，3代表超级管理员',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `loginStatus` int(11) DEFAULT '0' COMMENT '登录状态，0代表未登录，1代表已登录',
  `talkStatus` int(11) NOT NULL DEFAULT '0' COMMENT '发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言',
  `isupdating` int(2) DEFAULT '0' COMMENT '申请升级(0-未申请,1-已申请)',
  `updateStatus` int(2) unsigned DEFAULT '0' COMMENT '申请升级审核状态(0-未处理,1-已处理)',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE KEY `uni_user_userName` (`userName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_user_table` */

insert  into `bbs_user_table`(`userId`,`userName`,`userPass`,`email`,`picUrl`,`role`,`lastLoginTime`,`loginStatus`,`talkStatus`,`isupdating`,`updateStatus`) values 
(4,'admin','admin','','uploads/e44478e07cc54fdb92daf9de48dfff78.png',3,'2019-06-24 00:40:30',0,0,0,0);

/*Table structure for table `bbs_word_table` */

DROP TABLE IF EXISTS `bbs_word_table`;

CREATE TABLE `bbs_word_table` (
  `wordId` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) DEFAULT NULL COMMENT '敏感词',
  `status` int(2) DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`wordId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_word_table` */

insert  into `bbs_word_table`(`wordId`,`word`,`status`) values 
(1,'卧槽',0),
(2,'尼玛',0),
(3,'我就呵呵',0),
(4,'老铁666啊',0),
(5,'呵呵',0),
(6,'六的一批',0),
(7,'纳尼',0),
(8,'老牛',0),
(9,'牛皮',0),
(10,'嘻嘻',1);

/*Table structure for table `bbs_zone_table` */

DROP TABLE IF EXISTS `bbs_zone_table`;

CREATE TABLE `bbs_zone_table` (
  `zoneId` int(11) NOT NULL AUTO_INCREMENT COMMENT '交流区编号',
  `zoneName` varchar(255) NOT NULL COMMENT '交流区名字',
  `isDef` int(11) NOT NULL COMMENT '是否默认，1代表默认，2代表非默认',
  PRIMARY KEY (`zoneId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_zone_table` */

insert  into `bbs_zone_table`(`zoneId`,`zoneName`,`isDef`) values 
(1,'综合交流区',1),
(2,'BUG反馈区',2),
(3,'新闻公告区',2),
(4,'活动专区',2);

/*Table structure for table `bbs_zoneapply_table` */

DROP TABLE IF EXISTS `bbs_zoneapply_table`;

CREATE TABLE `bbs_zoneapply_table` (
  `applyZoneId` int(11) NOT NULL AUTO_INCREMENT,
  `zoneName` varchar(32) DEFAULT NULL COMMENT '新增板块名字',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `status` int(2) DEFAULT '0' COMMENT '处理状态(未处理-0,已处理-1)',
  PRIMARY KEY (`applyZoneId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bbs_zoneapply_table` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
