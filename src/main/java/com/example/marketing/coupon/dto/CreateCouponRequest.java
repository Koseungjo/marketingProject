package com.example.marketing.coupon.dto;

import com.example.marketing.coupon.enums.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCouponRequest {
    private String name;
    private String code;
    private String description;
    private String discountType; // 예: "FIXED_AMOUNT" 또는 "PERCENTAGE"
    private Double discountValue;
    private LocalDate validityStart;
    private LocalDate validityEnd;
}
