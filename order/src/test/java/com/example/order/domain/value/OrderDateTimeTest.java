package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderDateTimeTest {

    @Test
    @DisplayName("正常-Nullでない")
    public void Nullでない() {
        OrderDateTime orderDateTime = new OrderDateTime();

        assertTrue(Objects.nonNull(orderDateTime.getDateTime()));
    }
}
