package com.example.order.domain.value;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class FeeAmount {

    private static final int MIN_FEE_AMOUNT = 0;

    private final Integer amount;

    private FeeAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 手数料計算
     * @param amount 税抜金額
     * @param feeRate 手数料率
     * @return 手数料(Integer)
     */
    public static FeeAmount calculateFeeAmount(Integer amount, BigDecimal feeRate) {
        BigDecimal amountDecimalTransfer = BigDecimal.valueOf(amount);
        BigDecimal result = amountDecimalTransfer.multiply(feeRate);
        int feeAmount = result.setScale(0, RoundingMode.DOWN).intValue();

        if (feeAmount < MIN_FEE_AMOUNT) {
            throw new IllegalArgumentException("手数料が最小値未満です");

        }
        return  new FeeAmount(feeAmount);
    }
}
