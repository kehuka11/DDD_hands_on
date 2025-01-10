package com.example.order.domain.value;

import lombok.Getter;

import java.util.Objects;

@Getter
public class TotalAmount {

    private final Integer amount;

    private final Subtotal subtotal;

    private final TaxAmount taxAmount;

    private final FeeAmount feeAmount;

    private TotalAmount(Integer amount, Subtotal subtotal, TaxAmount taxAmount, FeeAmount feeAmount) {
        this.amount = amount;
        this.subtotal = subtotal;
        this.taxAmount = taxAmount;
        this.feeAmount = feeAmount;
    }

    public static TotalAmount calculateTotalAmount(Subtotal subtotal, TaxAmount taxAmount, FeeAmount feeAmount) {
        if (Objects.isNull(subtotal) || Objects.isNull(taxAmount) || Objects.isNull(feeAmount))
            throw new IllegalArgumentException("Nullは許容されません");

        return new TotalAmount(
                subtotal.getAmount() + taxAmount.getAmount() + feeAmount.getAmount(),
                subtotal,
                taxAmount,
                feeAmount
        );
    }
}
