package com.example.marketing.coupon.controller;

import com.example.marketing.coupon.dto.CouponListRequest;
import com.example.marketing.coupon.dto.CouponListResponse;
import com.example.marketing.coupon.dto.CreateCouponRequest;
import com.example.marketing.coupon.service.CouponCUDService;
import com.example.marketing.coupon.service.CouponReadService;
import com.example.marketing.global.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CouponApiController {

    private final CouponCUDService couponCUDService;
    private final CouponReadService couponReadService;

    //TODO: 쿠폰 생성
    @PostMapping("/coupon")
    public ResponseDTO createCoupon(CreateCouponRequest request){
        couponCUDService.createCoupon(request);
        return ResponseDTO.ok();
    }
    //TODO: 쿠폰 조회
    @GetMapping("/coupons")
    public ResponseDTO<CouponListResponse> getCouponList(@ModelAttribute CouponListRequest request){
        CouponListResponse response = couponReadService.getCouponList(request);
        return ResponseDTO.ok(response);
    }
}
