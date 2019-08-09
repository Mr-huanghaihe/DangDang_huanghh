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

Date: 2019-01-21 18:02:47
*/


-- ----------------------------
-- Table structure for ADDRESS
-- ----------------------------
DROP TABLE dd_address;
CREATE TABLE dd_address (
ID VARCHAR2(36 BYTE) NOT NULL ,
NAME VARCHAR2(30 BYTE) NULL ,
LOCAL VARCHAR2(300 BYTE) NULL ,
ZIP_CODE VARCHAR2(10 BYTE) NULL ,
PHONE VARCHAR2(11 BYTE) NULL ,
USER_ID VARCHAR2(36 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
select * from dd_address
insert into dd_address values('1','黄海河','贝克','100000','1234567','dc05ad5c-0aa1-4cdf-ae04-67fc379e639a')
-- ----------------------------
-- Records of ADDRESS
-- ----------------------------

-- ----------------------------
-- Indexes structure for table ADDRESS
-- ----------------------------

-- ----------------------------
-- Checks structure for table ADDRESS
-- ----------------------------
ALTER TABLE "HR"."ADDRESS" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ADDRESS
-- ----------------------------
ALTER TABLE "HR"."ADDRESS" ADD PRIMARY KEY ("ID");
