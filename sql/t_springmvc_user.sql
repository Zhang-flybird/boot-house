
CREATE TABLE `t_springmvc_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `gender` varchar(4) NOT NULL COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `birthday` date NOT NULL COMMENT '出生日期',
  PRIMARY KEY (`id`)
);