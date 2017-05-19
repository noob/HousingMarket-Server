

-- 订单表
DROP TABLE IF EXISTS `HM_ORDER`;
CREATE TABLE `HM_ORDER` (
  `ORDER_ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(25) NOT NULL COMMENT '用户ID',
  `ORDER_GOODS_ID` bigint(25) NOT NULL COMMENT '订单商品表ID',
  `STORE_ID` bigint(25) DEFAULT NULL COMMENT '商家id',  
  `ORDER_TRADE_NO` varchar(20) NOT NULL COMMENT '订单编号',
  `PAYWAY` varchar(100) NOT NULL COMMENT '支付方式',
  `USER_NAME` varchar(25) NOT NULL COMMENT '用户名',
  `ORDER_PRICE` DECIMAL(8,2) NOT NULL COMMENT '订单价格',
  `SEND_PRICE` DECIMAL(8,2) NOT NULL COMMENT '配送价格',
  
  `ORDER_CREATE_TIME` timestamp  NULL  COMMENT '创建时间',
  `ORDER_PAY_TIME` timestamp  NULL COMMENT '支付时间',
  `ORDER_REFUSE_TIME` timestamp  NULL COMMENT '拒绝时间',
  `ORDER_REFUND_TIME` timestamp  NULL COMMENT '退款时间',
  `ORDER_CONFIRM_TIME` timestamp  NULL COMMENT '确认收货时间',
  `ORDER_COMPLETE_TIME` timestamp  NULL COMMENT '订单完成时间',
  ORDER_STATUS INTEGER(1) COMMENT '订单状态',
  
  `BUYER_MOBILE` varchar(20) DEFAULT NULL COMMENT '买家联系方式',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '收货地址',
  	MAN_JIAN VARCHAR(255) COMMENT '满减',	-- 满减
	MAN_FAN VARCHAR(255) COMMENT '满返', -- 满返
	MAN_SONG VARCHAR(255) COMMENT '满送 ', -- 满送

  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 订单商品表
DROP TABLE IF EXISTS `HM_ORDER_GOODS`;
CREATE TABLE `HM_ORDER_GOODS` (
  `ORDER_GOODS_ID` bigint(25) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` bigint(25) NOT NULL COMMENT '订单表ID',
  `STORE_ID` bigint(25) DEFAULT NULL COMMENT '商家id',  
  `GOODS_ID` bigint(25) DEFAULT NULL COMMENT '商品id', 
  CATE_ID  bigint(25) COMMENT '类别ID',    -- 类别ID 
  `GOODS_PRICE` DECIMAL(8,2) NOT NULL COMMENT '商品单价(取自商品表)',
  GOOD_NAME VARCHAR(255) NOT NULL COMMENT '单品名称',  -- 单品名称
	GOOD_IMAGE VARCHAR(255) NOT NULL COMMENT '单品图片',  -- 单品图片
  `GOOD_COUNT` INTEGER NOT NULL COMMENT '商品数量，默认为 1', 	 -- 商品数量，默认为 1
  PRIMARY KEY (`ORDER_GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 商品表
DROP TABLE IF EXISTS `HM_GOODS`;
CREATE TABLE `HM_GOODS` (
  `GOODS_ID` bigint(25) NOT NULL AUTO_INCREMENT,
  CATE_ID  bigint(25) COMMENT '类别ID',    -- 类别ID 
  `STORE_ID` bigint(25) DEFAULT NULL COMMENT '商家id',  
  GOOD_ORIGINAL_PRICE DECIMAL(8,2) DEFAULT 0 COMMENT '商品原价', -- 商品原价
  `GOODS_PRICE` DECIMAL(8,2) NOT NULL COMMENT '商品现价',
  GOOD_NAME VARCHAR(255) NOT NULL COMMENT '单品名称',  -- 单品名称
	GOOD_IMAGE VARCHAR(255) NOT NULL COMMENT '单品图片',  -- 单品图片
	DISCOUNT decimal(20,5) DEFAULT 0 COMMENT '打折', 	-- 打折
  COUNT_UNIT varchar(50) DEFAULT 0 COMMENT '计量单位', -- 计量单位
  DESCRIPTION  varchar(255) NULL COMMENT '描述', -- 描述
  MARK  varchar(255) NULL COMMENT ' 备注', -- 备注
	SALES_VOLUME int(11) DEFAULT 0 COMMENT '销量', -- 销售量
  INVENTORY int(11) DEFAULT 0 COMMENT '库存', -- 库存量
	CREATE_DATE DATETIME DEFAULT NULL, -- 建立时间
  PRIMARY KEY (`GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


