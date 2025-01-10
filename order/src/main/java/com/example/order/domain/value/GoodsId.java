package com.example.order.domain.value;

import com.example.order.infrastructure.common.validate.UuidValid;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GoodsId {
    UUID id;

    private GoodsId(UUID id) {
        this.id = id;
    }

    public static GoodsId newGoodsId() {
        return new GoodsId(UUID.randomUUID());
    }

    public static GoodsId toGoodsId(String id) {
        UUID uuid = null;

        try {
            uuid = UUID.fromString(UuidValid.isValid(id));
        } catch (Exception e) {
            throw new IllegalArgumentException("指定したIDがUUIDに準拠してません");
        }

        return new GoodsId(uuid);
    }
}
