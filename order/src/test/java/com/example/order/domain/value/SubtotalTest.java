package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubtotalTest {

    @Test
    @DisplayName("正常-小計計算される")
    public void 小計計算される() {
        List<Integer> amounts = new ArrayList<>();
        amounts.add(1000);
        amounts.add(1000);

        Subtotal subtotal = Subtotal.calculateSubtotal(amounts);

        assertEquals(2000, subtotal.getAmount());
    }

    @Test
    @DisplayName("異常-小計元の値が存在しない")
    public void 小計元の値が存在しない() {
        List<Integer> amounts = new ArrayList<>();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Subtotal.calculateSubtotal(amounts)
        );


        assertEquals("小計元の値が存在しません", exception.getMessage());
    }

    @Test
    @DisplayName("異常-小計がマイナス")
    public void 小計がマイナス() {
        List<Integer> amounts = new ArrayList<>();
        amounts.add(-1000);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Subtotal.calculateSubtotal(amounts)
        );


        assertEquals("0より小さい小計は不適正です", exception.getMessage());
    }
}
