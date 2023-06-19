package com.example.marketing.coupon.dto;

import com.example.marketing.coupon.entity.Coupon;
import com.example.marketing.customer.dto.CustomerResponse;
import com.example.marketing.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponResponse {
    private Long customerId;
    private String customerName;
    private String couponName;
    private String couponStatus;
    private LocalDate expirationDate;

    public CouponResponse(Coupon coupon) {
        this.customerId = coupon.getCustomer().getCustomerId();
        this.customerName = coupon.getCustomer().getCustomerName();
        this.couponName = coupon.getCouponName();
        this.couponStatus = coupon.getStatus();
        this.expirationDate = coupon.getExpirationDate();
    }

    public static CouponResponse of(Coupon coupon){
        return new CouponResponse(coupon);
    }
}
