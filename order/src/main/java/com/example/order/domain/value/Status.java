package com.example.order.domain.value;

import lombok.Getter;

@Getter
public enum Status {
        UNORDERED("unordered", "未注文"),
        ORDERED("ordered", "注文済み"),
        DELIVERED("delivered", "配達済み");

        private final String identifier;
        private final String description;

        private Status(String identifier, String description) {
            this.identifier = identifier;
            this.description = description;
        }

        public static Status fromIdentifier(String identifier) {
            for(Status status : Status.values()) {
                if (status.identifier.equals(identifier)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid status: " + identifier);
        }


    }

