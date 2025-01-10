package com.example.order.infrastructure.common.validate;

import java.util.Objects;
import java.util.regex.Pattern;

public class UuidValid {
    private static final String UUID_REGEX =
            "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);

    public static String isValid(String id) {
        if (Objects.isNull(id) || !UUID_PATTERN.matcher(id).matches()) {
            throw new RuntimeException("error");
        }

        return id;
    }
}
