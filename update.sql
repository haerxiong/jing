SELECT 1 from dual;

alter table z_takein add column sys_org_code varchar(50) comment '所属部门';
alter table z_takein add column sys_company_code varchar(50) comment '所属公司';

alter table z_sale add column sys_org_code varchar(50) comment '所属部门';
alter table z_sale add column sys_company_code varchar(50) comment '所属公司';

alter table z_saleman add column sys_org_code varchar(50) comment '所属部门';
alter table z_saleman add column sys_company_code varchar(50) comment '所属公司';

alter table z_takein_way add column sys_org_code varchar(50) comment '所属部门';
alter table z_takein_way add column sys_company_code varchar(50) comment '所属公司';