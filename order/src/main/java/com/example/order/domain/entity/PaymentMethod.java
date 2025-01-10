package com.example.order.domain.entity;

import com.example.order.domain.value.PaymentMethodType;
import lombok.Getter;

import java.util.Objects;

@Getter
public class PaymentMethod {
    private final PaymentMethodType paymentMethodType;

    private PaymentMethod(PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public PaymentMethod newPaymentMethod(String paymentMethodId) {
        if (Objects.isNull(paymentMethodId)) {
            throw  new RuntimeException("error");
        }

        return new PaymentMethod(
                PaymentMethodType.fromId(paymentMethodId)
        );
    }
}
