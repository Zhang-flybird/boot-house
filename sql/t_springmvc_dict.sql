
CREATE TABLE `t_springmvc_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(16) NOT NULL COMMENT '字典项分组id',
  `name` varchar(32) NOT NULL COMMENT '字典名称',
  `value` varchar(16) NOT NULL COMMENT '字典值',
  `sort` int(11) NOT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
);