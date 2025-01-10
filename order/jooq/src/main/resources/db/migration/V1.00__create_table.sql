USE `order`;

CREATE TABLE IF NOT EXISTS `order_info` (
  `order_id` varchar(255) NOT NULL,
  `order_date_time` TIMESTAMP DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_amount` DECIMAL NOT NULL,
  `updated_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `created_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
);

CREATE TABLE IF NOT EXISTS `goods` (
  `goods_id` varchar(255) NOT NULL,
  `merchant_id` varchar(255) NOT NULL,
  `goods_name` varchar(255) NOT NULL,
  `amount` DECIMAL NOT NULL,
  `updated_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `created_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`goods_id`)
);


CREATE TABLE IF NOT EXISTS `order_goods_detail` (
  `order_id` varchar(255) NOT NULL,
  `goods_id` varchar(255) NOT NULL,
  `updated_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   `created_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`goods_id`, `order_id`)
);