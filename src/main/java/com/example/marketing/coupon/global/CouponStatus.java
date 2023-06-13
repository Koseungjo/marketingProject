package com.example.marketing.coupon.global;

import lombok.Getter;

@Getter
public enum CouponStatus {

    ACTIVE("A", "사용"),
    IN_ACTIVE("I","미사용");


    private final String status;
    private final String description;

    CouponStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
