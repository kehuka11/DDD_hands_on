package com.example.order.domain.value;

import com.example.order.infrastructure.common.validate.UuidValid;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

@Getter
public class OrderId {

    private final UUID id;


    private OrderId(UUID id) {
        this.id = id;
    }

    /**
     * オーダーID新規作成
     * @return OrderId
     */
    public static OrderId newOrderId() {
        return new OrderId(UUID.randomUUID());
    }

    /**
     * 既存IDを元にOrderId作成
     * @param id id
     * @return OrderId
     */

    public static OrderId toOrderId(String id) {
        UUID uuid = null;

        try {
            uuid = UUID.fromString(UuidValid.isValid(id));
        } catch (Exception e) {
            throw new IllegalArgumentException("指定したIDがUUIDに準拠してません");
        }

        return new OrderId(uuid);

    }

}
