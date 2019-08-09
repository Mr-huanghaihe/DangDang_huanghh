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

Date: 2019-01-21 18:03:43
*/


-- ----------------------------
-- Table structure for ORDERS
-- ----------------------------
DROP TABLE dd_order;
CREATE TABLE dd_order (
ID VARCHAR2(36 BYTE) NOT NULL ,
ORDER_NO VARCHAR2(36 BYTE) NULL ,
USER_ID VARCHAR2(36 BYTE) NULL ,
TOTAL NUMBER(10,2) NULL ,
CREATE_DATE DATE NULL ,
ADDRESS_ID VARCHAR2(36 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
select * from dd_order
delete from dd_order where id='b54fc378-9535-4bf9-aa46-57460eaf93fd'
-- ----------------------------
-- Records of ORDERS
-- ----------------------------

-- ----------------------------
-- Indexes structure for table ORDERS
-- ----------------------------

-- ----------------------------
-- Checks structure for table ORDERS
-- ----------------------------
ALTER TABLE HR.ORDERS ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ORDERS
-- ----------------------------
ALTER TABLE HR.ORDERS ADD PRIMARY KEY (ID);
