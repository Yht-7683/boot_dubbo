/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50721
Source Host           : 121.41.91.101:3306
Source Database       : pokemondb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-02-10 14:40:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ball
-- ----------------------------
DROP TABLE IF EXISTS `ball`;
CREATE TABLE `ball` (
  `id` int(25) NOT NULL,
  `name` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `probability` double(25,0) NOT NULL,
  `money` int(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ball
-- ----------------------------
INSERT INTO `ball` VALUES ('1', '精灵球', '../../static/图鉴/精灵球.png', '50', '200');
INSERT INTO `ball` VALUES ('2', '超级球', '../../static/图鉴/超级球.png', '60', '400');
INSERT INTO `ball` VALUES ('3', '高级球', '../../static/图鉴/高级球.png', '80', '1200');
INSERT INTO `ball` VALUES ('4', '究极球', '../../static/图鉴/究极球.png', '90', '5000');
INSERT INTO `ball` VALUES ('5', '大师球', '../../static/图鉴/大师球.png', '100', '10000');

-- ----------------------------
-- Table structure for ball_pack
-- ----------------------------
DROP TABLE IF EXISTS `ball_pack`;
CREATE TABLE `ball_pack` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(25) NOT NULL,
  `ball_id` int(25) NOT NULL,
  `num` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `o21` (`user_id`) USING BTREE,
  KEY `o22` (`ball_id`) USING BTREE,
  CONSTRAINT `ball_pack_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ball_pack_ibfk_2` FOREIGN KEY (`ball_id`) REFERENCES `ball` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ball_pack
-- ----------------------------
INSERT INTO `ball_pack` VALUES ('1', '12', '5', '10');
INSERT INTO `ball_pack` VALUES ('2', '12', '2', '10');
INSERT INTO `ball_pack` VALUES ('3', '12', '1', '10');
INSERT INTO `ball_pack` VALUES ('4', '12', '3', '10');
INSERT INTO `ball_pack` VALUES ('5', '123132', '4', '10');
INSERT INTO `ball_pack` VALUES ('6', '12', '4', '5');
INSERT INTO `ball_pack` VALUES ('7', '123132', '1', '0');
INSERT INTO `ball_pack` VALUES ('13', '1', '1', '11');
INSERT INTO `ball_pack` VALUES ('14', '1', '2', '6');
INSERT INTO `ball_pack` VALUES ('15', '1', '3', '6');
INSERT INTO `ball_pack` VALUES ('16', '1', '4', '0');
INSERT INTO `ball_pack` VALUES ('17', '1', '5', '0');
INSERT INTO `ball_pack` VALUES ('18', '222', '1', '0');
INSERT INTO `ball_pack` VALUES ('19', '222', '2', '0');
INSERT INTO `ball_pack` VALUES ('20', '222', '3', '1');
INSERT INTO `ball_pack` VALUES ('21', '222', '4', '0');
INSERT INTO `ball_pack` VALUES ('22', '222', '5', '0');
INSERT INTO `ball_pack` VALUES ('23', 'uKMRF1', '1', '1');
INSERT INTO `ball_pack` VALUES ('24', 'uKMRF1', '2', '0');
INSERT INTO `ball_pack` VALUES ('25', 'uKMRF1', '3', '0');
INSERT INTO `ball_pack` VALUES ('26', 'uKMRF1', '4', '0');
INSERT INTO `ball_pack` VALUES ('27', 'uKMRF1', '5', '0');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `details` varchar(255) NOT NULL,
  `time` date NOT NULL DEFAULT '0000-00-00',
  `user_id` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `s1` (`user_id`) USING BTREE,
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '欢迎', '欢迎使用本系统', '2019-11-30', '123132');

-- ----------------------------
-- Table structure for pkm_pack
-- ----------------------------
DROP TABLE IF EXISTS `pkm_pack`;
CREATE TABLE `pkm_pack` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `pokemon_id` int(20) NOT NULL,
  `meetTime` date NOT NULL DEFAULT '0000-00-00',
  `LV` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `o1` (`user_id`) USING BTREE,
  KEY `o2` (`pokemon_id`) USING BTREE,
  CONSTRAINT `pkm_pack_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pkm_pack_ibfk_2` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemon` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pkm_pack
-- ----------------------------
INSERT INTO `pkm_pack` VALUES ('1', '123132', '1', '2019-12-01', '15');
INSERT INTO `pkm_pack` VALUES ('2', '123132', '15', '2019-12-01', '55');
INSERT INTO `pkm_pack` VALUES ('3', '123132', '7', '2019-12-05', '45');
INSERT INTO `pkm_pack` VALUES ('4', '12', '14', '2019-12-05', '14');
INSERT INTO `pkm_pack` VALUES ('5', '12', '34', '2019-12-05', '14');
INSERT INTO `pkm_pack` VALUES ('6', '123132', '8', '2019-12-07', '45');
INSERT INTO `pkm_pack` VALUES ('7', '123132', '1', '2019-12-07', '1');
INSERT INTO `pkm_pack` VALUES ('8', '123132', '19', '2019-12-07', '45');
INSERT INTO `pkm_pack` VALUES ('9', '123132', '16', '2019-12-07', '52');
INSERT INTO `pkm_pack` VALUES ('10', '123132', '24', '2019-12-07', '45');
INSERT INTO `pkm_pack` VALUES ('11', '222', '28', '2020-01-16', '58');
INSERT INTO `pkm_pack` VALUES ('12', '222', '17', '2020-01-20', '27');

-- ----------------------------
-- Table structure for pokemon
-- ----------------------------
DROP TABLE IF EXISTS `pokemon`;
CREATE TABLE `pokemon` (
  `id` int(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `type` varchar(25) NOT NULL,
  `ability` varchar(255) DEFAULT NULL,
  `others` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pokemon
-- ----------------------------
INSERT INTO `pokemon` VALUES ('1', '小火龙', '../../static/图鉴/小火龙.png', '火', '猛火', '');
INSERT INTO `pokemon` VALUES ('2', '火恐龙', '../../static/图鉴/火恐龙.png', '火', '猛火', '	挥动燃烧着火焰的尾巴，用锋利的爪子撕裂对手。性格十分粗暴。');
INSERT INTO `pokemon` VALUES ('3', '喷火龙', '../../static/图鉴/喷火龙.png', '火/飞行', '猛火', '能够喷出猛烈的火焰，仿佛连岩石都能烤焦。有时会引发森林火灾。');
INSERT INTO `pokemon` VALUES ('4', '鲤鱼王', '../../static/图鉴/鲤鱼王.png', '水', '悠游自如', '力量和速度几乎都不行。是世界上最弱最可怜的宝可梦');
INSERT INTO `pokemon` VALUES ('5', '暴鲤龙', '../../static/图鉴/暴鲤龙.png', '水/飞', '威吓', '性格非常凶暴。从嘴里发出的破坏光线能够将一切燃烧殆尽');
INSERT INTO `pokemon` VALUES ('6', '鬼斯', '../../static/图鉴/鬼斯.png', '鬼/毒', '飘浮', '从气体中诞生的生命体。如果被含毒的气体状身体裹住的话，不管是谁都会昏迷过去。');
INSERT INTO `pokemon` VALUES ('7', '鬼斯通', '../../static/图鉴/鬼斯通.png', '鬼/毒', '飘浮', '	据说如果被它气体状的舌头舔到，身体就会无法停止颤抖，最终将会导致死亡。');
INSERT INTO `pokemon` VALUES ('8', '耿鬼', '../../static/图鉴/耿鬼.png', '鬼/毒', '诅咒之躯', '	满月的夜晚，如果影子自己动起来并露出笑容，那肯定是耿鬼搞的鬼。');
INSERT INTO `pokemon` VALUES ('9', '皮卡丘', '../../static/图鉴/皮卡丘.png', '电', '静电', '越是能制造出强大电流的皮卡丘，脸颊上的囊就越柔软，同时也越有伸展性。');
INSERT INTO `pokemon` VALUES ('10', '雷丘', '../../static/图鉴/雷丘.png', '电', '静电', '长长的尾巴能够像接地线一样保护自己，因此即使是高压电也不会让它麻痹。');
INSERT INTO `pokemon` VALUES ('11', '小果然', '../../static/图鉴/小果然.png', '超', '踩影', '	和大群伙伴一起行动，通过和伙伴彼此推挤来锻炼自己的忍耐力');
INSERT INTO `pokemon` VALUES ('12', '果然翁', '../../static/图鉴/果然翁.png', '超', '踩影', '讨厌光和冲击。受到攻击时，身体就会膨胀，反击也会因此变强。');
INSERT INTO `pokemon` VALUES ('13', '	玛狃拉', '../../static/图鉴/玛狃拉.png', '	恶/冰', '压迫感', '成群结队袭击猎物。通过团队合作，连象牙猪那样强大的对手也能轻松解决。');
INSERT INTO `pokemon` VALUES ('14', '谜拟Q', '../../static/图鉴/谜拟Q.png', '鬼/妖', '画皮', '为了让别人不要害怕自己，特意穿上了看似皮卡丘的破布，结果却变得更加令人毛骨悚然。');
INSERT INTO `pokemon` VALUES ('15', '路卡利欧', '../../static/图鉴/路卡利欧.png', '格斗/钢', '不屈之心/精神力', '操纵一种被称为波导的力量来进行狩猎。这种力量就连巨大的岩石也能击得粉碎。');
INSERT INTO `pokemon` VALUES ('16', '拉普拉斯', '../../static/图鉴/拉普拉斯.png', '水/冰', '储水/硬壳盔甲', '	头脑聪慧，心地善良的宝可梦。会一边以优美的声音歌唱，一边畅游于大海之上。');
INSERT INTO `pokemon` VALUES ('17', '吼吼鲸', '../../static/图鉴/吼吼鲸.png', '水', '水幕/迟钝', '	头脑聪慧，心地善良的宝可梦。会一边以优美的声音歌唱，一边畅游于大海之上。');
INSERT INTO `pokemon` VALUES ('18', '吼鲸王', '../../static/图鉴/吼鲸王.png', '水', '水幕/迟钝', '	有时会让大大的身体在波浪上跳跃，并以此来产生冲击让对手昏迷。');
INSERT INTO `pokemon` VALUES ('19', '卡蒂狗', '../../static/图鉴/卡蒂狗.png', '火', '威吓 / 引火', '能毫无畏惧地去对抗比自己更强更大的对手。性格勇敢非常可靠。');
INSERT INTO `pokemon` VALUES ('20', '	风速狗', '../../static/图鉴/风速狗.png', '火', '威吓 / 引火', '从古时候起就是俘获了众多人心的美丽宝可梦。能像飞一样轻巧地奔跑。');
INSERT INTO `pokemon` VALUES ('21', '拉鲁拉丝', '../../static/图鉴/拉鲁拉丝.png', '超/妖', '同步/复制', '	能敏锐地捕捉人和宝可梦的感情。感受到敌意后就会躲进暗处。');
INSERT INTO `pokemon` VALUES ('22', '	奇鲁莉安', '../../static/图鉴/奇鲁莉安.png', '超/妖', '	同步/复制', '当训练家高兴的时候，奇鲁莉安会充满能量，开心地转着圈跳舞。');
INSERT INTO `pokemon` VALUES ('23', '艾路雷朵', '../../static/图鉴/艾路雷朵.png', '超/格', '不屈之心', '被称为武神的宝可梦。只有在为了保护什么的时候才会去使用自己的肘刀。');
INSERT INTO `pokemon` VALUES ('24', '沙奈朵', '../../static/图鉴/沙奈朵.png', '超/妖', '同步/复制', '有着预知未来的能力。在保护训练家的时候，会发挥出最强的力量。');
INSERT INTO `pokemon` VALUES ('25', '伊布', '../../static/图鉴/伊布.png', '普通', '逃跑/适应力', '	由于不稳定的遗传基因，蕴含着各种各样进化可能性的特殊宝可梦。');
INSERT INTO `pokemon` VALUES ('26', '火精灵', '../../static/图鉴/火精灵.png', '火', '引火', '当火焰在体内积蓄时，火精灵的体温也会随之上升到最高９００度。');
INSERT INTO `pokemon` VALUES ('27', '雷精灵', '../../static/图鉴/雷精灵.png', '电', '蓄电', '当雷精灵生气或是吃惊时，它全身的体毛会像针一样竖起来刺穿对手。');
INSERT INTO `pokemon` VALUES ('28', '水精灵', '../../static/图鉴/水精灵.png', '水', '储水', '	当水伊布开始微微颤动它全身上下的鳍，就表示几个小时之后要下雨了');
INSERT INTO `pokemon` VALUES ('29', '叶精灵', '../../static/图鉴/叶精灵.png', '草', '叶子防守', '尾巴好似锐利的刀刃，锋利得无与伦比，连大树都能一斩为二。');
INSERT INTO `pokemon` VALUES ('30', '冰精灵', '../../static/图鉴/冰精灵.png', '冰', '雪隐', '	能够降下冰晶。被它的美貌迷住的猎物会在不知不觉间被冻住。');
INSERT INTO `pokemon` VALUES ('31', '太阳精灵', '../../static/图鉴/太阳精灵.png', '超', '同步', '能通过感受空气的流动，准确地预测出接下来的天气和对手的行动等等。');
INSERT INTO `pokemon` VALUES ('32', '月精灵', '../../static/图鉴/月精灵.png', '恶', '同步', '	发怒的时候会从全身的毛孔喷出混合了毒素的汗液，袭击对手的眼睛。');
INSERT INTO `pokemon` VALUES ('33', '仙子精灵', '../../static/图鉴/仙子精灵.png', '妖', '迷人之躯', '会从蝴蝶结般的触角里释放能够消除敌意的波动，借此平息纷争。');
INSERT INTO `pokemon` VALUES ('34', '皮皮', '../../static/图鉴/皮皮.png', '妖', '迷人之躯/魔法防守', '据说在满月的夜晚，如果能看到皮皮们聚在一起跳舞，就能得到幸福。');
INSERT INTO `pokemon` VALUES ('35', '皮可西', '../../static/图鉴/皮可西.png', '妖', '迷人之躯/魔法防守', '妖精的一种，极少出现在人前。察觉到有人存在后，好像就会立刻逃走。');
INSERT INTO `pokemon` VALUES ('36', '腕力', '../../static/图鉴/腕力.png', '格', '毅力/无防守', '	时时刻刻都充满力量。由于体力过剩而去举起岩石消磨时间，也因此变得更强。');
INSERT INTO `pokemon` VALUES ('37', '豪力', '../../static/图鉴/豪力.png', '格', '毅力/无防守', '	因为肉体非常强韧，所以戴着力量限制腰带来控制力量。');
INSERT INTO `pokemon` VALUES ('38', '怪力', '../../static/图鉴/怪力.png', '格', '毅力/无防守', '能够迅速活动４只手臂，从各个角度毫不停歇地使出拳击或手刀。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `state` varchar(11) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `registTime` date NOT NULL DEFAULT '0000-00-00',
  `money` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=ad9086b6af014c080d3620f76b12696d/4ec2d5628535e5dda3a5aec070c6a7efce1b6227.jpg', '1', '1', '正常', '管理员', '女', '2019-12-08', '1000');
INSERT INTO `user` VALUES ('12', '究极异兽', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', '123', '123', '正常', '管理员', '男', '2019-12-03', '100000');
INSERT INTO `user` VALUES ('123132', '神兽', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg', '123456', '4567864566', '冻结', '用户', '女', '2019-12-03', '111111');
INSERT INTO `user` VALUES ('222', '2', 'https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=ad9086b6af014c080d3620f76b12696d/4ec2d5628535e5dda3a5aec070c6a7efce1b6227.jpg', '2', '222', '正常', '用户', '男', '2019-12-09', '1022');
INSERT INTO `user` VALUES ('uKMRF1', '333', 'https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=ce1116222634349b600b66d7a8837eab/94cad1c8a786c9179402a501c73d70cf3bc75781.jpg', '333', '333', '正常', '用户', '男', '2019-12-10', '10000');
