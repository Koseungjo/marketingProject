package com.example.marketing.customer.global;

import lombok.Getter;

@Getter
public enum CustomerStatus {

    ACTIVE("A", "사용"),
    IN_ACTIVE("C","차단");


    private final String status;
    private final String description;

    CustomerStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
