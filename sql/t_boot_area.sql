drop table if exists t_ boot_ area;
create table if not exists t_boot_area(
id int not null auto_increment comment ' 主键',
pid int not null comment ' parent id',
name varchar(128) comment '地区名称' ,
sort int comment '排序字段',
primary key (id)
);



INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('1', '0', '山东省', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('2', '0', '江苏省', '2');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('3', '0', '北京市', '3');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('4', '1', '济南市', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('5', '1', '青岛市', '2');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('6', '2', '南京市', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('7', '2', '苏州市', '2');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('8', '3', '北京市', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('9', '4', '天桥区', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('10', '4', '历下区', '2');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('11', '5', '市南区', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('12', '5', '城阳区', '2');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('13', '6', '雨花区', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('14', '6', '建邺区', '2');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('15', '8', '海淀区', '1');
INSERT INTO t_boot_area (`id`, `pid`, `name`, `sort`) VALUES ('16', '8', '朝阳区', '2');