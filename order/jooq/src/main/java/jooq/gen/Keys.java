/*
 * This file is generated by jOOQ.
 */
package jooq.gen;


import jooq.gen.tables.Goods;
import jooq.gen.tables.OrderGoodsDetail;
import jooq.gen.tables.OrderInfo;
import jooq.gen.tables.records.GoodsRecord;
import jooq.gen.tables.records.OrderGoodsDetailRecord;
import jooq.gen.tables.records.OrderInfoRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * order.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GoodsRecord> KEY_GOODS_PRIMARY = Internal.createUniqueKey(Goods.GOODS, DSL.name("KEY_goods_PRIMARY"), new TableField[] { Goods.GOODS.GOODS_ID }, true);
    public static final UniqueKey<OrderGoodsDetailRecord> KEY_ORDER_GOODS_DETAIL_PRIMARY = Internal.createUniqueKey(OrderGoodsDetail.ORDER_GOODS_DETAIL, DSL.name("KEY_order_goods_detail_PRIMARY"), new TableField[] { OrderGoodsDetail.ORDER_GOODS_DETAIL.GOODS_ID, OrderGoodsDetail.ORDER_GOODS_DETAIL.ORDER_ID }, true);
    public static final UniqueKey<OrderInfoRecord> KEY_ORDER_INFO_PRIMARY = Internal.createUniqueKey(OrderInfo.ORDER_INFO, DSL.name("KEY_order_info_PRIMARY"), new TableField[] { OrderInfo.ORDER_INFO.ORDER_ID }, true);
}
