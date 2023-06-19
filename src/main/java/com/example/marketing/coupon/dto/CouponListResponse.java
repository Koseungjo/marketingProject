package com.example.marketing.coupon.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CouponListResponse {

    private List<CouponResponse> couponResponse;

    private CouponListResponse(List<CouponResponse> responses){
        this.couponResponse = responses;
    }

    public static CouponListResponse of(List<CouponResponse> responses){
        return new CouponListResponse(responses);
    }
}
