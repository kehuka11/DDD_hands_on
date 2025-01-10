package com.example.order.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class MerchantIdTest {
    private final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Test
    @DisplayName("正常系-加盟店IDを新規生成")
    public void 加盟店IDを新規生成() {
        MerchantId merchantId = MerchantId.newMerchantId();

        assertTrue(Pattern.matches(UUID_REGEX, merchantId.getId().toString()));
    }

    @Test
    @DisplayName("正常系-引数で指定した値を元にオブジェクト生成")
    public void 引数で指定した値を元にオブジェクト生成() {
        String id = "123e4567-e89b-12d3-a456-426614174000";
        MerchantId merchantId = MerchantId.toMerchantId(id);

        assertTrue(Objects.nonNull(merchantId.getId()));
    }

    @Test
    @DisplayName("異常系-指定したIDがUUIDに準拠していない")
    public void 指定したIDがUUIDに準拠していない() {
        String id = "123e4567";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MerchantId.toMerchantId(id)
        );

        assertEquals("指定したIDがUUIDに準拠してません", exception.getMessage());
    }
}
