package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TotalAmountTest {

    @Test
    @DisplayName("正常-合計金額が計算される")
    public void 合計金額が計算される() {
        List<Integer> amounts = new ArrayList<>();
        amounts.add(1000);
        Subtotal subtotal = Subtotal.calculateSubtotal(amounts);

        Integer amount = 1000;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);

        TaxAmount taxAmount = TaxAmount.calculateTaxAmount(amount, feeRate);

        FeeAmount feeAmount = FeeAmount.calculateFeeAmount(amount, feeRate);

        TotalAmount totalAmount = TotalAmount.calculateTotalAmount(subtotal, taxAmount, feeAmount);

        assertEquals(1100, totalAmount.getAmount());
    }

    @Test
    @DisplayName("異常-SubtotalがNULL")
    public void SubtotalがNULL() {

        Integer amount = 0;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);

        TaxAmount taxAmount = TaxAmount.calculateTaxAmount(amount, feeRate);

        FeeAmount feeAmount = FeeAmount.calculateFeeAmount(amount, feeRate);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TotalAmount.calculateTotalAmount(null, taxAmount, feeAmount)
        );


        assertEquals("Nullは許容されません", exception.getMessage());
    }

    @Test
    @DisplayName("異常-TaxAmountがNULL")
    public void TaxAmountがNULL() {
        List<Integer> amounts = new ArrayList<>();
        amounts.add(1000);
        Subtotal subtotal = Subtotal.calculateSubtotal(amounts);

        Integer amount = 0;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);


        FeeAmount feeAmount = FeeAmount.calculateFeeAmount(amount, feeRate);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TotalAmount.calculateTotalAmount(subtotal, null, feeAmount)
        );


        assertEquals("Nullは許容されません", exception.getMessage());
    }


    @Test
    @DisplayName("正常-FeeAmountがNULL")
    public void FeeAmountがNULL() {
        List<Integer> amounts = new ArrayList<>();
        amounts.add(1000);
        Subtotal subtotal = Subtotal.calculateSubtotal(amounts);

        Integer amount = 0;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);

        TaxAmount taxAmount = TaxAmount.calculateTaxAmount(amount, feeRate);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TotalAmount.calculateTotalAmount(subtotal, taxAmount, null)
        );


        assertEquals("Nullは許容されません", exception.getMessage());
    }

}
