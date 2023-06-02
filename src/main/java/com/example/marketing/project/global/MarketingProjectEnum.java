package com.example.marketing.project.global;

import lombok.Getter;

@Getter
public enum MarketingProjectEnum {
    WAITING("W","대기"),
    IN_PROGRESS("I","진행중"),
    COMPLETED("C","종료");


    private final String status;
    private final String description;

    MarketingProjectEnum(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
