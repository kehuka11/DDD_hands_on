package com.example.order.domain.value;

import lombok.Getter;

@Getter
public class Quantity {

    private static final int MIN_QUANTITY_SIZE = 0;

    private final Integer value;

    public Quantity(int value) {
        if (value < MIN_QUANTITY_SIZE) {
            throw new IllegalArgumentException("0以上を指定してください");
        }
        this.value = value;
    }
}
