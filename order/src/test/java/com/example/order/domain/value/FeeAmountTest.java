package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FeeAmountTest {


    @Test
    @DisplayName("正常系-手数料が正しく計算される")
    public void 手数料が正しく計算() {
        Integer amount = 1000;
        BigDecimal feeRate = BigDecimal.valueOf(0.05); // 5%

        FeeAmount feeAmount = FeeAmount.calculateFeeAmount(amount, feeRate);

        assertEquals(50, feeAmount.getAmount());
    }

    @Test
    @DisplayName("正常系-手数料が0円")
    public void 手数料が0円() {
        Integer amount = 1000;
        BigDecimal feeRate = BigDecimal.valueOf(0);

        FeeAmount feeAmount = FeeAmount.calculateFeeAmount(amount, feeRate);

        assertEquals(0, feeAmount.getAmount());
    }

    @Test
    @DisplayName("正常系-小数点以下が切り捨てられる")
    public void 小数点以下が切り捨てられる() {
        Integer amount = 135;
        BigDecimal feeRate = BigDecimal.valueOf(0.05); // 5%

        FeeAmount feeAmount = FeeAmount.calculateFeeAmount(amount, feeRate);

        assertEquals(6, feeAmount.getAmount());
    }

    @Test
    @DisplayName("異常系-手数料がMIN_FEE_AMOUNTより小さい場合は例外をスロー")
    public void 手数料がMIN_FEE_AMOUNTより小さい場合は例外をスロー() {
        Integer amount = -1000;
        BigDecimal feeRate = BigDecimal.valueOf(0.05);

        RuntimeException exception = assertThrows(
                IllegalArgumentException.class,
                () -> FeeAmount.calculateFeeAmount(amount, feeRate)
        );

        assertEquals("手数料が最小値未満です", exception.getMessage());
    }

}
