package com.example.order.domain.entity.root;

import com.example.order.domain.value.OrderDateTime;
import com.example.order.domain.value.OrderId;
import com.example.order.domain.value.Status;
import com.example.order.domain.value.TotalAmount;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Order {
    private final OrderId orderId;
    private final OrderDateTime orderDateTime;
    private final Status status;
    private final TotalAmount totalAmount;

    private Order(OrderId orderId, OrderDateTime orderDateTime, Status status, TotalAmount totalAmount) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public static Order newOrder(OrderId orderId, OrderDateTime orderDateTime, Status status, TotalAmount totalAmount) {

        if (Objects.isNull(orderId) || Objects.isNull(orderDateTime) || Objects.isNull(status) || Objects.isNull(totalAmount)) {
            throw new RuntimeException("error");
        }

        return new Order(orderId, orderDateTime, status, totalAmount);
    }
}
