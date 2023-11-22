package com.example.marketing.coupon.enums;

import lombok.Getter;

@Getter
public enum DiscountType {
    FIXED_AMOUNT("F", "정액 할인"), // 정액 할인
    PERCENTAGE("P", "비율 할인"); // 비율 할인

    private final String status;
    private final String description;

    DiscountType(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
