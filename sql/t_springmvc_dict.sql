
CREATE TABLE `t_springmvc_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(16) NOT NULL COMMENT '字典项分组id',
  `name` varchar(32) NOT NULL COMMENT '字典名称',
  `value` varchar(16) NOT NULL COMMENT '字典值',
  `sort` int(11) NOT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
);


INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'rent_mode', '整租', '1', '1');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'rent_mode', '合租', '2', '2');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'house_type', '一居', '1', '1');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'house_type', '二居', '2', '2');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'house_type', '三居', '3', '3');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'house_type', '四居及以上', '4', '4');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'orientation', '东', '1', '1');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'orientation', '西', '2', '2');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'orientation', '南', '3', '3');
INSERT INTO `t_springmvc_dict` (`id`, `group_id`, `name`, `value`, `sort`) VALUES (null, 'orientation', '北', '4', '4');
