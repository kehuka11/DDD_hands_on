package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityTest {

    @Test
    @DisplayName("正常-インスタンス生成")
    public void インスタンス生成() {
        Quantity quantity = new Quantity(1);

        assertEquals(1, quantity.getValue());
    }

    @Test
    @DisplayName("異常-MIN_QUANTITY_SIZEより小さい")
    public void MIN_QUANTITY_SIZEより小さい() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity(-1)
        );

        assertEquals("0以上を指定してください", exception.getMessage());
    }
}
