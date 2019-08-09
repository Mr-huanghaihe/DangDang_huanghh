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

Date: 2019-01-21 18:03:27
*/


-- ----------------------------
-- Table structure for ITEM
-- ----------------------------
DROP TABLE dd_item;
CREATE TABLE dd_item (
ID VARCHAR2(36 BYTE) NOT NULL ,
BOOK_ID VARCHAR2(36 BYTE) NULL ,
COUNT NUMBER(10) NULL ,
CREATE_DATE DATE NULL ,
ORDER_ID VARCHAR2(36 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
select * from dd_item
-- ----------------------------
-- Records of ITEM
-- ----------------------------

-- ----------------------------
-- Indexes structure for table ITEM
-- ----------------------------

-- ----------------------------
-- Checks structure for table ITEM
-- ----------------------------
ALTER TABLE HR.ITEM ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ITEM
-- ----------------------------
ALTER TABLE HR.ITEM ADD PRIMARY KEY (ID);
