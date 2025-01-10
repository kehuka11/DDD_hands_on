package com.example.order.domain.value;

import com.example.order.infrastructure.common.validate.UuidValid;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MerchantId {

    private final UUID id;

    private MerchantId(UUID id) {
        this.id = id;
    }

    public static MerchantId newMerchantId() {
        return new MerchantId(UUID.randomUUID());
    }

    public static MerchantId toMerchantId(String id) {
        UUID uuid = null;

        try {
            uuid = UUID.fromString(UuidValid.isValid(id));
        } catch (Exception e) {
            throw new IllegalArgumentException("指定したIDがUUIDに準拠してません");
        }
        return new MerchantId(uuid);
    }
}
