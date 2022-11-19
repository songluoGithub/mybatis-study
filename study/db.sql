CREATE TABLE `tbl_department` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `tel` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

CREATE TABLE `tbl_user` (
  `id` varchar(32) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `department_id` varchar(32) NOT NULL,
  `sorder` int(11) NOT NULL DEFAULT '1',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

create table tbl_dept2 (
    id int(11) not null auto_increment,
    name varchar(32) not null,
    tel varchar(18) default null,
    primary key (id)
);