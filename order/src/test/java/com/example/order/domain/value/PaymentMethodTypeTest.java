package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentMethodTypeTest {

    private final String CREDIT_CARD_ID = "01";
    private final String E_MONEY_ID = "02";

    private final String BANK_TRANSFER_ID = "03";

    @Test
    @DisplayName("正常-クレジットカードタイプ生成")
    public void クレジットカードタイプ生成() {
        PaymentMethodType paymentMethodType = PaymentMethodType.fromId(CREDIT_CARD_ID);

        assertEquals(PaymentMethodType.CREDIT_CARD, paymentMethodType);
    }

    @Test
    @DisplayName("正常-電子マネータイプ生成")
    public void 電子マネータイプ生成() {
        PaymentMethodType paymentMethodType = PaymentMethodType.fromId(E_MONEY_ID);

        assertEquals(PaymentMethodType.E_MONEY, paymentMethodType);
    }

    @Test
    @DisplayName("正常-銀行振込タイプ生成")
    public void 銀行振込タイプ生成() {
        PaymentMethodType paymentMethodType = PaymentMethodType.fromId(BANK_TRANSFER_ID);

        assertEquals(PaymentMethodType.BANK_TRANSFER, paymentMethodType);
    }

    @Test
    @DisplayName("異常-存在しない決済手段タイプ")
    public void 存在しない決済手段タイプ() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PaymentMethodType.fromId("99")
        );

        assertEquals("Invalid id: 99", exception.getMessage());
    }
}
