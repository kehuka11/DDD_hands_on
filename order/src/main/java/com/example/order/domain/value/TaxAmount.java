package com.example.order.domain.value;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class TaxAmount {

    private static final int MIN_TAX_AMOUNT = 0;

    private final Integer amount;

    private TaxAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 消費税額計算
     * @param amount 税抜金額
     * @param taxRate 消費税率
     * @return 税込金額(Integer)
     */
    public static TaxAmount calculateTaxAmount(Integer amount, BigDecimal taxRate) {
        BigDecimal amountDecimalTransfer = BigDecimal.valueOf(amount);
        BigDecimal result = amountDecimalTransfer.multiply(taxRate);
        int taxAmount = result.setScale(0, RoundingMode.DOWN).intValue();
        if (taxAmount < MIN_TAX_AMOUNT) throw new IllegalArgumentException("消費税額が不正です");
        return new TaxAmount(taxAmount);
    }
}
