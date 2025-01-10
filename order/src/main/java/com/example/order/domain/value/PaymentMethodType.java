package com.example.order.domain.value;

import lombok.Getter;

@Getter
public enum PaymentMethodType {
    CREDIT_CARD("01", "クレジットカード"),
    E_MONEY("02", "電子マネー"),
    BANK_TRANSFER("03", "銀行振込");

    private final String id;
    private final String identifier;

    private PaymentMethodType(String id, String identifier) {
        this.id = id;
        this.identifier = identifier;
    }

    public static PaymentMethodType fromId(String id) {
        for (PaymentMethodType type : PaymentMethodType.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid id: " + id);
    }
}
