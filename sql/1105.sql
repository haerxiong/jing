INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd1967600010', NULL, 1, '销售业绩明细', '81', 'zSaleController.do?list', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', 'admin', '2018-11-2 09:35:00', '2018-11-1 10:28:06', '管理员');
INSERT INTO `t_s_function` VALUES ('402881c866bda35a0166bdabe7350019', NULL, 1, '客户资金', '333', 'customMoneyController.do?list', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', 'admin', '2018-11-1 10:29:15', '2018-10-29 10:34:11', '管理员');
INSERT INTO `t_s_function` VALUES ('402881c866bd93ca0166bd97a6fc0005', NULL, 1, '客户利息', '71', 'zReturnController.do?list', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', 'admin', '2018-11-1 10:27:53', '2018-10-29 10:12:04', '管理员');
INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd185c42000a', NULL, 1, '客户资金日报表', '51', '', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', 'admin', '2018-11-1 10:27:17', '2018-11-1 10:26:57', '管理员');
INSERT INTO `t_s_function` VALUES ('402881c866bd93ca0166bd9731400003', NULL, 1, '客户信息汇总', '1', 'zTakeinController.do?list', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', 'admin', '2018-11-1 10:24:14', '2018-10-29 10:11:34', '管理员');
INSERT INTO `t_s_function` VALUES ('402881c866bd93ca0166bd9675c80001', NULL, 0, '财务', '0', '', NULL, '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', NULL, NULL, '2018-10-29 10:10:46', NULL);
INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd1662e30002', NULL, 1, '现有资金流水', '2', 'zTakeinController.do?list&type=xianyou', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', NULL, NULL, '2018-11-1 10:24:48', NULL);
INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd1759630006', NULL, 1, '客户资金到期汇总', '4', 'zTakeinController.do?list&type=daoqi', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', NULL, NULL, '2018-11-1 10:25:51', NULL);
INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd179a2b0008', NULL, 1, '客户资金汇总信息', '5', 'zTakeinController.do?list&type=huizong', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', NULL, NULL, '2018-11-1 10:26:08', NULL);
INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd18f8b7000d', NULL, 1, '客户单月流水汇总', '61', '', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', NULL, NULL, '2018-11-1 10:27:37', NULL);
INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd1995850012', NULL, 1, '销售提成发放', '91', '', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', NULL, NULL, '2018-11-1 10:28:17', NULL);
INSERT INTO `t_s_function` VALUES ('402881c866cd02000166cd19c7a70014', NULL, 1, '客户现金利息明细', '100', '', '402881c866bd93ca0166bd9675c80001', '8a8ab0b246dc81120146dc8180460000', '8a8ab0b246dc81120146dc8180dd001e', 0, '', 'admin', '管理员', NULL, NULL, '2018-11-1 10:28:30', NULL);

insert into t_s_typegroup value('402881c866cd02000166cd50127e0039', 'takein', '入金状态', now(), '管理员');
insert into t_s_type value('402881c866cd02000166cd514dd50040', '3', '到期已出金', NULL, '402881c866cd02000166cd50127e0039', now(), '管理员', '3');
insert into t_s_type value('402881c866cd02000166cd510de7003d', '2', '到期未出金', NULL, '402881c866cd02000166cd50127e0039', now(), '管理员', '2');
insert into t_s_type value('402881c866cd02000166cd508f3e003b', '1', '未到期', NULL, '402881c866cd02000166cd50127e0039', now(), '管理员', '1');

CREATE TABLE `z_takein` (
  `id` varchar(36) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL COMMENT '创建人名称',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人登录名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_name` varchar(50) DEFAULT NULL COMMENT '更新人名称',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人登录名称',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_del` varchar(32) DEFAULT NULL COMMENT '是否删除',
  `contract` varchar(64) DEFAULT NULL COMMENT '合同编号',
  `receipt` varchar(64) DEFAULT NULL COMMENT '收据编号',
  `sale_name` varchar(64) DEFAULT NULL COMMENT '销售姓名',
  `custom_name` varchar(64) DEFAULT NULL COMMENT '客户姓名',
  `id_card` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `takein_time` datetime DEFAULT NULL COMMENT '入金时间',
  `amount` double DEFAULT NULL COMMENT '金额',
  `time_limit` int(11) DEFAULT NULL COMMENT '期限',
  `rate` double DEFAULT NULL COMMENT '利率',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话',
  `bank_account` varchar(32) DEFAULT NULL COMMENT '汇款账号',
  `end_time` datetime DEFAULT NULL COMMENT '到期时间',
  `comment` longtext COMMENT '备注',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `out_time` datetime DEFAULT NULL COMMENT '出金时间',
  `invest_time` datetime DEFAULT NULL COMMENT '投资时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `z_saleman` (
  `id` varchar(36) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL COMMENT '创建人名称',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人登录名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_name` varchar(50) DEFAULT NULL COMMENT '更新人名称',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人登录名称',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `sale_name` varchar(32) DEFAULT NULL COMMENT '销售姓名',
  `team_name` varchar(32) DEFAULT NULL COMMENT '团队',
  `join_time` datetime DEFAULT NULL COMMENT '入职时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `z_sale` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `create_name` varchar(50) DEFAULT NULL COMMENT '创建人名称',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人登录名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_name` varchar(50) DEFAULT NULL COMMENT '更新人名称',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人登录名称',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_del` varchar(32) DEFAULT NULL COMMENT '是否删除',
  `takein_id` varchar(36) DEFAULT NULL COMMENT '外键指向takein表',
  `sign_time` datetime DEFAULT NULL COMMENT '签单时间',
  `year_total` decimal(32,0) DEFAULT NULL COMMENT '年化合计',
  `total` decimal(32,0) DEFAULT NULL COMMENT '合计',
  `performance` decimal(32,0) DEFAULT NULL COMMENT '业绩年化',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;