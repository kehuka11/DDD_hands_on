package com.example.order.domain.value;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class OrderDateTime {

    private final LocalDateTime dateTime;

    public OrderDateTime() {
            this.dateTime = LocalDateTime.now();
    }
}
