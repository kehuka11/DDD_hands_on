/*
 * This file is generated by jOOQ.
 */
package jooq.gen.tables.records;


import java.time.LocalDateTime;

import jooq.gen.tables.OrderGoodsDetail;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderGoodsDetailRecord extends UpdatableRecordImpl<OrderGoodsDetailRecord> implements Record4<String, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>order.order_goods_detail.order_id</code>.
     */
    public void setOrderId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>order.order_goods_detail.order_id</code>.
     */
    public String getOrderId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>order.order_goods_detail.goods_id</code>.
     */
    public void setGoodsId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>order.order_goods_detail.goods_id</code>.
     */
    public String getGoodsId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>order.order_goods_detail.updated_time</code>.
     */
    public void setUpdatedTime(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>order.order_goods_detail.updated_time</code>.
     */
    public LocalDateTime getUpdatedTime() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>order.order_goods_detail.created_time</code>.
     */
    public void setCreatedTime(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>order.order_goods_detail.created_time</code>.
     */
    public LocalDateTime getCreatedTime() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return OrderGoodsDetail.ORDER_GOODS_DETAIL.ORDER_ID;
    }

    @Override
    public Field<String> field2() {
        return OrderGoodsDetail.ORDER_GOODS_DETAIL.GOODS_ID;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return OrderGoodsDetail.ORDER_GOODS_DETAIL.UPDATED_TIME;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return OrderGoodsDetail.ORDER_GOODS_DETAIL.CREATED_TIME;
    }

    @Override
    public String component1() {
        return getOrderId();
    }

    @Override
    public String component2() {
        return getGoodsId();
    }

    @Override
    public LocalDateTime component3() {
        return getUpdatedTime();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedTime();
    }

    @Override
    public String value1() {
        return getOrderId();
    }

    @Override
    public String value2() {
        return getGoodsId();
    }

    @Override
    public LocalDateTime value3() {
        return getUpdatedTime();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedTime();
    }

    @Override
    public OrderGoodsDetailRecord value1(String value) {
        setOrderId(value);
        return this;
    }

    @Override
    public OrderGoodsDetailRecord value2(String value) {
        setGoodsId(value);
        return this;
    }

    @Override
    public OrderGoodsDetailRecord value3(LocalDateTime value) {
        setUpdatedTime(value);
        return this;
    }

    @Override
    public OrderGoodsDetailRecord value4(LocalDateTime value) {
        setCreatedTime(value);
        return this;
    }

    @Override
    public OrderGoodsDetailRecord values(String value1, String value2, LocalDateTime value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderGoodsDetailRecord
     */
    public OrderGoodsDetailRecord() {
        super(OrderGoodsDetail.ORDER_GOODS_DETAIL);
    }

    /**
     * Create a detached, initialised OrderGoodsDetailRecord
     */
    public OrderGoodsDetailRecord(String orderId, String goodsId, LocalDateTime updatedTime, LocalDateTime createdTime) {
        super(OrderGoodsDetail.ORDER_GOODS_DETAIL);

        setOrderId(orderId);
        setGoodsId(goodsId);
        setUpdatedTime(updatedTime);
        setCreatedTime(createdTime);
    }
}