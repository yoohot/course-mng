

CREATE TABLE course_record
(
  id bigint PRIMARY KEY NOT NULL auto_increment,
  original_id varchar(32) NOT NULL,
  title varchar(50) NOT NULL,
  pict_url varchar(256) COMMENT '主图',
  course_url varchar(256) NOT NULL COMMENT '课程详细地址',
  teacher_name varchar(16) NOT NULL,
  chapter_num varchar(10) NOT NULL,
  real_price decimal(8,2),
  price decimal(10,2),
  price_type int DEFAULT 0 NOT NULL COMMENT '0 免费 1 收费',
  open_date date NOT NULL COMMENT '首页展示日期：爬虫日期',
  category_name varchar(32) COMMENT '首页展示所在分类',
  resource varchar(8) DEFAULT 'QQ' COMMENT '数据来源',
  gmt_created datetime NOT NULL,
  gmt_modified datetime NOT NULL
) CHARACTER SET utf8 COLLATE utf8_general_ci engine innodb;