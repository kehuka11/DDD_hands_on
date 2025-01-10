package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaxAmountTest {

    @Test
    @DisplayName("正常-消費税額が計算される")
    public void 消費税額が計算される() {
        Integer amount = 1000;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);

        TaxAmount taxAmount = TaxAmount.calculateTaxAmount(amount, feeRate );

        assertEquals(50, taxAmount.getAmount());
    }

    @Test
    @DisplayName("正常系-消費税が0円")
    public void 消費税が0円() {
        Integer amount = 0;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);

        TaxAmount taxAmount = TaxAmount.calculateTaxAmount(amount, feeRate);

        assertEquals(0, taxAmount.getAmount());
    }

    @Test
    @DisplayName("正常系-小数点以下が切り捨てられる")
    public void 小数点以下が切り捨てられる() {
        Integer amount = 135;
        BigDecimal feeRate = BigDecimal.valueOf(0.05); // 5%

        TaxAmount taxAmount = TaxAmount.calculateTaxAmount(amount, feeRate);

        assertEquals(6, taxAmount.getAmount());
    }

    @Test
    @DisplayName("異常系-消費税がMIN_TAX_AMOUNTより小さい場合は例外をスロー")
    public void 消費税がMIN_TAX_AMOUNTより小さい場合は例外をスロー() {
        Integer amount = -1000;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TaxAmount.calculateTaxAmount(amount, feeRate)
        );

        assertEquals("消費税額が不正です", exception.getMessage());
    }
}
