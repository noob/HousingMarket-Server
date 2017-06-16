


-- 商铺表
DROP TABLE IF EXISTS `HM_STORE`;
CREATE TABLE `HM_STORE` (
  `STORE_ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(25) NOT NULL COMMENT '用户ID',
  `BUSSINESS_LICENSE` VARCHAR(255) DEFAULT NULL COMMENT '商家许可证 ',
  `STORE_ADDRESS` VARCHAR(255) DEFAULT NULL COMMENT '商家地址',
  `STORE_NAME` VARCHAR(255) DEFAULT NULL COMMENT '店名 ',
  `STORE_MOBILE` VARCHAR(255) DEFAULT NULL COMMENT '商家联系方式 ',
  STORE_IMG VARCHAR(255) COMMENT '商铺图片',
	CREATE_DATE DATETIME DEFAULT NULL COMMENT '建立时间 ', -- 建立时间
	QR_CODE VARCHAR(255) DEFAULT NULL COMMENT '店铺二维码 ', 
`GETUI_CLIENT_ID` VARCHAR(100) DEFAULT NULL COMMENT '个推clientid',
  `DEVICE_INFO` VARCHAR(50) DEFAULT NULL COMMENT '客户端类型', -- e.g. : Andriod_Store

  PRIMARY KEY (`STORE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;