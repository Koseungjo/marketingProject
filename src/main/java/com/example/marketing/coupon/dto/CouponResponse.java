package com.example.marketing.coupon.dto;

import com.example.marketing.coupon.entity.Coupon;
import com.example.marketing.customer.dto.CustomerResponse;
import com.example.marketing.customer.entity.Customer;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponResponse {
    private Long id;
    private String name;
    private String code;
    private String description;
    private String discountType;
    private Double discountValue;
    private LocalDate validityStart; // 날짜 필드 (시간대 정보 없음)
    private LocalDate validityEnd;
    private LocalDate createdDate;
    private LocalDate updateDate;

    public CouponResponse(Coupon coupon) {
        this.id = coupon.getCouponId();
        this.name = coupon.getName();
        this.code = coupon.getCode();
        this.description = coupon.getDescription();
        this.discountType = coupon.getDiscountType();
        this.discountValue = coupon.getDiscountValue();
        this.validityStart = coupon.getValidityStart();
        this.validityEnd = coupon.getValidityEnd();
        this.createdDate = coupon.getCreatedDate();
        this.updateDate = coupon.getUpdateDate();
    }

    public static CouponResponse from(Coupon coupon){
        return new CouponResponse(coupon);
    }
}
