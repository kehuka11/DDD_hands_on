package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatusTest {

    private final String UNORDERED = "unordered";
    private final String ORDERED = "ordered";
    private final String DELIVERED = "delivered";

    @Test
    @DisplayName("正常-未注文状態を生成")
    public void 未注文状態を生成() {
        Status status = Status.fromIdentifier(UNORDERED);

        assertEquals(Status.UNORDERED, status);
    }

    @Test
    @DisplayName("正常-注文済み状態を生成")
    public void 注文済み状態を生成() {
        Status status = Status.fromIdentifier(ORDERED);

        assertEquals(Status.ORDERED, status);
    }

    @Test
    @DisplayName("正常-配達済み状態を生成")
    public void 配達済み状態を生成() {
        Status status = Status.fromIdentifier(DELIVERED);

        assertEquals(Status.DELIVERED, status);
    }

    @Test
    @DisplayName("異常-存在しない状態を生成")
    public void 存在しない状態を生成() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Status.fromIdentifier("unknown")
        );

        assertEquals("Invalid status: unknown", exception.getMessage());
    }
}
