/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : bidding

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 30/04/2026 17:13:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for changdiyuyue
-- ----------------------------
DROP TABLE IF EXISTS `changdiyuyue`;
CREATE TABLE `changdiyuyue`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `changdimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '场地名称',
  `changdileixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '场地类型',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `shiyongshijian` datetime NULL DEFAULT NULL COMMENT '使用时间',
  `yuyueshijian` datetime NULL DEFAULT NULL COMMENT '预约时间',
  `toubiaozhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标账号',
  `toubiaorenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人姓名',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '场地预约' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of changdiyuyue
-- ----------------------------
INSERT INTO `changdiyuyue` VALUES (1, '2025-12-24 20:45:12', '项目评审专区B102', '异地协作室', '东部新城智慧交通管理系统升级项目', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_5', '孙七', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (2, '2025-12-24 20:45:12', '项目评审专区B102', '异地协作室', '省实验中学体育馆加固与翻新工程', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_6', '周八', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (3, '2025-12-24 20:45:12', '政务中心七号会议室', '异地协作室', '滨海新区海绵城市生态修复（一期）', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_5', '孙七', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (4, '2025-12-24 20:45:12', '项目评审专区B102', '异地协作室', '市政务云平台数据中心扩容采购', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_1', '张三', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (5, '2025-12-24 20:45:12', '公共资源交易大厅', '评标室', '文化宫片区旧城改造拆迁评估服务', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_3', '王五', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (6, '2025-12-24 20:45:12', '政务中心七号会议室', '多功能评审室', '高新区智能制造产业园分布式光伏项目', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_8', '郑十', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (7, '2025-12-24 20:45:12', '综合评标会议室', '异地协作室', '市图书馆数字化馆藏资源库扩建', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_2', '李四', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (8, '2025-12-24 20:45:12', '综合评标会议室', '异地协作室', '人民医院医学影像云存储及传输服务', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_4', '赵六', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (9, '2025-12-24 20:45:12', '政务中心七号会议室', '开标室', '南北快速路隧道照明亮化提升工程', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_3', '王五', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (10, '2025-12-24 20:45:12', '电子开标室03', '会议室', '湿地保护区鸟类监测物联网平台建设', '2025-12-24 20:45:12', '2025-12-24 20:45:12', 'user_2', '李四', '是', '准予预约');
INSERT INTO `changdiyuyue` VALUES (11, '2025-12-24 20:59:13', '凤娃', '热歌', '过热', '2025-02-26 00:00:00', '2025-12-24 20:59:05', 'user_2', '李四', '是', '通过');

-- ----------------------------
-- Table structure for chengjieqingqiu
-- ----------------------------
DROP TABLE IF EXISTS `chengjieqingqiu`;
CREATE TABLE `chengjieqingqiu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业账号',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代理公司账号',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代理公司名称',
  `lianxidianhua` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `fuwuchengnuo` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '服务承诺',
  `zizhiwenjian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '资质文件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '承接申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chengjieqingqiu
-- ----------------------------
INSERT INTO `chengjieqingqiu` VALUES (5, '2026-04-17 16:30:37', '南北快速路隧道照明亮化提升工程', 'owner_6', 'agency_1', '同诚招标代理公司', '18166665551', '123', '');
INSERT INTO `chengjieqingqiu` VALUES (6, '2026-04-17 16:37:23', '省实验中学体育馆加固与翻新工程', 'owner_1', 'agency_1', '同诚招标代理公司', '18166665551', '交给我你放心', 'file/qyzz1.jpg');

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `value` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '轮播图' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, '2025-12-24 20:45:12', 'swiper1', 'file/swiperPicture1.jpg');
INSERT INTO `config` VALUES (2, '2025-12-24 20:45:12', 'swiper2', 'file/swiperPicture2.jpg');
INSERT INTO `config` VALUES (3, '2025-12-24 20:45:12', 'swiper3', 'file/swiperPicture3.jpg');

-- ----------------------------
-- Table structure for dailipingjia
-- ----------------------------
DROP TABLE IF EXISTS `dailipingjia`;
CREATE TABLE `dailipingjia`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司账号',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司名称',
  `manyidu` int NULL DEFAULT NULL COMMENT '满意度',
  `pingjianeirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '评价内容',
  `yezhuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '业主账号',
  `yezhumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '业主名称',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '代理评价' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dailipingjia
-- ----------------------------
INSERT INTO `dailipingjia` VALUES (9, '2026-04-17 16:38:59', 'agency_1', '同诚招标代理公司', 9, '9分', 'owner_1', '中天建设集团有限公司', '东部新城智慧交通管理系统升级项目');

-- ----------------------------
-- Table structure for hetongbeian
-- ----------------------------
DROP TABLE IF EXISTS `hetongbeian`;
CREATE TABLE `hetongbeian`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `zhaobiaoren` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标人',
  `zhaobiaofanwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标范围',
  `toubiaojiezhishijian` date NULL DEFAULT NULL COMMENT '投标截止时间',
  `kaibiaoshijian` date NULL DEFAULT NULL COMMENT '开标时间',
  `xiangmudidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目地点',
  `xiangmuzhouqi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目周期',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `qiyemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业名称',
  `toubiaorenzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人账号',
  `toubiaorenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人姓名',
  `hetong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '合同',
  `qianyueshijian` datetime NULL DEFAULT NULL COMMENT '签约时间',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司账号',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '合同备案' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hetongbeian
-- ----------------------------
INSERT INTO `hetongbeian` VALUES (1, '2025-12-24 20:45:12', '省实验中学体育馆加固与翻新工程', '发包方负责人1', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '东部新区经开路12号', '180个日历天', 'owner_1', '中天建设集团有限公司', 'user_1', '张三', '', '2025-12-24 20:45:12', 'agency_1', '同诚招标代理公司');
INSERT INTO `hetongbeian` VALUES (2, '2025-12-24 20:45:12', '滨海新区海绵城市生态修复（一期）', '发包方负责人2', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '高新区创新园区B座', '24个月', 'owner_5', '格力电器销售有限公司', 'user_5', '孙七', '', '2025-12-24 20:45:12', 'agency_5', '中经国际招标部');
INSERT INTO `hetongbeian` VALUES (3, '2025-12-24 20:45:12', '市政务云平台数据中心扩容采购', '发包方负责人3', '第三方安全监理与质量检测', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '365天', 'owner_6', '海尔智家北京分公司', 'user_6', '周八', '', '2025-12-24 20:45:12', 'agency_6', '弘业项目管理公司');
INSERT INTO `hetongbeian` VALUES (4, '2025-12-24 20:45:12', '文化宫片区旧城改造拆迁评估服务', '发包方负责人4', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '自合同签订起90天', 'owner_7', '万科企业股份有限公司', 'user_7', '吴九', '', '2025-12-24 20:45:12', 'agency_7', '捷诚信达招标公司');
INSERT INTO `hetongbeian` VALUES (5, '2025-12-24 20:45:12', '高新区智能制造产业园分布式光伏项目', '发包方负责人5', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '空港经济区现代物流园', '180个日历天', 'owner_3', '顺丰速递物流中心', 'user_3', '王五', '', '2025-12-24 20:45:12', 'agency_3', '广厦项目管理公司');
INSERT INTO `hetongbeian` VALUES (6, '2025-12-24 20:45:12', '市图书馆数字化馆藏资源库扩建', '发包方负责人6', '第三方安全监理与质量检测', '2025-12-24', '2025-12-24', '东部新区经开路12号', '24个月', 'owner_7', '万科企业股份有限公司', 'user_7', '吴九', '', '2025-12-24 20:45:12', 'agency_7', '捷诚信达招标公司');
INSERT INTO `hetongbeian` VALUES (7, '2025-12-24 20:45:12', '人民医院医学影像云存储及传输服务', '发包方负责人7', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '高新区创新园区B座', '365天', 'owner_5', '格力电器销售有限公司', 'user_5', '孙七', '', '2025-12-24 20:45:12', 'agency_5', '中经国际招标部');
INSERT INTO `hetongbeian` VALUES (9, '2025-12-24 20:45:12', '东部新城智慧交通管理系统升级项目', '发包方负责人9', '第三方安全监理与质量检测', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '180个日历天', 'owner_1', '中天建设集团有限公司', 'user_1', '张三', '', '2025-12-24 20:45:12', 'agency_1', '同诚招标代理公司');
INSERT INTO `hetongbeian` VALUES (10, '2025-12-24 20:45:12', '省实验中学体育馆加固与翻新工程', '发包方负责人10', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '空港经济区现代物流园', '24个月', 'owner_6', '海尔智家北京分公司', 'user_6', '周八', '', '2025-12-24 20:45:12', 'agency_6', '弘业项目管理公司');
INSERT INTO `hetongbeian` VALUES (11, '2025-12-24 20:58:26', '滨海新区海绵城市生态修复（一期）', '', '范文芳', '2025-02-27', '2025-12-24', '范围阿帆', '34', 'owner_2', '华润置地(北京)有限公司', 'user_2', '李四', 'file/1739797103099.docx', '2025-02-19 00:00:00', 'agency_2', '华审工程咨询中心');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '2025-12-24 20:45:12', '[{\"backMenu\": [{\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-shop\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"classname\": \"yezhudanwei\", \"menu\": \"业主单位\", \"menuJump\": \"列表\", \"tableName\": \"yezhudanwei\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-vip\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"toubiaodanwei\", \"menu\": \"投标单位\", \"menuJump\": \"列表\", \"tableName\": \"toubiaodanwei\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-taxi\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"classname\": \"zhaobiaodaili\", \"menu\": \"招标代理\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaodaili\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-explore\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"users\", \"menu\": \"管理员\", \"menuJump\": \"列表\", \"tableName\": \"users\"}], \"fontClass\": \"icon-user8\", \"menu\": \"用户管理\", \"unicode\": \"&#xef9e;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\", \"投标\"], \"appFrontIcon\": \"cuIcon-present\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"classname\": \"zhaobiaoxiangmu\", \"menu\": \"招标项目\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaoxiangmu\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"中标公告\", \"查看履历\"], \"appFrontIcon\": \"cuIcon-pay\", \"buttons\": [\"查看\", \"修改\", \"删除\", \"查看履历\"], \"classname\": \"toubiaoxinxi\", \"menu\": \"投标信息\", \"menuJump\": \"列表\", \"tableName\": \"toubiaoxinxi\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"合同备案\", \"查看履历\"], \"appFrontIcon\": \"cuIcon-album\", \"buttons\": [\"查看\", \"修改\", \"删除\", \"查看履历\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}, {\"allButtons\": [\"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-evaluate\", \"buttons\": [\"查看\", \"修改\", \"删除\"], \"classname\": \"dailipingjia\", \"menu\": \"代理评价\", \"menuJump\": \"列表\", \"tableName\": \"dailipingjia\"}], \"fontClass\": \"icon-common16\", \"menu\": \"招标项目管理\", \"unicode\": \"&#edfd;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-discover\", \"buttons\": [\"查看\", \"修改\", \"删除\", \"审核\"], \"classname\": \"tousuxinxi\", \"menu\": \"投诉信息\", \"menuJump\": \"列表\", \"tableName\": \"tousuxinxi\"}], \"fontClass\": \"icon-common38\", \"menu\": \"投诉信息管理\", \"unicode\": \"&#xeeb2;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-rank\", \"buttons\": [\"查看\", \"修改\", \"删除\", \"审核\"], \"classname\": \"zhaobiaogonggao\", \"menu\": \"招标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaogonggao\"}], \"fontClass\": \"icon-common18\", \"menu\": \"招标公告管理\", \"unicode\": \"&#edff;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-wenzi\", \"buttons\": [\"查看\", \"修改\", \"删除\", \"审核\"], \"classname\": \"changdiyuyue\", \"menu\": \"场地预约\", \"menuJump\": \"列表\", \"tableName\": \"changdiyuyue\"}], \"fontClass\": \"icon-common13\", \"menu\": \"场地预约管理\", \"unicode\": \"&#xedf7;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-addressbook\", \"buttons\": [\"查看\", \"修改\", \"删除\"], \"classname\": \"zhaobiaojihua\", \"menu\": \"招标计划\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaojihua\"}, {\"allButtons\": [\"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-addressbook\", \"buttons\": [\"查看\", \"修改\", \"删除\"], \"classname\": \"chengjieqingqiu\", \"menu\": \"承接记录\", \"menuJump\": \"列表\", \"tableName\": \"chengjieqingqiu\"}], \"fontClass\": \"icon-common1\", \"menu\": \"招标计划管理\", \"unicode\": \"&#xeda3;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-newshot\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"config\", \"menu\": \"轮播图\", \"menuJump\": \"列表\", \"tableName\": \"config\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-pic\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"news\", \"menu\": \"系统公告\", \"menuJump\": \"列表\", \"tableName\": \"news\"}, {\"allButtons\": [\"菜单管理\"], \"appFrontIcon\": \"cuIcon-form\", \"buttons\": [\"菜单管理\"], \"classname\": \"menu\", \"menu\": \"菜单\", \"menuJump\": \"列表\", \"tableName\": \"menu\"}], \"fontClass\": \"icon-common31\", \"menu\": \"系统管理\", \"unicode\": \"&#xee48;\"}], \"frontMenu\": [{\"child\": [{\"appFrontIcon\": \"cuIcon-flashlightopen\", \"buttons\": [\"查看\", \"投标\"], \"classname\": \"zhaobiaoxiangmu\", \"menu\": \"招标项目\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaoxiangmu\"}], \"menu\": \"招标项目管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-link\", \"buttons\": [\"查看\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}], \"menu\": \"中标公告管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-circle\", \"buttons\": [\"查看\"], \"classname\": \"zhaobiaogonggao\", \"menu\": \"招标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaogonggao\"}], \"menu\": \"招标公告管理\"}], \"hasBackLogin\": \"是\", \"hasBackRegister\": \"否\", \"hasFrontLogin\": \"否\", \"hasFrontRegister\": \"否\", \"pathName\": \"users\", \"roleName\": \"管理员\", \"tableName\": \"users\"}, {\"backMenu\": [{\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\", \"投标\"], \"appFrontIcon\": \"cuIcon-present\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"zhaobiaoxiangmu\", \"menu\": \"招标项目\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaoxiangmu\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"中标公告\"], \"appFrontIcon\": \"cuIcon-pay\", \"buttons\": [\"查看\"], \"classname\": \"toubiaoxinxi\", \"menu\": \"投标信息\", \"menuJump\": \"列表\", \"tableName\": \"toubiaoxinxi\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"合同备案\", \"查看履历\"], \"appFrontIcon\": \"cuIcon-album\", \"buttons\": [\"查看\", \"合同备案\", \"查看履历\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"评价代理\"], \"appFrontIcon\": \"cuIcon-clothes\", \"buttons\": [\"查看\", \"修改\", \"删除\", \"评价代理\"], \"classname\": \"hetongbeian\", \"menu\": \"合同备案\", \"menuJump\": \"列表\", \"tableName\": \"hetongbeian\"}, {\"allButtons\": [\"查看\"], \"appFrontIcon\": \"cuIcon-taxi\", \"buttons\": [\"查看\"], \"classname\": \"zhaobiaodaili\", \"menu\": \"招标代理\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaodaili\"}, {\"allButtons\": [\"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-evaluate\", \"buttons\": [\"查看\", \"修改\", \"删除\"], \"classname\": \"dailipingjia\", \"menu\": \"代理评价\", \"menuJump\": \"列表\", \"tableName\": \"dailipingjia\"}], \"fontClass\": \"icon-common16\", \"menu\": \"招标项目管理\", \"unicode\": \"&#edfd;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"appFrontIcon\": \"cuIcon-addressbook\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"zhaobiaojihua\", \"menu\": \"招标计划\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaojihua\"}, {\"allButtons\": [\"查看\"], \"appFrontIcon\": \"cuIcon-addressbook\", \"buttons\": [\"查看\"], \"classname\": \"chengjieqingqiu\", \"menu\": \"承接申请\", \"menuJump\": \"列表\", \"tableName\": \"chengjieqingqiu\"}], \"fontClass\": \"icon-common1\", \"menu\": \"招标计划管理\", \"unicode\": \"&#xeda3;\"}], \"frontMenu\": [{\"child\": [{\"appFrontIcon\": \"cuIcon-flashlightopen\", \"buttons\": [\"查看\", \"投标\"], \"classname\": \"zhaobiaoxiangmu\", \"menu\": \"招标项目\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaoxiangmu\"}], \"menu\": \"招标项目管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-link\", \"buttons\": [\"查看\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}], \"menu\": \"中标公告管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-circle\", \"buttons\": [\"查看\"], \"classname\": \"zhaobiaogonggao\", \"menu\": \"招标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaogonggao\"}], \"menu\": \"招标公告管理\"}], \"hasBackLogin\": \"是\", \"hasBackRegister\": \"是\", \"hasFrontLogin\": \"否\", \"hasFrontRegister\": \"否\", \"pathName\": \"yezhudanwei\", \"roleName\": \"业主单位\", \"tableName\": \"yezhudanwei\"}, {\"backMenu\": [{\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"中标公告\"], \"appFrontIcon\": \"cuIcon-pay\", \"buttons\": [\"查看\", \"删除\"], \"classname\": \"toubiaoxinxi\", \"menu\": \"投标信息\", \"menuJump\": \"列表\", \"tableName\": \"toubiaoxinxi\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"合同备案\"], \"appFrontIcon\": \"cuIcon-album\", \"buttons\": [\"查看\", \"删除\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"评价代理\"], \"appFrontIcon\": \"cuIcon-clothes\", \"buttons\": [\"查看\", \"删除\"], \"classname\": \"hetongbeian\", \"menu\": \"合同备案\", \"menuJump\": \"列表\", \"tableName\": \"hetongbeian\"}, {\"allButtons\": [\"查看\"], \"appFrontIcon\": \"cuIcon-evaluate\", \"buttons\": [\"查看\"], \"classname\": \"dailipingjia\", \"menu\": \"代理评价\", \"menuJump\": \"列表\", \"tableName\": \"dailipingjia\"}], \"fontClass\": \"icon-common16\", \"menu\": \"招标项目管理\", \"unicode\": \"&#edfd;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-discover\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"tousuxinxi\", \"menu\": \"投诉信息\", \"menuJump\": \"列表\", \"tableName\": \"tousuxinxi\"}], \"fontClass\": \"icon-common38\", \"menu\": \"投诉信息管理\", \"unicode\": \"&#xeeb2;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-wenzi\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"changdiyuyue\", \"menu\": \"场地预约\", \"menuJump\": \"列表\", \"tableName\": \"changdiyuyue\"}], \"fontClass\": \"icon-common13\", \"menu\": \"场地预约管理\", \"unicode\": \"&#edf7;\"}], \"frontMenu\": [{\"child\": [{\"appFrontIcon\": \"cuIcon-flashlightopen\", \"buttons\": [\"查看\", \"投标\"], \"classname\": \"zhaobiaoxiangmu\", \"menu\": \"招标项目\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaoxiangmu\"}], \"menu\": \"招标项目管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-link\", \"buttons\": [\"查看\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}], \"menu\": \"中标公告管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-circle\", \"buttons\": [\"查看\"], \"classname\": \"zhaobiaogonggao\", \"menu\": \"招标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaogonggao\"}], \"menu\": \"招标公告管理\"}], \"hasBackLogin\": \"否\", \"hasBackRegister\": \"否\", \"hasFrontLogin\": \"是\", \"hasFrontRegister\": \"是\", \"pathName\": \"toubiaodanwei\", \"roleName\": \"投标单位\", \"tableName\": \"toubiaodanwei\"}, {\"backMenu\": [{\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\", \"投标\"], \"appFrontIcon\": \"cuIcon-present\", \"buttons\": [\"查看\"], \"classname\": \"zhaobiaoxiangmu\", \"menu\": \"招标项目\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaoxiangmu\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"中标公告\", \"查看履历\"], \"appFrontIcon\": \"cuIcon-pay\", \"buttons\": [\"查看\", \"中标公告\", \"查看履历\"], \"classname\": \"toubiaoxinxi\", \"menu\": \"投标信息\", \"menuJump\": \"列表\", \"tableName\": \"toubiaoxinxi\"}, {\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"合同备案\"], \"appFrontIcon\": \"cuIcon-album\", \"buttons\": [\"查看\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}, {\"allButtons\": [\"查看\"], \"appFrontIcon\": \"cuIcon-evaluate\", \"buttons\": [\"查看\"], \"classname\": \"dailipingjia\", \"menu\": \"代理评价\", \"menuJump\": \"列表\", \"tableName\": \"dailipingjia\"}], \"fontClass\": \"icon-common16\", \"menu\": \"招标项目管理\", \"unicode\": \"&#edfd;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"审核\"], \"appFrontIcon\": \"cuIcon-rank\", \"buttons\": [\"新增\", \"查看\", \"修改\", \"删除\"], \"classname\": \"zhaobiaogonggao\", \"menu\": \"招标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaogonggao\"}], \"fontClass\": \"icon-common18\", \"menu\": \"招标公告管理\", \"unicode\": \"&#edff;\"}, {\"child\": [{\"allButtons\": [\"新增\", \"查看\", \"修改\", \"删除\", \"申请承接\"], \"appFrontIcon\": \"cuIcon-addressbook\", \"buttons\": [\"查看\", \"申请承接\"], \"classname\": \"zhaobiaojihua\", \"menu\": \"招标计划\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaojihua\"}, {\"allButtons\": [\"查看\", \"删除\"], \"appFrontIcon\": \"cuIcon-addressbook\", \"buttons\": [\"查看\", \"删除\"], \"classname\": \"chengjieqingqiu\", \"menu\": \"承接记录\", \"menuJump\": \"列表\", \"tableName\": \"chengjieqingqiu\"}], \"fontClass\": \"icon-common1\", \"menu\": \"招标计划管理\", \"unicode\": \"&#xeda3;\"}], \"frontMenu\": [{\"child\": [{\"appFrontIcon\": \"cuIcon-flashlightopen\", \"buttons\": [\"查看\", \"投标\"], \"classname\": \"zhaobiaoxiangmu\", \"menu\": \"招标项目\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaoxiangmu\"}], \"menu\": \"招标项目管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-link\", \"buttons\": [\"查看\"], \"classname\": \"zhongbiaogonggao\", \"menu\": \"中标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhongbiaogonggao\"}], \"menu\": \"中标公告管理\"}, {\"child\": [{\"appFrontIcon\": \"cuIcon-circle\", \"buttons\": [\"查看\"], \"classname\": \"zhaobiaogonggao\", \"menu\": \"招标公告\", \"menuJump\": \"列表\", \"tableName\": \"zhaobiaogonggao\"}], \"menu\": \"招标公告管理\"}], \"hasBackLogin\": \"是\", \"hasBackRegister\": \"是\", \"hasFrontLogin\": \"否\", \"hasFrontRegister\": \"否\", \"pathName\": \"zhaobiaodaili\", \"roleName\": \"招标代理\", \"tableName\": \"zhaobiaodaili\"}]');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '简介',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统公告' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '2025-12-24 20:45:12', '余生，愿你活出自己的精彩', '曾几何时，为了让自己显得合群，选择去做自己不喜欢的事;为了讨好喜欢的人，一次次地委屈自己;甚至，为了陌生人的一个眼神，就陷入了深深的自我怀疑。', 'file/newsPicture1.jpg', '可是，这样小心翼翼的你，一定很累吧。你以为照顾了所有人的想法，就能得到他们的喜欢;你以为逼着自己合群，就能真的合群。直到后来才发现，在日复一日对自己的为难中，你逐渐弄丢了真实的自己.\n殊不知，人生在世，最不值得的事情，就是在别人的眼光中，迷失自己。其实，正如世界上没有十全十美的人，你也同样无法做到让每综合办公楼弱电工程满意。\n世上没有不快乐的人，只有不肯让自己快乐的心。有一句话说:\n如果一段关系让你变得卑微，你可以选择抽身离去;如果一综合办公楼弱电工程总是让你悲伤哭泣，你要学会放手。\n始终相信，每综合办公楼弱电工程最初的样子，都是最美好的。真正喜欢你的人，会喜欢你原来的样子:真正爱你的从来不需要你的委曲求全。\n后半生，请把身上的枷锁，全部解除。去做喜欢的事，去听自己内心的声音。你会发现，这世上没有什么事情比活出自己更加幸福。\n要相信，真实的自己亦是一道风景线。你若盛开，清风自来。愿你此生尽兴，不负韶华，');
INSERT INTO `news` VALUES (2, '2025-12-24 20:45:12', '岁月无常，好好珍惜', '常听到这样的话，如果一切可以重新开始，我一定改掉任性，学会坚持，如果有下辈子，我一定好好珍惜，不会再弄丢原本属于自己的幸福。', 'file/newsPicture2.jpg', '然而，世上有很多事情没有再来一次的机会，一旦错失就意味着无法弥补，正如人与人之间，有的只是一世的缘分，一旦转身，就意味着再无可能。\n这一生只活一次，有些人也只爱一回。\n所以，在拥有时就好好把握，对于来世，可以适当憧憬，但不要一昧去幻想，活着，唯有珍惜身边做好眼前事，才能让明天少一些遗憾。人，\n既然有幸来到这个世上，那就要努力把这辈子活好。岁月其实远没有想象中的那么漫长，若是能爱就好好爱，别让说好相伴一生的人，中途散走;若是当下能相知相守，就别去等待虚无缥缈的未来。\n就像一位网友留言说的:我从来不去期待下辈子，我要的只有今生，世事无常，来世是怎样的光景，谁都无法预知。对我来说，在有限的时光里，善待爱自己及自己爱的人，用心珍惜相聚的每一时刻，努力过好当下就足够了。\n时光匆匆，韶华似水，每综合办公楼弱电工程都只有这短暂的一生。\n有些事，如果喜欢就坚定努力的去做，有些人，如果爱就真诚用心地去爱，别幻想着重来，别总是寄希望于下辈子。\n下辈子，彼此也许再也不会遇见，就算遇见了，谁还会记得谁，今生相互承诺的两综合办公楼弱电工程，来生也许相见不相识。\n想起之前看过的一句话:人生没有假如，我们没有来世，下辈子，你我也许只是大千世界里互不相识的两个陌生人。\n的确，生命只有一次，今生有幸相遇的人，下辈子不一定能遇见，就算能遇见，谁能把谁陪伴，谁又是谁的谁?\n余生不长，趁着岁月未老，好好珍惜这辈子的缘分吧，别等到失去了才悔不该当初。');
INSERT INTO `news` VALUES (3, '2025-12-24 20:45:12', '与其背着烦恼活，不如带着美好过', '一直觉得，感情里，无疾而终并不可怕，可怕的是结束后，你还抱着回忆不肯放;岁月中，失去并不可怕，可怕的是失去后，你还揪着曾经不肯忘。\n有些事，明知道不应该继续，却始终没有转身的勇气;有些人，明知道已经成为过去，却还是舍不得放手;有时候，明知道纠缠于往事旧人只会徒增伤悲，却仍然执着的去回忆，去留恋。', 'file/newsPicture3.jpg', '人生短短几十年，为什么要蹉跎浪费在无可挽回的失去上，为什么不酒脱一点，看开一点，活得轻松快乐一点。\n这世间，没有谁的人生是十全十美的，总要面对一些离别，总要经历一些失去，如果总对身边的一切执念太深，只会越活越累。\n时间不停向前，人也不可避免的要向前看。面对一些不如意、不顺心的事，该放的就放，该忘的就忘，别总把自己困在失败的悲伤中。\n生而为人，放不是无能，而是一种洒脱，忘更不是懦弱，而是一种智慧。\n在来去匆匆，聚散不定的现实里，放下不属于自己的感情，才能有新的开始，忘记心中的烦恼，才能收获愉快的心情。\n所以，有些离开的人，该放就放下吧，一直念念不忘，伤害的是自己，有些烦心事，该忘就忘了吧一直耿耿于怀，痛苦的是自己。\n-辈子本就不长，何必让自己活得那么累，过去的情就让它过去，别再留恋，想不通的事就算了，别再纠结。\n人生的旅途，总有些事让人烦，总有些情让人伤。只有学会忘记过往的不如意，忘记一些不必要的烦恼，以轻盈的身心重新出发，才不会被旧人旧事所累。\n记得，每综合办公楼弱电工程心灵的空间都是有限的，当装多了纠结与伤感，就装不下自在与欢快了。要想日子过得简单轻松一点，就要懂得放下执念，忘掉痛苦，清除伤。');
INSERT INTO `news` VALUES (4, '2025-12-24 20:45:12', '理想很丰满，现实很骨感', '游戏里的你帅气无比，乘风御剑，通关杀敌无所不能，你满足于那其中的成就感，你满足于通关的畅快淋漓。', 'file/newsPicture4.jpg', '年轻人，可那毕竟不是现实，理想很丰满，现实很骨感这不是玩笑，你不走出来，怎么会知\n你真的想等到某天喜欢上一个姑娘时，才去纠结咖啡钱电影钱你要如何与爸妈张口，才去苦恼为她买礼物你要怎样省吃俭用节衣缩食?\n你没有挥金如土的.魄力，没有殷实的家境，没有既定的光芒锦绣的前程，二十出头的年纪，你不努力，你想拿什么报答那个在你身边用最好的青春陪伴你的姑娘?你又拿什么报答含辛茹苦养育你这么多年的父母?\n生活不是游戏，不会给你那么多反复再来的机会，青春年少风华正茂，年轻人，你不努力，你想指望什么?\n年轻人，走出来奋斗吧!累也好苦也罢。如果你现在对自己各种放纵，你指望以后你用什么条件来放松?\n年轻人，你要努力赚钱，为了自己，也为了你爸妈。为了他们在以后逛商场的时候，可以给自己买东西像给你买东西一样毫不犹豫。为了他们可以在同老友谈起你时可以一脸安详，而不是想着，这个月，儿子交了房租还有钱吃饭么。我们这个年龄的人，已经像吸血鬼一样巴着父母活了二十多年了，还真的要继续吸着他们的血活下去么?\n年轻人，停止期望凡事简单容易。如果总是挑简单的事情做，那你永远成不了大器，生活总会在始料不及时考验你，所以你必须挑战困难，保持坚强，世上任何值得拥有的东西都需要付诸努力，勤奋与自律，倘若自甘平庸，那你就会变得庸碌无为。\n年轻人，与我们一起，挑战一下自己，拥抱一下梦想。你想要的生活，跳起来，一定够得到!');
INSERT INTO `news` VALUES (5, '2025-12-24 20:45:12', '理想是一种精神上的追求', '如果前方是一片黑暗，理想是否会黯淡?黑暗终究不能限制理想的步伐，只是需要时间。', 'file/newsPicture5.jpg', '是否会撕裂黑暗的结界?给理想一点时间，是否会完成理想的目标?太多时候，黑给黑暗一缕曙光，暗限制了理想的脚步，时间成了撕裂黑暗的曙光。社会的压抑，未知的迷茫，甚至是事实的打击，都成了所谓的黑暗。\n理想应该是一种精神上的追求，一种我们内心深处的渴望。也许理想的种类太多，不一样的人也有不一样的理想。但唯一的共同点就是我们在追求，追求自己精神上亦或是心中的目标。但总是不尽人意，一来存在太多不确定因素，二来时间还不够。理想并不是一而就的空话。\n想过放弃，因为理想与现实的差距。但又不想放弃，因为理想是精神上的追求心中的渴望。纠结了太多，却是否想过在纠结的时候，已经选择了错过。被刻意选择的错过是什么?是路过。我们在不经意间路过了多少理想，只是因为纠结。如果坚定自己的理想，用时间去行动，是否会少几次刻意的错过:-次，与一位朋友谈到如何乐观，然后追求理想。朋友想了一会儿，给我的回答是正能量与时间。他说，想要乐观就要不断给自己正能量。事物有阴阳两面，如果阳代表乐观，那在我们看待一件事时要看阳面千万别看阴面。这样自己不会消极，某种程度上来说就是一种正能量。想要追求理想，务必要花费时间。正如没有风平浪静的大海，想要追求理想，要时间。给理想一点时间，让自己去追求，不顾切的追求。\n点点滴滴的小事构成了我们的生活，点点滴滴的努力给理想铺平了路。每一次小成功都为理想迈进了一步。每一次失败，都告诉我们一些教训，反方向来说为下一次成功提供了经验。不要觉得失败是可怕的，长远来看，正是失败才有了成功。\n时间在流逝。如果安于现状，就会乐不思。理想需要时间不代表我们可以挥霍，我们能做的是珍惜时间，去为理想拼搏。\n间接意义上讲，理想的时间是我们的努力。\n如果正在路上，一直任性向前走，忘记时间不回头。');
INSERT INTO `news` VALUES (6, '2025-12-24 20:45:12', '人生如梦，梦想是帆', '人生如梦，梦想是帆，每综合办公楼弱电工程都有一个只属于自己的梦，但我们同属一个国家，所以每综合办公楼弱电工程的梦又与国家的兴衰荣辱紧密相连。先哲顾炎武曾说:天下兴亡，匹夫有责。只有国家好，大家才能好。', 'file/newsPicture6.jpg', '我依然清楚的记得:\n当甲午战争战败，日寇无礼踏破中国的门户;当八国联军侵入北京，无情掠夺中国的财产:当七七事变发生，中国的老人、妇孺被残忍杀害的时候，我在想那时中国的梦是怎样的!\n我虽不曾亲眼看到，但那却是铁一般的事实。因为从老人们那深邃的眼神中可以感到无尽的愤懑;从他们干瘪的脸颊可以看到深情的泪水，从他们嘹亮的军歌中可以想到那奋勇杀敌时的豪迈;从他们激昂话语中听到那誓要捍卫家园振兴中华的誓言。作为新一代青年的我们难道不应该树立远大的理想，付之以踏实的行动，去继承先辈们的使命。去实现中华民族的伟大崛起和复兴吗?\n有梦才能使中国繁荣!\n在改革开放以来中国取得了一系列的可以载入中国史册的成就。香港、澳门的回归，经济特区的建立，使中国成为发展国家中的经济大国，科技先进国和军事强国。当中国成功举办奥运的时候，当神九飞天的时候，当蛟龙入海的时候，当航母下水的时候，当莫言荣获诺贝尔文学奖的时候。我相信每综合办公楼弱电工程都感觉到了无比的自豪。但是现在的中国与其他发达国家还有很大差距。作为新一代的我们，难道不应该志存高远吗?\n我想有的人会说，我们的力量是有限的。的确综合办公楼弱电工程的力量很渺小，但是中国梦就是因一个个微不足道的综合办公楼弱电工程的梦一直汇集、汇集，然后凝聚成的一个巨大的梦。冯至在《十四行诗》中写道，我们准备着，深深领受，那些意想不到的奇迹，在漫长的岁月里，忽然有彗星的出现，狂风乍起。\n梦想是美丽的，它是美的期望;梦想是阳光的，它使人由浮躁走向踏实;梦想是充满力量的，它可以激发人身体里无限的潜能。我们期盼的是国泰民安、经济发展、政治清明、文化繁荣、社会和谐、生态良\n好、公平正义。这才是中国人伟大的梦');
INSERT INTO `news` VALUES (7, '2025-12-24 20:45:12', '若月亮没来-王宇宙Leto，乔浚丞', '《若月亮没来(若是月亮还没来)》是王宇宙Leto，乔浚丞演唱的歌曲，于2024年1月22日上线发行。', 'file/newsPicture7.jpg', '风吹过山 船靠了岸  风光呀 一点点看  我走向北 你去往南\n故事呀 一篇篇翻  好烦 又加班到很晚  你搭上空荡的 地铁已是末班\n好烦 很爱却要分开  恋爱谈不明白  好烦 接近理想好难 却又还很不甘\n如何拥抱平淡  如果 最难得到圆满  不如选择坦然 若是月亮还没来\n路灯也可照窗台  照着白色的山茶花微微开  若是晨风还没来\n晚风也可吹入怀  吹着那一地树影温柔摇摆  你总以为你不够好\n不够苗条和美貌  可是完美谁能达到  做你自己就很好\n烦恼烦恼拥有太少  没有房车没有钞票  可爱你的人永远会 \n把你当做心尖珍宝  我也懂大多数的时候  你只想逃离这世界\n我也懂太多的情绪在  一综合办公楼弱电工程失眠的深夜 你可以是悲伤或者埋怨\n但请不要放弃明天  这一直灰暗的世界  我想看见你的笑脸\n若是月亮还没来  路灯也可照窗台  照着白色的山茶花微微开\n若是晨风还没来  晚风也可吹入怀  吹着那一地树影温柔摇摆\n若是月亮还没来  路灯也可照窗台  照着白色的山茶花微微开\n若是晨风还没来  晚风也可吹入怀  吹着那一地树影温柔摇摆\n李哲今年1月份创作了《若月亮没来》这首歌。随着歌曲的热度不断上升，约他写歌的人越来越多，他的工作变得更加繁忙。\n近年来，李哲凭借对音乐的热爱和不懈的努力，创作了几百首音乐作品，其中不乏广为人知的佳作，例如王栎鑫的《一综合办公楼弱电工程》、何赛飞与叶炫清在央视演唱的《木兰诗》等歌曲，都是由李哲作曲。\n如今，李哲的音乐才华和努力得到了业界的广泛认可，他的音乐作品多次登上各大音乐平台的热歌榜，成为备受瞩目的新生代音乐人。现在，走在街头、坐在车里，经常会听到自己的作品。看到自己的音乐作品受到如此广泛的喜爱和认可，我感到非常有成就感。李哲笑着说，他会努力创作更多优秀音乐作品，为家乡争光。');
INSERT INTO `news` VALUES (8, '2025-12-24 20:45:12', '-米阳光传递一份温暖', '黑暗中跌倒，坚强里苦笑。只是因为青春还在，所以梦想一直在路上。当年华未曾老去，青春没有散场，留给幽暗的岁月，还有几分值得珍藏?孤独无助时、伤心难过时总爱恣意挥霍愤怒。伤了、痛了原本以为就都结束了;可是心里还不甘愿放弃，就只为一个理由，有梦想的人永不孤单。', 'file/newsPicture8.jpg', '放进去了的青春，走不出来的悲伤却总是给年少时的我们留下太多无法割舍的情怀。记录岁月的足迹，聆听时光的故事。然轻吟浅唱出，青春嘉年华。\n故事里总会有，那些太多感慨于时间的无情，太多对往事的追忆，太多的太多，而今刻在了心里也停泻在了流年里。一段无法抹去的回忆，也只不过是一场烟火燃放的瞬间，却也一辈子在脑海里兜兜转转。很是怀念那些相遇的日子，邂逅了幸福也留在了时间轨迹里。时而想起，那些曾肩并肩奋斗的日子，那些写满感动与快乐的岁月。\n如今，我们似乎渐行渐远，彼此奋斗着青春的轮回。渐渐的，我们都长大了，时间改变了我们时刻分享彼此快乐与不快乐的习惯，青春的渐逝，岁月的更迭让我们变得都不再联系，身边的朋友也越来越少;那些欢笑，那些幸福的流年也随着我们的陌生而变得更加奢侈。也许多年以后，我们都有了自己的朋友，有了自己关心的人。那时，我们再细数那些癫狂在你生命里一辈子的记忆故事，蓦然发现一切都停留在了回忆里。');
INSERT INTO `news` VALUES (9, '2025-12-24 20:45:12', '自己的路自己走，自己的心自己懂', '岛上书店》中有句话:每综合办公楼弱电工程的生命里，都有最艰难的那一年，将人生变得美好而辽阔。\n你有没有经历过那么一年，在走过的岁月中跋涉得异常艰难困苦，却仍无法灭前行的勇气。哪怕所有人都极力劝阻，也要不甘心地试一试;哪怕前方已没有道路，却还在坚定前行;哪怕再看不到任何希望，也要竭尽全力地为自己争取一个机会。', 'file/newsPicture9.jpg', '你开始不动声色的扮演着一个大人，经历着生活日复一日的打。\n每天醒在天还没亮的五六点，挤过早高峰的地下铁，面对成山的工作，加班到深夜倒下就睡更成为了日常，还要应付各色的人际关系，逐渐开始接受努力也不一定有回报的道理。\n这段日子也许很长，但你没有放弃对生活的信心，始终相信人生总会变得一帆风顺，更坚信每件事的最后都会有一个好的结局，如果不是，说明还没到最后。\n于是你树立新的目标，让这一年的奔波更有方向。\n虽然永远无法预料明天是晴是雨，也无法预知你在乎的人是否还在身边，你一直以来的坚持究竟能换来什么。\n但你能决定的是，今天有没有备好雨伞，有没有好好爱人以及是否为自己追求的理想拼尽全力。\n永远不要只看见前方路途遥远而忘了从前的自己坚持了多久才走到了这里，\n今天拼尽全力虽然艰辛万分，在未来都将成为落在你身上的礼物。');
INSERT INTO `news` VALUES (10, '2025-12-24 20:45:12', '愿你有明天可奔赴，有过往可回头', '此去经年，用一张离家的车票，换一段有故事可说的人生。\n大概就是那时候怀揣着梦想，背上了行囊，一腔热血决定远行的你。独自拎着一只行李箱，背着双肩包在深夜抵达一个陌生的城市，站在人潮涌动的车站出口，望着宽敞公路上车水马龙的喧嚣，城市里亮如白昼的繁华。', 'file/newsPicture10.jpg', '这世界上的人们都活的匆匆忙忙，每综合办公楼弱电工程看起来都很焦虑，每综合办公楼弱电工程都有自己的苦楚，却往往找不到人可以诉说。也许你的倾诉，对别人来说是一种打扰，而且别人没经历过你的经历，所以无法体会你的心情。我们总是在心情不好的时候拿着手机，翻翻通讯录，然后再默默放下手机，压住心中那股想要找人说说话的想法。\n等到低落的情绪慢慢有些好转，才开始明白，人这一生，无论是什么样的路，都是自己的选择，冲动也好，深思熟虑也罢，自己选的路，不管多难，都要自己走下去。心中的感受，不管是复杂还是简单，都只能自己来懂，别人帮不了你，也安慰不了你，顶多给你一些无济于事的劝告，最后还得靠自己想开。你选的幸福，你自己享受;你选的眼泪，你自己来流，生活就是如此，自己的路，自己走;自己的心，自己懂。');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1739796677316, 'yezhu_01', 'yezhudanwei', '项目建设指挥部', 'bgnb1tgw6uixfto207ytx51yumpavcs0', '2025-12-24 20:51:35', '2025-12-24 21:51:36');
INSERT INTO `token` VALUES (2, 1, 'admin', 'users', '管理员', 'hrck2kp77xu0o7dxtm16qu2jtnurcv27', '2025-12-24 20:53:14', '2026-04-17 17:57:16');
INSERT INTO `token` VALUES (3, 1739796927413, 'yezhu_01', 'yezhudanwei', '项目建设指挥部', 'qoubnoubx9877q6dnhr7tuq1dxrf4y4m', '2025-12-24 20:55:37', '2026-04-17 15:47:21');
INSERT INTO `token` VALUES (4, 1739796933942, 'yezhu_01', 'zhaobiaodaili', '招标代理', 'lg2m9bo2apovhm76r9995i3je6fohn6z', '2025-12-24 20:56:19', '2026-04-17 15:47:28');
INSERT INTO `token` VALUES (5, 1739797003398, 'yezhu_01', 'toubiaodanwei', '投标单位', 'quhv738ct1bb6t3qinrlbrnmyf7dmwug', '2025-12-24 20:56:45', '2026-04-16 22:01:22');
INSERT INTO `token` VALUES (6, 51, 'agency_0', 'zhaobiaodaili', '招标代理', 'o7uqxxdr9fumdnfaqvjy19fxxm17rlyx', '2026-03-28 00:23:18', '2026-03-28 22:38:23');
INSERT INTO `token` VALUES (7, 1775888676617, 'agency_02', 'yezhudanwei', '项目建设指挥部', '761p4pdt88er6b4upchg1nvkorufc3wt', '2026-04-11 14:26:44', '2026-04-11 15:26:44');
INSERT INTO `token` VALUES (8, 101, 'owner_1', 'yezhudanwei', '业主单位', 'b24euiy94mzua9rjdsxk9ecgiq1h8tyg', '2026-04-17 16:13:26', '2026-04-17 17:57:09');
INSERT INTO `token` VALUES (9, 301, 'agency_1', 'zhaobiaodaili', '招标代理', 'rhig7zgkd83dcnpxovccfkzae1e071u1', '2026-04-17 16:15:29', '2026-04-17 17:43:25');
INSERT INTO `token` VALUES (10, 302, 'agency_2', 'zhaobiaodaili', '招标代理', 'z9yggcfuygbg34tmblhofk7g5zdmo6f9', '2026-04-17 16:30:46', '2026-04-17 17:30:47');
INSERT INTO `token` VALUES (11, 1776414869813, '123', 'yezhudanwei', '业主单位', '0j0wd6mk5g063iz8fkf8yddepy4toinr', '2026-04-17 16:35:44', '2026-04-17 17:35:44');
INSERT INTO `token` VALUES (12, 1776414897357, '123', 'zhaobiaodaili', '招标代理', 'fyaqtr27ofwxlgt6ubloxky97a7jhl0c', '2026-04-17 16:35:48', '2026-04-17 17:35:48');
INSERT INTO `token` VALUES (13, 201, 'user_1', 'toubiaodanwei', '投标单位', 'r22z0y5fjr4rt4mxhgd63lc8f60a52c4', '2026-04-17 16:40:36', '2026-04-17 17:40:37');
INSERT INTO `token` VALUES (14, 102, 'owner_2', 'yezhudanwei', '业主单位', 'fyauktu3pdhwn548zoqxguaax6l7g7i6', '2026-04-17 16:44:31', '2026-04-17 17:44:31');
INSERT INTO `token` VALUES (15, 103, 'owner_3', 'yezhudanwei', '业主单位', 'hvnsbop05z8yatjqydaxy2tt31a9crpt', '2026-04-17 16:44:52', '2026-04-17 17:44:53');
INSERT INTO `token` VALUES (16, 202, 'user_2', 'toubiaodanwei', '投标单位', '8aqavdkrzx2j2izehpuzfwfis898h3f4', '2026-04-17 17:05:40', '2026-04-17 18:05:41');
INSERT INTO `token` VALUES (17, 205, 'user_5', 'toubiaodanwei', '投标单位', 'i35dwss1p4tz5hf586s96tf8amdlnuue', '2026-04-17 17:05:53', '2026-04-17 18:05:53');

-- ----------------------------
-- Table structure for toubiaodanwei
-- ----------------------------
DROP TABLE IF EXISTS `toubiaodanwei`;
CREATE TABLE `toubiaodanwei`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `toubiaozhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `toubiaorenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `shenfenzhenghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '身份证号',
  `shoujihao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `touxiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `toubiaozhanghao`(`toubiaozhanghao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1739797003399 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '投标单位' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of toubiaodanwei
-- ----------------------------
INSERT INTO `toubiaodanwei` VALUES (201, '2026-04-17 15:59:37', 'user_1', '666666', '张三', '男', '30', '44100019900101001', '15188887771', 'file/toubiaodanweiTouxiang1.jpg');
INSERT INTO `toubiaodanwei` VALUES (202, '2026-04-17 15:59:37', 'user_2', '123456', '李四', '男', '30', '44100019900101002', '15288887772', 'file/toubiaodanweiTouxiang2.jpg');
INSERT INTO `toubiaodanwei` VALUES (203, '2026-04-17 15:59:37', 'user_3', '123456', '王五', '男', '30', '44100019900101003', '15388887773', 'file/toubiaodanweiTouxiang3.jpg');
INSERT INTO `toubiaodanwei` VALUES (204, '2026-04-17 15:59:37', 'user_4', '123456', '赵六', '男', '30', '44100019900101004', '15488887774', 'file/toubiaodanweiTouxiang4.jpg');
INSERT INTO `toubiaodanwei` VALUES (205, '2026-04-17 15:59:37', 'user_5', '123456', '孙七', '男', '30', '44100019900101005', '15588887775', 'file/toubiaodanweiTouxiang5.jpg');
INSERT INTO `toubiaodanwei` VALUES (206, '2026-04-17 15:59:37', 'user_6', '123456', '周八', '男', '30', '44100019900101006', '15688887776', 'file/toubiaodanweiTouxiang6.jpg');
INSERT INTO `toubiaodanwei` VALUES (207, '2026-04-17 15:59:37', 'user_7', '123456', '吴九', '男', '30', '44100019900101007', '15788887777', 'file/toubiaodanweiTouxiang7.jpg');
INSERT INTO `toubiaodanwei` VALUES (208, '2026-04-17 15:59:37', 'user_8', '123456', '郑十', '男', '30', '44100019900101008', '15888887778', 'file/toubiaodanweiTouxiang8.jpg');

-- ----------------------------
-- Table structure for toubiaoxinxi
-- ----------------------------
DROP TABLE IF EXISTS `toubiaoxinxi`;
CREATE TABLE `toubiaoxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `zhaobiaoren` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标人',
  `zhaobiaofanwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标范围',
  `toubiaojiezhishijian` date NULL DEFAULT NULL COMMENT '投标截止时间',
  `kaibiaoshijian` date NULL DEFAULT NULL COMMENT '开标时间',
  `xiangmudidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目地点',
  `xiangmuzhouqi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目周期',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `qiyemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业名称',
  `zizhizhengshu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '资质证书',
  `toubiaozhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标账号',
  `toubiaorenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人姓名',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司账号',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司名称',
  `toubiaozongbaojia` double NULL DEFAULT NULL COMMENT '投标总报价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '投标信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of toubiaoxinxi
-- ----------------------------
INSERT INTO `toubiaoxinxi` VALUES (2, '2025-12-24 20:45:12', '省实验中学体育馆加固与翻新工程', '发包方负责人2', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '高新区创新园区B座', '24个月', 'owner_5', '格力电器销售有限公司', '', 'user_5', '孙七', 'agency_5', '中经国际招标部', 1730000);
INSERT INTO `toubiaoxinxi` VALUES (3, '2025-12-24 20:45:12', '滨海新区海绵城市生态修复（一期）', '发包方负责人3', '第三方安全监理与质量检测', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '365天', 'owner_6', '海尔智家北京分公司', '', 'user_6', '周八', 'agency_6', '弘业项目管理公司', 4779000);
INSERT INTO `toubiaoxinxi` VALUES (4, '2025-12-24 20:45:12', '市政务云平台数据中心扩容采购', '发包方负责人4', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '自合同签订起90天', 'owner_7', '万科企业股份有限公司', '', 'user_7', '吴九', 'agency_7', '捷诚信达招标公司', 2282000);
INSERT INTO `toubiaoxinxi` VALUES (5, '2025-12-24 20:45:12', '文化宫片区旧城改造拆迁评估服务', '发包方负责人5', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '空港经济区现代物流园', '180个日历天', 'owner_3', '顺丰速递物流中心', '', 'user_3', '王五', 'agency_3', '广厦项目管理公司', 5420000);
INSERT INTO `toubiaoxinxi` VALUES (6, '2025-12-24 20:45:12', '高新区智能制造产业园分布式光伏项目', '发包方负责人6', '第三方安全监理与质量检测', '2025-12-24', '2025-12-24', '东部新区经开路12号', '24个月', 'owner_7', '万科企业股份有限公司', '', 'user_7', '吴九', 'agency_7', '捷诚信达招标公司', 1320000);
INSERT INTO `toubiaoxinxi` VALUES (7, '2025-12-24 20:45:12', '市图书馆数字化馆藏资源库扩建', '发包方负责人7', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '高新区创新园区B座', '365天', 'owner_5', '格力电器销售有限公司', '', 'user_5', '孙七', 'agency_5', '中经国际招标部', 7995000);
INSERT INTO `toubiaoxinxi` VALUES (8, '2025-12-24 20:45:12', '人民医院医学影像云存储及传输服务', '发包方负责人8', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '自合同签订起90天', 'owner_6', '海尔智家北京分公司', '', 'user_6', '周八', 'agency_6', '弘业项目管理公司', 2059000);
INSERT INTO `toubiaoxinxi` VALUES (13, '2026-04-17 16:43:00', '南北快速路隧道照明亮化提升工程', '', '第三方安全监理与质量检测', '2026-04-18', '2025-12-24', '老城区文化遗址保护区', '180个日历天', 'owner_1', '中天建设集团有限公司', '', 'user_1', '张三', 'agency_1', '同诚招标代理公司', 6882000);

-- ----------------------------
-- Table structure for tousuxinxi
-- ----------------------------
DROP TABLE IF EXISTS `tousuxinxi`;
CREATE TABLE `tousuxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `tousubianhao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投诉编号',
  `tousuneirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投诉内容',
  `tousushijian` datetime NULL DEFAULT NULL COMMENT '投诉时间',
  `toubiaozhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标账号',
  `toubiaorenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人姓名',
  `shoujihao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tousubianhao`(`tousubianhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '投诉信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tousuxinxi
-- ----------------------------
INSERT INTO `tousuxinxi` VALUES (1, '2025-12-24 20:45:12', 'TS2026041702', '评标委员会组成不符合法定人数要求，且部分专家有利害关系。', '2025-12-24 20:45:12', 'user_1', '张三', '13920000002', '是', '已受理并下达整改通知');
INSERT INTO `tousuxinxi` VALUES (2, '2025-12-24 20:45:12', 'TS2026041703', '中标候选人公示期仅为2个工作日，不足法定公示天数。', '2025-12-24 20:45:12', 'user_5', '孙七', '13930000003', '是', '已受理并下达整改通知');
INSERT INTO `tousuxinxi` VALUES (3, '2025-12-24 20:45:12', 'TS2026041704', '发现其他投标人存在围标串标嫌疑，提供的业绩证明文件涉假。', '2025-12-24 20:45:12', 'user_6', '周八', '13940000004', '是', '已受理并下达整改通知');
INSERT INTO `tousuxinxi` VALUES (4, '2025-12-24 20:45:12', 'TS2026041705', '投标保证金退还逾期，要求按同期贷款利率支付利息。', '2025-12-24 20:45:12', 'user_7', '吴九', '13950000005', '是', '已受理并下达整改通知');
INSERT INTO `tousuxinxi` VALUES (5, '2025-12-24 20:45:12', 'TS2026041706', '招标文件在发售期间对实质性参数进行重大变更，未书面通知。', '2025-12-24 20:45:12', 'user_3', '王五', '13960000006', '是', '已受理并下达整改通知');
INSERT INTO `tousuxinxi` VALUES (6, '2025-12-24 20:45:12', 'TS2026041707', '对评审结果中关于‘类似业绩’的认定标准表示异议。', '2025-12-24 20:45:12', 'user_7', '吴九', '13970000007', '是', '已受理并下达整改通知');
INSERT INTO `tousuxinxi` VALUES (7, '2025-12-24 20:45:12', 'TS2026041708', '招标公告发布时间不足法定天数即截止发售，程序违规。', '2025-12-24 20:45:12', 'user_5', '孙七', '13980000008', '是', '已受理并下达整改通知');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '2025-12-24 20:45:12', 'admin', 'admin', '管理员');

-- ----------------------------
-- Table structure for yezhudanwei
-- ----------------------------
DROP TABLE IF EXISTS `yezhudanwei`;
CREATE TABLE `yezhudanwei`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '企业账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `qiyemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '企业名称',
  `fuzeren` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人',
  `lianxidianhua` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
  `dizhi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `zizhi` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '资质',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `qiyezhanghao`(`qiyezhanghao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1775888676618 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '业主单位' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of yezhudanwei
-- ----------------------------
INSERT INTO `yezhudanwei` VALUES (101, '2026-04-17 15:59:38', 'owner_1', '666666', '中天建设集团有限公司', '张伟', '13188889991', '东部新区经开路12号', 'file/qyzz1.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (102, '2026-04-17 15:59:38', 'owner_2', '123456', '华润置地(北京)有限公司', '王芳', '13288889992', '高新区创新园区B座3楼', 'file/qyzz2.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (103, '2026-04-17 15:59:38', 'owner_3', '123456', '顺丰速递物流中心', '李健', '13388889993', '空港经济区现代物流园A区', 'file/qyzz3.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (104, '2026-04-17 15:59:38', 'owner_4', '123456', '美的集团股份有限公司', '赵敏', '13488889994', '滨海新区海防大道88号', 'file/qyzz4.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (105, '2026-04-17 15:59:38', 'owner_5', '123456', '格力电器销售有限公司', '刘军', '13588889995', '老城区文化遗址保护区', 'file/qyzz5.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (106, '2026-04-17 15:59:38', 'owner_6', '123456', '海尔智家北京分公司', '陈秀', '13688889996', '经开区软件园2号楼', 'file/qyzz6.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (107, '2026-04-17 15:59:38', 'owner_7', '123456', '万科企业股份有限公司', '杨洋', '13788889997', '自贸区商务中心A座', 'file/qyzz7.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (108, '2026-04-17 15:59:38', 'owner_8', '123456', '龙湖地产发展有限公司', '马超', '13888889998', '中心城区解放路99号', 'file/qyzz8.jpg', '是', NULL);
INSERT INTO `yezhudanwei` VALUES (1776414869813, '2026-04-17 16:34:29', '123', '123', '123', NULL, NULL, NULL, 'file/1776414868697.jpg', '是', 'ok');

-- ----------------------------
-- Table structure for zhaobiaodaili
-- ----------------------------
DROP TABLE IF EXISTS `zhaobiaodaili`;
CREATE TABLE `zhaobiaodaili`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '代理公司账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '代理公司名称',
  `lianxidianhua` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复内容',
  `zizhi` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '资质',
  `manyidu` double NULL DEFAULT 0 COMMENT '满意度',
  `dengji` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '暂无等级' COMMENT '等级',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dailigongsizhanghao`(`dailigongsizhanghao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1775888709225 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '招标代理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhaobiaodaili
-- ----------------------------
INSERT INTO `zhaobiaodaili` VALUES (301, '2026-04-17 15:59:38', 'agency_1', '666666', '同诚招标代理公司', '18166665551', '是', '', 'file/qyzz1.jpg', 9, '金牌代理公司');
INSERT INTO `zhaobiaodaili` VALUES (302, '2026-04-17 15:59:38', 'agency_2', '123456', '华审工程咨询中心', '18266665552', '是', '', 'file/qyzz2.jpg', 8.5, '银牌代理公司');
INSERT INTO `zhaobiaodaili` VALUES (303, '2026-04-17 15:59:38', 'agency_3', '123456', '广厦项目管理公司', '18366665553', '是', '', 'file/qyzz3.jpg', 9.3, '金牌代理公司');
INSERT INTO `zhaobiaodaili` VALUES (304, '2026-04-17 15:59:38', 'agency_4', '123456', '国信招标集团', '18466665554', '是', '', 'file/qyzz4.jpg', 8.1, '银牌代理公司');
INSERT INTO `zhaobiaodaili` VALUES (305, '2026-04-17 15:59:38', 'agency_5', '123456', '中经国际招标部', '18566665555', '是', '', 'file/qyzz5.jpg', 9.5, '金牌代理公司');
INSERT INTO `zhaobiaodaili` VALUES (306, '2026-04-17 15:59:38', 'agency_6', '123456', '弘业项目管理公司', '18666665556', '是', '', 'file/qyzz6.jpg', 9.6, '金牌代理公司');
INSERT INTO `zhaobiaodaili` VALUES (307, '2026-04-17 15:59:38', 'agency_7', '123456', '捷诚信达招标公司', '18766665557', '是', '', 'file/qyzz7.jpg', 9.7, '金牌代理公司');
INSERT INTO `zhaobiaodaili` VALUES (308, '2026-04-17 15:59:38', 'agency_8', '123456', '德勤工程咨询公司', '18866665558', '是', '', 'file/qyzz8.jpg', 6, '暂无等级');
INSERT INTO `zhaobiaodaili` VALUES (1776414897357, '2026-04-17 16:34:57', '123', '123', '123', '18377778888', '是', 'ok', 'file/1776414889728.jpg', 0, '暂无等级');

-- ----------------------------
-- Table structure for zhaobiaogonggao
-- ----------------------------
DROP TABLE IF EXISTS `zhaobiaogonggao`;
CREATE TABLE `zhaobiaogonggao`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `qiyemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业名称',
  `zhaobiaofanwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标范围',
  `zhaobiaogonggaowenjian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '招标公告文件',
  `toubiaojiezhishijian` date NULL DEFAULT NULL COMMENT '投标截止时间',
  `kaibiaoshijian` date NULL DEFAULT NULL COMMENT '开标时间',
  `xiangmudidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目地点',
  `xiangmuzhouqi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目周期',
  `hetongtiaokuan` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '合同条款',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司账号',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司名称',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复内容',
  `xiangmuyusuan` double NULL DEFAULT NULL COMMENT '项目预算',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '招标公告' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhaobiaogonggao
-- ----------------------------
INSERT INTO `zhaobiaogonggao` VALUES (2, '2025-12-24 20:45:12', '省实验中学体育馆加固与翻新工程', '格力电器销售有限公司', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '高新区创新园区B座', '24个月', '', 'agency_5', '中经国际招标部', '是', '', 1730000);
INSERT INTO `zhaobiaogonggao` VALUES (3, '2025-12-24 20:45:12', '滨海新区海绵城市生态修复（一期）', '海尔智家北京分公司', '第三方安全监理与质量检测', '', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '365天', '', 'agency_6', '弘业项目管理公司', '是', '', 4779000);
INSERT INTO `zhaobiaogonggao` VALUES (4, '2025-12-24 20:45:12', '市政务云平台数据中心扩容采购', '万科企业股份有限公司', '设计、施工、材料采购一体化', '', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '自合同签订起90天', '', 'agency_7', '捷诚信达招标公司', '是', '', 2282000);
INSERT INTO `zhaobiaogonggao` VALUES (5, '2025-12-24 20:45:12', '文化宫片区旧城改造拆迁评估服务', '顺丰速递物流中心', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '空港经济区现代物流园', '180个日历天', '', 'agency_3', '广厦项目管理公司', '是', '', 5420000);
INSERT INTO `zhaobiaogonggao` VALUES (6, '2025-12-24 20:45:12', '高新区智能制造产业园分布式光伏项目', '万科企业股份有限公司', '第三方安全监理与质量检测', '', '2025-12-24', '2025-12-24', '东部新区经开路12号', '24个月', '', 'agency_7', '捷诚信达招标公司', '是', '', 1320000);
INSERT INTO `zhaobiaogonggao` VALUES (7, '2025-12-24 20:45:12', '市图书馆数字化馆藏资源库扩建', '格力电器销售有限公司', '设计、施工、材料采购一体化', '', '2025-12-24', '2025-12-24', '高新区创新园区B座', '365天', '', 'agency_5', '中经国际招标部', '是', '', 7995000);
INSERT INTO `zhaobiaogonggao` VALUES (8, '2025-12-24 20:45:12', '人民医院医学影像云存储及传输服务', '海尔智家北京分公司', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '自合同签订起90天', '', 'agency_6', '弘业项目管理公司', '是', '', 2059000);
INSERT INTO `zhaobiaogonggao` VALUES (9, '2025-12-24 20:45:12', '南北快速路隧道照明亮化提升工程', '中天建设集团有限公司', '第三方安全监理与质量检测', '', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '180个日历天', '', 'agency_1', '同诚招标代理公司', '是', '', 6883000);

-- ----------------------------
-- Table structure for zhaobiaojihua
-- ----------------------------
DROP TABLE IF EXISTS `zhaobiaojihua`;
CREATE TABLE `zhaobiaojihua`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `qiyemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业名称',
  `zhaobiaofanwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标范围',
  `jihuawenjian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '计划文件',
  `toubiaojiezhishijian` date NULL DEFAULT NULL COMMENT '投标截止时间',
  `kaibiaoshijian` date NULL DEFAULT NULL COMMENT '开标时间',
  `xiangmudidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目地点',
  `xiangmuzhouqi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目周期',
  `xiangmuyusuan` double NULL DEFAULT NULL COMMENT '项目预算',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '招标计划' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhaobiaojihua
-- ----------------------------
INSERT INTO `zhaobiaojihua` VALUES (1, '2025-12-24 20:45:12', '省实验中学体育馆加固与翻新工程', 'owner_1', '中天建设集团有限公司', '设计、施工、材料采购一体化', '', '2025-12-24', '2025-12-24', '东部新区经开路12号', '180个日历天', 1730000);
INSERT INTO `zhaobiaojihua` VALUES (2, '2025-12-24 20:45:12', '滨海新区海绵城市生态修复（一期）', 'owner_5', '格力电器销售有限公司', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '高新区创新园区B座', '24个月', 4779000);
INSERT INTO `zhaobiaojihua` VALUES (3, '2025-12-24 20:45:12', '市政务云平台数据中心扩容采购', 'owner_6', '海尔智家北京分公司', '第三方安全监理与质量检测', '', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '365天', 2282000);
INSERT INTO `zhaobiaojihua` VALUES (4, '2025-12-24 20:45:12', '文化宫片区旧城改造拆迁评估服务', 'owner_7', '万科企业股份有限公司', '设计、施工、材料采购一体化', '', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '自合同签订起90天', 5420000);
INSERT INTO `zhaobiaojihua` VALUES (5, '2025-12-24 20:45:12', '高新区智能制造产业园分布式光伏项目', 'owner_3', '顺丰速递物流中心', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '空港经济区现代物流园', '180个日历天', 1320000);
INSERT INTO `zhaobiaojihua` VALUES (6, '2025-12-24 20:45:12', '市图书馆数字化馆藏资源库扩建', 'owner_7', '万科企业股份有限公司', '第三方安全监理与质量检测', '', '2025-12-24', '2025-12-24', '东部新区经开路12号', '24个月', 7995000);
INSERT INTO `zhaobiaojihua` VALUES (7, '2025-12-24 20:45:12', '人民医院医学影像云存储及传输服务', 'owner_5', '格力电器销售有限公司', '设计、施工、材料采购一体化', '', '2025-12-24', '2025-12-24', '高新区创新园区B座', '365天', 2059000);
INSERT INTO `zhaobiaojihua` VALUES (8, '2025-12-24 20:45:12', '南北快速路隧道照明亮化提升工程', 'owner_6', '海尔智家北京分公司', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '自合同签订起90天', 6883000);

-- ----------------------------
-- Table structure for zhaobiaoxiangmu
-- ----------------------------
DROP TABLE IF EXISTS `zhaobiaoxiangmu`;
CREATE TABLE `zhaobiaoxiangmu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `qiyemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业名称',
  `zhaobiaofanwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标范围',
  `zhaobiaowenjian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '招标文件',
  `toubiaojiezhishijian` date NULL DEFAULT NULL COMMENT '投标截止时间',
  `kaibiaoshijian` date NULL DEFAULT NULL COMMENT '开标时间',
  `xiangmudidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目地点',
  `xiangmuzhouqi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目周期',
  `hetongtiaokuan` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '合同条款',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复内容',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '封面',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司账号',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司名称',
  `xiangmuyusuan` double NULL DEFAULT NULL COMMENT '项目预算',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '招标项目' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhaobiaoxiangmu
-- ----------------------------
INSERT INTO `zhaobiaoxiangmu` VALUES (2, '2025-12-24 20:45:12', '省实验中学体育馆加固与翻新工程', 'owner_5', '格力电器销售有限公司', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '高新区创新园区B座', '24个月', '', '是', '', 'file/zhaobiaoxiangmuFengmian2.jpg,file/zhaobiaoxiangmuFengmian3.jpg,file/zhaobiaoxiangmuFengmian4.jpg', 'agency_5', '中经国际招标部', 1730000);
INSERT INTO `zhaobiaoxiangmu` VALUES (3, '2025-12-24 20:45:12', '滨海新区海绵城市生态修复（一期）', 'owner_6', '海尔智家北京分公司', '第三方安全监理与质量检测', '', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '365天', '', '是', '', 'file/zhaobiaoxiangmuFengmian3.jpg,file/zhaobiaoxiangmuFengmian4.jpg,file/zhaobiaoxiangmuFengmian5.jpg', 'agency_6', '弘业项目管理公司', 4779000);
INSERT INTO `zhaobiaoxiangmu` VALUES (4, '2025-12-24 20:45:12', '市政务云平台数据中心扩容采购', 'owner_7', '万科企业股份有限公司', '设计、施工、材料采购一体化', '', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '自合同签订起90天', '', '是', '', 'file/zhaobiaoxiangmuFengmian4.jpg,file/zhaobiaoxiangmuFengmian5.jpg,file/zhaobiaoxiangmuFengmian6.jpg', 'agency_7', '捷诚信达招标公司', 2282000);
INSERT INTO `zhaobiaoxiangmu` VALUES (5, '2025-12-24 20:45:12', '文化宫片区旧城改造拆迁评估服务', 'owner_3', '顺丰速递物流中心', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '空港经济区现代物流园', '180个日历天', '', '是', '', 'file/zhaobiaoxiangmuFengmian5.jpg,file/zhaobiaoxiangmuFengmian6.jpg,file/zhaobiaoxiangmuFengmian7.jpg', 'agency_3', '广厦项目管理公司', 5420000);
INSERT INTO `zhaobiaoxiangmu` VALUES (6, '2025-12-24 20:45:12', '高新区智能制造产业园分布式光伏项目', 'owner_7', '万科企业股份有限公司', '第三方安全监理与质量检测', '', '2025-12-24', '2025-12-24', '东部新区经开路12号', '24个月', '', '是', '', 'file/zhaobiaoxiangmuFengmian6.jpg,file/zhaobiaoxiangmuFengmian7.jpg,file/zhaobiaoxiangmuFengmian8.jpg', 'agency_7', '捷诚信达招标公司', 1320000);
INSERT INTO `zhaobiaoxiangmu` VALUES (7, '2025-12-24 20:45:12', '市图书馆数字化馆藏资源库扩建', 'owner_5', '格力电器销售有限公司', '设计、施工、材料采购一体化', '', '2025-12-24', '2025-12-24', '高新区创新园区B座', '365天', '', '是', '', 'file/zhaobiaoxiangmuFengmian7.jpg,file/zhaobiaoxiangmuFengmian8.jpg,file/zhaobiaoxiangmuFengmian9.jpg', 'agency_5', '中经国际招标部', 7995000);
INSERT INTO `zhaobiaoxiangmu` VALUES (8, '2025-12-24 20:45:12', '人民医院医学影像云存储及传输服务', 'owner_6', '海尔智家北京分公司', '设备供应及五年运维服务', '', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '自合同签订起90天', '', '是', '', 'file/zhaobiaoxiangmuFengmian8.jpg,file/zhaobiaoxiangmuFengmian9.jpg,file/zhaobiaoxiangmuFengmian10.jpg', 'agency_6', '弘业项目管理公司', 2059000);
INSERT INTO `zhaobiaoxiangmu` VALUES (9, '2025-12-24 20:45:12', '南北快速路隧道照明亮化提升工程', 'owner_1', '中天建设集团有限公司', '第三方安全监理与质量检测', '', '2026-04-18', '2025-12-24', '老城区文化遗址保护区', '180个日历天', '', '是', '', 'file/zhaobiaoxiangmuFengmian9.jpg,file/zhaobiaoxiangmuFengmian10.jpg,file/zhaobiaoxiangmuFengmian11.jpg', 'agency_1', '同诚招标代理公司', 6883000);

-- ----------------------------
-- Table structure for zhongbiaogonggao
-- ----------------------------
DROP TABLE IF EXISTS `zhongbiaogonggao`;
CREATE TABLE `zhongbiaogonggao`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `zhaobiaoren` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标人',
  `zhaobiaofanwei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '招标范围',
  `toubiaojiezhishijian` date NULL DEFAULT NULL COMMENT '投标截止时间',
  `kaibiaoshijian` date NULL DEFAULT NULL COMMENT '开标时间',
  `xiangmudidian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目地点',
  `xiangmuzhouqi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目周期',
  `dailigongsizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司账号',
  `dailigongsimingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代理公司名称',
  `qiyezhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业账号',
  `qiyemingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业名称',
  `toubiaorenzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人账号',
  `toubiaorenxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '投标人姓名',
  `jieguo` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '结果',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '中标公告' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of zhongbiaogonggao
-- ----------------------------
INSERT INTO `zhongbiaogonggao` VALUES (2, '2025-12-24 20:45:12', '省实验中学体育馆加固与翻新工程', '发包方负责人2', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '高新区创新园区B座', '24个月', 'agency_5', '中经国际招标部', 'owner_5', '格力电器销售有限公司', 'user_5', '孙七', '');
INSERT INTO `zhongbiaogonggao` VALUES (3, '2025-12-24 20:45:12', '滨海新区海绵城市生态修复（一期）', '发包方负责人3', '第三方安全监理与质量检测', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '365天', 'agency_6', '弘业项目管理公司', 'owner_6', '海尔智家北京分公司', 'user_6', '周八', '');
INSERT INTO `zhongbiaogonggao` VALUES (4, '2025-12-24 20:45:12', '市政务云平台数据中心扩容采购', '发包方负责人4', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '老城区文化遗址保护区', '自合同签订起90天', 'agency_7', '捷诚信达招标公司', 'owner_7', '万科企业股份有限公司', 'user_7', '吴九', '');
INSERT INTO `zhongbiaogonggao` VALUES (5, '2025-12-24 20:45:12', '文化宫片区旧城改造拆迁评估服务', '发包方负责人5', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '空港经济区现代物流园', '180个日历天', 'agency_3', '广厦项目管理公司', 'owner_3', '顺丰速递物流中心', 'user_3', '王五', '');
INSERT INTO `zhongbiaogonggao` VALUES (6, '2025-12-24 20:45:12', '高新区智能制造产业园分布式光伏项目', '发包方负责人6', '第三方安全监理与质量检测', '2025-12-24', '2025-12-24', '东部新区经开路12号', '24个月', 'agency_7', '捷诚信达招标公司', 'owner_7', '万科企业股份有限公司', 'user_7', '吴九', '');
INSERT INTO `zhongbiaogonggao` VALUES (7, '2025-12-24 20:45:12', '市图书馆数字化馆藏资源库扩建', '发包方负责人7', '设计、施工、材料采购一体化', '2025-12-24', '2025-12-24', '高新区创新园区B座', '365天', 'agency_5', '中经国际招标部', 'owner_5', '格力电器销售有限公司', 'user_5', '孙七', '');
INSERT INTO `zhongbiaogonggao` VALUES (8, '2025-12-24 20:45:12', '人民医院医学影像云存储及传输服务', '发包方负责人8', '设备供应及五年运维服务', '2025-12-24', '2025-12-24', '滨海新区海防大道88号', '自合同签订起90天', 'agency_1', '中天建设集团有限公司', 'owner_1', '同诚招标代理公司', 'user_1', '张三', '');

SET FOREIGN_KEY_CHECKS = 1;
