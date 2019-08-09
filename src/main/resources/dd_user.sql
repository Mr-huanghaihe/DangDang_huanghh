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

Date: 2019-01-21 18:04:07
*/


-- ----------------------------
-- Table structure for USERS
-- ----------------------------
DROP TABLE dd_user;
CREATE TABLE dd_user (
ID VARCHAR2(40 BYTE) NOT NULL ,
EMAIL VARCHAR2(40 BYTE) NULL ,
PASSWORD VARCHAR2(40 BYTE) NULL ,
SALT VARCHAR2(8 BYTE) NULL ,
NICKNAME VARCHAR2(40 BYTE) NULL ,
STATUS VARCHAR2(10 BYTE) NULL ,
CODE VARCHAR2(10 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
select * from dd_user

delete from dd_user where id='193d510b-527c-4a2c-a099-d322b2dc7356'
select id,email,password,nickname,salt,status,code from dd_user where email='123@qq.com'
-- ----------------------------
-- Records of USERS
-- ----------------------------
INSERT INTO dd_user VALUES ('1', '123@qq.com', '123456', 'PeQvrcHA', '哈哈', '正常', 'iAssUqTz');

-- ----------------------------
-- Indexes structure for table USERS
-- ----------------------------

-- ----------------------------
-- Checks structure for table USERS
-- ----------------------------
ALTER TABLE "HR"."USERS" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table USERS
-- ----------------------------
ALTER TABLE "HR"."USERS" ADD PRIMARY KEY ("ID");
