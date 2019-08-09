/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : dangdang
Source Server Version : 100200
Source Host           : 127.0.0.1:1521
Source Schema         : HR

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2019-01-21 18:03:13
*/


-- ----------------------------
-- Table structure for CATEGORY
-- ----------------------------
DROP TABLE CATEGORY



CREATE TABLE CATEGORY(
id VARCHAR2(36 BYTE),
name VARCHAR2(100 BYTE),
parentId VARCHAR2(36 BYTE),
levels NUMBER(1)
)
select * from category
select id,name,parentId,levels from category where levels='1'

create sequence dd_seq start with 5
insert into category values('1','小说',null,'1')
insert into category values('2','文艺',null,'1')
insert into category values('3','西游记','1','2')
insert into category values('4','浮世绘','1','2')
LOGGING
NOCOMPRESS
NOCACHE
select s.id sid,s.name sname,f.name fname,s.levels slevels
	   from category s left join category f on s.parentId=f.id
;
select s.id as s_id,s.name as s_name,s.parentId as s_parentId,s.levels as s_levels,
	   f.id as f_id,f.name as f_name,f.parentId as f_parentId,f.levels as f_levels
	   from category s left join category f on s.parentId=f.id
-- ----------------------------
-- Records of CATEGORY
-- ----------------------------
INSERT INTO "HR"."CATEGORY" VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '小说', null, '1');
INSERT INTO "HR"."CATEGORY" VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '文艺', null, '1');
INSERT INTO "HR"."CATEGORY" VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '科技', null, '1');
INSERT INTO "HR"."CATEGORY" VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '人文社科', null, '1');
INSERT INTO "HR"."CATEGORY" VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '生活', null, '1');
INSERT INTO "HR"."CATEGORY" VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '童书', null, '1');
INSERT INTO "HR"."CATEGORY" VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '教育', null, '1');
INSERT INTO "HR"."CATEGORY" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c1', '官场', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c2', '情感', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c3', '四大名著', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c4', '科幻小说', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c5', '近现代小说', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c6', '古典小说', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f1', '历史', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f2', '古籍', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f3', '哲学/宗教', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f4', '文化', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f5', '政治/军事', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f6', '法律', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b761', '文学', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b762', '传记', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b763', '艺术', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b764', '摄影', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8571', '科普', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8572', '建筑', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8573', '医学', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8574', '计算机', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8575', '农林', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8576', '自然科学', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a461', '两性', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a462', '孕期', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a463', '育儿', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a464', '亲自/家教', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a465', '保健', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a466', '运动', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a467', '家居', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('79a263c5-b609-473e-85c8-aa351c56cc51', '0-2', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('79a263c5-b609-473e-85c8-aa351c56cc52', '3-6', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('79a263c5-b609-473e-85c8-aa351c56cc53', '7-10', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('79a263c5-b609-473e-85c8-aa351c56cc54', '11-14', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('79a263c5-b609-473e-85c8-aa351c56cc55', '绘本', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('79a263c5-b609-473e-85c8-aa351c56cc56', '英语', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('4fe9388b-b672-4640-8078-d36d40772ad1', '教材', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('4fe9388b-b672-4640-8078-d36d40772ad2', '外语', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('4fe9388b-b672-4640-8078-d36d40772ad3', '考试', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('4fe9388b-b672-4640-8078-d36d40772ad4', '中小学教辅', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO "HR"."CATEGORY" VALUES ('4fe9388b-b672-4640-8078-d36d40772ad5', '工具书', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');

-- ----------------------------
-- Indexes structure for table CATEGORY
-- ----------------------------

-- ----------------------------
-- Checks structure for table CATEGORY
-- ----------------------------
ALTER TABLE "HR"."CATEGORY" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CATEGORY
-- ----------------------------
ALTER TABLE "HR"."CATEGORY" ADD PRIMARY KEY ("ID");
