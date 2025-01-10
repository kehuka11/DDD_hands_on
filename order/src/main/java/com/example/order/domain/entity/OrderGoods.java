package com.example.order.domain.entity;

import com.example.order.domain.value.GoodsId;
import com.example.order.domain.value.Quantity;
import com.example.order.domain.value.Subtotal;
import lombok.Getter;

import java.util.Map;

@Getter
public class OrderGoods {

    private final Map<GoodsId, Quantity> itemSummary;

    private final Subtotal subtotal;

    private OrderGoods(Map<GoodsId, Quantity> itemSummary, Subtotal subtotal) {
        this.itemSummary = itemSummary;
        this.subtotal = subtotal;
    }


}
