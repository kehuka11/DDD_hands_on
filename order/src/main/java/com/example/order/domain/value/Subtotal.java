package com.example.order.domain.value;

import lombok.Getter;

import java.util.List;

@Getter
public class Subtotal {

    private static final int MIN_AMOUNTS_LIST_SIZE = 0;

    private static final int MIN_SUBTOTAL = 0;

    private final Integer amount;

    private Subtotal(Integer amount) {

        this.amount = amount;
    }

    /**
     * 小計計算
     * @param amounts 税抜額リスト
     * @return 小計(Integer)
     */
    public static Subtotal calculateSubtotal(List<Integer> amounts) {
        if (amounts.size() == MIN_AMOUNTS_LIST_SIZE)
            throw new IllegalArgumentException("小計元の値が存在しません");

        Subtotal subtotal = new Subtotal(amounts.stream().mapToInt(Integer::intValue).sum());

        if (subtotal.getAmount() < MIN_SUBTOTAL) {
            throw new IllegalArgumentException("0より小さい小計は不適正です");
        }

        return subtotal;
    }
}
